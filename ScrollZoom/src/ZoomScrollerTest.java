import java.awt.FlowLayout;

import javax.swing.*;


public class ZoomScrollerTest extends JPanel {
	
	public ZoomScrollerTest() {
		setLayout(new FlowLayout());
		ZoomScroller zs = new ZoomScroller();
		add(zs);
	}
	
	public static void main(String[] args) {
		UIManager.put("ZoomScrollerUI", "BasicZoomScrollerUI");
		
		ZoomScrollerTest test = new ZoomScrollerTest();
		
		JFrame frame = new JFrame("ZoomScroller Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(test);
		frame.setSize(700, 700);
		frame.setVisible(true);
	}

}
