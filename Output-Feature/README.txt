To make the feature available we can add it directly from maven (this does not start the feature):

    features:addurl mvn:servicemix.example/Output-Feature/1.0-SNAPSHOT/xml/features

Installing the feature will also install and start the required bundles.

    features:install output-feature

The feature should show as "installed"

    features:list | grep output

The two bundles in the feature are installed and started now.
Both bundles (Output-One and Output-Two) should show as "Active"

    osgi:list | grep Output

By uninstalling the feature, it  will stop and uninstall any bundles that belong to this feature:

    features:uninstall output-feature

... and the feature should be "uninstalled" ...

    features:list | grep output

... and both bundles are removed:

    osgi:list | grep Output

We can view the urls that the features come from:

    features:listurl

To remove the feature permanently, we need to remove the feature url:

    features:removeurl mvn:servicemix.example/Output-Feature/1.0-SNAPSHOT/xml/features
