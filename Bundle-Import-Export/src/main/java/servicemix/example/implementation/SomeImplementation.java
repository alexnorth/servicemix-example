package servicemix.example.implementation;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import servicemix.example.api.SomeInterface;

import java.lang.reflect.Method;

public class SomeImplementation implements BundleActivator, SomeInterface {

    Logger logger = LoggerFactory.getLogger(SomeImplementation.class);

    public void doSomething(String append) {
        logger.debug("This is a debug message from "+ append);
        logger.error("This is an error message from "+ append);
        logger.info("This is a info message from "+ append);
        logger.trace("This is a trace message from "+ append);
        logger.warn("This is a warning message from "+ append);
    }

    // this is here to hide the servicemix.example.support package from the bnd tool so that we are forced to explicitly
    // import the package in the manifest for demonstration purposes.
    // For an explanation of the situations when you need to implicitly import, see
    // http://fusesource.com/docs/esbent/7.0/esb_dependencies/ImportExport-BundleTypes.html
    private void reflectionCall() {
        try {
            Class<?> c = Class.forName("servicemix.example.support.Reflected");
            Object t = c.newInstance();
            Method[] allMethods = c.getDeclaredMethods();
            for (Method m : allMethods) {
                String mname = m.getName();
                if (mname.equals("toString")) {
                    String retVal = (String) m.invoke(t, null);
                    logger.info(retVal);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String useThese(int number, String text) {
        // this implementation just adds the number to the end of the text
        return text +" "+ number;
    }

    public void start(BundleContext bundleContext) throws Exception {
        doSomething("START");
        reflectionCall();
    }

    public void stop(BundleContext bundleContext) throws Exception {
        doSomething("STOP");
    }
}
