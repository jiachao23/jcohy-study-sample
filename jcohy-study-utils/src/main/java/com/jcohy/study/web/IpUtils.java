package com.jcohy.study.web;

import com.jcohy.study.common.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Copyright  : 2015-2033 Beijing
 * Created by jiac on 2018/3/9 14:52.
 * ClassName  : IpUtils
 * Description  :
 */
public class IpUtils {



    /**
     * 判断是否是ajax请求
     * @param request request
     * @return result
     */
    public static boolean isAjaxRequest(HttpServletRequest request){
        return StringUtils.isNotBlank(request.getHeader("x-requested-with")) && request.getHeader("x-requested-with").equals("XMLHttpRequest");
    }

    /**
     * 获取真实ip
     * @param request request
     * @return result
     */
    public static String getRealIp(HttpServletRequest request) {
        String remoteAddress;
        try {
            remoteAddress = request.getHeader("x-forwarded-for");
            if (StringUtils.isEmpty(remoteAddress) || "unknown".equalsIgnoreCase(remoteAddress)) {
                remoteAddress = request.getHeader("Proxy-Client-IP");
            }

            if (StringUtils.isEmpty(remoteAddress) || remoteAddress.length() == 0 || "unknown".equalsIgnoreCase(remoteAddress)) {
                remoteAddress = request.getHeader("WL-Proxy-Client-IP");
            }

            if (StringUtils.isEmpty(remoteAddress) || "unknown".equalsIgnoreCase(remoteAddress)) {
                remoteAddress = request.getHeader("HTTP_CLIENT_IP");
            }

            if (StringUtils.isEmpty(remoteAddress) || "unknown".equalsIgnoreCase(remoteAddress)) {
                remoteAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
            }

            if (StringUtils.isEmpty(remoteAddress) || "unknown".equalsIgnoreCase(remoteAddress)) {
                remoteAddress = request.getRemoteAddr();
            }
        } catch (Exception var3) {
            remoteAddress = request.getRemoteAddr();
        }

        return remoteAddress;
    }


    /**
     * 获取本机 ip
     * @return 本机IP
     * @throws SocketException  SocketException
     */
    public static String getLocalIp() throws SocketException {
        // 本地IP，如果没有配置外网IP则返回
        String localip = null;
        // 外网IP
        String netip = null;

        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        // 是否找到外网IP
        boolean finded = false;
        while (netInterfaces.hasMoreElements() && !finded) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                ip = address.nextElement();
                // 外网IP
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    netip = ip.getHostAddress();
                    finded = true;
                    break;
                } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    // 内网IP
                    localip = ip.getHostAddress();
                }
            }
        }

        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }
}
