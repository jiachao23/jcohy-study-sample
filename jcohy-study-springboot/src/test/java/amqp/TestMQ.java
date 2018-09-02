package amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiac on 2018/9/2.
 * ClassName  : com.jcohy.study.amqp
 * Description  :
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 单播（点对点）
     */
    @Test
    public void contextLoad(){
        //message需要自己构建一个；定义消息体内容和消息头
        Map<String,Object> map = new HashMap<>();
        map.put("msg","");
        map.put("data","");
//        rabbitTemplate.send("exchange.direct","hello",map);
        //object默认当成消息体，只需要传入要发送的对象，自动化序列发给rabbitmq
        rabbitTemplate.convertAndSend("exchange.direct","hello",map);
    }


    @Test
    protected void receive(){
        //接受消息，如何将数据序列化成Json
        Object o = rabbitTemplate.receiveAndConvert("QueueName");

    }

    @Test
    public void createExchange(){
        //凡是以declare开始的都是创建。
        amqpAdmin.declareExchange(new DirectExchange(""));
    }
}
