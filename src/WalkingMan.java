
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.Timer;
public class WalkingMan extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public static void main(String[] args) {
	JFrame myFrame = new JFrame("Walking man");
	myFrame.setTitle("Walking man");
	myFrame.setLayout(null);
	myFrame.setBounds(400, 0, 495, 700);
	
	WalkingManClass man = new WalkingManClass();
	myFrame.add(man);
	myFrame.setVisible(true);
	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Timer t1 = new Timer(1000, new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			man.update(null);
		}
	});
	t1.start();
}

}
