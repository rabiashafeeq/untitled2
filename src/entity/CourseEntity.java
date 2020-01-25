package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "final", catalog = "")
public class CourseEntity {
    private int courseId;
    private String courceCode;
    private String courseName;
    private int creditHour;
    private Integer userId;

    @Id
    @Column(name = "course_id")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "cource_code")
    public String getCourceCode() {
        return courceCode;
    }

    public void setCourceCode(String courceCode) {
        this.courceCode = courceCode;
    }

    @Basic
    @Column(name = "course_name")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "credit_hour")
    public int getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
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
        CourseEntity that = (CourseEntity) o;
        return courseId == that.courseId &&
                creditHour == that.creditHour &&
                Objects.equals(courceCode, that.courceCode) &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courceCode, courseName, creditHour, userId);
    }
}
