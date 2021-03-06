package net.wendal.nutzbook;

import java.util.Date;

import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.integration.quartz.NutQuartzCronJobFactory;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import net.wendal.nutzbook.bean.User;

public class MainSetup implements Setup
{

	public void init(NutConfig conf)
	{
		Ioc ioc = conf.getIoc();
		Dao dao = ioc.get(Dao.class);
		Daos.createTablesInPackage(dao, "net.wendal.nutzbook", false);
		ioc.get(NutQuartzCronJobFactory.class);
		// 初始化默认根用户
		System.out.println("1====>" + System.currentTimeMillis());
		try
		{
			Thread.sleep(1000L);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1====>" + System.currentTimeMillis());
		if (dao.count(User.class) == 0)
		{
			User user = new User();
			user.setName("admin");
			user.setPassword("123456");
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			dao.insert(user);
		}
	}

	public void destroy(NutConfig conf)
	{
	}

}