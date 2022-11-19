class MidtermVisitor implements Visitor{
	public Object visit(Exp e) {
		return e.accept(this);
	}

	public Object visit(RNum e){
		return e;
	}

	public Object visit(X e){
		return e.id;
	}

	public Object visit(Times e){
		Object x = e.e1.accept(this);
		Object y = e.e2.accept(this);
		int n1 = ((RNum)x).numerator;
		int d1 = ((RNum)x).denominator;
		int n2 = ((RNum)y).numerator;
		int d2 = ((RNum)y).denominator;

		if (d1 == 1){
			int n3 = d2 * 1 + n2;
			int d3 = d2;
			return new RNum(n3 + "/" + d3);
		}
		if (d2 == 1){
			int n3 = d1 * 1 + n1;
			int d3 = d1;
			return new RNum(n3 + "/" + d3);
		}
		else{
			int n3 = n1 * d2 + d1 * n2;
			int d3 = d1 * d2;
			return new RNum(n3 + "/" + d3);
		}
	}

	public Object visit(Divide e){
		Object x = e.e1.accept(this);
		Object y = e.e2.accept(this);
		int n1 = ((RNum)x).numerator;
		int d1 = ((RNum)x).denominator;
		int n2 = ((RNum)y).numerator;
		int d2 = ((RNum)y).denominator;

		if (d1 == 1){
			int n3 = d2 * 1 - n2;
			int d3 = d2;
			return new RNum(n3 + "/" + d3);
		}
		if (d2 == 1){
			int n3 = d1 * 1 - n1;
			int d3 = d1;
			return new RNum(n3 + "/" + d3);
		}
		else{
			int n3 = n1 * d2 - d1 * n2;
			int d3 = d1 * d2;
			return new RNum(n3 + "/" + d3);
		}
	}


	public Object visit(Power e){
		Object y = e.e2.accept(this);
		int n1 = ((RNum)y).numerator;
		int d1 = ((RNum)y).denominator;
		return new Power(e.e1, new RNum(n1 + "/" + d1));
	}
	
}