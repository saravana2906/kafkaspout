package com.spout;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import com.bean.Order;

public class OrderSpout extends BaseRichSpout {

	
	Properties props;
	private SpoutOutputCollector collector;
	
	@Override
	public void nextTuple() {
		// TODO Auto-generated method stub
		try(KafkaConsumer<String, Order> consumer =
			    new KafkaConsumer<String, Order>(props))
			{
			
			consumer.subscribe(Collections.singletonList("ordertopic"));
			while (true) {
		        ConsumerRecords<String, Order> messages = consumer.poll(100);
		        for (ConsumerRecord<String, Order> message : messages) {
		          System.out.println("Message received " + message.value().toString());
		          Order ord=message.value();
		          this.collector.emit(new Values(ord.getOrderId()));
		        }
			}
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector arg2) {
		// TODO Auto-generated method stub
		 this.props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "ordergroup");
		props.put("key.deserializer",
		    "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer",
		    "com.consumer.ObjectDeserializer");
		
		this.collector = arg2;
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		// TODO Auto-generated method stub
		
		arg0.declare(new Fields("orderid"));//based on u project

		
	}

}
