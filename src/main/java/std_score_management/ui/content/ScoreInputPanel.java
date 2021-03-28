package std_score_management.ui.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import std_score_management.dto.Score;
import std_score_management.dto.StudentScoreAll;
import std_score_management.service.ScoreService;
import std_score_management.service.StudentScoreAllService;

@SuppressWarnings("serial")
public class ScoreInputPanel extends JPanel {
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMath;
	private JTextField tfSoc;
	private JTextField tfSci;
	private ScoreService service;
	private StudentScoreAllService allService;

	public ScoreInputPanel() {

		initialize();
	}
	
	public void setService(ScoreService service) {
		this.service = service;
	}
	
	public void setAllService(StudentScoreAllService allService) {
		this.allService = allService;
	}

	private void initialize() {
		setBorder(new TitledBorder(null, "성적 입력", TitledBorder.LEADING, TitledBorder.TOP, null,
				null));
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

	public void setItem(StudentScoreAll item) {
		tfKor.setText(item.getKor() + "");
		tfEng.setText(item.getEng() + "");
		tfMath.setText(item.getMath() + "");
		tfSoc.setText(item.getSoc() + "");
		tfSci.setText(item.getSci() + "");
	}
	
	public StudentScoreAll getItem() {
		int kor = Integer.parseInt(tfKor.getText().trim());
		int eng = Integer.parseInt(tfKor.getText().trim());
		int math = Integer.parseInt(tfKor.getText().trim());
		int soc = Integer.parseInt(tfKor.getText().trim());
		int sci = Integer.parseInt(tfKor.getText().trim());
		
		return new StudentScoreAll(kor, eng, math, soc, sci);
	}
	
	public void clearTf() {
		tfKor.setText("");
		tfEng.setText("");
		tfMath.setText("");
		tfSoc.setText("");
		tfSci.setText("");
	}
	
	
	public JTextField getTfKor() {
		return tfKor;
	}

	public void setTfKor(JTextField tfKor) {
		this.tfKor = tfKor;
	}

	public JTextField getTfEng() {
		return tfEng;
	}

	public void setTfEng(JTextField tfEng) {
		this.tfEng = tfEng;
	}

	public JTextField getTfMath() {
		return tfMath;
	}

	public void setTfMath(JTextField tfMath) {
		this.tfMath = tfMath;
	}

	public JTextField getTfSoc() {
		return tfSoc;
	}

	public void setTfSoc(JTextField tfSoc) {
		this.tfSoc = tfSoc;
	}

	public JTextField getTfSci() {
		return tfSci;
	}

	public void setTfSci(JTextField tfSci) {
		this.tfSci = tfSci;
	}

}
