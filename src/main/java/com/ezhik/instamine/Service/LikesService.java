package com.ezhik.instamine.Service;

import com.ezhik.instamine.Model.Likes;

import java.util.List;

public interface LikesService {
    Long getCountLikesByUserId(Long userId);
    Long getCountLikesByImageId(Long imageId);
    List<Likes> getByUserId(Long userId);
    void save(Likes likes);
    Likes getByUserIdAndImageId(Long userId, Long imageId);
    void delete(Likes likes);
}
