package storm.test;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

/**
 * 将收到的原始商品名转换为大写再发送出去
 * @author zhangwenchao
 *
 */
public class UpperBolt extends BaseBasicBolt{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6314865535003131249L;


	/**
	 * 
	 * 每收到一个tuple，会调用一次。
	 * 从tuple中获取原始数据，进行操作
	 */
	@Override
	public void execute(Tuple tuple, BasicOutputCollector collector) {
		//获取数据,转换大写
		String src_word = tuple.getStringByField("src_word");
		String upper_word = src_word.toUpperCase();
		
		//发送
		collector.emit(new Values(upper_word));
		
		
	}

	
	/**
	 * 
	 */
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		
		declarer.declare(new Fields("upper_word"));
	}
	
	

}
