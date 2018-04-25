package com.owl.zookeeper.use.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by wanghouping on 2018/4/24.
 *
 * @author houping wang
 */
public class FactoryD {

    public interface Fruit {
        /**
         * 显示信息.
         */
        void showInfo();
    }

    public static class Apple implements Fruit{
        public void showInfo() {
            System.out.println("这是一个苹果");
        }
    }

    public static class Banana implements Fruit{
        public void showInfo() {
            System.out.println("这是一个香蕉");
        }
    }

    public static void main(String[] args) {
        String apple1 = PropertiesOperate.get().getProperty("apple");
        Fruit apple = FruitFactory.getInstance(apple1);
        if(apple != null) {
            apple.showInfo();
        }
    }

    public static class FruitFactory {

        public static Fruit getInstance(String beanName) {
            try {
                return (Fruit)Class.forName(beanName).newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    static class PropertiesOperate{//创建一个配置文件操作类
        private static Properties pro=null;
        private static File file=new File("fruit.properties");//创建一个File对象 地址为：D：/fruit.properties
        static {
            pro=new Properties();
            if(file.exists()){//文件如果存在
                try {
                    pro.loadFromXML(new FileInputStream(file));//加载配置文件
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{//如果不存在
                save();
            }
        }

        public static Properties get() {
            return pro;
        }

        public static void save(){//创建一个新的配置文件
            pro.setProperty("apple", "com.owl.zookeeper.use.reflect.FactoryD$Apple");//添加文件内容
            pro.setProperty("banana", "com.owl.zookeeper.use.reflect.FactoryD$Banana");//添加文件内容
            try {
                pro.storeToXML(new FileOutputStream(file), "Fruit");//把文件保存到指定目录，节点为Fruit
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
