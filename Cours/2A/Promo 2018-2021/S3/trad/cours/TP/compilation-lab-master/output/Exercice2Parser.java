// $ANTLR null /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g 2020-01-15 09:13:40

import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings("all")
public class Exercice2Parser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "INT", "NEWLINE", "NIL", "'('", 
		"')'", "','", "'.'"
	};
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int INT=4;
	public static final int NEWLINE=5;
	public static final int NIL=6;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "prog", "s", "v", "a", "x"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public Exercice2Parser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public Exercice2Parser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this, port, null);

		setDebugListener(proxy);
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
	}

	public Exercice2Parser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg, new RecognizerSharedState());
	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

	@Override public String[] getTokenNames() { return Exercice2Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g"; }


	/** Map variable name to Integer object holding value */
	HashMap<String,Integer>  memory = new HashMap<String,Integer>();



	// $ANTLR start "prog"
	// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:12:1: prog : a ;
	public final void prog() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "prog");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(12, 0);

		try {
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:12:5: ( a )
			dbg.enterAlt(1);

			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:12:8: a
			{
			dbg.location(12,8);
			pushFollow(FOLLOW_a_in_prog22);
			a();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(12, 8);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "prog");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "prog"



	// $ANTLR start "a"
	// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:16:1: a : ( v | '(' a x );
	public final void a() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "a");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(16, 0);

		try {
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:16:4: ( v | '(' a x )
			int alt1=2;
			try { dbg.enterDecision(1, decisionCanBacktrack[1]);

			int LA1_0 = input.LA(1);
			if ( (LA1_0==INT||LA1_0==NIL) ) {
				alt1=1;
			}
			else if ( (LA1_0==7) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(1);}

			switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:16:6: v
					{
					dbg.location(16,6);
					pushFollow(FOLLOW_v_in_a52);
					v();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:16:10: '(' a x
					{
					dbg.location(16,10);
					match(input,7,FOLLOW_7_in_a56); dbg.location(16,14);
					System.out.println("(");dbg.location(16,40);
					pushFollow(FOLLOW_a_in_a59);
					a();
					state._fsp--;
					dbg.location(16,42);
					pushFollow(FOLLOW_x_in_a61);
					x();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(16, 42);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "a");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "a"



	// $ANTLR start "x"
	// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:17:1: x : ( '.' a ')' | s ')' );
	public final void x() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "x");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(17, 0);

		try {
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:17:4: ( '.' a ')' | s ')' )
			int alt2=2;
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==10) ) {
				alt2=1;
			}
			else if ( ((LA2_0 >= 8 && LA2_0 <= 9)) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:17:6: '.' a ')'
					{
					dbg.location(17,6);
					match(input,10,FOLLOW_10_in_x69); dbg.location(17,10);
					System.out.println(".");dbg.location(17,37);
					pushFollow(FOLLOW_a_in_x73);
					a();
					state._fsp--;
					dbg.location(17,39);
					match(input,8,FOLLOW_8_in_x75); dbg.location(17,43);
					System.out.println(")");
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:17:72: s ')'
					{
					dbg.location(17,72);
					pushFollow(FOLLOW_s_in_x81);
					s();
					state._fsp--;
					dbg.location(17,74);
					match(input,8,FOLLOW_8_in_x83); dbg.location(17,77);
					System.out.println(")");
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(17, 102);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "x");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "x"



	// $ANTLR start "s"
	// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:18:1: s : ( ',' a s |);
	public final void s() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "s");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(18, 0);

		try {
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:18:4: ( ',' a s |)
			int alt3=2;
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			int LA3_0 = input.LA(1);
			if ( (LA3_0==9) ) {
				alt3=1;
			}
			else if ( (LA3_0==8) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(3);}

			switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:18:6: ',' a s
					{
					dbg.location(18,6);
					match(input,9,FOLLOW_9_in_s92); dbg.location(18,10);
					System.out.println(",");dbg.location(18,37);
					pushFollow(FOLLOW_a_in_s96);
					a();
					state._fsp--;
					dbg.location(18,39);
					pushFollow(FOLLOW_s_in_s98);
					s();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:18:43: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(18, 42);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "s");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "s"


	public static class v_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "v"
	// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:19:1: v : ( INT | NIL );
	public final Exercice2Parser.v_return v() throws RecognitionException {
		Exercice2Parser.v_return retval = new Exercice2Parser.v_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "v");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(19, 0);

		try {
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:19:4: ( INT | NIL )
			int alt4=2;
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

			int LA4_0 = input.LA(1);
			if ( (LA4_0==INT) ) {
				alt4=1;
			}
			else if ( (LA4_0==NIL) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:19:6: INT
					{
					dbg.location(19,6);
					match(input,INT,FOLLOW_INT_in_v108); dbg.location(19,10);
					System.out.println(input.toString(retval.start,input.LT(-1)));
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:19:43: NIL
					{
					dbg.location(19,43);
					match(input,NIL,FOLLOW_NIL_in_v113); dbg.location(19,47);
					System.out.println(",");
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(19, 72);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "v");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "v"

	// Delegated rules



	public static final BitSet FOLLOW_a_in_prog22 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_v_in_a52 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_7_in_a56 = new BitSet(new long[]{0x00000000000000D0L});
	public static final BitSet FOLLOW_a_in_a59 = new BitSet(new long[]{0x0000000000000700L});
	public static final BitSet FOLLOW_x_in_a61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_x69 = new BitSet(new long[]{0x00000000000000D0L});
	public static final BitSet FOLLOW_a_in_x73 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_x75 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_s_in_x81 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_x83 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_s92 = new BitSet(new long[]{0x00000000000000D0L});
	public static final BitSet FOLLOW_a_in_s96 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_s_in_s98 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_v108 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NIL_in_v113 = new BitSet(new long[]{0x0000000000000002L});
}
