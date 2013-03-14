Example of using Camel routes that are configured purely with Spring

features:install camel-jetty
Install activemq web console

    features:install activemq-web-console

Use the ActiveMQ console ( http://localhost:8181/activemqweb ) to create a queue named "search-requests"

To make this bundle available, build it (this will also create the necessary files in /tmp/myapp):

    mvn clean install

Install it to Karaf:

    osgi:install -s mvn:servicemix.example/Camel-Route-Spring-Only/1.0-SNAPSHOT

Create (or copy) a file in /tmp/myapp/dropsearch to trigger the route.
Output will be put into /tmp/myapp/www
