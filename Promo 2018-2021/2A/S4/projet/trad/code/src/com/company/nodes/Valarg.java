package com.company.nodes;

import com.company.nodes.exceptions.SemanticException;

public class Valarg extends Arg {

    @Override
    public String translate() {
        StringBuilder res = new StringBuilder(" ");
        if(type.getType().equals(com.company.tds.Type.tableau)){
            res.append(type.getSousType().toLowerCase()).append(" ");
            res.append(idf).append(type.translate());
        }else{
            res.append(type.translate()).append(" ");
            res.append(idf);
        }

        return res.toString();
    }

    @Override
    public void checkSemantique() throws Exception {
        if (tds.checkEntryAddable(idf)) {
            throw new SemanticException("Argument name in function is already used line " + line);
        }
        if (type.getType().equals(com.company.tds.Type.tableau)) {
            tds.addEntry(idf, type.getType(), type.getSousType(), type.getTabDecalage());
        } else {
            tds.addEntry(idf, type.getType(), type.getSousType(),0);
        }
    }
}
