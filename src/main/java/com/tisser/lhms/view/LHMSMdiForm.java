package com.tisser.lhms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.Stack;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.tisser.lhms.view.util.ImageUtil;



public class LHMSMdiForm extends LHMSView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane;
	private Icon cssaIcon;
	private JPanel toolBarPanel;
	ImageUtil imageUtil;
	private String lookAndFeel = null;
	JInternalFrame frame;
	private Stack<JInternalFrame> internalFrames;

	/**
	 * Create the frame.
	 */
	public LHMSMdiForm() {
		int inset = 0;
		toolBarPanel = new JPanel();
		desktopPane = new JDesktopPane();
		imageUtil = new ImageUtil();
		internalFrames = new Stack<JInternalFrame>();

		getContentPane().setLayout(new BorderLayout());
		setLookAndFeel(lookAndFeel);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset*2, screenSize.height-50-inset*2);
		setIconImage(imageUtil.getImage("cssa.jpg"));;
		this.setTitle("Interface Administration");
		
		toolBarPanel.setLayout(new BoxLayout(toolBarPanel, BoxLayout.Y_AXIS));
		this.getContentPane().add(BorderLayout.NORTH, toolBarPanel);
		
		
		desktopPane.setBackground(Color.gray);
		desktopPane.putClientProperty("JDesktopPane.dragMode", "outline");
		this.getContentPane().add(BorderLayout.CENTER,desktopPane);
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
	
		LHMSMenuController controller = new LHMSMenuController(this);
		controller.getMenuBar();
		
		LHMSToolBar toolBar = new LHMSToolBar(this);
		toolBar.setAlignmentX(JComponent.LEFT_ALIGNMENT);
		toolBarPanel.add(toolBar,BorderLayout.NORTH);
	}
	
	public void addChild(JInternalFrame frame) {
		Dimension screenSize = this.getContentPane().getSize();
		desktopPane.add(frame);
		frame.setSize(screenSize);
		frame.setVisible(true);
		internalFrames.push(frame);
		frame.addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e){
				closeFrame();
			}
		});
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			new ErrorDialog(e).setVisible(true);
			e.printStackTrace();
		}
	}
	
	public void addChild(JPanel panel, String frameTitle) {
		Dimension screenSize = this.getContentPane().getSize();
	    frame = new JInternalFrame(frameTitle, true, true, true, true);
		frame.add(panel);
		frame.setSize(screenSize);
		desktopPane.add(frame);
		frame.setVisible(true);
		internalFrames.push(frame);
		frame.addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e){
				closeFrame();
			}
		});
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			new ErrorDialog(e).setVisible(true);
			e.printStackTrace();
		}
		
	}
	
	public void addChild(JPanel panel, String frameTitle, Dimension screenSize ) {
	    frame = new JInternalFrame(frameTitle, false, true, false, true);
		frame.add(panel);
		frame.setSize(screenSize);
		desktopPane.add(frame);
		frame.setVisible(true);
		internalFrames.push(frame);
		frame.addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e){
				closeFrame();
			}
		});
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			new ErrorDialog(e).setVisible(true);
			e.printStackTrace();
		}
		
	}
	public void addChild(JTabbedPane tabbedPane, String frameTitle) {
		Dimension screenSize = this.getContentPane().getSize();
	    frame = new JInternalFrame(frameTitle, true, true, true, true);
		frame.add(tabbedPane);
		frame.setSize(screenSize);
		desktopPane.add(frame);
		frame.setVisible(true);
		internalFrames.push(frame);
		frame.addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e){
				closeFrame();
			}
		});
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			new ErrorDialog(e).setVisible(true);
			e.printStackTrace();
		}
		
	}

	/**
	 * @return the cssaIcon
	 */
	public Icon getCssaIcon() {
		return cssaIcon;
	}

	/**
	 * @param cssaIcon the cssaIcon to set
	 */
	public void setCssaIcon(Icon cssaIcon) {
		this.cssaIcon = cssaIcon;
	}
	/**
	 * @return the lookAndFeel
	 */
	public String getLookAndFeel() {
		return lookAndFeel;
	}

	/**
	 * @param lookAndFeel the lookAndFeel to set
	 */
	public void setLookAndFeel(String lookAndFeel) {
		this.lookAndFeel = lookAndFeel;
		if(null == lookAndFeel){
			lookAndFeel = LHMSConstants.SYSYEM;
		}
		try {
			UIManager.setLookAndFeel(new LHMSLookAndFeel(lookAndFeel).getLookAndFeel());
		} catch (ClassNotFoundException e) {
			new ErrorDialog(e).setVisible(true);
			e.printStackTrace();
		} catch (InstantiationException e) {
			new ErrorDialog(e).setVisible(true);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			new ErrorDialog(e).setVisible(true);
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			new ErrorDialog(e).setVisible(true);
			e.printStackTrace();
		}
	}

	/**
	 * @return the frame
	 */
	public JInternalFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JInternalFrame frame) {
		this.frame = frame;
	}
	
	public void closeFrame() {
		if(!internalFrames.empty()) {
			JInternalFrame frame = internalFrames.pop();
			frame.dispose();
		}
	}

	/**
	 * @return the internalFrames
	 */
	public Stack<JInternalFrame> getInternalFrames() {
		return internalFrames;
	}

	/**
	 * @param internalFrames the internalFrames to set
	 */
	public void setInternalFrames(Stack<JInternalFrame> internalFrames) {
		this.internalFrames = internalFrames;
	}

	/**
	 * @return the toolBarPanel
	 */
	public JPanel getToolBarPanel() {
		return toolBarPanel;
	}

	/**
	 * @param toolBarPanel the toolBarPanel to set
	 */
	public void setToolBarPanel(JPanel toolBarPanel) {
		this.toolBarPanel = toolBarPanel;
	}
	
	
	public void addToolBar(LHMSToolBar toolBar) {
		toolBarPanel.add(toolBar);
		toolBar.setAlignmentX(JComponent.LEFT_ALIGNMENT);
		toolBarPanel.revalidate();
		
	}
	
	public void refreshToolBars(Vector toolBars){
        getToolBarPanel().removeAll();
        getToolBarPanel().repaint();
        for(int i=0;i<toolBars.size();i++){
            addToolBar((LHMSToolBar) toolBars.elementAt(i));
        }
    }
	
	public void removeToolBar(LHMSToolBar toolBar) {
		toolBarPanel.remove(toolBar);
		toolBarPanel.revalidate();
	}
	
	
}
