package com.owl.zookeeper.use.jmx;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wanghouping on 2018/5/3.
 *
 * @author houping wang
 */
public class JmxClient {

    public static void main(String[] args) throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException, InvalidAttributeValueException, IntrospectionException {
        String domainName = "whp";
        int rmiPort = 1099;
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:"+rmiPort+"/"+domainName);
        // 可以类比HelloAgent.java中的那句：
        // JMXConnectorServer jmxConnector = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
        JMXConnector jmxc = JMXConnectorFactory.connect(url);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

        //print domains
        System.out.println("Domains:------------------");
        String domains[] = mbsc.getDomains();
        for(int i=0;i<domains.length;i++){
            System.out.println("\tDomain["+i+"] = "+domains[i]);
        }
        //MBean count
        System.out.println("MBean count = "+mbsc.getMBeanCount());
        //process attribute
        ObjectName mBeanName = new ObjectName(domainName+":name=HelloWorld");
        mbsc.setAttribute(mBeanName, new Attribute("Name","zzh"));//注意这里是Name而不是name
        System.out.println("Name = "+mbsc.getAttribute(mBeanName, "Name"));

        //接下去是执行Hello中的printHello方法，分别通过代理和rmi的方式执行
        //via proxy
        HelloMBean proxy = MBeanServerInvocationHandler.newProxyInstance(mbsc, mBeanName, HelloMBean.class, false);
        proxy.printlnHello();
        proxy.printlnHello("jizhi boy");
        //via rmi
        mbsc.invoke(mBeanName, "printlnHello", null, null);
        mbsc.invoke(mBeanName, "printlnHello", new String[]{"jizhi gril"}, new String[]{String.class.getName()});

        //get mbean information
        MBeanInfo info = mbsc.getMBeanInfo(mBeanName);
        System.out.println("Hello Class: "+info.getClassName());
        for(int i=0;i<info.getAttributes().length;i++){
            System.out.println("Hello Attribute:"+info.getAttributes()[i].getName());
        }
        for(int i=0;i<info.getOperations().length;i++){
            System.out.println("Hello Operation:"+info.getOperations()[i].getName());
        }

        //ObjectName of MBean
        System.out.println("all ObjectName:--------------");
        Set<ObjectInstance> set = mbsc.queryMBeans(null, null);
        for(Iterator<ObjectInstance> it = set.iterator(); it.hasNext();){
            ObjectInstance oi = it.next();
            System.out.println("\t"+oi.getObjectName());
        }
        jmxc.close();
    }
}
