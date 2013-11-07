import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

public class ZoomScroller extends JComponent implements ChangeListener {

	// Properties
	
	private BoundedRangeModel model;
	protected JPanel content = new JPanel();
	
	// ***************************************************
	
	// Constructors
	
	ZoomScroller() {
		init(new DefaultBoundedRangeModel(1, 1, defaultMin, defaultMax));
	}
	
	ZoomScroller(BoundedRangeModel m) {
		init(m);
	}
	
	ZoomScroller(int min, int max) {
		init(new DefaultBoundedRangeModel(1, 1, min, max)); // val, bound, min, max
	}
	
	protected void init(BoundedRangeModel m) {
		model = m;
		model.addChangeListener(this);
		setMinimumSize(minSize);
		setPreferredSize(prefSize);
		updateUI();
	}
	
	public void setModel(BoundedRangeModel m) {
		BoundedRangeModel old = model;
		
		if (m == null) {
			model = new DefaultBoundedRangeModel();
		} else {
			model = m;
		}
		
		firePropertyChange("model", old, model);
	}	
	
	protected BoundedRangeModel getModel() {
		return model;
	}	
	
	// ***************************************************
	
	// UI
	
	
	public void setUI(ZoomScrollerUI ui) {
		super.setUI(ui);
	}
	
	
	
	public void updateUI() {
		setUI((ZoomScrollerUI)UIManager.getUI(this));
		invalidate();
	} 
	public ZoomScrollerUI getUI() {
		return (ZoomScrollerUI)ui;
	}
	
	
	public String getUIClassID() {
		return "ZoomScrollerUI";
	}
	
	// ***************************************************
	
	// Methods
	
	public void resetToDefault() {
		model.setValue(1); // zoom level of 1 is default image size
	}
	
	// ***************************************************
	
	// Accessors
	
	public int getMinimum() { return model.getMinimum(); }
	
	public void setMinimum(int m) {
		int old = model.getMinimum();
		if (m != old) {
			model.setMinimum(m);
			firePropertyChange("minimum", old, m);
		}
	}
	
	public int getMaximum() { return model.getMaximum(); }
	
	public void setMaximum(int m) {
		int old = model.getMaximum();
		if(m != old) {
			model.setMaximum(m);
			firePropertyChange("maximum", old, m);
		}
	}
	
	public int getValue() { return model.getValue(); }
	
	public void setValue(int v) { // will probably be most commonly used
		int old = getValue();
		if (v != old) {
			model.setValue(v);
			firePropertyChange("value", old, v);
		}
		updateUI();
	}
	
	public double getMaxScale() {
		return maxScale;
	}
	
	public double getMinScale() {
		return minScale;
	}
	
	// ***************************************************
	
	// Display Specific Properties
	
	private Dimension minSize = new Dimension(400, 400);
	private Dimension prefSize = new Dimension(650, 650);
	private int defaultMin = -100;
	private int defaultMax = 100;
	private double minScale = 0.25;
	private double maxScale = 4;

	
	public double map(int val, float from1, float to1, double from2, double to2) {
		return (val - from1) / (to1 - from1) * (to2 - from2) + from2;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		repaint();
		
	}
	
	public static void main(String[] args) { }

}
