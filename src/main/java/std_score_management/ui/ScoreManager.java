package std_score_management.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import std_score_management.ui.content.StdSimplePanel;
import std_score_management.ui.content.ScoreInputPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class ScoreManager extends JFrame {

	private JPanel contentPane;
	private JButton btnSel;
	private JButton btnStdInfo;

	public ScoreManager() {
		initialize();
	}
	private void initialize() {
		setTitle("성적 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 630, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
		
		JButton btnInput = new JButton("입력");
		pSouth.add(btnInput);
		
		JButton btnDelete = new JButton("삭제");
		pSouth.add(btnDelete);
		
		JButton btnCancel = new JButton("취소");
		pSouth.add(btnCancel);
		
		ScoreInputPanel pCenter = new ScoreInputPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 2, 0, 0));
		
		StdSimplePanel pStd = new StdSimplePanel();
		pNorth.add(pStd);
		
		JPanel pBtn = new JPanel();
		pBtn.setBorder(new EmptyBorder(15, 30, 10, 150));
		pNorth.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 1, 10, 10));
		
		btnSel = new JButton("조회");
		pBtn.add(btnSel);
		
		btnStdInfo = new JButton("학생정보확인");
		pBtn.add(btnStdInfo);
	}

}
