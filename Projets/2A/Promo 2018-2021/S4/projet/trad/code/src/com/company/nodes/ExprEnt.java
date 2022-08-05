package com.company.nodes;

import com.company.nodes.exceptions.SemanticException;
import org.antlr.runtime.tree.BaseTree;

public class ExprEnt extends Expr {
    public String operateur;

    public Expr membreDroit;

    public Expr membreGauche;

    @Override
    public void browseTree(BaseTree t) throws Exception {
        super.browseTree(t);
        this.operateur = t.toString();
        this.membreGauche = Expr.expr_return((BaseTree) t.getChild(0));
        membreGauche.tds = tds;
        this.membreGauche.browseTree((BaseTree) t.getChild(0));
        this.membreDroit = Expr.expr_return((BaseTree) t.getChild(1));
        membreDroit.tds = tds;
        this.membreDroit.browseTree((BaseTree) t.getChild(1));
    }

    @Override
    public String translate() {
        return membreGauche.translate() + operateur + membreDroit.translate();
    }

    @Override
    public boolean isInt() {
        return true;
    }

    @Override
    public void checkSemantique() throws Exception {
        if (!this.membreGauche.isInt()) {
            throw new SemanticException(this.membreGauche.toString() + " is not compatible with " + this.operateur + " line " + line);
        }
        if (!this.membreDroit.isInt()) {
            throw new SemanticException(this.membreDroit.toString() + " is not compatible with " + this.operateur + " line " + line);
        }
        this.membreDroit.checkSemantique();
        this.membreGauche.checkSemantique();
    }
}