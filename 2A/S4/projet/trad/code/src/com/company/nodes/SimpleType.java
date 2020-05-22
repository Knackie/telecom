package com.company.nodes;

import com.company.nodes.exceptions.SemanticException;
import org.antlr.runtime.tree.BaseTree;

public class SimpleType extends Type {

    public String type;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        switch (t.toString().toUpperCase()) {
            case "INT":
                this.type = com.company.tds.Type.entier;
                break;
            case "BOOL":
                this.type = com.company.tds.Type.booleen;
                break;
            case "VOID":
                this.type = com.company.tds.Type.vide;
                break;
            default:
                throw new SemanticException("Unrecognized type line "+line);
        }
    }

    @Override
    public String translate() {
        return type.toLowerCase();
    }

    @Override
    public void checkSemantique() throws Exception {

    }

    public boolean isInt() {
        return this.type.toUpperCase().equals("INT");
    }

    public boolean isBol() {
        return this.type.toUpperCase().equals("BOOL");
    }

    public String toString(){
        return this.type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getSousType() {
        return null;
    }

    @Override
    public int[] getTabDecalage() {
        return null;
    }

}
