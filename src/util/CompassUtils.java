/**
 * @Date 2016年8月3日
 *
 * @author Administrator
 */
package util;

import org.compass.core.Compass;
import org.compass.core.config.CompassConfiguration;

/**
 * @author 郭瑞彪
 *
 */
public class CompassUtils {
	private static Compass compassSessionFactory;

	static {
		CompassConfiguration cfg = new CompassConfiguration().configure();
		compassSessionFactory = cfg.buildCompass();
	}

	public static Compass getCompassSessionFactory() {
		return compassSessionFactory;
	}

}
