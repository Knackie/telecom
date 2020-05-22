package com.company.nodes;

import com.company.Node;
import org.antlr.runtime.tree.BaseTree;

public class WhileDo extends Node {

    public Instruction instruction;


    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);

        BaseTree bloc;

        bloc = (BaseTree) t.getChild(0);
        this.instruction = Instruction.instruction_return(bloc);
        this.instruction.tds = tds;
        this.instruction.browseTree(bloc);
    }

    @Override
    public String translate() {
        StringBuilder res = new StringBuilder("");
        res.append(this.instruction.translate());
        res.append("\n");
        return res.toString();
    }

    @Override
    public void checkSemantique() throws Exception{
        instruction.checkSemantique();
    }

}
