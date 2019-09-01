package com.example.rabbitexample2.web.controller;

import com.example.rabbitexample2.mq.RabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tang
 * @Description TO DO
 * @create 2019-08-31-11:01
 **/
@RestController
@RequestMapping(value = "/messages")
public class MessageController {

	@Autowired
	RabbitProducer rabbitProducer;

	@PostMapping(value = "/send")
	public Map<String,Object> sendMessage(@RequestBody Map<String,Object> paramMap) {
		rabbitProducer.sendMessage(paramMap);
		Map<String,Object> resultMap=new HashMap<>();
		resultMap.put("status","success");
		return resultMap;
	}
}
