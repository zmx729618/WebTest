package zmx.future.test;

public class FutureData implements Data{
	
	protected RealData realData = null;
	
    protected boolean isReady = false;
    
    public synchronized void setRealData(RealData realData){
    	if(isReady){
    		return;
    	}
    	this.realData = realData;
    	isReady = true;
    	notifyAll(); 
    	
    }

	@Override
	public synchronized String getResult() {
		while(!isReady){
			try{
				wait();    //一直等待，直到RealData被注入
			}catch (Exception e) {
				
			}
		}
		return realData.result;   //由RealData实现
	}

}
