package org.example.visitor;

public class PrintVisitorList implements PrintVisitor {
    @Override
    public String print(L x) {
        return x.acceptPrint(this);
    }
    @Override
    public String print(Nil x) {
        return "";
    }

    @Override
    public String print(Cons x) {
        return x.head + "," + x.tail.acceptPrint(this);
    }
}
