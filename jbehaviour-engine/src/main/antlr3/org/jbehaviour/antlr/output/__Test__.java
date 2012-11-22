import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import org.jbehaviour.antlr.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        AnotherStoryGrammerLexer lex = new AnotherStoryGrammerLexer(new ANTLRFileStream("D:\\Workspace\\eclipse\\kepler-64\\git\\jbehave-tools\\jbehaviour-engine\\src\\test\\resources\\files\\include.story", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        AnotherStoryGrammerParser g = new AnotherStoryGrammerParser(tokens, 49100, null);
        try {
            g.story();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}