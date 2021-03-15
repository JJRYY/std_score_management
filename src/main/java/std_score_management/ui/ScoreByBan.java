package std_score_management.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import std_score_management.ui.content.ScoreByBanTopPanel;

@SuppressWarnings("serial")
public class ScoreByBan extends JFrame {

	private JPanel contentPane;

	public ScoreByBan() {
		initialize();
	}
	private void initialize() {
		setTitle("분반별 성적");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 750, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ScoreByBanTopPanel pContent = new ScoreByBanTopPanel();
		contentPane.add(pContent, BorderLayout.NORTH);
		
		JPanel pList = new JPanel();
		contentPane.add(pList, BorderLayout.CENTER);
	}

}
