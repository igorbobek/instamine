package com.ezhik.instamine.Dao;

import com.ezhik.instamine.Model.UserImageLikeComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface UserImageLikeCommentDao extends CrudRepository<UserImageLikeComment, Long> {
    Set<UserImageLikeComment> findByUserId(Long userId);
    Set<UserImageLikeComment> findByImageId(Long imageId);
    Set<UserImageLikeComment> findByCommentId(Long commentId);
    //Long countByImageIdAndLikeIsTrue(Long imageId);
    /*Set<UserImageLikeComment> findByUserIdAndImageId(Long userId, Long imageId);
    boolean existsByUserIdAndImageIdAndLikeIsTrue(Long userId, Long imageId);
    Set<UserImageLikeComment> findByUserIdAndImageIdAndCommentIsNull(Long userId, Long imageId);*/
}
