package com.company.nodes;

import com.company.Node;
import org.antlr.runtime.tree.BaseTree;

public class Program extends Node {

    public Vardeclist vardeclist;
    public Funcdeclist funcdeclist;
    public Bloc bloc;

    public String name;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        this.name = t.toString();

        BaseTree vardecl;
        BaseTree fundecl;
        BaseTree bloc;

        vardecl = (BaseTree) t.getChild(0);
        this.vardeclist = new Vardeclist();
        this.vardeclist.tds = tds;
        this.vardeclist.browseTree(vardecl);
        fundecl = (BaseTree) t.getChild(1);
        this.funcdeclist = new Funcdeclist();
        this.funcdeclist.tds = tds;
        this.funcdeclist.browseTree(fundecl);
        bloc = (BaseTree) t.getChild(2);
        this.bloc = new Bloc();
        this.bloc.tds = tds;
        this.bloc.browseTree(bloc);
    }

    @Override
    public String translate() {
        return "#include <stdio.h>\n#include <stdbool.h>\n" + funcdeclist.translate() + "\n int main()\n{\n" + vardeclist.translate() + " " + bloc.translate() + "\n}";
    }

    @Override
    public void checkSemantique() throws Exception {
        this.vardeclist.checkSemantique();
        this.funcdeclist.checkSemantique();
        this.bloc.checkSemantique();
    }

}
