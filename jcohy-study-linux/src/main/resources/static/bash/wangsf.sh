#!/bin/bash
while true;
do
    A=`ipvsadm -ln | wc -l`
	B=`ps -ef|grep keepalived |wc -l`
if [ $A -eq 3 ];then
                echo 'restart lvs!!!!'
                /usr/local/lvs/lvs-dr.sh start
				 if [ $A -eq 3 ];then
					if [ $B -gt 1 ];then
						   echo 'lvs dead  !!!! kill keepalived'
						   killall keepalived
						   break
					fi
				fi				
fi
if [ $A -eq 6 ];then
					if [ $B -eq 1 ];then
						   echo 'tomcat live  !!!! start keepalived'
						   service keepalived start
					fi
				fi
sleep 3
done
