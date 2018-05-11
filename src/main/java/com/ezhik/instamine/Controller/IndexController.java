package com.ezhik.instamine.Controller;



import com.ezhik.instamine.Model.Image;
import com.ezhik.instamine.Model.Likes;
import com.ezhik.instamine.Model.User;
import com.ezhik.instamine.Service.ImageService;
import com.ezhik.instamine.Service.LikesService;
import com.ezhik.instamine.Service.UserImageLikeCommentService;
import com.ezhik.instamine.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class IndexController {

    @Autowired
    ImageService imageService;
    @Autowired
    UserService userService;
    @Autowired
    LikesService likesService;
    @Autowired
    UserImageLikeCommentService userImageLikeCommentService;


    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("template", "images");
        modelAndView.addObject("images", imageService.getAll());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)){
            modelAndView.addObject("user", userService.findByName(auth.getName()));
        }
        return modelAndView;
    }

    @PostMapping("/")
    public void index(HttpServletResponse httpServletResponse) throws IOException{
        httpServletResponse.sendRedirect("/");
    }

    @PostMapping("/like")
    public String like(@RequestParam("imageId")String imageIdForm, HttpServletRequest request){
        String referer = request.getHeader("Referer");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByName(auth.getName());
        if(likesService.getByUserIdAndImageId(user.getId(), Long.parseLong(imageIdForm)) == null){
            likesService.save(new Likes(user, imageService.getImageById(Long.parseLong(imageIdForm))));
        }else{
            likesService.delete(likesService.getByUserIdAndImageId(user.getId(), Long.parseLong(imageIdForm)));
        }

        return "redirect:"+ referer;

    }

    @GetMapping("/image/{id}")
    public ModelAndView image(@PathVariable(value="id") String idStr){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("template", "image");
        Long id = 0L;
        try{
            id = Long.parseLong(idStr);
        }catch (NumberFormatException e){
            System.err.println(e.getMessage());
        }
        modelAndView.addObject("comments", userImageLikeCommentService.getByImageId(id));
        modelAndView.addObject("image", imageService.getImageById(id));
        modelAndView.addObject("user", userService.findByName(auth.getName()));
        return modelAndView;
    }






}
