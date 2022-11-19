interface Visitor {
    public Object visit(Exp e);
    public Object visit(RNum e);
    public Object visit(Times e);
    public Object visit(Divide e);
    public Object visit(Power e);
}