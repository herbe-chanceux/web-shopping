package huel.bean;

public class Userinfo {
	private Integer id;
	private String username;
	private String password;
	private String sex;
	private String tel;
	private String email;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username2) {
		
		this.username=username2;
	}

	public void setPassword(String password2) {
		
		this.password=password2;
	}
}
