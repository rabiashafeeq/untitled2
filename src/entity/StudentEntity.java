package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "final", catalog = "")
public class StudentEntity {
    private int stuId;
    private String stname;
    private String stRegno;
    private int stuSem;
    private Integer userId;

    @Id
    @Column(name = "stu_id")
    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "stname")
    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    @Basic
    @Column(name = "stRegno")
    public String getStRegno() {
        return stRegno;
    }

    public void setStRegno(String stRegno) {
        this.stRegno = stRegno;
    }

    @Basic
    @Column(name = "stuSem")
    public int getStuSem() {
        return stuSem;
    }

    public void setStuSem(int stuSem) {
        this.stuSem = stuSem;
    }

    @Basic
    @Column(name = "User_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return stuId == that.stuId &&
                stuSem == that.stuSem &&
                Objects.equals(stname, that.stname) &&
                Objects.equals(stRegno, that.stRegno) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, stname, stRegno, stuSem, userId);
    }
}
