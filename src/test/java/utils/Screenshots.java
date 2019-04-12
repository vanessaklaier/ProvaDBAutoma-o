package utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Screenshots {
	public static String captureFullScreen() {
		String newPath = "screenshots\\" + System.currentTimeMillis() + ".png";
		try {
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage capture = new Robot().createScreenCapture(screenRect);
			ImageIO.write(capture, "png", new File(newPath));
		} catch (Exception ex) {
			System.out.println("No foi possivel realizar a funo de screenshot");
		}

		return newPath;
	}
}