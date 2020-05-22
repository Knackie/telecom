package com.company.nodes;

import com.company.Node;
import org.antlr.runtime.tree.BaseTree;

public class Vardeclist extends Node {

    public Vardecl[] vardecl;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        this.vardecl = new Vardecl[t.getChildCount()];
        BaseTree t2;
        for (int i = 0; i < t.getChildCount(); i++) {
            t2 = (BaseTree) t.getChild(i);
            this.vardecl[i] = new Vardecl();
            this.vardecl[i].tds = tds;
            this.vardecl[i].browseTree(t2);
        }
    }

    @Override
    public String translate() {
        StringBuilder liste= new StringBuilder("");
        for (int i = 0; i< vardecl.length; i++){
            liste.append(vardecl[i].translate());
        };
        return liste.toString();
    }

    @Override
    public void checkSemantique() throws Exception {
        for (int i = 0; i< vardecl.length;i++){
            vardecl[i].checkSemantique();
        }
    }
}
