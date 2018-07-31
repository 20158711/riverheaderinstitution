package org.wingstudio.riverheaderinstitution.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserCategory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private Short id;

    @Column(length = 20,nullable = false,unique = true)
    @Setter @Getter
    private String categoryName;

    @OneToMany(mappedBy = "userCategory")
    @Getter
    private Set<User> users=new HashSet<>();

//    @ManyToMany(cascade = CascadeType.REFRESH
//            ,mappedBy = "categorys")
//    @Getter
//    private Set<User> users=new HashSet<>();

    public void addUserToCategory(User user){
        user.setUserCategory(this);
    }

    public void removeUserFromCategory(User user){
        user.setUserCategory(null);
    }

    @Override
    public boolean equals(Object obj) {
        return id==((UserCategory)obj).id;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        users.forEach(e -> stringBuffer.append(e.getUsername() + "\t"));
        return "UserCategory{" +
                "id=" + id +
                ", categoryName=" + categoryName +
                ", users["+stringBuffer.toString()+
                "]}";
    }
}
