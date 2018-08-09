#!/bin/bash
# . /home/anjianbing/soft/functions/wait4FlagFile.sh
# ===========================================================================
# 程序名称:     
# 功能描述:     抽取明细宽表
# 输入参数:     运行日期
# 目标表名:     zs.dw_pvs_hours
# 数据源表:     zs.ods_weblog_detail
#   创建人:     任我行
# 创建日期:     2016-12-21
# 版本说明:     v1.0
# 代码审核:     
# 修改人名:
# 修改日期:
# 修改原因:
# 修改列表: 
# ===========================================================================
### 1.参数加载
exe_hive="/home/hadoop/apps/hive/bin/hive"
if [ $# -eq 1 ]
then
    day_01=`date --date="${1}" +%Y-%m-%d`
else
    day_01=`date -d'-1 day' +%Y-%m-%d`
fi
syear=`date --date=$day_01 +%Y`
smonth=`date --date=$day_01 +%m`
sday=`date --date=$day_01 +%d`

TARGET_DB=zs
TARGET_TABLE=dw_pvs_hours

HQL="
insert into table zs.dw_pvs_hour partition(datestr='$day_01')
select a.month as month,a.day as day,a.hour as hour,count(1) as pvs from zs.ods_weblog_detail a
where a.datestr='$day_01' group by a.month,a.day,a.hour;
"
#执行hql
$exe_hive -e "$HQL"
