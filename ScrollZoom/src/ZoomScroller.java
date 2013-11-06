import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;


public class ZoomScroller extends JComponent implements ChangeListener {

	// Properties
	
	private BoundedRangeModel model;
	
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
		//updateUI();
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
	
	/*
	public void setUI(ZoomScrollerUI ui) {
		super.setUI(ui);
	}
	
	
	
	public void updateUI() {
		setUI((ZoomScrollerUI)UIManager.getUI(this));
		invalidate();
	} 
	*/
	
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
	}
	
	public double getImageScale() {
		return imageScale;
	}
	
	// ***************************************************
	
	// Display Specific Properties
	
	private Dimension minSize = new Dimension(100, 100);
	private Dimension prefSize = new Dimension(300, 300);
	private int defaultMin = -10;
	private int defaultMax = 10;
	private double imageScale = 1;
	private double minScale = 0.25;
	private double maxScale = 4;

	public void calculateImageScale() {
		double result = 1;
		if(model.getValue() > 1) {
			double ratio = model.getMaximum()/model.getValue();
			result = ratio * maxScale;
		} else if(model.getValue() < 1) {
			double ratio = Math.abs(model.getMinimum()/model.getValue());
			result = ratio * minScale;
		} 
		imageScale = result;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		repaint();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
