package std_score_management.ui.list;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

import std_score_management.dto.Student;
import std_score_management.service.StudentService;
import std_score_management.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class StudentTablePanel extends AbstractCustomTablePanel<Student> {
	private StudentService service;

	public void setService(StudentService service) {
		this.service = service;
	}	
	public void searchStudent(Student std) {
		Student newStd = service.showStudentByNo(std);
		// 조회 버튼을 눌렀을때 해당 학생 행을 찾아가게 함
		
//		ArrayList<Student> arList = new ArrayList<Student>();
//		arList.addAll(list);
//		int idx = arList.indexOf(newStd);
//		int idx = list.indexOf(newStd);
			
		int idx = 0;
		for (int i = 0; i < list.size(); i++) {
			if ((int) table.getValueAt(i, 0) == newStd.getStdNo()) {
				idx = i;
				break;
			}
		}
	
		table.setRowSelectionInterval(idx, idx);
		table.scrollRectToVisible(new Rectangle(table.getCellRect(idx, 0, true)));
		
	}
	
	@Override
	public void initList() {
		list = service.showStudents();
	}

	@Override
	public Student getItem() {
		int row = table.getSelectedRow();
		int stdNo = (int) table.getValueAt(row, 0);

		if (row == -1) {
			throw new NotSelectedException();
		}

		return list.get(list.indexOf(new Student(stdNo)));
	}

	@Override
	protected void setAlignAndWidth() {
		// 컬럼별 내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);

		// 컬럼별 너비 조정
		setTableCellWidth(60, 60, 60);
	}

	@Override
	public Object[] toArray(Student t) {
		return new Object[] { t.getStdNo(), t.getStdName(), t.getBanCode() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "학번", "이름", "분반" };
	}

}
