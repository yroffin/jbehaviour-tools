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

grammar CreoleGrammer;

options
{
	output=AST;
	// ANTLR can handle literally any tree node type.
	// For convenience, specify the Java type
	ASTLabelType=CommonTree;
}

tokens {
	TOK_ITALICS;
	TOK_BOLD;
	TOK_BULLETS;
	TOK_NUMBERED;
	TOK_HEADING;
	TOK_OPENHEADING;
	TOK_CLOSEHEADING;
	TOK_LINKTO;
	TOK_LINKTOURL;
	TOK_BLOCS;
	TOK_WORDS;
}

@header {
    package org.jbehaviour.antlr;
    import java.io.IOException;
}

@lexer::header {
    package org.jbehaviour.antlr;
}

@lexer::members {
   	/**
   	 * debug
   	 */
       	public void onDebug(String where) {
       		System.err.println("=> "+where);
       	}
       	public void onDebug(String what,org.antlr.runtime.CommonToken value) {
       		System.err.println("==> "+what+" ["+value+"]");
       	}
       	boolean inSentence;
       	public void setInSentence(boolean value) {
       		inSentence = value;
       	}
       	public boolean inSentence() {
       		return inSentence;
       	}
}
@members {
       	boolean inSentence;
       	public void setInSentence(boolean value) {
       		inSentence = value;
       	}
       	public boolean inSentence() {
       		return inSentence;
       	}
   	/**
   	 * debug
   	 */
       	public void onDebug(String where,String value) {
       		System.err.println("*** "+where+" ["+value+"]");
       	}
       	public void onDebug(String where) {
       		System.err.println("*** "+where);
       	}
       	public void onBeginSentence() {
       		onDebug("onBeginSentence");
       		((CreoleGrammerLexer)input.getTokenSource()).setInSentence(true);
       	}
       	public void onEndSentence() {
       		onDebug("onEndSentence");
       		((CreoleGrammerLexer)input.getTokenSource()).setInSentence(false);
       	}
       	public void onAnyItalics(String value) {
       		onDebug("onAnyItalics",value);
       	}
       	public void onAnyBold(String value) {
       		onDebug("onAnyBold",value);
       	}
       	public void onAnyContent(String value) {
       		onDebug("onAnyContent",value);
       	}
       	/**
       	 * linkto : [[linkname]]
       	 */
       	public void onAnyLinkTo(String value) {
       		onDebug("onAnyLinkTo",value);
       	}
       	/**
       	 * linktourl : [[URL|linkname]]
       	 */
       	public void onAnyLinkToUrl(String value) {
       		onDebug("onAnyLinkToUrl",value);
       	}
       	/**
       	 * format
       	 * headings, bullets, numbered
       	 */
       	public void onAnyHeadings(String value) {
       		onDebug("onAnyHeading",value);
       	}
       	public void onAnyBullets(String value) {
       		onDebug("onAnyBullet",value);
       	}
       	public void onAnyNumbered(String value) {
       		onDebug("onAnyNumbered",value);
       	}
       	public void onAfterAnyHeadings(String value) {
       		onDebug("onAnyHeading",value);
       	}
       	public void onAfterAnyBullets(String value) {
       		onDebug("onAnyBullet",value);
       	}
       	public void onAfterAnyNumbered(String value) {
       		onDebug("onAnyNumbered",value);
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

creole : (contents)*;

contents: (formats|sentence|LexEol);

formats
	:(
	  bullets
	  | numbered
	  | heading
	 )
	;

sentence: {onBeginSentence();} (words+|bold|italics) {onEndSentence();};

/**
 * bullet parsing
 */
bullets:left=lexStars {onAnyBullets($left.text);} sentence (right=lexStars {onAfterAnyBullets($right.text);})* LexEol;
lexStars : LexStars;

/**
 * numbered parsing
 */
numbered:left=LexDieses {onAnyNumbered($left.text);} sentence (right=LexDieses {onAfterAnyNumbered($right.text);})* LexEol;
lexDieses : LexDieses;

/**
 * heading parsing
 */
heading:left=lexEquals {onAnyHeadings($left.text);} sentence (right=lexEquals {onAfterAnyHeadings($right.text);})* LexEol;
lexEquals : LexEquals;

words	:	w1=LexContent {onAnyContent($w1.text);}
	-> ^(TOK_WORDS LexContent);

italics: begTwoSlashes contents {onAnyItalics($contents.text);} endTwoSlashes
	-> ^(TOK_ITALICS begTwoSlashes contents endTwoSlashes);
begTwoSlashes: LexTwoSlashes;
endTwoSlashes: LexTwoSlashes;

bold: begTwoStars contents {onAnyBold($contents.text);} endTwoStars
	-> ^(TOK_BOLD begTwoStars contents endTwoStars);
begTwoStars: LexTwoStars;
endTwoStars: LexTwoStars;

linkTo 	: '[[' words ']]' {onAnyLinkTo($words.text);}
	-> ^(TOK_LINKTO '[[' words ']]');

linkToUrl 	: '[[URL|' words ']]' {onAnyLinkToUrl($words.text);}
	-> ^(TOK_LINKTOURL '[[URL|' words ']]');

// $>

// $<Lexer

LexContent : {onDebug("LexContent");} a=Identifier {onDebug("Identifier",$a);};

/**
 * during sentence evaluation
 * format parsing is disabling, so ****.., ====... and ###... are disable
 */
LexStars  : {!inSentence()}? => a=Stars  {onDebug("Stars",$a);};
LexDieses : {!inSentence()}? => a=Dieses {onDebug("Dieses",$a);};
LexEquals : {!inSentence()}? => a=Equals {onDebug("Equals",$a);};

LexTwoStars 	: a=TwoStars {onDebug("TwoStars",$a);};
LexTwoSlashes 	: a=TwoSlashes {onDebug("TwoSlashes",$a);};

LexEol : a=Eol {onDebug("Eol",$a);} {skip();};
LexWS  : a=WS  {onDebug("WS",$a);}  {skip();};

fragment TwoStars 	: (Star Star);
fragment TwoSlashes 	: (Slash Slash);
fragment Stars 	: (Star+);
fragment Dieses	: (Diese+);
fragment Equals	: (Equal+);

fragment Eol
    : ('\n')
    | ('\n')('\r')
    | ('\r')('\n')
    ;

fragment WS: (' '|'\t')+;

/**
 * Fragment
 */
fragment Identifier :
	(Alphanumeric|Comma|Semicolon|UnderScrore|Dot|Minus|LeftBrace|RightBrace)+
	;

fragment Semicolon
	: ':'
	;

fragment Minus
	: '-'
	;

fragment UnderScrore
	: '_'
	;

fragment Pipe
	: '|'
	;

fragment LeftBrace
	: '('
	;

fragment RightBrace
	: ')'
	;

fragment LeftBracket
	: '['
	;

fragment RightBracket
	: ']'
	;

fragment Cote
	: '\''
	;

fragment DoubleCote
	: '"'
	;

fragment Star
	: '*'
	;

fragment Slash
	: '/'
	;

fragment Diese
	: '#'
	;

fragment Equal
	: '='
	;

fragment Comma
	: ','
	;

fragment Dot
	: '.'
	;

fragment Alphanumeric
	: '0'..'9' | 'A'..'Z' | 'a'..'z'
	;

// $>