// $ANTLR 3.3 Nov 30, 2010 12:50:56 compilation-lab-master/Expr.g 2020-01-08 09:05:14

import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ExprParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEWLINE", "ID", "INT", "WS", "'='", "'+'", "'-'", "'*'", "'('", "')'"
    };
    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int NEWLINE=4;
    public static final int ID=5;
    public static final int INT=6;
    public static final int WS=7;

    // delegates
    // delegators


        public ExprParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ExprParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ExprParser.tokenNames; }
    public String getGrammarFileName() { return "compilation-lab-master/Expr.g"; }


    /** Map variable name to Integer object holding value */
    HashMap<String,Integer>  memory = new HashMap<String,Integer>();



    // $ANTLR start "prog"
    // compilation-lab-master/Expr.g:12:1: prog : ( stat )+ ;
    public final void prog() throws RecognitionException {
        try {
            // compilation-lab-master/Expr.g:12:5: ( ( stat )+ )
            // compilation-lab-master/Expr.g:12:9: ( stat )+
            {
            // compilation-lab-master/Expr.g:12:9: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=NEWLINE && LA1_0<=INT)||LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // compilation-lab-master/Expr.g:12:9: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog23);
            	    stat();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "prog"


    // $ANTLR start "stat"
    // compilation-lab-master/Expr.g:14:1: stat : ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE );
    public final void stat() throws RecognitionException {
        Token ID2=null;
        int expr1 = 0;

        int expr3 = 0;


        try {
            // compilation-lab-master/Expr.g:14:5: ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE )
            int alt2=3;
            switch ( input.LA(1) ) {
            case INT:
            case 12:
                {
                alt2=1;
                }
                break;
            case ID:
                {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==8) ) {
                    alt2=2;
                }
                else if ( (LA2_2==NEWLINE||(LA2_2>=9 && LA2_2<=11)) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
                }
                break;
            case NEWLINE:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // compilation-lab-master/Expr.g:14:9: expr NEWLINE
                    {
                    pushFollow(FOLLOW_expr_in_stat50);
                    expr1=expr();

                    state._fsp--;

                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat52); 
                    System.out.println(expr1);

                    }
                    break;
                case 2 :
                    // compilation-lab-master/Expr.g:15:9: ID '=' expr NEWLINE
                    {
                    ID2=(Token)match(input,ID,FOLLOW_ID_in_stat64); 
                    match(input,8,FOLLOW_8_in_stat66); 
                    pushFollow(FOLLOW_expr_in_stat68);
                    expr3=expr();

                    state._fsp--;

                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat70); 
                    memory.put((ID2!=null?ID2.getText():null), new Integer(expr3));

                    }
                    break;
                case 3 :
                    // compilation-lab-master/Expr.g:17:9: NEWLINE
                    {
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat90); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "stat"


    // $ANTLR start "expr"
    // compilation-lab-master/Expr.g:20:1: expr returns [int value] : e= multExpr ( '+' e= multExpr | '-' e= multExpr )* ;
    public final int expr() throws RecognitionException {
        int value = 0;

        int e = 0;


        try {
            // compilation-lab-master/Expr.g:21:5: (e= multExpr ( '+' e= multExpr | '-' e= multExpr )* )
            // compilation-lab-master/Expr.g:21:9: e= multExpr ( '+' e= multExpr | '-' e= multExpr )*
            {
            pushFollow(FOLLOW_multExpr_in_expr115);
            e=multExpr();

            state._fsp--;

            value = e;
            // compilation-lab-master/Expr.g:22:9: ( '+' e= multExpr | '-' e= multExpr )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==9) ) {
                    alt3=1;
                }
                else if ( (LA3_0==10) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // compilation-lab-master/Expr.g:22:13: '+' e= multExpr
            	    {
            	    match(input,9,FOLLOW_9_in_expr131); 
            	    pushFollow(FOLLOW_multExpr_in_expr135);
            	    e=multExpr();

            	    state._fsp--;

            	    value += e;

            	    }
            	    break;
            	case 2 :
            	    // compilation-lab-master/Expr.g:23:13: '-' e= multExpr
            	    {
            	    match(input,10,FOLLOW_10_in_expr151); 
            	    pushFollow(FOLLOW_multExpr_in_expr155);
            	    e=multExpr();

            	    state._fsp--;

            	    value -= e;

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "expr"


    // $ANTLR start "multExpr"
    // compilation-lab-master/Expr.g:27:1: multExpr returns [int value] : e= atom ( '*' e= atom )* ;
    public final int multExpr() throws RecognitionException {
        int value = 0;

        int e = 0;


        try {
            // compilation-lab-master/Expr.g:28:5: (e= atom ( '*' e= atom )* )
            // compilation-lab-master/Expr.g:28:9: e= atom ( '*' e= atom )*
            {
            pushFollow(FOLLOW_atom_in_multExpr193);
            e=atom();

            state._fsp--;

            value = e;
            // compilation-lab-master/Expr.g:28:37: ( '*' e= atom )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==11) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // compilation-lab-master/Expr.g:28:38: '*' e= atom
            	    {
            	    match(input,11,FOLLOW_11_in_multExpr198); 
            	    pushFollow(FOLLOW_atom_in_multExpr202);
            	    e=atom();

            	    state._fsp--;

            	    value *= e;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "multExpr"


    // $ANTLR start "atom"
    // compilation-lab-master/Expr.g:31:1: atom returns [int value] : ( INT | ID | '(' expr ')' );
    public final int atom() throws RecognitionException {
        int value = 0;

        Token INT4=null;
        Token ID5=null;
        int expr6 = 0;


        try {
            // compilation-lab-master/Expr.g:32:5: ( INT | ID | '(' expr ')' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt5=1;
                }
                break;
            case ID:
                {
                alt5=2;
                }
                break;
            case 12:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // compilation-lab-master/Expr.g:32:9: INT
                    {
                    INT4=(Token)match(input,INT,FOLLOW_INT_in_atom230); 
                    value = Integer.parseInt((INT4!=null?INT4.getText():null));

                    }
                    break;
                case 2 :
                    // compilation-lab-master/Expr.g:33:9: ID
                    {
                    ID5=(Token)match(input,ID,FOLLOW_ID_in_atom242); 

                            Integer v = (Integer)memory.get((ID5!=null?ID5.getText():null));
                            if ( v!=null ) value = v.intValue();
                            else System.err.println("undefined variable "+(ID5!=null?ID5.getText():null));
                            

                    }
                    break;
                case 3 :
                    // compilation-lab-master/Expr.g:39:9: '(' expr ')'
                    {
                    match(input,12,FOLLOW_12_in_atom262); 
                    pushFollow(FOLLOW_expr_in_atom264);
                    expr6=expr();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_atom266); 
                    value = expr6;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_prog23 = new BitSet(new long[]{0x0000000000001072L});
    public static final BitSet FOLLOW_expr_in_stat50 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_stat52 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_stat64 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_stat66 = new BitSet(new long[]{0x0000000000001060L});
    public static final BitSet FOLLOW_expr_in_stat68 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_stat70 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_stat90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multExpr_in_expr115 = new BitSet(new long[]{0x0000000000000602L});
    public static final BitSet FOLLOW_9_in_expr131 = new BitSet(new long[]{0x0000000000001060L});
    public static final BitSet FOLLOW_multExpr_in_expr135 = new BitSet(new long[]{0x0000000000000602L});
    public static final BitSet FOLLOW_10_in_expr151 = new BitSet(new long[]{0x0000000000001060L});
    public static final BitSet FOLLOW_multExpr_in_expr155 = new BitSet(new long[]{0x0000000000000602L});
    public static final BitSet FOLLOW_atom_in_multExpr193 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_multExpr198 = new BitSet(new long[]{0x0000000000001060L});
    public static final BitSet FOLLOW_atom_in_multExpr202 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_INT_in_atom230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_atom262 = new BitSet(new long[]{0x0000000000001060L});
    public static final BitSet FOLLOW_expr_in_atom264 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_atom266 = new BitSet(new long[]{0x0000000000000002L});

}