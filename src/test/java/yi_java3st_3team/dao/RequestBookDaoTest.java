package yi_java3st_3team.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import yi_java3st_3team.dao.impl.RequestBookDaoImpl;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.RequestBook;
import yi_java3st_3team.util.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RequestBookDaoTest {
	static RequestBookDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = RequestBookDaoImpl.getInstance();
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
	public void test02SelectRequestBookByDate() throws ParseException {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//		String selDate = "2020-03";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//		Date getYear = sdf.parse(selDate);
		
		String selDate = "2020";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date getYear = sdf.parse(selDate);
		
		RequestBook rbook = new RequestBook();
		rbook.setRequestDate(getYear);
//		rbook.setWhCdt(1);
//		List<RequestBook> lists = dao.selectRequestBookByYearAndWhCdt(rbook);
//		for(RequestBook rb : lists) LogUtil.prnLog(rb);
	}

	@Test
	public void test03SelectRequestBookByAll() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<RequestBook> lists = dao.selectRequestBookByAll();
		Assert.assertNotEquals(0, lists.size());
		for(RequestBook rb : lists) LogUtil.prnLog(rb);
	}

	@Test
	public void test04SelectRequestBookById() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		RequestBook rbId = new RequestBook();
		rbId.setRequestMbId(new Member("ggg243r4@gmail.com"));
		List<RequestBook> lists = dao.selectRequestBookById(rbId);
		Assert.assertNotEquals(0, lists.size());
		for(RequestBook rb : lists) LogUtil.prnLog(rb);
	}

//	@Test
//	public void test01InsertRequestBook() {
//		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//		Calendar c = Calendar.getInstance();
//		Date requestDate = new Date(c.getTimeInMillis());
//		
//		RequestBook rb = new RequestBook(new Member("ggg243r4@gmail.com"), "Java의 정석", "남궁성", "", "도우출판", requestDate, 0);
//		LogUtil.prnLog(rb);
//		int res = dao.insertRequestBook(rb);
//		Assert.assertEquals(1, res);
//		List<RequestBook> lists = dao.selectRequestBookByAll();
//		for(RequestBook rbAll : lists) LogUtil.prnLog(rbAll);
//	}
//
//	@Test
//	public void test05UpdateRequestBook() {
//		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//		Calendar c = Calendar.getInstance();
//		Date requestDate = new Date(c.getTimeInMillis());
//		
//		RequestBook rb = new RequestBook(11, new Member("ggg243r4@gmail.com"), "이것이 자바다", "신용권", "", "한빛미디어", requestDate, 0);
//		LogUtil.prnLog(rb);
//		int res = dao.updateRequestBook(rb);
//		Assert.assertEquals(1, res);
//		List<RequestBook> lists = dao.selectRequestBookByAll();
//		for(RequestBook rbAll : lists) LogUtil.prnLog(rbAll);
//	}
//
//	@Test
//	public void test06DeleteRequestBook() {
//		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//		int res = dao.deleteRequestBook(new RequestBook(11));
//		Assert.assertEquals(1, res);
//		LogUtil.prnLog("삭제성공");
//		List<RequestBook> lists = dao.selectRequestBookByAll();
//		for(RequestBook rbAll : lists) LogUtil.prnLog(rbAll);
//	}

}
