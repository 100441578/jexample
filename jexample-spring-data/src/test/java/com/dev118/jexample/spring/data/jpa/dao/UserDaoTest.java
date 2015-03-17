package com.dev118.jexample.spring.data.jpa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.dev118.jexample.spring.data.SpringJunitJpaTest;
import com.dev118.jexample.spring.data.jpa.entity.User;
import com.dev118.jexample.spring.data.jpa.entity.UserDetail;
import com.dev118.jexample.spring.data.jpa.entity.type.SexType;
import com.dev118.jexample.spring.data.jpa.entity.type.UserCategoryType;
import com.dev118.jexample.spring.data.jpa.entity.type.UserStateType;

/**
 * UserDao测试类
 * 
 * @author Wen
 *
 */
public class UserDaoTest extends SpringJunitJpaTest {

	@Autowired
	private UserDao userDao;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	public void init() {

		List<User> users = new ArrayList<User>();
		users.add(new User("admin", "admin", UserCategoryType.SYSTEM, UserStateType.ENABLE));
		//
		for (int i = 0; i < 100; i++) {
			users.add(new User("admin" + i, "123", UserCategoryType.SYSTEM, (i % 2) == 0 ? UserStateType.ENABLE : UserStateType.DISABLE));
		}
		userDao.save(users);
		System.out.println(userDao.count());
	}

	@Test
	public void testSave() {
		UserDetail userDetail = new UserDetail("张三", SexType.FEMALE, new Date());

		User user = new User("zhangsan", "123", UserCategoryType.NORMAL, UserStateType.ENABLE);
		user.setUserDetail(userDetail);
		// User 中 需要配置cascade才可以级联保存
		userDao.save(user);
	}

	@Test
	public void testRemove() {

		User user = userDao.findByUsername("zhangsan");
		userDao.delete(user);
	}

	@Test
	public void testPageable() {
		// 排序
		Sort sort = new Sort(Sort.Direction.DESC, "username");
		// 分页
		PageRequest pageRequest = new PageRequest(0, 20, sort);

		Page<User> page = userDao.findByUserCategoryType(UserCategoryType.SYSTEM, pageRequest);

		System.out.println(page.getSize());
		System.out.println(page.getContent());
	}
}
