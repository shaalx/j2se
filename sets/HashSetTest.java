package sets;

import java.util.HashSet;
import java.util.Set;  
/** 
 * Created on 2010-6-7 
 * <p>Description: [HashSet��hashcode����������ڴ�й©]</p> 
 * @author         shixing_11@sina.com 
 * @version        1.0 
*/  
public class HashSetTest  
{  
    public static void main(String[] args)  
    {  
        Set<Person> set = new HashSet<Person>();  
        Person p1 = new Person("��ɮ","pwd1",25);  
        Person p2 = new Person("�����","pwd2",26);  
        Person p3 = new Person("��˽�","pwd3",27);  
        set.add(p1);  
        set.add(p2);  
        set.add(p3);  
        System.out.println("�ܹ���:"+set.size()+" ��Ԫ��!");  //������ܹ���:3 ��Ԫ��!  
        p3.setAge(2);    //�޸�p3������,��ʱp3Ԫ�ض�Ӧ��hashcodeֵ�����ı�  
        set.remove(p3);  //��ʱremove����������ڴ�й©  
        set.add(p3);     //������ӣ���Ȼ��ӳɹ�  
        Person del = new Person("��˽�","pwd3",2);
        boolean ok = set.remove(del);
        System.out.println(ok);
        System.out.println("�ܹ���:"+set.size()+" ��Ԫ��!");  //������ܹ���:4 ��Ԫ��!  
        for (Person person : set)  
        {  
            System.out.println(person);  
        }  
          
    }  
}  


class Person  
{  
    private String username;  
    private String password;  
    private int age;  
    public Person(String username, String password, int age)  
    {  
        this.username = username;  
        this.password = password;  
        this.age = age;  
    }  
    public String getUsername()  
    {  
        return username;  
    }  
    public void setUsername(String username)  
    {  
        this.username = username;  
    }  
    public String getPassword()  
    {  
        return password;  
    }  
    public void setPassword(String password)  
    {  
        this.password = password;  
    }  
    public int getAge()  
    {  
        return age;  
    }  
    public void setAge(int age)  
    {  
        this.age = age;  
    }  
    @Override  
    public int hashCode()  
    {  
        final int prime = 31;  
        int result = 1;  
        result = prime * result + age;  
        result = prime * result + ((password == null) ? 0 : password.hashCode());  
        result = prime * result + ((username == null) ? 0 : username.hashCode());  
        return result;  
    }  
    @Override  
    public boolean equals(Object obj)  
    {  
        if (this == obj)  
            return true;  
        if (obj == null)  
            return false;  
        if (getClass() != obj.getClass())  
            return false;  
        Person other = (Person) obj;  
        if (age != other.age)  
            return false;  
        if (password == null)  
        {  
            if (other.password != null)  
                return false;  
        }  
        else if (!password.equals(other.password))  
            return false;  
        if (username == null)  
        {  
            if (other.username != null)  
                return false;  
        }  
        else if (!username.equals(other.username))  
            return false;  
        return true;  
    }  
    @Override  
    public String toString()  
    {  
        return this.username+"-->"+this.password+"-->"+this.age;  
    }  
      
}  