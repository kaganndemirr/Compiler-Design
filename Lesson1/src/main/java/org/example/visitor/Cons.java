package org.example.visitor;

public class Cons extends L {
    int head;
    L tail;
    public Cons(int a, L b) {
        head=a;
        tail=b;
    }
    @Override
    public int acceptSum(SumVisitor v) {
        return v.sum(this);
    }

    @Override
    public String acceptPrint(PrintVisitor v) {
        return v.print(this);
    }
}
