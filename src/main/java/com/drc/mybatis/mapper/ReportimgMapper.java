package com.drc.mybatis.mapper;

import com.drc.mybatis.entity.Reportimg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ReportimgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reportimg record);

    Reportimg selectByPrimaryKey(Integer id);

    List<Reportimg> selectAll();

    int updateByPrimaryKey(Reportimg record);
}