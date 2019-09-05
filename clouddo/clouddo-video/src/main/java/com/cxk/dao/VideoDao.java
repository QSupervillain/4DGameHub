package com.cxk.dao;

import com.cxk.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VideoDao {
    public List<Video> findAll();
}
