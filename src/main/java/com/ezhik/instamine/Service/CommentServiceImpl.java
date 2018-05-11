package com.ezhik.instamine.Service;

import com.ezhik.instamine.Dao.CommentDao;
import com.ezhik.instamine.Model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentDao commentDao;

    @Override
    public Comment getById(Long idComment) {
        if(commentDao.findById(idComment).isPresent()){
            return commentDao.findById(idComment).get();
        }
        return null;
    }

    @Override
    public List<Comment> getAll() {
        ArrayList comments = new ArrayList<>();
        commentDao.findAll().forEach(comments::add);
        return comments;
    }
}
