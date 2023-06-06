package com.company.nodes;

import org.antlr.runtime.tree.BaseTree;

public class CsteStr extends Expr {
    public String valeur;

    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        BaseTree fils;
        fils = (BaseTree) t.getChild(0);
        this.valeur = fils.toString();
    }

    @Override
    public String translate() {
        return valeur;
    }

    @Override
    public boolean isStr() {
        return true;
    }

    @Override
    public void checkSemantique() throws Exception {
    }

}
