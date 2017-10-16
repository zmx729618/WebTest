package storm.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

public class SuffixBolt extends BaseBasicBolt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileWriter fileWriter = null;

			
    /**
     * 调用一次			
     */
	@SuppressWarnings("rawtypes")
	@Override
	public void prepare(Map stormConf, TopologyContext context) {
		
		super.prepare(stormConf, context);
		
		try {
			fileWriter =  new FileWriter("/home/hadoop/data/storm_"+UUID.randomUUID());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute(Tuple tuple, BasicOutputCollector collector) {
		//获取数据,转换大写
		String upper_word = tuple.getStringByField("upper_word");
		String result = upper_word+"_suffix";
		try {
			fileWriter.append(result);		
			fileWriter.append("/n");
			fileWriter.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		
		
	}

}
