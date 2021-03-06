package yi_java3st_3team.ui.service;

import yi_java3st_3team.dao.BookDao;
import yi_java3st_3team.dao.LendingDao;
import yi_java3st_3team.dao.MemberDao;
import yi_java3st_3team.dao.impl.BookDaoImpl;
import yi_java3st_3team.dao.impl.LendingDaoImpl;
import yi_java3st_3team.dao.impl.MemberDaoImpl;

public class StatisticUIService {
	private LendingDao lendingDao;
	private BookDao bookDao;
	private MemberDao memberDao;
	public StatisticUIService() {
		lendingDao = LendingDaoImpl.getInstance();
		bookDao = BookDaoImpl.getInstance();
		memberDao = MemberDaoImpl.getInstance();
	}
	public int selectAvgRendDate() {
		return lendingDao.selectAvgRendDate();
	}
	public int selectLendableBooks() {
		return bookDao.selectLendableBooks();
	}
	public int selectDuringLendBooks() {
		return bookDao.selectDuringLendBooks();
	}
	public int selectTotalBooks() {
		return bookDao.selectTotalBooks();
	}
	public int selectDisposalBooks() {
		return bookDao.selectDisposalBooks();
	}
	public int[] selectCountByCate() {
		return bookDao.selectCountByCate();
	}
	public int[] selectMemberCounts() {
		return memberDao.selectMemberCounts();
	}
}

