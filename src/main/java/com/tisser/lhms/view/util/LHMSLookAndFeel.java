package com.tisser.lhms.view.util;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class LHMSLookAndFeel {
	
	private String lookAndFeel;
	
	public LHMSLookAndFeel() {
		lookAndFeel = LHMSConstants.SYSYEM;
		setLookAndFeel();
	}
	
	public LHMSLookAndFeel(String lookAndFeel) {
		this.lookAndFeel = lookAndFeel;
		setLookAndFeel();
	}

	/**
	 * @return the lookAndFeel
	 */
	public String getLookAndFeel() {
		return lookAndFeel;
	}

	private void setLookAndFeel() {
		if(LHMSConstants.SYSYEM .equalsIgnoreCase(lookAndFeel)){
			lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		} else if (LHMSConstants.MOTIF.equalsIgnoreCase(lookAndFeel)) {
			lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
		} else if (LHMSConstants.GTK.equalsIgnoreCase(lookAndFeel)) {
			lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
		} else if (LHMSConstants.JAVA.equalsIgnoreCase(lookAndFeel)) {
			lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
		} else if (LHMSConstants.NIMBUS.equalsIgnoreCase(lookAndFeel)) {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            lookAndFeel = info.getClassName();
		            break;
		        }
		    }
		}
		
	}

}
