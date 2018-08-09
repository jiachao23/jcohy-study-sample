#!/bin/bash

#
# ===========================================================================
# 程序名称:     
# 功能描述:     移动文件到预处理工作目录
# 输入参数:     运行日期
# 目标路径:     /data/weblog/preprocess/input
# 数据源  :     /data/weblog/preprocess/output
#   创建人:     任我行
# 创建日期:     2016-12-21
# 版本说明:     v1.0
# 代码审核:     
# 修改人名:
# 修改日期:
# 修改原因:
# 修改列表: 
# ===========================================================================

#set java env
export JAVA_HOME=/home/hadoop/apps/jdk1.7.0_51
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
export PATH=${JAVA_HOME}/bin:$PATH

#set hadoop env
export HADOOP_HOME=/home/hadoop/apps/hadoop-2.6.1
export PATH=${HADOOP_HOME}/bin:${HADOOP_HOME}/sbin:$PATH



#flume采集生成的日志文件存放的目录
log_flume_dir=/data/flumedata/

#预处理程序的工作目录
log_pre_input=/data/weblog/preprocess/input


#获取时间信息
day_01=`date -d'-1 day' +%Y-%m-%d`
syear=`date --date=$day_01 +%Y`
smonth=`date --date=$day_01 +%m`
sday=`date --date=$day_01 +%d`


#读取日志文件的目录，判断是否有需要上传的文件
files=`hadoop fs -ls $log_flume_dir | grep $day_01 | wc -l`
if [ $files -gt 0 ]; then
hadoop fs -mv ${log_flume_dir}/${day_01} ${log_pre_input}
echo "success moved ${log_flume_dir}/${day_01} to ${log_pre_input} ....."
fi
