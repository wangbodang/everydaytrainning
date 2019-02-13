package common.apache_commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.UUID;

public class CommonsLoggingTest {

    @Test
    public void testCommonsLogging(){
        Log log = LogFactory.getLog(CommonsLoggingTest.class);

        log.info("fook");
        log.error("fook");
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}
