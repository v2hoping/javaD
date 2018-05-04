package com.owl.zookeeper.use.jmx;

import com.owl.zookeeper.App;
import org.junit.Test;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by wanghouping on 2018/5/2.
 *
 * @author houping wang
 */
public class JmxD {


    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException, IOException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        String domainName = "whp";
        ObjectName helloName = new ObjectName(domainName+":name=HelloWorld");
        // 将new Hello()这个对象注册到MBeanServer上去
        mbs.registerMBean(new Hello(),helloName);
        int rmiPort = 1099;
        LocateRegistry.createRegistry(rmiPort);
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:"+rmiPort+"/"+domainName);
        JMXConnectorServer jmxConnector = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
        jmxConnector.start();
    }
}
