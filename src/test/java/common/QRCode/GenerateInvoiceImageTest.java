package common.QRCode;

import common.domain.BillingQuery;
import org.junit.Test;

public class GenerateInvoiceImageTest {



    @Test
    public void testGenereateInvoiceImage(){
        BillingQuery bq = getBillingQueryDemo();

    }

    /**
     * "19"	"21"
     * "4100182130"
     * "03890116"
     * "3"
     * \N
     * "20181008102525"
     * \N
     * "035*17-+*43>7><<**6/56994<13<56>*59272*<-541-2-01-15/765976830<819<6>92-398342191350+8298240>*011363037193>6*106"
     * "73976603510708735039"
     * "91410100170051134L"
     * "河南五建建设集团有限公司"
     * "郑州市中原区建设西路100号0371-67869735"
     * "建行郑州百花路支行 41001520010050000199"
     * "91410100577618999K"
     * "郑州西流湖控股有限公司"
     * "郑州市中原区中原西路须水街道办事处三层0371-86238323"
     * "工商银行南阳路支行1702021709200185666"
     * \N
     * \N
     * "0.1"
     * "16663636.36"	"
     * 1666363.64"
     * "1.833E7"
     * "项目名称：郑州市中原新区三十里铺安置区项目中地块一标段
     * 项目地址：绕城高速辅道以东、奇秀路以西、阳春北路以南、阳春路以北区域"
     * "蒋毅弘"
     * "何慧姮"
     * "张毅冰"
     * \N
     * "*建筑服务*工程服务"
     * ""
     * "0"
     * "201810"
     * \N
     * \N
     * \N
     * \N
     * "Mon Oct 08 16:23:14 CST 2018"
     * "张毅冰"
     * \N
     * \N
     * \N
     * \N
     * ""
     * "1"
     * "@28"
     * \N
     * @return
     */
    private BillingQuery getBillingQueryDemo() {
        BillingQuery bq = new BillingQuery();


        return bq;
    }
}
