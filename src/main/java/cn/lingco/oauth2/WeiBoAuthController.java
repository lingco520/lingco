package cn.lingco.oauth2;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 微博授权登录
 *
 * @author TangGuangMing
 * @version 4.0
 * @date 2019-01-24 15:55
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "/weibo")
public class WeiBoAuthController {
    /**
     * 微博第三方登录图标调用方法
     * @param request
     * @param response
     */
    @RequestMapping(value = "/weiboAuthorize")
    public void sinaLogin(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 重定向跳转
            response.sendRedirect(new Oauth().authorize("code", ""));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WeiboException e) {
            e.printStackTrace();
        }
    }

    /**
     * 微博授权登录后的回调地址，这个地址需要登录微博开放平台配置
     * 授权成功可以获取微博用户信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/weiboCallBack")
    public String weiboCallBack(HttpServletRequest request) {
        String code = request.getParameter("code");
        if (StringUtils.isEmpty(code)) {
            return "weibo/login";
        }
        try {
            Oauth oauth = new Oauth();
            String token = oauth.getAccessTokenByCode(code).toString();
            String[] tokenStrs = token.split(",");
            String accessToken = tokenStrs[0].split("=")[1];
            String[] uidStrs = tokenStrs[3].split("]");
            String uid = uidStrs[0].split("=")[1];
            Users um = new Users(accessToken);
            User user = um.showUserById(uid);
            request.getSession().setAttribute("user", user);
        } catch (WeiboException e) {
            if (401 == e.getStatusCode()) {
                System.out.println("Unableto get the access token.");
            } else {
                e.printStackTrace();
            }
        }
        return "weibo/index";
    }

    /**
     * 微博授权登录取消时跳转地址:跳转到登录页
     * @return
     */
    @RequestMapping(value = "/weiboCannel")
    public String weiboCannel() {
        return "weibo/login";
    }
}
