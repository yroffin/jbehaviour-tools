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

package org.jbehaviour.plugins.sikuli;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.jbehaviour.annotation.Given;
import org.sikuli.api.*;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JBehaviourSikuliSteps {
	Logger logger = LoggerFactory.getLogger(JBehaviourSikuliSteps.class);

	// Create a screen region object that corresponds to the default monitor in full screen 
    ScreenRegion s = new DesktopScreenRegion();

	@Given("with sikuli type $character on $image")
	public void withSikuliTypeCharacter(String someCharacter, String image) throws Exception {
		// reuse action
		withSikuliClickOnImage(image);
		// Click the center of the found target
        DesktopKeyboard keyboard = new DesktopKeyboard();
        logger.info("Type [" + someCharacter + "]");
        keyboard.paste(someCharacter);
	}

	@Given("with sikuli type return")
	public void withSikuliTypeReturn() throws Exception {
		// Click the center of the found target
        DesktopKeyboard keyboard = new DesktopKeyboard();
        logger.info("Type RETURN");
        keyboard.type("\n");
	}

	private ScreenRegion findScreenRegion(String image) throws Exception {
		// Specify an image as the target to find on the screen
        URL imageURL = new URL(image);
		Target imageTarget = new ImageTarget(imageURL);
		
		// Wait for the target to become visible on the screen for at most 5 seconds
        // Once the target is visible, it returns a screen region object corresponding
        // to the region occupied by this target
        ScreenRegion r = s.wait(imageTarget,5000);
        if(r == null) throw new Exception("Unable to find " + image);
        return r;
	}

	@Given("with sikuli click on $image")
	public void withSikuliClickOnImage(String image) throws Exception {
		// Click the center of the found target
        Mouse mouse = new DesktopMouse();
        logger.info("Click on [" + image + "]");
        mouse.click(findScreenRegion(image).getCenter());
	}

	@Given("with sikuli doubleclick on $image")
	public void withSikuliDoubleClickOnImage(String image) throws Exception {
		// Click the center of the found target
        Mouse mouse = new DesktopMouse();
        logger.info("Double click on [" + image + "]");
        mouse.doubleClick(findScreenRegion(image).getCenter());
	}

	@Given("with sikuli capture desktop to $filename in $format format")
	public void withSikuliCaptureScreen(String filename, String format) throws IOException {
		BufferedImage toSave = s.capture();
		File outputfile = new File(filename);
	    ImageIO.write(toSave, format, outputfile);
	}

	@Given("with sikuli capture desktop to $dir in $filename in $format format")
	public void withSikuliCaptureScreen(String dir, String filename, String format) throws IOException {
		BufferedImage toSave = s.capture();
		File outputfile = new File(dir + '/' + filename + '.' + format);
	    ImageIO.write(toSave, format, outputfile);
	}
}
