package std_score_management.ui.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import std_score_management.dto.Ban;
import std_score_management.ui.exception.InvalidCheckException;

@SuppressWarnings("serial")
public class BanContentPanel extends JPanel {
	private JTextField tfBanCode;

	public BanContentPanel() {
		
		initialize();
	}
	
	private void initialize() {
		setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblBanCode = new JLabel("분반");
		lblBanCode.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblBanCode);
		
		tfBanCode = new JTextField();
		add(tfBanCode);
		tfBanCode.setColumns(10);
	}
	
	public void clearTf() {
		tfBanCode.setText("");
	}
	
	public void setItem(Ban item) {
		tfBanCode.setText(item.getBanCode() + "");
	}

	public Ban getItem() {
		validCheck();
		String banCode = tfBanCode.getText().trim();
		
		return new Ban(banCode);
	}

	private void validCheck() {
		if(tfBanCode.getText().equals("")) {
			throw new InvalidCheckException();
		}
		
	}
}
