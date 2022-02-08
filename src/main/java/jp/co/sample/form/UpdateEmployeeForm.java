package jp.co.sample.form;

/**
 * @author 土田真丸
 *
 */
public class UpdateEmployeeForm {
	/** ID */
	private String id;
	/** 扶養⼈数　*/
	private Integer dependentsCount;
	public String getId() {
		return id;
	}
	public Integer getDependentsCount() {
		return dependentsCount;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDependentsCount(Integer dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}
}
