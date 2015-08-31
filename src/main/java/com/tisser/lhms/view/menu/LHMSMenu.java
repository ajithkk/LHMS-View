/**
 * 
 */
package com.tisser.lhms.view.menu;

import java.util.List;
import java.util.Vector;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;

/**
 * @author ajith
 *
 */
public class LHMSMenu extends JMenu {
	
	private String name;
	private Icon iconName;
	private List<?> children;
	private boolean mnuVisible;
	private boolean mnuEnable;

	/**
	 * 
	 */
	public LHMSMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param a
	 */
	public LHMSMenu(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param s
	 * @param b
	 */
	public LHMSMenu(String s, boolean b) {
		super(s, b);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param s
	 */
	public LHMSMenu(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void addMenuItems() {
		if(null != children) {
			for(Object menuItem : children) {
				if(menuItem instanceof LHMSMenuItem) {
					this.add((LHMSMenuItem)menuItem);
				} else if(menuItem instanceof LHMSMenu ) {
					this.add((LHMSMenu)menuItem);
				} else if(menuItem instanceof JCheckBoxMenuItem) {
					this.add((JCheckBoxMenuItem) menuItem);
				} else {
					this.addSeparator();
				}
				
			}
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the iconName
	 */
	public Icon getIconName() {
		return iconName;
	}

	/**
	 * @param iconName the iconName to set
	 */
	public void setIconName(Icon iconName) {
		this.iconName = iconName;
	}

	/**
	 * @return the children
	 */
	public List<?> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<?> children) {
		this.children = children;
		this.removeAll();
		
	}

	/**
	 * @return the mnuVisible
	 */
	public boolean isMnuVisible() {
		return mnuVisible;
	}

	/**
	 * @param mnuVisible the mnuVisible to set
	 */
	public void setMnuVisible(boolean mnuVisible) {
		this.mnuVisible = mnuVisible;
	}

	/**
	 * @return the mnuEnable
	 */
	public boolean isMnuEnable() {
		return mnuEnable;
	}

	/**
	 * @param mnuEnable the mnuEnable to set
	 */
	public void setMnuEnable(boolean mnuEnable) {
		this.mnuEnable = mnuEnable;
	}

}
