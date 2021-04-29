package std_score_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import std_score_management.dto.Login;
import std_score_management.service.LoginService;
import std_score_management.ui.ScoreMain;
import java.awt.Font;

@SuppressWarnings("serial")
public class LoginUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfId;
	private JButton btnLogin;
	private JPasswordField pfPasswd;
	private LoginService service;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginUI() {
		service = new LoginService();
		initialize();
	}
	private void initialize() {
		setTitle("성적관리 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		pBtn.add(btnLogin);
		
		JPanel pContent = new JPanel();
		contentPane.add(pContent, BorderLayout.CENTER);
		pContent.setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("굴림", Font.BOLD, 20));
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		pContent.add(lblId);
		
		tfId = new JTextField();
		pContent.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblPasswd = new JLabel("Password");
		lblPasswd.setFont(new Font("굴림", Font.BOLD, 20));
		lblPasswd.setHorizontalAlignment(SwingConstants.RIGHT);
		pContent.add(lblPasswd);
		
		pfPasswd = new JPasswordField();
		pContent.add(pfPasswd);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			actionPerformedBtnLogin(e);
		}
	}
	protected void actionPerformedBtnLogin(ActionEvent e) {
		String id = tfId.getText().trim();
		char[] pw = pfPasswd.getPassword();
		String passwd = "";
		for (char cha : pw) {
			Character.toString(cha);
			passwd += (passwd.equals("")) ? ""+cha+"" : ""+cha+"";
		}
		
//		System.out.println("id >> " + id + ", pw >> " + passwd);
		Login loginUser = service.selectLoginUser(id, passwd);
		if (loginUser != null) {
			ScoreMain frame = new ScoreMain();
			frame.setVisible(true);
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "아이디와 패스워드를 확인하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			tfId.setText("");
			pfPasswd.setText("");
		}
		
	}
}
