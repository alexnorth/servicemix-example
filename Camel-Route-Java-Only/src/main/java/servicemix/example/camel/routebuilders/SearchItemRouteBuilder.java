package servicemix.example.camel.routebuilders;

import org.apache.camel.builder.RouteBuilder;

public class SearchItemRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/tmp/myapp/data/dropsearch")
                .to("jms:search-requests");
    }
}
