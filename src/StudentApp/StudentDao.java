
package StudentApp;

import java.util.List;


public interface StudentDao 
{
    public boolean addStudent(Student stu);
    
    public boolean updateStudent(Student stu);
    
    public boolean delStudentbyID(int id);
    
    public Student getStudentbyID(int id);
    
    public Student getStudentbyNum(String snum);
    
    public List<Student> getStudentbyName(String name);
    
    public List<Student> getAllStudent();
    
 }
