package github.haozi.nutzbook;

import org.nutz.mvc.annotation.*;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * @author wanghao
 * @Description
 * @date 2019-07-17 10:58
 */
@SetupBy(MainSetup.class)
@IocBy(type = ComboIocProvider.class, args = {"*js", "ioc/",
        "*anno", "github.haozi.nutzbook",
        "*tx", // 事务拦截 aop
        "*async"}) // 异步执行aop
@Modules(scanPackage = true)
@Ok("json:full")
@Fail("jsp:jsp.500")
@Localization(value = "msg/", defaultLocalizationKey = "zh-CN")
public class MainModule {

    @At("/hello")
    @Ok("jsp:jsp.hello")
    public String doHello() {
        return "Hello Nutz";
    }
}
