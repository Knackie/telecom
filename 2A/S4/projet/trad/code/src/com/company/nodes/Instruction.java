package com.company.nodes;

import com.company.Node;
import com.company.nodes.exceptions.InstructionNotFoundException;
import org.antlr.runtime.tree.BaseTree;

abstract public class Instruction extends Node {

    public static Instruction instruction_return(BaseTree t) throws Exception{
        switch (t.toString()) {
            case "INSTR_AFFECT":
                return (new InstrAffect());
            case "INSTR_WHILE":
                return (new InstrWhile());
            case "INSTR_FUNC_APPEL":
                return (new InstrFuncAppel());
            case "INSTR_IF":
                return (new InstrIf());
            case "INSTR_RETURN":
                return (new InstrReturn());
            case "INSTR_WRITE":
                return (new InstrWrite());
            case "INSTR_READ":
                return (new InstrRead());
            case "BLOC":
                return (new Bloc());
            case "EMPTY":
                return (null);
            default:
                throw new InstructionNotFoundException("L'instruction "+t.toString() + " n'a pas été reconnue ligne "+t.getLine());
        }
    }

}
