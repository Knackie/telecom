package com.company.nodes;

import com.company.Node;
import com.company.nodes.exceptions.SemanticException;
import org.antlr.runtime.tree.BaseTree;

public class Range extends Node {

    public CsteEnt cste1;
    public CsteEnt cste2;

    @Override
    public void browseTree(BaseTree t)  throws Exception{
        super.browseTree(t);
        BaseTree t2;
        t2 = (BaseTree) t.getChild(0);
        this.cste1 = new CsteEnt();
        this.cste1.tds = tds;
        this.cste1.browseTree(t2);
        t2 = (BaseTree) t.getChild(1);
        this.cste2 = new CsteEnt();
        this.cste2.tds = tds;
        this.cste2.browseTree(t2);
    }

    @Override
    public String translate() {
        /* On récupère la taille du tableau : index de fin - index de début
        * Pour récupérer la valeur de l'index (string), il faut appeler la méthode
        * translate sur cste1 et cste2 puis les transformer en int pour effectuer le calcul */
        int taille = Integer.parseInt(this.cste2.translate()) - Integer.parseInt(this.cste1.translate());
        String taille_str = Integer.toString(taille);
        return "[" + taille_str + "]";
        /* Attention au décallage des index à prendre en compte dans TDS */
    }

    @Override
    public void checkSemantique() throws Exception {
        if (cste1.getValeur() > cste2.getValeur()){
            throw new SemanticException("Invalid range line "+ line);
        }
        cste1.checkSemantique();
        cste2.checkSemantique();
    }

    public int getDecallage(){
        return -cste1.getValeur();
    }
}
