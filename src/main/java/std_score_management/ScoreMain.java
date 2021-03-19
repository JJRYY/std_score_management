package std_score_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import std_score_management.service.StudentScoreAllService;
import std_score_management.ui.ScoreAll;
import std_score_management.ui.ScoreByBan;
import std_score_management.ui.ScoreManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import std_score_management.ui.list.StudentScoreTablePanel;

@SuppressWarnings("serial")
public class ScoreMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnStdScore;
	private JButton btnScoreByBan;
	private JButton btnScoreAll;
	private StudentScoreAllService service;
	private StudentScoreTablePanel pStdList;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreMain frame = new ScoreMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ScoreMain() {
		service = new StudentScoreAllService();
		initialize();
		
	}
	private void initialize() {
		setTitle("학생 성적 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 10));
		setContentPane(contentPane);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.NORTH);
		
		JButton btnStd = new JButton("학생정보");
		pBtn.add(btnStd);
		
		btnStdScore = new JButton("학생 성적 입력");
		btnStdScore.addActionListener(this);
		pBtn.add(btnStdScore);
		
		btnScoreByBan = new JButton("분반별 성적 확인");
		btnScoreByBan.addActionListener(this);
		pBtn.add(btnScoreByBan);
		
		btnScoreAll = new JButton("전체 성적 확인");
		btnScoreAll.addActionListener(this);
		pBtn.add(btnScoreAll);
		
		pStdList = new StudentScoreTablePanel();
		pStdList.setService(service);
		pStdList.loadData();
		contentPane.add(pStdList, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnScoreAll) {
			actionPerformedBtnScoreAll(e);
		}
		if (e.getSource() == btnScoreByBan) {
			actionPerformedBtnScoreByBan(e);
		}
		if (e.getSource() == btnStdScore) {
			actionPerformedBtnStdScore(e);
		}
	}
	protected void actionPerformedBtnStdScore(ActionEvent e) {
		ScoreManager frame = new ScoreManager();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnScoreByBan(ActionEvent e) {
		ScoreByBan frame = new ScoreByBan();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnScoreAll(ActionEvent e) {
		ScoreAll frame = new ScoreAll();
		frame.setVisible(true);
	}
}
