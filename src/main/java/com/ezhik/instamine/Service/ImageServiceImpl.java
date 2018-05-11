package com.ezhik.instamine.Service;

import com.ezhik.instamine.Dao.ImageDao;
import com.ezhik.instamine.Model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageDao imageDao;

    @Override
    public Image getImageById(Long imageId) {
        if(imageDao.findById(imageId).isPresent()){
            return imageDao.findById(imageId).get();
        }
        return null;
    }

    @Override
    public List<Image> getAll() {
        List<Image> images = new ArrayList<>();
        imageDao.findAllByOrderByDateDesc().forEach(images::add);
        return images;
    }

    @Override
    public void save(Image image) {
        imageDao.save(image);
    }
}
