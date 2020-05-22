package com.company.nodes;

import com.company.Node;
import com.company.nodes.exceptions.SemanticException;
import org.antlr.runtime.tree.BaseTree;

public class Vardecl extends Node {

    public Type type;
    public String[] idf;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        String ty = ((BaseTree) t.getChild(0)).toString().toUpperCase();
        if ("ARRAY".equals(ty)) {
            this.type = new ArrayType();
        } else {
            this.type = new SimpleType();
        }
        this.type.tds = tds;
        this.type.browseTree((BaseTree)t.getChild(0));
        this.idf = new String[t.getChildCount()-1];
        BaseTree t2;
        for (int i = 1; i < t.getChildCount(); i++) {
            t2 = (BaseTree) t.getChild(i);
            this.idf[i-1] = t2.toString();
        }
    }

    @Override
    public String translate() {
        StringBuilder res = new StringBuilder(" ");
        if(type.getType().equals(com.company.tds.Type.tableau)){
            res.append(type.getSousType().toLowerCase()).append(" ");
            for (int i = 0; i< idf.length-1; i++){
                res.append(idf[i]).append(type.translate()).append(", ");
            }
            res.append(idf[idf.length - 1]).append(type.translate()).append(";\n");
        }else{
            res.append(type.translate()).append(" ");
            for (int i = 0; i< idf.length-1; i++){
                res.append(idf[i]).append(", ");
            }
            res.append(idf[idf.length - 1]).append(";\n");
        }

        return res.toString();
    }

    @Override
    public void checkSemantique() throws Exception {
        for(int i=0; i< idf.length; i++){
            if(tds.checkEntryAddable(idf[i])){
                throw new SemanticException("Variable "+ idf[i]+" is already declared line : "+ line);
            }else {
                if (type.getType().equals(com.company.tds.Type.tableau)){
                    tds.addEntry(idf[i], type.getType(), type.getSousType(), type.getTabDecalage());
                }else {
                    tds.addEntry(idf[i], type.getType(), type.getSousType(),0);
                }
            }
        }
    }

}
