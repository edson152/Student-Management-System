package StudentApp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDaoImpl implements UserDao
{

    public boolean addUser(User user) {
        String insert="insert into user(uname,upassword) values('"+user.getUname()+"','"+user.getUpassword()+"')";
        try {
            DBUtil.runUpdate(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public User getUserbyID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public List<User> getallUser() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public boolean certifyUser(String uname, String upassword) {
        String select="select * from user where uname='"+uname+"' and upassword='"+upassword+"'";
        boolean isCertifyUser=false;
        try {
            ResultSet rs=DBUtil.runQuery(select);
            if(rs!=null)
            {
                 isCertifyUser=rs.next();
                 DBUtil.realeaseAll();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCertifyUser;
    }
    
}
