package com.stone.tree.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author dbw
 * @date 2021/01/03/9:54 下午
 * @Description  自定义业务异常，可使用单消息参数构造器，定制特定错误码异常，使用双参数构造
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = -7363659599503806372L;
    /**
     * 错误码
     */
    protected Integer errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;


    public ServiceException(String message) {
        this.errorMsg = message;
    }
}
