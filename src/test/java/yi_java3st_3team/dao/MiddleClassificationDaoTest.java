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

import yi_java3st_3team.dao.impl.MiddleClassificationDaoImpl;
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.dto.MiddleClassification;
import yi_java3st_3team.util.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MiddleClassificationDaoTest {
	static MiddleClassificationDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = MiddleClassificationDaoImpl.getInstance();
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
	public void test02SelectMiddleClassificationByNo() {
		MiddleClassification ml = dao.selectMiddleClassificationByNo(new MiddleClassification(new LargeClassification(10), 03));
		Assert.assertNotNull(ml);
		LogUtil.prnLog(ml);
	}

	@Test
	public void test03SelectMiddleClassificationByAll() {
		List<MiddleClassification> lists = dao.selectMiddleClassificationByAll();
		Assert.assertNotEquals(0, lists.size());
		for(MiddleClassification ml : lists) LogUtil.prnLog(ml);
	}

	@Test
	public void test01InsertMiddleClassification() {
		MiddleClassification mlsfc = new MiddleClassification(new LargeClassification(10), 3, "테스트분류");
		int res = dao.insertMiddleClassification(mlsfc);
		Assert.assertEquals(1, res);
		LogUtil.prnLog(mlsfc);
	}

	@Test
	public void test04UpdateMiddleClassification() {
		MiddleClassification mlsfc = new MiddleClassification(new LargeClassification(10), 3, "테스트 중분류");
		int res = dao.updateMiddleClassification(mlsfc);
		Assert.assertEquals(1, res);
		LogUtil.prnLog(mlsfc);
	}

	@Test
	public void test05DeleteMiddleClassification() {
		MiddleClassification mlsfc = new MiddleClassification(new LargeClassification(10), 3);
		int res = dao.deleteMiddleClassification(mlsfc);
		Assert.assertEquals(1, res);
		LogUtil.prnLog(mlsfc + "\n 삭제완료");
	}

}
