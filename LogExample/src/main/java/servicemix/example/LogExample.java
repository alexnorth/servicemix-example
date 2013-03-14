package servicemix.example;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogExample implements BundleActivator {

    Logger logger = LoggerFactory.getLogger(LogExample.class);

    public void start(BundleContext bundleContext) throws Exception {
        String bundleName = bundleContext.getBundle().getSymbolicName();
        logger.trace(bundleName +" logging a START message with level: TRACE");
        logger.debug(bundleName +" logging a START message with level: DEBUG");
        logger.info(bundleName +" logging a START message with level: INFO");
        logger.warn(bundleName +" logging a START message with level: WARN");
        logger.error(bundleName +" logging a START message with level: ERROR");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        String bundleName = bundleContext.getBundle().getSymbolicName();
        logger.trace(bundleName +" logging a STOP message with level: TRACE");
        logger.debug(bundleName +" logging a STOP message with level: DEBUG");
        logger.info(bundleName +" logging a STOP message with level: INFO");
        logger.warn(bundleName +" logging a STOP message with level: WARN");
        logger.error(bundleName +" logging a STOP message with level: ERROR");
    }
}
