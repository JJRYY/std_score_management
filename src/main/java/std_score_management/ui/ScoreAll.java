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

import std_score_management.dto.StudentScoreAll;
import std_score_management.dto.Subject;
import std_score_management.service.StudentScoreAllService;
import std_score_management.ui.content.ScoreAllTopPanel;
import std_score_management.ui.list.StudentScoreTablePanel;

@SuppressWarnings("serial")
public class ScoreAll extends JFrame implements ActionListener {

	private JPanel contentPane;
	private StudentScoreTablePanel pList;
	private StudentScoreAllService service;
	private JPanel pNorth;
	private ScoreAllTopPanel pContent;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel pBtn;
	private JButton btnSel;
	private JButton btnCancel;

	public ScoreAll() {
		service = new StudentScoreAllService();
		initialize();
	}
	private void initialize() {
		setTitle("전체 성적");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 750, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pList = new StudentScoreTablePanel();
		pList.setService(service);
		pList.loadData();
		contentPane.add(pList, BorderLayout.CENTER);
		
		pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 2, 0, 0));
		
		pContent = new ScoreAllTopPanel();
		pContent.setService(service);
		pNorth.add(pContent);
		
		panel_2 = new JPanel();
		pNorth.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		pBtn = new JPanel();
		panel_2.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnSel = new JButton("조회");
		btnSel.addActionListener(this);
		pBtn.add(btnSel);
		
		btnCancel = new JButton("취소");
		pBtn.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSel) {
			actionPerformedBtnSel(e);
		}
	}
	
	protected void actionPerformedBtnSel(ActionEvent e) {
//		Subject subject = pContent.getSubject();
//		int cnt = pContent.getCnt();
//		List<StudentScoreAll> stdList = service.showStudentScoreTopByAvg(cnt);
//		pList.setInitList(stdList);
//		pList.setList();
		
		String subject = pContent.getSubject().getSubjectName();
		int cnt = Integer.parseInt(pContent.getTfStdCnt().getText().trim());
		
		if (((pContent.getTfStdCnt() != null)||(Integer.parseInt(pContent.getTfStdCnt().getText().trim()) == 0)) && pContent.getSubject() != null) {
			List<StudentScoreAll> stdList = service.showStudentScoreTopBySubject(subject, cnt);
			pList.setInitList(stdList);
		} else if (pContent.getSubject() != null && pContent.getTfStdCnt().equals(null)) {
			List<StudentScoreAll> stdList = service.showStudentScoreOrderBySubject(subject);
			pList.setInitList(stdList);
		}
		
//		if ((pContent.getTfStdCnt().getText() == "" || cnt == 0) && pContent.getCmbSubject().getSelectedIndex() == -1) {
//			List<StudentScoreAll> stdList = service.showStudentScoreOrderByAvg();
//			pList.setInitList(stdList);
//		}
//		List<StudentScoreAll> stdList = service.showStudentScoreTopBySubject(subject, cnt);
		pList.setList();
		
	}
}
