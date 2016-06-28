package controllers;

import dao.UserDAO;
import dto.AuthUser;
import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import utils.PasswordEncryptor;

/**
 * Created by Nikolay on 03.02.2016.
 */
@Controller
public class HomePageController extends BaseController{

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage(){
        return "home";
    }

    @RequestMapping(value = "/horizontal", method = RequestMethod.GET)
    public String getHorizontalPage(Model model){
        addAuthenticatedUserToModel(model);
        return "horizontal";
    }

    @RequestMapping(value = "/vertical", method = RequestMethod.GET)
    public String getVerticalPage(Model model) {
        addAuthenticatedUserToModel(model);
        return "vertical";
    }

    @RequestMapping(value = "/rolling", method = RequestMethod.GET)
    public String getRollingPage(Model model){
        addAuthenticatedUserToModel(model);
        return "rolling";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(){
        return "registration";
    }

    @RequestMapping(value = "/registration/customer", method = RequestMethod.POST)
    public String registrationCustomer (
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "login") String login,
            @RequestParam(value = "pass") String password,
            @RequestParam(value = "mail") String mail,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "phone") Integer phone
    ){
        User user = new User();
        user.setId(id);
        user.setLogin(login);
        String encryptedPassword = PasswordEncryptor.encryptPasswordMD5(password);
        user.setPassword(encryptedPassword);
        user.setMail(mail);
        user.setName(name);
        user.setPhone(phone);
        userDAO.addUser(user);

        return "redirect:/home";
    }

}
