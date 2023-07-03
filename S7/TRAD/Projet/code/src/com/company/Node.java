package com.company;

import com.company.tds.TDS;
import org.antlr.runtime.tree.BaseTree;

public abstract class Node {
    public TDS tds;

    public int line;

    public void browseTree(BaseTree t) throws Exception{
        this.line = t.getLine();
    }

    public abstract String translate();

    public abstract void checkSemantique() throws Exception;
}
