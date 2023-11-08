package object;

import java.awt.Color;
import java.awt.Graphics;


import scenes.Play;

public class Point {
	Play playing;
	public int tx , ty,x  ;
	public int r=16 ,c=8;
	
	public Point(Play playing) {
		runner.start();
		// TODO Auto-generated constructor stub
	}
	
		
	public void draw(Graphics g ) {
			
		 g.setColor(Color.RED);
	     g.fillOval(tx * 32 + c , ty*32 + c, r, r);
				
				
	}
	Thread runner = new Thread(new Runnable() {
        public void run() {
            while (true) {
                r--;
                c++;
                if (r == 8) {
                   r = 16;
                   c = 8;
                }
                try {
                    runner.sleep(100);
                } catch (InterruptedException e) {
                }
                x++;
            }
        }
    });
		
	public void setTX(int tx) {
		this.tx= tx;
	}
	
	public void setTY(int ty) {
		this.ty= ty;
	}
		
		
		
}
