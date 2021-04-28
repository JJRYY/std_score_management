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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class ScoreByBan extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSel;
	private JButton btnCancel;
	private StudentScoreAllService service;
	private StudentScoreTablePanel pList;
	private ScoreByBanContentPanel pContent;
	private JPanel pSouth;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblKor;
	private JLabel lblEng;
	private JLabel lblMath;
	private JLabel lblSoc;
	private JLabel lblSci;
	private JLabel lblSum;
	private JLabel lblAvg;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

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
		
		pSouth = new JPanel();
		pSouth.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pSouth, BorderLayout.SOUTH);
		pSouth.setLayout(new GridLayout(1, 0, 0, 0));
		
		label = new JLabel("국어");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(label);
		
		lblKor = new JLabel("");
		lblKor.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblKor);
		
		label_1 = new JLabel("영어");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(label_1);
		
		lblEng = new JLabel("");
		lblEng.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblEng);
		
		label_2 = new JLabel("수학");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(label_2);
		
		lblMath = new JLabel("");
		lblMath.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblMath);
		
		lblNewLabel = new JLabel("사회");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblNewLabel);
		
		lblSoc = new JLabel("");
		lblSoc.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblSoc);
		
		lblNewLabel_1 = new JLabel("과학");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblNewLabel_1);
		
		lblSci = new JLabel("");
		lblSci.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblSci);
		
		lblNewLabel_2 = new JLabel("총점");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblNewLabel_2);
		
		lblSum = new JLabel("");
		lblSum.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblSum);
		
		lblNewLabel_3 = new JLabel("평균");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblNewLabel_3);
		
		lblAvg = new JLabel("");
		lblAvg.setHorizontalAlignment(SwingConstants.RIGHT);
		pSouth.add(lblAvg);
		
		setLabelAvg();
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
		
		double avgKor = service.avgSubjectScoreByBan("국어", ban);
		double avgEng = service.avgSubjectScoreByBan("영어", ban);
		double avgMath = service.avgSubjectScoreByBan("수학", ban);
		double avgSoc = service.avgSubjectScoreByBan("사회", ban);
		double avgSci = service.avgSubjectScoreByBan("과학", ban);
		double avgSum = service.avgSubjectScoreByBan("sumScore", ban);
		double avgAll = service.avgSubjectScoreByBan("avgScore", ban);
		lblKor.setText(String.format("%.2f", avgKor));
		lblEng.setText(String.format("%.2f", avgEng));
		lblMath.setText(String.format("%.2f", avgMath));
		lblSoc.setText(String.format("%.2f", avgSoc));
		lblSci.setText(String.format("%.2f", avgSci));
		lblSum.setText(String.format("%.2f", avgSum));
		lblAvg.setText(String.format("%.2f", avgAll));
		
		pList.setList();
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clearTf();
		setLabelAvg();
		pList.initList();
		pList.loadData();
	}
}
