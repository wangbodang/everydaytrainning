package common.domain;


/**
 * 销项 开票 开票填开
 */
public class BillingQuery {
    /** 主键 */
    private Integer id;
    /** 开票申请关联ID */
    private Integer billingDetailid;
    /** 发票代码 */
    private String fpdm;
    /** 发票号码 */
    private String fphm;
    /** 发票状态 */
    private String fpzt;
    /** 上传标志 */
    private String scbz;
    /** 开票日期 */
    private String kprq;
    /** 税控服务器编号 */
    private String jqbh;
    /** 税控码 */
    private String skm;
    /** 校验码 */
    private String jym;
    /** 销货单位识别号 */
    private String xhdwsbh;
    /** 销货单位名称 */
    private String xhdwmc;
    /** 销货单位地址电话 */
    private String xhdwdzdh;
    /** 销货单位银行账号 */
    private String xhdwyhzh;
    /** 购货单位识别号 */
    private String ghdwsbh;
    /** 购货单位名称 */
    private String ghdwmc;
    /** 购货单位地址电话 */
    private String ghdwdzdh;
    /** 购货单位银行账号 */
    private String ghdwyhzh;
    /** 编码表版本号 */
    private String bmbbbh;
    /** 征税方式 */
    private String zsfs;
    /** 综合税率 */
    private String zhsl;
    /** 合计金额 */
    private String hjje;
    /** 合计税额 */
    private String hjse;
    /** 价税合计 */
    private String jshj;
    /** 备注 */
    private String bz;
    /** 收款人 */
    private String skr;
    /** 复核人 */
    private String fhr;
    /** 开票人 */
    private String kpr;
    /** 加密版本号 */
    private String jmbbh;
    /** 主要商品名称 */
    private String zyspmc;
    /** 商品税目 */
    private String spsm;
    /** 清单标志 */
    private String qdbz;
    /** 所属月份 */
    private String ssyf;
    /** 开票机号 */
    private String kpjh;
    /** 信息表编号 */
    private String tzdbh;
    /** 原发票代码 */
    private String yfpdm;
    /** 原发票号码 */
    private String yfphm;
    /** 作废日期 */
    private String zfrq;
    /** 作废人 */
    private String zfr;
    /** 签名参数 */
    private String qmcs;
    /** 签名值 */
    private String qmz;
    /** 已开负数金额 */
    private String ykfsje;
    /** 验签结果 */
    private String yqjg;
    /** 二维码 */
    private String ewm;
    /** 开票终端标识 */
    private String kpzdbs;
    /** 发票类型代码 */
    private String fplxdm;

    /**
     * 开票状态
     */
    private String status;

    /**
     * 幂等
     */
    private String ident;

    /**
     * 发票类型
     */
    private String invoiceType;

    /**
     * 作废标志
     */
    private String zfbz;

    /** 机构名称 */
    private String proConstruUnitName;

    /** 项目名称 */
    private String proName;

    public String getProConstruUnitName() {
        return proConstruUnitName;
    }

