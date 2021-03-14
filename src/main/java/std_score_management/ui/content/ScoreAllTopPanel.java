package std_score_management.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ScoreAllTopPanel extends JPanel {
	private JTextField tfStdCnt;

	public ScoreAllTopPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 6, 10, 0));
		
		JPanel pSpace = new JPanel();
		add(pSpace);
		
		JLabel lblStdCnt = new JLabel("인원 수");
		lblStdCnt.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblStdCnt);
		
		tfStdCnt = new JTextField();
		add(tfStdCnt);
		tfStdCnt.setColumns(10);
		
		JLabel lblSubject = new JLabel("과목");
		lblSubject.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSubject);
		
		JComboBox cmbSubject = new JComboBox();
		add(cmbSubject);
		
		JButton btnSelect = new JButton("조회");
		add(btnSelect);
	}

}
