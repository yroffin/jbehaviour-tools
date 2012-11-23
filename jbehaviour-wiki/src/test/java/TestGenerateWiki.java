import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;
import info.bliki.wiki.model.WikiModel;

public class TestGenerateWiki {

	@Test
	public void test() throws IOException {
		String htmlText = WikiModel.toHtml("This is a simple [[Hello World]] wiki tag");
		FileWriter fw = new FileWriter(new File("wiki/index.html"));
		fw.write(htmlText);
		fw.close();
		
	}

}
