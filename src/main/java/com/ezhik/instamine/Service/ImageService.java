package com.ezhik.instamine.Service;

import com.ezhik.instamine.Model.Image;

import java.util.List;

public interface ImageService {
    Image getImageById(Long imageId);
    List<Image> getAll();
    void save(Image image);
}

