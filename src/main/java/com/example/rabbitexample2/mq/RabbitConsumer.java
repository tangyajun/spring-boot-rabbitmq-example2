package com.example.rabbitexample2.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @author tang
 * @Description TO DO
 * @create 2019-08-31-11:20
 **/
@Component
@RabbitListener(queues = "q.test0831")
public class RabbitConsumer {

	@RabbitHandler
	public void receiveMessage(Object object) {
		Message message=(Message)object;
		byte bytes[]=null;
		if (message != null) {
			bytes=message.getBody();
		}
		try {
			String msg=new String(bytes,"UTF-8");
			System.out.println("receive message is ------------------------"+msg);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
