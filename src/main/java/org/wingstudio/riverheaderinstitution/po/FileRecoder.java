package org.wingstudio.riverheaderinstitution.po;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
public class FileRecoder {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Column(length = 50,unique = true,nullable = false)
    private String fileName;

    @Override
    public String toString() {
        return "FileRecoder{" +
                "id=" + id +
                ", updateTime=" + updateTime +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
