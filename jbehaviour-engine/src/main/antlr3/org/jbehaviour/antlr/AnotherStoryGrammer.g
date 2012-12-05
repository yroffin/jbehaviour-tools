/*
 *    Copyright 2012-2012 Yannick Roffin
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 * @author Roffin Yannick
 */

grammar AnotherStoryGrammer;

options
{
	output=AST;
	// ANTLR can handle literally any tree node type.
	// For convenience, specify the Java type
	ASTLabelType=CommonTree;
}

tokens {
	FEATURE='Feature:';
	INORDERTO='In order to';
	ASAN='As an';
	IWANTTO='I want to';
	REGISTER='Register';
	INCLUDE='Include';
	REPORT='Report';
	DECLARE='Declare';
	PLUGIN='plugin';
	SCENARIO='Scenario:';
	GIVEN='Given';
	WHEN='When';
	THEN='Then';
	AND='And';
	STORE='Store';

	TOK_FEATURE;
	TOK_INORDERTO;
	TOK_ASAN;
	TOK_IWANTTO;
	TOK_REGISTER;
	TOK_INCLUDE;
	TOK_REPORT;
	TOK_DECLARE;

	TOK_SCENARIO;
	TOK_GIVEN;
	TOK_WHEN;
	TOK_THEN;
	TOK_AND;
	TOK_STORE;
	TOK_TEMPLATE;

	STRING;
	NUMBER;
	OBJECT;
	FIELD;
	ARRAY;
	COMMA = ',';
	TRUE; FALSE; NULL;
}

@header {
    package org.jbehaviour.antlr;
    import java.io.IOException;
    import java.util.regex.Pattern;
}

@lexer::header {
    package org.jbehaviour.antlr;
}

