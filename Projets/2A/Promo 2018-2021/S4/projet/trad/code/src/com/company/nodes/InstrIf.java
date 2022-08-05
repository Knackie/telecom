package com.company.nodes;

import org.antlr.runtime.tree.BaseTree;

public class InstrIf extends Instruction {
    public IfCond ifCond;
    public IfThen ifThen;
    public IfElse ifElse;
    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);

        BaseTree ifCond;
        BaseTree ifThen;
        BaseTree ifElse;

        ifCond = (BaseTree) t.getChild(0);
        this.ifCond = new IfCond();
        this.ifCond.tds = tds;
        this.ifCond.browseTree(ifCond);
        ifThen = (BaseTree) t.getChild(1);
        this.ifThen = new IfThen();
        this.ifThen.tds = tds;
        this.ifThen.browseTree(ifThen);
        if(t.getChildCount()==3) {
            ifElse = (BaseTree) t.getChild(2);
            this.ifElse = new IfElse();
            this.ifElse.tds = tds;
            this.ifElse.browseTree(ifElse);
        }
    }

    @Override
    public String translate() {
        if(ifElse == null) {
            return "if (" + ifCond.translate() + ")\n" + ifThen.translate();
        }
        else
            return "if (" + ifCond.translate() + ")\n" + ifThen.translate() + ifElse.translate();
    }


    @Override
    public void checkSemantique() throws Exception {
        this.ifCond.checkSemantique();
        this.ifThen.checkSemantique();
        if(this.ifElse !=null) {
            this.ifElse.checkSemantique();
        }
    }
}
