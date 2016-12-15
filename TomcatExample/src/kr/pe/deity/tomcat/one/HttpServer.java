package kr.pe.deity.tomcat.one;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import kr.pe.deity.tomcat.one.Request;
import kr.pe.deity.tomcat.one.Response;



public class HttpServer {

	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator +"webroot";
	
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	private boolean shutdown = false;
	
	public static void main(String[] args){
		HttpServer server = new HttpServer();
		System.out.println(WEB_ROOT);
		server.await();
	}

	public void await() {
		ServerSocket serverSocket = null;
		int port = 8080;
		
		try {
			serverSocket = new ServerSocket(port,1,InetAddress.getByName("127.0.0.1"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		while(!shutdown){
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			
			try {
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				
				Request request = new Request(input);
				request.parse();//uri를 분석한다.
				
				Response response = new Response(output);
				response.setRequest(request);
				response.sendStaticResource();//uri가 파일인지 확인후 파일이면 파일을 리턴해준다.
				
				socket.close();
				
				shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			}
		}
		
	}
}