    public void setProConstruUnitName(String proConstruUnitName) {
        this.proConstruUnitName = proConstruUnitName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    /**
     * @return the invoiceType
     */
    public String getInvoiceType() {
        return invoiceType;
    }

    /**
     * @param invoiceType
     *            the invoiceType to set
     */
    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the ident
     */
    public String getIdent() {
        return ident;
    }

    /**
     * @param ident
     *            the ident to set
     */
    public void setIdent(String ident) {
        this.ident = ident;
    }

    public void setKpzdbs(String kpzdbs) {
        this.kpzdbs = kpzdbs;
    }

    public void setFplxdm(String fplxdm) {
        this.fplxdm = fplxdm;
    }

    public String getKpzdbs() {
        return kpzdbs;
    }

    public String getFplxdm() {
        return fplxdm;
    }

    public Integer getId() {
        return id;
    }

    public String getFpdm() {
        return fpdm;
    }

    public String getFphm() {
        return fphm;
    }

    public String getFpzt() {
        return fpzt;
    }

    public String getScbz() {
        return scbz;
    }

    public String getKprq() {
        return kprq;
    }

    public String getJqbh() {
        return jqbh;
    }

    public String getSkm() {
        return skm;
    }

    public String getJym() {
        return jym;
    }

    public String getXhdwsbh() {
        return xhdwsbh;
    }

    public String getXhdwmc() {
        return xhdwmc;
    }

    public String getXhdwdzdh() {
        return xhdwdzdh;
    }

    public String getXhdwyhzh() {
        return xhdwyhzh;
    }

    public String getGhdwsbh() {
        return ghdwsbh;
    }

    public String getGhdwmc() {
        return ghdwmc;
    }

    public String getGhdwdzdh() {
        return ghdwdzdh;
    }

    public String getGhdwyhzh() {
        return ghdwyhzh;
    }

    public String getBmbbbh() {
        return bmbbbh;
    }

    public String getZsfs() {
        return zsfs;
    }

    public String getZhsl() {
        return zhsl;
    }

    public String getHjje() {
        return hjje;
    }

    public String getHjse() {
        return hjse;
    }

    public String getJshj() {
        return jshj;
    }

    public String getBz() {
        return bz;
    }

    public String getSkr() {
        return skr;
    }

    public String getFhr() {
        return fhr;
    }

    public String getKpr() {
        return kpr;
    }

    public String getJmbbh() {
        return jmbbh;
    }

    public String getZyspmc() {
        return zyspmc;
    }

    public String getSpsm() {
        return spsm;
    }

    public String getQdbz() {
        return qdbz;
    }

    public String getSsyf() {
        return ssyf;
    }

    public String getKpjh() {
        return kpjh;
    }

    public String getTzdbh() {
        return tzdbh;
    }

    public String getYfpdm() {
        return yfpdm;
    }

    public String getYfphm() {
        return yfphm;
    }

    public String getZfrq() {
        return zfrq;
    }

    public String getZfr() {
        return zfr;
    }

    public String getQmcs() {
        return qmcs;
    }

    public String getQmz() {
        return qmz;
    }

    public String getYkfsje() {
        return ykfsje;
    }

    public String getYqjg() {
        return yqjg;
    }

    public String getEwm() {
        return ewm;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFpdm(String fpdm) {
        this.fpdm = fpdm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public void setFpzt(String fpzt) {
        this.fpzt = fpzt;
    }

    public void setScbz(String scbz) {
        this.scbz = scbz;
    }

    public void setKprq(String kprq) {
        this.kprq = kprq;
    }

    public void setJqbh(String jqbh) {
        this.jqbh = jqbh;
    }

    public void setSkm(String skm) {
        this.skm = skm;
    }

    public void setJym(String jym) {
        this.jym = jym;
    }

    public void setXhdwsbh(String xhdwsbh) {
        this.xhdwsbh = xhdwsbh;
    }

    public void setXhdwmc(String xhdwmc) {
        this.xhdwmc = xhdwmc;
    }

    public void setXhdwdzdh(String xhdwdzdh) {
        this.xhdwdzdh = xhdwdzdh;
    }

    public void setXhdwyhzh(String xhdwyhzh) {
        this.xhdwyhzh = xhdwyhzh;
    }

    public void setGhdwsbh(String ghdwsbh) {
        this.ghdwsbh = ghdwsbh;
    }

    public void setGhdwmc(String ghdwmc) {
        this.ghdwmc = ghdwmc;
    }

    public void setGhdwdzdh(String ghdwdzdh) {
        this.ghdwdzdh = ghdwdzdh;
    }

    public void setGhdwyhzh(String ghdwyhzh) {
        this.ghdwyhzh = ghdwyhzh;
    }

    public void setBmbbbh(String bmbbbh) {
        this.bmbbbh = bmbbbh;
    }

    public void setZsfs(String zsfs) {
        this.zsfs = zsfs;
    }

    public void setZhsl(String zhsl) {
        this.zhsl = zhsl;
    }

    public void setHjje(String hjje) {
        this.hjje = hjje;
    }

    public void setHjse(String hjse) {
        this.hjse = hjse;
    }

    public void setJshj(String jshj) {
        this.jshj = jshj;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public void setSkr(String skr) {
        this.skr = skr;
    }

    public void setFhr(String fhr) {
        this.fhr = fhr;
    }

    public void setKpr(String kpr) {
        this.kpr = kpr;
    }

    public void setJmbbh(String jmbbh) {
        this.jmbbh = jmbbh;
    }

    public void setZyspmc(String zyspmc) {
        this.zyspmc = zyspmc;
    }

    public void setSpsm(String spsm) {
        this.spsm = spsm;
    }

    public void setQdbz(String qdbz) {
        this.qdbz = qdbz;
    }

    public void setSsyf(String ssyf) {
        this.ssyf = ssyf;
    }

    public void setKpjh(String kpjh) {
        this.kpjh = kpjh;
    }

    public void setTzdbh(String tzdbh) {
        this.tzdbh = tzdbh;
    }

    public void setYfpdm(String yfpdm) {
        this.yfpdm = yfpdm;
    }

    public void setYfphm(String yfphm) {
        this.yfphm = yfphm;
    }

    public void setZfrq(String zfrq) {
        this.zfrq = zfrq;
    }

    public void setZfr(String zfr) {
        this.zfr = zfr;
    }

    public void setQmcs(String qmcs) {
        this.qmcs = qmcs;
    }

    public void setQmz(String qmz) {
        this.qmz = qmz;
    }

    public void setYkfsje(String ykfsje) {
        this.ykfsje = ykfsje;
    }

    public void setYqjg(String yqjg) {
        this.yqjg = yqjg;
    }

    public void setEwm(String ewm) {
        this.ewm = ewm;
    }

    /**
     * @return the billingDetailid
     */
    public Integer getBillingDetailid() {
        return billingDetailid;
    }

    /**
     * @param billingDetailid
     *            the billingDetailid to set
     */
    public void setBillingDetailid(Integer billingDetailid) {
        this.billingDetailid = billingDetailid;
    }

    public String getZfbz() {
        return zfbz;
    }

    public void setZfbz(String zfbz) {
        this.zfbz = zfbz;
    }

    @Override
    public String toString() {
        return "BillingQuery{" +
                "id=" + id +
                ", billingDetailid=" + billingDetailid +
                ", fpdm='" + fpdm + '\'' +
                ", fphm='" + fphm + '\'' +
                ", fpzt='" + fpzt + '\'' +
                ", scbz='" + scbz + '\'' +
                ", kprq='" + kprq + '\'' +
                ", jqbh='" + jqbh + '\'' +
                ", skm='" + skm + '\'' +
                ", jym='" + jym + '\'' +
                ", xhdwsbh='" + xhdwsbh + '\'' +
                ", xhdwmc='" + xhdwmc + '\'' +
                ", xhdwdzdh='" + xhdwdzdh + '\'' +
                ", xhdwyhzh='" + xhdwyhzh + '\'' +
                ", ghdwsbh='" + ghdwsbh + '\'' +
                ", ghdwmc='" + ghdwmc + '\'' +
                ", ghdwdzdh='" + ghdwdzdh + '\'' +
                ", ghdwyhzh='" + ghdwyhzh + '\'' +
                ", bmbbbh='" + bmbbbh + '\'' +
                ", zsfs='" + zsfs + '\'' +
                ", zhsl='" + zhsl + '\'' +
                ", hjje='" + hjje + '\'' +
                ", hjse='" + hjse + '\'' +
                ", jshj='" + jshj + '\'' +
                ", bz='" + bz + '\'' +
                ", skr='" + skr + '\'' +
                ", fhr='" + fhr + '\'' +
                ", kpr='" + kpr + '\'' +
                ", jmbbh='" + jmbbh + '\'' +
                ", zyspmc='" + zyspmc + '\'' +
                ", spsm='" + spsm + '\'' +
                ", qdbz='" + qdbz + '\'' +
                ", ssyf='" + ssyf + '\'' +
                ", kpjh='" + kpjh + '\'' +
                ", tzdbh='" + tzdbh + '\'' +
                ", yfpdm='" + yfpdm + '\'' +
                ", yfphm='" + yfphm + '\'' +
                ", zfrq='" + zfrq + '\'' +
                ", zfr='" + zfr + '\'' +
                ", qmcs='" + qmcs + '\'' +
                ", qmz='" + qmz + '\'' +
                ", ykfsje='" + ykfsje + '\'' +
                ", yqjg='" + yqjg + '\'' +
                ", ewm='" + ewm + '\'' +
                ", kpzdbs='" + kpzdbs + '\'' +
                ", fplxdm='" + fplxdm + '\'' +
                ", status='" + status + '\'' +
                ", ident='" + ident + '\'' +
                ", invoiceType='" + invoiceType + '\'' +
                ", zfbz='" + zfbz + '\'' +
                ", proConstruUnitName='" + proConstruUnitName + '\'' +
                ", proName='" + proName + '\'' +
                '}';
    }
}
