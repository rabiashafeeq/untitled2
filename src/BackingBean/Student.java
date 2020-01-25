package BackingBean;

public class Student {

    private  String StudentName;
    private  String StudentRegNo;
    private int StudentSemester;
    private int StudentId;
    private int Userid;

    public Student(){

    }
public  int getUserid(){
        return Userid;
}
public void setUserid(int userid){
        Userid=userid;
}


    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public int getStudentSemester() {
        return StudentSemester;
    }

    public void setStudentSemester(int studentSemester) {
        StudentSemester = studentSemester;
    }

    public void setStudentRegNo(String studentRegNo) {
        StudentRegNo = studentRegNo;
    }

    public String getStudentRegNo() {
        return StudentRegNo;
    }
}
