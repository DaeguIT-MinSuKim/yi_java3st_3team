package yi_java3st_3team.dao;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import yi_java3st_3team.dao.impl.RecommendationDaoImpl;
import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.Recommendation;
import yi_java3st_3team.util.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RecommendationDaoTest {
	static RecommendationDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = RecommendationDaoImpl.getInstance();
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
	public void test01SelectRecommendationByNo() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Recommendation recom = dao.selectRecommendationByLastNo();
		Assert.assertNotNull(recom);
		LogUtil.prnLog(recom);
		LogUtil.prnLog("추천도서번호 : "+recom.getRecomBookNo());
		LogUtil.prnLog("도서코드 : "+recom.getBookCode().getBookCode());
		LogUtil.prnLog("추천도서줄거리 : "+recom.getBookCont());
		LogUtil.prnLog("대분류 : "+recom.getBookCode().getLcNo().getLclasName());
		LogUtil.prnLog("중분류 : "+recom.getBookCode().getMlNo().getMlsfcName());
		LogUtil.prnLog("작가 : "+recom.getBookCode().getAuthrName());
		LogUtil.prnLog("역자 : "+recom.getBookCode().getTrnslrName());
		LogUtil.prnLog("도서명 : "+recom.getBookCode().getBookName());
		LogUtil.prnLog("출판사 : "+recom.getBookCode().getPls().getPlsName());
		LogUtil.prnLog("도서 이미지 : "+recom.getBookCode().getBookImg());
	}

	@Test
	public void test02SelectRecommendationByBookCode() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Recommendation recom = dao.selectRecommendationByBookCode(new Recommendation(new Book("A090102")));
		//Assert.assertNotNull(recom);
		LogUtil.prnLog(recom);
	}

	@Test
	public void test03InsertRecommendation() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = dao.insertRecommendation(new Recommendation(new Book("A090103"), "도서소개 테스트3....!!!"));
		Assert.assertEquals(1, res);
		LogUtil.prnLog(dao.selectRecommendationByLastNo());
	}

	@Test
	public void test04UpdateRecommendation() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = dao.updateRecommendation(new Recommendation(new Book("A090103"), "[수정]도서소개 테스트3"));
		Assert.assertEquals(1, res);
		LogUtil.prnLog(dao.selectRecommendationByLastNo());
	}

	@Test
	public void test05DeleteRecommendation() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = dao.deleteRecommendation(new Recommendation(new Book("A090103")));
		Assert.assertEquals(1, res);
		LogUtil.prnLog(dao.selectRecommendationByLastNo());
	}
}
