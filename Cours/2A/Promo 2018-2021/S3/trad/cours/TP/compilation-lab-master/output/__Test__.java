import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        ExprLexer lex = new ExprLexer(new ANTLRFileStream("/Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        ExprParser g = new ExprParser(tokens, 49101, null);
        try {
            g.prog();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}