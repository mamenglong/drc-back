/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2018/11/3
  Time: 16:12
  To change this template use File | Settings | File Templates.
*/
package com.drc.mybatis.service.serviceimpl;

import com.drc.mybatis.entity.Report;
import com.drc.mybatis.mapper.ReportMapper;
import com.drc.mybatis.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("reportService")
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return reportMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Report record) {
        return reportMapper.insert(record);
    }

    @Override
    public Report selectByPrimaryKey(Integer id) {
        return reportMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Report> selectAll() {
        return reportMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Report record) {
        return reportMapper.updateByPrimaryKey(record);
    }
}
