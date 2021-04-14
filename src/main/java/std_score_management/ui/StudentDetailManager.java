package std_score_management.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import std_score_management.dto.Student;
import std_score_management.dto.StudentDetail;
import std_score_management.service.StudentDetailService;
import std_score_management.ui.content.StudentDetailPanel;
import std_score_management.ui.list.StudentTablePanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StudentDetailManager extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAdd;
	private JButton btnCancel;
	private StudentDetailService detailService;
	private StudentDetailPanel pDetail;
	private StudentTablePanel stdTable;
	
	public void setStdTable(StudentTablePanel stdTable) {
		this.stdTable = stdTable;
	}

	public StudentDetailManager(boolean isBtns) {
		detailService = new StudentDetailService();
		initialize(isBtns);
	}

	private void initialize(boolean isBtns) {
		setTitle("학생 상세 정보");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pDetail = new StudentDetailPanel();
		contentPane.add(pDetail, BorderLayout.CENTER);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);

		btnAdd = new JButton("");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);

		btnCancel = new JButton("");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);

		if(isBtns) {
			btnAdd.setText("추가");
			btnCancel.setText("취소");
		} else {
			btnAdd.setText("수정");
			btnCancel.setText("삭제");
		}
	}

	public void setStdNo(Student stdNo) {
		pDetail.setTfStdNo(stdNo);
	}
	
	public void setDetailItem(StudentDetail stdDetail) {
		pDetail.setItem(stdDetail);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("취소")) {
			actionPerformedBtnCancel(e);
		}
		if (e.getActionCommand().equals("추가")) {
			actionPerformedBtnAdd(e);
		}
		if (e.getActionCommand().equals("수정")) {
			actionPerformedBtnUpdate(e);
		}
		if (e.getActionCommand().equals("삭제")) {
			actionPerformedBtnDelete(e);
		}
	}

	protected void actionPerformedBtnDelete(ActionEvent e) {
		StudentDetail stdDetail = pDetail.getItem();
		detailService.removeStudentDetail(new Student(stdDetail.getStdNo()));
		JOptionPane.showMessageDialog(null, "삭제 완료");
		pDetail.clearTf();
	}

	protected void actionPerformedBtnUpdate(ActionEvent e) {
		StudentDetail stdDetail = pDetail.getItem();
		detailService.updateStudentDetail(stdDetail);
		JOptionPane.showMessageDialog(null, "수정 완료");
		pDetail.clearTf();
		dispose();
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		StudentDetail stdDetail = pDetail.getItem();
		detailService.addStudentDetail(stdDetail);
		JOptionPane.showMessageDialog(null, "추가 완료");
		pDetail.clearTf();
		stdTable.loadData();
		dispose();
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		pDetail.clearTf();
		if(btnAdd.getText().equals("수정")) {
			btnAdd.setText("추가");
		}
	}
}
