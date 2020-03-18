package yi_java3st_3team.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import yi_java3st_3team.dao.impl.LibrarianDaoImpl;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Title;
import yi_java3st_3team.dto.ZipCode;
import yi_java3st_3team.util.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LibrarianDaoTest {
	static LibrarianDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = LibrarianDaoImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = null;
	}


	@Test
	public void test01SelectLibrarianByNo() {
		//이름 지은건 No인데 id를 기준으로 잡는다
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Librarian lib = dao.selectLibrarianById(new Librarian("iiopio5@book.ff.kr"));
		Assert.assertNotNull(lib);
		LogUtil.prnLog(String.format("%1$tF - %1tT %1$tY년 %1$tm월 %1$td일 ", lib.getJoinDate()));
		
		Calendar joinDate = Calendar.getInstance();
		joinDate.setTime(lib.getJoinDate());
		
		LogUtil.prnLog(String.format("%d 년", joinDate.get(Calendar.YEAR)));
		LogUtil.prnLog(String.format("%d 월", joinDate.get(Calendar.MONTH)+1));
		LogUtil.prnLog(String.format("%d 일", joinDate.get(Calendar.DAY_OF_MONTH)));
		
	}

	@Test
	public void test02SelectLibrarianByAll() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Librarian> list = dao.selectLibrarianByAll();
		Assert.assertNotEquals(0, list.size());
		LogUtil.prnLog(list);
		
	}

	@Test
	public void test03InsertLibrarian() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Calendar c = Calendar.getInstance();
		Date birthDay = new Date(c.getTimeInMillis());
		Date joinDate = new Date(c.getTimeInMillis());
		
		Librarian lib = new Librarian("hwangbug@book.ff.kr", "bug", "황충", birthDay, new ZipCode(42457), "대구광역시 북구 태전로", null, "010-4432-4141", null, new Title(0), joinDate, 0);
		LogUtil.prnLog(lib);
		int res = dao.insertLibrarian(lib);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04UpdateLibrarian() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Librarian lib = new Librarian("hwangbug@book.ff.kr", "bug", "황희정승", new Date(), new ZipCode(42457), "대구광역시 북구 태전로", null, "010-4432-4141", null, new Title(0), new Date(), 0);
		int res = dao.updateLibrarian(lib);
		Assert.assertEquals(1, res);
		LogUtil.prnLog(lib);
	}

	@Test
	public void test05DeleteLibrarian() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Librarian lib = new Librarian("hwangbug@book.ff.kr");	
		int res = dao.deleteLibrarian(lib);
		Assert.assertEquals(1, res);
		LogUtil.prnLog(lib);
	}

}
