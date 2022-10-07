package org.example.visitor;

public class Nil extends L{
    @Override
    public int acceptSum(SumVisitor v) {
        return v.sum(this);
    }

    @Override
    public String acceptPrint(PrintVisitor v) {
        return v.print(this);
    }
}
