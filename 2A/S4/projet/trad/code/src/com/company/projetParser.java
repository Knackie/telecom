// $ANTLR 3.5.2 .\\src\\com\\company\\projet.g 2020-01-20 16:56:51
package com.company;

import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class projetParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARGLIST", "BLOC", "BOOLEEN", 
		"COMMENT", "CSTE_BOOLEEN", "CSTE_ENT", "CSTE_STR", "EMPTY", "ESC_SEQ", 
		"FUNCDECL", "FUNCDECLISTE", "HEX_DIGIT", "ID", "IDF", "IF_COND", "IF_ELSE", 
		"IF_THEN", "INSTR_AFFECT", "INSTR_FUNC_APPEL", "INSTR_IF", "INSTR_READ", 
		"INSTR_RETURN", "INSTR_WHILE", "INSTR_WRITE", "INT", "NEWLINE", "OCTAL_ESC", 
		"RANGE", "RANGELIST", "REFARG", "ROOT", "STRING", "TAB_ACCESS", "UNICODE_ESC", 
		"VALARG", "VARDECL", "VARDECLISTE", "WHILE_COND", "WHILE_DO", "WS", "'!='", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'..'", "'/'", "':'", "';'", 
		"'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'['", "']'", "'^'", "'and'", 
		"'array'", "'bool'", "'do'", "'else'", "'function'", "'if'", "'int'", 
		"'not'", "'of'", "'or'", "'program'", "'read'", "'ref'", "'return'", "'then'", 
		"'var'", "'void'", "'while'", "'write'", "'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int T__65=65;
	public static final int T__66=66;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__70=70;
	public static final int T__71=71;
	public static final int T__72=72;
	public static final int T__73=73;
	public static final int T__74=74;
	public static final int T__75=75;
	public static final int T__76=76;
	public static final int T__77=77;
	public static final int T__78=78;
	public static final int T__79=79;
	public static final int T__80=80;
	public static final int T__81=81;
	public static final int T__82=82;
	public static final int T__83=83;
	public static final int T__84=84;
	public static final int T__85=85;
	public static final int ARGLIST=4;
	public static final int BLOC=5;
	public static final int BOOLEEN=6;
	public static final int COMMENT=7;
	public static final int CSTE_BOOLEEN=8;
	public static final int CSTE_ENT=9;
	public static final int CSTE_STR=10;
	public static final int EMPTY=11;
	public static final int ESC_SEQ=12;
	public static final int FUNCDECL=13;
	public static final int FUNCDECLISTE=14;
	public static final int HEX_DIGIT=15;
	public static final int ID=16;
	public static final int IDF=17;
	public static final int IF_COND=18;
	public static final int IF_ELSE=19;
	public static final int IF_THEN=20;
	public static final int INSTR_AFFECT=21;
	public static final int INSTR_FUNC_APPEL=22;
	public static final int INSTR_IF=23;
	public static final int INSTR_READ=24;
	public static final int INSTR_RETURN=25;
	public static final int INSTR_WHILE=26;
	public static final int INSTR_WRITE=27;
	public static final int INT=28;
	public static final int NEWLINE=29;
	public static final int OCTAL_ESC=30;
	public static final int RANGE=31;
	public static final int RANGELIST=32;
	public static final int REFARG=33;
	public static final int ROOT=34;
	public static final int STRING=35;
	public static final int TAB_ACCESS=36;
	public static final int UNICODE_ESC=37;
	public static final int VALARG=38;
	public static final int VARDECL=39;
	public static final int VARDECLISTE=40;
	public static final int WHILE_COND=41;
	public static final int WHILE_DO=42;
	public static final int WS=43;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public projetParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public projetParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return projetParser.tokenNames; }
	@Override public String getGrammarFileName() { return ".\\src\\com\\company\\projet.g"; }


	/** Map variable name to Integer object holding value */
	HashMap<String,Integer>  memory = new HashMap<String,Integer>();


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// .\\src\\com\\company\\projet.g:49:1: program : 'program' ID vardeclist fundeclist instr -> ^( ID vardeclist fundeclist instr ) ;
	public final projetParser.program_return program() throws RecognitionException {
		projetParser.program_return retval = new projetParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal1=null;
		Token ID2=null;
		ParserRuleReturnScope vardeclist3 =null;
		ParserRuleReturnScope fundeclist4 =null;
		ParserRuleReturnScope instr5 =null;

		Object string_literal1_tree=null;
		Object ID2_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
		RewriteRuleSubtreeStream stream_vardeclist=new RewriteRuleSubtreeStream(adaptor,"rule vardeclist");
		RewriteRuleSubtreeStream stream_instr=new RewriteRuleSubtreeStream(adaptor,"rule instr");
		RewriteRuleSubtreeStream stream_fundeclist=new RewriteRuleSubtreeStream(adaptor,"rule fundeclist");

		try {
			// .\\src\\com\\company\\projet.g:49:9: ( 'program' ID vardeclist fundeclist instr -> ^( ID vardeclist fundeclist instr ) )
			// .\\src\\com\\company\\projet.g:49:11: 'program' ID vardeclist fundeclist instr
			{
			string_literal1=(Token)match(input,75,FOLLOW_75_in_program162);  
			stream_75.add(string_literal1);

			ID2=(Token)match(input,ID,FOLLOW_ID_in_program164);  
			stream_ID.add(ID2);

			pushFollow(FOLLOW_vardeclist_in_program166);
			vardeclist3=vardeclist();
			state._fsp--;

			stream_vardeclist.add(vardeclist3.getTree());
			pushFollow(FOLLOW_fundeclist_in_program168);
			fundeclist4=fundeclist();
			state._fsp--;

			stream_fundeclist.add(fundeclist4.getTree());
			pushFollow(FOLLOW_instr_in_program170);
			instr5=instr();
			state._fsp--;

			stream_instr.add(instr5.getTree());
			// AST REWRITE
			// elements: vardeclist, fundeclist, ID, instr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 49:52: -> ^( ID vardeclist fundeclist instr )
			{
				// .\\src\\com\\company\\projet.g:49:55: ^( ID vardeclist fundeclist instr )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_ID.nextNode(), root_1);
				adaptor.addChild(root_1, stream_vardeclist.nextTree());
				adaptor.addChild(root_1, stream_fundeclist.nextTree());
				adaptor.addChild(root_1, stream_instr.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"


	public static class vardeclist_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "vardeclist"
	// .\\src\\com\\company\\projet.g:51:1: vardeclist : ( vardecl )* -> ^( VARDECLISTE ( vardecl )* ) ;
	public final projetParser.vardeclist_return vardeclist() throws RecognitionException {
		projetParser.vardeclist_return retval = new projetParser.vardeclist_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope vardecl6 =null;

		RewriteRuleSubtreeStream stream_vardecl=new RewriteRuleSubtreeStream(adaptor,"rule vardecl");

		try {
			// .\\src\\com\\company\\projet.g:52:2: ( ( vardecl )* -> ^( VARDECLISTE ( vardecl )* ) )
			// .\\src\\com\\company\\projet.g:52:4: ( vardecl )*
			{
			// .\\src\\com\\company\\projet.g:52:4: ( vardecl )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==80) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// .\\src\\com\\company\\projet.g:52:5: vardecl
					{
					pushFollow(FOLLOW_vardecl_in_vardeclist193);
					vardecl6=vardecl();
					state._fsp--;

					stream_vardecl.add(vardecl6.getTree());
					}
					break;

				default :
					break loop1;
				}
			}

			// AST REWRITE
			// elements: vardecl
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 52:15: -> ^( VARDECLISTE ( vardecl )* )
			{
				// .\\src\\com\\company\\projet.g:52:18: ^( VARDECLISTE ( vardecl )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARDECLISTE, "VARDECLISTE"), root_1);
				// .\\src\\com\\company\\projet.g:52:32: ( vardecl )*
				while ( stream_vardecl.hasNext() ) {
					adaptor.addChild(root_1, stream_vardecl.nextTree());
				}
				stream_vardecl.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "vardeclist"


	public static class vardecl_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "vardecl"
	// .\\src\\com\\company\\projet.g:53:1: vardecl : 'var' identlist ':' typename ';' -> ^( VARDECL typename identlist ) ;
	public final projetParser.vardecl_return vardecl() throws RecognitionException {
		projetParser.vardecl_return retval = new projetParser.vardecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal7=null;
		Token char_literal9=null;
		Token char_literal11=null;
		ParserRuleReturnScope identlist8 =null;
		ParserRuleReturnScope typename10 =null;

		Object string_literal7_tree=null;
		Object char_literal9_tree=null;
		Object char_literal11_tree=null;
		RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_identlist=new RewriteRuleSubtreeStream(adaptor,"rule identlist");
		RewriteRuleSubtreeStream stream_typename=new RewriteRuleSubtreeStream(adaptor,"rule typename");

		try {
			// .\\src\\com\\company\\projet.g:54:2: ( 'var' identlist ':' typename ';' -> ^( VARDECL typename identlist ) )
			// .\\src\\com\\company\\projet.g:54:4: 'var' identlist ':' typename ';'
			{
			string_literal7=(Token)match(input,80,FOLLOW_80_in_vardecl212);  
			stream_80.add(string_literal7);

			pushFollow(FOLLOW_identlist_in_vardecl214);
			identlist8=identlist();
			state._fsp--;

			stream_identlist.add(identlist8.getTree());
			char_literal9=(Token)match(input,53,FOLLOW_53_in_vardecl216);  
			stream_53.add(char_literal9);

			pushFollow(FOLLOW_typename_in_vardecl218);
			typename10=typename();
			state._fsp--;

			stream_typename.add(typename10.getTree());
			char_literal11=(Token)match(input,54,FOLLOW_54_in_vardecl220);  
			stream_54.add(char_literal11);

			// AST REWRITE
			// elements: identlist, typename
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 54:37: -> ^( VARDECL typename identlist )
			{
				// .\\src\\com\\company\\projet.g:54:40: ^( VARDECL typename identlist )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARDECL, "VARDECL"), root_1);
				adaptor.addChild(root_1, stream_typename.nextTree());
				adaptor.addChild(root_1, stream_identlist.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "vardecl"


	public static class identlist_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "identlist"
	// .\\src\\com\\company\\projet.g:55:1: identlist : ID identlist2 ;
	public final projetParser.identlist_return identlist() throws RecognitionException {
		projetParser.identlist_return retval = new projetParser.identlist_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID12=null;
		ParserRuleReturnScope identlist213 =null;

		Object ID12_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:56:2: ( ID identlist2 )
			// .\\src\\com\\company\\projet.g:56:4: ID identlist2
			{
			root_0 = (Object)adaptor.nil();


			ID12=(Token)match(input,ID,FOLLOW_ID_in_identlist238); 
			ID12_tree = (Object)adaptor.create(ID12);
			adaptor.addChild(root_0, ID12_tree);

			pushFollow(FOLLOW_identlist2_in_identlist240);
			identlist213=identlist2();
			state._fsp--;

			adaptor.addChild(root_0, identlist213.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "identlist"


	public static class identlist2_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "identlist2"
	// .\\src\\com\\company\\projet.g:57:1: identlist2 : (| ',' ! identlist );
	public final projetParser.identlist2_return identlist2() throws RecognitionException {
		projetParser.identlist2_return retval = new projetParser.identlist2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal14=null;
		ParserRuleReturnScope identlist15 =null;

		Object char_literal14_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:58:2: (| ',' ! identlist )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==53) ) {
				alt2=1;
			}
			else if ( (LA2_0==49) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// .\\src\\com\\company\\projet.g:59:2: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:59:4: ',' ! identlist
					{
					root_0 = (Object)adaptor.nil();


					char_literal14=(Token)match(input,49,FOLLOW_49_in_identlist2251); 
					pushFollow(FOLLOW_identlist_in_identlist2254);
					identlist15=identlist();
					state._fsp--;

					adaptor.addChild(root_0, identlist15.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "identlist2"


	public static class typename_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "typename"
	// .\\src\\com\\company\\projet.g:60:1: typename : ( atomtype | arraytype );
	public final projetParser.typename_return typename() throws RecognitionException {
		projetParser.typename_return retval = new projetParser.typename_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope atomtype16 =null;
		ParserRuleReturnScope arraytype17 =null;


		try {
			// .\\src\\com\\company\\projet.g:60:9: ( atomtype | arraytype )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==66||LA3_0==71||LA3_0==81) ) {
				alt3=1;
			}
			else if ( (LA3_0==65) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// .\\src\\com\\company\\projet.g:60:11: atomtype
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomtype_in_typename260);
					atomtype16=atomtype();
					state._fsp--;

					adaptor.addChild(root_0, atomtype16.getTree());

					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:61:4: arraytype
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_arraytype_in_typename265);
					arraytype17=arraytype();
					state._fsp--;

					adaptor.addChild(root_0, arraytype17.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "typename"


	public static class atomtype_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atomtype"
	// .\\src\\com\\company\\projet.g:63:1: atomtype : ( 'void' | 'bool' | 'int' );
	public final projetParser.atomtype_return atomtype() throws RecognitionException {
		projetParser.atomtype_return retval = new projetParser.atomtype_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set18=null;

		Object set18_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:63:9: ( 'void' | 'bool' | 'int' )
			// .\\src\\com\\company\\projet.g:
			{
			root_0 = (Object)adaptor.nil();


			set18=input.LT(1);
			if ( input.LA(1)==66||input.LA(1)==71||input.LA(1)==81 ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set18));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atomtype"


	public static class arraytype_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "arraytype"
	// .\\src\\com\\company\\projet.g:67:1: arraytype : 'array' '[' rangelist ']' 'of' atomtype -> ^( 'array' atomtype rangelist ) ;
	public final projetParser.arraytype_return arraytype() throws RecognitionException {
		projetParser.arraytype_return retval = new projetParser.arraytype_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal19=null;
		Token char_literal20=null;
		Token char_literal22=null;
		Token string_literal23=null;
		ParserRuleReturnScope rangelist21 =null;
		ParserRuleReturnScope atomtype24 =null;

		Object string_literal19_tree=null;
		Object char_literal20_tree=null;
		Object char_literal22_tree=null;
		Object string_literal23_tree=null;
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_rangelist=new RewriteRuleSubtreeStream(adaptor,"rule rangelist");
		RewriteRuleSubtreeStream stream_atomtype=new RewriteRuleSubtreeStream(adaptor,"rule atomtype");

		try {
			// .\\src\\com\\company\\projet.g:68:2: ( 'array' '[' rangelist ']' 'of' atomtype -> ^( 'array' atomtype rangelist ) )
			// .\\src\\com\\company\\projet.g:68:4: 'array' '[' rangelist ']' 'of' atomtype
			{
			string_literal19=(Token)match(input,65,FOLLOW_65_in_arraytype291);  
			stream_65.add(string_literal19);

			char_literal20=(Token)match(input,61,FOLLOW_61_in_arraytype293);  
			stream_61.add(char_literal20);

			pushFollow(FOLLOW_rangelist_in_arraytype295);
			rangelist21=rangelist();
			state._fsp--;

			stream_rangelist.add(rangelist21.getTree());
			char_literal22=(Token)match(input,62,FOLLOW_62_in_arraytype297);  
			stream_62.add(char_literal22);

			string_literal23=(Token)match(input,73,FOLLOW_73_in_arraytype299);  
			stream_73.add(string_literal23);

			pushFollow(FOLLOW_atomtype_in_arraytype301);
			atomtype24=atomtype();
			state._fsp--;

			stream_atomtype.add(atomtype24.getTree());
			// AST REWRITE
			// elements: rangelist, atomtype, 65
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 68:44: -> ^( 'array' atomtype rangelist )
			{
				// .\\src\\com\\company\\projet.g:68:47: ^( 'array' atomtype rangelist )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_65.nextNode(), root_1);
				adaptor.addChild(root_1, stream_atomtype.nextTree());
				adaptor.addChild(root_1, stream_rangelist.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "arraytype"


	public static class rangelist_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rangelist"
	// .\\src\\com\\company\\projet.g:69:1: rangelist : cste '..' cste ( ',' cste '..' cste )* -> ^( RANGELIST ( ^( RANGE cste cste ) )+ ) ;
	public final projetParser.rangelist_return rangelist() throws RecognitionException {
		projetParser.rangelist_return retval = new projetParser.rangelist_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal26=null;
		Token char_literal28=null;
		Token string_literal30=null;
		ParserRuleReturnScope cste25 =null;
		ParserRuleReturnScope cste27 =null;
		ParserRuleReturnScope cste29 =null;
		ParserRuleReturnScope cste31 =null;

		Object string_literal26_tree=null;
		Object char_literal28_tree=null;
		Object string_literal30_tree=null;
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleSubtreeStream stream_cste=new RewriteRuleSubtreeStream(adaptor,"rule cste");

		try {
			// .\\src\\com\\company\\projet.g:70:2: ( cste '..' cste ( ',' cste '..' cste )* -> ^( RANGELIST ( ^( RANGE cste cste ) )+ ) )
			// .\\src\\com\\company\\projet.g:70:5: cste '..' cste ( ',' cste '..' cste )*
			{
			pushFollow(FOLLOW_cste_in_rangelist320);
			cste25=cste();
			state._fsp--;

			stream_cste.add(cste25.getTree());
			string_literal26=(Token)match(input,51,FOLLOW_51_in_rangelist322);  
			stream_51.add(string_literal26);

			pushFollow(FOLLOW_cste_in_rangelist324);
			cste27=cste();
			state._fsp--;

			stream_cste.add(cste27.getTree());
			// .\\src\\com\\company\\projet.g:70:20: ( ',' cste '..' cste )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==49) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// .\\src\\com\\company\\projet.g:70:21: ',' cste '..' cste
					{
					char_literal28=(Token)match(input,49,FOLLOW_49_in_rangelist327);  
					stream_49.add(char_literal28);

					pushFollow(FOLLOW_cste_in_rangelist329);
					cste29=cste();
					state._fsp--;

					stream_cste.add(cste29.getTree());
					string_literal30=(Token)match(input,51,FOLLOW_51_in_rangelist331);  
					stream_51.add(string_literal30);

					pushFollow(FOLLOW_cste_in_rangelist333);
					cste31=cste();
					state._fsp--;

					stream_cste.add(cste31.getTree());
					}
					break;

				default :
					break loop4;
				}
			}

			// AST REWRITE
			// elements: cste, cste
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 70:43: -> ^( RANGELIST ( ^( RANGE cste cste ) )+ )
			{
				// .\\src\\com\\company\\projet.g:70:46: ^( RANGELIST ( ^( RANGE cste cste ) )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RANGELIST, "RANGELIST"), root_1);
				if ( !(stream_cste.hasNext()||stream_cste.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_cste.hasNext()||stream_cste.hasNext() ) {
					// .\\src\\com\\company\\projet.g:70:58: ^( RANGE cste cste )
					{
					Object root_2 = (Object)adaptor.nil();
					root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(RANGE, "RANGE"), root_2);
					adaptor.addChild(root_2, stream_cste.nextTree());
					adaptor.addChild(root_2, stream_cste.nextTree());
					adaptor.addChild(root_1, root_2);
					}

				}
				stream_cste.reset();
				stream_cste.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rangelist"


	public static class fundeclist_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fundeclist"
	// .\\src\\com\\company\\projet.g:71:1: fundeclist : ( fundecl )* -> ^( FUNCDECLISTE ( fundecl )* ) ;
	public final projetParser.fundeclist_return fundeclist() throws RecognitionException {
		projetParser.fundeclist_return retval = new projetParser.fundeclist_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope fundecl32 =null;

		RewriteRuleSubtreeStream stream_fundecl=new RewriteRuleSubtreeStream(adaptor,"rule fundecl");

		try {
			// .\\src\\com\\company\\projet.g:72:2: ( ( fundecl )* -> ^( FUNCDECLISTE ( fundecl )* ) )
			// .\\src\\com\\company\\projet.g:72:4: ( fundecl )*
			{
			// .\\src\\com\\company\\projet.g:72:4: ( fundecl )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==69) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// .\\src\\com\\company\\projet.g:72:5: fundecl
					{
					pushFollow(FOLLOW_fundecl_in_fundeclist364);
					fundecl32=fundecl();
					state._fsp--;

					stream_fundecl.add(fundecl32.getTree());
					}
					break;

				default :
					break loop5;
				}
			}

			// AST REWRITE
			// elements: fundecl
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 72:15: -> ^( FUNCDECLISTE ( fundecl )* )
			{
				// .\\src\\com\\company\\projet.g:72:18: ^( FUNCDECLISTE ( fundecl )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCDECLISTE, "FUNCDECLISTE"), root_1);
				// .\\src\\com\\company\\projet.g:72:33: ( fundecl )*
				while ( stream_fundecl.hasNext() ) {
					adaptor.addChild(root_1, stream_fundecl.nextTree());
				}
				stream_fundecl.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "fundeclist"


	public static class fundecl_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fundecl"
	// .\\src\\com\\company\\projet.g:73:1: fundecl : 'function' ID '(' arglist ')' ':' atomtype vardeclist block -> ^( FUNCDECL ID arglist atomtype vardeclist block ) ;
	public final projetParser.fundecl_return fundecl() throws RecognitionException {
		projetParser.fundecl_return retval = new projetParser.fundecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal33=null;
		Token ID34=null;
		Token char_literal35=null;
		Token char_literal37=null;
		Token char_literal38=null;
		ParserRuleReturnScope arglist36 =null;
		ParserRuleReturnScope atomtype39 =null;
		ParserRuleReturnScope vardeclist40 =null;
		ParserRuleReturnScope block41 =null;

		Object string_literal33_tree=null;
		Object ID34_tree=null;
		Object char_literal35_tree=null;
		Object char_literal37_tree=null;
		Object char_literal38_tree=null;
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_vardeclist=new RewriteRuleSubtreeStream(adaptor,"rule vardeclist");
		RewriteRuleSubtreeStream stream_arglist=new RewriteRuleSubtreeStream(adaptor,"rule arglist");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
		RewriteRuleSubtreeStream stream_atomtype=new RewriteRuleSubtreeStream(adaptor,"rule atomtype");

		try {
			// .\\src\\com\\company\\projet.g:73:9: ( 'function' ID '(' arglist ')' ':' atomtype vardeclist block -> ^( FUNCDECL ID arglist atomtype vardeclist block ) )
			// .\\src\\com\\company\\projet.g:73:11: 'function' ID '(' arglist ')' ':' atomtype vardeclist block
			{
			string_literal33=(Token)match(input,69,FOLLOW_69_in_fundecl382);  
			stream_69.add(string_literal33);

			ID34=(Token)match(input,ID,FOLLOW_ID_in_fundecl384);  
			stream_ID.add(ID34);

			char_literal35=(Token)match(input,45,FOLLOW_45_in_fundecl386);  
			stream_45.add(char_literal35);

			pushFollow(FOLLOW_arglist_in_fundecl388);
			arglist36=arglist();
			state._fsp--;

			stream_arglist.add(arglist36.getTree());
			char_literal37=(Token)match(input,46,FOLLOW_46_in_fundecl390);  
			stream_46.add(char_literal37);

			char_literal38=(Token)match(input,53,FOLLOW_53_in_fundecl392);  
			stream_53.add(char_literal38);

			pushFollow(FOLLOW_atomtype_in_fundecl394);
			atomtype39=atomtype();
			state._fsp--;

			stream_atomtype.add(atomtype39.getTree());
			pushFollow(FOLLOW_vardeclist_in_fundecl396);
			vardeclist40=vardeclist();
			state._fsp--;

			stream_vardeclist.add(vardeclist40.getTree());
			pushFollow(FOLLOW_block_in_fundecl398);
			block41=block();
			state._fsp--;

			stream_block.add(block41.getTree());
			// AST REWRITE
			// elements: atomtype, arglist, ID, vardeclist, block
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 73:71: -> ^( FUNCDECL ID arglist atomtype vardeclist block )
			{
				// .\\src\\com\\company\\projet.g:73:74: ^( FUNCDECL ID arglist atomtype vardeclist block )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCDECL, "FUNCDECL"), root_1);
				adaptor.addChild(root_1, stream_ID.nextNode());
				adaptor.addChild(root_1, stream_arglist.nextTree());
				adaptor.addChild(root_1, stream_atomtype.nextTree());
				adaptor.addChild(root_1, stream_vardeclist.nextTree());
				adaptor.addChild(root_1, stream_block.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "fundecl"


	public static class arglist_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "arglist"
	// .\\src\\com\\company\\projet.g:74:1: arglist : ( -> ^( ARGLIST ) | arg ( ',' arg )* -> ^( ARGLIST ( arg )+ ) );
	public final projetParser.arglist_return arglist() throws RecognitionException {
		projetParser.arglist_return retval = new projetParser.arglist_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal43=null;
		ParserRuleReturnScope arg42 =null;
		ParserRuleReturnScope arg44 =null;

		Object char_literal43_tree=null;
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleSubtreeStream stream_arg=new RewriteRuleSubtreeStream(adaptor,"rule arg");

		try {
			// .\\src\\com\\company\\projet.g:74:9: ( -> ^( ARGLIST ) | arg ( ',' arg )* -> ^( ARGLIST ( arg )+ ) )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==46) ) {
				alt7=1;
			}
			else if ( (LA7_0==ID||LA7_0==77) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// .\\src\\com\\company\\projet.g:74:11: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 74:11: -> ^( ARGLIST )
					{
						// .\\src\\com\\company\\projet.g:74:14: ^( ARGLIST )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGLIST, "ARGLIST"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:75:4: arg ( ',' arg )*
					{
					pushFollow(FOLLOW_arg_in_arglist431);
					arg42=arg();
					state._fsp--;

					stream_arg.add(arg42.getTree());
					// .\\src\\com\\company\\projet.g:75:8: ( ',' arg )*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==49) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// .\\src\\com\\company\\projet.g:75:9: ',' arg
							{
							char_literal43=(Token)match(input,49,FOLLOW_49_in_arglist434);  
							stream_49.add(char_literal43);

							pushFollow(FOLLOW_arg_in_arglist436);
							arg44=arg();
							state._fsp--;

							stream_arg.add(arg44.getTree());
							}
							break;

						default :
							break loop6;
						}
					}

					// AST REWRITE
					// elements: arg
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 75:19: -> ^( ARGLIST ( arg )+ )
					{
						// .\\src\\com\\company\\projet.g:75:22: ^( ARGLIST ( arg )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGLIST, "ARGLIST"), root_1);
						if ( !(stream_arg.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_arg.hasNext() ) {
							adaptor.addChild(root_1, stream_arg.nextTree());
						}
						stream_arg.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "arglist"


	public static class arg_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "arg"
	// .\\src\\com\\company\\projet.g:77:1: arg : ( ID ':' typename -> ^( VALARG typename ID ) | 'ref' ID ':' typename -> ^( REFARG typename ID ) );
	public final projetParser.arg_return arg() throws RecognitionException {
		projetParser.arg_return retval = new projetParser.arg_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID45=null;
		Token char_literal46=null;
		Token string_literal48=null;
		Token ID49=null;
		Token char_literal50=null;
		ParserRuleReturnScope typename47 =null;
		ParserRuleReturnScope typename51 =null;

		Object ID45_tree=null;
		Object char_literal46_tree=null;
		Object string_literal48_tree=null;
		Object ID49_tree=null;
		Object char_literal50_tree=null;
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_typename=new RewriteRuleSubtreeStream(adaptor,"rule typename");

		try {
			// .\\src\\com\\company\\projet.g:77:5: ( ID ':' typename -> ^( VALARG typename ID ) | 'ref' ID ':' typename -> ^( REFARG typename ID ) )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==ID) ) {
				alt8=1;
			}
			else if ( (LA8_0==77) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// .\\src\\com\\company\\projet.g:77:7: ID ':' typename
					{
					ID45=(Token)match(input,ID,FOLLOW_ID_in_arg455);  
					stream_ID.add(ID45);

					char_literal46=(Token)match(input,53,FOLLOW_53_in_arg457);  
					stream_53.add(char_literal46);

					pushFollow(FOLLOW_typename_in_arg459);
					typename47=typename();
					state._fsp--;

					stream_typename.add(typename47.getTree());
					// AST REWRITE
					// elements: typename, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 77:24: -> ^( VALARG typename ID )
					{
						// .\\src\\com\\company\\projet.g:77:26: ^( VALARG typename ID )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VALARG, "VALARG"), root_1);
						adaptor.addChild(root_1, stream_typename.nextTree());
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:78:4: 'ref' ID ':' typename
					{
					string_literal48=(Token)match(input,77,FOLLOW_77_in_arg474);  
					stream_77.add(string_literal48);

					ID49=(Token)match(input,ID,FOLLOW_ID_in_arg476);  
					stream_ID.add(ID49);

					char_literal50=(Token)match(input,53,FOLLOW_53_in_arg478);  
					stream_53.add(char_literal50);

					pushFollow(FOLLOW_typename_in_arg480);
					typename51=typename();
					state._fsp--;

					stream_typename.add(typename51.getTree());
					// AST REWRITE
					// elements: typename, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 78:26: -> ^( REFARG typename ID )
					{
						// .\\src\\com\\company\\projet.g:78:28: ^( REFARG typename ID )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(REFARG, "REFARG"), root_1);
						adaptor.addChild(root_1, stream_typename.nextTree());
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "arg"


	public static class instr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "instr"
	// .\\src\\com\\company\\projet.g:80:1: instr : ( 'if' expr 'then' instr ( options {greedy=true; } : 'else' instr )? -> ^( INSTR_IF ^( IF_COND expr ) ^( IF_THEN instr ) ( ^( IF_ELSE instr ) )? ) | 'while' expr 'do' instr -> ^( INSTR_WHILE ^( WHILE_COND expr ) ^( WHILE_DO instr ) ) | 'return' ( expr )? -> ^( INSTR_RETURN ( expr )? ) | block | ID ( ( lvalue '=' expr -> ^( INSTR_AFFECT ^( TAB_ACCESS ID lvalue ) expr ) | '=' expr -> ^( INSTR_AFFECT ^( IDF ID ) expr ) ) | '(' ( exprlist )? ')' -> ^( INSTR_FUNC_APPEL ID ( exprlist )? ) ) | 'write' instr5 -> ^( INSTR_WRITE instr5 ) | 'read' ID ( lvalue -> ^( INSTR_READ ^( TAB_ACCESS ID lvalue ) ) | -> ^( INSTR_READ ID ) ) );
	public final projetParser.instr_return instr() throws RecognitionException {
		projetParser.instr_return retval = new projetParser.instr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal52=null;
		Token string_literal54=null;
		Token string_literal56=null;
		Token string_literal58=null;
		Token string_literal60=null;
		Token string_literal62=null;
		Token ID65=null;
		Token char_literal67=null;
		Token char_literal69=null;
		Token char_literal71=null;
		Token char_literal73=null;
		Token string_literal74=null;
		Token string_literal76=null;
		Token ID77=null;
		ParserRuleReturnScope expr53 =null;
		ParserRuleReturnScope instr55 =null;
		ParserRuleReturnScope instr57 =null;
		ParserRuleReturnScope expr59 =null;
		ParserRuleReturnScope instr61 =null;
		ParserRuleReturnScope expr63 =null;
		ParserRuleReturnScope block64 =null;
		ParserRuleReturnScope lvalue66 =null;
		ParserRuleReturnScope expr68 =null;
		ParserRuleReturnScope expr70 =null;
		ParserRuleReturnScope exprlist72 =null;
		ParserRuleReturnScope instr575 =null;
		ParserRuleReturnScope lvalue78 =null;

		Object string_literal52_tree=null;
		Object string_literal54_tree=null;
		Object string_literal56_tree=null;
		Object string_literal58_tree=null;
		Object string_literal60_tree=null;
		Object string_literal62_tree=null;
		Object ID65_tree=null;
		Object char_literal67_tree=null;
		Object char_literal69_tree=null;
		Object char_literal71_tree=null;
		Object char_literal73_tree=null;
		Object string_literal74_tree=null;
		Object string_literal76_tree=null;
		Object ID77_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_lvalue=new RewriteRuleSubtreeStream(adaptor,"rule lvalue");
		RewriteRuleSubtreeStream stream_instr=new RewriteRuleSubtreeStream(adaptor,"rule instr");
		RewriteRuleSubtreeStream stream_exprlist=new RewriteRuleSubtreeStream(adaptor,"rule exprlist");
		RewriteRuleSubtreeStream stream_instr5=new RewriteRuleSubtreeStream(adaptor,"rule instr5");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// .\\src\\com\\company\\projet.g:80:8: ( 'if' expr 'then' instr ( options {greedy=true; } : 'else' instr )? -> ^( INSTR_IF ^( IF_COND expr ) ^( IF_THEN instr ) ( ^( IF_ELSE instr ) )? ) | 'while' expr 'do' instr -> ^( INSTR_WHILE ^( WHILE_COND expr ) ^( WHILE_DO instr ) ) | 'return' ( expr )? -> ^( INSTR_RETURN ( expr )? ) | block | ID ( ( lvalue '=' expr -> ^( INSTR_AFFECT ^( TAB_ACCESS ID lvalue ) expr ) | '=' expr -> ^( INSTR_AFFECT ^( IDF ID ) expr ) ) | '(' ( exprlist )? ')' -> ^( INSTR_FUNC_APPEL ID ( exprlist )? ) ) | 'write' instr5 -> ^( INSTR_WRITE instr5 ) | 'read' ID ( lvalue -> ^( INSTR_READ ^( TAB_ACCESS ID lvalue ) ) | -> ^( INSTR_READ ID ) ) )
			int alt15=7;
			switch ( input.LA(1) ) {
			case 70:
				{
				alt15=1;
				}
				break;
			case 82:
				{
				alt15=2;
				}
				break;
			case 78:
				{
				alt15=3;
				}
				break;
			case 84:
				{
				alt15=4;
				}
				break;
			case ID:
				{
				alt15=5;
				}
				break;
			case 83:
				{
				alt15=6;
				}
				break;
			case 76:
				{
				alt15=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// .\\src\\com\\company\\projet.g:80:10: 'if' expr 'then' instr ( options {greedy=true; } : 'else' instr )?
					{
					string_literal52=(Token)match(input,70,FOLLOW_70_in_instr498);  
					stream_70.add(string_literal52);

					pushFollow(FOLLOW_expr_in_instr500);
					expr53=expr();
					state._fsp--;

					stream_expr.add(expr53.getTree());
					string_literal54=(Token)match(input,79,FOLLOW_79_in_instr502);  
					stream_79.add(string_literal54);

					pushFollow(FOLLOW_instr_in_instr504);
					instr55=instr();
					state._fsp--;

					stream_instr.add(instr55.getTree());
					// .\\src\\com\\company\\projet.g:80:33: ( options {greedy=true; } : 'else' instr )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==68) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// .\\src\\com\\company\\projet.g:80:61: 'else' instr
							{
							string_literal56=(Token)match(input,68,FOLLOW_68_in_instr518);  
							stream_68.add(string_literal56);

							pushFollow(FOLLOW_instr_in_instr520);
							instr57=instr();
							state._fsp--;

							stream_instr.add(instr57.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: instr, expr, instr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 80:76: -> ^( INSTR_IF ^( IF_COND expr ) ^( IF_THEN instr ) ( ^( IF_ELSE instr ) )? )
					{
						// .\\src\\com\\company\\projet.g:80:79: ^( INSTR_IF ^( IF_COND expr ) ^( IF_THEN instr ) ( ^( IF_ELSE instr ) )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INSTR_IF, "INSTR_IF"), root_1);
						// .\\src\\com\\company\\projet.g:80:90: ^( IF_COND expr )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_COND, "IF_COND"), root_2);
						adaptor.addChild(root_2, stream_expr.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// .\\src\\com\\company\\projet.g:80:106: ^( IF_THEN instr )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_THEN, "IF_THEN"), root_2);
						adaptor.addChild(root_2, stream_instr.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// .\\src\\com\\company\\projet.g:80:123: ( ^( IF_ELSE instr ) )?
						if ( stream_instr.hasNext() ) {
							// .\\src\\com\\company\\projet.g:80:123: ^( IF_ELSE instr )
							{
							Object root_2 = (Object)adaptor.nil();
							root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_ELSE, "IF_ELSE"), root_2);
							adaptor.addChild(root_2, stream_instr.nextTree());
							adaptor.addChild(root_1, root_2);
							}

						}
						stream_instr.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:81:4: 'while' expr 'do' instr
					{
					string_literal58=(Token)match(input,82,FOLLOW_82_in_instr552);  
					stream_82.add(string_literal58);

					pushFollow(FOLLOW_expr_in_instr554);
					expr59=expr();
					state._fsp--;

					stream_expr.add(expr59.getTree());
					string_literal60=(Token)match(input,67,FOLLOW_67_in_instr556);  
					stream_67.add(string_literal60);

					pushFollow(FOLLOW_instr_in_instr558);
					instr61=instr();
					state._fsp--;

					stream_instr.add(instr61.getTree());
					// AST REWRITE
					// elements: instr, expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 81:28: -> ^( INSTR_WHILE ^( WHILE_COND expr ) ^( WHILE_DO instr ) )
					{
						// .\\src\\com\\company\\projet.g:81:31: ^( INSTR_WHILE ^( WHILE_COND expr ) ^( WHILE_DO instr ) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INSTR_WHILE, "INSTR_WHILE"), root_1);
						// .\\src\\com\\company\\projet.g:81:45: ^( WHILE_COND expr )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE_COND, "WHILE_COND"), root_2);
						adaptor.addChild(root_2, stream_expr.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// .\\src\\com\\company\\projet.g:81:64: ^( WHILE_DO instr )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE_DO, "WHILE_DO"), root_2);
						adaptor.addChild(root_2, stream_instr.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// .\\src\\com\\company\\projet.g:82:4: 'return' ( expr )?
					{
					string_literal62=(Token)match(input,78,FOLLOW_78_in_instr581);  
					stream_78.add(string_literal62);

					// .\\src\\com\\company\\projet.g:82:13: ( expr )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==BOOLEEN||LA10_0==ID||LA10_0==INT||LA10_0==45||LA10_0==50||LA10_0==72) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// .\\src\\com\\company\\projet.g:82:13: expr
							{
							pushFollow(FOLLOW_expr_in_instr583);
							expr63=expr();
							state._fsp--;

							stream_expr.add(expr63.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 82:19: -> ^( INSTR_RETURN ( expr )? )
					{
						// .\\src\\com\\company\\projet.g:82:22: ^( INSTR_RETURN ( expr )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INSTR_RETURN, "INSTR_RETURN"), root_1);
						// .\\src\\com\\company\\projet.g:82:37: ( expr )?
						if ( stream_expr.hasNext() ) {
							adaptor.addChild(root_1, stream_expr.nextTree());
						}
						stream_expr.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// .\\src\\com\\company\\projet.g:83:4: block
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_block_in_instr598);
					block64=block();
					state._fsp--;

					adaptor.addChild(root_0, block64.getTree());

					}
					break;
				case 5 :
					// .\\src\\com\\company\\projet.g:84:4: ID ( ( lvalue '=' expr -> ^( INSTR_AFFECT ^( TAB_ACCESS ID lvalue ) expr ) | '=' expr -> ^( INSTR_AFFECT ^( IDF ID ) expr ) ) | '(' ( exprlist )? ')' -> ^( INSTR_FUNC_APPEL ID ( exprlist )? ) )
					{
					ID65=(Token)match(input,ID,FOLLOW_ID_in_instr603);  
					stream_ID.add(ID65);

					// .\\src\\com\\company\\projet.g:84:7: ( ( lvalue '=' expr -> ^( INSTR_AFFECT ^( TAB_ACCESS ID lvalue ) expr ) | '=' expr -> ^( INSTR_AFFECT ^( IDF ID ) expr ) ) | '(' ( exprlist )? ')' -> ^( INSTR_FUNC_APPEL ID ( exprlist )? ) )
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==57||LA13_0==61) ) {
						alt13=1;
					}
					else if ( (LA13_0==45) ) {
						alt13=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 13, 0, input);
						throw nvae;
					}

					switch (alt13) {
						case 1 :
							// .\\src\\com\\company\\projet.g:85:3: ( lvalue '=' expr -> ^( INSTR_AFFECT ^( TAB_ACCESS ID lvalue ) expr ) | '=' expr -> ^( INSTR_AFFECT ^( IDF ID ) expr ) )
							{
							// .\\src\\com\\company\\projet.g:85:3: ( lvalue '=' expr -> ^( INSTR_AFFECT ^( TAB_ACCESS ID lvalue ) expr ) | '=' expr -> ^( INSTR_AFFECT ^( IDF ID ) expr ) )
							int alt11=2;
							int LA11_0 = input.LA(1);
							if ( (LA11_0==61) ) {
								alt11=1;
							}
							else if ( (LA11_0==57) ) {
								alt11=2;
							}

							else {
								NoViableAltException nvae =
									new NoViableAltException("", 11, 0, input);
								throw nvae;
							}

							switch (alt11) {
								case 1 :
									// .\\src\\com\\company\\projet.g:86:4: lvalue '=' expr
									{
									pushFollow(FOLLOW_lvalue_in_instr617);
									lvalue66=lvalue();
									state._fsp--;

									stream_lvalue.add(lvalue66.getTree());
									char_literal67=(Token)match(input,57,FOLLOW_57_in_instr619);  
									stream_57.add(char_literal67);

									pushFollow(FOLLOW_expr_in_instr621);
									expr68=expr();
									state._fsp--;

									stream_expr.add(expr68.getTree());
									// AST REWRITE
									// elements: lvalue, ID, expr
									// token labels: 
									// rule labels: retval
									// token list labels: 
									// rule list labels: 
									// wildcard labels: 
									retval.tree = root_0;
									RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

									root_0 = (Object)adaptor.nil();
									// 86:20: -> ^( INSTR_AFFECT ^( TAB_ACCESS ID lvalue ) expr )
									{
										// .\\src\\com\\company\\projet.g:86:23: ^( INSTR_AFFECT ^( TAB_ACCESS ID lvalue ) expr )
										{
										Object root_1 = (Object)adaptor.nil();
										root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INSTR_AFFECT, "INSTR_AFFECT"), root_1);
										// .\\src\\com\\company\\projet.g:86:38: ^( TAB_ACCESS ID lvalue )
										{
										Object root_2 = (Object)adaptor.nil();
										root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(TAB_ACCESS, "TAB_ACCESS"), root_2);
										adaptor.addChild(root_2, stream_ID.nextNode());
										adaptor.addChild(root_2, stream_lvalue.nextTree());
										adaptor.addChild(root_1, root_2);
										}

										adaptor.addChild(root_1, stream_expr.nextTree());
										adaptor.addChild(root_0, root_1);
										}

									}


									retval.tree = root_0;

									}
									break;
								case 2 :
									// .\\src\\com\\company\\projet.g:87:7: '=' expr
									{
									char_literal69=(Token)match(input,57,FOLLOW_57_in_instr649);  
									stream_57.add(char_literal69);

									pushFollow(FOLLOW_expr_in_instr651);
									expr70=expr();
									state._fsp--;

									stream_expr.add(expr70.getTree());
									// AST REWRITE
									// elements: ID, expr
									// token labels: 
									// rule labels: retval
									// token list labels: 
									// rule list labels: 
									// wildcard labels: 
									retval.tree = root_0;
									RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

									root_0 = (Object)adaptor.nil();
									// 87:16: -> ^( INSTR_AFFECT ^( IDF ID ) expr )
									{
										// .\\src\\com\\company\\projet.g:87:19: ^( INSTR_AFFECT ^( IDF ID ) expr )
										{
										Object root_1 = (Object)adaptor.nil();
										root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INSTR_AFFECT, "INSTR_AFFECT"), root_1);
										// .\\src\\com\\company\\projet.g:87:34: ^( IDF ID )
										{
										Object root_2 = (Object)adaptor.nil();
										root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDF, "IDF"), root_2);
										adaptor.addChild(root_2, stream_ID.nextNode());
										adaptor.addChild(root_1, root_2);
										}

										adaptor.addChild(root_1, stream_expr.nextTree());
										adaptor.addChild(root_0, root_1);
										}

									}


									retval.tree = root_0;

									}
									break;

							}

							}
							break;
						case 2 :
							// .\\src\\com\\company\\projet.g:89:5: '(' ( exprlist )? ')'
							{
							char_literal71=(Token)match(input,45,FOLLOW_45_in_instr676);  
							stream_45.add(char_literal71);

							// .\\src\\com\\company\\projet.g:89:9: ( exprlist )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==BOOLEEN||LA12_0==ID||LA12_0==INT||LA12_0==45||LA12_0==50||LA12_0==72) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// .\\src\\com\\company\\projet.g:89:9: exprlist
									{
									pushFollow(FOLLOW_exprlist_in_instr678);
									exprlist72=exprlist();
									state._fsp--;

									stream_exprlist.add(exprlist72.getTree());
									}
									break;

							}

							char_literal73=(Token)match(input,46,FOLLOW_46_in_instr681);  
							stream_46.add(char_literal73);

							// AST REWRITE
							// elements: ID, exprlist
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 89:23: -> ^( INSTR_FUNC_APPEL ID ( exprlist )? )
							{
								// .\\src\\com\\company\\projet.g:89:26: ^( INSTR_FUNC_APPEL ID ( exprlist )? )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INSTR_FUNC_APPEL, "INSTR_FUNC_APPEL"), root_1);
								adaptor.addChild(root_1, stream_ID.nextNode());
								// .\\src\\com\\company\\projet.g:89:48: ( exprlist )?
								if ( stream_exprlist.hasNext() ) {
									adaptor.addChild(root_1, stream_exprlist.nextTree());
								}
								stream_exprlist.reset();

								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;

					}

					}
					break;
				case 6 :
					// .\\src\\com\\company\\projet.g:91:4: 'write' instr5
					{
					string_literal74=(Token)match(input,83,FOLLOW_83_in_instr701);  
					stream_83.add(string_literal74);

					pushFollow(FOLLOW_instr5_in_instr703);
					instr575=instr5();
					state._fsp--;

					stream_instr5.add(instr575.getTree());
					// AST REWRITE
					// elements: instr5
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 91:19: -> ^( INSTR_WRITE instr5 )
					{
						// .\\src\\com\\company\\projet.g:91:22: ^( INSTR_WRITE instr5 )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INSTR_WRITE, "INSTR_WRITE"), root_1);
						adaptor.addChild(root_1, stream_instr5.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					// .\\src\\com\\company\\projet.g:92:4: 'read' ID ( lvalue -> ^( INSTR_READ ^( TAB_ACCESS ID lvalue ) ) | -> ^( INSTR_READ ID ) )
					{
					string_literal76=(Token)match(input,76,FOLLOW_76_in_instr716);  
					stream_76.add(string_literal76);

					ID77=(Token)match(input,ID,FOLLOW_ID_in_instr718);  
					stream_ID.add(ID77);

					// .\\src\\com\\company\\projet.g:92:14: ( lvalue -> ^( INSTR_READ ^( TAB_ACCESS ID lvalue ) ) | -> ^( INSTR_READ ID ) )
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==61) ) {
						alt14=1;
					}
					else if ( (LA14_0==EOF||LA14_0==54||LA14_0==68||LA14_0==85) ) {
						alt14=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}

					switch (alt14) {
						case 1 :
							// .\\src\\com\\company\\projet.g:93:3: lvalue
							{
							pushFollow(FOLLOW_lvalue_in_instr724);
							lvalue78=lvalue();
							state._fsp--;

							stream_lvalue.add(lvalue78.getTree());
							// AST REWRITE
							// elements: lvalue, ID
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 93:10: -> ^( INSTR_READ ^( TAB_ACCESS ID lvalue ) )
							{
								// .\\src\\com\\company\\projet.g:93:13: ^( INSTR_READ ^( TAB_ACCESS ID lvalue ) )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INSTR_READ, "INSTR_READ"), root_1);
								// .\\src\\com\\company\\projet.g:93:26: ^( TAB_ACCESS ID lvalue )
								{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(TAB_ACCESS, "TAB_ACCESS"), root_2);
								adaptor.addChild(root_2, stream_ID.nextNode());
								adaptor.addChild(root_2, stream_lvalue.nextTree());
								adaptor.addChild(root_1, root_2);
								}

								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							// .\\src\\com\\company\\projet.g:94:5: 
							{
							// AST REWRITE
							// elements: ID
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 94:5: -> ^( INSTR_READ ID )
							{
								// .\\src\\com\\company\\projet.g:94:8: ^( INSTR_READ ID )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INSTR_READ, "INSTR_READ"), root_1);
								adaptor.addChild(root_1, stream_ID.nextNode());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "instr"


	public static class instr5_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "instr5"
	// .\\src\\com\\company\\projet.g:97:1: instr5 : ( ID ( lvalue -> ^( TAB_ACCESS ID lvalue ) | -> ^( IDF ID ) ) | cste );
	public final projetParser.instr5_return instr5() throws RecognitionException {
		projetParser.instr5_return retval = new projetParser.instr5_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID79=null;
		ParserRuleReturnScope lvalue80 =null;
		ParserRuleReturnScope cste81 =null;

		Object ID79_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_lvalue=new RewriteRuleSubtreeStream(adaptor,"rule lvalue");

		try {
			// .\\src\\com\\company\\projet.g:97:9: ( ID ( lvalue -> ^( TAB_ACCESS ID lvalue ) | -> ^( IDF ID ) ) | cste )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==ID) ) {
				alt17=1;
			}
			else if ( (LA17_0==BOOLEEN||LA17_0==INT||LA17_0==STRING||LA17_0==50) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// .\\src\\com\\company\\projet.g:97:11: ID ( lvalue -> ^( TAB_ACCESS ID lvalue ) | -> ^( IDF ID ) )
					{
					ID79=(Token)match(input,ID,FOLLOW_ID_in_instr5763);  
					stream_ID.add(ID79);

					// .\\src\\com\\company\\projet.g:97:14: ( lvalue -> ^( TAB_ACCESS ID lvalue ) | -> ^( IDF ID ) )
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==61) ) {
						alt16=1;
					}
					else if ( (LA16_0==EOF||LA16_0==54||LA16_0==68||LA16_0==85) ) {
						alt16=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						throw nvae;
					}

					switch (alt16) {
						case 1 :
							// .\\src\\com\\company\\projet.g:98:3: lvalue
							{
							pushFollow(FOLLOW_lvalue_in_instr5769);
							lvalue80=lvalue();
							state._fsp--;

							stream_lvalue.add(lvalue80.getTree());
							// AST REWRITE
							// elements: ID, lvalue
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 98:10: -> ^( TAB_ACCESS ID lvalue )
							{
								// .\\src\\com\\company\\projet.g:98:13: ^( TAB_ACCESS ID lvalue )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TAB_ACCESS, "TAB_ACCESS"), root_1);
								adaptor.addChild(root_1, stream_ID.nextNode());
								adaptor.addChild(root_1, stream_lvalue.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							// .\\src\\com\\company\\projet.g:99:5: 
							{
							// AST REWRITE
							// elements: ID
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 99:5: -> ^( IDF ID )
							{
								// .\\src\\com\\company\\projet.g:99:8: ^( IDF ID )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDF, "IDF"), root_1);
								adaptor.addChild(root_1, stream_ID.nextNode());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;

					}

					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:101:4: cste
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_cste_in_instr5799);
					cste81=cste();
					state._fsp--;

					adaptor.addChild(root_0, cste81.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "instr5"


	public static class sequence_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "sequence"
	// .\\src\\com\\company\\projet.g:103:1: sequence : instr sequence2 ;
	public final projetParser.sequence_return sequence() throws RecognitionException {
		projetParser.sequence_return retval = new projetParser.sequence_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope instr82 =null;
		ParserRuleReturnScope sequence283 =null;


		try {
			// .\\src\\com\\company\\projet.g:104:2: ( instr sequence2 )
			// .\\src\\com\\company\\projet.g:104:5: instr sequence2
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_instr_in_sequence809);
			instr82=instr();
			state._fsp--;

			adaptor.addChild(root_0, instr82.getTree());

			pushFollow(FOLLOW_sequence2_in_sequence811);
			sequence283=sequence2();
			state._fsp--;

			adaptor.addChild(root_0, sequence283.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "sequence"


	public static class sequence2_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "sequence2"
	// .\\src\\com\\company\\projet.g:105:1: sequence2 : (| ';' ! sequence3 );
	public final projetParser.sequence2_return sequence2() throws RecognitionException {
		projetParser.sequence2_return retval = new projetParser.sequence2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal84=null;
		ParserRuleReturnScope sequence385 =null;

		Object char_literal84_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:106:2: (| ';' ! sequence3 )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==85) ) {
				alt18=1;
			}
			else if ( (LA18_0==54) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// .\\src\\com\\company\\projet.g:107:2: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:107:4: ';' ! sequence3
					{
					root_0 = (Object)adaptor.nil();


					char_literal84=(Token)match(input,54,FOLLOW_54_in_sequence2823); 
					pushFollow(FOLLOW_sequence3_in_sequence2826);
					sequence385=sequence3();
					state._fsp--;

					adaptor.addChild(root_0, sequence385.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "sequence2"


	public static class sequence3_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "sequence3"
	// .\\src\\com\\company\\projet.g:108:1: sequence3 : (| sequence );
	public final projetParser.sequence3_return sequence3() throws RecognitionException {
		projetParser.sequence3_return retval = new projetParser.sequence3_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope sequence86 =null;


		try {
			// .\\src\\com\\company\\projet.g:109:2: (| sequence )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==85) ) {
				alt19=1;
			}
			else if ( (LA19_0==ID||LA19_0==70||LA19_0==76||LA19_0==78||(LA19_0 >= 82 && LA19_0 <= 84)) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// .\\src\\com\\company\\projet.g:110:2: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:110:4: sequence
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_sequence_in_sequence3837);
					sequence86=sequence();
					state._fsp--;

					adaptor.addChild(root_0, sequence86.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "sequence3"


	public static class lvalue_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lvalue"
	// .\\src\\com\\company\\projet.g:111:1: lvalue : '[' ! exprlist ']' !;
	public final projetParser.lvalue_return lvalue() throws RecognitionException {
		projetParser.lvalue_return retval = new projetParser.lvalue_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal87=null;
		Token char_literal89=null;
		ParserRuleReturnScope exprlist88 =null;

		Object char_literal87_tree=null;
		Object char_literal89_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:111:9: ( '[' ! exprlist ']' !)
			// .\\src\\com\\company\\projet.g:112:3: '[' ! exprlist ']' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal87=(Token)match(input,61,FOLLOW_61_in_lvalue848); 
			pushFollow(FOLLOW_exprlist_in_lvalue851);
			exprlist88=exprlist();
			state._fsp--;

			adaptor.addChild(root_0, exprlist88.getTree());

			char_literal89=(Token)match(input,62,FOLLOW_62_in_lvalue853); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lvalue"


	public static class exprlist_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprlist"
	// .\\src\\com\\company\\projet.g:113:1: exprlist : expr exprlist2 ;
	public final projetParser.exprlist_return exprlist() throws RecognitionException {
		projetParser.exprlist_return retval = new projetParser.exprlist_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope expr90 =null;
		ParserRuleReturnScope exprlist291 =null;


		try {
			// .\\src\\com\\company\\projet.g:114:2: ( expr exprlist2 )
			// .\\src\\com\\company\\projet.g:114:5: expr exprlist2
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_in_exprlist863);
			expr90=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr90.getTree());

			pushFollow(FOLLOW_exprlist2_in_exprlist865);
			exprlist291=exprlist2();
			state._fsp--;

			adaptor.addChild(root_0, exprlist291.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exprlist"


	public static class exprlist2_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprlist2"
	// .\\src\\com\\company\\projet.g:115:1: exprlist2 : (| ',' ! exprlist );
	public final projetParser.exprlist2_return exprlist2() throws RecognitionException {
		projetParser.exprlist2_return retval = new projetParser.exprlist2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal92=null;
		ParserRuleReturnScope exprlist93 =null;

		Object char_literal92_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:116:2: (| ',' ! exprlist )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==46||LA20_0==62) ) {
				alt20=1;
			}
			else if ( (LA20_0==49) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// .\\src\\com\\company\\projet.g:117:2: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:117:4: ',' ! exprlist
					{
					root_0 = (Object)adaptor.nil();


					char_literal92=(Token)match(input,49,FOLLOW_49_in_exprlist2876); 
					pushFollow(FOLLOW_exprlist_in_exprlist2879);
					exprlist93=exprlist();
					state._fsp--;

					adaptor.addChild(root_0, exprlist93.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exprlist2"


	public static class expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// .\\src\\com\\company\\projet.g:118:1: expr : expr_ou ;
	public final projetParser.expr_return expr() throws RecognitionException {
		projetParser.expr_return retval = new projetParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope expr_ou94 =null;


		try {
			// .\\src\\com\\company\\projet.g:118:7: ( expr_ou )
			// .\\src\\com\\company\\projet.g:118:10: expr_ou
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_ou_in_expr888);
			expr_ou94=expr_ou();
			state._fsp--;

			adaptor.addChild(root_0, expr_ou94.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class exprlist3_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprlist3"
	// .\\src\\com\\company\\projet.g:119:1: exprlist3 : (| exprlist );
	public final projetParser.exprlist3_return exprlist3() throws RecognitionException {
		projetParser.exprlist3_return retval = new projetParser.exprlist3_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope exprlist95 =null;


		try {
			// .\\src\\com\\company\\projet.g:120:2: (| exprlist )
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==46) ) {
				alt21=1;
			}
			else if ( (LA21_0==BOOLEEN||LA21_0==ID||LA21_0==INT||LA21_0==45||LA21_0==50||LA21_0==72) ) {
				alt21=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// .\\src\\com\\company\\projet.g:121:2: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:121:4: exprlist
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_exprlist_in_exprlist3900);
					exprlist95=exprlist();
					state._fsp--;

					adaptor.addChild(root_0, exprlist95.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exprlist3"


	public static class atom_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// .\\src\\com\\company\\projet.g:123:1: atom : ( INT -> ^( CSTE_ENT INT ) | BOOLEEN -> ^( CSTE_BOOLEEN BOOLEEN ) | ID ( '[' exprlist ']' -> ^( TAB_ACCESS ID exprlist ) | '(' exprlist3 ')' -> ^( INSTR_FUNC_APPEL ID exprlist3 ) | -> ^( IDF ID ) ) | '(' ! expr ')' !);
	public final projetParser.atom_return atom() throws RecognitionException {
		projetParser.atom_return retval = new projetParser.atom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INT96=null;
		Token BOOLEEN97=null;
		Token ID98=null;
		Token char_literal99=null;
		Token char_literal101=null;
		Token char_literal102=null;
		Token char_literal104=null;
		Token char_literal105=null;
		Token char_literal107=null;
		ParserRuleReturnScope exprlist100 =null;
		ParserRuleReturnScope exprlist3103 =null;
		ParserRuleReturnScope expr106 =null;

		Object INT96_tree=null;
		Object BOOLEEN97_tree=null;
		Object ID98_tree=null;
		Object char_literal99_tree=null;
		Object char_literal101_tree=null;
		Object char_literal102_tree=null;
		Object char_literal104_tree=null;
		Object char_literal105_tree=null;
		Object char_literal107_tree=null;
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_BOOLEEN=new RewriteRuleTokenStream(adaptor,"token BOOLEEN");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
		RewriteRuleSubtreeStream stream_exprlist3=new RewriteRuleSubtreeStream(adaptor,"rule exprlist3");
		RewriteRuleSubtreeStream stream_exprlist=new RewriteRuleSubtreeStream(adaptor,"rule exprlist");

		try {
			// .\\src\\com\\company\\projet.g:123:7: ( INT -> ^( CSTE_ENT INT ) | BOOLEEN -> ^( CSTE_BOOLEEN BOOLEEN ) | ID ( '[' exprlist ']' -> ^( TAB_ACCESS ID exprlist ) | '(' exprlist3 ')' -> ^( INSTR_FUNC_APPEL ID exprlist3 ) | -> ^( IDF ID ) ) | '(' ! expr ')' !)
			int alt23=4;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt23=1;
				}
				break;
			case BOOLEEN:
				{
				alt23=2;
				}
				break;
			case ID:
				{
				alt23=3;
				}
				break;
			case 45:
				{
				alt23=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}
			switch (alt23) {
				case 1 :
					// .\\src\\com\\company\\projet.g:123:9: INT
					{
					INT96=(Token)match(input,INT,FOLLOW_INT_in_atom909);  
					stream_INT.add(INT96);

					// AST REWRITE
					// elements: INT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 123:14: -> ^( CSTE_ENT INT )
					{
						// .\\src\\com\\company\\projet.g:123:17: ^( CSTE_ENT INT )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CSTE_ENT, "CSTE_ENT"), root_1);
						adaptor.addChild(root_1, stream_INT.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:124:4: BOOLEEN
					{
					BOOLEEN97=(Token)match(input,BOOLEEN,FOLLOW_BOOLEEN_in_atom923);  
					stream_BOOLEEN.add(BOOLEEN97);

					// AST REWRITE
					// elements: BOOLEEN
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 124:12: -> ^( CSTE_BOOLEEN BOOLEEN )
					{
						// .\\src\\com\\company\\projet.g:124:15: ^( CSTE_BOOLEEN BOOLEEN )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CSTE_BOOLEEN, "CSTE_BOOLEEN"), root_1);
						adaptor.addChild(root_1, stream_BOOLEEN.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// .\\src\\com\\company\\projet.g:125:4: ID ( '[' exprlist ']' -> ^( TAB_ACCESS ID exprlist ) | '(' exprlist3 ')' -> ^( INSTR_FUNC_APPEL ID exprlist3 ) | -> ^( IDF ID ) )
					{
					ID98=(Token)match(input,ID,FOLLOW_ID_in_atom936);  
					stream_ID.add(ID98);

					// .\\src\\com\\company\\projet.g:125:7: ( '[' exprlist ']' -> ^( TAB_ACCESS ID exprlist ) | '(' exprlist3 ')' -> ^( INSTR_FUNC_APPEL ID exprlist3 ) | -> ^( IDF ID ) )
					int alt22=3;
					switch ( input.LA(1) ) {
					case 61:
						{
						alt22=1;
						}
						break;
					case 45:
						{
						alt22=2;
						}
						break;
					case EOF:
					case 44:
					case 46:
					case 47:
					case 48:
					case 49:
					case 50:
					case 52:
					case 54:
					case 55:
					case 56:
					case 58:
					case 59:
					case 60:
					case 62:
					case 63:
					case 64:
					case 67:
					case 68:
					case 74:
					case 79:
					case 85:
						{
						alt22=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 22, 0, input);
						throw nvae;
					}
					switch (alt22) {
						case 1 :
							// .\\src\\com\\company\\projet.g:125:9: '[' exprlist ']'
							{
							char_literal99=(Token)match(input,61,FOLLOW_61_in_atom940);  
							stream_61.add(char_literal99);

							pushFollow(FOLLOW_exprlist_in_atom941);
							exprlist100=exprlist();
							state._fsp--;

							stream_exprlist.add(exprlist100.getTree());
							char_literal101=(Token)match(input,62,FOLLOW_62_in_atom942);  
							stream_62.add(char_literal101);

							// AST REWRITE
							// elements: exprlist, ID
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 125:24: -> ^( TAB_ACCESS ID exprlist )
							{
								// .\\src\\com\\company\\projet.g:125:26: ^( TAB_ACCESS ID exprlist )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TAB_ACCESS, "TAB_ACCESS"), root_1);
								adaptor.addChild(root_1, stream_ID.nextNode());
								adaptor.addChild(root_1, stream_exprlist.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							// .\\src\\com\\company\\projet.g:126:5: '(' exprlist3 ')'
							{
							char_literal102=(Token)match(input,45,FOLLOW_45_in_atom957);  
							stream_45.add(char_literal102);

							pushFollow(FOLLOW_exprlist3_in_atom958);
							exprlist3103=exprlist3();
							state._fsp--;

							stream_exprlist3.add(exprlist3103.getTree());
							char_literal104=(Token)match(input,46,FOLLOW_46_in_atom959);  
							stream_46.add(char_literal104);

							// AST REWRITE
							// elements: exprlist3, ID
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 126:21: -> ^( INSTR_FUNC_APPEL ID exprlist3 )
							{
								// .\\src\\com\\company\\projet.g:126:23: ^( INSTR_FUNC_APPEL ID exprlist3 )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INSTR_FUNC_APPEL, "INSTR_FUNC_APPEL"), root_1);
								adaptor.addChild(root_1, stream_ID.nextNode());
								adaptor.addChild(root_1, stream_exprlist3.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 3 :
							// .\\src\\com\\company\\projet.g:127:5: 
							{
							// AST REWRITE
							// elements: ID
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 127:5: -> ^( IDF ID )
							{
								// .\\src\\com\\company\\projet.g:127:7: ^( IDF ID )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDF, "IDF"), root_1);
								adaptor.addChild(root_1, stream_ID.nextNode());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;

					}

					}
					break;
				case 4 :
					// .\\src\\com\\company\\projet.g:128:4: '(' ! expr ')' !
					{
					root_0 = (Object)adaptor.nil();


					char_literal105=(Token)match(input,45,FOLLOW_45_in_atom986); 
					pushFollow(FOLLOW_expr_in_atom989);
					expr106=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr106.getTree());

					char_literal107=(Token)match(input,46,FOLLOW_46_in_atom991); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"


	public static class expr_moins_unaire_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_moins_unaire"
	// .\\src\\com\\company\\projet.g:130:1: expr_moins_unaire : ( '-' ^)* atom ;
	public final projetParser.expr_moins_unaire_return expr_moins_unaire() throws RecognitionException {
		projetParser.expr_moins_unaire_return retval = new projetParser.expr_moins_unaire_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal108=null;
		ParserRuleReturnScope atom109 =null;

		Object char_literal108_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:131:2: ( ( '-' ^)* atom )
			// .\\src\\com\\company\\projet.g:131:6: ( '-' ^)* atom
			{
			root_0 = (Object)adaptor.nil();


			// .\\src\\com\\company\\projet.g:131:6: ( '-' ^)*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==50) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// .\\src\\com\\company\\projet.g:131:7: '-' ^
					{
					char_literal108=(Token)match(input,50,FOLLOW_50_in_expr_moins_unaire1004); 
					char_literal108_tree = (Object)adaptor.create(char_literal108);
					root_0 = (Object)adaptor.becomeRoot(char_literal108_tree, root_0);

					}
					break;

				default :
					break loop24;
				}
			}

			pushFollow(FOLLOW_atom_in_expr_moins_unaire1009);
			atom109=atom();
			state._fsp--;

			adaptor.addChild(root_0, atom109.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_moins_unaire"


	public static class expr_puissance_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_puissance"
	// .\\src\\com\\company\\projet.g:132:1: expr_puissance : expr_moins_unaire ( '^' ^ expr_moins_unaire )* ;
	public final projetParser.expr_puissance_return expr_puissance() throws RecognitionException {
		projetParser.expr_puissance_return retval = new projetParser.expr_puissance_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal111=null;
		ParserRuleReturnScope expr_moins_unaire110 =null;
		ParserRuleReturnScope expr_moins_unaire112 =null;

		Object char_literal111_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:133:2: ( expr_moins_unaire ( '^' ^ expr_moins_unaire )* )
			// .\\src\\com\\company\\projet.g:133:5: expr_moins_unaire ( '^' ^ expr_moins_unaire )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_moins_unaire_in_expr_puissance1018);
			expr_moins_unaire110=expr_moins_unaire();
			state._fsp--;

			adaptor.addChild(root_0, expr_moins_unaire110.getTree());

			// .\\src\\com\\company\\projet.g:133:23: ( '^' ^ expr_moins_unaire )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==63) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// .\\src\\com\\company\\projet.g:133:24: '^' ^ expr_moins_unaire
					{
					char_literal111=(Token)match(input,63,FOLLOW_63_in_expr_puissance1021); 
					char_literal111_tree = (Object)adaptor.create(char_literal111);
					root_0 = (Object)adaptor.becomeRoot(char_literal111_tree, root_0);

					pushFollow(FOLLOW_expr_moins_unaire_in_expr_puissance1024);
					expr_moins_unaire112=expr_moins_unaire();
					state._fsp--;

					adaptor.addChild(root_0, expr_moins_unaire112.getTree());

					}
					break;

				default :
					break loop25;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_puissance"


	public static class expr_mult_div_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_mult_div"
	// .\\src\\com\\company\\projet.g:134:1: expr_mult_div : expr_puissance ( ( '*' ^ expr_puissance ) | ( '/' ^ expr_puissance ) )* ;
	public final projetParser.expr_mult_div_return expr_mult_div() throws RecognitionException {
		projetParser.expr_mult_div_return retval = new projetParser.expr_mult_div_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal114=null;
		Token char_literal116=null;
		ParserRuleReturnScope expr_puissance113 =null;
		ParserRuleReturnScope expr_puissance115 =null;
		ParserRuleReturnScope expr_puissance117 =null;

		Object char_literal114_tree=null;
		Object char_literal116_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:135:2: ( expr_puissance ( ( '*' ^ expr_puissance ) | ( '/' ^ expr_puissance ) )* )
			// .\\src\\com\\company\\projet.g:135:5: expr_puissance ( ( '*' ^ expr_puissance ) | ( '/' ^ expr_puissance ) )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_puissance_in_expr_mult_div1035);
			expr_puissance113=expr_puissance();
			state._fsp--;

			adaptor.addChild(root_0, expr_puissance113.getTree());

			// .\\src\\com\\company\\projet.g:135:20: ( ( '*' ^ expr_puissance ) | ( '/' ^ expr_puissance ) )*
			loop26:
			while (true) {
				int alt26=3;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==47) ) {
					alt26=1;
				}
				else if ( (LA26_0==52) ) {
					alt26=2;
				}

				switch (alt26) {
				case 1 :
					// .\\src\\com\\company\\projet.g:135:21: ( '*' ^ expr_puissance )
					{
					// .\\src\\com\\company\\projet.g:135:21: ( '*' ^ expr_puissance )
					// .\\src\\com\\company\\projet.g:135:22: '*' ^ expr_puissance
					{
					char_literal114=(Token)match(input,47,FOLLOW_47_in_expr_mult_div1039); 
					char_literal114_tree = (Object)adaptor.create(char_literal114);
					root_0 = (Object)adaptor.becomeRoot(char_literal114_tree, root_0);

					pushFollow(FOLLOW_expr_puissance_in_expr_mult_div1042);
					expr_puissance115=expr_puissance();
					state._fsp--;

					adaptor.addChild(root_0, expr_puissance115.getTree());

					}

					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:135:45: ( '/' ^ expr_puissance )
					{
					// .\\src\\com\\company\\projet.g:135:45: ( '/' ^ expr_puissance )
					// .\\src\\com\\company\\projet.g:135:46: '/' ^ expr_puissance
					{
					char_literal116=(Token)match(input,52,FOLLOW_52_in_expr_mult_div1048); 
					char_literal116_tree = (Object)adaptor.create(char_literal116);
					root_0 = (Object)adaptor.becomeRoot(char_literal116_tree, root_0);

					pushFollow(FOLLOW_expr_puissance_in_expr_mult_div1051);
					expr_puissance117=expr_puissance();
					state._fsp--;

					adaptor.addChild(root_0, expr_puissance117.getTree());

					}

					}
					break;

				default :
					break loop26;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_mult_div"


	public static class expr_add_sous_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_add_sous"
	// .\\src\\com\\company\\projet.g:136:1: expr_add_sous : expr_mult_div ( ( '-' ^ expr_mult_div ) | ( '+' ^ expr_mult_div ) )* ;
	public final projetParser.expr_add_sous_return expr_add_sous() throws RecognitionException {
		projetParser.expr_add_sous_return retval = new projetParser.expr_add_sous_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal119=null;
		Token char_literal121=null;
		ParserRuleReturnScope expr_mult_div118 =null;
		ParserRuleReturnScope expr_mult_div120 =null;
		ParserRuleReturnScope expr_mult_div122 =null;

		Object char_literal119_tree=null;
		Object char_literal121_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:137:2: ( expr_mult_div ( ( '-' ^ expr_mult_div ) | ( '+' ^ expr_mult_div ) )* )
			// .\\src\\com\\company\\projet.g:137:5: expr_mult_div ( ( '-' ^ expr_mult_div ) | ( '+' ^ expr_mult_div ) )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_mult_div_in_expr_add_sous1063);
			expr_mult_div118=expr_mult_div();
			state._fsp--;

			adaptor.addChild(root_0, expr_mult_div118.getTree());

			// .\\src\\com\\company\\projet.g:137:19: ( ( '-' ^ expr_mult_div ) | ( '+' ^ expr_mult_div ) )*
			loop27:
			while (true) {
				int alt27=3;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==50) ) {
					alt27=1;
				}
				else if ( (LA27_0==48) ) {
					alt27=2;
				}

				switch (alt27) {
				case 1 :
					// .\\src\\com\\company\\projet.g:137:20: ( '-' ^ expr_mult_div )
					{
					// .\\src\\com\\company\\projet.g:137:20: ( '-' ^ expr_mult_div )
					// .\\src\\com\\company\\projet.g:137:21: '-' ^ expr_mult_div
					{
					char_literal119=(Token)match(input,50,FOLLOW_50_in_expr_add_sous1067); 
					char_literal119_tree = (Object)adaptor.create(char_literal119);
					root_0 = (Object)adaptor.becomeRoot(char_literal119_tree, root_0);

					pushFollow(FOLLOW_expr_mult_div_in_expr_add_sous1070);
					expr_mult_div120=expr_mult_div();
					state._fsp--;

					adaptor.addChild(root_0, expr_mult_div120.getTree());

					}

					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:137:43: ( '+' ^ expr_mult_div )
					{
					// .\\src\\com\\company\\projet.g:137:43: ( '+' ^ expr_mult_div )
					// .\\src\\com\\company\\projet.g:137:44: '+' ^ expr_mult_div
					{
					char_literal121=(Token)match(input,48,FOLLOW_48_in_expr_add_sous1076); 
					char_literal121_tree = (Object)adaptor.create(char_literal121);
					root_0 = (Object)adaptor.becomeRoot(char_literal121_tree, root_0);

					pushFollow(FOLLOW_expr_mult_div_in_expr_add_sous1079);
					expr_mult_div122=expr_mult_div();
					state._fsp--;

					adaptor.addChild(root_0, expr_mult_div122.getTree());

					}

					}
					break;

				default :
					break loop27;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_add_sous"


	public static class expr_comparaison_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_comparaison"
	// .\\src\\com\\company\\projet.g:138:1: expr_comparaison : expr_add_sous ( ( '>' ^ expr_add_sous ) | ( '<' ^ expr_add_sous ) | ( '<=' ^ expr_add_sous ) | ( '>=' ^ expr_add_sous ) | ( '==' ^ expr_add_sous ) | ( '!=' ^ expr_add_sous ) )* ;
	public final projetParser.expr_comparaison_return expr_comparaison() throws RecognitionException {
		projetParser.expr_comparaison_return retval = new projetParser.expr_comparaison_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal124=null;
		Token char_literal126=null;
		Token string_literal128=null;
		Token string_literal130=null;
		Token string_literal132=null;
		Token string_literal134=null;
		ParserRuleReturnScope expr_add_sous123 =null;
		ParserRuleReturnScope expr_add_sous125 =null;
		ParserRuleReturnScope expr_add_sous127 =null;
		ParserRuleReturnScope expr_add_sous129 =null;
		ParserRuleReturnScope expr_add_sous131 =null;
		ParserRuleReturnScope expr_add_sous133 =null;
		ParserRuleReturnScope expr_add_sous135 =null;

		Object char_literal124_tree=null;
		Object char_literal126_tree=null;
		Object string_literal128_tree=null;
		Object string_literal130_tree=null;
		Object string_literal132_tree=null;
		Object string_literal134_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:139:2: ( expr_add_sous ( ( '>' ^ expr_add_sous ) | ( '<' ^ expr_add_sous ) | ( '<=' ^ expr_add_sous ) | ( '>=' ^ expr_add_sous ) | ( '==' ^ expr_add_sous ) | ( '!=' ^ expr_add_sous ) )* )
			// .\\src\\com\\company\\projet.g:139:5: expr_add_sous ( ( '>' ^ expr_add_sous ) | ( '<' ^ expr_add_sous ) | ( '<=' ^ expr_add_sous ) | ( '>=' ^ expr_add_sous ) | ( '==' ^ expr_add_sous ) | ( '!=' ^ expr_add_sous ) )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_add_sous_in_expr_comparaison1091);
			expr_add_sous123=expr_add_sous();
			state._fsp--;

			adaptor.addChild(root_0, expr_add_sous123.getTree());

			// .\\src\\com\\company\\projet.g:139:18: ( ( '>' ^ expr_add_sous ) | ( '<' ^ expr_add_sous ) | ( '<=' ^ expr_add_sous ) | ( '>=' ^ expr_add_sous ) | ( '==' ^ expr_add_sous ) | ( '!=' ^ expr_add_sous ) )*
			loop28:
			while (true) {
				int alt28=7;
				switch ( input.LA(1) ) {
				case 59:
					{
					alt28=1;
					}
					break;
				case 55:
					{
					alt28=2;
					}
					break;
				case 56:
					{
					alt28=3;
					}
					break;
				case 60:
					{
					alt28=4;
					}
					break;
				case 58:
					{
					alt28=5;
					}
					break;
				case 44:
					{
					alt28=6;
					}
					break;
				}
				switch (alt28) {
				case 1 :
					// .\\src\\com\\company\\projet.g:139:19: ( '>' ^ expr_add_sous )
					{
					// .\\src\\com\\company\\projet.g:139:19: ( '>' ^ expr_add_sous )
					// .\\src\\com\\company\\projet.g:139:20: '>' ^ expr_add_sous
					{
					char_literal124=(Token)match(input,59,FOLLOW_59_in_expr_comparaison1094); 
					char_literal124_tree = (Object)adaptor.create(char_literal124);
					root_0 = (Object)adaptor.becomeRoot(char_literal124_tree, root_0);

					pushFollow(FOLLOW_expr_add_sous_in_expr_comparaison1097);
					expr_add_sous125=expr_add_sous();
					state._fsp--;

					adaptor.addChild(root_0, expr_add_sous125.getTree());

					}

					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:139:42: ( '<' ^ expr_add_sous )
					{
					// .\\src\\com\\company\\projet.g:139:42: ( '<' ^ expr_add_sous )
					// .\\src\\com\\company\\projet.g:139:43: '<' ^ expr_add_sous
					{
					char_literal126=(Token)match(input,55,FOLLOW_55_in_expr_comparaison1103); 
					char_literal126_tree = (Object)adaptor.create(char_literal126);
					root_0 = (Object)adaptor.becomeRoot(char_literal126_tree, root_0);

					pushFollow(FOLLOW_expr_add_sous_in_expr_comparaison1106);
					expr_add_sous127=expr_add_sous();
					state._fsp--;

					adaptor.addChild(root_0, expr_add_sous127.getTree());

					}

					}
					break;
				case 3 :
					// .\\src\\com\\company\\projet.g:139:65: ( '<=' ^ expr_add_sous )
					{
					// .\\src\\com\\company\\projet.g:139:65: ( '<=' ^ expr_add_sous )
					// .\\src\\com\\company\\projet.g:139:66: '<=' ^ expr_add_sous
					{
					string_literal128=(Token)match(input,56,FOLLOW_56_in_expr_comparaison1112); 
					string_literal128_tree = (Object)adaptor.create(string_literal128);
					root_0 = (Object)adaptor.becomeRoot(string_literal128_tree, root_0);

					pushFollow(FOLLOW_expr_add_sous_in_expr_comparaison1115);
					expr_add_sous129=expr_add_sous();
					state._fsp--;

					adaptor.addChild(root_0, expr_add_sous129.getTree());

					}

					}
					break;
				case 4 :
					// .\\src\\com\\company\\projet.g:139:89: ( '>=' ^ expr_add_sous )
					{
					// .\\src\\com\\company\\projet.g:139:89: ( '>=' ^ expr_add_sous )
					// .\\src\\com\\company\\projet.g:139:90: '>=' ^ expr_add_sous
					{
					string_literal130=(Token)match(input,60,FOLLOW_60_in_expr_comparaison1121); 
					string_literal130_tree = (Object)adaptor.create(string_literal130);
					root_0 = (Object)adaptor.becomeRoot(string_literal130_tree, root_0);

					pushFollow(FOLLOW_expr_add_sous_in_expr_comparaison1124);
					expr_add_sous131=expr_add_sous();
					state._fsp--;

					adaptor.addChild(root_0, expr_add_sous131.getTree());

					}

					}
					break;
				case 5 :
					// .\\src\\com\\company\\projet.g:139:113: ( '==' ^ expr_add_sous )
					{
					// .\\src\\com\\company\\projet.g:139:113: ( '==' ^ expr_add_sous )
					// .\\src\\com\\company\\projet.g:139:114: '==' ^ expr_add_sous
					{
					string_literal132=(Token)match(input,58,FOLLOW_58_in_expr_comparaison1130); 
					string_literal132_tree = (Object)adaptor.create(string_literal132);
					root_0 = (Object)adaptor.becomeRoot(string_literal132_tree, root_0);

					pushFollow(FOLLOW_expr_add_sous_in_expr_comparaison1133);
					expr_add_sous133=expr_add_sous();
					state._fsp--;

					adaptor.addChild(root_0, expr_add_sous133.getTree());

					}

					}
					break;
				case 6 :
					// .\\src\\com\\company\\projet.g:139:137: ( '!=' ^ expr_add_sous )
					{
					// .\\src\\com\\company\\projet.g:139:137: ( '!=' ^ expr_add_sous )
					// .\\src\\com\\company\\projet.g:139:138: '!=' ^ expr_add_sous
					{
					string_literal134=(Token)match(input,44,FOLLOW_44_in_expr_comparaison1139); 
					string_literal134_tree = (Object)adaptor.create(string_literal134);
					root_0 = (Object)adaptor.becomeRoot(string_literal134_tree, root_0);

					pushFollow(FOLLOW_expr_add_sous_in_expr_comparaison1142);
					expr_add_sous135=expr_add_sous();
					state._fsp--;

					adaptor.addChild(root_0, expr_add_sous135.getTree());

					}

					}
					break;

				default :
					break loop28;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_comparaison"


	public static class expr_non_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_non"
	// .\\src\\com\\company\\projet.g:140:1: expr_non : ( 'not' ^)* expr_comparaison ;
	public final projetParser.expr_non_return expr_non() throws RecognitionException {
		projetParser.expr_non_return retval = new projetParser.expr_non_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal136=null;
		ParserRuleReturnScope expr_comparaison137 =null;

		Object string_literal136_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:141:2: ( ( 'not' ^)* expr_comparaison )
			// .\\src\\com\\company\\projet.g:141:5: ( 'not' ^)* expr_comparaison
			{
			root_0 = (Object)adaptor.nil();


			// .\\src\\com\\company\\projet.g:141:5: ( 'not' ^)*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==72) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// .\\src\\com\\company\\projet.g:141:6: 'not' ^
					{
					string_literal136=(Token)match(input,72,FOLLOW_72_in_expr_non1155); 
					string_literal136_tree = (Object)adaptor.create(string_literal136);
					root_0 = (Object)adaptor.becomeRoot(string_literal136_tree, root_0);

					}
					break;

				default :
					break loop29;
				}
			}

			pushFollow(FOLLOW_expr_comparaison_in_expr_non1160);
			expr_comparaison137=expr_comparaison();
			state._fsp--;

			adaptor.addChild(root_0, expr_comparaison137.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_non"


	public static class expr_et_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_et"
	// .\\src\\com\\company\\projet.g:142:1: expr_et : expr_non ( 'and' ^ expr_non )* ;
	public final projetParser.expr_et_return expr_et() throws RecognitionException {
		projetParser.expr_et_return retval = new projetParser.expr_et_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal139=null;
		ParserRuleReturnScope expr_non138 =null;
		ParserRuleReturnScope expr_non140 =null;

		Object string_literal139_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:142:9: ( expr_non ( 'and' ^ expr_non )* )
			// .\\src\\com\\company\\projet.g:142:12: expr_non ( 'and' ^ expr_non )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_non_in_expr_et1168);
			expr_non138=expr_non();
			state._fsp--;

			adaptor.addChild(root_0, expr_non138.getTree());

			// .\\src\\com\\company\\projet.g:142:21: ( 'and' ^ expr_non )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==64) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// .\\src\\com\\company\\projet.g:142:22: 'and' ^ expr_non
					{
					string_literal139=(Token)match(input,64,FOLLOW_64_in_expr_et1171); 
					string_literal139_tree = (Object)adaptor.create(string_literal139);
					root_0 = (Object)adaptor.becomeRoot(string_literal139_tree, root_0);

					pushFollow(FOLLOW_expr_non_in_expr_et1174);
					expr_non140=expr_non();
					state._fsp--;

					adaptor.addChild(root_0, expr_non140.getTree());

					}
					break;

				default :
					break loop30;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_et"


	public static class expr_ou_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_ou"
	// .\\src\\com\\company\\projet.g:143:1: expr_ou : expr_et ( 'or' ^ expr_et )* ;
	public final projetParser.expr_ou_return expr_ou() throws RecognitionException {
		projetParser.expr_ou_return retval = new projetParser.expr_ou_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal142=null;
		ParserRuleReturnScope expr_et141 =null;
		ParserRuleReturnScope expr_et143 =null;

		Object string_literal142_tree=null;

		try {
			// .\\src\\com\\company\\projet.g:143:9: ( expr_et ( 'or' ^ expr_et )* )
			// .\\src\\com\\company\\projet.g:143:12: expr_et ( 'or' ^ expr_et )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_et_in_expr_ou1184);
			expr_et141=expr_et();
			state._fsp--;

			adaptor.addChild(root_0, expr_et141.getTree());

			// .\\src\\com\\company\\projet.g:143:20: ( 'or' ^ expr_et )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==74) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// .\\src\\com\\company\\projet.g:143:21: 'or' ^ expr_et
					{
					string_literal142=(Token)match(input,74,FOLLOW_74_in_expr_ou1187); 
					string_literal142_tree = (Object)adaptor.create(string_literal142);
					root_0 = (Object)adaptor.becomeRoot(string_literal142_tree, root_0);

					pushFollow(FOLLOW_expr_et_in_expr_ou1190);
					expr_et143=expr_et();
					state._fsp--;

					adaptor.addChild(root_0, expr_et143.getTree());

					}
					break;

				default :
					break loop31;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_ou"


	public static class block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "block"
	// .\\src\\com\\company\\projet.g:145:1: block : '{' seq -> ^( BLOC seq ) ;
	public final projetParser.block_return block() throws RecognitionException {
		projetParser.block_return retval = new projetParser.block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal144=null;
		ParserRuleReturnScope seq145 =null;

		Object char_literal144_tree=null;
		RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
		RewriteRuleSubtreeStream stream_seq=new RewriteRuleSubtreeStream(adaptor,"rule seq");

		try {
			// .\\src\\com\\company\\projet.g:145:8: ( '{' seq -> ^( BLOC seq ) )
			// .\\src\\com\\company\\projet.g:145:11: '{' seq
			{
			char_literal144=(Token)match(input,84,FOLLOW_84_in_block1202);  
			stream_84.add(char_literal144);

			pushFollow(FOLLOW_seq_in_block1204);
			seq145=seq();
			state._fsp--;

			stream_seq.add(seq145.getTree());
			// AST REWRITE
			// elements: seq
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 145:19: -> ^( BLOC seq )
			{
				// .\\src\\com\\company\\projet.g:145:22: ^( BLOC seq )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOC, "BLOC"), root_1);
				adaptor.addChild(root_1, stream_seq.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "block"


	public static class seq_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "seq"
	// .\\src\\com\\company\\projet.g:146:1: seq : ( sequence '}' !| '}' -> ^( EMPTY ) );
	public final projetParser.seq_return seq() throws RecognitionException {
		projetParser.seq_return retval = new projetParser.seq_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal147=null;
		Token char_literal148=null;
		ParserRuleReturnScope sequence146 =null;

		Object char_literal147_tree=null;
		Object char_literal148_tree=null;
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");

		try {
			// .\\src\\com\\company\\projet.g:146:6: ( sequence '}' !| '}' -> ^( EMPTY ) )
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==ID||LA32_0==70||LA32_0==76||LA32_0==78||(LA32_0 >= 82 && LA32_0 <= 84)) ) {
				alt32=1;
			}
			else if ( (LA32_0==85) ) {
				alt32=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}

			switch (alt32) {
				case 1 :
					// .\\src\\com\\company\\projet.g:146:9: sequence '}' !
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_sequence_in_seq1221);
					sequence146=sequence();
					state._fsp--;

					adaptor.addChild(root_0, sequence146.getTree());

					char_literal147=(Token)match(input,85,FOLLOW_85_in_seq1223); 
					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:146:25: '}'
					{
					char_literal148=(Token)match(input,85,FOLLOW_85_in_seq1228);  
					stream_85.add(char_literal148);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 146:29: -> ^( EMPTY )
					{
						// .\\src\\com\\company\\projet.g:146:32: ^( EMPTY )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EMPTY, "EMPTY"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "seq"


	public static class cste_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cste"
	// .\\src\\com\\company\\projet.g:148:1: cste : ( '-' INT -> ^( CSTE_ENT ^( '-' INT ) ) | INT -> ^( CSTE_ENT INT ) | BOOLEEN -> ^( CSTE_BOOLEEN BOOLEEN ) | STRING -> ^( CSTE_STR STRING ) );
	public final projetParser.cste_return cste() throws RecognitionException {
		projetParser.cste_return retval = new projetParser.cste_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal149=null;
		Token INT150=null;
		Token INT151=null;
		Token BOOLEEN152=null;
		Token STRING153=null;

		Object char_literal149_tree=null;
		Object INT150_tree=null;
		Object INT151_tree=null;
		Object BOOLEEN152_tree=null;
		Object STRING153_tree=null;
		RewriteRuleTokenStream stream_BOOLEEN=new RewriteRuleTokenStream(adaptor,"token BOOLEEN");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");

		try {
			// .\\src\\com\\company\\projet.g:148:7: ( '-' INT -> ^( CSTE_ENT ^( '-' INT ) ) | INT -> ^( CSTE_ENT INT ) | BOOLEEN -> ^( CSTE_BOOLEEN BOOLEEN ) | STRING -> ^( CSTE_STR STRING ) )
			int alt33=4;
			switch ( input.LA(1) ) {
			case 50:
				{
				alt33=1;
				}
				break;
			case INT:
				{
				alt33=2;
				}
				break;
			case BOOLEEN:
				{
				alt33=3;
				}
				break;
			case STRING:
				{
				alt33=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}
			switch (alt33) {
				case 1 :
					// .\\src\\com\\company\\projet.g:148:10: '-' INT
					{
					char_literal149=(Token)match(input,50,FOLLOW_50_in_cste1244);  
					stream_50.add(char_literal149);

					INT150=(Token)match(input,INT,FOLLOW_INT_in_cste1246);  
					stream_INT.add(INT150);

					// AST REWRITE
					// elements: 50, INT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 148:18: -> ^( CSTE_ENT ^( '-' INT ) )
					{
						// .\\src\\com\\company\\projet.g:148:21: ^( CSTE_ENT ^( '-' INT ) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CSTE_ENT, "CSTE_ENT"), root_1);
						// .\\src\\com\\company\\projet.g:148:32: ^( '-' INT )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot(stream_50.nextNode(), root_2);
						adaptor.addChild(root_2, stream_INT.nextNode());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:149:6: INT
					{
					INT151=(Token)match(input,INT,FOLLOW_INT_in_cste1265);  
					stream_INT.add(INT151);

					// AST REWRITE
					// elements: INT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 149:10: -> ^( CSTE_ENT INT )
					{
						// .\\src\\com\\company\\projet.g:149:13: ^( CSTE_ENT INT )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CSTE_ENT, "CSTE_ENT"), root_1);
						adaptor.addChild(root_1, stream_INT.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// .\\src\\com\\company\\projet.g:150:4: BOOLEEN
					{
					BOOLEEN152=(Token)match(input,BOOLEEN,FOLLOW_BOOLEEN_in_cste1278);  
					stream_BOOLEEN.add(BOOLEEN152);

					// AST REWRITE
					// elements: BOOLEEN
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 150:12: -> ^( CSTE_BOOLEEN BOOLEEN )
					{
						// .\\src\\com\\company\\projet.g:150:15: ^( CSTE_BOOLEEN BOOLEEN )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CSTE_BOOLEEN, "CSTE_BOOLEEN"), root_1);
						adaptor.addChild(root_1, stream_BOOLEEN.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// .\\src\\com\\company\\projet.g:151:4: STRING
					{
					STRING153=(Token)match(input,STRING,FOLLOW_STRING_in_cste1291);  
					stream_STRING.add(STRING153);

					// AST REWRITE
					// elements: STRING
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 151:11: -> ^( CSTE_STR STRING )
					{
						// .\\src\\com\\company\\projet.g:151:14: ^( CSTE_STR STRING )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CSTE_STR, "CSTE_STR"), root_1);
						adaptor.addChild(root_1, stream_STRING.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cste"

	// Delegated rules



	public static final BitSet FOLLOW_75_in_program162 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_program164 = new BitSet(new long[]{0x0000000000010000L,0x00000000001D5060L});
	public static final BitSet FOLLOW_vardeclist_in_program166 = new BitSet(new long[]{0x0000000000010000L,0x00000000001C5060L});
	public static final BitSet FOLLOW_fundeclist_in_program168 = new BitSet(new long[]{0x0000000000010000L,0x00000000001C5040L});
	public static final BitSet FOLLOW_instr_in_program170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vardecl_in_vardeclist193 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_vardecl212 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_identlist_in_vardecl214 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_vardecl216 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020086L});
	public static final BitSet FOLLOW_typename_in_vardecl218 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_vardecl220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_identlist238 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_identlist2_in_identlist240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_identlist2251 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_identlist_in_identlist2254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomtype_in_typename260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arraytype_in_typename265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_arraytype291 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_61_in_arraytype293 = new BitSet(new long[]{0x0004000810000040L});
	public static final BitSet FOLLOW_rangelist_in_arraytype295 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_arraytype297 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_arraytype299 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020084L});
	public static final BitSet FOLLOW_atomtype_in_arraytype301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cste_in_rangelist320 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_rangelist322 = new BitSet(new long[]{0x0004000810000040L});
	public static final BitSet FOLLOW_cste_in_rangelist324 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_49_in_rangelist327 = new BitSet(new long[]{0x0004000810000040L});
	public static final BitSet FOLLOW_cste_in_rangelist329 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_rangelist331 = new BitSet(new long[]{0x0004000810000040L});
	public static final BitSet FOLLOW_cste_in_rangelist333 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_fundecl_in_fundeclist364 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_fundecl382 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_fundecl384 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_fundecl386 = new BitSet(new long[]{0x0000400000010000L,0x0000000000002000L});
	public static final BitSet FOLLOW_arglist_in_fundecl388 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_fundecl390 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_fundecl392 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020084L});
	public static final BitSet FOLLOW_atomtype_in_fundecl394 = new BitSet(new long[]{0x0000000000000000L,0x0000000000110000L});
	public static final BitSet FOLLOW_vardeclist_in_fundecl396 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_block_in_fundecl398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arg_in_arglist431 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_49_in_arglist434 = new BitSet(new long[]{0x0000000000010000L,0x0000000000002000L});
	public static final BitSet FOLLOW_arg_in_arglist436 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_ID_in_arg455 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_arg457 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020086L});
	public static final BitSet FOLLOW_typename_in_arg459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_arg474 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_arg476 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_arg478 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020086L});
	public static final BitSet FOLLOW_typename_in_arg480 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_instr498 = new BitSet(new long[]{0x0004200010010040L,0x0000000000000100L});
	public static final BitSet FOLLOW_expr_in_instr500 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_79_in_instr502 = new BitSet(new long[]{0x0000000000010000L,0x00000000001C5040L});
	public static final BitSet FOLLOW_instr_in_instr504 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_instr518 = new BitSet(new long[]{0x0000000000010000L,0x00000000001C5040L});
	public static final BitSet FOLLOW_instr_in_instr520 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_82_in_instr552 = new BitSet(new long[]{0x0004200010010040L,0x0000000000000100L});
	public static final BitSet FOLLOW_expr_in_instr554 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_instr556 = new BitSet(new long[]{0x0000000000010000L,0x00000000001C5040L});
	public static final BitSet FOLLOW_instr_in_instr558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_instr581 = new BitSet(new long[]{0x0004200010010042L,0x0000000000000100L});
	public static final BitSet FOLLOW_expr_in_instr583 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_instr598 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_instr603 = new BitSet(new long[]{0x2200200000000000L});
	public static final BitSet FOLLOW_lvalue_in_instr617 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_instr619 = new BitSet(new long[]{0x0004200010010040L,0x0000000000000100L});
	public static final BitSet FOLLOW_expr_in_instr621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_instr649 = new BitSet(new long[]{0x0004200010010040L,0x0000000000000100L});
	public static final BitSet FOLLOW_expr_in_instr651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_instr676 = new BitSet(new long[]{0x0004600010010040L,0x0000000000000100L});
	public static final BitSet FOLLOW_exprlist_in_instr678 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_instr681 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_83_in_instr701 = new BitSet(new long[]{0x0004000810010040L});
	public static final BitSet FOLLOW_instr5_in_instr703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_instr716 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_instr718 = new BitSet(new long[]{0x2000000000000002L});
	public static final BitSet FOLLOW_lvalue_in_instr724 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_instr5763 = new BitSet(new long[]{0x2000000000000002L});
	public static final BitSet FOLLOW_lvalue_in_instr5769 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cste_in_instr5799 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_instr_in_sequence809 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_sequence2_in_sequence811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_sequence2823 = new BitSet(new long[]{0x0000000000010000L,0x00000000001C5040L});
	public static final BitSet FOLLOW_sequence3_in_sequence2826 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sequence_in_sequence3837 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_61_in_lvalue848 = new BitSet(new long[]{0x0004200010010040L,0x0000000000000100L});
	public static final BitSet FOLLOW_exprlist_in_lvalue851 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_lvalue853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_exprlist863 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_exprlist2_in_exprlist865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_exprlist2876 = new BitSet(new long[]{0x0004200010010040L,0x0000000000000100L});
	public static final BitSet FOLLOW_exprlist_in_exprlist2879 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_ou_in_expr888 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprlist_in_exprlist3900 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_atom909 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLEEN_in_atom923 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom936 = new BitSet(new long[]{0x2000200000000002L});
	public static final BitSet FOLLOW_61_in_atom940 = new BitSet(new long[]{0x0004200010010040L,0x0000000000000100L});
	public static final BitSet FOLLOW_exprlist_in_atom941 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_atom942 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_atom957 = new BitSet(new long[]{0x0004600010010040L,0x0000000000000100L});
	public static final BitSet FOLLOW_exprlist3_in_atom958 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_atom959 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_atom986 = new BitSet(new long[]{0x0004200010010040L,0x0000000000000100L});
	public static final BitSet FOLLOW_expr_in_atom989 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_atom991 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_expr_moins_unaire1004 = new BitSet(new long[]{0x0004200010010040L});
	public static final BitSet FOLLOW_atom_in_expr_moins_unaire1009 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_moins_unaire_in_expr_puissance1018 = new BitSet(new long[]{0x8000000000000002L});
	public static final BitSet FOLLOW_63_in_expr_puissance1021 = new BitSet(new long[]{0x0004200010010040L});
	public static final BitSet FOLLOW_expr_moins_unaire_in_expr_puissance1024 = new BitSet(new long[]{0x8000000000000002L});
	public static final BitSet FOLLOW_expr_puissance_in_expr_mult_div1035 = new BitSet(new long[]{0x0010800000000002L});
	public static final BitSet FOLLOW_47_in_expr_mult_div1039 = new BitSet(new long[]{0x0004200010010040L});
	public static final BitSet FOLLOW_expr_puissance_in_expr_mult_div1042 = new BitSet(new long[]{0x0010800000000002L});
	public static final BitSet FOLLOW_52_in_expr_mult_div1048 = new BitSet(new long[]{0x0004200010010040L});
	public static final BitSet FOLLOW_expr_puissance_in_expr_mult_div1051 = new BitSet(new long[]{0x0010800000000002L});
	public static final BitSet FOLLOW_expr_mult_div_in_expr_add_sous1063 = new BitSet(new long[]{0x0005000000000002L});
	public static final BitSet FOLLOW_50_in_expr_add_sous1067 = new BitSet(new long[]{0x0004200010010040L});
	public static final BitSet FOLLOW_expr_mult_div_in_expr_add_sous1070 = new BitSet(new long[]{0x0005000000000002L});
	public static final BitSet FOLLOW_48_in_expr_add_sous1076 = new BitSet(new long[]{0x0004200010010040L});
	public static final BitSet FOLLOW_expr_mult_div_in_expr_add_sous1079 = new BitSet(new long[]{0x0005000000000002L});
	public static final BitSet FOLLOW_expr_add_sous_in_expr_comparaison1091 = new BitSet(new long[]{0x1D80100000000002L});
	public static final BitSet FOLLOW_59_in_expr_comparaison1094 = new BitSet(new long[]{0x0004200010010040L});
	public static final BitSet FOLLOW_expr_add_sous_in_expr_comparaison1097 = new BitSet(new long[]{0x1D80100000000002L});
	public static final BitSet FOLLOW_55_in_expr_comparaison1103 = new BitSet(new long[]{0x0004200010010040L});
	public static final BitSet FOLLOW_expr_add_sous_in_expr_comparaison1106 = new BitSet(new long[]{0x1D80100000000002L});
	public static final BitSet FOLLOW_56_in_expr_comparaison1112 = new BitSet(new long[]{0x0004200010010040L});
	public static final BitSet FOLLOW_expr_add_sous_in_expr_comparaison1115 = new BitSet(new long[]{0x1D80100000000002L});
	public static final BitSet FOLLOW_60_in_expr_comparaison1121 = new BitSet(new long[]{0x0004200010010040L});
	public static final BitSet FOLLOW_expr_add_sous_in_expr_comparaison1124 = new BitSet(new long[]{0x1D80100000000002L});
	public static final BitSet FOLLOW_58_in_expr_comparaison1130 = new BitSet(new long[]{0x0004200010010040L});
	public static final BitSet FOLLOW_expr_add_sous_in_expr_comparaison1133 = new BitSet(new long[]{0x1D80100000000002L});
	public static final BitSet FOLLOW_44_in_expr_comparaison1139 = new BitSet(new long[]{0x0004200010010040L});
	public static final BitSet FOLLOW_expr_add_sous_in_expr_comparaison1142 = new BitSet(new long[]{0x1D80100000000002L});
	public static final BitSet FOLLOW_72_in_expr_non1155 = new BitSet(new long[]{0x0004200010010040L,0x0000000000000100L});
	public static final BitSet FOLLOW_expr_comparaison_in_expr_non1160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_non_in_expr_et1168 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_expr_et1171 = new BitSet(new long[]{0x0004200010010040L,0x0000000000000100L});
	public static final BitSet FOLLOW_expr_non_in_expr_et1174 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
	public static final BitSet FOLLOW_expr_et_in_expr_ou1184 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_74_in_expr_ou1187 = new BitSet(new long[]{0x0004200010010040L,0x0000000000000100L});
	public static final BitSet FOLLOW_expr_et_in_expr_ou1190 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_84_in_block1202 = new BitSet(new long[]{0x0000000000010000L,0x00000000003C5040L});
	public static final BitSet FOLLOW_seq_in_block1204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sequence_in_seq1221 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_seq1223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_85_in_seq1228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_cste1244 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_INT_in_cste1246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_cste1265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLEEN_in_cste1278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_cste1291 = new BitSet(new long[]{0x0000000000000002L});
}
