package com.kafka.learnings.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.learnings.payload.User;
import com.kafka.learnings.producer.KafkaProducer;

@RestController
public class KafkaPublishController {

	private static Logger LOG = LoggerFactory.getLogger(KafkaPublishController.class);

	@Autowired
	private KafkaProducer kafkaProducer;

	/*
	 * @GetMapping("/publish/{message}") public ResponseEntity<String>
	 * publish(@PathVariable String message) { LOG.info("---- entering ---- {}",
	 * message); kafkaProducer.sendMesssage(message); return new
	 * ResponseEntity<String>("done", HttpStatus.OK); }
	 */
	@PostMapping("/publish")
	public ResponseEntity<User> publish(@RequestBody User user) {
		LOG.info("---- entering ---- {}", user.toString());
		kafkaProducer.sendJsonMessage(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
