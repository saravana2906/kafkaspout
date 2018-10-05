package com.consumer;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.bean.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectDeserializer implements Deserializer<Order> {

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(Map arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order deserialize(String arg0, byte[] arg1) {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper = new ObjectMapper();
		   Order ord=null;
		   try {
			   ByteArrayInputStream in = new ByteArrayInputStream(arg1);
			    ObjectInputStream is = new ObjectInputStream(in);
			    return (Order) is.readObject();
			     
		  //  ord = mapper.readValue(arg1, Order.class);
			  // mapper.read
		   } catch (Exception e) {
		     e.printStackTrace();
		   }
		   return ord;
		
	}

}
