package controllers;

import dao.UserDAO;
import dto.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * Created by Nikolay on 28.03.2016.
 */
@Controller
public class BaseController {
    @Autowired
    protected UserDAO userDAO;

    protected String getLogin() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    protected void addAuthenticatedUserToModel (Model model){
        AuthUser authUser = userDAO.getAuthUser(getLogin());
        model.addAttribute("authUser", authUser);
    }

}
