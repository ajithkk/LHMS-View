package com.tisser.lhms.view.toolbar;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
/**
 * 
 * @author ajith
 *
 */

public class LHMSToolBarButton extends JButton {
	
	private static final Insets MARGIN = new Insets(0, 0, 0, 0);
	private static final int BOTTOM = 3;
	private static final int CENTER = 0;
 
	public LHMSToolBarButton(Icon icon, String txt,String toolTip) {
		super(icon);
		setMargin(MARGIN);
		setVerticalTextPosition(BOTTOM);
		setHorizontalTextPosition(CENTER);
		setToolTipText(toolTip);
		Dimension iconSize = new Dimension(25, 25);
		setSize(iconSize);
		setMaximumSize(iconSize);
		setMinimumSize(iconSize);
		setPreferredSize(iconSize);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	}
	public LHMSToolBarButton(Icon icon) {
		this(icon,null,null);
	}
	
	public LHMSToolBarButton(String imageFile) {
		this(new ImageIcon(imageFile));
	}
	
	public LHMSToolBarButton(String imageFile, String txt) {
		this(new ImageIcon(imageFile));
	}
}
