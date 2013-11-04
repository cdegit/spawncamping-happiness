import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.event.*;

public class ZoomScrollerUI extends JPanel implements ActionListener, ChangeListener {
	private static JFrame window = new JFrame("ZoomUI");
	private JLabel smaller = new JLabel("smaller");
	private JLabel bigger = new JLabel("bigger");
	private JLabel thedogPicture;
	
	BufferedImage image;
	
	ImageIcon dogicon = new ImageIcon("image1.jpeg");
	
	static final int ZOOM_MIN = 0;
	static final int ZOOM_MAX = 100;
	static final int ZOOM_INIT = 50;
	
	
	public ZoomScrollerUI() {
		window.setSize(700, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		final JSlider ZoomSlider = new JSlider(JSlider.HORIZONTAL, ZOOM_MIN, ZOOM_MAX, ZOOM_INIT); //do you connect it here?
		
		ZoomSlider.addChangeListener(this);
		ZoomSlider.setMajorTickSpacing(5);
		ZoomSlider.setMinorTickSpacing(5);
		ZoomSlider.setPaintTicks(true);
		ZoomSlider.setSnapToTicks(true);
		ZoomSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = ZoomSlider.getValue();
				//scale = (value + 4) / 20.0;
				revalidate();
				repaint();
			}
		});
		Container c = window.getContentPane();
		
		JPanel PicScreen = new JPanel();
		BorderLayout LAYOUT_STYLE_BORDER = new BorderLayout();
		FlowLayout LAYOUT_STYLE_FLOW = new FlowLayout();
		BoxLayout LAYOUT_STYLE_BOX = new BoxLayout(PicScreen, BoxLayout.PAGE_AXIS);
		c.setLayout(LAYOUT_STYLE_BORDER);
		//PicScreen.setLayout(LAYOUT_STYLE_BOX);
		thedogPicture = new JLabel("", dogicon, JLabel.CENTER);
		thedogPicture.setHorizontalAlignment(JLabel.CENTER);
		thedogPicture.setAlignmentX(Component.CENTER_ALIGNMENT);
		thedogPicture.setBorder(BorderFactory.createCompoundBorder(
	                BorderFactory.createLoweredBevelBorder(),
	                BorderFactory.createEmptyBorder(10,10,10,10)));
		c.add(smaller, BorderLayout.LINE_START);
		c.add(ZoomSlider, BorderLayout.CENTER);
		c.add(bigger, BorderLayout.LINE_END);
		c.add(thedogPicture, BorderLayout.PAGE_END);
		
		System.out.println("bye");
		window.setVisible(true);
	}
		
	


/*
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
	}, ChangeListener {
	 */
		
	private ImageIcon createImageIcon(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}




	private static void showGUI() {
		//JFrame window = new JFrame("ZoomUI");
		//window.setSize(500, 500);
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//window.setVisible(true);
		//System.out.println("bye");
		
	}
	
	
	public static void main(String[] args){
		//showGUI();
		new ZoomScrollerUI();
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}

