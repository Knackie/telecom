package com.company.nodes;

import com.company.nodes.exceptions.SemanticException;
import org.antlr.runtime.tree.BaseTree;

public class ExprNot extends Expr {

    public String comparateur;

    public Expr membreDroit;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        this.comparateur =  t.toString();
        this.membreDroit = Expr.expr_return((BaseTree) t.getChild(0));
        membreDroit.tds = tds;
        this.membreDroit.browseTree((BaseTree) t.getChild(0));
    }

    @Override
    public String translate() {
        return "! ("+this.membreDroit.translate() +")";
    }

    @Override
    public void checkSemantique() throws Exception {
        if(!this.membreDroit.isBol()){
            throw new SemanticException(this.membreDroit.toString() + " is not a boolean expression line " + line);
        }
        this.membreDroit.checkSemantique();
    }

    @Override
    public boolean isBol() {
        return true;
    }
}
