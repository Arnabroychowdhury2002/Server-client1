import java.io.*;
import java.net.*;
class UDPEchoClient{
static String add ="localhost";
public static void main(String args[]){
try(DatagramSocket sok = new DatagramSocket()){
InetAddress na=InetAddress.getByName(add);
byte[] buf = new byte[2048];
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter a msg to send to server or type 'bye' to exit: ");
String userInput;
while((userInput = br.readLine())!=null){
if("bye".equals(userInput)){
break;
}
buf = userInput.getBytes();
DatagramPacket sendpacket= new DatagramPacket(buf, buf.length,na,5555);
sok.send(sendpacket);
System.out.println("Sent message:" +userInput);
DatagramPacket rpkt = new DatagramPacket(buf, buf.length);
sok.receive(rpkt);
String msg = new String(rpkt.getData(), 0, rpkt.getLength());
System.out.println("Received from server "+msg);
}
System.out.println("Closing UDP client ");
}
catch(Exception e){
System.out.println("Error is: "+e);
}
}
}