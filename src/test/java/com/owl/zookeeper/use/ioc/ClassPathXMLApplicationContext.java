package com.owl.zookeeper.use.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghouping on 2018/5/14.
 *
 * @author houping wang
 */
public class ClassPathXMLApplicationContext implements ApplicationContext{

    private File file;

    private Map<String, Object> map = new HashMap<String, Object>();

    public ClassPathXMLApplicationContext(String xml) {
        try{
            URL resource = this.getClass().getClassLoader().getResource(xml);
            if(resource == null) {
                throw new NullPointerException("Url is not exist");
            }
            file = new File(resource.toURI());
            init();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        try {
            SAXReader sAXReader = new SAXReader();
            boolean exists = file.exists();
            Document doc = sAXReader.read(file);
            List list = doc.selectNodes("//bean");
            for(Object e : list) {
                Element e1 = (Element) e;
                String id = e1.attributeValue("id");
                String aClass = e1.attributeValue("class");
                Class<?> aClass1 = Class.forName(aClass);
                Object o = aClass1.newInstance();
                Field[] fields = aClass1.getDeclaredFields();
                //设置属性
                List propertys = e1.elements("property");
                for(Object p : propertys) {
                    Element p1 = (Element) p;
                    for(int i = 0; i < fields.length; i ++) {
                        if(p1.attributeValue("name") != null) {
                            if(fields[i].getName().equals(p1.attributeValue("name"))) {
                                fields[i].setAccessible(true);
                                fields[i].set(o, p1.attributeValue("value"));
                            }
                        }else{
                            fields[i].setAccessible(true);
                            fields[i].set(o, map.get(p1.attributeValue("ref")));
                        }
                    }
                }
                map.put(id, o);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String name) {
        return map.get(name);
    }
}
