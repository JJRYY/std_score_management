package std_score_management.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import std_score_management.ui.content.StdSimplePanel;
import std_score_management.ui.content.ScoreInputPanel;

@SuppressWarnings("serial")
public class ScoreManager extends JFrame {

	private JPanel contentPane;

	public ScoreManager() {
		initialize();
	}
	private void initialize() {
		setTitle("성적 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 630, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		StdSimplePanel pNorth = new StdSimplePanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
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
	}

}
