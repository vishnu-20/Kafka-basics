package com.kafka.learnings.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	// create a new topic
//	@Bean
//	public NewTopic newTopic() {
//
//		return TopicBuilder.name("demoTopic").build();
//
//	}
	@Bean
	public NewTopic newTopicForJson() {
		
		return TopicBuilder.name("jsonTopic").build();
		
	}
}