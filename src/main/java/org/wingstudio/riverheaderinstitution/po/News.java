package org.wingstudio.riverheaderinstitution.po;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@DynamicInsert
public class News {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Column(length = 50)
    private String newsFrom;

    @Column(length = 100,nullable = false,unique = true)
    private String newsTitle;

    @Lob
    @Column(nullable = false)
    private String newsBody;

    @Column(length = 30)
    private String newsAuthor;

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", updateTime=" + updateTime +
                ", newsFrom='" + newsFrom + '\'' +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsBody='" + newsBody + '\'' +
                ", newsAuthor='" + newsAuthor + '\'' +
                '}';
    }
}
