/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanager;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;


/**
 *
 * @author BlackVernon
 */
class IPAddress {
    
    public static String getIP() throws Exception {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()) {
            NetworkInterface networkInterface = interfaces.nextElement();
            // drop inactive
            if (!networkInterface.isUp())
                continue;

            // smth we can explore
            Enumeration<InetAddress> addresses;
            addresses = networkInterface.getInetAddresses();
            while(addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                if(networkInterface.getDisplayName().equalsIgnoreCase("Qualcomm Atheros QCA9377 Wireless Network Adapter #2"))
                        return addr.getHostAddress();
            }
        }
        return "";
    }
}
