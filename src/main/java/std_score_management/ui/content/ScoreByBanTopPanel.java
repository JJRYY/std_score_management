package std_score_management.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ScoreByBanTopPanel extends JPanel {

	public ScoreByBanTopPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel pLeft = new JPanel();
		add(pLeft);
		pLeft.setLayout(new GridLayout(0, 5, 10, 0));
		
		JLabel lblGrade = new JLabel("학년");
		lblGrade.setHorizontalAlignment(SwingConstants.RIGHT);
		pLeft.add(lblGrade);
		
		JComboBox cmbGrade = new JComboBox();
		pLeft.add(cmbGrade);
		
		JLabel lblBan = new JLabel("분반");
		lblBan.setHorizontalAlignment(SwingConstants.RIGHT);
		pLeft.add(lblBan);
		
		JComboBox cmbBan = new JComboBox();
		pLeft.add(cmbBan);
		
		JButton btnSelect = new JButton("조회");
		pLeft.add(btnSelect);
		
		JPanel pRight = new JPanel();
		add(pRight);
		pRight.setLayout(new GridLayout(0, 3, 10, 0));
		
		JLabel lblSubject = new JLabel("과목");
		lblSubject.setHorizontalAlignment(SwingConstants.RIGHT);
		pRight.add(lblSubject);
		
		JComboBox cmbSubject = new JComboBox();
		pRight.add(cmbSubject);
		
		JButton btnAlign = new JButton("정렬");
		pRight.add(btnAlign);
	}

}
