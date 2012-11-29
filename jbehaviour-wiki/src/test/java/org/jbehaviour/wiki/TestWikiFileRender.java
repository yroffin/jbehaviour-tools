package org.jbehaviour.wiki;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class TestWikiFileRender {
	@Test
	public void testRenderWiki() throws IOException  {
		WikiCompiler compiler = new WikiCompiler();
		compiler.compile(
				new File("src/test/resources/markdown.css"), 
				new File("src/test/resources/index.html"), 
				new File("wiki/md"),
				new File("wiki/html"));
	}
}
