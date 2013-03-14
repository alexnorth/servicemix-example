Support bundle used with the Bundle-Import-Export example to demonstrate explicitly importing a package.

This bundle contains a package that is exported.  This bundle alone doesn't do or demo anything, it just contains a
class that is used via reflection from another bundle which hides the usage of that class from the Bnd tool which then
means that the Import-package has to be overridden. See the Bundle-Import-Export/README.txt for more info.

To make this bundle available, build it:

    mvn clean install

Install it to Karaf:

    osgi:install -s mvn:servicemix.example/Bundle-Import-Export-Support/1.0-SNAPSHOT
