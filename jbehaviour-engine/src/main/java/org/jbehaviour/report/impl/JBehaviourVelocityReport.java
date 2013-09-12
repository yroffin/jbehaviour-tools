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

package org.jbehaviour.report.impl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.jbehaviour.reflexion.IBehaviourEnvProperty;
import org.jbehaviour.reflexion.IBehaviourReflexion;
import org.jbehaviour.report.IBehaviourReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JBehaviourVelocityReport implements IBehaviourReport {
	Logger logger = LoggerFactory.getLogger(JBehaviourVelocityReport.class);

	private VelocityContext context = null;
	private Writer writer = null;

	@Override
	public void init() {
		Velocity.init();
		context = new VelocityContext();
	}

	/**
	 * render this template
	 * @param ctx
	 * @param template
	 * @return
	 */
	public String render(IBehaviourReflexion ctx, String template) {
		context.put("context", ctx);
		
		/**
		 * dump all properties (shortcut)
		 */
		for(IBehaviourEnvProperty item : ctx.getEnv().getRawProperties()) {
			if(item.getKey().compareTo("context")==0) continue;
			context.put(item.getKey(), item.getValue());
		}

		writer  = new StringWriter();
		Velocity.evaluate(context, writer, "", template);
		return writer.toString();
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

	@Override
	public void render(IBehaviourReflexion ctx, File template, File output) throws IOException {
		logger.info("Render [" + template.getAbsolutePath() + "] to [" + output.getAbsolutePath() + "]");
		/**
		 * auto creation of output dir
		 */
		(new File(output.getParent())).mkdir();
		FileWriter fw = new FileWriter(output);
		fw.write(render(ctx,slurp(template)));
		fw.close();
	}
}
