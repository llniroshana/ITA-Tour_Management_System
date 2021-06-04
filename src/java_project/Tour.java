package java_project;

/**
 *
 * @author Notebook 15
 */
public class Tour {
    
    private int tid;
    private String tname;
    private String uname;
    private String pn;
    private String vehicle;
    private String hotel;
    private String cost;
    
    public Tour(int tid, String tname, String uname, String pn, String co, String veh, String hos)
    {
        this.tid = tid;
        this.tname = tname;
        this.uname = uname;
        this.pn = pn;
        this.cost = co;
        this.vehicle = veh;
        this.hotel = hos;
    }
    
    public int getTid()
    {
        return tid;
    }
    
    public String getTname()
    {
        return tname;
    }
    
    public String getUname()
    {
        return uname;
    }
    public String getPN()
    {
        return pn;
    }
    public String getcost()
    {
        return cost;
    }
    public String getvehicle()
    {
        return vehicle;
    }
    public String gethotel()
    {
        return hotel;
    }
    
}
