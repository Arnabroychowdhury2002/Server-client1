import java.io.*;
import java.net.*;
import java.util.*;

public class UDPDateTimeServer{
public static void main(String args[]) throws Exception{
DatagramSocket ss = new DatagramSocket(1234);
while(true){
System.out.println("Server is up....");
byte[] rd = new byte[100];
byte[] sd = new byte[100];
DatagramPacket rp = new DatagramPacket(rd, rd.length);
ss.receive(rp);
InetAddress ip = rp.getAddress();
int port = rp.getPort();
String s = new String(rp.getData());
System.out.println(s);
Date d = new Date();
String time = d + " ";
sd = time.getBytes();
DatagramPacket sp = new DatagramPacket(sd, sd.length, ip, port);
ss.send(sp);
rp = null;
System.out.println("Done!!!");

}
}
}