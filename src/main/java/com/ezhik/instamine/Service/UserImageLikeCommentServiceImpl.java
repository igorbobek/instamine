package com.ezhik.instamine.Service;

import com.ezhik.instamine.Dao.UserDao;
import com.ezhik.instamine.Dao.UserImageLikeCommentDao;
import com.ezhik.instamine.Model.Comment;
import com.ezhik.instamine.Model.Image;
import com.ezhik.instamine.Model.User;
import com.ezhik.instamine.Model.UserImageLikeComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserImageLikeCommentServiceImpl implements UserImageLikeCommentService {

    @Autowired
    UserImageLikeCommentDao userImageLikeCommentDao;
    @Autowired
    UserService userService;
    @Autowired
    ImageService imageService;


    @Override
    public void save(String commentStr, Long userId, Long imageId) {
        Comment comment = new Comment(commentStr);
        User user = userService.findById(userId);
        Image image = imageService.getImageById(imageId);
        userImageLikeCommentDao.save(new UserImageLikeComment(user, image, comment));
    }

    @Override
    public List<UserImageLikeComment> getByUserId(Long userId) {
        return new ArrayList<>(userImageLikeCommentDao.findByUserId(userId));
    }

    @Override
    public List<UserImageLikeComment> getByImageId(Long imageId) {
        return new ArrayList<>(userImageLikeCommentDao.findByImageId(imageId));
    }

    @Override
    public List<UserImageLikeComment> getByCommentId(Long commentId) {
        return new ArrayList<>(userImageLikeCommentDao.findByCommentId(commentId));
    }

    @Override
    public List<UserImageLikeComment> getAll() {
        List<UserImageLikeComment> uilc = new ArrayList<>();
        userImageLikeCommentDao.findAll().forEach(uilc::add);
        return uilc;
    }
}
