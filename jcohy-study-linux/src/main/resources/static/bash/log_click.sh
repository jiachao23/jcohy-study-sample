#!/bin/bash

#
# ===========================================================================
# 程序名称:     
# 功能描述:     点击流模型数据预处理
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


#点击流pagevies模型预处理程序类名
click_pv_class="cn.itcast.bigdata.hive.mr.ClickStreamThree"
#点击流pagevies模型程序输入目录，即预处理输出结果(valid)目录
log_pre_output=/data/weblog/preprocess/output
#点击流pagevies模型预处理程序输出目录
click_pvout=/data/weblog/preprocess/click_pv_out



#点击流visit模型预处理程序类名
click_visit_class="cn.itcast.bigdata.hive.mr.ClickStreamVisit"


#点击流visit模型预处理程序输入目录，即pagevies模型预处理程序输出目录  $click_pvout

#点击流visit模型预处理程序输出目录
click_vstout=/data/weblog/preprocess/click_visit_out


#获取时间信息
day_01=`date -d'-1 day' +%Y-%m-%d`
syear=`date --date=$day_01 +%Y`
smonth=`date --date=$day_01 +%m`
sday=`date --date=$day_01 +%d`


#读取日志文件的目录，判断是否有当日待处理的目录(如：2016-03-18)
files=`hadoop fs -ls $log_pre_output | grep $day_01 | wc -l`
if [ $files -gt 0 ]; then
#提交mr任务job运行
echo "running..    hadoop jar weblog.jar $click_pv_class $log_pre_output/$day_01 $click_pvout/$day_01"
hadoop jar weblog.jar $click_pv_class $log_pre_output/$day_01 $click_pvout/$day_01
fi

echo "pv处理运行结果： $?"
if [ $? -eq 0 ];then
#提交mr任务job运行
echo "running..    hadoop jar weblog.jar $click_visit_class $click_pvout $day_01 $click_vstout/$day_01"
hadoop jar weblog.jar $click_visit_class $click_pvout/$day_01 $click_vstout/$day_01
fi
