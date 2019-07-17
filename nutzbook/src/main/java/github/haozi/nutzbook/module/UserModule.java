package github.haozi.nutzbook.module;

import github.haozi.nutzbook.bean.User;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import javax.servlet.http.HttpSession;

/**
 * @author wanghao
 * @Description
 * @date 2019-07-17 16:42
 */
@IocBean
@At("/user")
@Ok("json")
@Fail("http:500")
public class UserModule {
    @Inject
    protected Dao dao;

    @At
    public int count() {
        return dao.count(User.class);
    }

    @At
    public Object login(@Param("username") String name, @Param("password") String password, HttpSession session) {
        User user = dao.fetch(User.class, Cnd.where("name", "=", name).and("password", "=", password));
        if (user == null) {
            return false;
        } else {
            session.setAttribute("me", user.getId());
            return true;
        }
    }

    @At
    @Ok(">>:/")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
