package top.wthfeng.model;

import java.util.Date;

/**
 * 用户类
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年11月25日 下午2:56:21
 */
public class User {
	
	/**
	 * id
	 */
	private Long id;	
	private String username;
	private String password;
	private String email;
	/**
	 * 0为男，1为女
	 */
	private Byte sex;
	private  Byte starNum;
	private String accessToken;
	private String headPortrait;
	private Date lastLoginTime;
	private String phone;
	private String nickName;
	
	public Byte getSex() {
		return sex;
	}
	public void setSex(Byte sex) {
		this.sex = sex;
	}
	public Byte getStarNum() {
		return starNum;
	}
	public void setStarNum(Byte starNum) {
		this.starNum = starNum;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
