package std_score_management.ui.content;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ScoreInputPanel extends JPanel {
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMath;
	private JTextField tfSoc;
	private JTextField tfSci;

	public ScoreInputPanel() {
		
		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "\uC131\uC801 \uC785\uB825", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 4, 10, 10));
		
		JLabel lblKor = new JLabel("국어");
		lblKor.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblKor);
		
		tfKor = new JTextField();
		add(tfKor);
		tfKor.setColumns(10);
		
		JLabel lblEng = new JLabel("영어");
		lblEng.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblEng);
		
		tfEng = new JTextField();
		tfEng.setColumns(10);
		add(tfEng);
		
		JLabel lblMath = new JLabel("수학");
		lblMath.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblMath);
		
		tfMath = new JTextField();
		tfMath.setColumns(10);
		add(tfMath);
		
		JLabel lblSoc = new JLabel("사회");
		lblSoc.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSoc);
		
		tfSoc = new JTextField();
		tfSoc.setColumns(10);
		add(tfSoc);
		
		JLabel lblSci = new JLabel("과학");
		lblSci.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSci);
		
		tfSci = new JTextField();
		tfSci.setColumns(10);
		add(tfSci);
	}

}
