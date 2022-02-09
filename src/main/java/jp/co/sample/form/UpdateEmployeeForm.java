package jp.co.sample.form;

import javax.validation.constraints.Pattern;


import org.hibernate.validator.constraints.Range;
/**
 * @author 土田真丸
 *
 */
public class UpdateEmployeeForm {
	/** ID */
	private String id;
	/** 扶養⼈数　*/
	@Range(min=1,max=10,message="扶養人数は1人以上10人以下で記載してください。")
	@Pattern(regexp="^[0-9,０-９]+$",message="数値を入力してください")
	private String dependentsCount;
	public String getId() {
		return id;
	}
	public String getDependentsCount() {
		return dependentsCount;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}
}
