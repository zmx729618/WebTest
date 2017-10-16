package mongo.test;

import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		//1、建立一个Mongo的数据库连接对象
		Mongo mongo = new Mongo("127.0.0.1:27017");
		System.out.println(mongo);
		
		//2、查询所有数据库
		List<String> dbName = mongo.getDatabaseNames();
		
		for(String db: dbName){
			System.out.println(db);
		}
		
		//3、创建相关数据库的连接
		DB db = mongo.getDB("tb_foobar");
		
		
		
		//创建一个document
		db.createCollection("java", new BasicDBObject());
		
		//为集合添加一个数据
	    DBObject dbObject = new BasicDBObject();
	    dbObject.put("name", "nercita");
	    dbObject.put("age", 11);
	    
		
		
		
		
		//4、查询数据库所有的集合名字
		Set<String> collections = db.getCollectionNames();
		
		for(String s: collections){
			System.out.println(s);
		}
		
		//5、查询集合中所有数据
		DBCollection persons = db.getCollection("persons");
		
		//游标
		DBCursor dbc = persons.find();
		
		while(dbc.hasNext()){
			DBObject object =  dbc.next();
			//System.out.println(object.get("age"));
			System.out.println(JSON.serialize(object));
		}
		
		//其他操作
		System.out.println(dbc.count());
		
		JSON.serialize(dbc);
	}

}
