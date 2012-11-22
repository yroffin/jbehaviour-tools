// $ANTLR 3.4 D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g 2012-11-22 22:17:18

    package org.jbehaviour.antlr;
    import java.io.IOException;
    import java.util.regex.Pattern;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


/**
 * @author Roffin Yannick
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class AnotherStoryGrammerParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARRAY", "ASAN", "Alphanumeric", "COMMA", "Comment", "Cote", "DECLARE", "Digit", "Dollar", "Dot", "DoubleCote", "Eol", "EscapeSequence", "Exponent", "FALSE", "FEATURE", "FIELD", "GIVEN", "HexDigit", "INCLUDE", "INORDERTO", "IWANTTO", "Identifier", "LeftBrace", "Member", "NULL", "NUMBER", "Number", "OBJECT", "PLUGIN", "REGISTER", "Reference", "RightBrace", "SCENARIO", "STORE", "STRING", "String", "THEN", "TOK_AND", "TOK_ASAN", "TOK_DECLARE", "TOK_FEATURE", "TOK_GIVEN", "TOK_INCLUDE", "TOK_INORDERTO", "TOK_IWANTTO", "TOK_REGISTER", "TOK_SCENARIO", "TOK_STORE", "TOK_TEMPLATE", "TOK_THEN", "TOK_WHEN", "TRUE", "UnderScrore", "UnicodeEscape", "WHEN", "WS", "':'", "'['", "']'", "'false'", "'null'", "'true'", "'{'", "'}'"
    };

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
    public static final int STORE=39;
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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "array", "scenario", "asAnDecl", "elements", "anyDeclEndedByPlugin", 
    "number", "iWantToDecl", "member", "identifier", "scenarioKeyword", 
    "statementDecl", "thenDecl", "members", "inOrderToDecl", "registerDecl", 
    "giveDecl", "andDecl", "includeDecl", "givenKeyword", "anyDecl", "reference", 
    "story", "template", "whenKeyword", "thenKeyword", "pair", "andKeyword", 
    "featureDecl", "jsonValue", "declareDecl", "jsonObject", "string", "storeDecl", 
    "feature", "whenDecl", "integer", "anyStringDecl"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public AnotherStoryGrammerParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public AnotherStoryGrammerParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this,port,adaptor);
        setDebugListener(proxy);
        setTokenStream(new DebugTokenStream(input,proxy));
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);
        proxy.setTreeAdaptor(adap);
    }

public AnotherStoryGrammerParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg);
     
    TreeAdaptor adap = new CommonTreeAdaptor();
    setTreeAdaptor(adap);


}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

protected DebugTreeAdaptor adaptor;
public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = new DebugTreeAdaptor(dbg,adaptor);


}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}

    public String[] getTokenNames() { return AnotherStoryGrammerParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g"; }


    	enum Situation {
    		none,
    		onGivenKeyword,
    		onWhenKeyword,
    		onThenKeyword
    	};
    	Situation situation = Situation.none;
    	/**
    	 * debug
    	 */
        	public void onDebug(String where,String value) {
        		System.err.println(where+" "+value);
        	}
    	/**
    	 * feature
    	 */
        	public void onFeatureKeyword() {
        		onDebug("onFeatureKeyword","");
        	}
    	/**
    	 * feature
    	 * Declare reference as String 'string'
    	 */
        	public void onFeatureDeclareKeyword() {
        		onDebug("onFeatureDeclareKeyword","");
        	}
    	/**
    	 * feature
    	 * In order to test this feature
    	 * As an explicit system actor
    	 * I want to verify this behaviour
    	 */
        	public void onFeatureInOrderToKeyword() {
        		onDebug("onFeatureInOrderToKeyword","");
        	}
        	public void onFeatureAsAnKeyword() {
        		onDebug("onFeatureAsAnKeyword","");
        	}
        	public void onFeatureIWantToKeyword() {
        		onDebug("onFeatureIWantToKeyword","");
        	}
    	/**
    	 * feature
    	 * Register system with 'org.jbehaviour.plugins.system.SystemSteps' plugin
    	 */
        	public void onFeatureRegisterKeyword() {
        		onDebug("onFeatureRegisterKeyword","");
        	}
    	/**
    	 * feature
    	 * Include 'file.story'
    	 */
        	public void onFeatureIncludeKeyword() {
        		onDebug("onFeatureIncludeKeyword","");
        	}
        	/**
        	 * scenario
        	 * Scenario: Verify we can go to 'http://www.bing.com'
        	 */
        	public void onScenarioKeyword() {
        		onDebug("onScenarioKeyword","");
        	}
        	/**
        	 * simulate given, when then according to the
        	 * situation
        	 */
        	public void onAndKeyword() {
        		switch(situation) {
        			case onGivenKeyword:
        				onGivenKeyword();
        				break;
        			case onThenKeyword:
        				onThenKeyword();
        				break;
        			case onWhenKeyword:
        				onWhenKeyword();
        				break;
        		}
        	}
        	public void onGivenKeyword() {
        		situation = Situation.onGivenKeyword;
        		onDebug("onGivenKeyword","");
        	}
        	public void onWhenKeyword() {
        		situation = Situation.onWhenKeyword;
        		onDebug("onWhenKeyword","");
        	}
        	public void onThenKeyword() {
        		situation = Situation.onThenKeyword;
        		onDebug("onThenKeyword","");
        	}
        	public void onStoreKeyword() {
        		onDebug("onStoreKeyword","");
        	}
        	/**
        	 * implement any words analysis
        	 */
        	public void onAnyKeyword() {
        		onDebug("onAnyKeyword","");
        	}
        	/**
        	 * rewrite any implementation
        	 */
        	public void onAnyString(String value) {
        		onDebug("onAnyString",value);
        	}
        	public void onAnyIdentifier(String value) {
        		onDebug("onAnyIdentifier",value);
        	}
        	public void onAnyReference(String value) {
        		onDebug("onAnyReference",value);
        	}
        	public void onAnyTemplate(String value) {
        		onDebug("onAnyTemplate",value);
        	}
        	public void onAnyNumeric(String value) {
        		onDebug("onAnyNumeric",value);
        	}
        	public void onAnyJsonObject(String value) {
        		onDebug("onAnyJsonObject",value);
        	}


    public static class story_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "story"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:218:1: story : feature ( scenario )* ;
    public final AnotherStoryGrammerParser.story_return story() throws RecognitionException {
        AnotherStoryGrammerParser.story_return retval = new AnotherStoryGrammerParser.story_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        AnotherStoryGrammerParser.feature_return feature1 =null;

        AnotherStoryGrammerParser.scenario_return scenario2 =null;



        try { dbg.enterRule(getGrammarFileName(), "story");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(218, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:219:2: ( feature ( scenario )* )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:219:4: feature ( scenario )*
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(219,4);
            pushFollow(FOLLOW_feature_in_story263);
            feature1=feature();

            state._fsp--;

            adaptor.addChild(root_0, feature1.getTree());
            dbg.location(219,12);
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:219:12: ( scenario )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==SCENARIO) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:219:13: scenario
            	    {
            	    dbg.location(219,13);
            	    pushFollow(FOLLOW_scenario_in_story266);
            	    scenario2=scenario();

            	    state._fsp--;

            	    adaptor.addChild(root_0, scenario2.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(220, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "story");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "story"


    public static class feature_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "feature"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:222:1: feature : FEATURE anyDecl featureDecl -> ^( TOK_FEATURE FEATURE anyDecl featureDecl ) ;
    public final AnotherStoryGrammerParser.feature_return feature() throws RecognitionException {
        AnotherStoryGrammerParser.feature_return retval = new AnotherStoryGrammerParser.feature_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token FEATURE3=null;
        AnotherStoryGrammerParser.anyDecl_return anyDecl4 =null;

        AnotherStoryGrammerParser.featureDecl_return featureDecl5 =null;


        CommonTree FEATURE3_tree=null;
        RewriteRuleTokenStream stream_FEATURE=new RewriteRuleTokenStream(adaptor,"token FEATURE");
        RewriteRuleSubtreeStream stream_anyDecl=new RewriteRuleSubtreeStream(adaptor,"rule anyDecl");
        RewriteRuleSubtreeStream stream_featureDecl=new RewriteRuleSubtreeStream(adaptor,"rule featureDecl");
        try { dbg.enterRule(getGrammarFileName(), "feature");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(222, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:222:8: ( FEATURE anyDecl featureDecl -> ^( TOK_FEATURE FEATURE anyDecl featureDecl ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:222:10: FEATURE anyDecl featureDecl
            {
            dbg.location(222,10);
            FEATURE3=(Token)match(input,FEATURE,FOLLOW_FEATURE_in_feature277);  
            stream_FEATURE.add(FEATURE3);

            dbg.location(222,18);
            onFeatureKeyword();
            dbg.location(222,40);
            pushFollow(FOLLOW_anyDecl_in_feature281);
            anyDecl4=anyDecl();

            state._fsp--;

            stream_anyDecl.add(anyDecl4.getTree());
            dbg.location(222,48);
            pushFollow(FOLLOW_featureDecl_in_feature283);
            featureDecl5=featureDecl();

            state._fsp--;

            stream_featureDecl.add(featureDecl5.getTree());

            // AST REWRITE
            // elements: anyDecl, featureDecl, FEATURE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 223:4: -> ^( TOK_FEATURE FEATURE anyDecl featureDecl )
            {
                dbg.location(223,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:223:7: ^( TOK_FEATURE FEATURE anyDecl featureDecl )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(223,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_FEATURE, "TOK_FEATURE")
                , root_1);

                dbg.location(223,21);
                adaptor.addChild(root_1, 
                stream_FEATURE.nextNode()
                );
                dbg.location(223,29);
                adaptor.addChild(root_1, stream_anyDecl.nextTree());
                dbg.location(223,37);
                adaptor.addChild(root_1, stream_featureDecl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(224, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "feature");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "feature"


    public static class featureDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "featureDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:226:1: featureDecl : inOrderToDecl asAnDecl iWantToDecl ( includeDecl | registerDecl | declareDecl )* ;
    public final AnotherStoryGrammerParser.featureDecl_return featureDecl() throws RecognitionException {
        AnotherStoryGrammerParser.featureDecl_return retval = new AnotherStoryGrammerParser.featureDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        AnotherStoryGrammerParser.inOrderToDecl_return inOrderToDecl6 =null;

        AnotherStoryGrammerParser.asAnDecl_return asAnDecl7 =null;

        AnotherStoryGrammerParser.iWantToDecl_return iWantToDecl8 =null;

        AnotherStoryGrammerParser.includeDecl_return includeDecl9 =null;

        AnotherStoryGrammerParser.registerDecl_return registerDecl10 =null;

        AnotherStoryGrammerParser.declareDecl_return declareDecl11 =null;



        try { dbg.enterRule(getGrammarFileName(), "featureDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(226, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:227:2: ( inOrderToDecl asAnDecl iWantToDecl ( includeDecl | registerDecl | declareDecl )* )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:227:4: inOrderToDecl asAnDecl iWantToDecl ( includeDecl | registerDecl | declareDecl )*
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(227,4);
            pushFollow(FOLLOW_inOrderToDecl_in_featureDecl309);
            inOrderToDecl6=inOrderToDecl();

            state._fsp--;

            adaptor.addChild(root_0, inOrderToDecl6.getTree());
            dbg.location(227,18);
            pushFollow(FOLLOW_asAnDecl_in_featureDecl311);
            asAnDecl7=asAnDecl();

            state._fsp--;

            adaptor.addChild(root_0, asAnDecl7.getTree());
            dbg.location(227,27);
            pushFollow(FOLLOW_iWantToDecl_in_featureDecl313);
            iWantToDecl8=iWantToDecl();

            state._fsp--;

            adaptor.addChild(root_0, iWantToDecl8.getTree());
            dbg.location(227,39);
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:227:39: ( includeDecl | registerDecl | declareDecl )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=4;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                switch ( input.LA(1) ) {
                case INCLUDE:
                    {
                    alt2=1;
                    }
                    break;
                case REGISTER:
                    {
                    alt2=2;
                    }
                    break;
                case DECLARE:
                    {
                    alt2=3;
                    }
                    break;

                }

                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:227:40: includeDecl
            	    {
            	    dbg.location(227,40);
            	    pushFollow(FOLLOW_includeDecl_in_featureDecl316);
            	    includeDecl9=includeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, includeDecl9.getTree());

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:227:52: registerDecl
            	    {
            	    dbg.location(227,52);
            	    pushFollow(FOLLOW_registerDecl_in_featureDecl318);
            	    registerDecl10=registerDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, registerDecl10.getTree());

            	    }
            	    break;
            	case 3 :
            	    dbg.enterAlt(3);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:227:65: declareDecl
            	    {
            	    dbg.location(227,65);
            	    pushFollow(FOLLOW_declareDecl_in_featureDecl320);
            	    declareDecl11=declareDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, declareDecl11.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);
            } finally {dbg.exitSubRule(2);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(228, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "featureDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "featureDecl"


    public static class inOrderToDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "inOrderToDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:230:1: inOrderToDecl : INORDERTO anyDecl -> ^( TOK_INORDERTO INORDERTO anyDecl ) ;
    public final AnotherStoryGrammerParser.inOrderToDecl_return inOrderToDecl() throws RecognitionException {
        AnotherStoryGrammerParser.inOrderToDecl_return retval = new AnotherStoryGrammerParser.inOrderToDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token INORDERTO12=null;
        AnotherStoryGrammerParser.anyDecl_return anyDecl13 =null;


        CommonTree INORDERTO12_tree=null;
        RewriteRuleTokenStream stream_INORDERTO=new RewriteRuleTokenStream(adaptor,"token INORDERTO");
        RewriteRuleSubtreeStream stream_anyDecl=new RewriteRuleSubtreeStream(adaptor,"rule anyDecl");
        try { dbg.enterRule(getGrammarFileName(), "inOrderToDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(230, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:230:14: ( INORDERTO anyDecl -> ^( TOK_INORDERTO INORDERTO anyDecl ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:230:16: INORDERTO anyDecl
            {
            dbg.location(230,16);
            INORDERTO12=(Token)match(input,INORDERTO,FOLLOW_INORDERTO_in_inOrderToDecl331);  
            stream_INORDERTO.add(INORDERTO12);

            dbg.location(230,26);
            pushFollow(FOLLOW_anyDecl_in_inOrderToDecl333);
            anyDecl13=anyDecl();

            state._fsp--;

            stream_anyDecl.add(anyDecl13.getTree());

            // AST REWRITE
            // elements: anyDecl, INORDERTO
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 231:4: -> ^( TOK_INORDERTO INORDERTO anyDecl )
            {
                dbg.location(231,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:231:7: ^( TOK_INORDERTO INORDERTO anyDecl )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(231,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_INORDERTO, "TOK_INORDERTO")
                , root_1);

                dbg.location(231,23);
                adaptor.addChild(root_1, 
                stream_INORDERTO.nextNode()
                );
                dbg.location(231,33);
                adaptor.addChild(root_1, stream_anyDecl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(232, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "inOrderToDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "inOrderToDecl"


    public static class asAnDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "asAnDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:233:1: asAnDecl : ASAN anyDecl -> ^( TOK_ASAN ASAN anyDecl ) ;
    public final AnotherStoryGrammerParser.asAnDecl_return asAnDecl() throws RecognitionException {
        AnotherStoryGrammerParser.asAnDecl_return retval = new AnotherStoryGrammerParser.asAnDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ASAN14=null;
        AnotherStoryGrammerParser.anyDecl_return anyDecl15 =null;


        CommonTree ASAN14_tree=null;
        RewriteRuleTokenStream stream_ASAN=new RewriteRuleTokenStream(adaptor,"token ASAN");
        RewriteRuleSubtreeStream stream_anyDecl=new RewriteRuleSubtreeStream(adaptor,"rule anyDecl");
        try { dbg.enterRule(getGrammarFileName(), "asAnDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(233, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:233:9: ( ASAN anyDecl -> ^( TOK_ASAN ASAN anyDecl ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:233:11: ASAN anyDecl
            {
            dbg.location(233,11);
            ASAN14=(Token)match(input,ASAN,FOLLOW_ASAN_in_asAnDecl354);  
            stream_ASAN.add(ASAN14);

            dbg.location(233,16);
            pushFollow(FOLLOW_anyDecl_in_asAnDecl356);
            anyDecl15=anyDecl();

            state._fsp--;

            stream_anyDecl.add(anyDecl15.getTree());

            // AST REWRITE
            // elements: anyDecl, ASAN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 234:4: -> ^( TOK_ASAN ASAN anyDecl )
            {
                dbg.location(234,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:234:7: ^( TOK_ASAN ASAN anyDecl )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(234,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_ASAN, "TOK_ASAN")
                , root_1);

                dbg.location(234,18);
                adaptor.addChild(root_1, 
                stream_ASAN.nextNode()
                );
                dbg.location(234,23);
                adaptor.addChild(root_1, stream_anyDecl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(235, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "asAnDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "asAnDecl"


    public static class iWantToDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "iWantToDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:236:1: iWantToDecl : IWANTTO anyDecl -> ^( TOK_IWANTTO IWANTTO anyDecl ) ;
    public final AnotherStoryGrammerParser.iWantToDecl_return iWantToDecl() throws RecognitionException {
        AnotherStoryGrammerParser.iWantToDecl_return retval = new AnotherStoryGrammerParser.iWantToDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token IWANTTO16=null;
        AnotherStoryGrammerParser.anyDecl_return anyDecl17 =null;


        CommonTree IWANTTO16_tree=null;
        RewriteRuleTokenStream stream_IWANTTO=new RewriteRuleTokenStream(adaptor,"token IWANTTO");
        RewriteRuleSubtreeStream stream_anyDecl=new RewriteRuleSubtreeStream(adaptor,"rule anyDecl");
        try { dbg.enterRule(getGrammarFileName(), "iWantToDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(236, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:236:12: ( IWANTTO anyDecl -> ^( TOK_IWANTTO IWANTTO anyDecl ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:236:14: IWANTTO anyDecl
            {
            dbg.location(236,14);
            IWANTTO16=(Token)match(input,IWANTTO,FOLLOW_IWANTTO_in_iWantToDecl377);  
            stream_IWANTTO.add(IWANTTO16);

            dbg.location(236,22);
            pushFollow(FOLLOW_anyDecl_in_iWantToDecl379);
            anyDecl17=anyDecl();

            state._fsp--;

            stream_anyDecl.add(anyDecl17.getTree());

            // AST REWRITE
            // elements: anyDecl, IWANTTO
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 237:4: -> ^( TOK_IWANTTO IWANTTO anyDecl )
            {
                dbg.location(237,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:237:7: ^( TOK_IWANTTO IWANTTO anyDecl )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(237,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_IWANTTO, "TOK_IWANTTO")
                , root_1);

                dbg.location(237,21);
                adaptor.addChild(root_1, 
                stream_IWANTTO.nextNode()
                );
                dbg.location(237,29);
                adaptor.addChild(root_1, stream_anyDecl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(238, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "iWantToDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "iWantToDecl"


    public static class includeDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "includeDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:239:1: includeDecl : INCLUDE anyStringDecl -> ^( TOK_INCLUDE INCLUDE anyStringDecl ) ;
    public final AnotherStoryGrammerParser.includeDecl_return includeDecl() throws RecognitionException {
        AnotherStoryGrammerParser.includeDecl_return retval = new AnotherStoryGrammerParser.includeDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token INCLUDE18=null;
        AnotherStoryGrammerParser.anyStringDecl_return anyStringDecl19 =null;


        CommonTree INCLUDE18_tree=null;
        RewriteRuleTokenStream stream_INCLUDE=new RewriteRuleTokenStream(adaptor,"token INCLUDE");
        RewriteRuleSubtreeStream stream_anyStringDecl=new RewriteRuleSubtreeStream(adaptor,"rule anyStringDecl");
        try { dbg.enterRule(getGrammarFileName(), "includeDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(239, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:239:12: ( INCLUDE anyStringDecl -> ^( TOK_INCLUDE INCLUDE anyStringDecl ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:239:14: INCLUDE anyStringDecl
            {
            dbg.location(239,14);
            INCLUDE18=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_includeDecl400);  
            stream_INCLUDE.add(INCLUDE18);

            dbg.location(239,22);
            onFeatureIncludeKeyword();
            dbg.location(239,51);
            pushFollow(FOLLOW_anyStringDecl_in_includeDecl404);
            anyStringDecl19=anyStringDecl();

            state._fsp--;

            stream_anyStringDecl.add(anyStringDecl19.getTree());

            // AST REWRITE
            // elements: anyStringDecl, INCLUDE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 240:4: -> ^( TOK_INCLUDE INCLUDE anyStringDecl )
            {
                dbg.location(240,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:240:7: ^( TOK_INCLUDE INCLUDE anyStringDecl )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(240,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_INCLUDE, "TOK_INCLUDE")
                , root_1);

                dbg.location(240,21);
                adaptor.addChild(root_1, 
                stream_INCLUDE.nextNode()
                );
                dbg.location(240,29);
                adaptor.addChild(root_1, stream_anyStringDecl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(241, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "includeDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "includeDecl"


    public static class registerDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "registerDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:242:1: registerDecl : REGISTER anyDeclEndedByPlugin -> ^( TOK_REGISTER REGISTER anyDeclEndedByPlugin ) ;
    public final AnotherStoryGrammerParser.registerDecl_return registerDecl() throws RecognitionException {
        AnotherStoryGrammerParser.registerDecl_return retval = new AnotherStoryGrammerParser.registerDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token REGISTER20=null;
        AnotherStoryGrammerParser.anyDeclEndedByPlugin_return anyDeclEndedByPlugin21 =null;


        CommonTree REGISTER20_tree=null;
        RewriteRuleTokenStream stream_REGISTER=new RewriteRuleTokenStream(adaptor,"token REGISTER");
        RewriteRuleSubtreeStream stream_anyDeclEndedByPlugin=new RewriteRuleSubtreeStream(adaptor,"rule anyDeclEndedByPlugin");
        try { dbg.enterRule(getGrammarFileName(), "registerDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(242, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:242:13: ( REGISTER anyDeclEndedByPlugin -> ^( TOK_REGISTER REGISTER anyDeclEndedByPlugin ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:242:15: REGISTER anyDeclEndedByPlugin
            {
            dbg.location(242,15);
            REGISTER20=(Token)match(input,REGISTER,FOLLOW_REGISTER_in_registerDecl425);  
            stream_REGISTER.add(REGISTER20);

            dbg.location(242,24);
            onFeatureRegisterKeyword();
            dbg.location(242,54);
            pushFollow(FOLLOW_anyDeclEndedByPlugin_in_registerDecl429);
            anyDeclEndedByPlugin21=anyDeclEndedByPlugin();

            state._fsp--;

            stream_anyDeclEndedByPlugin.add(anyDeclEndedByPlugin21.getTree());

            // AST REWRITE
            // elements: anyDeclEndedByPlugin, REGISTER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 243:4: -> ^( TOK_REGISTER REGISTER anyDeclEndedByPlugin )
            {
                dbg.location(243,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:243:7: ^( TOK_REGISTER REGISTER anyDeclEndedByPlugin )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(243,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_REGISTER, "TOK_REGISTER")
                , root_1);

                dbg.location(243,22);
                adaptor.addChild(root_1, 
                stream_REGISTER.nextNode()
                );
                dbg.location(243,31);
                adaptor.addChild(root_1, stream_anyDeclEndedByPlugin.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(244, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "registerDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "registerDecl"


    public static class declareDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "declareDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:245:1: declareDecl : DECLARE anyDecl -> ^( TOK_DECLARE DECLARE anyDecl ) ;
    public final AnotherStoryGrammerParser.declareDecl_return declareDecl() throws RecognitionException {
        AnotherStoryGrammerParser.declareDecl_return retval = new AnotherStoryGrammerParser.declareDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DECLARE22=null;
        AnotherStoryGrammerParser.anyDecl_return anyDecl23 =null;


        CommonTree DECLARE22_tree=null;
        RewriteRuleTokenStream stream_DECLARE=new RewriteRuleTokenStream(adaptor,"token DECLARE");
        RewriteRuleSubtreeStream stream_anyDecl=new RewriteRuleSubtreeStream(adaptor,"rule anyDecl");
        try { dbg.enterRule(getGrammarFileName(), "declareDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(245, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:245:12: ( DECLARE anyDecl -> ^( TOK_DECLARE DECLARE anyDecl ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:245:14: DECLARE anyDecl
            {
            dbg.location(245,14);
            DECLARE22=(Token)match(input,DECLARE,FOLLOW_DECLARE_in_declareDecl450);  
            stream_DECLARE.add(DECLARE22);

            dbg.location(245,22);
            onFeatureDeclareKeyword();
            dbg.location(245,51);
            pushFollow(FOLLOW_anyDecl_in_declareDecl454);
            anyDecl23=anyDecl();

            state._fsp--;

            stream_anyDecl.add(anyDecl23.getTree());

            // AST REWRITE
            // elements: anyDecl, DECLARE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 246:4: -> ^( TOK_DECLARE DECLARE anyDecl )
            {
                dbg.location(246,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:246:7: ^( TOK_DECLARE DECLARE anyDecl )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(246,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_DECLARE, "TOK_DECLARE")
                , root_1);

                dbg.location(246,21);
                adaptor.addChild(root_1, 
                stream_DECLARE.nextNode()
                );
                dbg.location(246,29);
                adaptor.addChild(root_1, stream_anyDecl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(247, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "declareDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "declareDecl"


    public static class scenarioKeyword_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scenarioKeyword"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:249:1: scenarioKeyword : SCENARIO ;
    public final AnotherStoryGrammerParser.scenarioKeyword_return scenarioKeyword() throws RecognitionException {
        AnotherStoryGrammerParser.scenarioKeyword_return retval = new AnotherStoryGrammerParser.scenarioKeyword_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token SCENARIO24=null;

        CommonTree SCENARIO24_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "scenarioKeyword");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(249, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:250:2: ( SCENARIO )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:250:4: SCENARIO
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(250,4);
            SCENARIO24=(Token)match(input,SCENARIO,FOLLOW_SCENARIO_in_scenarioKeyword478); 
            SCENARIO24_tree = 
            (CommonTree)adaptor.create(SCENARIO24)
            ;
            adaptor.addChild(root_0, SCENARIO24_tree);

            dbg.location(250,13);
            onScenarioKeyword();

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(251, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "scenarioKeyword");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "scenarioKeyword"


    public static class scenario_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scenario"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:253:1: scenario : scenarioKeyword anyDecl statementDecl -> ^( TOK_SCENARIO scenarioKeyword anyDecl statementDecl ) ;
    public final AnotherStoryGrammerParser.scenario_return scenario() throws RecognitionException {
        AnotherStoryGrammerParser.scenario_return retval = new AnotherStoryGrammerParser.scenario_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        AnotherStoryGrammerParser.scenarioKeyword_return scenarioKeyword25 =null;

        AnotherStoryGrammerParser.anyDecl_return anyDecl26 =null;

        AnotherStoryGrammerParser.statementDecl_return statementDecl27 =null;


        RewriteRuleSubtreeStream stream_scenarioKeyword=new RewriteRuleSubtreeStream(adaptor,"rule scenarioKeyword");
        RewriteRuleSubtreeStream stream_anyDecl=new RewriteRuleSubtreeStream(adaptor,"rule anyDecl");
        RewriteRuleSubtreeStream stream_statementDecl=new RewriteRuleSubtreeStream(adaptor,"rule statementDecl");
        try { dbg.enterRule(getGrammarFileName(), "scenario");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(253, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:253:9: ( scenarioKeyword anyDecl statementDecl -> ^( TOK_SCENARIO scenarioKeyword anyDecl statementDecl ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:253:11: scenarioKeyword anyDecl statementDecl
            {
            dbg.location(253,11);
            pushFollow(FOLLOW_scenarioKeyword_in_scenario489);
            scenarioKeyword25=scenarioKeyword();

            state._fsp--;

            stream_scenarioKeyword.add(scenarioKeyword25.getTree());
            dbg.location(253,27);
            pushFollow(FOLLOW_anyDecl_in_scenario491);
            anyDecl26=anyDecl();

            state._fsp--;

            stream_anyDecl.add(anyDecl26.getTree());
            dbg.location(253,35);
            pushFollow(FOLLOW_statementDecl_in_scenario493);
            statementDecl27=statementDecl();

            state._fsp--;

            stream_statementDecl.add(statementDecl27.getTree());

            // AST REWRITE
            // elements: statementDecl, scenarioKeyword, anyDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 254:4: -> ^( TOK_SCENARIO scenarioKeyword anyDecl statementDecl )
            {
                dbg.location(254,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:254:7: ^( TOK_SCENARIO scenarioKeyword anyDecl statementDecl )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(254,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_SCENARIO, "TOK_SCENARIO")
                , root_1);

                dbg.location(254,22);
                adaptor.addChild(root_1, stream_scenarioKeyword.nextTree());
                dbg.location(254,38);
                adaptor.addChild(root_1, stream_anyDecl.nextTree());
                dbg.location(254,46);
                adaptor.addChild(root_1, stream_statementDecl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(255, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "scenario");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "scenario"


    public static class statementDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statementDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:257:1: statementDecl : ( ( ( giveDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) ) | ( ( whenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) ) | ( ( thenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) ) )+ ;
    public final AnotherStoryGrammerParser.statementDecl_return statementDecl() throws RecognitionException {
        AnotherStoryGrammerParser.statementDecl_return retval = new AnotherStoryGrammerParser.statementDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        AnotherStoryGrammerParser.giveDecl_return giveDecl28 =null;

        AnotherStoryGrammerParser.storeDecl_return storeDecl29 =null;

        AnotherStoryGrammerParser.andDecl_return andDecl30 =null;

        AnotherStoryGrammerParser.storeDecl_return storeDecl31 =null;

        AnotherStoryGrammerParser.whenDecl_return whenDecl32 =null;

        AnotherStoryGrammerParser.storeDecl_return storeDecl33 =null;

        AnotherStoryGrammerParser.andDecl_return andDecl34 =null;

        AnotherStoryGrammerParser.storeDecl_return storeDecl35 =null;

        AnotherStoryGrammerParser.thenDecl_return thenDecl36 =null;

        AnotherStoryGrammerParser.storeDecl_return storeDecl37 =null;

        AnotherStoryGrammerParser.andDecl_return andDecl38 =null;

        AnotherStoryGrammerParser.storeDecl_return storeDecl39 =null;



        try { dbg.enterRule(getGrammarFileName(), "statementDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(257, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:258:2: ( ( ( ( giveDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) ) | ( ( whenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) ) | ( ( thenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) ) )+ )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:258:4: ( ( ( giveDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) ) | ( ( whenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) ) | ( ( thenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) ) )+
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(258,4);
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:258:4: ( ( ( giveDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) ) | ( ( whenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) ) | ( ( thenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) ) )+
            int cnt12=0;
            try { dbg.enterSubRule(12);

            loop12:
            do {
                int alt12=4;
                try { dbg.enterDecision(12, decisionCanBacktrack[12]);

                switch ( input.LA(1) ) {
                case GIVEN:
                    {
                    alt12=1;
                    }
                    break;
                case WHEN:
                    {
                    alt12=2;
                    }
                    break;
                case THEN:
                    {
                    alt12=3;
                    }
                    break;

                }

                } finally {dbg.exitDecision(12);}

                switch (alt12) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:259:5: ( ( giveDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) )
            	    {
            	    dbg.location(259,5);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:259:5: ( ( giveDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) )
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:259:6: ( giveDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* )
            	    {
            	    dbg.location(259,6);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:259:6: ( giveDecl ( storeDecl )? )
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:259:7: giveDecl ( storeDecl )?
            	    {
            	    dbg.location(259,7);
            	    pushFollow(FOLLOW_giveDecl_in_statementDecl527);
            	    giveDecl28=giveDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, giveDecl28.getTree());
            	    dbg.location(259,16);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:259:16: ( storeDecl )?
            	    int alt3=2;
            	    try { dbg.enterSubRule(3);
            	    try { dbg.enterDecision(3, decisionCanBacktrack[3]);

            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==STORE) ) {
            	        alt3=1;
            	    }
            	    } finally {dbg.exitDecision(3);}

            	    switch (alt3) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:259:16: storeDecl
            	            {
            	            dbg.location(259,16);
            	            pushFollow(FOLLOW_storeDecl_in_statementDecl529);
            	            storeDecl29=storeDecl();

            	            state._fsp--;

            	            adaptor.addChild(root_0, storeDecl29.getTree());

            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(3);}


            	    }

            	    dbg.location(259,27);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:259:27: ( ( andDecl ( storeDecl )? )* )
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:259:28: ( andDecl ( storeDecl )? )*
            	    {
            	    dbg.location(259,28);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:259:28: ( andDecl ( storeDecl )? )*
            	    try { dbg.enterSubRule(5);

            	    loop5:
            	    do {
            	        int alt5=2;
            	        try { dbg.enterDecision(5, decisionCanBacktrack[5]);

            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==AND) ) {
            	            alt5=1;
            	        }


            	        } finally {dbg.exitDecision(5);}

            	        switch (alt5) {
            	    	case 1 :
            	    	    dbg.enterAlt(1);

            	    	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:259:29: andDecl ( storeDecl )?
            	    	    {
            	    	    dbg.location(259,29);
            	    	    pushFollow(FOLLOW_andDecl_in_statementDecl534);
            	    	    andDecl30=andDecl();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, andDecl30.getTree());
            	    	    dbg.location(259,37);
            	    	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:259:37: ( storeDecl )?
            	    	    int alt4=2;
            	    	    try { dbg.enterSubRule(4);
            	    	    try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            	    	    int LA4_0 = input.LA(1);

            	    	    if ( (LA4_0==STORE) ) {
            	    	        alt4=1;
            	    	    }
            	    	    } finally {dbg.exitDecision(4);}

            	    	    switch (alt4) {
            	    	        case 1 :
            	    	            dbg.enterAlt(1);

            	    	            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:259:37: storeDecl
            	    	            {
            	    	            dbg.location(259,37);
            	    	            pushFollow(FOLLOW_storeDecl_in_statementDecl536);
            	    	            storeDecl31=storeDecl();

            	    	            state._fsp--;

            	    	            adaptor.addChild(root_0, storeDecl31.getTree());

            	    	            }
            	    	            break;

            	    	    }
            	    	    } finally {dbg.exitSubRule(4);}


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(5);}


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:260:5: ( ( whenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) )
            	    {
            	    dbg.location(260,5);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:260:5: ( ( whenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) )
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:260:6: ( whenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* )
            	    {
            	    dbg.location(260,6);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:260:6: ( whenDecl ( storeDecl )? )
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:260:7: whenDecl ( storeDecl )?
            	    {
            	    dbg.location(260,7);
            	    pushFollow(FOLLOW_whenDecl_in_statementDecl549);
            	    whenDecl32=whenDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, whenDecl32.getTree());
            	    dbg.location(260,16);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:260:16: ( storeDecl )?
            	    int alt6=2;
            	    try { dbg.enterSubRule(6);
            	    try { dbg.enterDecision(6, decisionCanBacktrack[6]);

            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==STORE) ) {
            	        alt6=1;
            	    }
            	    } finally {dbg.exitDecision(6);}

            	    switch (alt6) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:260:16: storeDecl
            	            {
            	            dbg.location(260,16);
            	            pushFollow(FOLLOW_storeDecl_in_statementDecl551);
            	            storeDecl33=storeDecl();

            	            state._fsp--;

            	            adaptor.addChild(root_0, storeDecl33.getTree());

            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(6);}


            	    }

            	    dbg.location(260,27);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:260:27: ( ( andDecl ( storeDecl )? )* )
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:260:28: ( andDecl ( storeDecl )? )*
            	    {
            	    dbg.location(260,28);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:260:28: ( andDecl ( storeDecl )? )*
            	    try { dbg.enterSubRule(8);

            	    loop8:
            	    do {
            	        int alt8=2;
            	        try { dbg.enterDecision(8, decisionCanBacktrack[8]);

            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==AND) ) {
            	            alt8=1;
            	        }


            	        } finally {dbg.exitDecision(8);}

            	        switch (alt8) {
            	    	case 1 :
            	    	    dbg.enterAlt(1);

            	    	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:260:29: andDecl ( storeDecl )?
            	    	    {
            	    	    dbg.location(260,29);
            	    	    pushFollow(FOLLOW_andDecl_in_statementDecl556);
            	    	    andDecl34=andDecl();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, andDecl34.getTree());
            	    	    dbg.location(260,37);
            	    	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:260:37: ( storeDecl )?
            	    	    int alt7=2;
            	    	    try { dbg.enterSubRule(7);
            	    	    try { dbg.enterDecision(7, decisionCanBacktrack[7]);

            	    	    int LA7_0 = input.LA(1);

            	    	    if ( (LA7_0==STORE) ) {
            	    	        alt7=1;
            	    	    }
            	    	    } finally {dbg.exitDecision(7);}

            	    	    switch (alt7) {
            	    	        case 1 :
            	    	            dbg.enterAlt(1);

            	    	            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:260:37: storeDecl
            	    	            {
            	    	            dbg.location(260,37);
            	    	            pushFollow(FOLLOW_storeDecl_in_statementDecl558);
            	    	            storeDecl35=storeDecl();

            	    	            state._fsp--;

            	    	            adaptor.addChild(root_0, storeDecl35.getTree());

            	    	            }
            	    	            break;

            	    	    }
            	    	    } finally {dbg.exitSubRule(7);}


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop8;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(8);}


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    dbg.enterAlt(3);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:261:5: ( ( thenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) )
            	    {
            	    dbg.location(261,5);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:261:5: ( ( thenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* ) )
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:261:6: ( thenDecl ( storeDecl )? ) ( ( andDecl ( storeDecl )? )* )
            	    {
            	    dbg.location(261,6);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:261:6: ( thenDecl ( storeDecl )? )
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:261:7: thenDecl ( storeDecl )?
            	    {
            	    dbg.location(261,7);
            	    pushFollow(FOLLOW_thenDecl_in_statementDecl571);
            	    thenDecl36=thenDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, thenDecl36.getTree());
            	    dbg.location(261,16);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:261:16: ( storeDecl )?
            	    int alt9=2;
            	    try { dbg.enterSubRule(9);
            	    try { dbg.enterDecision(9, decisionCanBacktrack[9]);

            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==STORE) ) {
            	        alt9=1;
            	    }
            	    } finally {dbg.exitDecision(9);}

            	    switch (alt9) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:261:16: storeDecl
            	            {
            	            dbg.location(261,16);
            	            pushFollow(FOLLOW_storeDecl_in_statementDecl573);
            	            storeDecl37=storeDecl();

            	            state._fsp--;

            	            adaptor.addChild(root_0, storeDecl37.getTree());

            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(9);}


            	    }

            	    dbg.location(261,27);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:261:27: ( ( andDecl ( storeDecl )? )* )
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:261:28: ( andDecl ( storeDecl )? )*
            	    {
            	    dbg.location(261,28);
            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:261:28: ( andDecl ( storeDecl )? )*
            	    try { dbg.enterSubRule(11);

            	    loop11:
            	    do {
            	        int alt11=2;
            	        try { dbg.enterDecision(11, decisionCanBacktrack[11]);

            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==AND) ) {
            	            alt11=1;
            	        }


            	        } finally {dbg.exitDecision(11);}

            	        switch (alt11) {
            	    	case 1 :
            	    	    dbg.enterAlt(1);

            	    	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:261:29: andDecl ( storeDecl )?
            	    	    {
            	    	    dbg.location(261,29);
            	    	    pushFollow(FOLLOW_andDecl_in_statementDecl578);
            	    	    andDecl38=andDecl();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, andDecl38.getTree());
            	    	    dbg.location(261,37);
            	    	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:261:37: ( storeDecl )?
            	    	    int alt10=2;
            	    	    try { dbg.enterSubRule(10);
            	    	    try { dbg.enterDecision(10, decisionCanBacktrack[10]);

            	    	    int LA10_0 = input.LA(1);

            	    	    if ( (LA10_0==STORE) ) {
            	    	        alt10=1;
            	    	    }
            	    	    } finally {dbg.exitDecision(10);}

            	    	    switch (alt10) {
            	    	        case 1 :
            	    	            dbg.enterAlt(1);

            	    	            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:261:37: storeDecl
            	    	            {
            	    	            dbg.location(261,37);
            	    	            pushFollow(FOLLOW_storeDecl_in_statementDecl580);
            	    	            storeDecl39=storeDecl();

            	    	            state._fsp--;

            	    	            adaptor.addChild(root_0, storeDecl39.getTree());

            	    	            }
            	    	            break;

            	    	    }
            	    	    } finally {dbg.exitSubRule(10);}


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop11;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(11);}


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt12++;
            } while (true);
            } finally {dbg.exitSubRule(12);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(263, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "statementDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "statementDecl"


    public static class givenKeyword_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "givenKeyword"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:265:1: givenKeyword : GIVEN ;
    public final AnotherStoryGrammerParser.givenKeyword_return givenKeyword() throws RecognitionException {
        AnotherStoryGrammerParser.givenKeyword_return retval = new AnotherStoryGrammerParser.givenKeyword_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token GIVEN40=null;

        CommonTree GIVEN40_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "givenKeyword");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(265, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:266:2: ( GIVEN )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:266:4: GIVEN
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(266,4);
            GIVEN40=(Token)match(input,GIVEN,FOLLOW_GIVEN_in_givenKeyword602); 
            GIVEN40_tree = 
            (CommonTree)adaptor.create(GIVEN40)
            ;
            adaptor.addChild(root_0, GIVEN40_tree);

            dbg.location(266,10);
            onGivenKeyword();

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(267, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "givenKeyword");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "givenKeyword"


    public static class whenKeyword_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "whenKeyword"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:269:1: whenKeyword : WHEN ;
    public final AnotherStoryGrammerParser.whenKeyword_return whenKeyword() throws RecognitionException {
        AnotherStoryGrammerParser.whenKeyword_return retval = new AnotherStoryGrammerParser.whenKeyword_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token WHEN41=null;

        CommonTree WHEN41_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "whenKeyword");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(269, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:270:2: ( WHEN )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:270:4: WHEN
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(270,4);
            WHEN41=(Token)match(input,WHEN,FOLLOW_WHEN_in_whenKeyword615); 
            WHEN41_tree = 
            (CommonTree)adaptor.create(WHEN41)
            ;
            adaptor.addChild(root_0, WHEN41_tree);

            dbg.location(270,9);
            onWhenKeyword();

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(271, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "whenKeyword");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "whenKeyword"


    public static class thenKeyword_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "thenKeyword"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:273:1: thenKeyword : THEN ;
    public final AnotherStoryGrammerParser.thenKeyword_return thenKeyword() throws RecognitionException {
        AnotherStoryGrammerParser.thenKeyword_return retval = new AnotherStoryGrammerParser.thenKeyword_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token THEN42=null;

        CommonTree THEN42_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "thenKeyword");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(273, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:274:2: ( THEN )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:274:4: THEN
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(274,4);
            THEN42=(Token)match(input,THEN,FOLLOW_THEN_in_thenKeyword628); 
            THEN42_tree = 
            (CommonTree)adaptor.create(THEN42)
            ;
            adaptor.addChild(root_0, THEN42_tree);

            dbg.location(274,9);
            onThenKeyword();

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(275, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "thenKeyword");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "thenKeyword"


    public static class andKeyword_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "andKeyword"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:277:1: andKeyword : AND ;
    public final AnotherStoryGrammerParser.andKeyword_return andKeyword() throws RecognitionException {
        AnotherStoryGrammerParser.andKeyword_return retval = new AnotherStoryGrammerParser.andKeyword_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token AND43=null;

        CommonTree AND43_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "andKeyword");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(277, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:278:2: ( AND )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:278:4: AND
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(278,4);
            AND43=(Token)match(input,AND,FOLLOW_AND_in_andKeyword641); 
            AND43_tree = 
            (CommonTree)adaptor.create(AND43)
            ;
            adaptor.addChild(root_0, AND43_tree);

            dbg.location(278,8);
            onAndKeyword();

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(279, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "andKeyword");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "andKeyword"


    public static class giveDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "giveDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:281:1: giveDecl : givenKeyword anyDecl -> ^( TOK_GIVEN givenKeyword anyDecl ) ;
    public final AnotherStoryGrammerParser.giveDecl_return giveDecl() throws RecognitionException {
        AnotherStoryGrammerParser.giveDecl_return retval = new AnotherStoryGrammerParser.giveDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        AnotherStoryGrammerParser.givenKeyword_return givenKeyword44 =null;

        AnotherStoryGrammerParser.anyDecl_return anyDecl45 =null;


        RewriteRuleSubtreeStream stream_anyDecl=new RewriteRuleSubtreeStream(adaptor,"rule anyDecl");
        RewriteRuleSubtreeStream stream_givenKeyword=new RewriteRuleSubtreeStream(adaptor,"rule givenKeyword");
        try { dbg.enterRule(getGrammarFileName(), "giveDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(281, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:282:2: ( givenKeyword anyDecl -> ^( TOK_GIVEN givenKeyword anyDecl ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:282:4: givenKeyword anyDecl
            {
            dbg.location(282,4);
            pushFollow(FOLLOW_givenKeyword_in_giveDecl654);
            givenKeyword44=givenKeyword();

            state._fsp--;

            stream_givenKeyword.add(givenKeyword44.getTree());
            dbg.location(282,17);
            pushFollow(FOLLOW_anyDecl_in_giveDecl656);
            anyDecl45=anyDecl();

            state._fsp--;

            stream_anyDecl.add(anyDecl45.getTree());

            // AST REWRITE
            // elements: anyDecl, givenKeyword
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 283:4: -> ^( TOK_GIVEN givenKeyword anyDecl )
            {
                dbg.location(283,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:283:7: ^( TOK_GIVEN givenKeyword anyDecl )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(283,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_GIVEN, "TOK_GIVEN")
                , root_1);

                dbg.location(283,19);
                adaptor.addChild(root_1, stream_givenKeyword.nextTree());
                dbg.location(283,32);
                adaptor.addChild(root_1, stream_anyDecl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(284, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "giveDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "giveDecl"


    public static class whenDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "whenDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:285:1: whenDecl : whenKeyword anyDecl -> ^( TOK_WHEN whenKeyword anyDecl ) ;
    public final AnotherStoryGrammerParser.whenDecl_return whenDecl() throws RecognitionException {
        AnotherStoryGrammerParser.whenDecl_return retval = new AnotherStoryGrammerParser.whenDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        AnotherStoryGrammerParser.whenKeyword_return whenKeyword46 =null;

        AnotherStoryGrammerParser.anyDecl_return anyDecl47 =null;


        RewriteRuleSubtreeStream stream_whenKeyword=new RewriteRuleSubtreeStream(adaptor,"rule whenKeyword");
        RewriteRuleSubtreeStream stream_anyDecl=new RewriteRuleSubtreeStream(adaptor,"rule anyDecl");
        try { dbg.enterRule(getGrammarFileName(), "whenDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(285, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:286:2: ( whenKeyword anyDecl -> ^( TOK_WHEN whenKeyword anyDecl ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:286:4: whenKeyword anyDecl
            {
            dbg.location(286,4);
            pushFollow(FOLLOW_whenKeyword_in_whenDecl679);
            whenKeyword46=whenKeyword();

            state._fsp--;

            stream_whenKeyword.add(whenKeyword46.getTree());
            dbg.location(286,16);
            pushFollow(FOLLOW_anyDecl_in_whenDecl681);
            anyDecl47=anyDecl();

            state._fsp--;

            stream_anyDecl.add(anyDecl47.getTree());

            // AST REWRITE
            // elements: whenKeyword, anyDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 287:4: -> ^( TOK_WHEN whenKeyword anyDecl )
            {
                dbg.location(287,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:287:7: ^( TOK_WHEN whenKeyword anyDecl )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(287,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_WHEN, "TOK_WHEN")
                , root_1);

                dbg.location(287,18);
                adaptor.addChild(root_1, stream_whenKeyword.nextTree());
                dbg.location(287,30);
                adaptor.addChild(root_1, stream_anyDecl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(288, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "whenDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "whenDecl"


    public static class thenDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "thenDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:289:1: thenDecl : thenKeyword anyDecl -> ^( TOK_THEN thenKeyword anyDecl ) ;
    public final AnotherStoryGrammerParser.thenDecl_return thenDecl() throws RecognitionException {
        AnotherStoryGrammerParser.thenDecl_return retval = new AnotherStoryGrammerParser.thenDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        AnotherStoryGrammerParser.thenKeyword_return thenKeyword48 =null;

        AnotherStoryGrammerParser.anyDecl_return anyDecl49 =null;


        RewriteRuleSubtreeStream stream_thenKeyword=new RewriteRuleSubtreeStream(adaptor,"rule thenKeyword");
        RewriteRuleSubtreeStream stream_anyDecl=new RewriteRuleSubtreeStream(adaptor,"rule anyDecl");
        try { dbg.enterRule(getGrammarFileName(), "thenDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(289, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:290:2: ( thenKeyword anyDecl -> ^( TOK_THEN thenKeyword anyDecl ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:290:4: thenKeyword anyDecl
            {
            dbg.location(290,4);
            pushFollow(FOLLOW_thenKeyword_in_thenDecl704);
            thenKeyword48=thenKeyword();

            state._fsp--;

            stream_thenKeyword.add(thenKeyword48.getTree());
            dbg.location(290,16);
            pushFollow(FOLLOW_anyDecl_in_thenDecl706);
            anyDecl49=anyDecl();

            state._fsp--;

            stream_anyDecl.add(anyDecl49.getTree());

            // AST REWRITE
            // elements: anyDecl, thenKeyword
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 291:4: -> ^( TOK_THEN thenKeyword anyDecl )
            {
                dbg.location(291,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:291:7: ^( TOK_THEN thenKeyword anyDecl )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(291,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_THEN, "TOK_THEN")
                , root_1);

                dbg.location(291,18);
                adaptor.addChild(root_1, stream_thenKeyword.nextTree());
                dbg.location(291,30);
                adaptor.addChild(root_1, stream_anyDecl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(292, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "thenDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "thenDecl"


    public static class andDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "andDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:293:1: andDecl : andKeyword anyDecl -> ^( TOK_AND andKeyword anyDecl ) ;
    public final AnotherStoryGrammerParser.andDecl_return andDecl() throws RecognitionException {
        AnotherStoryGrammerParser.andDecl_return retval = new AnotherStoryGrammerParser.andDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        AnotherStoryGrammerParser.andKeyword_return andKeyword50 =null;

        AnotherStoryGrammerParser.anyDecl_return anyDecl51 =null;


        RewriteRuleSubtreeStream stream_andKeyword=new RewriteRuleSubtreeStream(adaptor,"rule andKeyword");
        RewriteRuleSubtreeStream stream_anyDecl=new RewriteRuleSubtreeStream(adaptor,"rule anyDecl");
        try { dbg.enterRule(getGrammarFileName(), "andDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(293, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:294:2: ( andKeyword anyDecl -> ^( TOK_AND andKeyword anyDecl ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:294:4: andKeyword anyDecl
            {
            dbg.location(294,4);
            pushFollow(FOLLOW_andKeyword_in_andDecl729);
            andKeyword50=andKeyword();

            state._fsp--;

            stream_andKeyword.add(andKeyword50.getTree());
            dbg.location(294,15);
            pushFollow(FOLLOW_anyDecl_in_andDecl731);
            anyDecl51=anyDecl();

            state._fsp--;

            stream_anyDecl.add(anyDecl51.getTree());

            // AST REWRITE
            // elements: anyDecl, andKeyword
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 295:4: -> ^( TOK_AND andKeyword anyDecl )
            {
                dbg.location(295,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:295:7: ^( TOK_AND andKeyword anyDecl )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(295,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_AND, "TOK_AND")
                , root_1);

                dbg.location(295,17);
                adaptor.addChild(root_1, stream_andKeyword.nextTree());
                dbg.location(295,28);
                adaptor.addChild(root_1, stream_anyDecl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(296, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "andDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "andDecl"


    public static class storeDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "storeDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:297:1: storeDecl : STORE anyDecl -> ^( TOK_STORE STORE anyDecl ) ;
    public final AnotherStoryGrammerParser.storeDecl_return storeDecl() throws RecognitionException {
        AnotherStoryGrammerParser.storeDecl_return retval = new AnotherStoryGrammerParser.storeDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token STORE52=null;
        AnotherStoryGrammerParser.anyDecl_return anyDecl53 =null;


        CommonTree STORE52_tree=null;
        RewriteRuleTokenStream stream_STORE=new RewriteRuleTokenStream(adaptor,"token STORE");
        RewriteRuleSubtreeStream stream_anyDecl=new RewriteRuleSubtreeStream(adaptor,"rule anyDecl");
        try { dbg.enterRule(getGrammarFileName(), "storeDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(297, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:298:2: ( STORE anyDecl -> ^( TOK_STORE STORE anyDecl ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:298:4: STORE anyDecl
            {
            dbg.location(298,4);
            STORE52=(Token)match(input,STORE,FOLLOW_STORE_in_storeDecl754);  
            stream_STORE.add(STORE52);

            dbg.location(298,10);
            onStoreKeyword();
            dbg.location(298,30);
            pushFollow(FOLLOW_anyDecl_in_storeDecl758);
            anyDecl53=anyDecl();

            state._fsp--;

            stream_anyDecl.add(anyDecl53.getTree());

            // AST REWRITE
            // elements: STORE, anyDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 299:4: -> ^( TOK_STORE STORE anyDecl )
            {
                dbg.location(299,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:299:7: ^( TOK_STORE STORE anyDecl )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(299,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_STORE, "TOK_STORE")
                , root_1);

                dbg.location(299,19);
                adaptor.addChild(root_1, 
                stream_STORE.nextNode()
                );
                dbg.location(299,25);
                adaptor.addChild(root_1, stream_anyDecl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(300, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "storeDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "storeDecl"


    public static class anyDeclEndedByPlugin_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "anyDeclEndedByPlugin"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:301:1: anyDeclEndedByPlugin : ( string | identifier )+ PLUGIN ;
    public final AnotherStoryGrammerParser.anyDeclEndedByPlugin_return anyDeclEndedByPlugin() throws RecognitionException {
        AnotherStoryGrammerParser.anyDeclEndedByPlugin_return retval = new AnotherStoryGrammerParser.anyDeclEndedByPlugin_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token PLUGIN56=null;
        AnotherStoryGrammerParser.string_return string54 =null;

        AnotherStoryGrammerParser.identifier_return identifier55 =null;


        CommonTree PLUGIN56_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "anyDeclEndedByPlugin");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(301, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:302:2: ( ( string | identifier )+ PLUGIN )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:302:4: ( string | identifier )+ PLUGIN
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(302,4);
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:302:4: ( string | identifier )+
            int cnt13=0;
            try { dbg.enterSubRule(13);

            loop13:
            do {
                int alt13=3;
                try { dbg.enterDecision(13, decisionCanBacktrack[13]);

                int LA13_0 = input.LA(1);

                if ( (LA13_0==String) ) {
                    alt13=1;
                }
                else if ( (LA13_0==Identifier) ) {
                    alt13=2;
                }


                } finally {dbg.exitDecision(13);}

                switch (alt13) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:303:6: string
            	    {
            	    dbg.location(303,6);
            	    pushFollow(FOLLOW_string_in_anyDeclEndedByPlugin788);
            	    string54=string();

            	    state._fsp--;

            	    adaptor.addChild(root_0, string54.getTree());
            	    dbg.location(303,17);
            	    onAnyString((string54!=null?input.toString(string54.start,string54.stop):null));

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:304:6: identifier
            	    {
            	    dbg.location(304,6);
            	    pushFollow(FOLLOW_identifier_in_anyDeclEndedByPlugin801);
            	    identifier55=identifier();

            	    state._fsp--;

            	    adaptor.addChild(root_0, identifier55.getTree());
            	    dbg.location(304,17);
            	    onAnyIdentifier((identifier55!=null?input.toString(identifier55.start,identifier55.stop):null));

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt13++;
            } while (true);
            } finally {dbg.exitSubRule(13);}

            dbg.location(305,7);
            PLUGIN56=(Token)match(input,PLUGIN,FOLLOW_PLUGIN_in_anyDeclEndedByPlugin811); 
            PLUGIN56_tree = 
            (CommonTree)adaptor.create(PLUGIN56)
            ;
            adaptor.addChild(root_0, PLUGIN56_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(305, 12);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "anyDeclEndedByPlugin");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "anyDeclEndedByPlugin"


    public static class anyStringDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "anyStringDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:309:1: anyStringDecl : ( string )+ ;
    public final AnotherStoryGrammerParser.anyStringDecl_return anyStringDecl() throws RecognitionException {
        AnotherStoryGrammerParser.anyStringDecl_return retval = new AnotherStoryGrammerParser.anyStringDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        AnotherStoryGrammerParser.string_return string57 =null;



        try { dbg.enterRule(getGrammarFileName(), "anyStringDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(309, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:310:2: ( ( string )+ )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:310:4: ( string )+
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(310,4);
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:310:4: ( string )+
            int cnt14=0;
            try { dbg.enterSubRule(14);

            loop14:
            do {
                int alt14=2;
                try { dbg.enterDecision(14, decisionCanBacktrack[14]);

                int LA14_0 = input.LA(1);

                if ( (LA14_0==String) ) {
                    alt14=1;
                }


                } finally {dbg.exitDecision(14);}

                switch (alt14) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:311:5: string
            	    {
            	    dbg.location(311,5);
            	    pushFollow(FOLLOW_string_in_anyStringDecl827);
            	    string57=string();

            	    state._fsp--;

            	    adaptor.addChild(root_0, string57.getTree());
            	    dbg.location(311,16);
            	    onAnyString((string57!=null?input.toString(string57.start,string57.stop):null));

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt14++;
            } while (true);
            } finally {dbg.exitSubRule(14);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(312, 5);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "anyStringDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "anyStringDecl"


    public static class anyDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "anyDecl"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:313:1: anyDecl : ( string | identifier | reference | template | integer | jsonObject )+ ;
    public final AnotherStoryGrammerParser.anyDecl_return anyDecl() throws RecognitionException {
        AnotherStoryGrammerParser.anyDecl_return retval = new AnotherStoryGrammerParser.anyDecl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        AnotherStoryGrammerParser.string_return string58 =null;

        AnotherStoryGrammerParser.identifier_return identifier59 =null;

        AnotherStoryGrammerParser.reference_return reference60 =null;

        AnotherStoryGrammerParser.template_return template61 =null;

        AnotherStoryGrammerParser.integer_return integer62 =null;

        AnotherStoryGrammerParser.jsonObject_return jsonObject63 =null;



        try { dbg.enterRule(getGrammarFileName(), "anyDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(313, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:314:2: ( ( string | identifier | reference | template | integer | jsonObject )+ )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:314:4: ( string | identifier | reference | template | integer | jsonObject )+
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(314,4);
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:314:4: ( string | identifier | reference | template | integer | jsonObject )+
            int cnt15=0;
            try { dbg.enterSubRule(15);

            loop15:
            do {
                int alt15=7;
                try { dbg.enterDecision(15, decisionCanBacktrack[15]);

                switch ( input.LA(1) ) {
                case String:
                    {
                    alt15=1;
                    }
                    break;
                case Identifier:
                    {
                    alt15=2;
                    }
                    break;
                case Reference:
                    {
                    int LA15_4 = input.LA(2);

                    if ( (LA15_4==EOF||LA15_4==AND||LA15_4==ASAN||LA15_4==DECLARE||LA15_4==GIVEN||(LA15_4 >= INCLUDE && LA15_4 <= Identifier)||LA15_4==Number||(LA15_4 >= REGISTER && LA15_4 <= Reference)||(LA15_4 >= SCENARIO && LA15_4 <= STORE)||(LA15_4 >= String && LA15_4 <= THEN)||LA15_4==WHEN||LA15_4==68) ) {
                        alt15=3;
                    }
                    else if ( (LA15_4==Member) ) {
                        alt15=4;
                    }


                    }
                    break;
                case Number:
                    {
                    alt15=5;
                    }
                    break;
                case 68:
                    {
                    alt15=6;
                    }
                    break;

                }

                } finally {dbg.exitDecision(15);}

                switch (alt15) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:315:5: string
            	    {
            	    dbg.location(315,5);
            	    pushFollow(FOLLOW_string_in_anyDecl853);
            	    string58=string();

            	    state._fsp--;

            	    adaptor.addChild(root_0, string58.getTree());
            	    dbg.location(315,16);
            	    onAnyString((string58!=null?input.toString(string58.start,string58.stop):null));

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:316:5: identifier
            	    {
            	    dbg.location(316,5);
            	    pushFollow(FOLLOW_identifier_in_anyDecl865);
            	    identifier59=identifier();

            	    state._fsp--;

            	    adaptor.addChild(root_0, identifier59.getTree());
            	    dbg.location(316,16);
            	    onAnyIdentifier((identifier59!=null?input.toString(identifier59.start,identifier59.stop):null));

            	    }
            	    break;
            	case 3 :
            	    dbg.enterAlt(3);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:317:5: reference
            	    {
            	    dbg.location(317,5);
            	    pushFollow(FOLLOW_reference_in_anyDecl873);
            	    reference60=reference();

            	    state._fsp--;

            	    adaptor.addChild(root_0, reference60.getTree());
            	    dbg.location(317,16);
            	    onAnyReference((reference60!=null?input.toString(reference60.start,reference60.stop):null));

            	    }
            	    break;
            	case 4 :
            	    dbg.enterAlt(4);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:318:5: template
            	    {
            	    dbg.location(318,5);
            	    pushFollow(FOLLOW_template_in_anyDecl882);
            	    template61=template();

            	    state._fsp--;

            	    adaptor.addChild(root_0, template61.getTree());
            	    dbg.location(318,16);
            	    onAnyTemplate((template61!=null?input.toString(template61.start,template61.stop):null));

            	    }
            	    break;
            	case 5 :
            	    dbg.enterAlt(5);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:319:5: integer
            	    {
            	    dbg.location(319,5);
            	    pushFollow(FOLLOW_integer_in_anyDecl892);
            	    integer62=integer();

            	    state._fsp--;

            	    adaptor.addChild(root_0, integer62.getTree());
            	    dbg.location(319,16);
            	    onAnyNumeric((integer62!=null?input.toString(integer62.start,integer62.stop):null));

            	    }
            	    break;
            	case 6 :
            	    dbg.enterAlt(6);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:320:5: jsonObject
            	    {
            	    dbg.location(320,5);
            	    pushFollow(FOLLOW_jsonObject_in_anyDecl903);
            	    jsonObject63=jsonObject();

            	    state._fsp--;

            	    adaptor.addChild(root_0, jsonObject63.getTree());
            	    dbg.location(320,16);
            	    onAnyJsonObject((jsonObject63!=null?input.toString(jsonObject63.start,jsonObject63.stop):null));

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt15++;
            } while (true);
            } finally {dbg.exitSubRule(15);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(321, 5);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "anyDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "anyDecl"


    public static class string_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "string"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:323:1: string : String -> ^( STRING String ) ;
    public final AnotherStoryGrammerParser.string_return string() throws RecognitionException {
        AnotherStoryGrammerParser.string_return retval = new AnotherStoryGrammerParser.string_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token String64=null;

        CommonTree String64_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");

        try { dbg.enterRule(getGrammarFileName(), "string");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(323, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:323:9: ( String -> ^( STRING String ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:323:11: String
            {
            dbg.location(323,11);
            String64=(Token)match(input,String,FOLLOW_String_in_string920);  
            stream_String.add(String64);


            // AST REWRITE
            // elements: String
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 324:4: -> ^( STRING String )
            {
                dbg.location(324,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:324:7: ^( STRING String )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(324,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STRING, "STRING")
                , root_1);

                dbg.location(324,16);
                adaptor.addChild(root_1, 
                stream_String.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(325, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "string");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "string"


    public static class identifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "identifier"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:327:1: identifier : Identifier ;
    public final AnotherStoryGrammerParser.identifier_return identifier() throws RecognitionException {
        AnotherStoryGrammerParser.identifier_return retval = new AnotherStoryGrammerParser.identifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier65=null;

        CommonTree Identifier65_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "identifier");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(327, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:328:2: ( Identifier )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:328:4: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(328,4);
            Identifier65=(Token)match(input,Identifier,FOLLOW_Identifier_in_identifier942); 
            Identifier65_tree = 
            (CommonTree)adaptor.create(Identifier65)
            ;
            adaptor.addChild(root_0, Identifier65_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(329, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "identifier");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "identifier"


    public static class integer_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "integer"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:331:1: integer : Number ;
    public final AnotherStoryGrammerParser.integer_return integer() throws RecognitionException {
        AnotherStoryGrammerParser.integer_return retval = new AnotherStoryGrammerParser.integer_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Number66=null;

        CommonTree Number66_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "integer");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(331, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:332:2: ( Number )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:332:4: Number
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(332,4);
            Number66=(Token)match(input,Number,FOLLOW_Number_in_integer953); 
            Number66_tree = 
            (CommonTree)adaptor.create(Number66)
            ;
            adaptor.addChild(root_0, Number66_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(333, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "integer");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "integer"


    public static class reference_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "reference"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:335:1: reference : Reference ;
    public final AnotherStoryGrammerParser.reference_return reference() throws RecognitionException {
        AnotherStoryGrammerParser.reference_return retval = new AnotherStoryGrammerParser.reference_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Reference67=null;

        CommonTree Reference67_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "reference");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(335, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:336:2: ( Reference )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:336:4: Reference
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(336,4);
            Reference67=(Token)match(input,Reference,FOLLOW_Reference_in_reference964); 
            Reference67_tree = 
            (CommonTree)adaptor.create(Reference67)
            ;
            adaptor.addChild(root_0, Reference67_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(337, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "reference");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "reference"


    public static class template_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "template"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:339:1: template : Reference ( member )+ -> ^( TOK_TEMPLATE Reference ( member )+ ) ;
    public final AnotherStoryGrammerParser.template_return template() throws RecognitionException {
        AnotherStoryGrammerParser.template_return retval = new AnotherStoryGrammerParser.template_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Reference68=null;
        AnotherStoryGrammerParser.member_return member69 =null;


        CommonTree Reference68_tree=null;
        RewriteRuleTokenStream stream_Reference=new RewriteRuleTokenStream(adaptor,"token Reference");
        RewriteRuleSubtreeStream stream_member=new RewriteRuleSubtreeStream(adaptor,"rule member");
        try { dbg.enterRule(getGrammarFileName(), "template");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(339, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:340:2: ( Reference ( member )+ -> ^( TOK_TEMPLATE Reference ( member )+ ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:340:4: Reference ( member )+
            {
            dbg.location(340,4);
            Reference68=(Token)match(input,Reference,FOLLOW_Reference_in_template976);  
            stream_Reference.add(Reference68);

            dbg.location(340,14);
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:340:14: ( member )+
            int cnt16=0;
            try { dbg.enterSubRule(16);

            loop16:
            do {
                int alt16=2;
                try { dbg.enterDecision(16, decisionCanBacktrack[16]);

                int LA16_0 = input.LA(1);

                if ( (LA16_0==Member) ) {
                    alt16=1;
                }


                } finally {dbg.exitDecision(16);}

                switch (alt16) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:340:15: member
            	    {
            	    dbg.location(340,15);
            	    pushFollow(FOLLOW_member_in_template979);
            	    member69=member();

            	    state._fsp--;

            	    stream_member.add(member69.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt16++;
            } while (true);
            } finally {dbg.exitSubRule(16);}


            // AST REWRITE
            // elements: member, Reference
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 341:3: -> ^( TOK_TEMPLATE Reference ( member )+ )
            {
                dbg.location(341,6);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:341:6: ^( TOK_TEMPLATE Reference ( member )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(341,8);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TOK_TEMPLATE, "TOK_TEMPLATE")
                , root_1);

                dbg.location(341,21);
                adaptor.addChild(root_1, 
                stream_Reference.nextNode()
                );
                dbg.location(341,31);
                if ( !(stream_member.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_member.hasNext() ) {
                    dbg.location(341,32);
                    adaptor.addChild(root_1, stream_member.nextTree());

                }
                stream_member.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(342, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "template");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "template"


    public static class member_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "member"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:344:1: member : Member ;
    public final AnotherStoryGrammerParser.member_return member() throws RecognitionException {
        AnotherStoryGrammerParser.member_return retval = new AnotherStoryGrammerParser.member_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Member70=null;

        CommonTree Member70_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "member");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(344, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:344:8: ( Member )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:344:10: Member
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(344,10);
            Member70=(Token)match(input,Member,FOLLOW_Member_in_member1006); 
            Member70_tree = 
            (CommonTree)adaptor.create(Member70)
            ;
            adaptor.addChild(root_0, Member70_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(344, 15);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "member");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "member"


    public static class jsonValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "jsonValue"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:349:1: jsonValue : ( string | number | jsonObject | array | 'true' -> TRUE | 'false' -> FALSE | 'null' -> NULL );
    public final AnotherStoryGrammerParser.jsonValue_return jsonValue() throws RecognitionException {
        AnotherStoryGrammerParser.jsonValue_return retval = new AnotherStoryGrammerParser.jsonValue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal75=null;
        Token string_literal76=null;
        Token string_literal77=null;
        AnotherStoryGrammerParser.string_return string71 =null;

        AnotherStoryGrammerParser.number_return number72 =null;

        AnotherStoryGrammerParser.jsonObject_return jsonObject73 =null;

        AnotherStoryGrammerParser.array_return array74 =null;


        CommonTree string_literal75_tree=null;
        CommonTree string_literal76_tree=null;
        CommonTree string_literal77_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");

        try { dbg.enterRule(getGrammarFileName(), "jsonValue");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(349, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:350:2: ( string | number | jsonObject | array | 'true' -> TRUE | 'false' -> FALSE | 'null' -> NULL )
            int alt17=7;
            try { dbg.enterDecision(17, decisionCanBacktrack[17]);

            switch ( input.LA(1) ) {
            case String:
                {
                alt17=1;
                }
                break;
            case Number:
                {
                alt17=2;
                }
                break;
            case 68:
                {
                alt17=3;
                }
                break;
            case 63:
                {
                alt17=4;
                }
                break;
            case 67:
                {
                alt17=5;
                }
                break;
            case 65:
                {
                alt17=6;
                }
                break;
            case 66:
                {
                alt17=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(17);}

            switch (alt17) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:350:4: string
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(350,4);
                    pushFollow(FOLLOW_string_in_jsonValue1017);
                    string71=string();

                    state._fsp--;

                    adaptor.addChild(root_0, string71.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:351:4: number
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(351,4);
                    pushFollow(FOLLOW_number_in_jsonValue1022);
                    number72=number();

                    state._fsp--;

                    adaptor.addChild(root_0, number72.getTree());

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:352:4: jsonObject
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(352,4);
                    pushFollow(FOLLOW_jsonObject_in_jsonValue1027);
                    jsonObject73=jsonObject();

                    state._fsp--;

                    adaptor.addChild(root_0, jsonObject73.getTree());

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:353:4: array
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(353,4);
                    pushFollow(FOLLOW_array_in_jsonValue1032);
                    array74=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array74.getTree());

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:354:4: 'true'
                    {
                    dbg.location(354,4);
                    string_literal75=(Token)match(input,67,FOLLOW_67_in_jsonValue1037);  
                    stream_67.add(string_literal75);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 354:11: -> TRUE
                    {
                        dbg.location(354,14);
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(TRUE, "TRUE")
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:355:4: 'false'
                    {
                    dbg.location(355,4);
                    string_literal76=(Token)match(input,65,FOLLOW_65_in_jsonValue1046);  
                    stream_65.add(string_literal76);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 355:12: -> FALSE
                    {
                        dbg.location(355,15);
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(FALSE, "FALSE")
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:356:4: 'null'
                    {
                    dbg.location(356,4);
                    string_literal77=(Token)match(input,66,FOLLOW_66_in_jsonValue1055);  
                    stream_66.add(string_literal77);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 356:11: -> NULL
                    {
                        dbg.location(356,14);
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(NULL, "NULL")
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(357, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "jsonValue");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "jsonValue"


    public static class number_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "number"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:360:1: number : n= Number {...}? ( Exponent )? -> ^( NUMBER Number ( Exponent )? ) ;
    public final AnotherStoryGrammerParser.number_return number() throws RecognitionException {
        AnotherStoryGrammerParser.number_return retval = new AnotherStoryGrammerParser.number_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token n=null;
        Token Exponent78=null;

        CommonTree n_tree=null;
        CommonTree Exponent78_tree=null;
        RewriteRuleTokenStream stream_Exponent=new RewriteRuleTokenStream(adaptor,"token Exponent");
        RewriteRuleTokenStream stream_Number=new RewriteRuleTokenStream(adaptor,"token Number");

        try { dbg.enterRule(getGrammarFileName(), "number");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(360, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:360:8: (n= Number {...}? ( Exponent )? -> ^( NUMBER Number ( Exponent )? ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:360:10: n= Number {...}? ( Exponent )?
            {
            dbg.location(360,11);
            n=(Token)match(input,Number,FOLLOW_Number_in_number1072);  
            stream_Number.add(n);

            dbg.location(360,19);
            if ( !(evalPredicate(Pattern.matches("(0|(-?[1-9]\\d*))(\\.\\d+)?", n.getText()),"Pattern.matches(\"(0|(-?[1-9]\\\\d*))(\\\\.\\\\d+)?\", n.getText())")) ) {
                throw new FailedPredicateException(input, "number", "Pattern.matches(\"(0|(-?[1-9]\\\\d*))(\\\\.\\\\d+)?\", n.getText())");
            }
            dbg.location(361,6);
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:361:6: ( Exponent )?
            int alt18=2;
            try { dbg.enterSubRule(18);
            try { dbg.enterDecision(18, decisionCanBacktrack[18]);

            int LA18_0 = input.LA(1);

            if ( (LA18_0==Exponent) ) {
                alt18=1;
            }
            } finally {dbg.exitDecision(18);}

            switch (alt18) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:361:6: Exponent
                    {
                    dbg.location(361,6);
                    Exponent78=(Token)match(input,Exponent,FOLLOW_Exponent_in_number1082);  
                    stream_Exponent.add(Exponent78);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(18);}


            // AST REWRITE
            // elements: Exponent, Number
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 362:4: -> ^( NUMBER Number ( Exponent )? )
            {
                dbg.location(362,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:362:7: ^( NUMBER Number ( Exponent )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(362,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(NUMBER, "NUMBER")
                , root_1);

                dbg.location(362,16);
                adaptor.addChild(root_1, 
                stream_Number.nextNode()
                );
                dbg.location(362,23);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:362:23: ( Exponent )?
                if ( stream_Exponent.hasNext() ) {
                    dbg.location(362,23);
                    adaptor.addChild(root_1, 
                    stream_Exponent.nextNode()
                    );

                }
                stream_Exponent.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(363, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "number");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "number"


    public static class jsonObject_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "jsonObject"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:365:1: jsonObject : '{' ( members )? '}' -> ^( OBJECT ( members )? ) ;
    public final AnotherStoryGrammerParser.jsonObject_return jsonObject() throws RecognitionException {
        AnotherStoryGrammerParser.jsonObject_return retval = new AnotherStoryGrammerParser.jsonObject_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal79=null;
        Token char_literal81=null;
        AnotherStoryGrammerParser.members_return members80 =null;


        CommonTree char_literal79_tree=null;
        CommonTree char_literal81_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleSubtreeStream stream_members=new RewriteRuleSubtreeStream(adaptor,"rule members");
        try { dbg.enterRule(getGrammarFileName(), "jsonObject");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(365, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:365:12: ( '{' ( members )? '}' -> ^( OBJECT ( members )? ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:365:14: '{' ( members )? '}'
            {
            dbg.location(365,14);
            char_literal79=(Token)match(input,68,FOLLOW_68_in_jsonObject1108);  
            stream_68.add(char_literal79);

            dbg.location(365,18);
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:365:18: ( members )?
            int alt19=2;
            try { dbg.enterSubRule(19);
            try { dbg.enterDecision(19, decisionCanBacktrack[19]);

            int LA19_0 = input.LA(1);

            if ( (LA19_0==String) ) {
                alt19=1;
            }
            } finally {dbg.exitDecision(19);}

            switch (alt19) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:365:18: members
                    {
                    dbg.location(365,18);
                    pushFollow(FOLLOW_members_in_jsonObject1110);
                    members80=members();

                    state._fsp--;

                    stream_members.add(members80.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(19);}

            dbg.location(365,27);
            char_literal81=(Token)match(input,69,FOLLOW_69_in_jsonObject1113);  
            stream_69.add(char_literal81);


            // AST REWRITE
            // elements: members
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 366:4: -> ^( OBJECT ( members )? )
            {
                dbg.location(366,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:366:7: ^( OBJECT ( members )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(366,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OBJECT, "OBJECT")
                , root_1);

                dbg.location(366,16);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:366:16: ( members )?
                if ( stream_members.hasNext() ) {
                    dbg.location(366,16);
                    adaptor.addChild(root_1, stream_members.nextTree());

                }
                stream_members.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(367, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "jsonObject");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "jsonObject"


    public static class array_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "array"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:369:1: array : '[' ( elements )? ']' -> ^( ARRAY ( elements )? ) ;
    public final AnotherStoryGrammerParser.array_return array() throws RecognitionException {
        AnotherStoryGrammerParser.array_return retval = new AnotherStoryGrammerParser.array_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal82=null;
        Token char_literal84=null;
        AnotherStoryGrammerParser.elements_return elements83 =null;


        CommonTree char_literal82_tree=null;
        CommonTree char_literal84_tree=null;
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_elements=new RewriteRuleSubtreeStream(adaptor,"rule elements");
        try { dbg.enterRule(getGrammarFileName(), "array");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(369, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:369:7: ( '[' ( elements )? ']' -> ^( ARRAY ( elements )? ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:369:9: '[' ( elements )? ']'
            {
            dbg.location(369,9);
            char_literal82=(Token)match(input,63,FOLLOW_63_in_array1137);  
            stream_63.add(char_literal82);

            dbg.location(369,13);
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:369:13: ( elements )?
            int alt20=2;
            try { dbg.enterSubRule(20);
            try { dbg.enterDecision(20, decisionCanBacktrack[20]);

            int LA20_0 = input.LA(1);

            if ( (LA20_0==Number||LA20_0==String||LA20_0==63||(LA20_0 >= 65 && LA20_0 <= 68)) ) {
                alt20=1;
            }
            } finally {dbg.exitDecision(20);}

            switch (alt20) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:369:13: elements
                    {
                    dbg.location(369,13);
                    pushFollow(FOLLOW_elements_in_array1139);
                    elements83=elements();

                    state._fsp--;

                    stream_elements.add(elements83.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(20);}

            dbg.location(369,23);
            char_literal84=(Token)match(input,64,FOLLOW_64_in_array1142);  
            stream_64.add(char_literal84);


            // AST REWRITE
            // elements: elements
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 370:4: -> ^( ARRAY ( elements )? )
            {
                dbg.location(370,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:370:7: ^( ARRAY ( elements )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(370,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ARRAY, "ARRAY")
                , root_1);

                dbg.location(370,15);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:370:15: ( elements )?
                if ( stream_elements.hasNext() ) {
                    dbg.location(370,15);
                    adaptor.addChild(root_1, stream_elements.nextTree());

                }
                stream_elements.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(371, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "array");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "array"


    public static class elements_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elements"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:373:1: elements : jsonValue ( COMMA ! jsonValue )* ;
    public final AnotherStoryGrammerParser.elements_return elements() throws RecognitionException {
        AnotherStoryGrammerParser.elements_return retval = new AnotherStoryGrammerParser.elements_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COMMA86=null;
        AnotherStoryGrammerParser.jsonValue_return jsonValue85 =null;

        AnotherStoryGrammerParser.jsonValue_return jsonValue87 =null;


        CommonTree COMMA86_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "elements");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(373, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:373:9: ( jsonValue ( COMMA ! jsonValue )* )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:373:11: jsonValue ( COMMA ! jsonValue )*
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(373,11);
            pushFollow(FOLLOW_jsonValue_in_elements1163);
            jsonValue85=jsonValue();

            state._fsp--;

            adaptor.addChild(root_0, jsonValue85.getTree());
            dbg.location(373,21);
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:373:21: ( COMMA ! jsonValue )*
            try { dbg.enterSubRule(21);

            loop21:
            do {
                int alt21=2;
                try { dbg.enterDecision(21, decisionCanBacktrack[21]);

                int LA21_0 = input.LA(1);

                if ( (LA21_0==COMMA) ) {
                    alt21=1;
                }


                } finally {dbg.exitDecision(21);}

                switch (alt21) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:373:22: COMMA ! jsonValue
            	    {
            	    dbg.location(373,27);
            	    COMMA86=(Token)match(input,COMMA,FOLLOW_COMMA_in_elements1166); 
            	    dbg.location(373,29);
            	    pushFollow(FOLLOW_jsonValue_in_elements1169);
            	    jsonValue87=jsonValue();

            	    state._fsp--;

            	    adaptor.addChild(root_0, jsonValue87.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);
            } finally {dbg.exitSubRule(21);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(374, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "elements");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "elements"


    public static class members_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "members"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:376:1: members : pair ( COMMA ! pair )* ;
    public final AnotherStoryGrammerParser.members_return members() throws RecognitionException {
        AnotherStoryGrammerParser.members_return retval = new AnotherStoryGrammerParser.members_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COMMA89=null;
        AnotherStoryGrammerParser.pair_return pair88 =null;

        AnotherStoryGrammerParser.pair_return pair90 =null;


        CommonTree COMMA89_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "members");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(376, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:376:9: ( pair ( COMMA ! pair )* )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:376:11: pair ( COMMA ! pair )*
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(376,11);
            pushFollow(FOLLOW_pair_in_members1182);
            pair88=pair();

            state._fsp--;

            adaptor.addChild(root_0, pair88.getTree());
            dbg.location(376,16);
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:376:16: ( COMMA ! pair )*
            try { dbg.enterSubRule(22);

            loop22:
            do {
                int alt22=2;
                try { dbg.enterDecision(22, decisionCanBacktrack[22]);

                int LA22_0 = input.LA(1);

                if ( (LA22_0==COMMA) ) {
                    alt22=1;
                }


                } finally {dbg.exitDecision(22);}

                switch (alt22) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:376:17: COMMA ! pair
            	    {
            	    dbg.location(376,22);
            	    COMMA89=(Token)match(input,COMMA,FOLLOW_COMMA_in_members1185); 
            	    dbg.location(376,24);
            	    pushFollow(FOLLOW_pair_in_members1188);
            	    pair90=pair();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pair90.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);
            } finally {dbg.exitSubRule(22);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(377, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "members");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "members"


    public static class pair_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pair"
    // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:379:1: pair : String ':' jsonValue -> ^( FIELD String jsonValue ) ;
    public final AnotherStoryGrammerParser.pair_return pair() throws RecognitionException {
        AnotherStoryGrammerParser.pair_return retval = new AnotherStoryGrammerParser.pair_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token String91=null;
        Token char_literal92=null;
        AnotherStoryGrammerParser.jsonValue_return jsonValue93 =null;


        CommonTree String91_tree=null;
        CommonTree char_literal92_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_jsonValue=new RewriteRuleSubtreeStream(adaptor,"rule jsonValue");
        try { dbg.enterRule(getGrammarFileName(), "pair");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(379, 0);

        try {
            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:379:6: ( String ':' jsonValue -> ^( FIELD String jsonValue ) )
            dbg.enterAlt(1);

            // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:379:8: String ':' jsonValue
            {
            dbg.location(379,8);
            String91=(Token)match(input,String,FOLLOW_String_in_pair1202);  
            stream_String.add(String91);

            dbg.location(379,15);
            char_literal92=(Token)match(input,62,FOLLOW_62_in_pair1204);  
            stream_62.add(char_literal92);

            dbg.location(379,19);
            pushFollow(FOLLOW_jsonValue_in_pair1206);
            jsonValue93=jsonValue();

            state._fsp--;

            stream_jsonValue.add(jsonValue93.getTree());

            // AST REWRITE
            // elements: jsonValue, String
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 380:4: -> ^( FIELD String jsonValue )
            {
                dbg.location(380,7);
                // D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\main\\antlr3\\org\\jbehaviour\\antlr\\AnotherStoryGrammer.g:380:7: ^( FIELD String jsonValue )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(380,9);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FIELD, "FIELD")
                , root_1);

                dbg.location(380,15);
                adaptor.addChild(root_1, 
                stream_String.nextNode()
                );
                dbg.location(380,22);
                adaptor.addChild(root_1, stream_jsonValue.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
         
        catch (Exception e) { 
        //throw e; 
        } 

        finally {
        	// do for sure before leaving
        }
        dbg.location(381, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "pair");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "pair"

    // Delegated rules


 

    public static final BitSet FOLLOW_feature_in_story263 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_scenario_in_story266 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_FEATURE_in_feature277 = new BitSet(new long[]{0x0000021108000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_anyDecl_in_feature281 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_featureDecl_in_feature283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inOrderToDecl_in_featureDecl309 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_asAnDecl_in_featureDecl311 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_iWantToDecl_in_featureDecl313 = new BitSet(new long[]{0x0000000801000802L});
    public static final BitSet FOLLOW_includeDecl_in_featureDecl316 = new BitSet(new long[]{0x0000000801000802L});
    public static final BitSet FOLLOW_registerDecl_in_featureDecl318 = new BitSet(new long[]{0x0000000801000802L});
    public static final BitSet FOLLOW_declareDecl_in_featureDecl320 = new BitSet(new long[]{0x0000000801000802L});
    public static final BitSet FOLLOW_INORDERTO_in_inOrderToDecl331 = new BitSet(new long[]{0x0000021108000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_anyDecl_in_inOrderToDecl333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASAN_in_asAnDecl354 = new BitSet(new long[]{0x0000021108000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_anyDecl_in_asAnDecl356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IWANTTO_in_iWantToDecl377 = new BitSet(new long[]{0x0000021108000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_anyDecl_in_iWantToDecl379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_includeDecl400 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_anyStringDecl_in_includeDecl404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REGISTER_in_registerDecl425 = new BitSet(new long[]{0x0000020008000000L});
    public static final BitSet FOLLOW_anyDeclEndedByPlugin_in_registerDecl429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECLARE_in_declareDecl450 = new BitSet(new long[]{0x0000021108000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_anyDecl_in_declareDecl454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SCENARIO_in_scenarioKeyword478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scenarioKeyword_in_scenario489 = new BitSet(new long[]{0x0000021108000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_anyDecl_in_scenario491 = new BitSet(new long[]{0x1000040000400000L});
    public static final BitSet FOLLOW_statementDecl_in_scenario493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_giveDecl_in_statementDecl527 = new BitSet(new long[]{0x1000048000400012L});
    public static final BitSet FOLLOW_storeDecl_in_statementDecl529 = new BitSet(new long[]{0x1000040000400012L});
    public static final BitSet FOLLOW_andDecl_in_statementDecl534 = new BitSet(new long[]{0x1000048000400012L});
    public static final BitSet FOLLOW_storeDecl_in_statementDecl536 = new BitSet(new long[]{0x1000040000400012L});
    public static final BitSet FOLLOW_whenDecl_in_statementDecl549 = new BitSet(new long[]{0x1000048000400012L});
    public static final BitSet FOLLOW_storeDecl_in_statementDecl551 = new BitSet(new long[]{0x1000040000400012L});
    public static final BitSet FOLLOW_andDecl_in_statementDecl556 = new BitSet(new long[]{0x1000048000400012L});
    public static final BitSet FOLLOW_storeDecl_in_statementDecl558 = new BitSet(new long[]{0x1000040000400012L});
    public static final BitSet FOLLOW_thenDecl_in_statementDecl571 = new BitSet(new long[]{0x1000048000400012L});
    public static final BitSet FOLLOW_storeDecl_in_statementDecl573 = new BitSet(new long[]{0x1000040000400012L});
    public static final BitSet FOLLOW_andDecl_in_statementDecl578 = new BitSet(new long[]{0x1000048000400012L});
    public static final BitSet FOLLOW_storeDecl_in_statementDecl580 = new BitSet(new long[]{0x1000040000400012L});
    public static final BitSet FOLLOW_GIVEN_in_givenKeyword602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHEN_in_whenKeyword615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THEN_in_thenKeyword628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_andKeyword641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_givenKeyword_in_giveDecl654 = new BitSet(new long[]{0x0000021108000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_anyDecl_in_giveDecl656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whenKeyword_in_whenDecl679 = new BitSet(new long[]{0x0000021108000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_anyDecl_in_whenDecl681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_thenKeyword_in_thenDecl704 = new BitSet(new long[]{0x0000021108000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_anyDecl_in_thenDecl706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andKeyword_in_andDecl729 = new BitSet(new long[]{0x0000021108000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_anyDecl_in_andDecl731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_storeDecl754 = new BitSet(new long[]{0x0000021108000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_anyDecl_in_storeDecl758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_in_anyDeclEndedByPlugin788 = new BitSet(new long[]{0x0000020408000000L});
    public static final BitSet FOLLOW_identifier_in_anyDeclEndedByPlugin801 = new BitSet(new long[]{0x0000020408000000L});
    public static final BitSet FOLLOW_PLUGIN_in_anyDeclEndedByPlugin811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_in_anyStringDecl827 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_string_in_anyDecl853 = new BitSet(new long[]{0x0000021108000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_anyDecl865 = new BitSet(new long[]{0x0000021108000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_reference_in_anyDecl873 = new BitSet(new long[]{0x0000021108000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_template_in_anyDecl882 = new BitSet(new long[]{0x0000021108000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_integer_in_anyDecl892 = new BitSet(new long[]{0x0000021108000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_jsonObject_in_anyDecl903 = new BitSet(new long[]{0x0000021108000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_String_in_string920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_identifier942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Number_in_integer953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Reference_in_reference964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Reference_in_template976 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_member_in_template979 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Member_in_member1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_in_jsonValue1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_in_jsonValue1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jsonObject_in_jsonValue1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_jsonValue1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_jsonValue1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_jsonValue1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_jsonValue1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Number_in_number1072 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_Exponent_in_number1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_jsonObject1108 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_members_in_jsonObject1110 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_jsonObject1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_array1137 = new BitSet(new long[]{0x8000020100000000L,0x000000000000001FL});
    public static final BitSet FOLLOW_elements_in_array1139 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_array1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jsonValue_in_elements1163 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_COMMA_in_elements1166 = new BitSet(new long[]{0x8000020100000000L,0x000000000000001EL});
    public static final BitSet FOLLOW_jsonValue_in_elements1169 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_pair_in_members1182 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_COMMA_in_members1185 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_pair_in_members1188 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_String_in_pair1202 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_pair1204 = new BitSet(new long[]{0x8000020100000000L,0x000000000000001EL});
    public static final BitSet FOLLOW_jsonValue_in_pair1206 = new BitSet(new long[]{0x0000000000000002L});

}