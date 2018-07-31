package org.wingstudio.riverheaderinstitution.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FileUtilResponse {
    private int errno;
    private List<String> data;

    private FileUtilResponse(int errno, List<String> data) {
        this.errno = errno;
        this.data = data;
    }

    public static FileUtilResponse success(List<String> list){
        return new FileUtilResponse(0,list);
    }
    public static FileUtilResponse error(){
        return new FileUtilResponse(1,null);
    }
}
