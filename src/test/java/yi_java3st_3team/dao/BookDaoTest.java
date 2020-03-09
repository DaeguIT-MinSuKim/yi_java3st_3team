package yi_java3st_3team.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import yi_java3st_3team.dao.impl.BookDaoImpl;
import yi_java3st_3team.dto.Book;
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.dto.MiddleClassification;
import yi_java3st_3team.dto.PublishingCompany;
import yi_java3st_3team.util.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookDaoTest {
	static BookDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = BookDaoImpl.getInstance();
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
	public void test02SelectBookByCode() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Book book = dao.selectBookByCode(new Book("D100202"));
		if(book.getBookImg() != null) {
			getImgToPic(book.getBookImg(), book.getBookCode());
		}
		Assert.assertNotNull(book);
		LogUtil.prnLog(book);
	}
	
	@Test
	public void test03SelectBookByAll() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Book> lists = dao.selectBookByAll();
		Assert.assertNotEquals(0, lists.size());
//		LogUtil.prnLog(lists);
		for(Book b : lists) LogUtil.prnLog(b);
	}
	
	@Test
	public void test06selectBookByCodeAndCat() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Book bookCode = new Book();
		bookCode.setBookCode("D");
		bookCode.setLcNo(new LargeClassification(10));
		
		List<Book> lists = dao.selectBookByCodeAndCat(bookCode);
		Assert.assertNotEquals(0, lists.size());
		for(Book b : lists) LogUtil.prnLog(b);
	}
	
	@Test
	public void test07selectBookByNameAndCat() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Book book = new Book();
		book.setBookName("북");
		book.setLcNo(new LargeClassification(10));
		
		List<Book> lists = dao.selectBookByNameAndCat(book);
		Assert.assertNotEquals(0, lists.size());
		for(Book b : lists) LogUtil.prnLog(b);
	}
	
	@Test
	public void test08selectBookOnMber() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Book book = new Book();
		book.setBookName("북");
		book.setAuthrName("김");
		book.setLcNo(new LargeClassification(10));
		
		List<Book> lists = dao.selectBookOnMber(book);
		Assert.assertNotEquals(0, lists.size());
		for(Book b : lists) LogUtil.prnLog(b);
	}


	private void getImgToPic(byte[] bookImg, String bookCode) {
		File picsDir = new File(System.getProperty("user.dir") + File.separator + "pics");
		if(!picsDir.exists()) {
			picsDir.mkdir();
		}
		
		File file = new File(picsDir, bookCode + ".jpg");
		try (FileOutputStream fis = new FileOutputStream(file)) {
			fis.write(bookImg);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	@Test
//	public void test01InsertBook() throws ParseException {
//		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//		String inPblicDate = "2020-02-17";
//		String inRegistDate = "2020-02-24";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date pblicteYear = sdf.parse(inPblicDate);
//		Date registDate = sdf.parse(inRegistDate);
//		
//		Book book = new Book("D090101", "먼 바다", "공지영", "", new PublishingCompany(2), pblicteYear, 15800, 0, 0, 
//				new LargeClassification(9), new MiddleClassification(1), registDate, 0);
//		book.setBookImg(getImg("먼 바다.jpg"));
//		LogUtil.prnLog(book);
//		int res = dao.insertBook(book);
//		Assert.assertEquals(1, res);
//	}

	private byte[] getImg(String imgName) {
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir") + File.separator + "images", imgName);
		try (InputStream is = new FileInputStream(file)) {
			pic = new byte[is.available()];
			is.read(pic);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

//	@Test
//	public void test04UpdateBook() throws ParseException {
//		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//		String inPblicDate = "2020-02-17";
//		String inRegistDate = "2020-02-19";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date pblicteYear = sdf.parse(inPblicDate);
//		Date registDate = sdf.parse(inRegistDate);
//		
//		Book book = new Book("D090101", "먼 바다", "공지영", "", new PublishingCompany(2), pblicteYear, 15800, 1, 1, 
//				getImg("먼 바다.jpg"), new LargeClassification(9), new MiddleClassification(1), registDate, 0);
//		int res = dao.updateBook(book);
//		Assert.assertEquals(1, res);
//		LogUtil.prnLog(dao.selectBookByCode(new Book("D090101")));
//	}

//	@Test
//	public void test05DeleteBook() {
//		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//		Book book = new Book("D090101");
//		int res = dao.deleteBook(book);
//		Assert.assertEquals(1, res);
//		LogUtil.prnLog("삭제완료");
//	}

}
