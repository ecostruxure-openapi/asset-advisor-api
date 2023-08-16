#!/bin/bash
# 8 for 1.8.0_nn, 9 for 9-ea etc, and "no_java" for undetected
jdk_version() {
  local result
  local java_cmd
  if [[ -n $(type -p java) ]]
  then
    java_cmd=java
  elif [[ (-n "$JAVA_HOME") && (-x "$JAVA_HOME/bin/java") ]]
  then
    java_cmd="$JAVA_HOME/bin/java"
  fi
  local IFS=$'\n'
  # remove \r for Cygwin
  local lines=$("$java_cmd" -Xms32M -Xmx32M -version 2>&1 | tr '\r' '\n')
  if [[ -z $java_cmd ]]
  then
    result=no_java
  else
    for line in $lines; do
      if [[ (-z $result) && ($line = *"version \""*) ]]
      then
        local ver=$(echo $line | sed -e 's/.*version "\(.*\)"\(.*\)/\1/; 1q')
        # on macOS, sed doesn't support '?'
        if [[ $ver = "1."* ]]
        then
          result=$(echo $ver | sed -e 's/1\.\([0-9]*\)\(.*\)/\1/; 1q')
        else
          result=$(echo $ver | sed -e 's/\([0-9]*\)\(.*\)/\1/; 1q')
        fi
      fi
    done
  fi
  echo "$result"
}

v="$(jdk_version)"
echo 'java is present'

export CLASSPATH=target/assetadvisor-se-api-1.0.0.jar
while getopts c:t:b:f:s:a:q: flag
do
  case "${flag}" in
  c) className=${OPTARG};;
  t) token=${OPTARG};;
  b) baseUrl=${OPTARG};;
  f) filePath=${OPTARG};;
  s) siteId=${OPTARG};;
  a) assetId=${OPTARG};;
  q) subscriptionId=${OPTARG};;
  esac
done

if [[ $className != "GetAssetDetails" && $className != "GetAssetsList" && $className != "GetAssetsTreeView" && $className != "GetSiteDetails" && $className != "GetSitesList" && $className != "GetTicketSubscriptionList" &&  $className != "UpdateTicketSubscription"  &&  $className != "DeleteTicketSubscription" && $className != "CreateTicketSubscription" && $className != "GetTicketSubscription" && $className != "GetAssetHealthSubscriptionList" ]] ; then
     echo $className 'Not Found, Please Provide Valid Classname.'
    exit 1
fi
echo "## Running $className...."
shift
echo "## arguments passed."
if [[ $className == "GetSiteDetails" ||  $className == "GetAssetsList"  ||  $className == "GetAssetsTreeView" ]] ; then
     mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl  siteId=$siteId" -Dexec.cleanupDaemonThreads=false
elif [[ $className == "GetAssetDetails" ]] ; then
    mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl siteId=$siteId assetId=$assetId" -Dexec.cleanupDaemonThreads=false
elif [[ $className == "GetTicketSubscriptionList" || $className == "DeleteTicketSubscription" ]] ; then
     mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl subscriptionId=$subscriptionId" -Dexec.cleanupDaemonThreads=false
elif [[ $className == "UpdateTicketSubscription" ]] ; then 
     mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl subscriptionId=$subscriptionId filePath=$filePath" -Dexec.cleanupDaemonThreads=false
elif [[ $className == "CreateTicketSubscription" ]] ; then
    mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl filePath=$filePath" -Dexec.cleanupDaemonThreads=false
else
    mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl" -Dexec.cleanupDaemonThreads=false
fi
