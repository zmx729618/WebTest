package file.stream.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.Locale;

public class LiveData {
	
	private ByteArrayOutputStream outputStream;

	public void createData(){
		outputStream = new ByteArrayOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		for(int i=0; i<10; i++){
			Trade trade = new Trade(i);
			try {
				dataOutputStream.writeInt(trade.getScriptCode());
				dataOutputStream.write(trade.getTime());
				dataOutputStream.writeDouble(trade.getBid());
				dataOutputStream.writeDouble(trade.getOffer());
				dataOutputStream.writeDouble(trade.getHigh());
				dataOutputStream.writeDouble(trade.getLow());
				dataOutputStream.writeLong(trade.getQuantity());
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
		}
		
		try {
			FileOutputStream fos =  new FileOutputStream("trade.txt");
			outputStream.writeTo(fos);
			fos.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
				
		
	}
	
	
	private void readData(){	
		byte[] timeBuffer = new byte[8];
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.US);
		ByteArrayInputStream InputStream = new ByteArrayInputStream(outputStream.toByteArray());
		
		DataInputStream dataInputStream = new DataInputStream(InputStream);
		for(int i=0; i<10; i++){
			try {
				int scriptCode = dataInputStream.readInt();
				dataInputStream.read(timeBuffer);
				String time = new String(timeBuffer);
				
				double bid = dataInputStream.readDouble();
				double offer = dataInputStream.readDouble();
				double high = dataInputStream.readDouble();
				double low = dataInputStream.readDouble();
				double quantity = dataInputStream.readDouble();
				formatter.format("scriptCode %2d"+"\t time %s"+"\t bid %05.2f"+"\t offer %05.2f"+"\t low %05.2f"+"\t quantity %05.2f",
						          scriptCode,time,bid,offer,high,low,quantity);
				
				System.out.println(sb);
				sb.delete(0, sb.length());
				
				
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		LiveData liveData = new LiveData();
		
		liveData.createData();
		
		liveData.readData();
	}

}
