/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2019/2/16
  Time: 18:43
  To change this template use File | Settings | File Templates.
*/
package com.drc.controller;

import com.drc.model.ReportDTO;
import com.drc.model.Responsed;
import com.drc.mybatis.entity.Report;
import com.drc.mybatis.service.ReportService;
import com.drc.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;
    @PostMapping("/reportInsert")
    public Responsed insert(ReportDTO reportDTO){
        Responsed responsed=new Responsed();
        Report report=new Report();
        report.setOpname(reportDTO.getOpName());
        report.setDate(reportDTO.getDate());
        report.setId(reportService.insert(report));
        if (report.getId()>0){//一部分保存成功,给出返回数据继续上传图片
            responsed.setStatus(Responsed.Success)
                    .setMsg("report保存成功，可以进行图片上传！")
                    .setTimestamp(DateUtil.getNow(null))
                    .setException(report.getId().toString());
        }else {
            responsed.setStatus(Responsed.Fail)
                    .setMsg("report保存失败，稍后再试！")
                    .setTimestamp(DateUtil.getNow(null))
                    .setException(null);
        }
        return responsed;
    }
}
