package com.company.nodes;

import com.company.Node;
import org.antlr.runtime.tree.BaseTree;

public class Funcdeclist extends Node {

    public Fundecl[] fundecl;

    @Override
    public void browseTree(BaseTree t) throws Exception {
        super.browseTree(t);
        this.fundecl = new Fundecl[t.getChildCount()];
        BaseTree t2;
        for (int i = 0; i < t.getChildCount(); i++) {
            t2 = (BaseTree) t.getChild(i);
            this.fundecl[i] = new Fundecl();
            this.fundecl[i].tds = tds;
            this.fundecl[i].browseTree(t2);
        }
    }

    @Override
    public String translate() {
        String res = "";
        for (int i=0; i < fundecl.length-1; i++)
        {
            res += fundecl[i].translate() + "\n";
        }
        if(fundecl.length > 0) {
            res += fundecl[fundecl.length - 1].translate();
        }
        return res;
    }

    @Override
    public void checkSemantique() throws Exception {
        for (Fundecl value : this.fundecl) {
            value.checkSemantique();
        }
    }
}
