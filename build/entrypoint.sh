#!/bin/bash

# Waiting till the service discovery is up and running
echo "Is service discovery ${IS_SERVICE_DISCOVERY}"

EUREKA_URL="http://service-discovery:8081/eureka"
if [[ "${IS_SERVICE_DISCOVERY}" == "false" ]]; then
  while ! curl --silent -o /dev/null ${EUREKA_URL} ; do
    echo "Waiting for the Eureka to start up (${EUREKA_URL})"
    sleep 2
  done
fi

# Adding Spring's app arguments
OPTIONALS=""

# Adding the service discovery URL
OPTIONALS="${OPTIONALS} --eureka.client.service-url.defaultZone=${EUREKA_URL}"

# Starting the app
echo "The app is starting with the following args: "
echo "${OPTIONALS}"

java -jar /opt/app.jar ${OPTIONALS}