#!/bin/bash
#description:start lvs server
echo "1" >/proc/sys/net/ipv4/ip_forward
 
WEB1=192.168.56.200
WEB2=192.168.56.201
 
VIP1=192.168.56.90
 
/etc/rc.d/init.d/functions
 
case "$1" in
start)
echo "start LVS of directorServer"
#set the Virtual address and sysctl parameter
/sbin/ifconfig eth1:0 $VIP1 broadcast $VIP1 netmask 255.255.255.255 up
#clear ipvs table
/sbin/ipvsadm -C
 
#set LVS
#web apache or tomcat
/sbin/ipvsadm -A -t $VIP1:80 -s rr
/sbin/ipvsadm -a -t $VIP1:80 -r $WEB1:80  -g
/sbin/ipvsadm -a -t $VIP1:80 -r $WEB2:80  -g
 
#run LVS
/sbin/ipvsadm

;;

stop)
echo "close LVS directorserver"
echo "0" >/proc/sys/net/ipv4/ip_forward

/sbin/ipvsadm -C

/sbin/ipvsadm -Z

;;
*)
echo "usage:$0 {start|stop}"
exit 1
esac
