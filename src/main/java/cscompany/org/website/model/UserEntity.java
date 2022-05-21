package cscompany.org.website.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "user", schema = "sd_project")
public class UserEntity extends UserData {

//    @Id
//    @Column(name = "id_user")
//    @GeneratedValue
//    private int idUser;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_user_data")
//    private UserData idUserData;

    @Builder(builderMethodName = "UserEntityBuilder")
    public UserEntity(int idUserData, String name, String phone, String username, String password, String email) {
        super(idUserData, name, phone, username, password, email);
    }
    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserEntity that = (UserEntity) o;
//        return idUser == that.idUser;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(idUser);
//    }
}
