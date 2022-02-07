package jp.co.sample.form;

/**
 * @author 土田真丸
 *
 */
public class InsertAdministratorForm {
	//** 名前*/
	private String name;
	//** メールアドレス*/
	private String mailAddress;
	//** パスワード*/
	private String password;
	public String getName() {
		return name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdministratorService [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password + "]";
	}
}
