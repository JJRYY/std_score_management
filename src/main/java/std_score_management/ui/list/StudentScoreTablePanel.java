package std_score_management.ui.list;

import std_score_management.dto.Student;
import std_score_management.service.StudentService;
import std_score_management.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class StudentScoreTablePanel extends AbstractCustomTablePanel<Student> {
	private StudentService service;
	
	@Override
	public void initList() {
		list = service.showStudentScore();
	}
	
	public void setService(StudentService service) {
		this.service = service;
	}

	@Override
	protected void setAlignAndWidth() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] toArray(Student t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "학번", "이름", "국어", "영어", "수학", "사회", "과학"};
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

}
