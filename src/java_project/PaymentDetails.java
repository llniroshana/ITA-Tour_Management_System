/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java_project;

/**
 *
 * @author Notebook 15
 */
public class PaymentDetails {
    
    private int pid;
    private String type;
    private String cn;
    private String ed;
    private int sc;
    private int amount;
   
    
    public PaymentDetails(int ppid, String ptype, String pcn, String ped,int psc, int pamount)
    {
        this.pid = ppid;
        this.type = ptype;
        this.cn = pcn;
        this.ed = ped;
        this.sc = psc;
        this.amount = pamount;
        
    }
    
    public int getPid()
    {
        return pid;
    }
    
    public String getType()
    {
        return type;
    }
    
    public String getCN()
    {
        return cn;
    }
    public String getED()
    {
        return ed;
    }
    
     public int getSC()
    {
        return sc;
    }
     
    public int getAmount()
    {
        return amount;
    }
    
}
