package controllers;

import dto.AuthUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Nikolay on 18.02.2016.
 */
@Controller
public class AdminPageController extends BaseController {

    @RequestMapping(value = "/admin/add/user", method = RequestMethod.GET)
    public String addUser() {
        return "addUser";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String getPageForRole(Model model) {
        AuthUser authUser = userDAO.getAuthUser(getLogin());
        model.addAttribute("authUser", authUser);
        if (AuthUser.ROLE_ADMIN.equals(authUser.getRole())) {
            return "admin";
        }
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "login";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginFailedGET(Model model) {
        String loginFailed = "Неверный логин или пароль!";
        model.addAttribute("loginFailed", loginFailed);
        return "login";
    }

}
