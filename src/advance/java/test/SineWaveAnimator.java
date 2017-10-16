package advance.java.test;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class SineWaveAnimator extends JFrame implements Runnable{
	
	private int frame=0;
	
	public SineWaveAnimator() {
		
		this.setTitle("正弦函数动画");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		SineWaveAnimator sineWaveAnimator = new SineWaveAnimator();
		Thread thread =new Thread(sineWaveAnimator);		
		thread.setDaemon(true);
		thread.start();
		
	}

	@Override
	public void run() {
		
		while(true){
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frame++;
		}
		
		
	}

	@Override
	public void paint(Graphics g) {
		
		Rectangle d = this.getBounds();
		
		g.clearRect(0, 0, d.width, d.height);
		
		int h = d.height/2;
		
		for(int x=0; x<=d.width; x++){
			
			int y1= (int)((1.0+Math.sin((x-frame)*0.01))*h);
			int y2= (int)((1.0+Math.sin((x+frame)*0.09))*h);
	        g.drawLine(x, y1, x, y2);
			
		}
		
	}
	
	
	
	
	

}
