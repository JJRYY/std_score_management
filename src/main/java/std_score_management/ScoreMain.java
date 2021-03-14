package std_score_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ScoreMain extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 633, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.NORTH);
		
		JButton btnStd = new JButton("학생정보");
		pBtn.add(btnStd);
		
		JButton btnStdScore = new JButton("학생 성적 입력");
		pBtn.add(btnStdScore);
		
		JButton btnScoreByBan = new JButton("분반별 성적 확인");
		pBtn.add(btnScoreByBan);
		
		JButton btnScoreAll = new JButton("전체 성적 확인");
		pBtn.add(btnScoreAll);
		
		JPanel pStdList = new JPanel();
		contentPane.add(pStdList, BorderLayout.CENTER);
	}

}
