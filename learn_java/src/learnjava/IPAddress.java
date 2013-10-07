package learnjava;

import org.testng.annotations.Test;

import java.net.InetAddress;

/**
 * http://www.programmingsimplified.com/java/source-code/java-program-ip-address
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 30/9/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class IPAddress {

    @Test
    public void getIPAddress() throws Exception{
        System.out.println(InetAddress.getLocalHost());
    }
}
