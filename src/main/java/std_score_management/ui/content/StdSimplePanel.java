package std_score_management.ui.content;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class StdSimplePanel extends JPanel {
	private JTextField tfStdNo;
	private JTextField tfStdName;

	public StdSimplePanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "학생 정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 1, 0, 10));
		
		JPanel panel1 = new JPanel();
		add(panel1);
		panel1.setLayout(new GridLayout(0, 4, 10, 0));
		
		JLabel lblStdNo = new JLabel("학번");
		lblStdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(lblStdNo);
		
		tfStdNo = new JTextField();
		panel1.add(tfStdNo);
		tfStdNo.setColumns(10);
		
		JButton btnSelect = new JButton("조회");
		panel1.add(btnSelect);
		
		JButton btnStdDetail = new JButton("학생 정보 확인");
		panel1.add(btnStdDetail);
		
		JPanel panel2 = new JPanel();
		add(panel2);
		panel2.setLayout(new GridLayout(0, 4, 10, 0));
		
		JLabel lblStdName = new JLabel("이름");
		lblStdName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(lblStdName);
		
		tfStdName = new JTextField();
		panel2.add(tfStdName);
		tfStdName.setColumns(10);
		
		JPanel panel3 = new JPanel();
		panel2.add(panel3);
		panel3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblGrade = new JLabel("학년");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		panel3.add(lblGrade);
		
		JComboBox cmbGrade = new JComboBox();
		panel3.add(cmbGrade);
		
		JPanel panel4 = new JPanel();
		panel2.add(panel4);
		panel4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblBan = new JLabel("분반");
		lblBan.setHorizontalAlignment(SwingConstants.CENTER);
		panel4.add(lblBan);
		
		JComboBox cmbBan = new JComboBox();
		panel4.add(cmbBan);
	}

}