@lexer::members {
}
@members {
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
    	public void onFeatureReportKeyword() {
    		onDebug("onFeatureReportKeyword","");
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
}

// Alter code generation so catch-clauses get replace with 
// this action. 
@rulecatch { 
catch (Exception e) { 
//throw e; 
} 
}

// $<Parser

story
	: feature (scenario)*
	;

feature: FEATURE {onFeatureKeyword();} anyDecl featureDecl
	  -> ^(TOK_FEATURE FEATURE anyDecl featureDecl)
	;

featureDecl
	: inOrderToDecl asAnDecl iWantToDecl (includeDecl|registerDecl|reportDecl|declareDecl)*
	;

inOrderToDecl: INORDERTO anyDecl
	  -> ^(TOK_INORDERTO INORDERTO anyDecl)
	;
asAnDecl: ASAN anyDecl
	  -> ^(TOK_ASAN ASAN anyDecl)
	;
iWantToDecl: IWANTTO anyDecl
	  -> ^(TOK_IWANTTO IWANTTO anyDecl)
	;
includeDecl: INCLUDE {onFeatureIncludeKeyword();} anyStringDecl
	  -> ^(TOK_INCLUDE INCLUDE anyStringDecl)
	;
registerDecl: REGISTER {onFeatureRegisterKeyword();} anyDeclEndedByPlugin
	  -> ^(TOK_REGISTER REGISTER anyDeclEndedByPlugin)
	;
reportDecl: REPORT {onFeatureReportKeyword();} anyDecl
	  -> ^(TOK_REPORT DECLARE anyDecl)
	;
declareDecl: DECLARE {onFeatureDeclareKeyword();} anyDecl
	  -> ^(TOK_DECLARE DECLARE anyDecl)
	;

scenarioKeyword
	: SCENARIO {onScenarioKeyword();}
	;

scenario: scenarioKeyword anyDecl statementDecl
	  -> ^(TOK_SCENARIO scenarioKeyword anyDecl statementDecl)
	;

statementDecl
	: (
	   ((giveDecl storeDecl?)((andDecl storeDecl?)*))
	  |((whenDecl storeDecl?)((andDecl storeDecl?)*))
	  |((thenDecl storeDecl?)((andDecl storeDecl?)*))
	  )+
	;

givenKeyword
	: GIVEN {onGivenKeyword();}
	;

whenKeyword
	: WHEN {onWhenKeyword();}
	;

thenKeyword
	: THEN {onThenKeyword();}
	;

andKeyword
	: AND {onAndKeyword();}
	;

giveDecl
	: givenKeyword anyDecl
	  -> ^(TOK_GIVEN givenKeyword anyDecl)
	;
whenDecl
	: whenKeyword anyDecl
	  -> ^(TOK_WHEN whenKeyword anyDecl)
	;
thenDecl
	: thenKeyword anyDecl
	  -> ^(TOK_THEN thenKeyword anyDecl)
	;
andDecl
	: andKeyword anyDecl
	  -> ^(TOK_AND andKeyword anyDecl)
	;
storeDecl
	: STORE {onStoreKeyword();} anyDecl
	  -> ^(TOK_STORE STORE anyDecl)
	;
anyDeclEndedByPlugin
	: (
	    string     {onAnyString($string.text);}
	   |identifier {onAnyIdentifier($identifier.text);}
	  )+ PLUGIN;
/**
 * only string rule
 */
anyStringDecl
	: (
	   string     {onAnyString($string.text);}
	  )+;
anyDecl
	: (
	   string     {onAnyString($string.text);}
	  |identifier {onAnyIdentifier($identifier.text);}
	  |reference  {onAnyReference($reference.text);}
	  |template   {onAnyTemplate($template.text);}
	  |integer    {onAnyNumeric($integer.text);}
	  |jsonObject {onAnyJsonObject($jsonObject.text);}
	  )+;

string 	: String
	  -> ^(STRING String)
	;

identifier
	: Identifier
	;

integer
	: Number
	;

reference
	: Reference
	;

template 
	: Reference (member)+
	 -> ^(TOK_TEMPLATE Reference (member)+)
	;

member	:	Member;

/**
 * Json part
 */
jsonValue
	: string
	| number
	| jsonObject
	| array
	| 'true' -> TRUE
	| 'false' -> FALSE
	| 'null' -> NULL
	;

// If you want to conform to the RFC, use a validating semantic predicate to check the result.
number	: n=Number {Pattern.matches("(0|(-?[1-9]\\d*))(\\.\\d+)?", n.getText())}? 
	    Exponent? 
	  -> ^(NUMBER Number Exponent?)
	;

jsonObject	: '{' members? '}' 
	  -> ^(OBJECT members?)
	;
	
array	: '[' elements? ']'
	  -> ^(ARRAY elements?)
	;

elements: jsonValue (COMMA! jsonValue)*
	;
	
members	: pair (COMMA! pair)*
	;
	 
pair	: String ':' jsonValue 
	  -> ^(FIELD String jsonValue) 
	;

// $>

// $<Lexer

Number	: '-'? Digit+ ( '.' Digit+)?;

Exponent: ('e'|'E') '-'? ('1'..'9') Digit*;

String
	: DoubleCote ( EscapeSequence | ~('\u0000'..'\u001f' | '\\' | DoubleCote ) )* DoubleCote
	| Cote ( EscapeSequence | ~('\u0000'..'\u001f' | '\\' | Cote ) )* Cote
	;

Reference :
	Dollar Identifier
	;

Member : Dot Identifier (LeftBrace (Number|String|WS|COMMA)* RightBrace)?
	;

Identifier :
	(Alphanumeric|UnderScrore|Arobase)+
	;

Comment
    : '#' ( options{greedy=false;} : .)* Eol+ { $channel=HIDDEN; }
    ;

fragment Eol
    : ('\n')
    | ('\n')('\r')
    | ('\r')('\n')
    ;

WS: (' '|Eol|'\t')+ {$channel=HIDDEN;} ; // ignore whitespace 

fragment EscapeSequence
    	:   '\\' (UnicodeEscape |'b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\'|'\/')
    	;

fragment UnderScrore
	: '_'
	;

fragment LeftBrace
	: '('
	;

fragment RightBrace
	: ')'
	;

fragment Dollar
	: '$'
	;

fragment Arobase
	: '@'
	;

fragment Cote
	: '\''
	;

fragment DoubleCote
	: '"'
	;

fragment Dot
	: '.'
	;

fragment UnicodeEscape
	: 'u' HexDigit HexDigit HexDigit HexDigit
	;

fragment Alphanumeric
	: '0'..'9' | 'A'..'Z' | 'a'..'z'
	;

fragment HexDigit
	: '0'..'9' | 'A'..'F' | 'a'..'f'
	;

fragment Digit
	: '0'..'9'
	;

// $>