package com.ezhik.instamine.Service;

import com.ezhik.instamine.Model.Comment;

import java.util.List;

public interface CommentService {
    Comment getById(Long idComment);
    List<Comment> getAll();
}
