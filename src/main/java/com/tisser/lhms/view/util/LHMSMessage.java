package com.tisser.lhms.view.util;

import javax.swing.JOptionPane;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.util.MessageUtil;

/**
 * 
 * @author ajith
 * @since 8/22/2012
 *
 */

public class LHMSMessage extends MessageUtil {
	
	public LHMSMessage() {
		this(null);
	}
	
	public LHMSMessage(LHMSMdiForm mdiForm) {
		super(mdiForm);
	}

	public static void informationMessage(LHMSMdiForm mdiForm, String message) {
		JOptionPane.showMessageDialog(mdiForm,message);
	}
	
	public static void informationMessage(LHMSMdiForm mdiForm, String message, String title) {
		JOptionPane.showMessageDialog(mdiForm,message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	

}
