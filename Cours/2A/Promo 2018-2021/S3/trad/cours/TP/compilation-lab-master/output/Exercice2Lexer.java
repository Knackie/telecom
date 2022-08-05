// $ANTLR null /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g 2020-01-15 09:13:40

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Exercice2Lexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int INT=4;
	public static final int NEWLINE=5;
	public static final int NIL=6;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public Exercice2Lexer() {} 
	public Exercice2Lexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public Exercice2Lexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g"; }

	// $ANTLR start "T__7"
	public final void mT__7() throws RecognitionException {
		try {
			int _type = T__7;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:2:6: ( '(' )
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:2:8: '('
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
	// $ANTLR end "T__7"

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:3:6: ( ')' )
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:3:8: ')'
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
	// $ANTLR end "T__8"

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:4:6: ( ',' )
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:4:8: ','
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
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:5:7: ( '.' )
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:5:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__10"

	// $ANTLR start "NIL"
	public final void mNIL() throws RecognitionException {
		try {
			int _type = NIL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:14:6: ( 'nil' )
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:14:8: 'nil'
			{
			match("nil"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NIL"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:15:5: ( ( '0' .. '9' )+ )
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:15:9: ( '0' .. '9' )+
			{
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:15:9: ( '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:
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
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
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

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:21:8: ( ( '\\r' )? '\\n' )
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:21:9: ( '\\r' )? '\\n'
			{
			// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:21:9: ( '\\r' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\r') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:21:9: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
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
		// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:1:8: ( T__7 | T__8 | T__9 | T__10 | NIL | INT | NEWLINE )
		int alt3=7;
		switch ( input.LA(1) ) {
		case '(':
			{
			alt3=1;
			}
			break;
		case ')':
			{
			alt3=2;
			}
			break;
		case ',':
			{
			alt3=3;
			}
			break;
		case '.':
			{
			alt3=4;
			}
			break;
		case 'n':
			{
			alt3=5;
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
		case '8':
		case '9':
			{
			alt3=6;
			}
			break;
		case '\n':
		case '\r':
			{
			alt3=7;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 3, 0, input);
			throw nvae;
		}
		switch (alt3) {
			case 1 :
				// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:1:10: T__7
				{
				mT__7(); 

				}
				break;
			case 2 :
				// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:1:15: T__8
				{
				mT__8(); 

				}
				break;
			case 3 :
				// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:1:20: T__9
				{
				mT__9(); 

				}
				break;
			case 4 :
				// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:1:25: T__10
				{
				mT__10(); 

				}
				break;
			case 5 :
				// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:1:31: NIL
				{
				mNIL(); 

				}
				break;
			case 6 :
				// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:1:35: INT
				{
				mINT(); 

				}
				break;
			case 7 :
				// /Users/quentin/Telecom/S3/Traduction/TP/compilation-lab-master/Exercice2.g:1:39: NEWLINE
				{
				mNEWLINE(); 

				}
				break;

		}
	}



}
