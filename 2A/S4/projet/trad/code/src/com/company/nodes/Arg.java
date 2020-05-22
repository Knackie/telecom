package com.company.nodes;

import com.company.Node;
import org.antlr.runtime.tree.BaseTree;

public abstract class Arg extends Node {
    public Type type;
    public String idf;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        BaseTree type = (BaseTree) t.getChild(0);
        if ("array".equals(type.toString())) {
            this.type = new ArrayType();
        } else {
            this.type = new SimpleType();
        }
        this.type.tds = tds;
        this.type.browseTree(type);

        BaseTree idf = (BaseTree) t.getChild(1);
        this.idf = idf.toString();
    }


}
