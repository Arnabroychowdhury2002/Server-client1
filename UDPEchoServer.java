import java.io.*;
import java.net.*;
class UDPEchoServer{
public static void main(String args[]){
try(DatagramSocket sok = new DatagramSocket(5555)){
System.out.println("Server is listening");
byte[] buf = new byte[2048];
while(true){
DatagramPacket packet= new DatagramPacket(buf, buf.length);
sok.receive(packet);
InetAddress ca=packet.getAddress();
int cport = packet.getPort();
int dlength = packet.getLength();
String msg = new String(packet.getData(), 0, dlength);
System.out.println("Received: " +msg);
DatagramPacket echopacket = new DatagramPacket(packet.getData(), dlength, ca, cport);
sok.send(echopacket);
System.out.println("Message echoed: "+msg);
}
}
catch(Exception e){
System.out.println("Error: "+e);
}
}
}