Demonstration of using the Import-package and Export-package OSGi manifest headers.

This bundle contains 2 packages, one that we want to be public and one that we don't want to be public:
    servicemix.example.api (this should be public)
    servicemix.example.implementation (this shouldn't be public)

So only the api package is added to the Export-package header.

We can use the * (asterisk) in the Import-package header to tell the Bnd tool to include any packages that it can find
that are being used by this bundle.  In some cases (see http://fusesource.com/docs/esbent/7.0/esb_dependencies/ImportExport-BundleTypes.html)
it isn't possible for the Bnd tool to work these out.  This is demonstrated here by using reflection to load the
"Reflected" class from the Bundle-Import-Export-Support bundle in the servicemix.example.support package.  So this
package needs to be explicitly added to the Import-package header to allow this bundle to use it.

To make this bundle available, build it:

    mvn clean install

Install it to Karaf (make sure that Bundle-Import-Export-Support is available first):

    osgi:install -s mvn:servicemix.example/Bundle-Import-Export/1.0-SNAPSHOT
