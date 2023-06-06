package com.company.nodes;

import com.company.nodes.exceptions.SemanticException;
import org.antlr.runtime.tree.BaseTree;

public class CsteEnt extends Expr {
    /* CSTE_ENT peut être négatif, auquel cas on trouve un noeud "-" avant le neoud de la valeur.
     * On teste si le noeud est un "-". Si c'est le cas, on prend son fils comme valeur et on y ajoute un moins
     * */
    public int valeur;

    public void browseTree(BaseTree t) throws Exception {
        super.browseTree(t);
        BaseTree fils = (BaseTree) t.getChild(0);
        String res = fils.toString();
        int line = fils.getLine();
        if (res.equals("-")) {
            BaseTree sousfils = (BaseTree) fils.getChild(0);
            res = sousfils.toString();
            line = sousfils.getLine();
            try {
                this.valeur = Integer.parseInt("-" + res);
            } catch (NumberFormatException nfe) {
                throw new SemanticException(res + " is not an int expression line " + line);
            }
        }else {
            try {
                this.valeur = Integer.parseInt(res);
            } catch (NumberFormatException nfe) {
                throw new SemanticException(res + " is not an int expression line " + line);
            }
        }
    }

    @Override
    public String translate() {return Integer.toString(valeur);}

    @Override
    public boolean isInt() {
        return true;
    }

    @Override
    public void checkSemantique() throws Exception {

    }

    public int getValeur() {
        return valeur;
    }
}
