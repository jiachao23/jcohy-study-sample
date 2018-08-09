#! /bin/bash
echo "start zkServer..."
for i in 1 2 3
do
ssh node$i "source /etc/profile;/opt/zookeeper/bin/zkServer/sh start"
done