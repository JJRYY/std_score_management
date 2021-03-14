package std_score_management.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import std_score_management.dao.BanDao;
import std_score_management.dto.Ban;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BanDaoImplTest {
	private static BanDao dao = BanDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test03SelectBanByAll() {
		System.out.printf("%s()%n", "testSelectBanByAll");
		List<Ban> banList = dao.selectBanByAll();
		Assert.assertNotNull(banList);
		for (Ban b : banList) {
			System.out.println(b);
		}
	}

	@Test
	public void test04SelectBanByCode() {
		System.out.printf("%s()%n", "testSelectBanByCode");
		Ban ban = new Ban("A02");
		Ban searchBan = dao.selectBanByCode(ban);
		Assert.assertNotNull(searchBan);
		System.out.println(searchBan);
	}

	@Test
	public void test01InsertBan() {
		System.out.printf("%s()%n", "testInsertBan");
		Ban newBan = new Ban("B02");
		int res = dao.insertBan(newBan);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectBanByCode(newBan));
	}

	@Test
	public void test02DeleteBan() {
		System.out.printf("%s()%n", "testDeleteBan");
		Ban newBan = new Ban("B02");
		int res = dao.deleteBan(newBan);
		Assert.assertEquals(1, res);
		dao.selectBanByAll().stream().forEach(System.out::println);
	}

}
