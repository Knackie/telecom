package com.company.nodes;

import com.company.Node;
import com.company.nodes.exceptions.SemanticException;
import org.antlr.runtime.tree.BaseTree;

public class WhileCond extends Node {

    public Expr expr;


    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        this.expr = Expr.expr_return((BaseTree) (t.getChild(0)));
        expr.tds = tds;
        expr.browseTree((BaseTree) (t.getChild(0)));
    }

    @Override
    public String translate() {
        StringBuilder res = new StringBuilder("(");
        res.append(expr.translate());
        res.append(")\n");
        return res.toString();
    }

    @Override
    public void checkSemantique() throws Exception {
        if (! expr.isBol()){
            throw new SemanticException("Condition is not a boolean expression line " + line);
        }
        expr.checkSemantique();
    }

}
