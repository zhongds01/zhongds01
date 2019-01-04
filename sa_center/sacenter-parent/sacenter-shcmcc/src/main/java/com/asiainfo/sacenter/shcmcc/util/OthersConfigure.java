package com.asiainfo.sacenter.shcmcc.util;

import com.ai.sacenter.SFException;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.XmlUtils;
import org.dom4j.Attribute;
import org.dom4j.Element;

import java.util.List;
import java.util.Map;

/**
 * Created by Think on 2017/8/14.
 */
public class OthersConfigure {
    private static Map<String,Map> ConfigMap = new EDU.oswego.cs.dl.util.concurrent.ConcurrentHashMap();

    static{
        try{
            String configXml = JdomUtils.IConfigure.getOthersConfig();
            if(configXml != null && !"".equals(configXml)) {
                initialize(XmlUtils.parseFileXml(configXml));
            }
        }catch (Exception e){
            throw new SFException("IOS0010016", "Fail to Load others configure from file others.xml,check it if nes");
        }
    }

    /**
     *
     * @param configRoot
     */
    public static void initialize(Element configRoot){
        List<Element> Categorys = configRoot.elements("Category");

        for(Element Category : Categorys){
            Attribute CategoryAttr = Category.attribute("name");
            if(CategoryAttr != null) {
                String CategoryName = CategoryAttr.getText();
                if (CategoryName != null && !"".equals(CategoryName)) {

                    Map<String, Map> CategoryMap = new EDU.oswego.cs.dl.util.concurrent.ConcurrentHashMap();

                    List<Element> items = Category.elements("item");
                    for (Element item : items) {
                        Attribute itemAttr = item.attribute("name");
                        if(itemAttr != null){
                            String itemName = itemAttr.getText();
                            if(itemName != null && !"".equals(itemName)){

                                Map ItemMap = new EDU.oswego.cs.dl.util.concurrent.ConcurrentHashMap();;

                                List<Element> values = item.elements();
                                for(Element value : values) {
                                    ItemMap.put(value.getName(), value.getText());
                                }

                                CategoryMap.put(itemName,ItemMap);
                            }
                        }
                    }
                    ConfigMap.put(CategoryName,CategoryMap);
                }
            }
        }
    }


    public static Map getCategory(String name){
        return ConfigMap.get(name);
    }

    public static Map getItem(String Category,String item){
        Map<String,Map> CategoryMap = ConfigMap.get(Category);
        if(CategoryMap != null){
            return CategoryMap.get(item);
        }
        return null;
    }
}
