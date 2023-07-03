package com.company.nodes;

import com.company.nodes.exceptions.SemanticException;
import org.antlr.runtime.tree.BaseTree;

public class CsteBooleen extends Expr {
    public boolean valeur;

    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        BaseTree fils;
        String res;
        fils = (BaseTree) t.getChild(0);
        res = fils.toString().toUpperCase();
        if( res.equals("TRUE")){
            this.valeur = true;
        } else {
            if( res.equals("FALSE")){
                this.valeur = false;
            } else {
                throw new SemanticException(fils.toString() + " is not a boolean expression line " + fils.getLine());
            }
        }
    }

    @Override
    public String translate() {return Boolean.toString(valeur);}

    @Override
    public boolean isBol() {
        return true;
    }

    @Override
    public void checkSemantique() throws Exception {
    }

}
