package com.kafka.learnings.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.learnings.payload.User;

@Service
public class KafkaConsumer {

	private static Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

	/*
	 * @KafkaListener(topics = "demoTopic" , groupId = "myGroup") public void
	 * consume(String mesage) { LOG.info("kafka-----consume {}", mesage);
	 * 
	 * }
	 */

	@KafkaListener(topics = "jsonTopic", groupId = "myGroup")
	public void consume(User user) {
		LOG.info("kafka-----consume {}", user.toString());

	}

}
