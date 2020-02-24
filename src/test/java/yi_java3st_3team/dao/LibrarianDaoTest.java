package yi_java3st_3team.dao;

import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import yi_java3st_3team.dao.impl.LibrarianDaoImpl;
import yi_java3st_3team.dto.Librarian;
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
		Librarian lib = dao.selectLibrarianByNo(new Librarian("iiopio5@book.ff.kr"));
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

		fail("Not yet implemented");
	}

	@Test
	public void test04UpdateLibrarian() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		fail("Not yet implemented");
	}

	@Test
	public void test05DeleteLibrarian() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		fail("Not yet implemented");
	}

}
