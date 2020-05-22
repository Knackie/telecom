package com.company.nodes;

import com.company.nodes.exceptions.SemanticException;
import com.company.tds.Type;
import org.antlr.runtime.tree.BaseTree;

public class InstrFuncAppel extends Expr {
    public String name;
    public Expr[] expr;
    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        this.expr = new Expr[t.getChildCount()-1];
        this.name = ((BaseTree) t.getChild(0)).toString();
        for(int i = 1; i<t.getChildCount(); i++){
            this.expr[i-1] = Expr.expr_return((BaseTree) t.getChild(i));
            this.expr[i-1].tds = tds;
            this.expr[i-1].browseTree((BaseTree) t.getChild(i));
        }
    }

    @Override
    public String translate() {
        StringBuilder res = new StringBuilder(name + "(");
        for (int i =0; i < expr.length-1; i++)
        {
            res.append(expr[i].translate()).append(", ");
        }
        if(expr.length >0) {
            res.append(expr[expr.length - 1].translate()).append(")").toString();

        }else{
            res.append(")").toString();
        }
        res.append(";");
        return (res.toString());

    }

    @Override
    public void checkSemantique() throws Exception {
        if(!tds.checkEntryExists(name)){
            throw new SemanticException(name+" never declared before line "+line);
        }
        if (!tds.getType(name).getType().equals(Type.fonction)){
            throw new SemanticException(name+" is not a function line "+line);
        }
        if(this.expr.length != this.tds.getNbArg(this.name)){
            throw new SemanticException(name+" is called with wrong number of arg line "+line);
        }
        for (Expr value : this.expr) {
            value.checkSemantique();
        }
    }

    public boolean isInt(){
        return this.tds.getType(this.name).getSoustype().equals(Type.entier);
    }

    public boolean isBol(){
        return this.tds.getType(this.name).getSoustype().equals(Type.booleen);
    }
}
