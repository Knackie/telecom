package com.company.nodes;

import org.antlr.runtime.tree.BaseTree;

public class InstrWrite extends Instruction {
    public Expr expr;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        BaseTree fils = (BaseTree) t.getChild(0);
        this.expr = Expr.expr_return(fils);
        expr.tds = tds;
        this.expr.browseTree((BaseTree) t.getChild(0));
    }

    @Override
    public String translate() {
        String val ="";
        if (expr.isBol() || expr.isInt() )
            val = "\"%d\\n\",";
        if (expr.isStr())
            val = "\"%s\\n\",";

        return new StringBuilder().append("printf(").append(val).append(expr.translate()).append(")").toString() + ";\n";
    }

    @Override
    public void checkSemantique() throws Exception {
        expr.checkSemantique();
    }
}
