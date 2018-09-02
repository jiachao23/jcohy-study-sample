import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by jiac on 2018/9/2.
 * ClassName  : PACKAGE_NAME
 * Description  :
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Test
    public void test(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //邮件设置
        simpleMailMessage.setSubject("通知：xxx");
        simpleMailMessage.setText("内容");
        simpleMailMessage.setTo("");
        simpleMailMessage.setFrom("");
        javaMailSender.send(simpleMailMessage);
    }

    @Test
    public void test02() throws Exception {
        //1.创建一个复杂的消息邮件
        MimeMessage message =javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        //邮件设置
        helper.setSubject("通知：xxx");
        helper.setText("内容");
        helper.setTo("");
        helper.setFrom("");
        //上传文件
        helper.addAttachment("1.jpg",new File(""));
        javaMailSender.send(message);
    }
}
