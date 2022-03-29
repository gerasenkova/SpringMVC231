package zadacha231.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zadacha231.model.User;
import zadacha231.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersControllers {
    final
    UserService userService;

    public UsersControllers(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String allUsers(Model model){
        model.addAttribute("users", userService.userList());
        return "/users";
    }
    //переходим на страницу конкретного юзера по id
    @GetMapping("/{id}")
public String user(@PathVariable int id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "/show";
    }
    //переходим на страницу, где мы сможем добавить нового юзера
    @GetMapping("/new")
    public String newUser( Model model){
        model.addAttribute("user", new User());
        return "/new";
    }

    //создаем нового пользователя
    @PostMapping()
    public String addUser(@ModelAttribute ("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
    //переходим на страницу где изменяем пользователя
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "/edit";
    }
    //изменяем пользователя, возвращаемся к началу
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }
    //удаляем пользователя
    @RequestMapping("/{id}")
    public String delete(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.getById(id);
        userService.delete(user);
        return "redirect:/users";
    }
}
