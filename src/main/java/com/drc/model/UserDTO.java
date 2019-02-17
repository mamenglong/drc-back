/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2019/2/16
  Time: 17:37
  To change this template use File | Settings | File Templates.
*/
package com.drc.model;

import com.alibaba.fastjson.JSON;
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
public class UserDTO {
    String userName;//用户名
    String passWord;//密码
    String uniqueCode;//唯一设备值

    public String toJson(){
        return JSON.toJSONString(this);
    }

}
