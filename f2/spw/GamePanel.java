package f2.spw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel { 
	
	private BufferedImage bi;	
	Graphics2D big;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();

	 public GamePanel() {

		bi = new BufferedImage(500, 600, BufferedImage.TYPE_INT_ARGB); //size BG #1
		big = (Graphics2D) bi.getGraphics();
		big.setBackground(Color.WHITE); // color BG #1
		
	}
	



	public void updateGameUI(GameReporter reporter){
		big.clearRect(0, 0, 500, 600);
		
		big.setColor(Color.BLUE);	//color score #1
		big.drawString(String.format("%08d", reporter.getScore()), 400, 40); //size score #1
		for(Sprite s : sprites){
			s.draw(big);
		}
		
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}

}
