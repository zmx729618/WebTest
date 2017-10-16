package test;

public interface ExpirationListener<T> {
	
	void expired(T expiredObject);

}
