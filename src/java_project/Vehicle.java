package java_project;

/**
 *
 * @author Notebook 15
 */
public class Vehicle {
    private int vid;
    private String vtype;
    private float vrate;
    private byte[] vpic;
    
    public Vehicle(int pvid, String pvtype, float pvrate, byte[] pvpic)
    {
        this.vid = pvid;
        this.vtype = pvtype;
        this.vrate = pvrate;
        this.vpic = pvpic;
    }
    
    public int getVid()
    {
        return vid;
    }
    
    public String getVtype()
    {
        return vtype;
    }
    
    public float getVrate()
    {
        return vrate;
    }
    
    public byte[] getVpic()
    {
        return vpic;
    }
    
}
