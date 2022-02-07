package jp.co.sample.form;

/**
 * @author 土田真丸
 *
 */
public class LoginForm {
	/** メールアドレス*/
	private String mailAddress;
	/** パスワード*/
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
