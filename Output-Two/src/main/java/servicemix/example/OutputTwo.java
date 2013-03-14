package servicemix.example;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutputTwo implements BundleActivator {

    Logger logger = LoggerFactory.getLogger(OutputTwo.class);

    public void start(BundleContext bundleContext) throws Exception {
        logger.info( "OutputTwo shouts \"START!\"" );
    }

    public void stop(BundleContext bundleContext) throws Exception {
        logger.info( "OutputTwo shouts \"STOP!\"" );
    }
}
