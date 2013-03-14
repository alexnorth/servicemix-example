Tool set used is:
    - Apache ServiceMix (4.4.1-fuse-01-06)
        + patch from "patch" dir, see README.txt there for details and installation instruction.
    - Apache Maven (3.0.4)

TODO - setup stuff ready
------------------
install patch
------------
features:install camel-jetty
--------------
Install activemq web console

    features:install activemq-web-console

http://localhost:8181/activemqweb
------------
The Karaf web console will be used and as this is not installed by default, the feature must be installed:

    features:install webconsole

The web console is now available from:

    http://localhost:8181/system/console
    default username: smx
    default password: smx
---------


Each module has it's own README.txt that contains information about that project and how to use it.

1) Output-One
    Simple bundle project that logs a message when the bundle starts or stops.
    This shows how to make an OSGi bundle and manage it with the Karaf console.

2) Output-Two
    Another simple bundle project that logs a message when the bundle starts or stops
    This shows how to make an OSGi bundle and manage it with the Karaf web console - and it also gives another bundle
    to use for the Output-Feature example.

3) Output-Feature
    Simple feature project that depends on the Output-One and Output-Two bundles.  Shows how to manage features with
    the Karaf console

4) LogExample
    Various level log messages in the Start and Stop bundle activation methods

5) Bundle-Import-Export (and Bundle-Import-Export-Support)
    Example of using Import-package with * and implicitly listing a package, also shows using Export-package where one
    package is kept hidden and one package is made available to other bundles

6) Camel-Route-Spring-Only
    Example of using Camel routes that are configured purely with Spring.
    Note: Camel-Route-Java-Only shows the same routes without any Spring configuration.

7) Camel-Route-Java-Only
    Example of using Camel routes that are written entirely in Java.
    Note: Camel-Route-Spring-Only shows the same routes without any Java code.

8) Webservice-From-WSDL
    Web service production with CXF from an existing WSDL and generating the Java code

9) Webservice-From-Java
    Web service production with CXF from Java and generating the WSDL


?) activemq

?) using properties, eg; in Camel-Route-Spring-Only/src/main/resources/META-INF/spring/configuration.xml (eg: the file locations used for the routes)

?) unit testing (this should be broken down into different areas, eg: osgi bundle, routes, jms, etc)

?) customising the ServiceMix installation/package (overlay)  - add in setup requirements from above

?) packaging (mvn vs file)
