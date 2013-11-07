import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.plaf.*;

public class BasicZoomScrollerUI extends ZoomScrollerUI implements MouseListener {
	
    protected BufferedImage image;
	protected ZoomScroller zs;
    double scale = 1.0;
    
    protected JPanel imagePanel;
    protected JPanel sliderPanel;
    
    protected JSlider slider;
    
    private int scrollX = 0;
    private int scrollY = 0;
    private int scrollWidth;
    private int scrollHeight = 20;
    
    protected int shuttleX;
    protected int shuttleY = 0;
	private int shuttleWidth = 20;
	private int shuttleHeight = 20;
	
	ImageIcon dogicon = new ImageIcon("image1.jpeg");
	
	private int defaultImgWidth = dogicon.getIconWidth();
	private int defaultImgHeight = dogicon.getIconHeight();
	
	public BasicZoomScrollerUI() {

	}
	
	public static ComponentUI createUI(JComponent c) {
		return new BasicZoomScrollerUI();
	}
	
	
	public void installUI(JComponent c) {
		zs = (ZoomScroller) c;
		zs.addMouseListener(this);
		addComponents(c);
	}
	
	public void addComponents(JComponent c) {
		ZoomScroller zs = (ZoomScroller) c;
		
		slider = new JSlider();
		sliderPanel = new JPanel();
		sliderPanel.add(slider);
		
		imagePanel = new JPanel();
		imagePanel.add(new JLabel("hello world!"));
		
		zs.content.add(imagePanel);
		zs.content.add(sliderPanel);
		
	}
	
	public void uninstallUI(JComponent c) {
		zs = (ZoomScroller) c;
		zs.removeMouseListener(this);
	}
	
	public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        
        // Draw Scroll Bar Base
        g.setColor(Color.lightGray);
        scrollWidth = c.getWidth() - 20;
        scrollWidth = zs.getMaximum() - zs.getMinimum();
        g.fillRect(scrollX, scrollY, scrollWidth, scrollHeight);
        
        // Draw Scroll Bar Shuttle
        g.setColor(Color.DARK_GRAY);
        
        shuttleX = (scrollWidth/2) + zs.getValue();

        g.fillRect(shuttleX - 10, shuttleY, shuttleWidth, shuttleHeight);
        
        // Draw image at appropriate size
		int imgNewWidth;
		int imgNewHeight;
		
		if (zs.getValue() == 1) {
			imgNewWidth = defaultImgWidth;
			imgNewHeight = defaultImgHeight;
		} else if (zs.getValue() > 1) {
			imgNewWidth = (int) (defaultImgWidth * zs.map(zs.getValue(), 0, 100, 1, zs.getMaxScale()));
			imgNewHeight = (int) (defaultImgHeight * zs.map(zs.getValue(), 0, 100, 1, zs.getMaxScale()));
		} else {
			imgNewWidth = (int) (defaultImgWidth * zs.map(zs.getValue(), -100, 0, zs.getMinScale(), 1));
			imgNewHeight = (int) (defaultImgHeight * zs.map(zs.getValue(), -100, 0, zs.getMinScale(), 1));
		}
        
        g.drawImage(dogicon.getImage(), 0, 40, imgNewWidth, imgNewHeight + 40, 0, 0, dogicon.getIconWidth(), dogicon.getIconHeight(), null);
       
	}

	public static void main(String[] args) {}
	

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		// if in bounds of shuttle, start drag
		// update component
		if ((e.getX() < shuttleX + shuttleWidth/2) && (e.getX() >= scrollX)) {
			if ((e.getY() <= shuttleY + shuttleHeight) && (e.getY() > 0) ) {  // if it is less than half of the shuttle, and also within the height
				// on left side of scroll but in scroll, so can move
				zs.setValue(zs.getValue() - 5);
				
			}
		}
		
		if ((e.getX() > shuttleX + shuttleWidth/2) && (e.getX() <= scrollX + scrollWidth)) {
			if ((e.getY() <= shuttleY + shuttleHeight) && (e.getY() > 0) ) {
				zs.setValue(zs.getValue() + 5);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) { }

}
