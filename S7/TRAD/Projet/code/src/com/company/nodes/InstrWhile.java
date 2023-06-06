package com.company.nodes;

import org.antlr.runtime.tree.BaseTree;

public class InstrWhile extends Instruction {

    public WhileCond while_cond;
    public WhileDo while_do;


    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);

        BaseTree while_cond;
        BaseTree while_do;

        while_cond = (BaseTree) t.getChild(0);
        this.while_cond = new WhileCond();
        this.while_cond.tds = tds;
        this.while_cond.browseTree(while_cond);
        while_do = (BaseTree) t.getChild(1);
        this.while_do = new WhileDo();
        this.while_do.tds = tds;
        this.while_do.browseTree(while_do);
    }

    @Override
    public String translate() {
        StringBuilder res = new StringBuilder("while ");
        res.append(while_cond.translate());
        res.append(while_do.translate());
        return res.toString();
    }

    @Override
    public void checkSemantique() throws Exception {
        while_cond.checkSemantique();
        while_do.checkSemantique();
    }

}
