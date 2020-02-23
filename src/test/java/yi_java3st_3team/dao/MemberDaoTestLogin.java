package yi_java3st_3team.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import yi_java3st_3team.dao.impl.MemberDaoImpl;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.util.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDaoTestLogin {
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

	@Before
	public void setUp() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	}

	@After
	public void tearDown() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	}

	@Test
	public void test01LoginMember() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member loginMember = dao.loginMember(new Member("daddystop@gmail.com", "airopwieop3678"));
		Assert.assertNotNull(loginMember);
		LogUtil.prnLog(loginMember);
	}

	@Test
	public void test02FindMemberId() throws ParseException {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		String brthdy = "1984-08-04";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date mberBrthdy = sdf.parse(brthdy);
		
		Member findMemberId = dao.findMemberId(new Member("이전", mberBrthdy));
		Assert.assertNotNull(findMemberId);
		LogUtil.prnLog(findMemberId);
	}

	@Test
	public void test03ResetMemberPw() throws ParseException {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		String brthdy = "1984-08-04";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date mberBrthdy = sdf.parse(brthdy);
		
		Member ResetMemberPw = dao.findMemberPw(new Member("daddystop@gmail.com", "이전", mberBrthdy));
		Assert.assertNotNull(ResetMemberPw);
		LogUtil.prnLog(ResetMemberPw);
	}

}
