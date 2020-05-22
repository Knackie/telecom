package com.company;

import com.company.nodes.Program;
import com.company.tds.TDS;
import org.antlr.runtime.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.antlr.runtime.tree.BaseTree;

import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) throws Exception {
        ANTLRFileStream input = new ANTLRFileStream("test/test_Da_Silva.c");
        String pathC = "out/generate.c";

        projetLexer lexer = new projetLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        projetParser parser = new projetParser(tokens);
        BaseTree t = (BaseTree)(parser.program().getTree());
        Program p = new Program();
        p.tds = new TDS();
        p.browseTree(t);
        p.checkSemantique();
        String res =  p.translate();
        Files.writeString(Paths.get(pathC), res);
        System.out.println("\n=======================RESULTAT GÉNÉRATION=======================\n\nCode généré sans erreur");
        System.out.println("\n==============================TDS================================\n");
        System.out.println(p.tds);



    }
}
