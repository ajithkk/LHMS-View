package com.tisser.lhms.view.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;

import com.tisser.lhms.view.LHMSMdiForm;
import com.tisser.lhms.view.util.ImageUtil;

public class LHMSToolBar extends JToolBar implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LHMSToolBarButton addNewEvent;
	public LHMSToolBarButton addNewCollege;
	public LHMSToolBarButton addNewCollegeDetails;
	public LHMSToolBarButton addStudentDetails;
	public LHMSToolBarButton timeSchedule;
	public LHMSToolBarButton report;
	public LHMSToolBarButton exit;
	public LHMSToolBarButton insertResult;
	public LHMSToolBarButton insertWinners;
	public LHMSToolBarButton editInsertResult;
	public LHMSToolBarButton editInsertWinners;
	public LHMSToolBarButton reportCollege;
	public LHMSToolBarButton reportStudent;
	public LHMSToolBarButton reportEvent;
	private LHMSMdiForm mdiForm;
	ImageUtil imageUtil;
	
	public LHMSToolBar() {
		this(null);
	}
	
	public LHMSToolBar(LHMSMdiForm mdiForm) {
		this.mdiForm = mdiForm;
		createToolBar();
	}
	
	public void createToolBar()	{
		imageUtil = new ImageUtil();
		
		addNewEvent = new LHMSToolBarButton(imageUtil.getIcon("BeanAdd24.gif"), "Event", " Add New Event");
		addNewEvent.setActionCommand(MNU_FILE_NEWEVENT);
		addNewEvent.addActionListener(this);
		this.add(addNewEvent);
		
		addNewCollegeDetails = new LHMSToolBarButton(imageUtil.loadImage("JarAdd24.gif"), "College Details", "Add College Initial details");
		addNewCollegeDetails.addActionListener(this);
		addNewCollegeDetails.setActionCommand(MNU_FILE_NEWCOLLEGE);
		this.add(addNewCollegeDetails);
		
		
		
		insertResult = new LHMSToolBarButton(imageUtil.loadImage("WarAdd24.gif"), "Result details", "Add Result");
		insertResult.addActionListener(this);
		insertResult.setActionCommand(MNU_MAINTAIN_RESULT);
		this.add(insertResult);
		
		editInsertResult = new LHMSToolBarButton(imageUtil.loadImage("War24.gif"), "Edit Result details", " Edit Result");
		editInsertResult.addActionListener(this);
		editInsertResult.setActionCommand(MNU_MAINTAIN_EDIT_RESULT);
		this.add(editInsertResult);
		
		insertWinners = new LHMSToolBarButton(imageUtil.loadImage("WebComponentAdd24.gif"), "Winners", "Insert Winners");
		insertWinners.addActionListener(this);
		insertWinners.setActionCommand(MNU_MAINTAIN_WINNERS);
		this.add(insertWinners);
		
		editInsertWinners = new LHMSToolBarButton(imageUtil.loadImage("WebComponent24.gif"), "Edit Winners details", " Edit Winners");
		editInsertWinners.addActionListener(this);
		editInsertWinners.setActionCommand(MNU_MAINTAIN_EDIT_WINNERS);
		this.add(editInsertWinners);
		
		timeSchedule = new LHMSToolBarButton(imageUtil.loadImage("Server24.gif"), "Time Schedule", "Time Schedule");
		timeSchedule.addActionListener(this);
		timeSchedule.setActionCommand(MNU_FILE_TIME_SHEET);
		this.add(timeSchedule);
		
		reportCollege = new LHMSToolBarButton(imageUtil.loadImage("J2EEApplicationClient24.gif"), "Report College", "Report College");
		reportCollege.addActionListener(this);
		reportCollege.setActionCommand(ACT_MNU_REPORT_COLLEGE);
		this.add(reportCollege);
		
		reportStudent = new LHMSToolBarButton(imageUtil.loadImage("J2EEServer24.gif"), "Report Student", "Report Student");
		reportStudent.addActionListener(this);
		reportStudent.setActionCommand(MNU_REPORT_STUDENT);
		this.add(reportStudent);
		
		reportEvent = new LHMSToolBarButton(imageUtil.loadImage("EnterpriseJavaBean24.gif"), "Reprt Event", "Report Event");
		reportEvent.addActionListener(this);
		reportEvent.setActionCommand(MNU_REPORT_EVENT);
		this.add(reportEvent);
		
		exit = new LHMSToolBarButton(imageUtil.loadImage("exit.gif"), "Exit", "Exit");
		exit.addActionListener(this);
		exit.setActionCommand(MNU_FILE_EXIT);
		this.add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(LHMSMenuBar.MNU_FILE_EXIT.equals(actionCommand)) {
			Util.exitApplicataion();
		} else if (MNU_FILE_NEWEVENT.equals(actionCommand)) {
			new EventsController(mdiForm).askEventView();
		} else if (MNU_HELP_CONTENT.equals(actionCommand)) {
		} else if(MNU_FILE_NEWCOLLEGE.equals(actionCommand)) {
			new CollegeInitialViewController(mdiForm).askCollegeInitialView();
		} else if(MNU_MAINTAIN_COLLEGE.equals(actionCommand)) {
			new CollegeLookupController(mdiForm).askCollegeLookupView();
		} else if (MNU_MAINTAIN_STUDENT.equals(actionCommand)) {
			new StudentLookupController(mdiForm).askStudentLookupsereen();
		} else if(MNU_MAINTAIN_RESULT.equals(actionCommand)) {
			new ResultInsertController(mdiForm).askResultInsertView();
		}else if(MNU_MAINTAIN_EDIT_RESULT.equals(actionCommand)) {
			new ResultInsertController(mdiForm,true).askResultInsertView();
		} else if(MNU_MAINTAIN_WINNERS.equals(actionCommand)) {
			new InsertResultController(mdiForm).askInsertResultView();
		} else if(ACT_MNU_REPORT_COLLEGE.equals(actionCommand)) {
			new CollegeLookupController(mdiForm,true).askCollegeLookupView();
		} else if(MNU_REPORT_STUDENT.equals(actionCommand)) {
			new StudentLookupController(mdiForm, false, true).askStudentLookupsereen();
		} else if (MNU_REPORT_EVENT.equals(actionCommand)) {
			new SearchTableController(mdiForm).askSearachTable();
		} else if(ACT_MNU_REPORT_RESULT.equals(actionCommand)) {
			new ParticipantLookupController(mdiForm).askParticipantsLookupView();
		} else if (MNU_FILE_TIME_SHEET.equals(actionCommand)) {
			new SelectDateDialogController(mdiForm).askDateDialog();
		} else if (MNU_MAINTAIN_GROUP_EVENT.equals(actionCommand)) {
			new StudentLookupController(mdiForm, true, false).askStudentLookupsereen();
		}else if (MNU_MAINTAIN_EDIT_WINNERS.equals(actionCommand)) {
			new WinnerLookupController(mdiForm).askWinnerLookUp();
		}
		
	}

}
