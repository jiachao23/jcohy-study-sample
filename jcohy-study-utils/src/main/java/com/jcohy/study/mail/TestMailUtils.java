package com.jcohy.study.mail;


import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.IOException;

public class TestMailUtils {

	public static void main(String[] args) throws IOException, MessagingException {
		// TODO Auto-generated method stub
		Session session = MailUtils.createSession("", "", "");
		Mail mail = new Mail();
		mail.addToAddress("");
		mail.setContent("1111");
		MailUtils.send(session, mail);
	}

}
