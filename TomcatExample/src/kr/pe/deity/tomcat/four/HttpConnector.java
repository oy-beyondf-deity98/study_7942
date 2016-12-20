package kr.pe.deity.tomcat.four;

public class HttpConnector implements Runnable{

	@Override
	public void run() {
		System.out.println("음... 이건 생성만해도 실행하는 것일까?");
		
	}
	
	public void start(){
		Thread thread = new Thread(this);
	    thread.start();
	}

}
