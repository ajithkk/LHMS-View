/**
 * 
 */
package com.tisser.lhms.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.util.Util;

import com.tisser.lhms.view.LHMSMdiForm;
import com.tisser.lhms.view.util.LHMSConstants;

/**
 * @author Ajith
 *
 */
public class LHMSMenuController implements ActionListener {

	private LHMSMenuBar menuBar = null;
	private LHMSMdiForm lhmsMdiFrom = null;
	
	public LHMSMenuController(LHMSMdiForm lhmsMdiForm) {
		this.lhmsMdiFrom = lhmsMdiForm;
	}
	public LHMSMenuController() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(LHMSMenuBar.MNU_FILE_NEWCOLLEGE.equals(actionCommand)) {
			exitApplication();
		}
		
	}
	
	public void exitApplication() {
		Util.exitApplicataion();
		
	}
	public void getMenuBar() {
		LHMSMenuBar menuBar = new LHMSMenuBar(this,lhmsMdiFrom);
		menuBar.addMenuBar();
	}
	
	public void displayHelp() {
		ClassLoader loader = this.getClass().getClassLoader();
		URL url = loader.getResource("help" + File.separator + LHMSConstants.HELP_FILE); 
		
	}

}
