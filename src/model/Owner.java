package model;

public class Owner extends Person{
	
	private String bankAccount;
	private String bankName;

	
	public Owner(model.IdType idType, String id, String name, String phone, model.PhoneType phoneType,
			String bankAccount, String bankName) {
		super(idType, id, name, phone, phoneType);
		this.bankAccount = bankAccount;
		this.bankName = bankName;
	}

	public String getBankAccount() {
		return bankAccount;
	}


	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	
}