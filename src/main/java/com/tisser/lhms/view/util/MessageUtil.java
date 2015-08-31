/**
 * 
 */
package com.tisser.lhms.view.util;

import javax.swing.JOptionPane;

import org.cssa.iface.gui.CssaMDIForm;

/**
 * @author ajith
 *
 */
public class MessageUtil {
	
	private LHMSMdiForm mdiForm;

	/**
	 * @param mdiForm
	 */
	public MessageUtil(LHMSMdiForm mdiForm) {
		this.mdiForm = mdiForm;
	}
	
	/**
	 * method to display error messgae
	 * @param title
	 * @param Messge
	 */
	public void showErrorMessage(String title, String Messge) {
		JOptionPane.showMessageDialog(mdiForm, Messge,
				title, JOptionPane.ERROR_MESSAGE);
	}

}
