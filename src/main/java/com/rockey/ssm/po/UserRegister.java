package main.java.com.rockey.ssm.po;

import javax.validation.constraints.Size;

public class UserRegister extends User {
	
	@Size(min=4,max=16,message="{user.password2.length.wrong}")
	private String password2;

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
}
