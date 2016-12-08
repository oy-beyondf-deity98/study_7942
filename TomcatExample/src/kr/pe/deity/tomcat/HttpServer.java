package kr.pe.deity.tomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;



public class HttpServer {

	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator +"webroot";
	
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	private boolean shutdown = false;
	
	public static void main(String[] args){
		HttpServer server = new HttpServer();
		server.await();
	}

	public void await() {
		ServerSocket serverSocket = null;
		int port = 8080;
		
		try {
			serverSocket = new ServerSocket(port,1,InetAddress.getByName("127.0.0.1"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
				request.parse();
				
				Response response = new Response(output);
				response.setRequest(request);
				response.sendStaticResource();
				
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

class Request {

	private InputStream input;
	private String uri;
	
	public Request(InputStream input) {
		this.input = input;
	}	

	public void parse() {
		StringBuffer request = new StringBuffer(2048);
		int i;
		byte[] buffer = new byte[2048];
		
		try {
			i= input.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
			i = -1;
		}
		for(int j=0;j<i;j++){
			request.append(((char)buffer[j]));
		}
		
		uri = parseUri(request.toString());
		
	}
	
	private String parseUri(String requestString){
		int index1,index2;
		index1 = requestString.indexOf(' ');
		if(index1 !=-1){
			index2 = requestString.indexOf(' ',index1+1);
			if(index2 > index1)
				return requestString.substring(index1 +1, index2);
		}
		return null;
	}

	public String getUri() {
		return uri;
	}

}

class Response {

	private static final int BUFFER_SIZE = 1024;
	Request request;
	OutputStream output;
	
	public Response(OutputStream output) {
		this.output = output;
	}

	public void setRequest(Request request) {
		this.request = request;
		
	}

	public void sendStaticResource() {
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			File file = new File(HttpServer.WEB_ROOT,request.getUri());
			if(file.exists()){
				
				fis = new FileInputStream(file);
				int ch = fis.read(bytes,0,BUFFER_SIZE);
				while(ch!=-1){
					output.write(bytes,0,ch);
					ch= fis.read(bytes,0,BUFFER_SIZE);
				}
			}else{
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
						+ "Content-Type: text/html \r\n"
						+ "Content-Length: 23\r\n"
						+ "\r\n"
						+ "<h1>File Not Found</h1>"
						;
				output.write(errorMessage.getBytes());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
		
	}

}
