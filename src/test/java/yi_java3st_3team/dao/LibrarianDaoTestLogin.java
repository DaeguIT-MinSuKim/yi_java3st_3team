package yi_java3st_3team.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import yi_java3st_3team.dao.impl.LibrarianDaoImpl;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.util.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LibrarianDaoTestLogin {
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

	@Before
	public void setUp() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	}

	@After
	public void tearDown() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	}

	@Test
	public void test01LoginLibrarian() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Librarian loginLibrarian = dao.loginLibrarian(new Librarian("43ojlkjl@book.ff.kr", "fjgfkdlj6"));
		Assert.assertNotNull(loginLibrarian);
		LogUtil.prnLog(loginLibrarian);
	}

	@Test
	public void test02FindLibrarianId() throws ParseException {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		String birthday = "1961-12-31";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date lbBirthDay = sdf.parse(birthday);
		
		Librarian findLibrarianId = dao.findLibrarianId(new Librarian("원소", lbBirthDay));
		Assert.assertNotNull(findLibrarianId);
		LogUtil.prnLog(findLibrarianId);
	}

	@Test
	public void test03ResetLibrarianPw() throws ParseException {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		String birthday = "1961-12-31";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date lbBirthDay = sdf.parse(birthday);
		
		Librarian ResetLibrarianPw = dao.findLibrarianPw(new Librarian("43ojlkjl@book.ff.kr", "원소", lbBirthDay));
		Assert.assertNotNull(ResetLibrarianPw);
		LogUtil.prnLog(ResetLibrarianPw);
	}

}
