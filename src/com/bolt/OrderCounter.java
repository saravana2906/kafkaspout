package com.bolt;

import java.util.HashMap;
import java.util.Map;

import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;

public class OrderCounter extends BaseBasicBolt {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer id;
	String name;
	Map<String, Integer> counters;
	

	@Override
	public void execute(Tuple arg0, BasicOutputCollector arg1) {
		// TODO Auto-generated method stub
		String str = arg0.getString(0);
		/**
		 * If the word dosn't exist in the map we will create
		 * this, if not We will add 1 
		 */
		if(!counters.containsKey(str)){
			counters.put(str, 1);
		}else{
			Integer c = counters.get(str) + 1;
			counters.put(str, c);
		
	}
		System.out.println("Current Order Count : " + counters.size());
	}
	
	@Override
	public void prepare(Map stormConf, TopologyContext context) {
		this.counters = new HashMap<String, Integer>();
		this.name = context.getThisComponentId();
		this.id = context.getThisTaskId();
	}
	
	
	@Override
	public void cleanup() {
		System.out.println("-- Word Counter ["+name+"-"+id+"] --");
		for(Map.Entry<String, Integer> entry : counters.entrySet()){
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
		
		System.out.println("Total Order Count : " + counters.size());
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		// TODO Auto-generated method stub
		
		
	}
	
	
	

}
