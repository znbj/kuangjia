package com.itheima.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BeanFactory {
    private static Map<String, Object> map = new HashMap<String, Object>();
    static {
        SAXReader sax = new SAXReader();
        InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
        try {
            Document doc = sax.read(inputStream);
            Element rootElement = doc.getRootElement();
            List<Element> bean = rootElement.elements("bean");
            for (Element element : bean) {
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                Class<?> clazz = Class.forName(className);
                Object obj = clazz.newInstance();
                map.put(id, obj);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    public static Object getBean(String id) {
        return map.get(id);
    }


}
