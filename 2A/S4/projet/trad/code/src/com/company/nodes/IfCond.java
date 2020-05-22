package com.company.nodes;

import com.company.Node;
import com.company.nodes.exceptions.SemanticException;
import org.antlr.runtime.tree.BaseTree;

public class IfCond extends Node {
    public Expr expr;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        BaseTree expr = (BaseTree) t.getChild(0);
        this.expr = Expr.expr_return(expr);
        this.expr.tds = tds;
        this.expr.browseTree(expr);
    }

    @Override
    public String translate() {
        return  expr.translate() ;
    }

    @Override
    public void checkSemantique() throws Exception {
        if(!this.expr.isBol()){
            throw new SemanticException("If condition must be a boolean expression line " +line);
        }
        this.expr.checkSemantique();
    }
}
