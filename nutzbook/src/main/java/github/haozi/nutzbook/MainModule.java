package github.haozi.nutzbook;

import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

/**
 * @author wanghao
 * @Description
 * @date 2019-07-17 10:58
 */
public class MainModule {

    @At("/hello")
    @Ok("jsp:jsp.hello")
    public String doHello() {
        return "Hello Nutz";
    }
}
