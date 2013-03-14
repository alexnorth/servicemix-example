To make this bundle available, build it:

    mvn clean install

Install it to Karaf:

    osgi:install -s mvn:servicemix.example/LogExample/1.0-SNAPSHOT

Set the log level to the most detailed possible, for this class only:

    log:set TRACE servicemix.example.LogExample

Valid log levels are TRACE, DEBUG, INFO, WARN, ERROR

Restart LogExample bundle:

    osgi:list | grep LogExample
    osgi:restart <num>

Log is available from $SMX_HOME/data/log/servicemix.log or the Log Service in the Karaf web console