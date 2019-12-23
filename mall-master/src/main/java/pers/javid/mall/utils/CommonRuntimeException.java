package pers.javid.mall.utils;

import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.apache.commons.lang3.exception.ExceptionContext;

/**
 * @author ：javid
 * @date ：Created in 2019-8-20
 * @description：通用异常类
 * @version: 1.0
 */
public class CommonRuntimeException extends ContextedRuntimeException {

    private static final long serialVersionUID = -1733196472425115467L;

    public CommonRuntimeException(){

    }

    public CommonRuntimeException(String msg){
        super(msg);
    }

    public CommonRuntimeException(Throwable cause){
        super(cause);
    }

    public CommonRuntimeException(String msg,Throwable cause){
        super(msg,cause);
    }

    public CommonRuntimeException(String msg, Throwable cause, ExceptionContext context){
        super(msg,cause,context);
    }
}
