package com.tisser.lhms.view;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public abstract class LHMSView extends JFrame {
	
	protected String title;
	
	public LHMSView() throws HeadlessException {
		super();
	}

	public LHMSView(String title) throws HeadlessException {
		super(title);
		this.title = title;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		super.setTitle(title);
	}

	
	
	
	
	

}
