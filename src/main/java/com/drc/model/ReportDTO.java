/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2019/2/16
  Time: 18:48
  To change this template use File | Settings | File Templates.
*/
package com.drc.model;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Accessors(chain = true)
@Setter
@Getter
@Builder
@AllArgsConstructor
public class ReportDTO {
    Date date;//日期
    String opName;//操作员
    List<String> photoPaths = new ArrayList<>();
    List<String> measurementValue = new ArrayList<>();//测量值

    public String toJson(){
        return JSON.toJSONString(this);
    }

}
