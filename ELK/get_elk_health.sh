#!/bin/bash
url1='http://10.8.51.1:9200/_cat/health?pretty'

while true;
  do
   #test_curl="$(curl -Is "$url1" | head -n 1)"
    test_curl="$(curl -s XGET "$url1")"
    test_url=$test_curl
    echo $test_curl
  echo ""
  sleep 2
done

