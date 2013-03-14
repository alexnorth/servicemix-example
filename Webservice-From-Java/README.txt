mvn archetype:create -DarchetypeGroupId=org.apache.servicemix.tooling -DarchetypeArtifactId=servicemix-cxf-code-first-osgi-bundle -DarchetypeVersion=2012.01.0.fuse-7-061 -DgroupId=servicemix.example -DartifactId=Webservice-From-Java -Dversion=1.0-SNAPSHOT


Change the address (in beans.xml) to:

    address="http://0.0.0.0:9191/PersonServiceCF"

Modify the address in Client.java to match what you set the address to in the beans.xml, eg:

    factory.setAddress("http://localhost:9191/PersonServiceCF");

Add the WSDL generation Maven plugin to the pom.xml:

            <plugin>
                <groupId>org.apache.cxf</groupId>
                <artifactId>cxf-java2ws-plugin</artifactId>
                <version>${cxf.version}</version>
                <dependencies>
                    <dependency>
                        <groupId>org.apache.cxf</groupId>
                        <artifactId>cxf-rt-frontend-jaxws</artifactId>
                        <version>${cxf.version}</version>
                    </dependency>
                    <dependency>
                        <groupId>org.apache.cxf</groupId>
                        <artifactId>cxf-rt-frontend-simple</artifactId>
                        <version>${cxf.version}</version>
                    </dependency>
                </dependencies>
                <executions>
                    <execution>
                        <id>process-classes</id>
                        <phase>process-classes</phase>
                        <configuration>
                            <className>servicemix.example.Person</className>
                            <outputFile>${basedir}/src/main/resources/wsdl/PersonService.wsdl</outputFile>
                            <genWsdl>true</genWsdl>
                            <verbose>true</verbose>
                        </configuration>
                        <goals>
                            <goal>java2ws</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

To make this bundle available, build it:

    mvn clean install

Install it to Karaf:

    osgi:install -s mvn:servicemix.example/Webservice-From-Java/1.0-SNAPSHOT

Check that the service is running by visiting:

    http://localhost:9191/PersonServiceCF?wsdl

You can use the test client from the command line:

    mvn test -Pclient

Amongst the output there should be the messages from the client, something like:

    INFO: Creating Service {http://example.servicemix/}PersonService from class servicemix.example.Person
    Invoking getPerson...
    getPerson._getPerson_personId=Guillaume
    getPerson._getPerson_ssn=000-000-0000
    getPerson._getPerson_name=Guillaume

