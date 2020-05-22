package com.company.nodes;

import com.company.nodes.exceptions.SemanticException;
import com.company.tds.Type;
import org.antlr.runtime.tree.BaseTree;

public class InstrAffect extends Instruction {

    public Expr expr;
    public Affectable affectable;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);

        //todo : know if it is idf or table
        if(t.getChild(0).toString().equals("TAB_ACCESS")){
            this.affectable = new TabAccess();
        }
        else{
            this.affectable = new Idf();
        }
        this.affectable.tds = tds;
        this.affectable.browseTree((BaseTree) (t.getChild(0)));
        this.expr = Expr.expr_return((BaseTree) (t.getChild(1)));
        expr.tds = tds;
        expr.browseTree((BaseTree) (t.getChild(1)));
    }

    @Override
    public String translate() {
        return affectable.translate() + " = " + expr.translate() + ";\n";
    }

    @Override
    public void checkSemantique() throws Exception {
        this.expr.checkSemantique();
        this.affectable.checkSemantique();
        if(this.expr.isStr()){
            throw new SemanticException("String is not affectable line " + line);
        }
        else{
            if(this.expr.isInt()){
                if(!this.affectable.getType().equals(Type.entier)){
                    throw new SemanticException("trying to affect int expr to not int variable line " +line);
                }
            } else{
                if(this.expr.isBol()){
                    if(!this.affectable.getType().equals(Type.booleen)){
                        throw new SemanticException("trying to affect bool expr to not bool variable line " +line);
                    }
                }
                else {
                    throw new SemanticException("void type not allowed here line " +line);
                }
            }
        }

    }

}
