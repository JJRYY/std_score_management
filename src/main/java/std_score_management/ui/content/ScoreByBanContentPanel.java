package std_score_management.ui.content;

import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import std_score_management.dto.Ban;
import std_score_management.dto.Subject;
import std_score_management.service.StudentScoreAllService;

@SuppressWarnings("serial")
public class ScoreByBanContentPanel extends JPanel {
	private JComboBox<Ban> cmbBan;
	private JComboBox<Subject> cmbSubject;
	private StudentScoreAllService service;

	public ScoreByBanContentPanel() {

		initialize();
	}
	
	public void setService(StudentScoreAllService service) {
		this.service = service;
		
		List<Ban> banList = service.showBanList();
		DefaultComboBoxModel<Ban> banModel = new DefaultComboBoxModel<>(new Vector(banList));
		cmbBan.setModel(banModel);
		cmbBan.setSelectedIndex(-1);
		
		List<Subject> subjectList = service.showSubjectList();
		DefaultComboBoxModel<Subject> subjectModel = new DefaultComboBoxModel<>(new Vector(subjectList));
		cmbSubject.setModel(subjectModel);
		cmbSubject.setSelectedIndex(-1);
		
	}
	
	private void initialize() {
		setLayout(new GridLayout(0, 4, 10, 10));
		
		JLabel lblBan = new JLabel("분반");
		lblBan.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblBan);
		
		cmbBan = new JComboBox<>();
		add(cmbBan);
		
		JLabel lblSubject = new JLabel("과목");
		lblSubject.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSubject);
		
		cmbSubject = new JComboBox<>();
		add(cmbSubject);
	}

}
