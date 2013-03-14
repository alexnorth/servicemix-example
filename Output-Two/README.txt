Another simple bundle project that outputs some text to the console when the bundle starts or stops

To make this bundle available, build it:

    mvn install

Use the Karaf web console: http://localhost:8181/system/console (username=smx password=smx) to install the bundle:

    "Bundles" -> "Install/Update..."
    Select the "Start Bundle" checkbox and "Browse..." to the bundle and select it
    Click "Install or Update"

    Click "Refresh Packages" (on Bundle page)
    Sort the list by id, largest first and the most recently installed bundle should be shown

    Click "Log Service" to see the INFO message from OutputTwo

Make a change to the message from the bundle when it starts by editing the start() method in OutputTwo.java

Recompile and make the bundle available in your Maven repository:

    mvn clean install

Now, from the Karaf console update the bundle:

    "Bundles" -> "Install/Update..."
    Select the "Start Bundle" checkbox and "Browse..." to the bundle and select it
    Click "Install or Update"

This will stop the bundle, update it, and start it again so you should see the relevant messages from the bundle
displayed in the log view.

The bundle can be stopped by clicking the Stop sign in the Actions column (on the Bundles page)

The bundle can be started by clicking the Start sign in the Actions column (on the Bundles page)
