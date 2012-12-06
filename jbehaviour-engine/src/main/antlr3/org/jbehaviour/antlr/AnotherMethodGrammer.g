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

grammar AnotherMethodGrammer;

options
{
	output=AST;
	// ANTLR can handle literally any tree node type.
	// For convenience, specify the Java type
	ASTLabelType=CommonTree;
}

tokens {
	TOK_NUMBER;
	TOK_STRING;
	TOK_TEMPLATE;
	TOK_IDENTIFIER;
	TOK_NUMBER;
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
	/**
	 * debug
	 */
    	public void onDebug(String where,String value) {
    		System.err.println(where+" "+value);
    	}
    	public void onIsMethod(String isMethod) {
	    	onDebug("onIsMethod: ", isMethod);
    	}
    	public void onAnyReference(String reference) {
	    	onDebug("onAnyReference: ", reference);
    	}
    	public void onAnyIdentifier(String identifier) {
	    	onDebug("onAnyIdentifier: ", identifier);
    	}
    	public void onAnyString(String string) {
	    	onDebug("onAnyString: ", string);
    	}
    	public void onAnyNumber(String number) {
	    	onDebug("onAnyNumber: ", number);
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

template 
	: Reference {onAnyReference($Reference.text);} (Dot identifier {onAnyIdentifier($identifier.text);} arguments?)+
	 -> ^(TOK_TEMPLATE Reference (Dot identifier (arguments)?)+)
	;

arguments
	: (LeftBrace {onIsMethod($LeftBrace.text);} (number {onAnyNumber($number.text);}|string {onAnyString($string.text);}|WS|Comma)* RightBrace)
	;

string 	: String
	  -> ^(TOK_STRING String)
	;

identifier
	: Identifier
	  -> ^(TOK_IDENTIFIER Identifier)
	;

integer
	: Number
	  -> ^(TOK_NUMBER Number)
	;

reference
	: Reference
	;

number	: n=Number {Pattern.matches("(0|(-?[1-9]\\d*))(\\.\\d+)?", n.getText())}? 
	    Exponent? 
	  -> ^(TOK_NUMBER Number Exponent?)
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

fragment Member : Dot Identifier (LeftBrace (Number|String|WS|Comma)* RightBrace)?
	;

Identifier :
	(Alphanumeric|UnderScrore|Arobase)+
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

LeftBrace
	: '('
	;

RightBrace
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

Dot
	: '.'
	;

Comma
	: ','
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