package std_score_management.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import std_score_management.dto.Student;
import std_score_management.service.StudentScoreAllService;
import std_score_management.service.StudentService;
import std_score_management.ui.content.StdSimplePanel;
import std_score_management.ui.exception.InvalidCheckException;
import std_score_management.ui.exception.StdNotExistException;
import std_score_management.ui.list.StudentTablePanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	public StudentManager() {
		service = new StudentScoreAllService();
		stdService = new StudentService();
		initialize();
	}

	private void initialize() {
		setTitle("학생 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 593, 250);
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
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnClear) {
				actionPerformedBtnClear(e);
			}
			if (e.getSource() == btnAdd) {
				actionPerformedBtnAdd(e);
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

	protected void actionPerformedBtnSel(ActionEvent e) {
		Student newStd = pContent.getItem();
		pContent.setItem(stdService.showStudentByNo(newStd));
		pList.searchStudent(newStd);
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		Student newStd = pContent.getStudent();
		stdService.addStudent(newStd);
		JOptionPane.showMessageDialog(null, newStd + "추가완료");
		pList.loadData();
		pContent.clearTf();
	}

	protected void actionPerformedBtnClear(ActionEvent e) {
		pContent.clearTf();
		pList.initList();
		pList.loadData();
	}
}
