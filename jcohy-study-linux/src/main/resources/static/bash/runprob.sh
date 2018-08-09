#!/bin/bash
CLASSPATH=`find $HADOOP_HOME/share/hadoop/ -name "*.jar"|xargs|sed "s/ /:/g"`
java -cp `echo $CLASSPATH:../logprob.jar` cn.itcast.bigdata.hdfs.logprob.LogProb hdfs://192.168.33.152:9000 hadoop /weblog/flume-collection
echo $?
