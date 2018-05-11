package com.ezhik.instamine.Service;

import com.ezhik.instamine.Model.UserImageLikeComment;

import java.util.List;

public interface UserImageLikeCommentService {

    void save(String commentStr, Long userId, Long imageId);
    List<UserImageLikeComment> getByUserId(Long userId);
    List<UserImageLikeComment> getByImageId(Long imageId);
    List<UserImageLikeComment> getByCommentId(Long commentId);
    List<UserImageLikeComment> getAll();

}
