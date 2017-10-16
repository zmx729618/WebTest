package io.test.nettytest.jbossmarshalling;

import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;

import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

public class MarshallingCodeCFactory {


    /**
     * 创建jboss Marshalling 解码器
     * @return
     */
	public static MarshallingDecoder buildMarshallingDecoder() {
		
		 MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
			
		 MarshallingConfiguration config = new MarshallingConfiguration();
		
		 config.setVersion(5);
		 
		 UnmarshallerProvider provider = new DefaultUnmarshallerProvider(marshallerFactory, config);
		 
		 MarshallingDecoder decoder = new MarshallingDecoder(provider);
		
		
		 return decoder;
	}
	
	
    /**
     * 创建jboss Marshalling 编码器
     * @return
     */
	public static MarshallingEncoder buildMarshallingEncoder() {
		
		 MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
			
		 MarshallingConfiguration config = new MarshallingConfiguration();
		
		 config.setVersion(5);
		 
		 MarshallerProvider provider = new DefaultMarshallerProvider(marshallerFactory, config);
		 
		 MarshallingEncoder encoder = new MarshallingEncoder(provider);
		
		
		 return encoder;
	}
	


}
