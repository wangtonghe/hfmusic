package top.wthfeng.po;
/**
 * 用户类
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年11月25日 下午2:56:21
 */
public class User {
	
	private Long id;	
	private String username;
	private String password;
	private String email;
	
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
	@Override
	public String toString() {
		return "["+username+","+email+"]";
	}

}
