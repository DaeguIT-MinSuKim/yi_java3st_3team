package yi_java3st_3team.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import yi_java3st_3team.dao.impl.BookDaoImpl;
import yi_java3st_3team.dao.impl.LendingDaoImpl;
import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.util.LogUtil;

public class LendingDaoTest {
	static LendingDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = LendingDaoImpl.getInstance();
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
		LogUtil.prnLog("\n");
	}

	@Test
	public void testUpdateLendingByCodeAndMberId() throws ParseException {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		String date = "2020-03-04";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date resDate = sdf.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(resDate);
		cal.add(Calendar.DATE, 10);
		Date RturnDueDate = cal.getTime();
		
		Lending update = new Lending();
		update.setBookCd(new Book("A090253"));
		update.setMberId(new Member("fivestar@nate.com"));
		update.setRturnPsmCdt(1);
		update.setRturnDueDate(RturnDueDate);
		int res = dao.updateLendingByCodeAndMberId(update);
		Assert.assertEquals(1, res);
		LogUtil.prnLog(res);
	}

}
