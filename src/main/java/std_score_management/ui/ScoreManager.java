package std_score_management.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import std_score_management.dto.Score;
import std_score_management.dto.Student;
import std_score_management.dto.StudentScoreAll;
import std_score_management.dto.Subject;
import std_score_management.service.ScoreService;
import std_score_management.service.StudentScoreAllService;
import std_score_management.service.StudentService;
import std_score_management.ui.content.ScoreInputPanel;
import std_score_management.ui.content.StdSimplePanel;
import std_score_management.ui.exception.InvalidCheckException;
import std_score_management.ui.exception.ScoreNotExistException;
import std_score_management.ui.exception.StdNotExistException;

@SuppressWarnings("serial")
public class ScoreManager extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSel;
	private JButton btnStdInfo;
	private StudentScoreAllService service;
	private ScoreService scoreService;
	private StudentService stdService;
	private StdSimplePanel pStd;
	private JButton btnInput;
	private JButton btnDelete;
	private JButton btnCancel;
	private ScoreInputPanel pScoreInput;
	private JButton btnUpdate;

	public ScoreManager() {
		service = new StudentScoreAllService();
		scoreService = new ScoreService();
		stdService = new StudentService();
		initialize();
	}
	private void initialize() {
		setTitle("성적 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 630, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
		
		btnInput = new JButton("입력");
		btnInput.addActionListener(this);
		pSouth.add(btnInput);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		
		btnUpdate = new JButton("수정");
		pSouth.add(btnUpdate);
		pSouth.add(btnDelete);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pSouth.add(btnCancel);
		
		pScoreInput = new ScoreInputPanel();
		contentPane.add(pScoreInput, BorderLayout.CENTER);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 2, 0, 0));
		
		pStd = new StdSimplePanel();
		pStd.setService(service);
		pNorth.add(pStd);
		
		JPanel pBtn = new JPanel();
		pBtn.setBorder(new EmptyBorder(15, 30, 10, 150));
		pNorth.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 1, 10, 10));
		
		btnSel = new JButton("조회");
		btnSel.addActionListener(this);
		pBtn.add(btnSel);
		
		btnStdInfo = new JButton("학생상세정보");
		pBtn.add(btnStdInfo);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDelete) {
			actionPerformedBtnDelete(e);
		}
		if (e.getSource() == btnInput) {
			actionPerformedBtnInput(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		try {
			if (e.getSource() == btnSel) {
				actionPerformedBtnSel(e);
			}
		} catch (InvalidCheckException | ScoreNotExistException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			pScoreInput.clearTf();
		} catch (StdNotExistException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			pStd.clearTf();
			pScoreInput.clearTf();
		}
	}
	
	protected void actionPerformedBtnSel(ActionEvent e) {
		Student newStd = pStd.getItem();
		Student newStd2 = stdService.showStudentByNo(newStd);
		pStd.setItem(newStd2);
		
		StudentScoreAll newScore = service.selectStudentScoreByStdNo(newStd);
		pScoreInput.setItem(newScore);
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pStd.clearTf();
		pScoreInput.clearTf();
	}
	
	protected void actionPerformedBtnInput(ActionEvent e) {
		Student newStd = pStd.getItem();
		
		if(!pScoreInput.getTfKor().getText().equals("")) {
			int kor = Integer.parseInt(pScoreInput.getTfKor().getText().trim());
			Score korScore = new Score(newStd, new Subject(101), kor);
			scoreService.addScore(korScore);
		}
		if(!pScoreInput.getTfEng().getText().equals("")) {
			int eng =  Integer.parseInt(pScoreInput.getTfEng().getText().trim());
			Score engScore = new Score(newStd, new Subject(201), eng);
			scoreService.addScore(engScore);
		}
		if(!pScoreInput.getTfMath().getText().equals("")) {
			int math =  Integer.parseInt(pScoreInput.getTfMath().getText().trim());
			Score mathScore = new Score(newStd, new Subject(301), math);
			scoreService.addScore(mathScore);
		}
		if(!pScoreInput.getTfSoc().getText().equals("")) {
			int soc =  Integer.parseInt(pScoreInput.getTfSoc().getText().trim());
			Score socScore = new Score(newStd, new Subject(401), soc);
			scoreService.addScore(socScore);
		}
		if(!pScoreInput.getTfSci().getText().equals("")) {
			int sci =  Integer.parseInt(pScoreInput.getTfSci().getText().trim());
			Score sciScore = new Score(newStd, new Subject(501), sci);
			scoreService.addScore(sciScore);
		}
		
		JOptionPane.showMessageDialog(null, "추가완료");
		pStd.clearTf();
		pScoreInput.clearTf();
		
	}
	protected void actionPerformedBtnDelete(ActionEvent e) {
		Student newStd = pStd.getItem();
		Score score = new Score(newStd);
		
		scoreService.removeScore(score);
		
		JOptionPane.showMessageDialog(null, "삭제완료");
		pStd.clearTf();
		pScoreInput.clearTf();
	}
}
