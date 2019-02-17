/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2019/2/16
  Time: 14:50
  To change this template use File | Settings | File Templates.
*/
package com.drc.mybatis.service.serviceimpl;

import com.drc.mybatis.entity.Reportimg;
import com.drc.mybatis.mapper.ReportimgMapper;
import com.drc.mybatis.service.ReportImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("reportImgService")
public class ReportImgServiceImpl implements ReportImgService {
    @Autowired
    private ReportimgMapper reportimgMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Reportimg record) {
        return reportimgMapper.insert(record);
    }

    @Override
    public Reportimg selectByPrimaryKey(Integer id) {
        return reportimgMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Reportimg> selectAll() {
        return reportimgMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Reportimg record) {
        return reportimgMapper.updateByPrimaryKey(record);
    }
}
