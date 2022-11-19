abstract class Exp{
	public abstract void accept(Visitor v);
}

class RNum extends Exp{
	int numerator;
	int denominator;
	public RNum(String number){
		if(number.length() != 1){
			numerator = Integer.parseInt(String.valueOf(number.charAt(0)));
			denominator = Integer.parseInt(String.valueOf(number.charAt(2)));
		}
		else{
			numerator =Integer.parseInt(String.valueOf(number.charAt(0)));
			denominator = 1;
		}
	}
	public String toString(){
		if(denominator == 1){
			return "RNum(" + numerator + ")";
		}
		else{
			return "RNum("+ numerator + "/" + denominator +")";
		}
	}
	public void accept(Visitor v){
		v.visit(this);
	}
}


class X extends Exp{
	String id;
	public X(String id){
		this.id = id;
	}
	public String toString(){
		return "X(" + id + ")";
	}
	public void accept(Visitor v){
		v.visit(this);
	}
}


class Times extends Exp{
	Exp e1,e2;
	public Times(Exp e1, Exp e2){
		this.e1 = e1;
		this.e2 = e2;
	}
	public String toString(){
		return "Times(" + e1 + "," + e2 +")";
	}
	public void accept(Visitor v){
		v.visit(this);
	}
}

class Divide extends Exp{
	Exp e1,e2;
	public Divide(Exp e1, Exp e2){
		this.e1 = e1;
		this.e2 = e2;
	}
	public String toString(){
		return "Divide(" + e1 + "," + e2 +")";
	}
	public void accept(Visitor v){
		v.visit(this);
	}
}

class Power extends Exp{
	Exp e1,e2;
	public Power(Exp e1, Exp e2){
		this.e1 = e1;
		this.e2 = e2;
	}
	public String toString(){
		return "Power(" + e1 + "," + e2 +")";
	}
	public void accept(Visitor v){
		v.visit(this);
	}
}