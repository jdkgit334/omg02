package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Table(name = "user")
@NamedQueries({
    @NamedQuery(
            name = "getAllUsers", //全てのユーザーデータをid降順で取得する
            query = "SELECT u FROM User AS u ORDER BY u.id DESC"
            ),
    @NamedQuery(
            name = "getUsersCount", //全てのユーザー数をカウントする
            query = "SELECT COUNT(u) FROM User AS u"
            ),
    @NamedQuery(
            name = "checkRegisteredCode", //ユーザーIDが既存のものか確認する
            query = "SELECT COUNT(u) FROM User AS u WHERE u.code = :code"
            ),
    @NamedQuery(
            name = "checkLoginCodeAndPassword", //削除フラグが立っておらずユーザーIDもパスワードも正しいか確認する
            query = "SELECT u FROM User AS u WHERE u.delete_flag = 0 AND u.code = :code AND u.password = :pass"
            )
})
@Entity
public class User {
    @Id //カラム名idを主キーに設定
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false, unique = true) //カラム名code(ユーザーID)、一意制約(同一不可)
    private String code;

    @Column(name = "name", nullable = false) //カラム名name(ユーザー名)
    private String name;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "admin_flag", nullable = false) //管理者フラグ
    private Integer admin_flag;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Column(name = "delete_flag", nullable = false)
    private Integer delete_flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAdmin_flag() {
        return admin_flag;
    }

    public void setAdmin_flag(Integer admin_flag) {
        this.admin_flag = admin_flag;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }


}


























