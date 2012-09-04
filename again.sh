cd ./data/dropsearch
rm -rf .camel
cd ../dropsearch-out
rm -rf .camel
rm nok.*
cd ../www
rm nok.*
cd ..
cd ..
cp ./messages/nok.html ./data/dropsearch
mvn camel:run

