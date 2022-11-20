class MidtermVisitor implements Visitor{
	public Object visit(Exp e) {
		return e.accept(this);
	}

	public Object visit(RNum e){
		return e;
	}

	public Object visit(X e){
		return e;
	}

	public Object visit(Times e){
		Object x = e.e1.accept(this);
		Object y = e.e2.accept(this);
		if (x instanceof X && y instanceof X) {
			int xNumerator = 1;
			int xDenominator = 1;
			int yNumerator = 1;
			int yDenominator = 1;

			int rNumerator = xNumerator * yDenominator + xDenominator * yNumerator;
			int rDenominator = xDenominator * yDenominator;

			return new RNum(rNumerator + "/" + rDenominator);

		}
		else{
			int xNumerator;
			int xDenominator;
			int yNumerator;
			int yDenominator;

			if(x instanceof X){
				xNumerator = 1;
				xDenominator = 1;
			}
			else{
				xNumerator = ((RNum)x).numerator;
				xDenominator = ((RNum)x).denominator;
			}
			if(y instanceof X){
				yNumerator = 1;
				yDenominator = 1;
			}
			else{
				yNumerator = ((RNum)y).numerator;
				yDenominator = ((RNum)y).denominator;
			}

			int rNumerator = xNumerator * yDenominator + xDenominator * yNumerator;
			int rDenominator = xDenominator * yDenominator;

			return new RNum(rNumerator + "/" + rDenominator);
		}
		
	}

	public Object visit(Divide e){
		Object x = e.e1.accept(this);
		Object y = e.e2.accept(this);
		if (x instanceof X && y instanceof X) {
			int xNumerator = 1;
			int xDenominator = 1;
			int yNumerator = 1;
			int yDenominator = 1;

			int rNumerator = xNumerator * yDenominator - xDenominator * yNumerator;
			int rDenominator = xDenominator * yDenominator;

			return new RNum(rNumerator + "/" + rDenominator);

		}
		else{
			int xNumerator;
			int xDenominator;
			int yNumerator;
			int yDenominator;

			if(x instanceof X){
				xNumerator = 1;
				xDenominator = 1;
			}
			else{
				xNumerator = ((RNum)x).numerator;
				xDenominator = ((RNum)x).denominator;
			}
			if(y instanceof X){
				yNumerator = 1;
				yDenominator = 1;
			}
			else{
				yNumerator = ((RNum)y).numerator;
				yDenominator = ((RNum)y).denominator;
			}

			int rNumerator = xNumerator * yDenominator - xDenominator * yNumerator;
			int rDenominator = xDenominator * yDenominator;

			return new RNum(rNumerator + "/" + rDenominator);
		}
	}


	public Object visit(Power e){
		Object x = e.e1.accept(this);
		Object y = e.e2.accept(this);

		int xNumerator;
			int xDenominator;
			int yNumerator;
			int yDenominator;

			if(x instanceof X){
				xNumerator = 1;
				xDenominator = 1;
			}
			else{
				xNumerator = ((RNum)x).numerator;
				xDenominator = ((RNum)x).denominator;
			}
			if(y instanceof X){
				yNumerator = 1;
				yDenominator = 1;
			}
			else{
				yNumerator = ((RNum)y).numerator;
				yDenominator = ((RNum)y).denominator;
			}

			int rNumerator = xNumerator * yNumerator;
			int rDenominator = xDenominator * yDenominator;

			return new RNum(rNumerator + "/" + rDenominator);
	}
	
}