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

import yi_java3st_3team.dao.impl.PublishingCompanyDaoImpl;
import yi_java3st_3team.dto.PublishingCompany;
import yi_java3st_3team.util.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PublishingCompanyDaoTest {
	static PublishingCompanyDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = PublishingCompanyDaoImpl.getInstance();
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
	public void test02SelectPublishingCompanyByNo() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		PublishingCompany pls = dao.selectPublishingCompanyByNo(new PublishingCompany(69));
		Assert.assertNotNull(pls);
		LogUtil.prnLog(pls);
	}

	@Test
	public void test03SelectPublishingCompanyByAll() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<PublishingCompany> lists = dao.selectPublishingCompanyByAll();
		Assert.assertNotEquals(0, lists.size());
//		LogUtil.prnLog(lists);
		for(PublishingCompany pls : lists) LogUtil.prnLog(pls);
	}

	@Test
	public void test01InsertPublishingCompany() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		PublishingCompany pls = new PublishingCompany(69, "테스트");
		int res = dao.insertPublishingCompany(pls);
		Assert.assertEquals(1, res);
		LogUtil.prnLog(pls);
	}

	@Test
	public void test04UpdatePublishingCompany() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		PublishingCompany pls = new PublishingCompany(69, "테스트출판사");
		int res = dao.updatePublishingCompany(pls);
		Assert.assertEquals(1, res);
		LogUtil.prnLog(dao.selectPublishingCompanyByNo(new PublishingCompany(69)));
	}

	@Test
	public void test05DeletePublishingCompany() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		PublishingCompany pls = new PublishingCompany(69);
		int res = dao.deletePublishingCompany(pls);
		Assert.assertEquals(1, res);
		LogUtil.prnLog("삭제완료");
	}

}
