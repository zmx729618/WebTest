package xml.test;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class MyXStreamDateConverter implements Converter {
	

	
	/**
	 * 实现改方法，判断要转换的类型
	 */
	@Override
	public boolean canConvert(Class clazz) {
		
		return Date.class.isAssignableFrom(clazz);   
	}

	@Override
	public void marshal(Object value, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		writer.setValue(dateFormat.format(value));

	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			return dateFormat.parseObject(reader.getValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
