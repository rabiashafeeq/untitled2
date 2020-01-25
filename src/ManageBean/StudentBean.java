package ManageBean;

import BackingBean.Reservation;
import BackingBean.Student;
import entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@ManagedBean

public class StudentBean {
     Student student;
public static int u;
    List<Student> students;
    public Student getStudent() {
        return student;
    }

    public StudentBean() {student=new Student(); //db=new DbConnection();
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public String loginStudent(){

        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();

        List<StudentEntity> labels = session.createQuery("from StudentEntity").getResultList();


        for(StudentEntity label : labels) {
            if (student.getStudentName().equals(label.getStname()) && student.getStudentRegNo().equals(label.getStRegno())) {
                HttpSession sessions =
                        (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                sessions.setAttribute("username", student.getStudentName());

                sessions.setMaxInactiveInterval(10 * 60);
                return "reservation.xhtml?faces-redirect=true";
            }
        }
        return "login";
    }
    public String addStudent(){
       StudentEntity studentEntity=new StudentEntity();
        studentEntity.setUserId(u);
        studentEntity.setStname(student.getStudentName());
        studentEntity.setStRegno(student.getStudentRegNo());
        studentEntity.setStuSem(student.getStudentSemester());
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        session.save(studentEntity);
        session.beginTransaction().commit();
        session.close();
        factory.close();


        return "ListAllReservation.xhtml?faces-redirect=true";

        // if(res==1){
        //return "login";}

        //return "signup.xhtml?faces-redirect=true";

    }
    public boolean isLoggedIn(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if(session!=null){
            String uname = (String) session.getAttribute("username");
            if(uname!=null){
                return true;
            }
        }
        return false;
    }
    public String logoutUser(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "login.xhtml?faces-redirect=true";
    }


    public List<Student> getAllStudents(){

        students = new ArrayList<Student>();
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();

        List<StudentEntity> labels = session.createQuery("from StudentEntity ").getResultList();


        for(StudentEntity label : labels) {


            Student student = new Student();


            student.setStudentId(label.getStuId());
            student.setStudentName(label.getStname());
            student.setStudentRegNo(label.getStRegno());
            student.setStudentSemester(label.getStuSem());

            students.add(student);
        }
        return students;
    }
    public List<Student> getDataTable(){
        if(students==null){
            students=getAllStudents();
        }
        return students;
    }
    public String deleteStudent(int id){
        System.out.println(id);
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();

        StudentEntity studentssEntity = (StudentEntity) session.get(StudentEntity.class, id);
        session.delete(studentssEntity);
        session.beginTransaction().commit();
        session.close();
        factory.close();


        // db.deleteRecord(id);
        return "ListAllReservation.xhtml?faces-redirect=true";
    }
    public void onRowEdit(RowEditEvent event) {


        Student stu=(Student) event.getObject();
        StudentEntity studentsEntity=new StudentEntity();
        studentsEntity.setUserId(stu.getStudentId());
        studentsEntity.setStname(stu.getStudentName());
        studentsEntity.setStRegno(stu.getStudentRegNo());
        studentsEntity.setStuSem(stu.getStudentSemester());



        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        session.update(studentsEntity);
        session.beginTransaction().commit();
        session.close();
        factory.close();

        System.out.println(event.getObject().toString());
        FacesMessage msg = new FacesMessage("Student Edited", ((Student) event.getObject()).getStudentName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().toString());
        Student stu=(Student) event.getObject();
        System.out.println(stu.getStudentId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public String updateStudent(){
        Session session=null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
             session = factory.openSession();
            session.beginTransaction();
            StudentEntity studentEntity = (StudentEntity) session.get(StudentEntity.class, student.getStudentId());
            studentEntity.setStname(student.getStudentName().toString());
            studentEntity.setStRegno(student.getStudentRegNo().toString());
            studentEntity.setStuSem(student.getStudentSemester());
            studentEntity.setUserId(student.getUserid());

            session.getTransaction().commit();
        }
        catch (Exception sqlException){
            if (null!=session.getTransaction()){
                System.out.println("Session is begin");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }

        return "edit.xhtml?faces-redirect=true";

    }



}
