package jp.co.sample.form;

import javax.validation.constraints.NotBlank;

/**
 * @author 土田真丸
 *
 */
public class LoginForm {
	/** メールアドレス*/
	@NotBlank(message = "メールアドレスは必須です。")
	private String mailAddress;
	/** パスワード*/
	@NotBlank(message = "パスワードは必須です。")
	private String password;
	
	public String getMailAddress() {
		return mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
