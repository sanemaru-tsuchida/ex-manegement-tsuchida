package jp.co.sample.domain;

import java.util.Date;

/**
 * @author 土田真丸
 * 
 *
 */
public class Employee {
	/** ID */
	private Integer id;
	/** 名前 */
	private String name;
	/** 画像 */
	private String image;
	/** 性別 */
	private String gender;
	/** 入社日 */
	private Date hierDate;
	/** メールアドレス */
	private String mailAddress;
	/** 郵便番号 */
	private String zipCode;
	/** 住所 */
	private String address;
	/** 電話番号 */
	private String telephone;
	/** 給料 */
	private Integer salary;
	/** 特性 */
	private String characteristics;
	/** 扶養⼈数　*/
	private Integer dependentsCount;
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getImage() {
		return image;
	}
	public String getGender() {
		return gender;
	}
	public Date getHierDate() {
		return hierDate;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public String getAddress() {
		return address;
	}
	public String getTelephone() {
		return telephone;
	}
	public Integer getSalary() {
		return salary;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public Integer getDependentsCount() {
		return dependentsCount;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setHierDate(Date hierDate) {
		this.hierDate = hierDate;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public void setDependentsCount(Integer dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", image=" + image + ", gender=" + gender + ", hierDate="
				+ hierDate + ", mailAddress=" + mailAddress + ", zipCode=" + zipCode + ", address=" + address
				+ ", telephone=" + telephone + ", salary=" + salary + ", characteristics=" + characteristics
				+ ", dependentsCount=" + dependentsCount + "]";
	}
	
}
