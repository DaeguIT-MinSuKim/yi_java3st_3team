package yi_java3st_3team.dao;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.mysql.jdbc.log.Log;

import yi_java3st_3team.dao.impl.MemberDaoImpl;
import yi_java3st_3team.dto.Grade;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.ZipCode;
import yi_java3st_3team.util.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDaoTest {
	static MemberDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = MemberDaoImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = null;
	}

	@Test
	public void test01SelectMemberByNo() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = dao.selectMemberByNo(new Member("ssdfr@daum.net"));
		if(member.getMberImg() != null) {
			getImageToPic(member.getMberImg(),member.getMberId()); //프로젝트 폴더의 pics 폴더에 사원아이디.jpg 파일이 생성된다
		}
		Assert.assertNotNull(member);
		LogUtil.prnLog(String.format("%1$tF - %1tT %1$tY년 %1$tm월 %1$td일 ", member.getJoinDt()));
		LogUtil.prnLog(String.format("%1$tF - %1tT %1$tY년 %1$tm월 %1$td일 ", member.getMberBrthdy()));
		
		Calendar joinDate = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		joinDate.setTime(member.getJoinDt());
		birthday.setTime(member.getMberBrthdy());
		
		LogUtil.prnLog(String.format("%d 년", joinDate.get(Calendar.YEAR)));
		LogUtil.prnLog(String.format("%d 월", joinDate.get(Calendar.MONTH)+1));
		LogUtil.prnLog(String.format("%d 일", joinDate.get(Calendar.DAY_OF_MONTH)));
		
		LogUtil.prnLog(String.format("%d 년", birthday.get(Calendar.YEAR)));
		LogUtil.prnLog(String.format("%d 월", birthday.get(Calendar.MONTH)+1));
		LogUtil.prnLog(String.format("%d 일", birthday.get(Calendar.DAY_OF_MONTH)));
	}

	

	@Test
	public void test02SelectMemberByAll() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Member> list = dao.selectMemberByAll();
		Assert.assertNotEquals(0, list.size());
		LogUtil.prnLog(list);
	}

	@Test
	public void test03InsertMember() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Calendar c= Calendar.getInstance();
		Date birthday = new Date(c.getTimeInMillis());
		Date joinDate = new Date(c.getTimeInMillis());
		
		Member member = new Member("bus503@daum.net", "xodnjs", "황태원", birthday, new ZipCode(42457), "대구광역시 북구 태전로", "루존 202호", "010-4245-3825", 100, 2, new Grade(1), 1, joinDate, 1);
		member.setMberImg(getImage("lyy.jpg"));
		LogUtil.prnLog(member);
		int res = dao.insertMember(member);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04UpdateMember() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("bus503@daum.net", "xodnjs", "장수황씨", new Date(), new ZipCode(42457), "대구광역시 북구 태전로", "루존 202호", "010-4245-3825", 100, 2, new Grade(1), 1, new Date(), 1);
		int res = dao.updateMember(member);
		Assert.assertEquals(1, res);
		LogUtil.prnLog(member);
	}

	@Test
	public void test05DeleteMember() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("bus503@daum.net");
		int res = dao.deleteMember(member);
		Assert.assertEquals(1, res);
		LogUtil.prnLog(member);
	}
	
	private byte[] getImage(String ImgName) {
		byte[] image = null;
		File file = new File(System.getProperty("user.dir")+File.separator+"images",ImgName);
		try(InputStream is = new FileInputStream(file)){
			image = new byte[is.available()];
			is.read(image);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	private void getImageToPic(byte[] mberImg, String mberId) {
		File picsDir = new File(System.getProperty("user.dir") + File.separator + "pics");
		if (!picsDir.exists()) {
			picsDir.mkdir();
		}
		
		File file = new File(picsDir, mberId +".jpg");
		try(FileOutputStream save = new FileOutputStream(file)){
			save.write(mberImg);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
