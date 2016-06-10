import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class Launcher {
	
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		ServletHandler handler = new ServletHandler();
		server.setHandler(handler);
		handler.addServletWithMapping("Map", "/");
		server.start();
		findLocalIp();
		server.join();
	}
	
	public static void findLocalIp() throws SocketException {
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while (interfaces.hasMoreElements())
		{
		    NetworkInterface current = interfaces.nextElement();
		    if (!current.isUp() || current.isLoopback() || current.isVirtual()) continue;
		    Enumeration<InetAddress> addresses = current.getInetAddresses();
		    while (addresses.hasMoreElements())
			{
		        InetAddress current_addr = addresses.nextElement();
		        if (current_addr.isLoopbackAddress()) continue;
				if (current_addr instanceof Inet4Address)
				{
  					System.out.println("IPv4: "+current_addr.getHostAddress() + ":8080");
				}
		    }
		}
	}
}
