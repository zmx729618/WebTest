package storm.test;

import java.util.Map;
import java.util.Random;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class RandomSpout extends BaseRichSpout{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3381012965557883592L;

	private SpoutOutputCollector spoutOutputCollector;
	
	String[]  goods = new String[]{"iphone","xiaomi","sumsung","huawei","zhongxing","meizu","moto","simens"} ;
    
	/**
	 * 获取消息发送给下一个组件的方法，会被storm不断循环调用
	 * 从goods数组数据中随机挑一个，封装到tuple中发送出去
	 */
	
	
	@Override
	public void nextTuple() {
		
		//随机取一个
		Random random = new Random();
		String good = goods[random.nextInt(goods.length)];
		
		//封装到tuple中 发送出去
		spoutOutputCollector.emit(new Values(good));
		
		
	}

	/**
	 * 初始化，只调用一次
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void open(Map arg0, TopologyContext context, SpoutOutputCollector collector) {
		
		this.spoutOutputCollector = collector;
	}

	
	/**
	 * 定义tuple的scheme---tuple中数据的属性名
	 */
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		
		declarer.declare(new Fields("src_word"));
	}
	
	

}
