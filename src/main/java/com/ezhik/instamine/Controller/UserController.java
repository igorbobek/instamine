package com.ezhik.instamine.Controller;

import com.ezhik.instamine.Model.Image;
import com.ezhik.instamine.Model.User;
import com.ezhik.instamine.Model.UserImageLikeComment;
import com.ezhik.instamine.Service.ImageService;
import com.ezhik.instamine.Service.UserImageLikeCommentService;
import com.ezhik.instamine.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    ImageService imageService;
    @Autowired
    UserService userService;
    @Autowired
    UserImageLikeCommentService userImageLikeCommentService;

    @Secured("ROLE_ANONYMOUS")
    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @Secured("ROLE_ANONYMOUS")
    @PostMapping("/login")
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect("");
    }

    @Secured("ROLE_ANONYMOUS")
    @GetMapping("/signup")
    public ModelAndView signup(){
        ModelAndView modelAndView = new ModelAndView("signup");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @Secured("ROLE_ANONYMOUS")
    @PostMapping("/signup")
    public ModelAndView signup(@ModelAttribute("user") User userForm, @RequestParam("matchingPassword") String matchPass){
        ModelAndView modelAndView = new ModelAndView();
        if(userForm.getName().equals("") || userForm.getEmail().equals("") || userForm.getPassword().equals("")){
            modelAndView.setViewName("signup");
            modelAndView.addObject("error", "Вводимые поля не должны быть пустыми!");
            return modelAndView;
        }

        if (!userForm.getPassword().equals(matchPass)){
            modelAndView.setViewName("signup");
            modelAndView.addObject("error", "Оба введенных пароля должны быть идентичны!");
            return modelAndView;
        }
        try{
            userForm.setPassword(new BCryptPasswordEncoder().encode(userForm.getPassword()));
            userService.save(userForm);
            modelAndView = new ModelAndView(new RedirectView("/"));
            return modelAndView;
        }catch (Exception e){
            modelAndView.setViewName("signup");
            modelAndView.addObject("error", e.getMessage());
            System.err.println(e.getMessage());
        }

        return modelAndView;
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping("/addComment")
    public String addComment(HttpServletRequest request, @RequestParam("comment") String commentForm, @RequestParam("imageId") String imageId){
        String referer = request.getHeader("Referer");

        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            userImageLikeCommentService.save(commentForm, userService.findByName(auth.getName()).getId(), Long.parseLong(imageId));
        }catch (NumberFormatException e){
            System.err.println(e.getMessage());
        }
        return "redirect:"+ referer;
    }

    @GetMapping("/user/{name}")
    public ModelAndView userPage(@PathVariable(value="name") String name){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("template", "images");
        List<Image> images = new ArrayList<>(userService.findByName(name).getImages());

        images.sort((e, q)->{
            if (e.getDate().before(q.getDate())) {
                return 1;
            } else if (e.getDate().after(q.getDate())) {
                return -1;
            } else {
                return 0;
            }
        });
        modelAndView.addObject("images", images);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)){
            modelAndView.addObject("user", userService.findByName(auth.getName()));
        }
        return modelAndView;
    }

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("/addImage")
    public ModelAndView addImage(){
        ModelAndView modelAndView = new ModelAndView("add_image");
        modelAndView.addObject("image", new Image());
        return modelAndView;
    }

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @PostMapping("/addImage")
    public void addImage(@ModelAttribute("image") Image imageForm, HttpServletResponse response) throws IOException{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByName(auth.getName());
        imageForm.setUser(user);
        imageForm.setDate(new Date());
        imageService.save(imageForm);
        response.sendRedirect("/user/"+auth.getName());
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin")
    public ModelAndView adminPanel(){
        return new ModelAndView("admin");
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/admin/deleteUser")
    public void adminPanel(@RequestParam("userName") String userName, HttpServletResponse response) throws IOException{
        userService.delete(userService.findByName(userName));
        response.sendRedirect("/admin");
    }

}
