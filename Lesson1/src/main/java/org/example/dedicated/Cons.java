package org.example.dedicated;

public class Cons extends L{
    int head;
    L tail;
    public Cons(int a, L b) {
        head = a;
        tail = b;
    }
    @Override
    public int eval() {
        return head + tail.eval();
    }
    @Override
    public String print(){
            return head + "," + tail.print();
    }
}
