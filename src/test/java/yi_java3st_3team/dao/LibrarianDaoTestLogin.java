package yi_java3st_3team.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import yi_java3st_3team.dao.impl.LibrarianDaoImpl;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.util.LogUtil;

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
	public void test() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Librarian loginLibrarian = dao.loginLibrarian(new Librarian("43ojlkjl@book.ff.kr", "fjgfkdlj6"));
		Assert.assertNotNull(loginLibrarian);
		LogUtil.prnLog(loginLibrarian);
	}

}
