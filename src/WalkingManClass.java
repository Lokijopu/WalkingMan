import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class WalkingManClass extends JComponent {
	private Ellipse2D.Double head;
	private Rectangle body;
	private Rectangle leftArm;
	private Rectangle rightArm;
	private Rectangle leftLeg;
	private Rectangle rightLeg;
	private ArrayList<Shape> parts;
	private int dx = 0;
	private int dy = 0;
	
	public WalkingManClass() {
		parts = new ArrayList<Shape>();
		head = new Ellipse2D.Double(10,10,10,10);
		parts.add(parts.size(), head);
		body = new Rectangle(11,21,8,20);
		parts.add(parts.size(), body);
		leftArm = new Rectangle(0, 21, 10, 8);
		parts.add(parts.size(), leftArm);
		rightArm = new Rectangle(19, 21, 10, 8);
		parts.add(parts.size(), rightArm);
		leftLeg = new Rectangle(7, 41, 8, 20);
		parts.add(parts.size(), leftLeg);
		rightLeg = new Rectangle(15, 41, 8, 20);
		parts.add(parts.size(), rightLeg);
		setSize(30, 70);

		addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
			        if (e.getKeyCode() == e.VK_UP) {
			            setDy(2);
			            move();
			        } else if (e.getKeyCode() == e.VK_DOWN) {
			        	setDy(-2);
			        	 move();
			        } else if (e.getKeyCode() == e.VK_LEFT) {
			        	setDx(-2);
			        	 move();
			        } else if (e.getKeyCode() == e.VK_RIGHT) {
			        	setDx(2);
			        	 move();
			        }
			    
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == e.VK_UP) {
		            setDy(0);
		        } else if (e.getKeyCode() == e.VK_DOWN) {
		        	setDy(0);
		        } else if (e.getKeyCode() == e.VK_LEFT) {
		        	setDx(0);
		        } else if (e.getKeyCode() == e.VK_RIGHT) {
		        	setDx(0);
		        }
			}

			public void keyTyped(KeyEvent e) {
				
			}
		});
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		for (Shape i: parts) {
			g2.draw(i);
			g2.fill(i);
		}
	}
	
	public void move() {
		setLocation(getX() + dx, getY() + dy);
	}
	public void setDx(int x) {
		dx = x;
	}
	
	public void setDy(int y) {
		dy = y;
	}
	public int getDx() {
		return dx;
	}
	
	public int getDy() {
		return dy;
	}
	
}
