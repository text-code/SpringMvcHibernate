package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserDaoImpl userDao;

    @Autowired
    public UsersController(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers", userDao.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(
            @PathVariable("id") int id,
            Model model
    ) {
        model.addAttribute("user", userDao.getUser(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userDao.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(
            @PathVariable("id") int id,
            Model model
    ) {
        model.addAttribute("user", userDao.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(
            @ModelAttribute("user") User user,
            @PathVariable("id") int id
    ) {
        userDao.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userDao.delete(id);
        return "redirect:/users";
    }
}
