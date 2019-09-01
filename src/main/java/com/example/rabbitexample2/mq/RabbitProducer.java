package com.example.rabbitexample2.mq;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * @author tang
 * @Description TO DO
 * @create 2019-08-31-10:54
 **/
@Component
public class RabbitProducer {
	@Autowired
	AmqpTemplate amqpTemplate;

	public void sendMessage(Object object) {
		try {
			Message message= MessageBuilder.withBody(JSON.toJSONString(object).getBytes("UTF-8"))
					.setContentType(MessageProperties.CONTENT_TYPE_JSON)
					.setContentEncoding("UTF-8")
					.setMessageId(UUID.randomUUID().toString()).build();
			// 指定exchange name 为x.test0831,路由键为 rk.test
			amqpTemplate.send("x.test0831","rk.test",message);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
