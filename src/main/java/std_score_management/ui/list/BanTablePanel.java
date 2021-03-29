package std_score_management.ui.list;

import javax.swing.SwingConstants;

import std_score_management.dto.Ban;
import std_score_management.service.BanService;
import std_score_management.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class BanTablePanel extends AbstractCustomTablePanel<Ban> {
	public BanTablePanel() {
	}
	private BanService service;
	
	@Override
	public Ban getItem() {
		int row = table.getSelectedRow();
		if (row == -1) {
			throw new NotSelectedException();
		}
		
		String banCode = (String) table.getValueAt(row, 0);
		
		return list.get(list.indexOf(new Ban(banCode)));
	}

	@Override
	public void initList() {
		list = service.showBans();
	}

	@Override
	protected void setAlignAndWidth() {
		// 컬럼별 내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0);

		// 컬럼별 너비 조정
		setTableCellWidth(100);		
	}

	@Override
	public Object[] toArray(Ban t) {
		return new Object[] { t.getBanCode() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "분반" };
	}
	
	public void setService(BanService service) {
		this.service = service;
	}


}
