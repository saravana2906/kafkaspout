import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.drpc.LinearDRPCTopologyBuilder;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

import com.bolt.OrderCounter;
import com.spout.OrderSpout;



public class OrderConsumer {
	
	
	public static void main(String args[])
	{
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("orderspout",new OrderSpout());
		builder.setBolt("ordercounter", new OrderCounter()).shuffleGrouping("orderspout");
		Config conf = new Config();
		//conf.put("wordsFile", args[0]);
		//conf.setDebug(false);
        //Topology run
		conf.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 1);
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("ordertopology", conf, builder.createTopology());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//cluster.shutdown();
	}
	
}
