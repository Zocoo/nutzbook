package net.wendal.nutzbook;

import org.nutz.mvc.annotation.ChainBy;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@SetupBy(value = MainSetup.class)
@IocBy(type = ComboIocProvider.class, args = { "*js", "ioc/", "*anno",
		"net.wendal.nutzbook", "*tx",
		"*org.nutz.integration.quartz.QuartzIocLoader" })
@Modules(scanPackage = true)
@Fail("jsp:jsp.500")
@ChainBy(args = "mvc/nutzbook-mvc-chain.js")

public class MainModule
{
}