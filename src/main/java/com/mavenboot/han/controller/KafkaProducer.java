package com.mavenboot.han.controller;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaProducer {

	private Producer<String, String> producer;
	public final static String TOPIC = "linlin";
	
	private KafkaProducer(){
		Properties properties = new Properties();
		// 此处配置的是kafka的端口  
		properties.put("metadata.broker.list", "127.0.0.1:9092");  
		properties.put("zk.connect", "127.0.0.1:2181");
		
		// 配置key的序列化类  
		properties.put("key.serializer.class", "kafka.serializer.StringEncoder");
		 // 配置value的序列化类  
		properties.put("serializer.class", "kafka.serializer.StringEncoder");  
		
		properties.put("request.required.acks", "-1");
		
		producer = new Producer<String, String>(new ProducerConfig(properties));
	}
	
	//生产者
	public void produce(){
		 int messageNo = 1000;  
	     final int COUNT = 10000; 
	     while (messageNo < COUNT) {  
	            String key = String.valueOf(messageNo);  
	            String data = "hello kafka message " + key;  
	            producer.send(new KeyedMessage<String, String>(TOPIC, key, data));  
	            System.out.println(data);  
	            messageNo++;  
	        }  
	}
	
	public static void main(String[] args) {
		new KafkaProducer().produce();
	}
}
