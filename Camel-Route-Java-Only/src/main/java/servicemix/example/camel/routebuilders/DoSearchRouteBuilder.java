package servicemix.example.camel.routebuilders;

import org.apache.camel.builder.RouteBuilder;

public class DoSearchRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:search-requests")
                .to("jetty://http://www.google.com/ig/api?stock=NOK")
                .to("file:/tmp/myapp/data/dropsearch-out");
    }
}
