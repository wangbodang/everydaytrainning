package common.log4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Test {
    //Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    static Logger logger = LoggerFactory.getLogger(Log4j2Test.class.getName());

    @Test
    public void testLog4j2(){
        logger.info("fook");
    }
}
