import java.net.*;
import java.io.*;
import java.util.Scanner;

public class server{

	public static void main(String args[]){
		try{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the port number to connect:");
			int port = sc.nextInt();
			System.out.println("Server is waiting to connect...");
			ServerSocket sok = new ServerSocket(port);
			Socket socket = sok.accept();
			if(socket.isConnected()== true){
				System.out.println("Server is ready to connect");
				InputStream inputstream = socket.getInputStream();
				OutputStream outputstream = socket.getOutputStream();
				PrintWriter pr = new PrintWriter(outputstream);
				BufferedReader buf = new BufferedReader(new InputStreamReader(inputstream));
				String str = buf.readLine();
				System.out.println("Message Received from client :"+str);
				System.out.println("The Message is forwarded to client :");
				pr.println(str);
				pr.flush();
			}
		}catch(Exception e){
			System.out.println("An error occured:" +e.getMessage());
			}
	}
}