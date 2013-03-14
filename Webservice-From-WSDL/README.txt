mvn archetype:create -DarchetypeGroupId=org.apache.servicemix.tooling -DarchetypeArtifactId=servicemix-cxf-wsdl-first-osgi-bundle -DarchetypeVersion=2012.01.0.fuse-7-061 -DgroupId=servicemix.example -DartifactId=Webservice-From-WSDL -Dversion=1.0-SNAPSHOT

If it exists, remove this line from the pom.xml (in the maven-bundle-plugin):

    org.apache.cxf.transport.http_osgi,

Change the address (in beans.xml) to:

    address="http://0.0.0.0:9191/PersonService"

To make this bundle available, build it:

    mvn clean install

Install it to Karaf:

    osgi:install -s mvn:servicemix.example/Webservice-From-WSDL/1.0-SNAPSHOT

Check that the service is running by visiting:

    http://localhost:9191/PersonService?wsdl
