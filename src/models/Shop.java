package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "shops")
@NamedQueries({
    @NamedQuery(
            name = "getAllShops",
            query = "SELECT s FROM Shop AS s ORDER BY s.id DESC"
            ),
    @NamedQuery(
            name = "getShopsCount",
            query = "SELECT COUNT(s) FROM Shop AS s"
            ),
    @NamedQuery(
            name = "getMyAllShops",
            query = "SELECT s FROM Shop AS s WHERE s.user = :user ORDER BY s.id DESC "
            ),
    @NamedQuery(
            name = "getMyShopsCount",
            query = "SELECT COUNT(s) FROM Shop AS s WHERE s.user = :user"
            )

})

@Entity
public class Shop {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


@ManyToOne
@JoinColumn(name = "user_id", nullable = false)
private User user;

@Column(name = "name", length = 255, nullable = false)
private String name;

@Column(name = "disclose", nullable = false)
private Integer disclose;

@Lob
@Column(name = "address", length = 255, nullable = false)
private String address;

@Column(name = "open_at1", nullable = false)
private String open_at1;

@Column(name = "close_at1", nullable = false)
private String close_at1;

@Column(name = "open_at2", nullable = false)
private String open_at2;

@Column(name = "close_at2", nullable = false)
private String close_at2;

@Column(name = "holiday", nullable = false)
private String holiday;

@Column(name = "homepage", nullable = true)
private String homepage;

@Lob
@Column(name = "content", nullable = true)
private String content;

/*
@Column(name = "delete_flag", nullable = false)
private Integer delete_flag;
*/

@Column(name = "tel", nullable = true)
private String tel;

@Column(name = "category", nullable = false)
private String category;

@Column(name = "created_at", nullable = false)
private Timestamp created_at;

@Column(name = "updated_at", nullable = false)
private Timestamp updated_at;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Integer getDisclose() {
    return disclose;
}

public void setDisclose(Integer disclose) {
    this.disclose = disclose;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public String getOpen_at1() {
    return open_at1;
}

public void setOpen_at1(String open_at1) {
    this.open_at1 = open_at1;
}

public String getClose_at1() {
    return close_at1;
}

public void setClose_at1(String close_at1) {
    this.close_at1 = close_at1;
}

public String getOpen_at2() {
    return open_at2;
}

public void setOpen_at2(String open_at2) {
    this.open_at2 = open_at2;
}

public String getClose_at2() {
    return close_at2;
}

public void setClose_at2(String close_at2) {
    this.close_at2 = close_at2;
}

public String getHoliday() {
    return holiday;
}

public void setHoliday(String holiday) {
    this.holiday = holiday;
}

public String getHomepage() {
    return homepage;
}

public void setHomepage(String homepage) {
    this.homepage = homepage;
}

public String getContent() {
    return content;
}

public void setContent(String content) {
    this.content = content;
}

/*
public Integer getDelete_flag() {
    return delete_flag;
}

public void setDelete_flag(Integer delete_flag) {
    this.delete_flag = delete_flag;
}
*/

public String getTel() {
    return tel;
}

public void setTel(String tel) {
    this.tel = tel;
}

public String getCategory() {
    return category;
}

public void setCategory(String category) {
    this.category = category;
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





}
