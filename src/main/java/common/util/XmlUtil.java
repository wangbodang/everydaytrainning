package common.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: XmlUtil  
 * @Description: TODO(xml工具类)  
 * @author 刘阳 
 * @date 2018年5月11日  
 *
 */
public class XmlUtil {
	/**
	 * log
	 *//*
	private final static Logger  LOGGER = LoggerFactory.getLogger(XmlUtil.class);
	
	static {
		//解决jar冲突
		System.setProperty("javax.xml.parsers.DocumentBuilderFactory","com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
	}
	
	*//**
     * XML转对象
     * @param clazz 对象类
     * @param str xml字符串
     * @param <T> T
     * @return
     *//*
    public static <T> T parseFromXml(Class<T> clazz, String xml) {
    	String trim = xml.trim();
    	LOGGER.info("xml转对象开始 clazz={},xml={}",clazz,trim);
        //创建解析XML对象
        XStream xStream = new XStream(new DomDriver());
        xStream.ignoreUnknownElements();
        //处理注解
        xStream.processAnnotations(clazz);
		@SuppressWarnings("unchecked")
        //将XML字符串转为bean对象
        T t = (T)xStream.fromXML(trim);
        LOGGER.info("xml转对象结束 clazz={},xml={}",clazz,trim);
        return t;
    }
    
    *//**
     * 对象转xml
     * @param obj 对象
     * @return
     *//*
    public static String toXml(Object obj) {
    	LOGGER.info("对象转xml开始 obj={}",obj);
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(obj.getClass());
        LOGGER.info("对象转xml结束 obj={}",obj);
        return "<?xml version=\"1.0\" encoding=\"gb2312\"?>\r\n"+xStream.toXML(obj);
    }
*/
	
}
