package org.example.visitor;

public interface PrintVisitor {
    String print(L x);
    String print(Nil x);
    String print(Cons x);
}
