package servicemix.example;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutputOne implements BundleActivator {

    Logger logger = LoggerFactory.getLogger(OutputOne.class);

    public void start(BundleContext bundleContext) throws Exception {
        logger.info( "OutputOne shouts \"STARTING!\"" );
    }

    public void stop(BundleContext bundleContext) throws Exception {
        logger.info("OutputOne shouts \"STOP!\"" );
    }
}
