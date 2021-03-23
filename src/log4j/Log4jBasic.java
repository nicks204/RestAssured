package log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Log4jBasic {
	
	static final Logger logger = Logger.getLogger(Log4jBasic.class);
				 
    public static void main(String[] args)
    {
        //Configure logger
        BasicConfigurator.configure();
        logger.debug("Hello World!");
    }


}
