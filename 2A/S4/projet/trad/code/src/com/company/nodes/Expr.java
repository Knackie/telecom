package com.company.nodes;

import com.company.Node;
import com.company.nodes.exceptions.ExprNotFoundException;
import org.antlr.runtime.tree.BaseTree;

abstract public class Expr extends Instruction {

    public static Expr expr_return(BaseTree t) throws Exception {
        switch (t.toString()) {
            case "<=":
            case ">=":
            case "<":
            case ">":
            case "==":
            case "!=":
                return (new ExprBool());
            case "+":
            case "*":
            case "/":
            case "^":
                return (new ExprEnt());
            case "INSTR_FUNC_APPEL":
                return (new InstrFuncAppel());
            case "CSTE_ENT":
                return (new CsteEnt());
            case "CSTE_BOOLEEN":
                return (new CsteBooleen());
            case "CSTE_STR":
                return (new CsteStr());
            case "IDF":
                return (new Idf());
            case "not":
                return new ExprNot();
            case "-":
                if(t.getChildCount()==1){
                    return new ExprNeg();
                }else{
                    return new ExprEnt();
                }
            case "and":
            case "or":
                return new ExprBoolBool();
            case "TAB_ACCESS":
                return new TabAccess();
            default:
                throw new ExprNotFoundException("L'expression " + t.toString() + " n'a pas été reconnue ligne " + t.getLine());
        }
    }

    public boolean isBol() {
        return false;
    }

    public boolean isInt() {
        return false;
    }

    public boolean isStr() {
        return false;
    }

}
