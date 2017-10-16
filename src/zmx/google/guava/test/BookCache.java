package zmx.google.guava.test;

import java.util.concurrent.TimeUnit;
import java.util.List;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
public class BookCache {
	public static Cache<String, List<Book>> cache = CacheBuilder.newBuilder()
			.expireAfterAccess(8, TimeUnit.SECONDS).maximumSize(10)
			.build();
	
	
	
}
