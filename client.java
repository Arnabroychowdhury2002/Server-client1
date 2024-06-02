import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client{

	public static void main(String args[]){
		try{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the port number to connect with server:");
			int port = sc.nextInt();
			//System.out.println("Server is waiting to connect...");
			Socket sok = new Socket("localhost",port);
			if(sok.isConnected()== true){
				System.out.println("Client is ready to connect");
				InputStream inputstream = sok.getInputStream();
				OutputStream outputstream = sok.getOutputStream();
				PrintWriter pr = new PrintWriter(outputstream);
				BufferedReader buf1 = new BufferedReader(new InputStreamReader(System.in));
				BufferedReader buf2 = new BufferedReader(new InputStreamReader(System.in));
				String str1,str2;
				System.out.print("Enter Message:");
				str1 = buf1.readLine();
				pr.println(str1);
				pr.flush();
				System.out.print("Message send successfully!");
				str2 = buf2.readLine();
				System.out.print("Message from server:"+str2);
			}
		}catch(Exception e){
			System.out.println("An error occured:" +e.getMessage());
			}
	}
}