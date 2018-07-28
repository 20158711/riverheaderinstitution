package org.wingstudio.riverheaderinstitution.common;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum  ResponseCode {
    SUCCESS(0,"success"),
    ERROR(1,"error");
    private int code;
    private String msg;
}
