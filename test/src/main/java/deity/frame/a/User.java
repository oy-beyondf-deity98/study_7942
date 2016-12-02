package deity.frame.a;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement(name = "fields")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

	@XmlElement(name = "userId")
	@NotEmpty(message = "아이디를 입력하십시요.")
	private String userId;
	@XmlElement(name = "userNmae")
	@Size(min=2, max=30)
	private String userName;
	@XmlElement(name = "userInfo")
	private String userInfo;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	
	
	
}
