package org.wingstudio.riverheaderinstitution.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventStatusEnum {
    BEGIN(Byte.valueOf("0"),"开始"),
    DOING(Byte.valueOf("1"),"正在处理"),
    REBACK(Byte.valueOf("2"),"退回"),
    DONE(Byte.valueOf("3"),"完成");
    private byte code;
    private String msg;

}
