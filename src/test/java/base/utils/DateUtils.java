package base.utils;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class DateUtils {

    @Test
    public void testTime(){
        String start = "2021-02-10 7:40:00";
        String end = "2021-02-10 10:45:03";
        Date dateTimeStart = DateUtil.parseDateTime(start);
        Date dateTimeEnd = DateUtil.parseDateTime(end);
        Long between = dateTimeEnd.getTime() - dateTimeStart.getTime();
        BigDecimal betweenHour = new BigDecimal(between).divide(new BigDecimal(60*60*1000), 4, BigDecimal.ROUND_HALF_UP);
        System.out.println("---> between:"+betweenHour);
    }

    @Test
    public void testDateTime(){

    }
}
