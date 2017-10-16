package zmx.nio.test.myftpnio;

import java.nio.channels.SelectionKey;

public interface NioHandler {
	 void execute(SelectionKey key);  
}
