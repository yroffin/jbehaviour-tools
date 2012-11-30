package org.jbehaviour.report.impl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
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
		FileWriter fw = new FileWriter(output);
		fw.write(render(ctx,slurp(template)));
		fw.close();
	}
}
