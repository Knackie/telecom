package com.company.nodes;

import com.company.Node;
import org.antlr.runtime.tree.BaseTree;

public class Arglist extends Node {

    public Arg[] arg;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        this.arg = new Arg[t.getChildCount()];
        BaseTree t2;
        for(int i = 0; i<t.getChildCount(); i++){
            t2 = (BaseTree) t.getChild(i);

            if(t2.toString().equals("REFARG")) {
                this.arg[i] = new Refarg();
            } else{
                this.arg[i] = new Valarg();
            }
            this.arg[i].tds = tds;
            this.arg[i].browseTree(t2);
        }
    }

    @Override
    public String translate() {
        StringBuilder res =new StringBuilder("");
        for (int i = 0; i< arg.length-1; i++){
            res.append(arg[i].translate()).append(", ");
        }
        if(arg.length>0) {
            res.append(arg[arg.length - 1].translate());
        }
        return res.toString();
    }

    @Override
    public void checkSemantique() throws Exception {
        for (Arg value : this.arg) {
            value.checkSemantique();
        }
    }
}
