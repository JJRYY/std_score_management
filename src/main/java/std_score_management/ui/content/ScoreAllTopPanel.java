package std_score_management.ui.content;

import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import std_score_management.dto.Subject;
import std_score_management.service.StudentScoreAllService;
import std_score_management.ui.exception.InvalidCheckException;

@SuppressWarnings("serial")
public class ScoreAllTopPanel extends JPanel {
	private JTextField tfStdCnt;
	private JComboBox<Subject> cmbSubject;
	private StudentScoreAllService service;

	public ScoreAllTopPanel() {

		initialize();
	}
	
	public void setService(StudentScoreAllService service) {
		this.service = service;
		
		List<Subject> subjectList = service.showSubjectList();
		DefaultComboBoxModel<Subject> subjectModel = new DefaultComboBoxModel<>(new Vector(subjectList));
		cmbSubject.setModel(subjectModel);
		
		cmbSubject.setSelectedIndex(-1);
	}
	
	private void initialize() {
		setLayout(new GridLayout(0, 4, 10, 0));
		
		JLabel lblStdCnt = new JLabel("인원 수");
		lblStdCnt.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblStdCnt);
		
		tfStdCnt = new JTextField();
		add(tfStdCnt);
		tfStdCnt.setColumns(10);
		
		JLabel lblSubject = new JLabel("과목");
		lblSubject.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSubject);
		
		cmbSubject = new JComboBox<>();
		add(cmbSubject);
	}

	public Subject getSubject() {
		validCheck();
		Subject subject = (Subject) cmbSubject.getSelectedItem();
		
		return new Subject(subject.getSubjectCode(), subject.getSubjectName());
	}
	

	public int getCnt() {
		validCheck();
		int cnt = Integer.parseInt(tfStdCnt.getText().trim());
		
		return cnt;
	}
	
	private void validCheck() {
		if (tfStdCnt.getText().equals("")||cmbSubject.getSelectedIndex() == -1) {
			throw new InvalidCheckException();
		}
		
	}
}
