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
		int xNumerator;
		int xDenominator;
		if (x instanceof X){
			xNumerator = 1;
			xDenominator = 1;
			System.out.println("Inside Times, x instanceof X, " + xNumerator + "/" + xDenominator);
		}
		else{
			xNumerator = ((RNum)x).numerator;
			xDenominator = ((RNum)x).denominator;
			System.out.println("Inside Times, x !instanceof X, " + xNumerator + "/" + xDenominator);
		}

		Object y = e.e2.accept(this);
		int yNumerator;
		int yDenominator;
		if (y instanceof X){
			yNumerator = 1;
			yDenominator = 1;
			System.out.println("Inside Times, y instanceof X, " + yNumerator + "/" + yDenominator);
		}
		else{
			yNumerator = ((RNum)y).numerator;
			yDenominator = ((RNum)y).denominator;
			System.out.println("Inside Times, y !instanceof X, " + yNumerator + "/" + yDenominator);
		}

		int rNumerator = xNumerator * yDenominator + xDenominator * yNumerator;
		int rDenominator = xDenominator * yDenominator;

		
		if(x instanceof X || y instanceof X){
			RNum rNum = new RNum("");
			rNum.numerator = rNumerator;
			rNum.denominator = rDenominator;
			System.out.println("Inside Times, x or y instanceof X, " + rNum.numerator + "/" + rNum.denominator);
			return rNum;
		}
		else{
			((RNum)y).numerator = rNumerator;
			((RNum)y).denominator = rDenominator;
			System.out.println("Inside Times, none of them instanceof X, " + ((RNum)y).numerator + "/" + ((RNum)y).denominator);
			return y;
		}
		
	}

	public Object visit(Divide e){
		Object x = e.e1.accept(this);
		int xNumerator;
		int xDenominator;
		if (x instanceof X){
			xNumerator = 1;
			xDenominator = 1;
			System.out.println("Inside Divide, x instanceof X, " + xNumerator + "/" + xDenominator);
		}
		else{
			xNumerator = ((RNum)x).numerator;
			xDenominator = ((RNum)x).denominator;
			System.out.println("Inside Divide, x !instanceof X, " + xNumerator + "/" + xDenominator);
		}

		Object y = e.e2.accept(this);
		int yNumerator;
		int yDenominator;
		if (y instanceof X){
			yNumerator = 1;
			yDenominator = 1;
			System.out.println("Inside Divide, y instanceof X, " + yNumerator + "/" + yDenominator);
		}
		else{
			yNumerator = ((RNum)y).numerator;
			yDenominator = ((RNum)y).denominator;
			System.out.println("Inside Divide, y !instanceof X, " + yNumerator + "/" + yDenominator);
		}

		int rNumerator = xNumerator * yDenominator - xDenominator * yNumerator;
		int rDenominator = xDenominator * yDenominator;

		
		if(x instanceof X || y instanceof X){
			RNum rNum = new RNum("");
			rNum.numerator = rNumerator;
			rNum.denominator = rDenominator;
			System.out.println("Inside Divide, x or y instanceof X, " + rNum.numerator + "/" + rNum.denominator);
			return rNum;
		}
		else{
			((RNum)y).numerator = rNumerator;
			((RNum)y).denominator = rDenominator;
			System.out.println("Inside Divide, none of them instanceof X, " + ((RNum)y).numerator + "/" + ((RNum)y).denominator);
			return y;
		}
	}


	public Object visit(Power e){
		if(e.e1.accept(this) instanceof X){
			System.out.println("Inside Power, e1 instanceof X, returned e2");
			return e.e2.accept(this);
		}
		else{
			System.out.println("Inside Power, e1 !instanceof X");
			Object x = e.e1.accept(this);
			int xNumerator = ((RNum)x).numerator;
			int xDenominator = ((RNum)x).denominator;

			System.out.println("Inside Power, e1 = " + xNumerator + "/" + xDenominator);

			Object y = e.e2.accept(this);
			int yNumerator = ((RNum)y).numerator;
			int yDenominator = ((RNum)y).denominator;

			System.out.println("Inside Power, e2 = " + " = " + yNumerator + "/" + yDenominator);

			int rNumerator = xNumerator * yNumerator;
			int rDenominator = xDenominator * yDenominator;

			System.out.println("Inside Power, Powered : " + rNumerator + "/" + rDenominator);

			((RNum)y).numerator = rNumerator;
			((RNum)y).denominator = rDenominator;

			return y;
		}
	}
	
}