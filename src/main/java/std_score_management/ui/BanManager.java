package std_score_management.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import std_score_management.dto.Ban;
import std_score_management.service.BanService;
import std_score_management.ui.content.BanContentPanel;
import std_score_management.ui.exception.NotSelectedException;
import std_score_management.ui.exception.SqlConstraintException;
import std_score_management.ui.list.BanTablePanel;

@SuppressWarnings("serial")
public class BanManager extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnDel;
	private BanService service;
	private BanContentPanel pContent;
	private BanTablePanel pList;

	public BanManager() {
		service = new BanService();
		initialize();
	}
	
	private void initialize() {
		setTitle("분반 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(460, 100, 300, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pContent = new BanContentPanel();
		contentPane.add(pContent);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		pBtn.add(btnDel);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		pList = new BanTablePanel();
		pList.setService(service);
		pList.loadData();
		contentPane.add(pList);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnDel) {
				actionPerformedBtnDel(e);
			}
			if (e.getSource() == btnAdd) {
				actionPerformedBtnAdd(e);
			}
		} catch (SqlConstraintException | NotSelectedException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		
	}
	
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Ban ban = pContent.getItem();
		service.addBan(ban);
		JOptionPane.showMessageDialog(null, ban + " 추가완료");
		pList.loadData();
		pContent.clearTf();
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clearTf();
		pList.loadData();
	}
	
	protected void actionPerformedBtnDel(ActionEvent e) {
		Ban ban = pList.getItem();
		service.removeBan(ban);
		pList.loadData();
		JOptionPane.showMessageDialog(null, ban + " 삭제완료");
	}
}
