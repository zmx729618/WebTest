package storm.test;

import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;


public class Topomain {
	
	
	public static void main(String[] args){
		
		TopologyBuilder topologyBuilder = new  TopologyBuilder();
		
		topologyBuilder.setSpout("randomSpout", new RandomSpout(), 4);
		
		topologyBuilder.setBolt("upperBolt", new UpperBolt(),4).shuffleGrouping("randomSpout");
		
		topologyBuilder.setBolt("suffixBolt", new SuffixBolt(),4).shuffleGrouping("upperBolt");
		
		StormTopology stormTopology =  topologyBuilder.createTopology();
		
		
		//设置storm集群
		Config config = new Config();
		config.setNumWorkers(4);   //4个进程
		config.setDebug(true);
		config.setNumAckers(0);
				
		try {
			StormSubmitter.submitTopology("demotopo", config, stormTopology);
		} catch (AlreadyAliveException e) {
			
			e.printStackTrace();
		} catch (InvalidTopologyException e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	

}
