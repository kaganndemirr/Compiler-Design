package org.example;

import org.example.visitor.PrintVisitorList;
import org.example.visitor.SumVisitorList;

public class Main {
    public static void main(String[] args) {

        // {2, -4, 6, 9}
        org.example.eval.L listEval = new org.example.eval.Cons(2, new org.example.eval.Cons(-4, new org.example.eval.Cons(6, new org.example.eval.Cons(9, new org.example.eval.Nil()))));
        int a = new Main().eval(listEval);
        System.out.println("eval a: " + a);

        String s = new Main().print(listEval);
        System.out.println("{" + s.substring(0, s.length() - 1) + "}");

        org.example.dedicated.L listDedicated = new org.example.dedicated.Cons(2, new org.example.dedicated.Cons(-4, new org.example.dedicated.Cons(6, new org.example.dedicated.Cons(9, new org.example.dedicated.Nil()))));
        int b = listDedicated.eval();
        System.out.println("dedicated a: " + b);
        System.out.println("{" + listDedicated.print().substring(0, listDedicated.print().length() - 1) + "}");

        org.example.visitor.L listVisitor = new org.example.visitor.Cons(2, new org.example.visitor.Cons(-4, new org.example.visitor.Cons(6, new org.example.visitor.Cons(9, new org.example.visitor.Nil()))));
        int c = new SumVisitorList().sum(listVisitor);
        System.out.println("visitor c: " + c);

        String listVisitorString = new PrintVisitorList().print(listVisitor);
        System.out.println("{" + listVisitorString.substring(0, listVisitorString.length() - 1) + "}");
    }

    public int eval(org.example.eval.L x){
        if (x instanceof org.example.eval.Nil){
            return 0;
        }
        else{
            return ((org.example.eval.Cons)x).head + eval(((org.example.eval.Cons)x).tail);
        }
    }
    public String print(org.example.eval.L x){
        if (x instanceof org.example.eval.Nil){
            return "";
        }
        else{
            return ((org.example.eval.Cons)x).head + "," + print(((org.example.eval.Cons)x).tail);
        }
    }
}