package BackingBean;

//import Db.DbConnection;

import javax.faces.context.FacesContext;
import java.util.Map;

public class Reservation {

private int id;
    private String studentname;
    private String studentregno;
    private String studentemail;




    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();


    public Reservation() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentemail() {
        return studentemail;
    }

    public String getStudentregno() {
        return studentregno;
    }

    public void setStudentregno(String studentregno) {
        this.studentregno = studentregno;
    }

    public void setStudentemail(String studentemail) {
        this.studentemail = studentemail;
    }
}