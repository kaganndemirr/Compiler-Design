package org.example.visitor;

public class SumVisitorList implements SumVisitor {
    @Override
    public int sum(L x) {
        return x.acceptSum(this);
    }
    @Override
    public int sum(Nil x) {
        return 0;
    }
    @Override
    public int sum(Cons x) {
        return x.head + x.tail.acceptSum(this);
    }
}
