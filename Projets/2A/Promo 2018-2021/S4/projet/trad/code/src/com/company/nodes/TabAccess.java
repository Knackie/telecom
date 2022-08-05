package com.company.nodes;

import com.company.nodes.exceptions.SemanticException;
import com.company.tds.Type;
import org.antlr.runtime.tree.BaseTree;

public class TabAccess extends Affectable {
    public String idf;
    public Expr[] expr;
    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        this.expr = new Expr[t.getChildCount()-1];
        this.idf =  t.getChild(0).toString();
        for(int i = 1; i<t.getChildCount(); i++) {
            this.expr[i-1] = Expr.expr_return((BaseTree) t.getChild(i));
            this.expr[i-1].tds = tds;
            this.expr[i-1].browseTree((BaseTree) t.getChild(i));
        }
    }

    @Override
    public String translate() {
        StringBuilder res = new StringBuilder(idf);

        for (int i = 0; i< expr.length; i++){
            res.append("["+expr[i].translate()+"+"+tds.getType(idf).getDecallages()[i] +"]");
        }
        return res.toString();
    }

    @Override
    public void checkSemantique() throws Exception {
        if(!tds.checkEntryExists(idf)){
            throw new SemanticException(idf+" never declared before use line "+line);
        }
        for (int i=0; i<expr.length;i++){
            if (!expr[i].isInt()){
                throw new SemanticException("Expr in tab accessor is not an integer expr line "+line);
            }
            expr[i].checkSemantique();
        }
    }

    @Override
    public boolean isBol() {
        return tds.getType(idf).getSoustype().equals( Type.booleen);
    }

    @Override
    public boolean isInt() {
        return tds.getType(idf).getSoustype().equals( Type.entier);
    }

    @Override
    String getType() {
        return tds.getType(idf).getSoustype();
    }
}
