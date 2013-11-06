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
	
	int value;
	
	BufferedImage image;
	
	ImageIcon dogicon = new ImageIcon("image1.jpeg");
	
	/*
	Image img = dogicon.getImage();
	BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB); 
	Graphics g = bi.createGraphics();

	g.drawImage(img, 500, 500, 500, 500, null); 
	ImageIcon newIcon = new ImageIcon(bi);
*/
	
	static final int ZOOM_MIN = 0;
	static final int ZOOM_MAX = 500;
	static final int ZOOM_INIT = 250;
	
	
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
				value = ZoomSlider.getValue();
				
				//scale = (value + 4) / 20.0;
				System.out.println(value);
				revalidate();
				repaint();
				
		//==========================================================================================================================
				Image img = dogicon.getImage();
				BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
				BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
				Graphics g = bi.createGraphics();
				boolean myBool = g.drawImage(img, 0, 0, 640 + value, 480 + value, null);
				//System.out.println(myBool);
				ImageIcon newIcon = new ImageIcon(bi);
				thedogPicture = new JLabel("", newIcon, JLabel.CENTER);
				thedogPicture.setHorizontalAlignment(JLabel.CENTER);
				thedogPicture.setAlignmentX(Component.CENTER_ALIGNMENT);
				thedogPicture.setBorder(BorderFactory.createCompoundBorder(
			                BorderFactory.createLoweredBevelBorder(),
			                BorderFactory.createEmptyBorder(10,10,10,10)));
				System.out.println(myBool);
		//==========================================================================================================================		

			}
		});
		Container c = window.getContentPane();
		
		
		// ================= I MOVED THIS SECTION UP THERE BECAUSE I THOUGHT IT WILL KEEP ON REDRAWING AS I CHANGE THE VALUE, BUT NOPE
		Image img = dogicon.getImage();
		BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		boolean myBool = g.drawImage(img, 0, 0, 640 + value, 480 + value, null);
		System.out.println(myBool);
		ImageIcon newIcon = new ImageIcon(bi);
		
		
		
		JPanel PicScreen = new JPanel();
		BorderLayout LAYOUT_STYLE_BORDER = new BorderLayout();
		FlowLayout LAYOUT_STYLE_FLOW = new FlowLayout();
		BoxLayout LAYOUT_STYLE_BOX = new BoxLayout(PicScreen, BoxLayout.PAGE_AXIS);
		c.setLayout(LAYOUT_STYLE_BORDER);
		//PicScreen.setLayout(LAYOUT_STYLE_BOX);
		thedogPicture = new JLabel("", newIcon, JLabel.CENTER);
		thedogPicture.setHorizontalAlignment(JLabel.CENTER);
		thedogPicture.setAlignmentX(Component.CENTER_ALIGNMENT);
		thedogPicture.setBorder(BorderFactory.createCompoundBorder(
	                BorderFactory.createLoweredBevelBorder(),
	                BorderFactory.createEmptyBorder(10,10,10,10)));
		
		// ====================================================================================================================================
		
		
		
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
		
	private void BufferedImage(int width, int height, int typeIntArgb) {
		// TODO Auto-generated method stub
		
	}




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

