#!/bin/bash
#获取绝对路径
readonly INITDIR=$(readlink -m $(dirname $0))
#加载配置文件
source $INITDIR/init.conf
if [ $USER != $INSTALL_USER ]; then
echo "请用"$NSTALL_USER"用户安装！！"
exit
fi
#移除安装过的文件
rm -rf $HBASEHOME
rm -rf $HBASE_INSTALL_DIR/$HBASE_FILE
#拷贝安装文件到安装目录
cp $INITDIR/$HBASE_FILE $HBASE_INSTALL_DIR
#进入安装目录
cd $HBASE_INSTALL_DIR
#解压
tar -zxvf $HBASE_FILE
#重命名
mv $HBASE_INSTALL_DIR/$HBASE_FILE_END $HBASE_HOME
#修改配置文件
cp $INITDIR/$CONF/* $HBASE_HOME/conf
for slave in `cat $INITDIR/$CONF/regionservers`
do
    scp -r $HBASE_HOME $INSTALL_USER@$slave:$HBASE_INSTALL_DIR
done
echo "complete!!!!"

