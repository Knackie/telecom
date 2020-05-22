package com.company.nodes;

import org.antlr.runtime.tree.BaseTree;

public class InstrReturn extends Instruction {

    public Expr expr;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        if(t.getChildCount()>0) {
            this.expr = Expr.expr_return((BaseTree) (t.getChild(0)));
            expr.tds = tds;
            expr.browseTree((BaseTree) (t.getChild(0)));
        } else {
            this.expr = null;
        }
    }

    @Override
    public String translate() {
        StringBuilder res = new StringBuilder("return ");
        if(this.expr != null) {
            res.append(expr.translate());
        }
        return res.append(" ;\n").toString();
    }

    @Override
    public void checkSemantique() throws Exception {
        if(this.expr != null) {
            this.expr.checkSemantique();
        }
    }

}
