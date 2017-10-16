package zmx.nio.test.myftpbio;

import java.nio.channels.SelectionKey;

public interface FtpHandler {
	public void execute(SelectionKey key);
}
