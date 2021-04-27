package std_score_management.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import std_score_management.dto.Ban;
import std_score_management.dto.StudentScoreAll;
import std_score_management.service.StudentScoreAllService;
import std_score_management.ui.content.ScoreByBanContentPanel;
import std_score_management.ui.list.StudentScoreTablePanel;

@SuppressWarnings("serial")
public class ScoreByBan extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSel;
	private JButton btnCancel;
	private StudentScoreAllService service;
	private StudentScoreTablePanel pList;
	private ScoreByBanContentPanel pContent;

	public ScoreByBan() {
		service = new StudentScoreAllService();
		initialize();
	}
	private void initialize() {
		setTitle("분반별 성적");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(460, 100, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 10));
		setContentPane(contentPane);
		
		pList = new StudentScoreTablePanel();
		pList.setService(service);
		pList.loadData();
		contentPane.add(pList, BorderLayout.CENTER);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 2, 10, 0));
		
		pContent = new ScoreByBanContentPanel();
		pContent.setService(service);
		pNorth.add(pContent);
		
		JPanel panel_1 = new JPanel();
		pNorth.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		
		JPanel pBtns = new JPanel();
		panel_1.add(pBtns);
		pBtns.setLayout(new GridLayout(0, 2, 10, 0));
		
		btnSel = new JButton("정렬");
		btnSel.addActionListener(this);
		pBtns.add(btnSel);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnSel) {
			actionPerformedBtnSel(e);
		}
	}
	
	protected void actionPerformedBtnSel(ActionEvent e) {
		Ban ban = pContent.getBan();
		String subject = pContent.getSubject().getSubjectName();
		if (ban != null && subject != null) {
			List<StudentScoreAll> stdList = service.showStudentScoreByBanSubject(ban, subject);
			pList.setInitList(stdList);
			pList.setList();
		} else if (ban != null && subject == null) {
			List<StudentScoreAll> stdList = service.showStudentScoreByBan(ban);
			pList.setInitList(stdList);
			pList.setList();
		} else if (ban == null && subject != null) {
			List<StudentScoreAll> stdList = service.showStudentScoreOrderBySubject(subject);
			pList.setInitList(stdList);
		} else if (ban == null && subject == null) {
			List<StudentScoreAll> stdList = service.showStudentScoreOrderByAvg();
			pList.setInitList(stdList);
		}
		
		pList.setList();
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clearTf();
		pList.initList();
		pList.loadData();
	}
}
