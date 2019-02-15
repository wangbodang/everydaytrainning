package common.string;

import common.util.AmountNumberToCN;
import common.util.SplitStringByLength;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class StringTest {

    /**
     * 测试split函数
     */
    @Test
    public void testSplitString(){
        String demo = "wang,bodang";
        String[] strArr = demo.split(",");
        for(String s:strArr){
            System.out.println(s);
        }
    }

    /**
     *
     */
    @Test
    public void testSubString(){
        String skm = "035*17-+*43>7><<**6/56994<13<56>*59272*<-541-2-01-15/765976830<819<6>92-398342191350+8298240>*011363037193>6*106";
        if(StringUtils.isNotBlank(skm)){
            int lines = 4;
            int rowCounts = skm.length()/4;
            for(int i=0;i<lines;i++){
                System.out.println(skm.substring(i*rowCounts, (i+1)*rowCounts));
            }
        }
    }

    /**
     *
     */
    @Test
    public void testAmountToCn(){
        BigDecimal bd = new BigDecimal(18330001.00);
        System.out.println(AmountNumberToCN.number2CNMontrayUnit(bd));
    }

    /**
     * 校验码, 四位中间加一个空格
     */
    @Test
    public void testJYM(){
        String jym = "73976603510708735039";
        System.out.println(jym.length());

        List<String> jymList = SplitStringByLength.getStrList(jym, 5);
        for(String s:jymList){
            System.out.println(s);
        }

        System.out.println(SplitStringByLength.getJymWithBlank(jym,5));
    }

    /**
     * 建筑服务发生地截取
     */
    @Test
    public void testSpiltByAddr(){
        //String bz = "项目名称：马钢晋西轮轴项目一期货车、客车轮对厂房和成品库 厂房总包工程 \r\n项目地址：安徽马鞍山经济开发区";
        String bz = "项目名称：郑州市中原新区三十里铺安置区项目中地块一标段 \n" +
                "项目地址：绕城高速辅道以东、奇秀路以西、阳春北路以南、阳春路以北区域";
        String[] bzArr = bz.split("\n");
        System.out.println(bzArr[0].length());

        String xmmc = "项目名称：郑州市中原新区三十里铺安置区项目中地块一";
        System.out.println(xmmc.length());
    }

    @Test
    public void testStringSplitLength(){
        String xmmc = "项目名称：郑州市中原新区三十里铺安置区项目中地块一标段项目名称：郑州市中原新区三十里铺安置区项目";
        int bzLineCounts = 25;
        int rows = (xmmc.length()%bzLineCounts == 0)?xmmc.length()/bzLineCounts:(xmmc.length()/bzLineCounts+1);
        System.out.println(rows);
        for(int i=0;i<rows;i++){
            System.out.println(xmmc.substring(i*bzLineCounts, (i+1)*bzLineCounts));
        }
    }
}
