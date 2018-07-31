package org.wingstudio.riverheaderinstitution.common;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum  ResponseCode {
    SUCCESS(0,"success"),
    ERROR(1,"error"),
    FILE_NOT_NULL(10,"文件不存在"),
    PATH_NOT_NULL(11,"路径不能为空"),
    FILE_NAME_NOT_NULL(12,"文件名不能为空");
    private int code;
    private String msg;
}
