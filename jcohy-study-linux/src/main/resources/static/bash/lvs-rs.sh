#!/bin/sh
#description start realserver
#chkconfig 235 26 26
VIP1=192.168.56.90
/etc/rc.d/init.d/functions
case "$1" in
start)
 
echo "start LVS of realserver"
/sbin/ifconfig lo:0 $VIP1 broadcast $VIP1 netmask 255.255.255.255 up
 
echo "1" >/proc/sys/net/ipv4/conf/lo/arp_ignore
echo "2" >/proc/sys/net/ipv4/conf/lo/arp_announce
echo "1" >/proc/sys/net/ipv4/conf/all/arp_ignore
echo "2" >/proc/sys/net/ipv4/conf/all/arp_announce
;;
stop)
/sbin/ifconfig lo:0 down
echo "close lvs dirctorserver"
echo "0" >/proc/sys/net/ipv4/conf/lo/arp_ignore
echo "0" >/proc/sys/net/ipv4/conf/lo/arp_announce
echo "0" >/proc/sys/net/ipv4/conf/all/arp_ignore
echo "0" >/proc/sys/net/ipv4/conf/all/arp_announce
;;
*)
echo "usage:$0{start|stop}"
exit 1
esac
