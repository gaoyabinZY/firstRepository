package com.gyb.jse2test.day1208;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddrTest {

    public static void main(String[] args) throws UnknownHostException {
        //本机
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("主机ip地址--" + address.getHostAddress());
        System.out.println("主机名--" + address.getHostName());

        //外机
        InetAddress address2 = InetAddress.getByAddress(new byte[]{(byte)192,(byte)168,(byte)107,(byte)100});
        System.out.println(address2.getHostAddress());
        System.out.println(address2.getHostName());
    }
}
