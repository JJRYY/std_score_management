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
import javax.swing.border.TitledBorder;

import std_score_management.dto.Ban;
import std_score_management.dto.Student;
import std_score_management.service.StudentScoreAllService;
import std_score_management.service.StudentService;
import std_score_management.ui.exception.InvalidCheckException;
import std_score_management.ui.exception.StdNotExistException;

@SuppressWarnings("serial")
public class StdSimplePanel extends JPanel {
	private JTextField tfStdNo;
	private JTextField tfStdName;
	private JComboBox<Ban> cmbBan;
	private StudentScoreAllService service;
	private StudentService stdService;

	public StdSimplePanel() {

		initialize();
	}
	
	public void setService(StudentScoreAllService service) {
		this.service = service;
		
		List<Ban> banList = service.showBanList();
		DefaultComboBoxModel<Ban> banModel = new DefaultComboBoxModel<>(new Vector(banList));
		cmbBan.setModel(banModel);
		cmbBan.setSelectedIndex(-1);
	}
	
	private void initialize() {
		setBorder(new TitledBorder(null, "학생 정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblStdNo = new JLabel("학번");
		lblStdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblStdNo);
		
		tfStdNo = new JTextField();
		add(tfStdNo);
		tfStdNo.setColumns(10);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);
		
		tfStdName = new JTextField();
		tfStdName.setEditable(false);
		add(tfStdName);
		tfStdName.setColumns(10);
		
		JLabel lblBan = new JLabel("분반");
		lblBan.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblBan);
		
		cmbBan = new JComboBox<>();
		cmbBan.setEnabled(false);
		add(cmbBan);
	}

	public Student getItem() {
		validCheck();
		int stdNo = Integer.parseInt(tfStdNo.getText().trim());
//		String stdName = tfStdName.getText().trim();
//		Ban banCode = (Ban) cmbBan.getSelectedItem();
				
		return new Student(stdNo);
	}
	
	private void validCheck() {
		if (tfStdNo.getText().equals("")) {
			throw new InvalidCheckException();
		}
		
	}

	public void setItem(Student item) {
		if (item == null) {
			throw new StdNotExistException();
		}
		tfStdNo.setText(item.getStdNo() + "");
		tfStdName.setText(item.getStdName());
		cmbBan.setSelectedItem(item.getBanCode());
	}
	
	public void clearTf() {
		tfStdNo.setText("");
		tfStdName.setText("");
		cmbBan.setSelectedIndex(-1);
	}
	
	public JTextField getTfStdNo() {
		return tfStdNo;
	}

	public void setTfStdNo(JTextField tfStdNo) {
		this.tfStdNo = tfStdNo;
	}

	public JTextField getTfName() {
		return tfStdName;
	}

	public void setTfName(JTextField tfName) {
		this.tfStdName = tfName;
	}

	public JComboBox<Ban> getCmbBan() {
		return cmbBan;
	}

	public void setCmbBan(JComboBox<Ban> cmbBan) {
		this.cmbBan = cmbBan;
	}
	
	

}
