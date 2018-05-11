package com.ezhik.instamine.Dao;

import com.ezhik.instamine.Model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface ImageDao extends CrudRepository<Image, Long> {
    Set<Image> findAllByOrderByDateDesc();
}
