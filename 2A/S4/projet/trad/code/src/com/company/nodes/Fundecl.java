package com.company.nodes;

import com.company.Node;
import com.company.nodes.exceptions.SemanticException;
import com.company.tds.TDS;
import org.antlr.runtime.tree.BaseTree;

public class Fundecl extends Node {

    public String name;

    public Arglist arglist;

    public Type type;

    public Vardeclist vardeclist;

    public Bloc bloc;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        TDS funcTds = new TDS();
        tds.addFils(funcTds);
        funcTds.parent = tds;
        this.name = ((BaseTree) t.getChild(0)).toString();

        BaseTree arglist = (BaseTree) t.getChild(1);
        this.arglist = new Arglist();
        this.arglist.tds = funcTds;
        this.arglist.browseTree(arglist);

        String ty = ((BaseTree) t.getChild(2)).toString().toUpperCase();
        if ("ARRAY".equals(ty)) {
            throw new SemanticException("Array type is not valid for a function line " + line);
        } else {
            this.type = new SimpleType();
            this.type.tds = tds;
        }
        this.type.browseTree((BaseTree)(t.getChild(2)));

        BaseTree vardeclist = (BaseTree) t.getChild(3);
        this.vardeclist = new Vardeclist();
        this.vardeclist.tds = funcTds;
        this.vardeclist.browseTree(vardeclist);

        BaseTree bloc = (BaseTree) t.getChild(4);
        this.bloc = new Bloc();
        this.bloc.tds = funcTds;
        this.bloc.browseTree(bloc);
    }

    @Override
    public String translate() {
        StringBuilder res = new StringBuilder(this.type.translate() + " " + this.name + "(");
        res.append(this.arglist.translate() + ")\n{\n");
        res.append(this.vardeclist.translate());
        String tmp = this.bloc.translate();
        tmp = tmp.substring(2, tmp.length()-1);
        //System.out.println(" tmp vaut =" + tmp);
        res.append(tmp);

        return res.toString();
    }

    @Override
    public void checkSemantique() throws Exception {
        if(this.tds.checkEntryAddable(this.name)) {
            throw new SemanticException(this.name + " already used line " + line);
        } else {
            this.tds.addEntry(this.name, "FUNCTION", this.type.toString(), this.arglist.arg.length);
        }
        this.arglist.checkSemantique();
        this.type.checkSemantique();
        this.vardeclist.checkSemantique();
        this.bloc.checkSemantique();
    }
}
