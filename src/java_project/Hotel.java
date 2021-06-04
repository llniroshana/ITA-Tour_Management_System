package java_project;

/**
 *
 * @author Notebook 15
 */
public class Hotel {
    
    private int hid;
    private String hname;
    private float hprice;
    private byte[] hpic;
    
    public Hotel(int phid, String phname, float phprice, byte[] phpic)
    {
        this.hid = phid;
        this.hname = phname;
        this.hprice = phprice;
        this.hpic = phpic;
    }
    
    public int getHid()
    {
        return hid;
    }
    
    public String getHname()
    {
        return hname;
    }
    
    public float getHprice()
    {
        return hprice;
    }
    
    public byte[] getHpic()
    {
        return hpic;
    }
    
}
