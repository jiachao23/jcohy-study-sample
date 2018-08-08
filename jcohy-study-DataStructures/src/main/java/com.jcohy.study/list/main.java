package com.jcohy.study.list;

import java.io.Serializable;

public class main implements Serializable{

	/**
	 * @author jiachao
	 */
	private static final long serialVersionUID = 5371551559742984912L;
	
	private String accountId;
	private String memberId;
	private float balance;
	
	
	public main() {
		super();
	}


	public main(String accountId, String memberId, float balance) {
		super();
		this.accountId = accountId;
		this.memberId = memberId;
		this.balance = balance;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", memberId=" + memberId
				+ ", balance=" + balance + "]";
	}
	
	
}
