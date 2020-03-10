package yi_java3st_3team.dao;

import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import yi_java3st_3team.dao.impl.MemberDaoImpl;
import yi_java3st_3team.dto.Member;
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
	public void testSelectMemberByNo() {
//		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//		Member member = dao.selectMemberByNo(new Member(""));
//		if (member.getPic() != null){
//			getImageToPic(emp.getPic(), emp.getEmpNo());// 프로젝트 폴더의 pics폴더에 사원번호.jpg파일이 생성
//		}
//		Assert.assertNotNull(emp);
//		LogUtil.prnLog(emp);
//		
//		//Date를 Calendar 로 변환하여 년/월/일 시/분/초 추출하기
//		LogUtil.prnLog(String.format("%1$tF - %1$tT %1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초 ", emp.getHireDate()));
//		
//		Calendar hire_date = Calendar.getInstance();
//		hire_date.setTime(emp.getHireDate());
		
//		LogUtil.prnLog(String.format("%d 년", hire_date.get(Calendar.YEAR)));
//		LogUtil.prnLog(String.format("%d 월", hire_date.get(Calendar.MONTH) + 1));
//		LogUtil.prnLog(String.format("%d 일", hire_date.get(Calendar.DAY_OF_MONTH)));
//		LogUtil.prnLog(String.format("%d시 %d분 %d초", hire_date.get(Calendar.HOUR_OF_DAY), hire_date.get(Calendar.MINUTE), hire_date.get(Calendar.SECOND)));
	}

	@Test
	public void testSelectMemberByAll() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		fail("Not yet implemented");
	}

	@Test
	public void testInsertMember() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateMember() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMember() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		fail("Not yet implemented");
	}

}
