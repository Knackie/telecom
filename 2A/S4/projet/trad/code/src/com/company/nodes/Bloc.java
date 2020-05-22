package com.company.nodes;

import org.antlr.runtime.tree.BaseTree;

import java.util.ArrayList;
import java.util.List;

public class Bloc extends Instruction {
    public List<Instruction> listInstr;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        this.listInstr = new ArrayList<Instruction>();
        BaseTree t2;

        for(int i=0; i<t.getChildCount(); i++){
            t2 = (BaseTree) t.getChild(i);
            Instruction tmp = Instruction.instruction_return(t2);

            if(tmp!=null){
                tmp.tds = tds;
                this.listInstr.add(tmp);
                tmp.browseTree(t2);
            }

        }
    }

    @Override
    public String translate() {
        StringBuilder res = new StringBuilder("\n{\n");
        for (Instruction instruction :this.listInstr){
            res.append(instruction.translate()).append("");
            }
        res.append("\n}\n");
        return res.toString();
    }

    @Override
    public void checkSemantique() throws Exception {
        for (Instruction instruction : this.listInstr) {
            instruction.checkSemantique();
        }
    }
}
