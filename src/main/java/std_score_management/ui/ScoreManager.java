package std_score_management.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
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
import std_score_management.ui.exception.SqlConstraintException;
import std_score_management.ui.exception.StdNotExistException;
import std_score_management.ui.list.StudentScoreTablePanel;
import std_score_management.ui.list.StudentTablePanel;

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
	private JButton btnUpdate;
	private StudentTablePanel stdTable;
	private JPanel panel;
	private ScoreInputPanel pScoreInput;
	private StudentScoreTablePanel pList;
	
	public void setStdTable(StudentTablePanel stdTable) {
		this.stdTable = stdTable;
	}
	
	public ScoreManager() {
		service = new StudentScoreAllService();
		scoreService = new ScoreService();
		stdService = new StudentService();
		initialize();
	}
	private void initialize() {
		setTitle("성적 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(460, 100, 630, 503);
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
		btnUpdate.addActionListener(this);
		pSouth.add(btnUpdate);
		pSouth.add(btnDelete);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pSouth.add(btnCancel);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 2, 0, 0));
		
		pStd = new StdSimplePanel();
		pStd.setService(service);
		pStd.getTfName().setEditable(false);
		pStd.getCmbBan().setEnabled(false);
		pNorth.add(pStd);
		
		JPanel pBtn = new JPanel();
		pBtn.setBorder(new EmptyBorder(15, 30, 10, 150));
		pNorth.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 1, 10, 10));
		
		btnSel = new JButton("조회");
		btnSel.addActionListener(this);
		pBtn.add(btnSel);
		
		btnStdInfo = new JButton("학생상세정보");
		btnStdInfo.setVisible(false);
		pBtn.add(btnStdInfo);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 0, 0, 5));
		
		pScoreInput = new ScoreInputPanel();
		panel.add(pScoreInput);
		
		pList = new StudentScoreTablePanel();
		pList.setService(service);
		pList.loadData();
		panel.add(pList);
		pList.getTable().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JTable table = (JTable) e.getSource();
				int row = table.getSelectedRow();
				int stdNo = (int) table.getValueAt(row, 0);
				
				Student newStd = stdService.showStudentByNo(new Student(stdNo));
				pStd.setItem(newStd);
				
				StudentScoreAll score = service.selectStudentScoreByStdNo(newStd);
				pScoreInput.setItem(score);
			}
		});
	}
	
	public void setStdItem(Student std) {
		pStd.setItem(std);
	}
	
	public void setScoreItem(Student std) {
		StudentScoreAll newScore = service.selectStudentScoreByStdNo(std);
		pScoreInput.setItem(newScore);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnDelete) {
				actionPerformedBtnDelete(e);
			}
			if (e.getSource() == btnCancel) {
				actionPerformedBtnCancel(e);
			}
			if (e.getSource() == btnInput) {
				actionPerformedBtnInput(e);
			}
			if (e.getSource() == btnUpdate) {
				actionPerformedBtnUpdate(e);
			}
			if (e.getSource() == btnSel) {
				actionPerformedBtnSel(e);
			}
		} catch (InvalidCheckException | ScoreNotExistException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			pScoreInput.clearTf();
		} catch (StdNotExistException | SqlConstraintException e1) {
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
		
		pList.searchStudent(newStd);
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pStd.clearTf();
		pScoreInput.clearTf();
	}
	
	protected void actionPerformedBtnInput(ActionEvent e) {
		Student newStd = pStd.getItem();
		Score score = new Score(newStd);
		
		List<Score> scoreList = scoreService.showScoreByNo(score);
		if (scoreList == null) {
			StudentScoreAll newScore = pScoreInput.getItem();
			int kor = newScore.getKor();
			int eng = newScore.getEng();
			int math = newScore.getMath();
			int soc = newScore.getSoc();
			int sci = newScore.getSci();
			
			Score korScore = new Score(newStd, new Subject(101), kor);
			scoreService.addScore(korScore);
			Score engScore = new Score(newStd, new Subject(201), eng);
			scoreService.addScore(engScore);
			Score mathScore = new Score(newStd, new Subject(301), math);
			scoreService.addScore(mathScore);
			Score socScore = new Score(newStd, new Subject(401), soc);
			scoreService.addScore(socScore);
			Score sciScore = new Score(newStd, new Subject(501), sci);
			scoreService.addScore(sciScore);
		} else {
			throw new SqlConstraintException();
		}
		
		JOptionPane.showMessageDialog(null, "추가완료");
		pStd.clearTf();
		pScoreInput.clearTf();
		if (stdTable != null) {
			stdTable.loadData();
		}
		pList.loadData();
		
	}
	protected void actionPerformedBtnDelete(ActionEvent e) {
		Student newStd = pStd.getItem();
		Score score = new Score(newStd);
		
		scoreService.removeScore(score);
		
		JOptionPane.showMessageDialog(null, "삭제완료");
		pStd.clearTf();
		pScoreInput.clearTf();
		if (stdTable != null) {
			stdTable.loadData();
		}
		pList.loadData();
	}
	
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Student newStd = pStd.getItem();
		
		StudentScoreAll newScore = pScoreInput.getItem();
		int kor = newScore.getKor();
		int eng = newScore.getEng();
		int math = newScore.getMath();
		int soc = newScore.getSoc();
		int sci = newScore.getSci();
		
		Score korScore = new Score(newStd, new Subject(101), kor);
		scoreService.updateScore(korScore);
		Score engScore = new Score(newStd, new Subject(201), eng);
		scoreService.updateScore(engScore);
		Score mathScore = new Score(newStd, new Subject(301), math);
		scoreService.updateScore(mathScore);
		Score socScore = new Score(newStd, new Subject(401), soc);
		scoreService.updateScore(socScore);
		Score sciScore = new Score(newStd, new Subject(501), sci);
		scoreService.updateScore(sciScore);
		
		JOptionPane.showMessageDialog(null, "수정완료");
		pStd.clearTf();
		pScoreInput.clearTf();
		pList.loadData();
	}
}
