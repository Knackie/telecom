package com.company.nodes;

import com.company.Node;
import org.antlr.runtime.tree.BaseTree;

public class IfElse extends Node {
    public Instruction instruction;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        BaseTree instruction = (BaseTree) t.getChild(0);
        this.instruction = Instruction.instruction_return(instruction);
        this.instruction.tds = tds;
        this.instruction.browseTree(instruction);
    }

    @Override
    public String translate() {
        return "else \n" + instruction.translate() + "\n";
    }

    @Override
    public void checkSemantique() throws Exception {
        this.instruction.checkSemantique();
    }
}
