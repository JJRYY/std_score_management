package std_score_management.ui.list;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.SwingConstants;

import std_score_management.dto.Student;
import std_score_management.dto.StudentScoreAll;
import std_score_management.service.StudentScoreAllService;
import std_score_management.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class StudentScoreTablePanel extends AbstractCustomTablePanel<StudentScoreAll> {
	private StudentScoreAllService service;
	
	@Override
	public void initList() {
		list = service.showStudentScore();
	}
	
	public void setInitList(List<StudentScoreAll> std) {
		list = std;
	}

	public void setService(StudentScoreAllService service) {
		this.service = service;
	}
	
	@Override
	protected void setAlignAndWidth() {
		// 컬럼별 내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
		setTableCellAlign(SwingConstants.RIGHT, 3, 4, 5, 6, 7, 8, 9);

		// 컬럼별 너비 조정
		setTableCellWidth(80, 80, 80, 50, 40, 40, 40, 40, 60, 60);
		
	}
	
	@Override
	public Object[] toArray(StudentScoreAll t) {
		String avg = String.format("%.2f", t.getAvg());
		return new Object[] {
								t.getStdNo().getStdNo(),
								t.getStdName(),
								t.getBanCode(),
								t.getKor(),
								t.getEng(),
								t.getMath(),
								t.getSoc(),
								t.getSci(),
								t.getSum(),
								avg
							};
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"학번", "이름", "분반", "국어", "영어", "수학", "사회", "과학", "총점", "평균"};
	}

	@Override
	public StudentScoreAll getItem() {
		int row = table.getSelectedRow();
		int stdNo = (int) table.getValueAt(row, 0);
		
		if (row == -1) {
			throw new NotSelectedException();
		}
		
		return list.get(list.indexOf(new StudentScoreAll(new Student(stdNo))));
	}

	public void searchStudent(Student std) {
		StudentScoreAll newStd = service.selectStudentScoreByStdNo(std);
		// 조회 버튼을 눌렀을때 해당 학생 행을 찾아가게 함
		int idx = 0;
		for (int i = 0; i < list.size(); i++) {
			if ((int) table.getValueAt(i, 0) == newStd.getStdNo().getStdNo()) {
				idx = i;
				break;
			}
		}
	
		table.setRowSelectionInterval(idx, idx);
		table.scrollRectToVisible(new Rectangle(table.getCellRect(idx, 0, true)));
		
	}
}
