package std_score_management.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import std_score_management.dto.Student;
import std_score_management.dto.StudentDetail;
import std_score_management.dto.StudentScoreAll;
import std_score_management.service.StudentDetailService;
import std_score_management.service.StudentScoreAllService;
import std_score_management.service.StudentService;
import std_score_management.ui.content.StdSimplePanel;
import std_score_management.ui.exception.InvalidCheckException;
import std_score_management.ui.exception.NotSelectedException;
import std_score_management.ui.exception.SqlConstraintException;
import std_score_management.ui.exception.StdNotExistException;
import std_score_management.ui.list.StudentTablePanel;

@SuppressWarnings("serial")
public class StudentManager extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSel;
	private JButton btnAdd;
	private JButton btnClear;
	private StudentTablePanel pList;
	private StdSimplePanel pContent;
	private StudentService stdService;
	private StudentScoreAllService service;
	private StudentDetailService detailService;

	public StudentManager() {
		service = new StudentScoreAllService();
		stdService = new StudentService();
		detailService = new StudentDetailService();
		initialize();
	}

	private void initialize() {
		setTitle("학생 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 720, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));

		JPanel pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(10, 10));

		pContent = new StdSimplePanel();
		pContent.setService(service);
		pLeft.add(pContent, BorderLayout.CENTER);

		JPanel pBtn = new JPanel();
		pLeft.add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(0, 3, 0, 0));

		btnSel = new JButton("조회");
		btnSel.addActionListener(this);
		pBtn.add(btnSel);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);

		btnClear = new JButton("취소");
		btnClear.addActionListener(this);
		pBtn.add(btnClear);

		pList = new StudentTablePanel();
		pList.setService(stdService);
		pList.loadData();
		contentPane.add(pList);
		
		JPopupMenu popMenu = createPopupMenu();
		pList.setPopupMenu(popMenu);
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem detailItem = new JMenuItem("상세 정보");
		detailItem.addActionListener(popupMenuListener);
		popMenu.add(detailItem);
		
		JMenuItem updateItem = new JMenuItem("학생 정보 수정");
		updateItem.addActionListener(popupMenuListener);
		popMenu.add(updateItem);
		
		JMenuItem scoreItem = new JMenuItem("성적 관리");
		scoreItem.addActionListener(popupMenuListener);
		popMenu.add(scoreItem);
		
		JMenuItem deleteItem = new JMenuItem("학생 정보 삭제");
		deleteItem.addActionListener(popupMenuListener);
		popMenu.add(deleteItem);
		
		return popMenu;
	}
	
	ActionListener popupMenuListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				if(e.getActionCommand().equals("학생 정보 수정")) {
					Student updateStd = pList.getItem();
					pContent.setItem(updateStd);
					stdService.updateStudent(updateStd);
					btnAdd.setText("수정");
				}
				if(e.getActionCommand().equals("학생 정보 삭제")) {
					Student delStd = pList.getItem();
					stdService.removeStudent(delStd);
					pList.loadData();
					JOptionPane.showMessageDialog(null, delStd + " 삭제 완료");
				}
				if(e.getActionCommand().equals("성적 관리")) {
					Student std = pList.getItem();
					StudentScoreAll stdScore = service.selectStudentScoreByStdNo(std);
					ScoreManager frame;
					if (stdScore == null) {
						frame = new ScoreManager();
						frame.setStdItem(std);
					} else {
						frame = new ScoreManager();
						frame.setStdItem(std);
						frame.setScoreItem(std);
					}
					frame.setVisible(true);
					frame.setStdTable(pList);
					
				}
				if(e.getActionCommand().equals("상세 정보")) {
					Student std = pList.getItem();
					StudentDetail stdDetail = detailService.showStudentDetailByNo(std);
					StudentDetailManager frame;
					if(stdDetail == null) {
						frame = new StudentDetailManager(true);
					} else {
						frame = new StudentDetailManager(false);
						frame.setDetailItem(stdDetail);
					}
					
					frame.setStdNo(std);
					frame.setVisible(true);
					frame.setStdTable(pList);
				}
				
			} catch(NotSelectedException | SqlConstraintException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	};

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnClear) {
				actionPerformedBtnClear(e);
			}
			if (e.getSource() == btnAdd) {
				if (btnAdd.getText().equals("추가")) {
					actionPerformedBtnAdd(e);
				}
				if (btnAdd.getText().equals("수정")) {
					actionPerformedBtnUpdate(e);
				}
			}
			if (e.getSource() == btnSel) {
				actionPerformedBtnSel(e);
			}
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			pContent.clearTf();
		} catch (StdNotExistException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			pContent.clearTf();
		}
	}

	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Student updateStd = pContent.getStudent();
		stdService.updateStudent(updateStd);
		pList.loadData();
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, updateStd.getStdNo() + " 정보 수정 완료");
		pContent.clearTf();
	}

	protected void actionPerformedBtnSel(ActionEvent e) {
		Student newStd = pContent.getItem();
		pContent.setItem(stdService.showStudentByNo(newStd));
		pList.searchStudent(newStd);
		btnAdd.setText("수정");
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		Student newStd = pContent.getStudent();
		stdService.addStudent(newStd);
		JOptionPane.showMessageDialog(null, newStd + " 추가완료");
		pList.loadData();
		pContent.clearTf();
	}

	protected void actionPerformedBtnClear(ActionEvent e) {
		pContent.clearTf();
		pList.initList();
		pList.loadData();
		
		if (btnAdd.getText().equals("수정")) {
			btnAdd.setText("추가");
		}
	}
}
