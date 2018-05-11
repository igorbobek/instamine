package com.ezhik.instamine.Controller;

import com.ezhik.instamine.Model.Image;
import com.ezhik.instamine.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiRestController {

    @Autowired
    ImageService imageService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/api/images")
    public ResponseEntity<List<Image>> listAllImages(){
        List<Image> images = imageService.getAll();
        images.forEach(e->{
            e.setCommentUserBook(null);
            e.setLikes(null);
            e.getUser().setImages(null);
            e.getUser().setRoles(null);
        });
        if(images.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(images,HttpStatus.OK);
    }

}
