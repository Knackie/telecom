package com.company.nodes;

import com.company.nodes.exceptions.SemanticException;
import org.antlr.runtime.tree.BaseTree;

public class ExprBool extends Expr {

    public String comparateur;

    public Expr membreDroit;

    public Expr membreGauche;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        this.comparateur =  t.toString();
        this.membreGauche = Expr.expr_return((BaseTree) t.getChild(0));
        membreGauche.tds = tds;
        this.membreGauche.browseTree((BaseTree) t.getChild(0));
        this.membreDroit = Expr.expr_return((BaseTree) t.getChild(1));
        membreDroit.tds = tds;
        this.membreDroit.browseTree((BaseTree) t.getChild(1));
    }

    @Override
    public String translate() {
        return membreGauche.translate() + comparateur + membreDroit.translate();
    }

    @Override
    public void checkSemantique() throws Exception {
        if(!this.membreGauche.isInt()) {
            throw new SemanticException(this.membreGauche.toString() + " is not comparable with " + this.comparateur +" line "+line);
        }
        if(!this.membreDroit.isInt()) {
            throw new SemanticException(this.membreDroit.toString() + " is not comparable with " + this.comparateur +" line "+line);
        }
        this.membreDroit.checkSemantique();
        this.membreGauche.checkSemantique();
    }

    @Override
    public boolean isBol() {
        return true;
    }
}
