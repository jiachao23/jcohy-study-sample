#!/bin/bash

BASE_SERVER=172.16.203.100
yum install -y wget
wget $BASE_SERVER/soft/jdk-7u45-linux-x64.tar.gz
tar -zxvf jdk-7u45-linux-x64.tar.gz -C /usr/local
cat >> /etc/profile << EOF
export JAVA_HOME=/usr/local/jdk1.7.0_45
export PATH=\$PATH:\$JAVA_HOME/bin
EOF

