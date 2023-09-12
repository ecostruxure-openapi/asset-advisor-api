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
while getopts c:t:b:f:s:a:q:d:o:l:w:p:u:v: flag
do
  case "${flag}" in
  c) className=${OPTARG};;
  t) token=${OPTARG};;
  b) baseUrl=${OPTARG};;
  f) filePath=${OPTARG};;
  s) siteId=${OPTARG};;
  a) assetId=${OPTARG};;
  q) subscriptionId=${OPTARG};;
  d) ticketId=${OPTARG};;
  o) offset=(${OPTARG});;
  l) limit=(${OPTARG});;
  w) status+=(${OPTARG});;
  p) priority+=(${OPTARG});;
  u) createdFrom=(${OPTARG});;
  v) createdTo=(${OPTARG});;
  esac
done
if [[ $className != "GetAssetDetails" && $className != "GetAssetsList" && $className != "GetAssetsTreeView" && $className != "GetSiteDetails" && $className != "GetSitesList" && $className != "GetTicketSubscriptionList" &&  $className != "UpdateTicketSubscription"  &&  $className != "DeleteTicketSubscription" && $className != "CreateTicketSubscription" && $className != "GetTicketSubscriptionDetails" && $className != "GetAssetHealthSubscriptionList" &&  $className != "GetTicketDetails" &&  $className != "GetTicketsList" &&  $className != "GetAssetsTickets" &&  $className != "CreateAssetHealthSubscription" &&  $className != "GetAssetHealthSubscription" &&  $className != "DeleteAssetHealthSubscription" &&  $className != "UpdateAssetHealthSubscription" &&  $className != "CreateSiteRiskLevelSubscription" &&  $className != "GetSiteRiskLevelSubscriptions" &&  $className != "DeleteSiteRiskLevelSubscription" &&  $className != "UpdateSiteRiskLevelSubscription" &&  $className != "GetSiteRiskLevelSubscriptionDetails"  ]] ; then
     echo $className 'Not Found, Please Provide Valid Classname.'
    exit 1
fi
echo "## Running $className...."
shift
echo "## arguments passed."
if [[ $className == "GetSiteDetails" ||  $className == "GetAssetsList"  ||  $className == "GetAssetsTreeView" ]] ; then
     mvn exec:java -Dexec.mainClass="example.$className" -Dexec.args="token=$token baseUrl=$baseUrl  siteId=$siteId" -Dexec.cleanupDaemonThreads=false
elif [[ $className == "GetAssetDetails" ]] ; then
    mvn exec:java -Dexec.mainClass="example.$className" -Dexec.args="token=$token baseUrl=$baseUrl siteId=$siteId assetId=$assetId" -Dexec.cleanupDaemonThreads=false
elif [[ $className == "GetTicketSubscriptionDetails" || $className == "DeleteTicketSubscription" || $className == "GetAssetHealthSubscription" || $className == "DeleteAssetHealthSubscription" || $className == "GetSiteRiskLevelSubscriptionDetails" || $className == "DeleteSiteRiskLevelSubscription" ]] ; then
     mvn exec:java -Dexec.mainClass="example.$className" -Dexec.args="token=$token baseUrl=$baseUrl subscriptionId=$subscriptionId" -Dexec.cleanupDaemonThreads=false
elif [[ $className == "UpdateTicketSubscription" || $className == "UpdateAssetHealthSubscription" || $className == "UpdateSiteRiskLevelSubscription" ]] ; then 
     mvn exec:java -Dexec.mainClass="example.$className" -Dexec.args="token=$token baseUrl=$baseUrl subscriptionId=$subscriptionId filePath=$filePath" -Dexec.cleanupDaemonThreads=false
elif [[ $className == "CreateTicketSubscription" || $className == "CreateAssetHealthSubscription" || $className == "CreateSiteRiskLevelSubscription" ]] ; then
    mvn exec:java -Dexec.mainClass="example.$className" -Dexec.args="token=$token baseUrl=$baseUrl filePath=$filePath" -Dexec.cleanupDaemonThreads=false
elif [[ $className == "GetTicketDetails" ]] ; then
    mvn exec:java -Dexec.mainClass="example.$className" -Dexec.args="token=$token baseUrl=$baseUrl ticketId=$ticketId" -Dexec.cleanupDaemonThreads=false    
elif [[ $className == "GetAssetsTickets" ]] ; then
    # to map status list
    for status in "${status[@]}"
    do
        statusList+=' status='$status
    done
    mvn exec:java -Dexec.mainClass="example.$className" -Dexec.args="token=$token baseUrl=$baseUrl siteId=$siteId assetId=$assetId offset=$offset limit=$limit $statusList" -Dexec.cleanupDaemonThreads=false
elif [[ $className == "GetTicketsList" ]] ; then
    # to map status list
    for status in "${status[@]}"
    do
        statusList+=' status='$status
    done
    
    # to map priority list
    for priority in "${priority[@]}"
    do
        priorityList+=' priority='$priority
    done
    mvn exec:java -Dexec.mainClass="example.$className" -Dexec.args="token=$token baseUrl=$baseUrl  offset=$offset limit=$limit $statusList $priorityList createdFrom=$createdFrom createdTo=$createdTo" -Dexec.cleanupDaemonThreads=false
else
    mvn exec:java -Dexec.mainClass="example.$className" -Dexec.args="token=$token baseUrl=$baseUrl" -Dexec.cleanupDaemonThreads=false
fi
