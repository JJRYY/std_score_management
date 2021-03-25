package std_score_management.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import std_score_management.service.StudentScoreAllService;
import std_score_management.ui.content.ScoreByBanContentPanel;
import std_score_management.ui.list.StudentScoreTablePanel;

@SuppressWarnings("serial")
public class ScoreByBan extends JFrame {

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
		setBounds(150, 150, 750, 300);
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
		
		btnSel = new JButton("조회");
		pBtns.add(btnSel);
		
		btnCancel = new JButton("취소");
		pBtns.add(btnCancel);
	}

}
