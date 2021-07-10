package common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class RestInfo<K,V> {
	private static final String REST_URI_PATH_VAL = "rest_uri_path_att";
	private static final String HTT_BODY = "http-body";
	private static final String HEAD = "body";
	private static final String BODY = "head";
	
	private Map<K,V> uriPathVal;
	private Map<K,V> reqMap;
	private Map<K,V> reqHeadMap;
	private Map<K,V> reqBodyMap;
	private Map<K,V> reqParamMap;
	private Map<K,V> responseMap;
	private Map<K,V> responseBodyMap;
	
	private Map<String, MultipartFile> reqFiles;
	private String hostUrl;

	
	@SuppressWarnings("unused")
	private RestInfo() {}
	
	@SuppressWarnings("unchecked")
	public RestInfo(HttpServletRequest request) {
		
		this.uriPathVal = (Map<K, V>) request.getAttribute(REST_URI_PATH_VAL);
		this.reqMap = (Map<K, V>) request.getAttribute(HTT_BODY);
		
		this.reqParamMap = (Map<K, V>) request.getParameterMap();
	
		this.reqHeadMap = (Map<K, V>) request.getAttribute(HEAD);
		this.reqBodyMap = (Map<K, V>) request.getAttribute(BODY);

		this.responseMap = new HashMap<K,V>();
		this.responseBodyMap = new HashMap<K,V>();
		
		init();
	}

	private void init() {
		if(this.reqHeadMap==null) {
			this.reqHeadMap = new HashMap<K,V>();
		}
	}
	
	public void setDate(K dataName,V dataValue) {
		this.responseBodyMap.put(dataName, dataValue);
	}
	
	public Map<K,V> getResult() {
		System.out.println("restult data :"+this.toString());
//		return JSON.toJSONString(this.responseBodyMap);
		return this.responseBodyMap;
	}
	
	public void multipart(HttpServletRequest request) {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart) {
//			List<Map<String,>>
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			this.reqFiles = multipartRequest.getFileMap();// read only map, not update map;
			
			setServerHostURL(request);
			
		}else {
			throw new NullPointerException("업로드 요청이 아닙니다.");
		}
	}



	private void setServerHostURL(HttpServletRequest request) {
		String sHostUrl = request.getScheme()+"://"+request.getServerName() + 
				(request.getServerPort() >0 ?":"+request.getServerPort():"")+request.getContextPath();
		
		sHostUrl = sHostUrl.endsWith("/")?sHostUrl:sHostUrl+"/";
		
		this.hostUrl = sHostUrl;
		
	}
	
	public final String getHostUrl() {
		return this.hostUrl;
	}
	
	public final Map<String,MultipartFile> getFiles(){
		return (Map<String, MultipartFile>) this.reqFiles;
	}

	public Map<K, V> getUriPathVal() {
		return uriPathVal;
	}

	public void setUriPathVal(Map<K, V> uriPathVal) {
		this.uriPathVal = uriPathVal;
	}

	public Map<K, V> getReqMap() {
		return reqMap;
	}

	public void setReqMap(Map<K, V> reqMap) {
		this.reqMap = reqMap;
	}

	public Map<K, V> getReqHeadMap() {
		return reqHeadMap;
	}

	public void setReqHeadMap(Map<K, V> reqHeadMap) {
		this.reqHeadMap = reqHeadMap;
	}

	public Map<K, V> getReqBodyMap() {
		return reqBodyMap;
	}

	public void setReqBodyMap(Map<K, V> reqBodyMap) {
		this.reqBodyMap = reqBodyMap;
	}

	public Map<K, V> getReqParamMap() {
		return reqParamMap;
	}

	public void setReqParamMap(Map<K, V> reqParamMap) {
		this.reqParamMap = reqParamMap;
	}

	public Map<K, V> getResponseMap() {
		return responseMap;
	}

	public void setResponseMap(Map<K, V> responseMap) {
		this.responseMap = responseMap;
	}

	public Map<K, V> getResponseBodyMap() {
		return responseBodyMap;
	}

	public void setResponseBodyMap(Map<K, V> responseBodyMap) {
		this.responseBodyMap = responseBodyMap;
	}
	
	@Override
	public String toString() {
		return "RestInfo [uriPathVal=" + uriPathVal + ", reqMap=" + reqMap + ", reqHeadMap=" + reqHeadMap
				+ ", reqBodyMap=" + reqBodyMap + ", reqParamMap=" + reqParamMap + ", responseMap=" + responseMap
				+ ", responseBodyMap=" + responseBodyMap + ", reqFiles=" + reqFiles + ", hostUrl=" + hostUrl + "]";
	}	
	
}
