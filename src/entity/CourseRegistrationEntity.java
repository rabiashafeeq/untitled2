package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_registration", schema = "final", catalog = "")
public class CourseRegistrationEntity {
    private int courseRegisId;
    private String registrationTime;
    private Integer stuId;
    private Integer courseId;

    @Id
    @Column(name = "course_regis_id")
    public int getCourseRegisId() {
        return courseRegisId;
    }

    public void setCourseRegisId(int courseRegisId) {
        this.courseRegisId = courseRegisId;
    }

    @Basic
    @Column(name = "RegistrationTime")
    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    @Basic
    @Column(name = "stu_id")
    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "course_id")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseRegistrationEntity that = (CourseRegistrationEntity) o;
        return courseRegisId == that.courseRegisId &&
                Objects.equals(registrationTime, that.registrationTime) &&
                Objects.equals(stuId, that.stuId) &&
                Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseRegisId, registrationTime, stuId, courseId);
    }
}
