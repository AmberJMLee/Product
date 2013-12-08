package log4j.test;
import org.apache.log4j.Logger;

public class log4j {
	public static final Logger log = Logger.getLogger(log4j.class);
	public static void main(String[] args)
	{
		log.trace("I love you");
	}
}
