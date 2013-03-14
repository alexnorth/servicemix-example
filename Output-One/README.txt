Simple bundle project that outputs some text to the console when the bundle starts or stops

To make this bundle available, build it:

    mvn install

To install this bundle into Karaf:

    osgi:install -s mvn:servicemix.example/Output-One/1.0-SNAPSHOT

The -s starts the bundle and you should see a message in the log ($SMX_HOME/data/log/servicemix.log) from the bundle
plus a message to the console from Karaf giving the bundle ID. eg:

    karaf@root> osgi:install -s mvn:servicemix.example/Output-One/1.0-SNAPSHOT
    Bundle ID: 218
    karaf@root>

To see all of the bundles available to Karaf:

    osgi:list

The last entry in the list is the bundle that was just loaded:

    [ 218] [Active     ] [            ] [       ] [   60] Output-One (1.0.0.SNAPSHOT)

The number in the first column is the bundle ID.  This can be used to manage the bundle.  Make a change to the message
from the bundle when it starts by editing the start() method in OutputOne.java

Recompile and make the bundle available in your Maven repository:

    mvn clean install

Now, from the Karaf console update the bundle (replace 218 with whatever your bundle ID is):

    osgi:update 218

This will stop the bundle, update it, and start it again so you should see the relevant messages from the bundle displayed.

The bundle can be stopped manually:

    osgi:stop 218

The bundle can be started manually:

    osgi:start 218
