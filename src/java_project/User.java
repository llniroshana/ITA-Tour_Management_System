package java_project;

/**
 *
 * @author Notebook 15
 */
public class User {
    //private int uid;
    private String uname;
    private String name;
    private String addrs;
    private String phone;
    private String email;
    
    public User(String puname, String pname,String paddrs,String pphone,String pemail)
    {
        //this.uid = puid;
        this.uname = puname;
        this.name = pname;
        this.addrs = paddrs;
        this.phone = pphone;
        this.email = pemail;
    }
 
    public String getUname()
    {
        return uname;
    }
    
     public String getName()
    {
        return name;
    }
    
     public String getAddrs()
    {
        return addrs;
    }
    
     public String getPhone()
    {
        return phone;
    }
    
     public String getEmail()
    {
        return email;
    }
    
    
}
