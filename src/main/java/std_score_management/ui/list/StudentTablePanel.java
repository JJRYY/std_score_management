package std_score_management.ui.list;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import std_score_management.dto.Student;
import std_score_management.service.StudentService;
import std_score_management.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class StudentTablePanel extends AbstractCustomTablePanel<Student> {
	private StudentService service;

	public void setService(StudentService service) {
		this.service = service;
	}	
	public void setList(Student std) {
		Student newStd = service.showStudentByNo(std);
		// 선택될 index 찾아서 넣기
		// 다르게 정렬되면 못찾아감
		// List에서 valueAt으로 index 찾아서 
		table.setRowSelectionInterval(index0, index0);
		ArrayList<Student> arList = list;
		
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
