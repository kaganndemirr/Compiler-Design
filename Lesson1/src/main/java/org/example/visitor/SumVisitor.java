package org.example.visitor;

interface SumVisitor {
    int sum(L x);
    int sum(Nil x);
    int sum(Cons x);



}
