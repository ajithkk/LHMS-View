/**
 * 
 */
package com.tisser.lhms.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.JMenuBar;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.college.CollegeInitialViewController;
import org.cssa.iface.gui.database.DatabaseAdministrationController;
import org.cssa.iface.gui.database.DatabaseViewController;
import org.cssa.iface.gui.events.EventsController;
import org.cssa.iface.gui.lookup.CollegeLookupController;
import org.cssa.iface.gui.lookup.ParticipantLookupController;
import org.cssa.iface.gui.lookup.StudentLookupController;
import org.cssa.iface.gui.lookup.WinnerLookupController;
import org.cssa.iface.gui.result.InsertResultController;
import org.cssa.iface.gui.result.ResultInsertController;
import org.cssa.iface.gui.search.SearchTableController;
import org.cssa.iface.gui.timesheet.SelectDateDialogController;
import org.cssa.iface.services.MenuConstants;
import org.cssa.iface.util.TableStoreXML;

import com.tisser.lhms.view.LHMSMdiForm;

/**
 * @author ajith
 *
 */
public class LHMSMenuBar extends JMenuBar implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LHMSMdiForm lhmsMdiForm = null;
	private LHMSMenuController controller = null;
	
	/**
	 * 
	 * @return file menu items 
	 */
	public LHMSMenu  getFileMenu() {
		
		Vector<Object> fileMenu = new Vector<Object>();
		LHMSMenuItem mnuItemNewCollege  = new  LHMSMenuItem(MNU_FILE_NEWCOLLEGE);
		LHMSMenuItem mnuItemNewEvent = new LHMSMenuItem(MNU_FILE_NEWEVENT);
		LHMSMenuItem mnuItemExit = new LHMSMenuItem(MNU_FILE_EXIT);
		LHMSMenuItem mnuItemSeminar = new LHMSMenuItem(MNU_FILE_TIME_SHEET);
		LHMSMenuItem mnuItemAdmin = new LHMSMenuItem(ADMIN);
		
		mnuItemNewCollege.addActionListener(this);
		mnuItemNewCollege.setActionCommand(MNU_FILE_NEWCOLLEGE);
		mnuItemNewEvent.addActionListener(this);
		mnuItemNewEvent.setActionCommand(MNU_FILE_NEWEVENT);
		mnuItemSeminar.addActionListener(this);
		mnuItemSeminar.setActionCommand(MNU_FILE_TIME_SHEET);
		mnuItemExit.addActionListener(this);
		mnuItemExit.setActionCommand(MNU_FILE_EXIT);
		mnuItemAdmin.addActionListener(this);
		mnuItemAdmin.setActionCommand(ADMIN);
		
		fileMenu.addElement(mnuItemNewCollege);
		fileMenu.addElement(mnuItemNewEvent);
		fileMenu.addElement(SEPRATOR);
		fileMenu.addElement(mnuItemSeminar);
		fileMenu.addElement(SEPRATOR);
		fileMenu.addElement(mnuItemAdmin);
		fileMenu.addElement(SEPRATOR);
		fileMenu.addElement(mnuItemExit);
		
		CssaMenu mnuFile = new CssaMenu("File");
		mnuFile.setChildren(fileMenu);
		mnuFile.addMenuItems();
		return mnuFile;
		
	}
	
	public CssaMenu getMaintainMenu() {
		
		Vector<Object> maintainMenu = new Vector<Object>();
		LHMSMenuItem mnuItemCollege = new LHMSMenuItem(MNU_MAINTAIN_COLLEGE);
		mnuItemCollege.addActionListener(this);
		mnuItemCollege.setActionCommand(MNU_MAINTAIN_COLLEGE);
		
		
		LHMSMenuItem mnuItemStudents = new LHMSMenuItem(MNU_MAINTAIN_STUDENT);
		mnuItemStudents.addActionListener(this);
		mnuItemStudents.setActionCommand(MNU_MAINTAIN_STUDENT);
		
		LHMSMenuItem mnuItemGroup = new LHMSMenuItem(MNU_MAINTAIN_GROUP_EVENT);
		mnuItemGroup.addActionListener(this);
		mnuItemGroup.setActionCommand(MNU_MAINTAIN_GROUP_EVENT);
		
		LHMSMenuItem mnuItemResult = new LHMSMenuItem(MNU_MAINTAIN_RESULT);
		mnuItemResult.addActionListener(this);
		mnuItemResult.setActionCommand(MNU_MAINTAIN_RESULT);
		
		LHMSMenuItem mnuItemWinners = new LHMSMenuItem(MNU_MAINTAIN_WINNERS);
		mnuItemWinners.addActionListener(this);
		mnuItemWinners.setActionCommand(MNU_MAINTAIN_WINNERS);
		
		maintainMenu.addElement(mnuItemCollege);
		maintainMenu.addElement(mnuItemStudents);
		maintainMenu.addElement(mnuItemGroup);
		maintainMenu.addElement(SEPRATOR);
		maintainMenu.addElement(mnuItemResult);
		maintainMenu.addElement(SEPRATOR);
		maintainMenu.addElement(mnuItemWinners);
		
		CssaMenu mnuMaintain = new CssaMenu("Maintain");
		mnuMaintain.setChildren(maintainMenu);
		mnuMaintain.addMenuItems();
		return mnuMaintain;
		
	}
	
	public CssaMenu getDatabaseMenu() {
		Vector<Object> databseMenu = new Vector<Object>();
		TableStoreXML tableStoreXML = new TableStoreXML();
		Map<String, String> tableMap = tableStoreXML.getTableStoreMap();
		
		Set<Map.Entry<String, String>> tableSet = tableMap.entrySet();
		for(Map.Entry<String, String> set : tableSet) {
			final String tableName = set.getKey();
			LHMSMenuItem menuItem = new LHMSMenuItem(set.getKey().toLowerCase());
			menuItem.setActionCommand(set.getKey());
			menuItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new DatabaseViewController(tableName, lhmsMdiForm).showDatabaseView();
				}
			});
			databseMenu.addElement(menuItem);
		}
		CssaMenu mnuDatabase = new CssaMenu("Database");
		mnuDatabase.setChildren(databseMenu);
		mnuDatabase.addMenuItems();
		
		return mnuDatabase;
	}
	
	public CssaMenu getReportMenu() {
		Vector<Object> reportMenu = new Vector<Object>();
		
		LHMSMenuItem mnuItemCollege = new LHMSMenuItem(MNU_REPORT_COLLEGE);
		LHMSMenuItem mnuItemStudents = new LHMSMenuItem(MNU_REPORT_STUDENT);
		LHMSMenuItem mnuItemResult = new LHMSMenuItem(MNU_REPORT_RESULT);
		LHMSMenuItem mnuItemEvent = new LHMSMenuItem(MNU_REPORT_EVENT);
		LHMSMenuItem mnuItemWinners = new LHMSMenuItem(MNU_REPORT_WINNERS);
		
		mnuItemCollege.addActionListener(this);
		mnuItemCollege.setActionCommand(ACT_MNU_REPORT_COLLEGE);
		mnuItemStudents.addActionListener(this);
		mnuItemStudents.setActionCommand(ACT_MNU_REPORT_STUDENT);
		mnuItemResult.addActionListener(this);
		mnuItemResult.setActionCommand(ACT_MNU_REPORT_RESULT);
		mnuItemEvent.addActionListener(this);
		mnuItemEvent.setActionCommand(ACT_MNU_REPORT_EVENT);
		mnuItemWinners.addActionListener(this);
		mnuItemWinners.setActionCommand(ACT_MNU_REPORT_WINNERS);
		
		reportMenu.addElement(mnuItemCollege);
		reportMenu.addElement(mnuItemStudents);
		reportMenu.addElement(SEPRATOR);
		reportMenu.addElement(mnuItemEvent);
		reportMenu.addElement(SEPRATOR);
		reportMenu.addElement(mnuItemResult);
		reportMenu.addElement(SEPRATOR);
		reportMenu.addElement(mnuItemWinners);
		
		CssaMenu mnuReport = new CssaMenu(MNU_REPORT);
		mnuReport.setChildren(reportMenu);
		mnuReport.addMenuItems();
		return mnuReport;
		
	}
	
	public CssaMenu getHelpMenu() {
		Vector<Object> helpMenu = new Vector<Object>();
		
		LHMSMenuItem mnuItemHelpContent = new LHMSMenuItem(MNU_HELP_CONTENT);
		LHMSMenuItem mnuItemAbout = new LHMSMenuItem(MNU_HELP_ABOUT);
		
		mnuItemHelpContent.setActionCommand(MNU_HELP_CONTENT);
		mnuItemAbout.setActionCommand(MNU_HELP_ABOUT);
		mnuItemHelpContent.addActionListener(this);
		mnuItemAbout.addActionListener(this);
		
		helpMenu.addElement(mnuItemHelpContent);
		helpMenu.addElement(SEPRATOR);
		helpMenu.addElement(mnuItemAbout);
		
		CssaMenu mnuHelp= new CssaMenu(MNU_HELP);
		mnuHelp.setChildren(helpMenu);
		mnuHelp.addMenuItems();
		return mnuHelp;
	}
	
	public LHMSMenuBar() {
		this.add(getFileMenu());
		this.add(getMaintainMenu());
		this.add(getDatabaseMenu());
		this.add(getReportMenu());
		this.add(getHelpMenu());
		
	}
	
	public LHMSMenuBar(LHMSMdiForm lhmsMdiForm) {
		this();
		this.lhmsMdiForm = lhmsMdiForm;
	}

	public LHMSMenuBar(LHMSMenuController cssaMenuController) {
		this();
		this.controller = cssaMenuController;
	}
	
	public LHMSMenuBar(LHMSMenuController controller, LHMSMdiForm lhmsMdiForm) {
		this();
		this.controller = controller;
		this.lhmsMdiForm = lhmsMdiForm;
	}
	
	public void setController(LHMSMenuController controller) {
		this.controller = controller;
	}

	public void setCssaMDIForm(LHMSMdiForm lhmsMdiForm) {
		this.lhmsMdiForm = lhmsMdiForm;
	}
	
	public LHMSMdiForm  getCssaMDIForm() {
		return lhmsMdiForm;
	}
	
	public void addMenuBar() {
		lhmsMdiForm.setJMenuBar(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(LHMSMenuBar.MNU_FILE_EXIT.equals(actionCommand)) {
			controller.exitApplication();
		} else if (LHMSMenuBar.MNU_FILE_NEWEVENT.equals(actionCommand)) {
			new EventsController(lhmsMdiForm).askEventView();
		} else if (LHMSMenuBar.MNU_HELP_CONTENT.equals(actionCommand)) {
			controller.displayHelp();
		} else if(LHMSMenuBar.MNU_FILE_NEWCOLLEGE.equals(actionCommand)) {
			new CollegeInitialViewController(lhmsMdiForm).askCollegeInitialView();
		} else if(LHMSMenuBar.MNU_MAINTAIN_COLLEGE.equals(actionCommand)) {
			new CollegeLookupController(lhmsMdiForm).askCollegeLookupView();
		} else if (LHMSMenuBar.MNU_MAINTAIN_STUDENT.equals(actionCommand)) {
			new StudentLookupController(lhmsMdiForm).askStudentLookupsereen();
		} else if(LHMSMenuBar.MNU_MAINTAIN_RESULT.equals(actionCommand)) {
			new ResultInsertController(lhmsMdiForm).askResultInsertView();
		} else if(LHMSMenuBar.MNU_MAINTAIN_WINNERS.equals(actionCommand)) {
			new InsertResultController(lhmsMdiForm).askInsertResultView();
		} else if(LHMSMenuBar.ACT_MNU_REPORT_COLLEGE.equals(actionCommand)) {
			new CollegeLookupController(lhmsMdiForm,true).askCollegeLookupView();
		} else if(LHMSMenuBar.ACT_MNU_REPORT_STUDENT.equals(actionCommand)) {
			new StudentLookupController(lhmsMdiForm, false, true).askStudentLookupsereen();
		} else if (LHMSMenuBar.ACT_MNU_REPORT_EVENT.equals(actionCommand)) {
			new SearchTableController(lhmsMdiForm).askSearachTable();
		} else if(LHMSMenuBar.ACT_MNU_REPORT_RESULT.equals(actionCommand)) {
			new ParticipantLookupController(lhmsMdiForm,true).askParticipantsLookupView();
		} else if (LHMSMenuBar.MNU_FILE_TIME_SHEET.equals(actionCommand)) {
			new SelectDateDialogController(lhmsMdiForm).askDateDialog();
		} else if (LHMSMenuBar.MNU_MAINTAIN_GROUP_EVENT.equals(actionCommand)) {
			new StudentLookupController(lhmsMdiForm, true, false).askStudentLookupsereen();
		} else if (ACT_MNU_REPORT_WINNERS.equals(actionCommand)) {
			new WinnerLookupController(lhmsMdiForm, true).askWinnerLookUp();
		} else if (ADMIN.equals(actionCommand)) {
			new DatabaseAdministrationController(lhmsMdiForm).showAdministrationView();
		}
			
	}

	private void exitApp() {
		System.exit(ABORT);
		
	}
	

}
