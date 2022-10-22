package model;

public abstract class Person{
	
	private IdType IdType;
	private String id;
	private String name;
	private String phone;
	private PhoneType PhoneType;

	public Person(model.IdType idType, String id, String name, String phone, model.PhoneType phoneType) {
		IdType = idType;
		this.id = id;
		this.name = name;
		this.phone = phone;
		PhoneType = phoneType;
	}

	public IdType getIdType() {
		return IdType;
	}

	public void setIdType(IdType idType) {
		IdType = idType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public PhoneType getPhoneType() {
		return PhoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		PhoneType = phoneType;
	}
	
	
}