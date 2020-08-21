package com.demo.boot.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName : ResultVO.java
 * @Description : 公共返回结果
 * @Author : lizhiwen
 * @Date: 2020-08-21 10:47
 */
@ApiModel(value = "ResultVO 对象",description = "请求返回结果")
@Data
@Builder
public class ResultVO {
    @ApiModelProperty(value = "请求返回结果数据",name = "date",example = "")
    private Object date;
    @ApiModelProperty(value = "请求返回状态码 0000=成功,9999=失败",name = "code",example = "0000")
    private Integer code;
    @ApiModelProperty(value = "请求返回状态信息 成功,失败,其他",name = "msg",example = "成功")
    private String msg;
}
