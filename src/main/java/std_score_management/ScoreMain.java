package std_score_management;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import std_score_management.ui.BanManager;
import std_score_management.ui.ScoreAll;
import std_score_management.ui.ScoreByBan;
import std_score_management.ui.ScoreManager;
import std_score_management.ui.StudentManager;

@SuppressWarnings("serial")
public class ScoreMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnStdScore;
	private JButton btnScoreByBan;
	private JButton btnScoreAll;
	private JButton btnBan;
	private JButton btnStd;

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
		initialize();
		
	}
	private void initialize() {
		setTitle("학생 성적 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		
		btnStd = new JButton("학생정보");
		btnStd.addActionListener(this);
		pBtn.setLayout(new GridLayout(0, 1, 10, 10));
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
		
		btnBan = new JButton("분반 관리");
		btnBan.addActionListener(this);
		pBtn.add(btnBan);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStd) {
			actionPerformedBtnStd(e);
		}
		if (e.getSource() == btnBan) {
			actionPerformedBtnBan(e);
		}
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
	protected void actionPerformedBtnBan(ActionEvent e) {
		BanManager frame = new BanManager();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnStd(ActionEvent e) {
		StudentManager frame = new StudentManager();
		frame.setVisible(true);
	}
}
