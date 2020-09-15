// $ANTLR 3.5.2 .\\src\\com\\company\\projet.g 2020-01-20 16:56:52
package com.company;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class projetLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public projetLexer() {} 
	public projetLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public projetLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return ".\\src\\com\\company\\projet.g"; }

	// $ANTLR start "T__44"
	public final void mT__44() throws RecognitionException {
		try {
			int _type = T__44;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:2:7: ( '!=' )
			// .\\src\\com\\company\\projet.g:2:9: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__44"

	// $ANTLR start "T__45"
	public final void mT__45() throws RecognitionException {
		try {
			int _type = T__45;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:3:7: ( '(' )
			// .\\src\\com\\company\\projet.g:3:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__45"

	// $ANTLR start "T__46"
	public final void mT__46() throws RecognitionException {
		try {
			int _type = T__46;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:4:7: ( ')' )
			// .\\src\\com\\company\\projet.g:4:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:5:7: ( '*' )
			// .\\src\\com\\company\\projet.g:5:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:6:7: ( '+' )
			// .\\src\\com\\company\\projet.g:6:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:7:7: ( ',' )
			// .\\src\\com\\company\\projet.g:7:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__49"

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:8:7: ( '-' )
			// .\\src\\com\\company\\projet.g:8:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:9:7: ( '..' )
			// .\\src\\com\\company\\projet.g:9:9: '..'
			{
			match(".."); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:10:7: ( '/' )
			// .\\src\\com\\company\\projet.g:10:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:11:7: ( ':' )
			// .\\src\\com\\company\\projet.g:11:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:12:7: ( ';' )
			// .\\src\\com\\company\\projet.g:12:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:13:7: ( '<' )
			// .\\src\\com\\company\\projet.g:13:9: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:14:7: ( '<=' )
			// .\\src\\com\\company\\projet.g:14:9: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__56"

	// $ANTLR start "T__57"
	public final void mT__57() throws RecognitionException {
		try {
			int _type = T__57;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:15:7: ( '=' )
			// .\\src\\com\\company\\projet.g:15:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__57"

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:16:7: ( '==' )
			// .\\src\\com\\company\\projet.g:16:9: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__58"

	// $ANTLR start "T__59"
	public final void mT__59() throws RecognitionException {
		try {
			int _type = T__59;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:17:7: ( '>' )
			// .\\src\\com\\company\\projet.g:17:9: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__59"

	// $ANTLR start "T__60"
	public final void mT__60() throws RecognitionException {
		try {
			int _type = T__60;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:18:7: ( '>=' )
			// .\\src\\com\\company\\projet.g:18:9: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__60"

	// $ANTLR start "T__61"
	public final void mT__61() throws RecognitionException {
		try {
			int _type = T__61;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:19:7: ( '[' )
			// .\\src\\com\\company\\projet.g:19:9: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__61"

	// $ANTLR start "T__62"
	public final void mT__62() throws RecognitionException {
		try {
			int _type = T__62;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:20:7: ( ']' )
			// .\\src\\com\\company\\projet.g:20:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__62"

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:21:7: ( '^' )
			// .\\src\\com\\company\\projet.g:21:9: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__63"

	// $ANTLR start "T__64"
	public final void mT__64() throws RecognitionException {
		try {
			int _type = T__64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:22:7: ( 'and' )
			// .\\src\\com\\company\\projet.g:22:9: 'and'
			{
			match("and"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__64"

	// $ANTLR start "T__65"
	public final void mT__65() throws RecognitionException {
		try {
			int _type = T__65;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:23:7: ( 'array' )
			// .\\src\\com\\company\\projet.g:23:9: 'array'
			{
			match("array"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__65"

	// $ANTLR start "T__66"
	public final void mT__66() throws RecognitionException {
		try {
			int _type = T__66;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:24:7: ( 'bool' )
			// .\\src\\com\\company\\projet.g:24:9: 'bool'
			{
			match("bool"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__66"

	// $ANTLR start "T__67"
	public final void mT__67() throws RecognitionException {
		try {
			int _type = T__67;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:25:7: ( 'do' )
			// .\\src\\com\\company\\projet.g:25:9: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__67"

	// $ANTLR start "T__68"
	public final void mT__68() throws RecognitionException {
		try {
			int _type = T__68;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:26:7: ( 'else' )
			// .\\src\\com\\company\\projet.g:26:9: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__68"

	// $ANTLR start "T__69"
	public final void mT__69() throws RecognitionException {
		try {
			int _type = T__69;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:27:7: ( 'function' )
			// .\\src\\com\\company\\projet.g:27:9: 'function'
			{
			match("function"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__69"

	// $ANTLR start "T__70"
	public final void mT__70() throws RecognitionException {
		try {
			int _type = T__70;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:28:7: ( 'if' )
			// .\\src\\com\\company\\projet.g:28:9: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__70"

	// $ANTLR start "T__71"
	public final void mT__71() throws RecognitionException {
		try {
			int _type = T__71;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:29:7: ( 'int' )
			// .\\src\\com\\company\\projet.g:29:9: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__71"

	// $ANTLR start "T__72"
	public final void mT__72() throws RecognitionException {
		try {
			int _type = T__72;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:30:7: ( 'not' )
			// .\\src\\com\\company\\projet.g:30:9: 'not'
			{
			match("not"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__72"

	// $ANTLR start "T__73"
	public final void mT__73() throws RecognitionException {
		try {
			int _type = T__73;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:31:7: ( 'of' )
			// .\\src\\com\\company\\projet.g:31:9: 'of'
			{
			match("of"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__73"

	// $ANTLR start "T__74"
	public final void mT__74() throws RecognitionException {
		try {
			int _type = T__74;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:32:7: ( 'or' )
			// .\\src\\com\\company\\projet.g:32:9: 'or'
			{
			match("or"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__74"

	// $ANTLR start "T__75"
	public final void mT__75() throws RecognitionException {
		try {
			int _type = T__75;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:33:7: ( 'program' )
			// .\\src\\com\\company\\projet.g:33:9: 'program'
			{
			match("program"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__75"

	// $ANTLR start "T__76"
	public final void mT__76() throws RecognitionException {
		try {
			int _type = T__76;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:34:7: ( 'read' )
			// .\\src\\com\\company\\projet.g:34:9: 'read'
			{
			match("read"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__76"

	// $ANTLR start "T__77"
	public final void mT__77() throws RecognitionException {
		try {
			int _type = T__77;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:35:7: ( 'ref' )
			// .\\src\\com\\company\\projet.g:35:9: 'ref'
			{
			match("ref"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__77"

	// $ANTLR start "T__78"
	public final void mT__78() throws RecognitionException {
		try {
			int _type = T__78;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:36:7: ( 'return' )
			// .\\src\\com\\company\\projet.g:36:9: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__78"

	// $ANTLR start "T__79"
	public final void mT__79() throws RecognitionException {
		try {
			int _type = T__79;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:37:7: ( 'then' )
			// .\\src\\com\\company\\projet.g:37:9: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__79"

	// $ANTLR start "T__80"
	public final void mT__80() throws RecognitionException {
		try {
			int _type = T__80;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:38:7: ( 'var' )
			// .\\src\\com\\company\\projet.g:38:9: 'var'
			{
			match("var"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__80"

	// $ANTLR start "T__81"
	public final void mT__81() throws RecognitionException {
		try {
			int _type = T__81;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:39:7: ( 'void' )
			// .\\src\\com\\company\\projet.g:39:9: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__81"

	// $ANTLR start "T__82"
	public final void mT__82() throws RecognitionException {
		try {
			int _type = T__82;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:40:7: ( 'while' )
			// .\\src\\com\\company\\projet.g:40:9: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__82"

	// $ANTLR start "T__83"
	public final void mT__83() throws RecognitionException {
		try {
			int _type = T__83;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:41:7: ( 'write' )
			// .\\src\\com\\company\\projet.g:41:9: 'write'
			{
			match("write"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__83"

	// $ANTLR start "T__84"
	public final void mT__84() throws RecognitionException {
		try {
			int _type = T__84;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:42:7: ( '{' )
			// .\\src\\com\\company\\projet.g:42:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__84"

	// $ANTLR start "T__85"
	public final void mT__85() throws RecognitionException {
		try {
			int _type = T__85;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:43:7: ( '}' )
			// .\\src\\com\\company\\projet.g:43:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__85"

	// $ANTLR start "BOOLEEN"
	public final void mBOOLEEN() throws RecognitionException {
		try {
			int _type = BOOLEEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:153:9: ( 'true' | 'false' )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='t') ) {
				alt1=1;
			}
			else if ( (LA1_0=='f') ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// .\\src\\com\\company\\projet.g:153:11: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:154:4: 'false'
					{
					match("false"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOLEEN"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:157:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// .\\src\\com\\company\\projet.g:157:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// .\\src\\com\\company\\projet.g:157:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// .\\src\\com\\company\\projet.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:160:5: ( ( '0' .. '9' )+ )
			// .\\src\\com\\company\\projet.g:160:7: ( '0' .. '9' )+
			{
			// .\\src\\com\\company\\projet.g:160:7: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// .\\src\\com\\company\\projet.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:164:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='/') ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1=='/') ) {
					alt7=1;
				}
				else if ( (LA7_1=='*') ) {
					alt7=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// .\\src\\com\\company\\projet.g:164:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
					{
					match("//"); 

					// .\\src\\com\\company\\projet.g:164:14: (~ ( '\\n' | '\\r' ) )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// .\\src\\com\\company\\projet.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop4;
						}
					}

					// .\\src\\com\\company\\projet.g:164:28: ( '\\r' )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0=='\r') ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// .\\src\\com\\company\\projet.g:164:28: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					_channel=HIDDEN;
					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:165:9: '/*' ( options {greedy=false; } : . )* '*/'
					{
					match("/*"); 

					// .\\src\\com\\company\\projet.g:165:14: ( options {greedy=false; } : . )*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0=='*') ) {
							int LA6_1 = input.LA(2);
							if ( (LA6_1=='/') ) {
								alt6=2;
							}
							else if ( ((LA6_1 >= '\u0000' && LA6_1 <= '.')||(LA6_1 >= '0' && LA6_1 <= '\uFFFF')) ) {
								alt6=1;
							}

						}
						else if ( ((LA6_0 >= '\u0000' && LA6_0 <= ')')||(LA6_0 >= '+' && LA6_0 <= '\uFFFF')) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// .\\src\\com\\company\\projet.g:165:42: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop6;
						}
					}

					match("*/"); 

					_channel=HIDDEN;
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:169:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
			// .\\src\\com\\company\\projet.g:169:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// .\\src\\com\\company\\projet.g:169:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
			loop8:
			while (true) {
				int alt8=3;
				int LA8_0 = input.LA(1);
				if ( (LA8_0=='\\') ) {
					alt8=1;
				}
				else if ( ((LA8_0 >= '\u0000' && LA8_0 <= '!')||(LA8_0 >= '#' && LA8_0 <= '[')||(LA8_0 >= ']' && LA8_0 <= '\uFFFF')) ) {
					alt8=2;
				}

				switch (alt8) {
				case 1 :
					// .\\src\\com\\company\\projet.g:169:14: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:169:24: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop8;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "HEX_DIGIT"
	public final void mHEX_DIGIT() throws RecognitionException {
		try {
			// .\\src\\com\\company\\projet.g:174:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// .\\src\\com\\company\\projet.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEX_DIGIT"

	// $ANTLR start "ESC_SEQ"
	public final void mESC_SEQ() throws RecognitionException {
		try {
			// .\\src\\com\\company\\projet.g:178:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
			int alt9=3;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='\\') ) {
				switch ( input.LA(2) ) {
				case '\"':
				case '\'':
				case '\\':
				case 'b':
				case 'f':
				case 'n':
				case 'r':
				case 't':
					{
					alt9=1;
					}
					break;
				case 'u':
					{
					alt9=2;
					}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
					{
					alt9=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// .\\src\\com\\company\\projet.g:178:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
					{
					match('\\'); 
					if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:179:9: UNICODE_ESC
					{
					mUNICODE_ESC(); 

					}
					break;
				case 3 :
					// .\\src\\com\\company\\projet.g:180:9: OCTAL_ESC
					{
					mOCTAL_ESC(); 

					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC_SEQ"

	// $ANTLR start "OCTAL_ESC"
	public final void mOCTAL_ESC() throws RecognitionException {
		try {
			// .\\src\\com\\company\\projet.g:185:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
			int alt10=3;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='\\') ) {
				int LA10_1 = input.LA(2);
				if ( ((LA10_1 >= '0' && LA10_1 <= '3')) ) {
					int LA10_2 = input.LA(3);
					if ( ((LA10_2 >= '0' && LA10_2 <= '7')) ) {
						int LA10_4 = input.LA(4);
						if ( ((LA10_4 >= '0' && LA10_4 <= '7')) ) {
							alt10=1;
						}

						else {
							alt10=2;
						}

					}

					else {
						alt10=3;
					}

				}
				else if ( ((LA10_1 >= '4' && LA10_1 <= '7')) ) {
					int LA10_3 = input.LA(3);
					if ( ((LA10_3 >= '0' && LA10_3 <= '7')) ) {
						alt10=2;
					}

					else {
						alt10=3;
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// .\\src\\com\\company\\projet.g:185:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// .\\src\\com\\company\\projet.g:186:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 3 :
					// .\\src\\com\\company\\projet.g:187:9: '\\\\' ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OCTAL_ESC"

	// $ANTLR start "UNICODE_ESC"
	public final void mUNICODE_ESC() throws RecognitionException {
		try {
			// .\\src\\com\\company\\projet.g:192:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
			// .\\src\\com\\company\\projet.g:192:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			{
			match('\\'); 
			match('u'); 
			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNICODE_ESC"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:194:5: ( ( ' ' | '\\t' )+ )
			// .\\src\\com\\company\\projet.g:194:9: ( ' ' | '\\t' )+
			{
			// .\\src\\com\\company\\projet.g:194:9: ( ' ' | '\\t' )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0=='\t'||LA11_0==' ') ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// .\\src\\com\\company\\projet.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\src\\com\\company\\projet.g:195:8: ( ( '\\r' )? '\\n' )
			// .\\src\\com\\company\\projet.g:195:9: ( '\\r' )? '\\n'
			{
			// .\\src\\com\\company\\projet.g:195:9: ( '\\r' )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='\r') ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// .\\src\\com\\company\\projet.g:195:9: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	@Override
	public void mTokens() throws RecognitionException {
		// .\\src\\com\\company\\projet.g:1:8: ( T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | BOOLEEN | ID | INT | COMMENT | STRING | WS | NEWLINE )
		int alt13=49;
		alt13 = dfa13.predict(input);
		switch (alt13) {
			case 1 :
				// .\\src\\com\\company\\projet.g:1:10: T__44
				{
				mT__44(); 

				}
				break;
			case 2 :
				// .\\src\\com\\company\\projet.g:1:16: T__45
				{
				mT__45(); 

				}
				break;
			case 3 :
				// .\\src\\com\\company\\projet.g:1:22: T__46
				{
				mT__46(); 

				}
				break;
			case 4 :
				// .\\src\\com\\company\\projet.g:1:28: T__47
				{
				mT__47(); 

				}
				break;
			case 5 :
				// .\\src\\com\\company\\projet.g:1:34: T__48
				{
				mT__48(); 

				}
				break;
			case 6 :
				// .\\src\\com\\company\\projet.g:1:40: T__49
				{
				mT__49(); 

				}
				break;
			case 7 :
				// .\\src\\com\\company\\projet.g:1:46: T__50
				{
				mT__50(); 

				}
				break;
			case 8 :
				// .\\src\\com\\company\\projet.g:1:52: T__51
				{
				mT__51(); 

				}
				break;
			case 9 :
				// .\\src\\com\\company\\projet.g:1:58: T__52
				{
				mT__52(); 

				}
				break;
			case 10 :
				// .\\src\\com\\company\\projet.g:1:64: T__53
				{
				mT__53(); 

				}
				break;
			case 11 :
				// .\\src\\com\\company\\projet.g:1:70: T__54
				{
				mT__54(); 

				}
				break;
			case 12 :
				// .\\src\\com\\company\\projet.g:1:76: T__55
				{
				mT__55(); 

				}
				break;
			case 13 :
				// .\\src\\com\\company\\projet.g:1:82: T__56
				{
				mT__56(); 

				}
				break;
			case 14 :
				// .\\src\\com\\company\\projet.g:1:88: T__57
				{
				mT__57(); 

				}
				break;
			case 15 :
				// .\\src\\com\\company\\projet.g:1:94: T__58
				{
				mT__58(); 

				}
				break;
			case 16 :
				// .\\src\\com\\company\\projet.g:1:100: T__59
				{
				mT__59(); 

				}
				break;
			case 17 :
				// .\\src\\com\\company\\projet.g:1:106: T__60
				{
				mT__60(); 

				}
				break;
			case 18 :
				// .\\src\\com\\company\\projet.g:1:112: T__61
				{
				mT__61(); 

				}
				break;
			case 19 :
				// .\\src\\com\\company\\projet.g:1:118: T__62
				{
				mT__62(); 

				}
				break;
			case 20 :
				// .\\src\\com\\company\\projet.g:1:124: T__63
				{
				mT__63(); 

				}
				break;
			case 21 :
				// .\\src\\com\\company\\projet.g:1:130: T__64
				{
				mT__64(); 

				}
				break;
			case 22 :
				// .\\src\\com\\company\\projet.g:1:136: T__65
				{
				mT__65(); 

				}
				break;
			case 23 :
				// .\\src\\com\\company\\projet.g:1:142: T__66
				{
				mT__66(); 

				}
				break;
			case 24 :
				// .\\src\\com\\company\\projet.g:1:148: T__67
				{
				mT__67(); 

				}
				break;
			case 25 :
				// .\\src\\com\\company\\projet.g:1:154: T__68
				{
				mT__68(); 

				}
				break;
			case 26 :
				// .\\src\\com\\company\\projet.g:1:160: T__69
				{
				mT__69(); 

				}
				break;
			case 27 :
				// .\\src\\com\\company\\projet.g:1:166: T__70
				{
				mT__70(); 

				}
				break;
			case 28 :
				// .\\src\\com\\company\\projet.g:1:172: T__71
				{
				mT__71(); 

				}
				break;
			case 29 :
				// .\\src\\com\\company\\projet.g:1:178: T__72
				{
				mT__72(); 

				}
				break;
			case 30 :
				// .\\src\\com\\company\\projet.g:1:184: T__73
				{
				mT__73(); 

				}
				break;
			case 31 :
				// .\\src\\com\\company\\projet.g:1:190: T__74
				{
				mT__74(); 

				}
				break;
			case 32 :
				// .\\src\\com\\company\\projet.g:1:196: T__75
				{
				mT__75(); 

				}
				break;
			case 33 :
				// .\\src\\com\\company\\projet.g:1:202: T__76
				{
				mT__76(); 

				}
				break;
			case 34 :
				// .\\src\\com\\company\\projet.g:1:208: T__77
				{
				mT__77(); 

				}
				break;
			case 35 :
				// .\\src\\com\\company\\projet.g:1:214: T__78
				{
				mT__78(); 

				}
				break;
			case 36 :
				// .\\src\\com\\company\\projet.g:1:220: T__79
				{
				mT__79(); 

				}
				break;
			case 37 :
				// .\\src\\com\\company\\projet.g:1:226: T__80
				{
				mT__80(); 

				}
				break;
			case 38 :
				// .\\src\\com\\company\\projet.g:1:232: T__81
				{
				mT__81(); 

				}
				break;
			case 39 :
				// .\\src\\com\\company\\projet.g:1:238: T__82
				{
				mT__82(); 

				}
				break;
			case 40 :
				// .\\src\\com\\company\\projet.g:1:244: T__83
				{
				mT__83(); 

				}
				break;
			case 41 :
				// .\\src\\com\\company\\projet.g:1:250: T__84
				{
				mT__84(); 

				}
				break;
			case 42 :
				// .\\src\\com\\company\\projet.g:1:256: T__85
				{
				mT__85(); 

				}
				break;
			case 43 :
				// .\\src\\com\\company\\projet.g:1:262: BOOLEEN
				{
				mBOOLEEN(); 

				}
				break;
			case 44 :
				// .\\src\\com\\company\\projet.g:1:270: ID
				{
				mID(); 

				}
				break;
			case 45 :
				// .\\src\\com\\company\\projet.g:1:273: INT
				{
				mINT(); 

				}
				break;
			case 46 :
				// .\\src\\com\\company\\projet.g:1:277: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 47 :
				// .\\src\\com\\company\\projet.g:1:285: STRING
				{
				mSTRING(); 

				}
				break;
			case 48 :
				// .\\src\\com\\company\\projet.g:1:292: WS
				{
				mWS(); 

				}
				break;
			case 49 :
				// .\\src\\com\\company\\projet.g:1:295: NEWLINE
				{
				mNEWLINE(); 

				}
				break;

		}
	}


	protected DFA13 dfa13 = new DFA13(this);
	static final String DFA13_eotS =
		"\11\uffff\1\47\2\uffff\1\51\1\53\1\55\3\uffff\15\41\17\uffff\3\41\1\105"+
		"\3\41\1\111\2\41\1\114\1\115\10\41\1\130\2\41\1\uffff\3\41\1\uffff\1\136"+
		"\1\137\2\uffff\2\41\1\142\3\41\1\146\3\41\1\uffff\1\41\1\153\1\154\2\41"+
		"\2\uffff\1\41\1\160\1\uffff\1\41\1\162\1\163\1\uffff\1\164\2\41\1\167"+
		"\2\uffff\1\41\1\163\1\41\1\uffff\1\41\3\uffff\1\173\1\174\1\uffff\2\41"+
		"\1\177\2\uffff\1\41\1\u0081\1\uffff\1\u0082\2\uffff";
	static final String DFA13_eofS =
		"\u0083\uffff";
	static final String DFA13_minS =
		"\1\11\10\uffff\1\52\2\uffff\3\75\3\uffff\1\156\2\157\1\154\1\141\1\146"+
		"\1\157\1\146\1\162\1\145\1\150\1\141\1\150\17\uffff\1\144\1\162\1\157"+
		"\1\60\1\163\1\156\1\154\1\60\2\164\2\60\1\157\1\141\1\145\1\165\1\162"+
		"\3\151\1\60\1\141\1\154\1\uffff\1\145\1\143\1\163\1\uffff\2\60\2\uffff"+
		"\1\147\1\144\1\60\1\165\1\156\1\145\1\60\1\144\1\154\1\164\1\uffff\1\171"+
		"\2\60\1\164\1\145\2\uffff\1\162\1\60\1\uffff\1\162\2\60\1\uffff\1\60\2"+
		"\145\1\60\2\uffff\1\151\1\60\1\141\1\uffff\1\156\3\uffff\2\60\1\uffff"+
		"\1\157\1\155\1\60\2\uffff\1\156\1\60\1\uffff\1\60\2\uffff";
	static final String DFA13_maxS =
		"\1\175\10\uffff\1\57\2\uffff\3\75\3\uffff\1\162\2\157\1\154\1\165\1\156"+
		"\1\157\2\162\1\145\1\162\1\157\1\162\17\uffff\1\144\1\162\1\157\1\172"+
		"\1\163\1\156\1\154\1\172\2\164\2\172\1\157\1\164\1\145\1\165\1\162\3\151"+
		"\1\172\1\141\1\154\1\uffff\1\145\1\143\1\163\1\uffff\2\172\2\uffff\1\147"+
		"\1\144\1\172\1\165\1\156\1\145\1\172\1\144\1\154\1\164\1\uffff\1\171\2"+
		"\172\1\164\1\145\2\uffff\1\162\1\172\1\uffff\1\162\2\172\1\uffff\1\172"+
		"\2\145\1\172\2\uffff\1\151\1\172\1\141\1\uffff\1\156\3\uffff\2\172\1\uffff"+
		"\1\157\1\155\1\172\2\uffff\1\156\1\172\1\uffff\1\172\2\uffff";
	static final String DFA13_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\13\3\uffff\1"+
		"\22\1\23\1\24\15\uffff\1\51\1\52\1\54\1\55\1\57\1\60\1\61\1\56\1\11\1"+
		"\15\1\14\1\17\1\16\1\21\1\20\27\uffff\1\30\3\uffff\1\33\2\uffff\1\36\1"+
		"\37\12\uffff\1\25\5\uffff\1\34\1\35\2\uffff\1\42\3\uffff\1\45\4\uffff"+
		"\1\27\1\31\3\uffff\1\41\1\uffff\1\44\1\53\1\46\2\uffff\1\26\3\uffff\1"+
		"\47\1\50\2\uffff\1\43\1\uffff\1\40\1\32";
	static final String DFA13_specialS =
		"\u0083\uffff}>";
	static final String[] DFA13_transitionS = {
			"\1\44\1\45\2\uffff\1\45\22\uffff\1\44\1\1\1\43\5\uffff\1\2\1\3\1\4\1"+
			"\5\1\6\1\7\1\10\1\11\12\42\1\12\1\13\1\14\1\15\1\16\2\uffff\32\41\1\17"+
			"\1\uffff\1\20\1\21\1\41\1\uffff\1\22\1\23\1\41\1\24\1\25\1\26\2\41\1"+
			"\27\4\41\1\30\1\31\1\32\1\41\1\33\1\41\1\34\1\41\1\35\1\36\3\41\1\37"+
			"\1\uffff\1\40",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\46\4\uffff\1\46",
			"",
			"",
			"\1\50",
			"\1\52",
			"\1\54",
			"",
			"",
			"",
			"\1\56\3\uffff\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\64\23\uffff\1\63",
			"\1\65\7\uffff\1\66",
			"\1\67",
			"\1\70\13\uffff\1\71",
			"\1\72",
			"\1\73",
			"\1\74\11\uffff\1\75",
			"\1\76\15\uffff\1\77",
			"\1\100\11\uffff\1\101",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\102",
			"\1\103",
			"\1\104",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\106",
			"\1\107",
			"\1\110",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\112",
			"\1\113",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\116",
			"\1\117\4\uffff\1\120\15\uffff\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\131",
			"\1\132",
			"",
			"\1\133",
			"\1\134",
			"\1\135",
			"",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"",
			"",
			"\1\140",
			"\1\141",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\143",
			"\1\144",
			"\1\145",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\147",
			"\1\150",
			"\1\151",
			"",
			"\1\152",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\155",
			"\1\156",
			"",
			"",
			"\1\157",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"",
			"\1\161",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\165",
			"\1\166",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"",
			"",
			"\1\170",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\171",
			"",
			"\1\172",
			"",
			"",
			"",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"",
			"\1\175",
			"\1\176",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"",
			"",
			"\1\u0080",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"",
			""
	};

	static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
	static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
	static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
	static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
	static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
	static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
	static final short[][] DFA13_transition;

	static {
		int numStates = DFA13_transitionS.length;
		DFA13_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
		}
	}

	protected class DFA13 extends DFA {

		public DFA13(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 13;
			this.eot = DFA13_eot;
			this.eof = DFA13_eof;
			this.min = DFA13_min;
			this.max = DFA13_max;
			this.accept = DFA13_accept;
			this.special = DFA13_special;
			this.transition = DFA13_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | BOOLEEN | ID | INT | COMMENT | STRING | WS | NEWLINE );";
		}
	}

}
