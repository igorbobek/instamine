package com.ezhik.instamine.Dao;

import com.ezhik.instamine.Model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommentDao extends CrudRepository<Comment,Long> {
}
