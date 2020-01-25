package ManageBean;

import BackingBean.User;
import entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.List;

@ManagedBean
public class UserBean {



//    DbConnection db;
        private User user;

    public User getUser() {
        return user;
    }

    public UserBean() {user=new User(); //db=new DbConnection();
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String loginUser(){

        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();

        List<UserEntity> labels = session.createQuery("from UserEntity").getResultList();


        for(UserEntity label : labels) {
            if (user.getEmail().equals(label.getEmail()) && user.getPassword().equals(label.getPassword())) {
                HttpSession sessions =
                        (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

                int c=user.getId();
StudentBean.u=label.getUserId();
System.out.println(label.getUserId());
System.out.println(StudentBean.u);
                sessions.setAttribute("id",c);
                sessions.setMaxInactiveInterval(10 * 60);
                return "student.xhtml?faces-redirect=true";
            }
        }
        return "login";
    }

    public String addUser(){
        UserEntity userEntity=new UserEntity();

      userEntity.setName(user.getName());
      userEntity.setEmail(user.getEmail());
      userEntity.setPassword(user.getPassword());










        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();


        session.save(userEntity);
        session.beginTransaction().commit();
        session.close();
        factory.close();


        return "login.xhtml?faces-redirect=true";

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

}
