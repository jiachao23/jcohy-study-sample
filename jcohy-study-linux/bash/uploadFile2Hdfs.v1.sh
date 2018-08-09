#!/bin/bash


#set java env
export JAVA_HOME=/export/servers/jdk
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
export PATH=${JAVA_HOME}/bin:$PATH

#set hadoop env
export HADOOP_HOME=/export/servers/hadoop
export PATH=${HADOOP_HOME}/bin:${HADOOP_HOME}/sbin:$PATH




#日志文件存放的目录
log_src_dir=/export/software/

#日志文件上传到hdfs的根路径
hdfs_root_dir=/data/clickLog/20151226/


#读取日志文件的目录，判断是否有需要上传的文件

ls $log_src_dir | while read fileName
do
        if [ "hadoop.log1" = "$fileName" ];then
                hadoop fs -put $log_src_dir$fileName $hdfs_root_dir
        fi
done
