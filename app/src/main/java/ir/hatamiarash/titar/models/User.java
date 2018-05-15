package ir.hatamiarash.titar.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class User extends RealmObject {
	@PrimaryKey
	private int id;
	@Required
	private String name;
	private String phone;
	@Required
	private String email;
	@Required
	private String password;
	private int age;
	private String wallet;
	private String birthday;
	private boolean info_confirm;
	private boolean phone_confirm;
	private boolean email_confirm;
	private boolean address_confirm;
	private String id_code;
	private String address;
	private String sex;
	private String role;
	private String grade;
	private String country;
	private String province;
	private String city;
	private String pushe_id;
	private String firebase_id;
	
	public User() {
	
	}
	
	public User(int id,
	            String name,
	            String phone,
	            String email,
	            String password,
	            int age,
	            String wallet,
	            String birthday,
	            boolean info_confirm,
	            boolean phone_confirm,
	            boolean email_confirm,
	            boolean address_confirm,
	            String id_code,
	            String address,
	            String sex,
	            String role,
	            String grade,
	            String country,
	            String province,
	            String city,
	            String pushe_id,
	            String firebase_id) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.age = age;
		this.wallet = wallet;
		this.birthday = birthday;
		this.info_confirm = info_confirm;
		this.phone_confirm = phone_confirm;
		this.email_confirm = email_confirm;
		this.address_confirm = address_confirm;
		this.id_code = id_code;
		this.address = address;
		this.sex = sex;
		this.role = role;
		this.grade = grade;
		this.country = country;
		this.province = province;
		this.city = city;
		this.pushe_id = pushe_id;
		this.firebase_id = firebase_id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setWallet(String wallet) {
		this.wallet = wallet;
	}
	
	public String getWallet() {
		return this.wallet;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getBirthday() {
		return this.birthday;
	}
	
	public void setInfo_confirm(boolean info_confirm) {
		this.info_confirm = info_confirm;
	}
	
	public boolean getInfo_confirm() {
		return this.info_confirm;
	}
	
	public void setPhone_confirm(boolean phone_confirm) {
		this.phone_confirm = phone_confirm;
	}
	
	public boolean getPhone_confirm() {
		return this.phone_confirm;
	}
	
	public void setEmail_confirm(boolean email_confirm) {
		this.email_confirm = email_confirm;
	}
	
	public boolean getEmail_confirm() {
		return this.email_confirm;
	}
	
	public void setAddress_confirm(boolean address_confirm) {
		this.address_confirm = address_confirm;
	}
	
	public boolean getAddress_confirm() {
		return this.address_confirm;
	}
	
	public void setId_code(String id_code) {
		this.id_code = id_code;
	}
	
	public String getId_code() {
		return this.id_code;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getSex() {
		return this.sex;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getGrade() {
		return this.grade;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getProvince() {
		return this.province;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setPushe_id(String pushe_id) {
		this.pushe_id = pushe_id;
	}
	
	public String getPushe_id() {
		return this.pushe_id;
	}
	
	public void setFirebase_id(String firebase_id) {
		this.firebase_id = firebase_id;
	}
	
	public String getFirebase_id() {
		return this.firebase_id;
	}
}
