package com.ezhik.instamine.Dao;

import com.ezhik.instamine.Model.Likes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface LikesDao extends CrudRepository<Likes, Long> {

    Long countByUserId(Long userId);
    Long countByImageId(Long imageId);
    Set<Likes> findByUserId(Long userId);
    Likes findByUserIdAndImageId(Long userId, Long imageId);
}
