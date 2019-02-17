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
import com.drc.mybatis.entity.Reportimg;
import com.drc.mybatis.service.ReportImgService;
import com.drc.mybatis.service.ReportService;
import com.drc.utils.DateUtil;
import com.drc.utils.FileUtil;
import com.drc.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class ReportController {
    private final static String filePath ="/images" ;
    @Autowired
    private ReportService reportService;
    @Autowired
    private ReportImgService reportImgService;
    @PostMapping("/reportInsert1")
    @Deprecated
    public Responsed insert1(ReportDTO reportDTO){
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
    @PostMapping("/reportInsert")
    public Responsed insert(@RequestParam("multipartFile") MultipartFile[] multipartFiles, ReportDTO reportDTO){
        Responsed responsed=new Responsed();
        Report report=new Report();
        report.setOpname(reportDTO.getOpName());
        report.setDate(reportDTO.getDate());
        report.setId(reportService.insert(report));
        if (report.getId()>0){//一部分保存成功,继续上传图片
            if (multipartFiles != null && multipartFiles.length >0) {
                for (int i = 0; i < multipartFiles.length; i++) {
                    String root_fileName = multipartFiles[i].getOriginalFilename();
                    String contentType = multipartFiles[i].getContentType();
                    LogUtil.info("上传图片:name={},type={}:" + root_fileName + "   : " + contentType);
                    //获取路径
                    LogUtil.info("图片保存路径={}" + filePath);
                    String file_name = null;
                    try {
                        file_name = FileUtil.saveImg(multipartFiles[i], filePath);
                        LogUtil.info("图片新名字" + file_name);
                        Reportimg reportimg = new Reportimg();
                        if (!file_name.isEmpty()) {
                            reportimg.setReportid(report.getId());
                            reportimg.setPath(filePath + File.separator + file_name);
                            reportimg.setMeasurementvalue(reportDTO.getMeasurementValue().get(i));
                            if (reportImgService.insert(reportimg) > 0) {
                                responsed.setStatus(Responsed.Success)
                                        .setMsg("数据插入成功！")
                                        .setException(null)
                                        .setTimestamp(DateUtil.getNow(null));
                            }else {
                                responsed.setStatus(Responsed.Fail)
                                        .setMsg("图片数据插入失败！")
                                        .setException("fail at reportImgService.insert(reportimg)")
                                        .setTimestamp(DateUtil.getNow(null));
                                return responsed;//出错返回
                            }
                        }
                    } catch (IOException e) {
                        LogUtil.error(e.toString());
                        responsed.setStatus(Responsed.Fail)
                                .setMsg("图片上传失败！")
                                .setException(e.getMessage())
                                .setTimestamp(DateUtil.getNow(null));
                        return responsed;//出错返回
                    }
                }
            }else if(reportDTO.getMeasurementValue().size()!=0){
                //无图只有数据情况
                for (String value:reportDTO.getMeasurementValue()) {
                    Reportimg reportimg = new Reportimg();
                    reportimg.setReportid(report.getId());
                    reportimg.setPath(null);
                    reportimg.setMeasurementvalue(value);
                    if (reportImgService.insert(reportimg) > 0) {
                        responsed.setStatus(Responsed.Success)
                                .setMsg("测量值数据插入成功！")
                                .setException(null)
                                .setTimestamp(DateUtil.getNow(null));
                    }else {
                        responsed.setStatus(Responsed.Fail)
                                .setMsg("测量值数据上传失败！")
                                .setException("fail")
                                .setTimestamp(DateUtil.getNow(null));
                        return responsed;//出错返回
                    }
                }
            }
        }else {
            responsed.setStatus(Responsed.Fail)
                    .setMsg("report保存失败，稍后再试！")
                    .setTimestamp(DateUtil.getNow(null))
                    .setException(null);
        }
        return responsed;
    }
}
