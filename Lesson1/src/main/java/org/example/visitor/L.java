package org.example.visitor;

public abstract class L {
    public abstract int acceptSum(SumVisitor v);
    public abstract String acceptPrint(PrintVisitor v);
}
