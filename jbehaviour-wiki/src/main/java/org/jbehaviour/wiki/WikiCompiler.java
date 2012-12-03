/**
 *  Copyright 2012 Yannick Roffin
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.jbehaviour.wiki;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.petebevin.markdown.MarkdownProcessor;

public class WikiCompiler {
	Logger logger = LoggerFactory.getLogger(WikiCompiler.class);

	public WikiCompiler() {
	}

	/**
	 * read this file in one single output string
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private String slurp(File file) throws IOException {
        FileReader in = new FileReader(file);
        StringBuffer sb = new StringBuffer();
        int ch;
        while ((ch = in.read()) != -1) {
            sb.append((char) ch);
        }
        in.close();
        return sb.toString();
    }

	/**
	 * file filter class
	 */
	private class OnlyMd implements FilenameFilter {

		@Override
		public boolean accept(File dir, String name) {
			if(dir.isDirectory()) return true;
			return name.endsWith(".md");
		}
		
	}

	/**
	 * scan files
	 * @param file
	 * @param list
	 * @param filter
	 * @return
	 */
	private List<File> scanDirectory(File file, List<File> list, FilenameFilter filter) {
		if(file.isDirectory()) {
			for(File subfile : file.listFiles(filter)) {
				scanDirectory(subfile,list,filter);
			}
		} else {
			if(file.isFile()) {
				list.add(file);
			}
		}
		return list;
	}

	/**
	 * compile dir
	 * @param indir
	 * @param outdir
	 * @param  
	 * @throws IOException
	 */
	public void compile(File css, File head, File indir, File outdir) throws IOException {
		compileMd(css,head,indir,outdir);
	}

	/**
	 * compile dir
	 * @param indir
	 * @param outdir
	 * @param  
	 * @throws IOException
	 */
	public void compileMd(File css, File head, File indir, File outdir) throws IOException {
		MarkdownProcessor markup = new MarkdownProcessor();
		String header = slurp(head);
		for(File file : scanDirectory(indir,new ArrayList<File>(),new OnlyMd())) {
			String outputfile = file.getAbsolutePath().replace(indir.getAbsolutePath(), outdir.getAbsolutePath()).replace(".md", ".html");
			String cssfile = file.getAbsolutePath().replace(indir.getAbsolutePath(), outdir.getAbsolutePath()).replace(file.getName(), "markdown.css");
			File dir = new File(new File(outputfile).getParent());
			dir.mkdirs();
			FileWriter fw = new FileWriter(outputfile);
			fw.write(header);
			fw.write(markup.markdown(slurp(file).replace(".md", ".html")));
			fw.close();
			fw = new FileWriter(cssfile);
			fw.write(slurp(css));
			fw.close();
			logger.info("Render " + outputfile + " ok");
		}
	}

}
