/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2018/10/25
  Time: 16:37
  To change this template use File | Settings | File Templates.
*/
package com.drc.model;

import com.alibaba.fastjson.JSON;
import com.drc.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
@Getter
@Builder
@AllArgsConstructor
public class Responsed {
    public static int Success=1;
    public static int Fail=0;
    private int status;//状态
    private String msg;//说明
    private String exception;//异常
    private String timestamp;//时间

    public Responsed(){
        this.status=0;
        this.msg="未设置";
        this.timestamp= DateUtil.getNow(null);
        this.exception="无";
    }
    public void init(){
        setException("");
        setMsg("");
        setStatus(Responsed.Fail);
        setTimestamp( DateUtil.getNow(null));
    }
    public String toJson(){
        return JSON.toJSONString(this);
    }

}
