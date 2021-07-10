package kr.pe.deity.tomcat.four;

public class BootStrap {

	public static void main(String[] args) {
		HttpConnector connector = new HttpConnector();
		
		connector.start();
		
	}
}
