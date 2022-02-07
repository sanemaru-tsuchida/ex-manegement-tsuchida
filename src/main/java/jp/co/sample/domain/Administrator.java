package jp.co.sample.domain;

/**
 * @author 土田真丸
 *
 */
public class Administrator {
	/** ID */
	private Integer id;
	/**　名前*/
	private String name;
	/**メールアドレス*/
	private String email;
	/**パスワード*/
	private String pass;
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + "]";
	}
}
