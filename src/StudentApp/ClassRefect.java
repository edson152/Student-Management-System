
package StudentApp;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClassRefect<T> 
{
    private static final Comparator MySort = null;

    public static  Field[] getAllPublicAttribute(Object obj)
    {
        Class<? extends Object> refClass = obj.getClass();
        //System.out.println(refClass);
        return refClass.getFields();
    }
    
    public static Field[] getAllAttribute(Object obj)
    {
        Class<? extends Object> refClass = obj.getClass();
        //System.out.println(refClass);
        return refClass.getDeclaredFields();
    }
    
    public static Method[] getAllPublicMethod(Object obj)
    {
        Class<? extends Object> refClass = obj.getClass();
        //System.out.println(refClass);
        return refClass.getMethods();
    }
    
    public static List<Method> getAllGetMethod(Object obj)
    {
        List<Method> getMethods=new ArrayList<>();
        Class<? extends Object> refClass = obj.getClass();
        //System.out.println(refClass);
        String[] row= {"getSid","getSname","getSage","getSaddress","getSnumber","getSphone"};
        Method[] methodArray = refClass.getMethods();
        for(String r:row){
        	for(Method m:methodArray)
        	{       	   	
        		if(m.getName()== r){
        			getMethods.add(m);
        			System.out.println(m.getName());
        		}
        	}
        }     
        return getMethods;
    }
   
    public static void invokeAllGetMethod(Object obj)
    {
        Class<? extends Object> refClass = obj.getClass();
        //System.out.println(refClass);
        Method[] methodArray = refClass.getMethods();
        for (Method m : methodArray) {
            //System.out.println(m);
            if(m.getName().contains("get")){
                try {
                    System.out.println(m.getName());
                    System.out.println(m.invoke(obj, null));
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ClassRefect.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ClassRefect.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(ClassRefect.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
   
   
}
