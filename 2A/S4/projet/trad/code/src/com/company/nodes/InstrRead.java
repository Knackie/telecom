package com.company.nodes;

import org.antlr.runtime.tree.BaseTree;

public class InstrRead extends Instruction {
    public Affectable affectable;
    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        if (t.getChild(0).toString().equals("TAB_ACCESS")){
            this.affectable= new TabAccess();

        }else{
            this.affectable = new Idf();
        }
        this.affectable.tds = tds;
        this.affectable.browseTree((BaseTree) t.getChild(0));
    }

    @Override
    public String translate() {
        String val ="";
        if (affectable.isBol() || affectable.isInt() )
            val = "%d";
        if (affectable.isStr())
            val = "%s";
        return  "scanf(\""+val+"\", &"  + affectable.translate() +");\n";

    }

    @Override
    public void checkSemantique() throws Exception {
        this.affectable.checkSemantique();
    }
}
