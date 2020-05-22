package com.company.nodes;

import com.company.Node;
import org.antlr.runtime.tree.BaseTree;

public class Rangelist extends Node {

    public Range[] range;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        this.range = new Range[t.getChildCount()];
        BaseTree t2;
        for(int i=0; i<t.getChildCount(); i++){
            t2 = (BaseTree) t.getChild(i);
            this.range[i] = new Range();
            this.range[i].tds = tds;
            this.range[i].browseTree(t2);
        }
    }

    @Override
    public String translate() {
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i< range.length; i++){
            res.append(range[i].translate());
        };
        return res.toString();
    }

    @Override
    public void checkSemantique() throws Exception {
        for (Range value : this.range) {
            value.checkSemantique();
        }
    }

    public int[] getTabDecalage(){
        int[] res = new int[range.length];
        for(int i=0; i<range.length; i++){
            res[i] = range[i].getDecallage();
        }
        return res;
    }
}
