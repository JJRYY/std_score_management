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
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

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
	private JPanel pSouth;
	private JLabel lblKor;
	private JLabel lblEng;
	private JLabel lblMath;
	private JLabel lblSoc;
	private JLabel lblSci;
	private JLabel lblSum;
	private JLabel lblAvg;

	public ScoreAll() {
		service = new StudentScoreAllService();
		initialize();
	}
	
	private void initialize() {
		setTitle("전체 성적");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(980, 100, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 10));
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
		pBtn.setLayout(new GridLayout(0, 2, 10, 0));
		
		btnSel = new JButton("정렬");
		btnSel.addActionListener(this);
		pBtn.add(btnSel);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		pSouth = new JPanel();
		pSouth.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pSouth, BorderLayout.SOUTH);
		pSouth.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblText1 = new JLabel("국어 :");
		lblText1.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblText1);
		
		lblKor = new JLabel("");
		lblKor.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblKor);
		
		JLabel lblText2 = new JLabel("영어 :");
		lblText2.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblText2);
		
		lblEng = new JLabel("");
		lblEng.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblEng);
		
		JLabel lblText3 = new JLabel("수학 :");
		lblText3.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblText3);
		
		lblMath = new JLabel("");
		lblMath.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblMath);
		
		JLabel lblText4 = new JLabel("사회 :");
		lblText4.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblText4);
		
		lblSoc = new JLabel("");
		lblSoc.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblSoc);
		
		JLabel lblText5 = new JLabel("과학 :");
		lblText5.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblText5);
		
		lblSci = new JLabel("");
		lblSci.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblSci);
		
		JLabel lblText6 = new JLabel("총점 :");
		lblText6.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblText6);
		
		lblSum = new JLabel("");
		lblSum.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblSum);
		
		JLabel lblText7 = new JLabel("평균 :");
		lblText7.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblText7);
		
		lblAvg = new JLabel("");
		lblAvg.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblAvg);
		
		setLabelAvg();
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
		
		String subject = pContent.getSubject().getSubjectName();
		int cnt = pContent.getCnt();
		
		int sumKor = 0;
		int sumEng = 0;
		int sumMath = 0;
		int sumSoc = 0;
		int sumSci = 0;
		int sumAll = 0;
		double sumAvg = 0.0;
		
		double avgKor = 0.0;
		double avgEng = 0.0;
		double avgMath = 0.0;
		double avgSoc = 0.0;
		double avgSci = 0.0;
		double avgSum = 0.0;
		double avgAll = 0.0;
		
		if(cnt != 0 && subject != null) {
			List<StudentScoreAll> stdList = service.showStudentScoreTopBySubject(subject, cnt);
			for (StudentScoreAll s : stdList) {
				sumKor += s.getKor();
				sumEng += s.getEng();
				sumMath += s.getMath();
				sumSoc += s.getSoc();
				sumSci += s.getSci();
				sumAll += s.getSum();
				sumAvg += s.getAvg();
			}
			avgKor = (double) sumKor / stdList.size();
			avgEng = (double) sumEng / stdList.size();
			avgMath = (double) sumMath / stdList.size();
			avgSoc = (double) sumSoc / stdList.size();
			avgSci = (double) sumSci / stdList.size();
			avgSum = (double) sumAll / stdList.size();
			avgAll = sumAvg / stdList.size();
			
			pList.setInitList(stdList);
		} else if (cnt == 0 && subject != null) {
			List<StudentScoreAll> stdList = service.showStudentScoreOrderBySubject(subject);
			
			for (StudentScoreAll s : stdList) {
				sumKor += s.getKor();
				sumEng += s.getEng();
				sumMath += s.getMath();
				sumSoc += s.getSoc();
				sumSci += s.getSci();
				sumAll += s.getSum();
				sumAvg += s.getAvg();
			}
			avgKor = (double) sumKor / stdList.size();
			avgEng = (double) sumEng / stdList.size();
			avgMath = (double) sumMath / stdList.size();
			avgSoc = (double) sumSoc / stdList.size();
			avgSci = (double) sumSci / stdList.size();
			avgSum = (double) sumAll / stdList.size();
			avgAll = sumAvg / stdList.size();
			
			pList.setInitList(stdList);
		} else if (cnt != 0 && subject == null) {
			List<StudentScoreAll> stdList = service.showStudentScoreTopByAvg(cnt);
			
			for (StudentScoreAll s : stdList) {
				sumKor += s.getKor();
				sumEng += s.getEng();
				sumMath += s.getMath();
				sumSoc += s.getSoc();
				sumSci += s.getSci();
				sumAll += s.getSum();
				sumAvg += s.getAvg();
			}
			avgKor = (double) sumKor / stdList.size();
			avgEng = (double) sumEng / stdList.size();
			avgMath = (double) sumMath / stdList.size();
			avgSoc = (double) sumSoc / stdList.size();
			avgSci = (double) sumSci / stdList.size();
			avgSum = (double) sumAll / stdList.size();
			avgAll = sumAvg / stdList.size();
			
			pList.setInitList(stdList);
		} else if (cnt == 0 && subject == null) {
			List<StudentScoreAll> stdList = service.showStudentScoreOrderByAvg();
			
			for (StudentScoreAll s : stdList) {
				sumKor += s.getKor();
				sumEng += s.getEng();
				sumMath += s.getMath();
				sumSoc += s.getSoc();
				sumSci += s.getSci();
				sumAll += s.getSum();
				sumAvg += s.getAvg();
			}
			avgKor = (double) sumKor / stdList.size();
			avgEng = (double) sumEng / stdList.size();
			avgMath = (double) sumMath / stdList.size();
			avgSoc = (double) sumSoc / stdList.size();
			avgSci = (double) sumSci / stdList.size();
			avgSum = (double) sumAll / stdList.size();
			avgAll = sumAvg / stdList.size();
			
			pList.setInitList(stdList);
		} 
		
		lblKor.setText(String.format("%.2f", avgKor));
		lblEng.setText(String.format("%.2f", avgEng));
		lblMath.setText(String.format("%.2f", avgMath));
		lblSoc.setText(String.format("%.2f", avgSoc));
		lblSci.setText(String.format("%.2f", avgSci));
		lblSum.setText(String.format("%.2f", avgSum));
		lblAvg.setText(String.format("%.2f", avgAll));

		pList.setList();
		
	}
	
	public void setLabelAvg() {
		lblKor.setText(String.format("%.2f", service.avgSubjectScore("국어")));
		lblEng.setText(String.format("%.2f", service.avgSubjectScore("영어")));
		lblMath.setText(String.format("%.2f", service.avgSubjectScore("수학")));
		lblSoc.setText(String.format("%.2f", service.avgSubjectScore("사회")));
		lblSci.setText(String.format("%.2f", service.avgSubjectScore("과학")));
		lblSum.setText(String.format("%.2f", service.avgSubjectScore("sumScore")));
		lblAvg.setText(String.format("%.2f", service.avgSubjectScore("avgScore")));
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clearTf();
		pList.initList();
		pList.loadData();
		setLabelAvg();
	}
}
