package com.company.tds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TDS {

    public HashMap<String, Type> entries = new HashMap<String, Type>();

    public TDS parent;
    public List<TDS> fils = new ArrayList<TDS>();

    public void addEntry(String idf, String type, String soustype, int nbArg) {
        Type t = new Type(type, soustype, nbArg);
        this.entries.put(idf, t);
    }

    public void addEntry(String idf, String type, String soustype, int[] decallages) {
        Type t = new Type(type, soustype,0);
        t.setDecallages(decallages);
        this.entries.put(idf, t);
    }

    public boolean checkEntryExists(String entry) {
       return this.entries.containsKey(entry) || (this.parent != null && this.parent.checkEntryExists(entry));
    }

    public boolean checkEntryAddable(String entry) {
        return this.entries.containsKey(entry);
    }

    public Type getType(String idf){
        if(this.entries.containsKey(idf)) {
            return this.entries.get(idf);
        }else{
            return this.parent.getType(idf);
        }
    }

    public int getNbArg(String idf){
        if(this.entries.containsKey(idf)) {
            return this.entries.get(idf).nbArg;
        }else{
            return this.parent.getType(idf).nbArg;
        }
    }

    public void addFils(TDS tds){
        this.fils.add(tds);
    }

    public String toString(){
        String res = "";
        Iterator<Type> i = entries.values().iterator();
        while (i.hasNext()){
            Type t = i.next();
            res+= t;
            res += '\n';
        }
        res+= "--------|\n";
        Iterator<TDS> t = fils.iterator();
        while (t.hasNext()){
            res += t.next();
        }
        return res;
    }

}
