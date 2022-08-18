package com.kafka.learnings.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.learnings.payload.User;

@Service
public class KafkaProducer {

	private static Logger log = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	/*
	 * @Autowired private KafkaTemplate<String, String> kafkaTemplate;
	 */

	/*
	 * public void sendMesssage(String message) {
	 * 
	 * log.info(message); kafkaTemplate.send("demoTopic", message); }
	 */

	public void sendJsonMessage(User user) {

		log.info("----user----{}", user.toString());

		Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "jsonTopic").build();

		kafkaTemplate.send(message);
	}
}
