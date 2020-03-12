package yi_java3st_3team.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import yi_java3st_3team.dao.impl.LargeClassificationDaoImpl;
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.util.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LargeClassificationDaoTest {
	static LargeClassificationDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = LargeClassificationDaoImpl.getInstace();
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
	public void test02SelectLargeClassificationByNo() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		LargeClassification lc = dao.selectLargeClassificationByNo(new LargeClassification(11));
		Assert.assertNotNull(lc);
		LogUtil.prnLog(lc);
	}

	@Test
	public void test03SelectLargeClassificationByAll() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<LargeClassification> lists = dao.selectLargeClassificationByAll();
		Assert.assertNotEquals(0, lists.size());
		for(LargeClassification lc : lists) LogUtil.prnLog(lc);
	}

	@Test
	public void test01InsertLargeClassification() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = dao.insertLargeClassification(new LargeClassification(11, "테스트"));
		Assert.assertEquals(1, res);
		LogUtil.prnLog(dao.selectLargeClassificationByNo(new LargeClassification(11)));
	}

	@Test
	public void test04UpdateLargeClassification() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = dao.updateLargeClassification(new LargeClassification(11, "테스트대분류"));
		Assert.assertEquals(1, res);
		LogUtil.prnLog(dao.selectLargeClassificationByNo(new LargeClassification(11)));
	}

	@Test
	public void test05DeleteLargeClassification() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = dao.deleteLargeClassification(new LargeClassification(11));
		Assert.assertEquals(1, res);
		LogUtil.prnLog("삭제완료");
	}

}
