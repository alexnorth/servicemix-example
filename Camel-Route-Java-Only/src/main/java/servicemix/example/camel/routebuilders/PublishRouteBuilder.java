package servicemix.example.camel.routebuilders;

import org.apache.camel.builder.RouteBuilder;

public class PublishRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/tmp/myapp/data/dropsearch-out")
                .to("xslt://file:/tmp/myapp/resources/SingleQuote.xsl")
                .to("file:/tmp/myapp/data/www");
    }
}
