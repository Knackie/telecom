package com.company.nodes;

import com.company.nodes.exceptions.SemanticException;
import com.company.tds.Type;
import org.antlr.runtime.tree.BaseTree;

public class Idf extends Affectable {
    public String idf;

    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        BaseTree fils;
        fils = (BaseTree) t.getChild(0);
        this.idf = fils.toString();
    }
    public String translate() {
        return idf;
    }

    @Override
    public void checkSemantique() throws Exception {
        if(!this.tds.checkEntryExists(this.idf)){
            throw new SemanticException(this.idf + " never declared line " + line);
        }
    }

    @Override
    public boolean isBol() {
        return tds.getType(idf).getType().equals( Type.booleen);
    }

    @Override
    public boolean isInt() {
        return tds.getType(idf).getType().equals( Type.entier);
    }

    @Override
    String getType() {
        return tds.getType(idf).getType();
    }
}
