package com.company.nodes;

import com.company.nodes.exceptions.SemanticException;
import org.antlr.runtime.tree.BaseTree;

public class ArrayType extends Type {

    public SimpleType simpletype;
    public Rangelist rangelist;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        this.simpletype = new SimpleType();
        simpletype.tds = tds;
        this.simpletype.browseTree((BaseTree) t.getChild(0));

        this.rangelist = new Rangelist();
        rangelist.tds = tds;
        this.rangelist.browseTree((BaseTree) t.getChild(1));
    }

    @Override
    public String translate() {
        String res = "";
        for (int i=0;i<rangelist.range.length; i++){
            res += "[" +(rangelist.range[i].cste2.getValeur()-rangelist.range[i].cste1.getValeur())+ "]";
        }
        return res ;
    }

    @Override
    public void checkSemantique() throws Exception {
        this.simpletype.checkSemantique();
        if(!this.simpletype.isInt() && !this.simpletype.isBol()) {
            throw new SemanticException(this.simpletype.type + " is not an array type line "+line);
        }
        this.rangelist.checkSemantique();
    }

    @Override
    public String getType() {
        return com.company.tds.Type.tableau;
    }

    @Override
    public String getSousType() {
        return simpletype.getType();
    }

    public int[] getTabDecalage(){
        return rangelist.getTabDecalage();
    }

}
