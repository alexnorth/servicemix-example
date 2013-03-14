package servicemix.example.camel;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jetty.JettyHttpComponent;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.xslt.XsltComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import servicemix.example.camel.routebuilders.DoSearchRouteBuilder;
import servicemix.example.camel.routebuilders.PublishRouteBuilder;
import servicemix.example.camel.routebuilders.SearchItemRouteBuilder;

import javax.jms.ConnectionFactory;

public class Router implements BundleActivator {
    CamelContext camelContext = new DefaultCamelContext();

    public void start(BundleContext bundleContext) throws Exception {
        // add JMS component
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        // add Jetty component
        camelContext.addComponent("jetty", new JettyHttpComponent());

        // add component
        camelContext.addComponent("xslt", new XsltComponent());

        camelContext.addRoutes(new SearchItemRouteBuilder());
        camelContext.addRoutes(new DoSearchRouteBuilder());
        camelContext.addRoutes(new PublishRouteBuilder());
        camelContext.start();
    }

    public void stop(BundleContext bundleContext) throws Exception {
        camelContext.stop();
    }
}
