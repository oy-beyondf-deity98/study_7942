package kr.pe.deity.tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TestSocket {

	private static Socket socket;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		socket();
	}
	public static void socket() throws IOException, InterruptedException{
		socket = new Socket();
		socket.connect(new InetSocketAddress(InetAddress.getByName("naver.com"), 80));
		
		OutputStream os = socket.getOutputStream();
		boolean autoflush = true;
		PrintWriter out = new PrintWriter(socket.getOutputStream(),autoflush);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		out.println("GET /index.jsp HTTP/1.1");
		out.println("Host: localhost:8080");
		out.println("Connection: Close");
		out.println();
		
		boolean loop = true;
		StringBuffer sb = new StringBuffer(8096);
		while(loop){
			if(in.ready()){
				int i =0;
				while(i!=-1){
					i = in.read();
					sb.append((char)i);
				}
				loop = false;
			}
			Thread.currentThread().sleep(50);
			
		}
		
		System.out.println(sb.toString());
		socket.close();
	    
	}
}
