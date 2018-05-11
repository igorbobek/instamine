package com.ezhik.instamine.Service;

import com.ezhik.instamine.Dao.LikesDao;
import com.ezhik.instamine.Model.Likes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikesServiceImpl implements LikesService {

    @Autowired
    LikesDao likesDao;

    @Override
    public Long getCountLikesByUserId(Long userId) {
        return likesDao.countByUserId(userId);
    }

    @Override
    public Long getCountLikesByImageId(Long imageId) {
        return likesDao.countByImageId(imageId);
    }

    @Override
    public List<Likes> getByUserId(Long userId) {

        return new ArrayList<>(likesDao.findByUserId(userId));
    }

    @Override
    public void save(Likes likes) {
        likesDao.save(likes);
    }

    @Override
    public Likes getByUserIdAndImageId(Long userId, Long imageId) {

        return likesDao.findByUserIdAndImageId(userId, imageId);
    }

    @Override
    public void delete(Likes likes) {
        likesDao.delete(likes);
    }
}
