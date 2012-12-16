// $ANTLR 3.4 D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g 2012-11-22 22:17:19

    package org.jbehaviour.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AnotherStoryGrammerLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int AND=4;
    public static final int ARRAY=5;
    public static final int ASAN=6;
    public static final int Alphanumeric=7;
    public static final int COMMA=8;
    public static final int Comment=9;
    public static final int Cote=10;
    public static final int DECLARE=11;
    public static final int Digit=12;
    public static final int Dollar=13;
    public static final int Dot=14;
    public static final int DoubleCote=15;
    public static final int Eol=16;
    public static final int EscapeSequence=17;
    public static final int Exponent=18;
    public static final int FALSE=19;
    public static final int FEATURE=20;
    public static final int FIELD=21;
    public static final int GIVEN=22;
    public static final int HexDigit=23;
    public static final int INCLUDE=24;
    public static final int INORDERTO=25;
    public static final int IWANTTO=26;
    public static final int Identifier=27;
    public static final int LeftBrace=28;
    public static final int Member=29;
    public static final int NULL=30;
    public static final int NUMBER=31;
    public static final int Number=32;
    public static final int OBJECT=33;
    public static final int PLUGIN=34;
    public static final int REGISTER=35;
    public static final int Reference=36;
    public static final int RightBrace=37;
    public static final int SCENARIO=38;
    public static final int CALL=39;
    public static final int STRING=40;
    public static final int String=41;
    public static final int THEN=42;
    public static final int TOK_AND=43;
    public static final int TOK_ASAN=44;
    public static final int TOK_DECLARE=45;
    public static final int TOK_FEATURE=46;
    public static final int TOK_GIVEN=47;
    public static final int TOK_INCLUDE=48;
    public static final int TOK_INORDERTO=49;
    public static final int TOK_IWANTTO=50;
    public static final int TOK_REGISTER=51;
    public static final int TOK_SCENARIO=52;
    public static final int TOK_STORE=53;
    public static final int TOK_TEMPLATE=54;
    public static final int TOK_THEN=55;
    public static final int TOK_WHEN=56;
    public static final int TRUE=57;
    public static final int UnderScrore=58;
    public static final int UnicodeEscape=59;
    public static final int WHEN=60;
    public static final int WS=61;



    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public AnotherStoryGrammerLexer() {} 
    public AnotherStoryGrammerLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public AnotherStoryGrammerLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g"; }

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:8:5: ( 'And' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:8:7: 'And'
            {
            match("And"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "ASAN"
    public final void mASAN() throws RecognitionException {
        try {
            int _type = ASAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:9:6: ( 'As an' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:9:8: 'As an'
            {
            match("As an"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASAN"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:10:7: ( ',' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:10:9: ','
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
    // $ANTLR end "COMMA"

    // $ANTLR start "DECLARE"
    public final void mDECLARE() throws RecognitionException {
        try {
            int _type = DECLARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:11:9: ( 'Declare' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:11:11: 'Declare'
            {
            match("Declare"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DECLARE"

    // $ANTLR start "FEATURE"
    public final void mFEATURE() throws RecognitionException {
        try {
            int _type = FEATURE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:12:9: ( 'Feature:' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:12:11: 'Feature:'
            {
            match("Feature:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FEATURE"

    // $ANTLR start "GIVEN"
    public final void mGIVEN() throws RecognitionException {
        try {
            int _type = GIVEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:13:7: ( 'Given' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:13:9: 'Given'
            {
            match("Given"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GIVEN"

    // $ANTLR start "INCLUDE"
    public final void mINCLUDE() throws RecognitionException {
        try {
            int _type = INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:14:9: ( 'Include' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:14:11: 'Include'
            {
            match("Include"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INCLUDE"

    // $ANTLR start "INORDERTO"
    public final void mINORDERTO() throws RecognitionException {
        try {
            int _type = INORDERTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:15:11: ( 'In order to' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:15:13: 'In order to'
            {
            match("In order to"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INORDERTO"

    // $ANTLR start "IWANTTO"
    public final void mIWANTTO() throws RecognitionException {
        try {
            int _type = IWANTTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:16:9: ( 'I want to' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:16:11: 'I want to'
            {
            match("I want to"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IWANTTO"

    // $ANTLR start "PLUGIN"
    public final void mPLUGIN() throws RecognitionException {
        try {
            int _type = PLUGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:17:8: ( 'plugin' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:17:10: 'plugin'
            {
            match("plugin"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUGIN"

    // $ANTLR start "REGISTER"
    public final void mREGISTER() throws RecognitionException {
        try {
            int _type = REGISTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:18:10: ( 'Register' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:18:12: 'Register'
            {
            match("Register"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REGISTER"

    // $ANTLR start "SCENARIO"
    public final void mSCENARIO() throws RecognitionException {
        try {
            int _type = SCENARIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:19:10: ( 'Scenario:' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:19:12: 'Scenario:'
            {
            match("Scenario:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SCENARIO"

    // $ANTLR start "STORE"
    public final void mSTORE() throws RecognitionException {
        try {
            int _type = STORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:20:7: ( 'Store' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:20:9: 'Store'
            {
            match("Store"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STORE"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:21:6: ( 'Then' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:21:8: 'Then'
            {
            match("Then"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "WHEN"
    public final void mWHEN() throws RecognitionException {
        try {
            int _type = WHEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:22:6: ( 'When' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:22:8: 'When'
            {
            match("When"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHEN"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:23:7: ( ':' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:23:9: ':'
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
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:24:7: ( '[' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:24:9: '['
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
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:25:7: ( ']' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:25:9: ']'
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
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:26:7: ( 'false' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:26:9: 'false'
            {
            match("false"); 



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
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:27:7: ( 'null' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:27:9: 'null'
            {
            match("null"); 



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
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:28:7: ( 'true' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:28:9: 'true'
            {
            match("true"); 



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
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:29:7: ( '{' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:29:9: '{'
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
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:30:7: ( '}' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:30:9: '}'
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
    // $ANTLR end "T__69"

    // $ANTLR start "Number"
    public final void mNumber() throws RecognitionException {
        try {
            int _type = Number;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:387:8: ( ( '-' )? ( Digit )+ ( '.' ( Digit )+ )? )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:387:10: ( '-' )? ( Digit )+ ( '.' ( Digit )+ )?
            {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:387:10: ( '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:387:10: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:387:15: ( Digit )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:387:22: ( '.' ( Digit )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='.') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:387:24: '.' ( Digit )+
                    {
                    match('.'); 

                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:387:28: ( Digit )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:
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
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Number"

    // $ANTLR start "Exponent"
    public final void mExponent() throws RecognitionException {
        try {
            int _type = Exponent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:389:9: ( ( 'e' | 'E' ) ( '-' )? ( '1' .. '9' ) ( Digit )* )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:389:11: ( 'e' | 'E' ) ( '-' )? ( '1' .. '9' ) ( Digit )*
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:389:21: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:389:21: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:389:37: ( Digit )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:
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
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Exponent"

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:392:2: ( DoubleCote ( EscapeSequence |~ ( '\\u0000' .. '\\u001f' | '\\\\' | DoubleCote ) )* DoubleCote | Cote ( EscapeSequence |~ ( '\\u0000' .. '\\u001f' | '\\\\' | Cote ) )* Cote )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\"') ) {
                alt9=1;
            }
            else if ( (LA9_0=='\'') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:392:4: DoubleCote ( EscapeSequence |~ ( '\\u0000' .. '\\u001f' | '\\\\' | DoubleCote ) )* DoubleCote
                    {
                    mDoubleCote(); 


                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:392:15: ( EscapeSequence |~ ( '\\u0000' .. '\\u001f' | '\\\\' | DoubleCote ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0 >= ' ' && LA7_0 <= '!')||(LA7_0 >= '#' && LA7_0 <= '[')||(LA7_0 >= ']' && LA7_0 <= '\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:392:17: EscapeSequence
                    	    {
                    	    mEscapeSequence(); 


                    	    }
                    	    break;
                    	case 2 :
                    	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:392:34: ~ ( '\\u0000' .. '\\u001f' | '\\\\' | DoubleCote )
                    	    {
                    	    if ( (input.LA(1) >= ' ' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
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
                    	    break loop7;
                        }
                    } while (true);


                    mDoubleCote(); 


                    }
                    break;
                case 2 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:393:4: Cote ( EscapeSequence |~ ( '\\u0000' .. '\\u001f' | '\\\\' | Cote ) )* Cote
                    {
                    mCote(); 


                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:393:9: ( EscapeSequence |~ ( '\\u0000' .. '\\u001f' | '\\\\' | Cote ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0 >= ' ' && LA8_0 <= '&')||(LA8_0 >= '(' && LA8_0 <= '[')||(LA8_0 >= ']' && LA8_0 <= '\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:393:11: EscapeSequence
                    	    {
                    	    mEscapeSequence(); 


                    	    }
                    	    break;
                    	case 2 :
                    	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:393:28: ~ ( '\\u0000' .. '\\u001f' | '\\\\' | Cote )
                    	    {
                    	    if ( (input.LA(1) >= ' ' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
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
                    } while (true);


                    mCote(); 


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
    // $ANTLR end "String"

    // $ANTLR start "Reference"
    public final void mReference() throws RecognitionException {
        try {
            int _type = Reference;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:396:11: ( Dollar Identifier )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:397:2: Dollar Identifier
            {
            mDollar(); 


            mIdentifier(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Reference"

    // $ANTLR start "Member"
    public final void mMember() throws RecognitionException {
        try {
            int _type = Member;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:400:8: ( Dot Identifier ( LeftBrace ( Identifier | String )? RightBrace )? )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:400:10: Dot Identifier ( LeftBrace ( Identifier | String )? RightBrace )?
            {
            mDot(); 


            mIdentifier(); 


            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:400:25: ( LeftBrace ( Identifier | String )? RightBrace )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='(') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:400:26: LeftBrace ( Identifier | String )? RightBrace
                    {
                    mLeftBrace(); 


                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:400:36: ( Identifier | String )?
                    int alt10=3;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0 >= '0' && LA10_0 <= '9')||(LA10_0 >= 'A' && LA10_0 <= 'Z')||LA10_0=='_'||(LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0=='\"'||LA10_0=='\'') ) {
                        alt10=2;
                    }
                    switch (alt10) {
                        case 1 :
                            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:400:37: Identifier
                            {
                            mIdentifier(); 


                            }
                            break;
                        case 2 :
                            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:400:48: String
                            {
                            mString(); 


                            }
                            break;

                    }


                    mRightBrace(); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Member"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:403:12: ( ( Alphanumeric | UnderScrore )+ )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:404:2: ( Alphanumeric | UnderScrore )+
            {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:404:2: ( Alphanumeric | UnderScrore )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= '0' && LA12_0 <= '9')||(LA12_0 >= 'A' && LA12_0 <= 'Z')||LA12_0=='_'||(LA12_0 >= 'a' && LA12_0 <= 'z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:
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
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Identifier"

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:408:5: ( '#' ( options {greedy=false; } : . )* ( Eol )+ )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:408:7: '#' ( options {greedy=false; } : . )* ( Eol )+
            {
            match('#'); 

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:408:11: ( options {greedy=false; } : . )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='\n') ) {
                    alt13=2;
                }
                else if ( (LA13_0=='\r') ) {
                    int LA13_2 = input.LA(2);

                    if ( (LA13_2=='\n') ) {
                        alt13=2;
                    }
                    else if ( ((LA13_2 >= '\u0000' && LA13_2 <= '\t')||(LA13_2 >= '\u000B' && LA13_2 <= '\uFFFF')) ) {
                        alt13=1;
                    }


                }
                else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '\t')||(LA13_0 >= '\u000B' && LA13_0 <= '\f')||(LA13_0 >= '\u000E' && LA13_0 <= '\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:408:38: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:408:42: ( Eol )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='\n'||LA14_0=='\r') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:408:42: Eol
            	    {
            	    mEol(); 


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Comment"

    // $ANTLR start "Eol"
    public final void mEol() throws RecognitionException {
        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:412:5: ( ( '\\n' ) | ( '\\n' ) ( '\\r' ) | ( '\\r' ) ( '\\n' ) )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n') ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1=='\r') ) {
                    alt15=2;
                }
                else {
                    alt15=1;
                }
            }
            else if ( (LA15_0=='\r') ) {
                alt15=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:412:7: ( '\\n' )
                    {
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:412:7: ( '\\n' )
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:412:8: '\\n'
                    {
                    match('\n'); 

                    }


                    }
                    break;
                case 2 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:413:7: ( '\\n' ) ( '\\r' )
                    {
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:413:7: ( '\\n' )
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:413:8: '\\n'
                    {
                    match('\n'); 

                    }


                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:413:13: ( '\\r' )
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:413:14: '\\r'
                    {
                    match('\r'); 

                    }


                    }
                    break;
                case 3 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:414:7: ( '\\r' ) ( '\\n' )
                    {
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:414:7: ( '\\r' )
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:414:8: '\\r'
                    {
                    match('\r'); 

                    }


                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:414:13: ( '\\n' )
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:414:14: '\\n'
                    {
                    match('\n'); 

                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Eol"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:417:3: ( ( ' ' | Eol | '\\t' )+ )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:417:5: ( ' ' | Eol | '\\t' )+
            {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:417:5: ( ' ' | Eol | '\\t' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=4;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt16=1;
                    }
                    break;
                case '\n':
                case '\r':
                    {
                    alt16=2;
                    }
                    break;
                case '\t':
                    {
                    alt16=3;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:417:6: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:417:10: Eol
            	    {
            	    mEol(); 


            	    }
            	    break;
            	case 3 :
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:417:14: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


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

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:420:6: ( '\\\\' ( UnicodeEscape | 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | '\\/' ) )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:420:10: '\\\\' ( UnicodeEscape | 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | '\\/' )
            {
            match('\\'); 

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:420:15: ( UnicodeEscape | 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | '\\/' )
            int alt17=10;
            switch ( input.LA(1) ) {
            case 'u':
                {
                alt17=1;
                }
                break;
            case 'b':
                {
                alt17=2;
                }
                break;
            case 't':
                {
                alt17=3;
                }
                break;
            case 'n':
                {
                alt17=4;
                }
                break;
            case 'f':
                {
                alt17=5;
                }
                break;
            case 'r':
                {
                alt17=6;
                }
                break;
            case '\"':
                {
                alt17=7;
                }
                break;
            case '\'':
                {
                alt17=8;
                }
                break;
            case '\\':
                {
                alt17=9;
                }
                break;
            case '/':
                {
                alt17=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:420:16: UnicodeEscape
                    {
                    mUnicodeEscape(); 


                    }
                    break;
                case 2 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:420:31: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 3 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:420:35: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:420:39: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 5 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:420:43: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:420:47: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 7 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:420:51: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 8 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:420:56: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 9 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:420:61: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 10 :
                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:420:66: '\\/'
                    {
                    match('/'); 

                    }
                    break;

            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "UnderScrore"
    public final void mUnderScrore() throws RecognitionException {
        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:424:2: ( '_' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:424:4: '_'
            {
            match('_'); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UnderScrore"

    // $ANTLR start "LeftBrace"
    public final void mLeftBrace() throws RecognitionException {
        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:428:2: ( '(' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:428:4: '('
            {
            match('('); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LeftBrace"

    // $ANTLR start "RightBrace"
    public final void mRightBrace() throws RecognitionException {
        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:432:2: ( ')' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:432:4: ')'
            {
            match(')'); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RightBrace"

    // $ANTLR start "Dollar"
    public final void mDollar() throws RecognitionException {
        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:436:2: ( '$' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:436:4: '$'
            {
            match('$'); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Dollar"

    // $ANTLR start "Cote"
    public final void mCote() throws RecognitionException {
        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:440:2: ( '\\'' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:440:4: '\\''
            {
            match('\''); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Cote"

    // $ANTLR start "DoubleCote"
    public final void mDoubleCote() throws RecognitionException {
        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:444:2: ( '\"' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:444:4: '\"'
            {
            match('\"'); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DoubleCote"

    // $ANTLR start "Dot"
    public final void mDot() throws RecognitionException {
        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:448:2: ( '.' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:448:4: '.'
            {
            match('.'); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Dot"

    // $ANTLR start "UnicodeEscape"
    public final void mUnicodeEscape() throws RecognitionException {
        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:452:2: ( 'u' HexDigit HexDigit HexDigit HexDigit )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:452:4: 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('u'); 

            mHexDigit(); 


            mHexDigit(); 


            mHexDigit(); 


            mHexDigit(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UnicodeEscape"

    // $ANTLR start "Alphanumeric"
    public final void mAlphanumeric() throws RecognitionException {
        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:456:2: ( '0' .. '9' | 'A' .. 'Z' | 'a' .. 'z' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
    // $ANTLR end "Alphanumeric"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:460:2: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:
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
    // $ANTLR end "HexDigit"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:464:2: ( '0' .. '9' )
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:
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


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Digit"

    public void mTokens() throws RecognitionException {
        // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:8: ( AND | ASAN | COMMA | DECLARE | FEATURE | GIVEN | INCLUDE | INORDERTO | IWANTTO | PLUGIN | REGISTER | SCENARIO | STORE | THEN | WHEN | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | Number | Exponent | String | Reference | Member | Identifier | Comment | WS )
        int alt18=31;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:10: AND
                {
                mAND(); 


                }
                break;
            case 2 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:14: ASAN
                {
                mASAN(); 


                }
                break;
            case 3 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:19: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 4 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:25: DECLARE
                {
                mDECLARE(); 


                }
                break;
            case 5 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:33: FEATURE
                {
                mFEATURE(); 


                }
                break;
            case 6 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:41: GIVEN
                {
                mGIVEN(); 


                }
                break;
            case 7 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:47: INCLUDE
                {
                mINCLUDE(); 


                }
                break;
            case 8 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:55: INORDERTO
                {
                mINORDERTO(); 


                }
                break;
            case 9 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:65: IWANTTO
                {
                mIWANTTO(); 


                }
                break;
            case 10 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:73: PLUGIN
                {
                mPLUGIN(); 


                }
                break;
            case 11 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:80: REGISTER
                {
                mREGISTER(); 


                }
                break;
            case 12 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:89: SCENARIO
                {
                mSCENARIO(); 


                }
                break;
            case 13 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:98: STORE
                {
                mSTORE(); 


                }
                break;
            case 14 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:104: THEN
                {
                mTHEN(); 


                }
                break;
            case 15 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:109: WHEN
                {
                mWHEN(); 


                }
                break;
            case 16 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:114: T__62
                {
                mT__62(); 


                }
                break;
            case 17 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:120: T__63
                {
                mT__63(); 


                }
                break;
            case 18 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:126: T__64
                {
                mT__64(); 


                }
                break;
            case 19 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:132: T__65
                {
                mT__65(); 


                }
                break;
            case 20 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:138: T__66
                {
                mT__66(); 


                }
                break;
            case 21 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:144: T__67
                {
                mT__67(); 


                }
                break;
            case 22 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:150: T__68
                {
                mT__68(); 


                }
                break;
            case 23 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:156: T__69
                {
                mT__69(); 


                }
                break;
            case 24 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:162: Number
                {
                mNumber(); 


                }
                break;
            case 25 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:169: Exponent
                {
                mExponent(); 


                }
                break;
            case 26 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:178: String
                {
                mString(); 


                }
                break;
            case 27 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:185: Reference
                {
                mReference(); 


                }
                break;
            case 28 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:195: Member
                {
                mMember(); 


                }
                break;
            case 29 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:202: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 30 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:213: Comment
                {
                mComment(); 


                }
                break;
            case 31 :
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:1:221: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\1\uffff\1\32\1\uffff\11\32\3\uffff\3\32\3\uffff\1\24\1\32\6\uffff"+
        "\6\32\1\uffff\11\32\1\uffff\1\55\1\100\1\uffff\4\32\1\uffff\11\32"+
        "\1\55\1\uffff\10\32\1\126\1\127\1\32\1\131\1\132\2\32\1\135\4\32"+
        "\1\142\2\uffff\1\143\2\uffff\2\32\1\uffff\1\32\1\147\2\32\2\uffff"+
        "\1\152\1\32\1\154\1\uffff\2\32\3\uffff\1\157\1\32\2\uffff";
    static final String DFA18_eofS =
        "\161\uffff";
    static final String DFA18_minS =
        "\1\11\1\156\1\uffff\2\145\1\151\1\40\1\154\1\145\1\143\2\150\3\uffff"+
        "\1\141\1\165\1\162\3\uffff\1\60\1\55\6\uffff\1\144\1\40\1\143\1"+
        "\141\1\166\1\40\1\uffff\1\165\1\147\1\145\1\157\2\145\2\154\1\165"+
        "\1\uffff\2\60\1\uffff\1\154\1\164\1\145\1\154\1\uffff\1\147\1\151"+
        "\1\156\1\162\2\156\1\163\1\154\1\145\1\60\1\uffff\1\141\1\165\1"+
        "\156\1\165\1\151\1\163\1\141\1\145\2\60\1\145\2\60\2\162\1\60\1"+
        "\144\1\156\1\164\1\162\1\60\2\uffff\1\60\2\uffff\2\145\1\uffff\1"+
        "\145\1\60\1\145\1\151\2\uffff\1\60\1\72\1\60\1\uffff\1\162\1\157"+
        "\3\uffff\1\60\1\72\2\uffff";
    static final String DFA18_maxS =
        "\1\175\1\163\1\uffff\2\145\1\151\1\156\1\154\1\145\1\164\2\150\3"+
        "\uffff\1\141\1\165\1\162\3\uffff\1\172\1\71\6\uffff\1\144\1\40\1"+
        "\143\1\141\1\166\1\143\1\uffff\1\165\1\147\1\145\1\157\2\145\2\154"+
        "\1\165\1\uffff\2\172\1\uffff\1\154\1\164\1\145\1\154\1\uffff\1\147"+
        "\1\151\1\156\1\162\2\156\1\163\1\154\1\145\1\172\1\uffff\1\141\1"+
        "\165\1\156\1\165\1\151\1\163\1\141\1\145\2\172\1\145\2\172\2\162"+
        "\1\172\1\144\1\156\1\164\1\162\1\172\2\uffff\1\172\2\uffff\2\145"+
        "\1\uffff\1\145\1\172\1\145\1\151\2\uffff\1\172\1\72\1\172\1\uffff"+
        "\1\162\1\157\3\uffff\1\172\1\72\2\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\3\11\uffff\1\20\1\21\1\22\3\uffff\1\26\1\27\1\30\2\uffff"+
        "\1\32\1\33\1\34\1\35\1\36\1\37\6\uffff\1\11\11\uffff\1\31\2\uffff"+
        "\1\2\4\uffff\1\10\12\uffff\1\1\25\uffff\1\16\1\17\1\uffff\1\24\1"+
        "\25\2\uffff\1\6\4\uffff\1\15\1\23\3\uffff\1\12\2\uffff\1\4\1\5\1"+
        "\7\2\uffff\1\13\1\14";
    static final String DFA18_specialS =
        "\161\uffff}>";
    static final String[] DFA18_transitionS = {
            "\2\34\2\uffff\1\34\22\uffff\1\34\1\uffff\1\27\1\33\1\30\2\uffff"+
            "\1\27\4\uffff\1\2\1\24\1\31\1\uffff\12\25\1\14\6\uffff\1\1\2"+
            "\32\1\3\1\26\1\4\1\5\1\32\1\6\10\32\1\10\1\11\1\12\2\32\1\13"+
            "\3\32\1\15\1\uffff\1\16\1\uffff\1\32\1\uffff\4\32\1\26\1\17"+
            "\7\32\1\20\1\32\1\7\3\32\1\21\6\32\1\22\1\uffff\1\23",
            "\1\35\4\uffff\1\36",
            "",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\43\115\uffff\1\42",
            "\1\44",
            "\1\45",
            "\1\46\20\uffff\1\47",
            "\1\50",
            "\1\51",
            "",
            "",
            "",
            "\1\52",
            "\1\53",
            "\1\54",
            "",
            "",
            "",
            "\12\25\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\55\3\uffff\11\56",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\65\102\uffff\1\64",
            "",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "",
            "\12\77\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\12\77\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\130",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\133",
            "\1\134",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\1\144",
            "\1\145",
            "",
            "\1\146",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\150",
            "\1\151",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\153",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\155",
            "\1\156",
            "",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\160",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( AND | ASAN | COMMA | DECLARE | FEATURE | GIVEN | INCLUDE | INORDERTO | IWANTTO | PLUGIN | REGISTER | SCENARIO | STORE | THEN | WHEN | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | Number | Exponent | String | Reference | Member | Identifier | Comment | WS );";
        }
    }
 

}