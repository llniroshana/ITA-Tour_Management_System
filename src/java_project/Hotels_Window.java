package java_project;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Notebook 15
 */
public class Hotels_Window extends javax.swing.JFrame {
    

    /**
     * Creates new form Main_Window
     */
    public Hotels_Window() {
        initComponents();
        Show_Product_In_JTable();
    }
    
    String ImgPath = null;
    int pos = 0;
    
    // Connection
     public Connection getConnection()
      {
          Connection con = null;
          
          try{
              con=DriverManager.getConnection("jdbc:mysql://localhost/hotels_db","root","");
              //JOptionPane.showMessageDialog(null, "Connected");
              System.out.println("Connected");
              return con;
          }catch (SQLException ex){
                    Logger.getLogger(Hotels_Window.class.getName()).log(Level.SEVERE,null,ex);
                    JOptionPane.showMessageDialog(null, "Not Connected");
                    System.out.println("Not Connected");
                    return null;
                }
      }
     
     //Check Inputs
     public boolean checkinputs()
      {
          if(   txt_hname.getText() == null 
             || txt_hprice.getText() == null )
                {
                    return false;
                }
          else
          {
            try{
                Float.parseFloat(txt_hprice.getText());
                    {
                     return true;
                    }
            }catch(Exception ex)
                    {
                     return false;
                    }
          }
      }

    
    //Resize Image
     public ImageIcon ResizeImage(String imagePath, byte[] hpic)
      {
          ImageIcon myImage = null;
          
          if(imagePath != null )
          {
              myImage = new ImageIcon(imagePath);
          }
          else{
              myImage = new ImageIcon(hpic);
          }
          
          Image img = myImage.getImage();
          Image img2 = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
          ImageIcon image = new ImageIcon(img2);
          return image;
      }
     
//Display Data In JTable
     
     // 1 - Fill Array List with Data
     
    /**
     *
     * @return
     */
         
     public ArrayList<Hotel> getHotelList(){
     
     //JTable_Hotels.removeAll();    
     ArrayList<Hotel>  hotelList = new ArrayList<Hotel>();
     Connection con = getConnection();
     String query = "SELECT * FROM hotelsp";
     
     Statement st;
     ResultSet rs;
     
     try{
        st = con.createStatement();
        rs = st.executeQuery(query);
        Hotel hotel;
     
            while(rs.next())
            {
                hotel = new Hotel(rs.getInt("hid"),rs.getString("hname"), Float.parseFloat(rs.getString("hprice")),rs.getBytes("hpic"));
                hotelList.add(hotel);
            }
     
    }catch(SQLException ex){
        Logger.getLogger(Hotels_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    return hotelList;
}
// 2 - Populate the JTable
     
    public void Show_Product_In_JTable()
    {
        
        ArrayList<Hotel> list = getHotelList();
        DefaultTableModel model = (DefaultTableModel)JTable_Hotels.getModel();
        model.setRowCount(0);
         
        Object[] row = new Object[4];
        for(int i=0; i<list.size();i++)
        {
            row[0]=list.get(i).getHid();
            row[1]=list.get(i).getHname();
            row[2]=list.get(i).getHprice();
            row[3]=list.get(i).getHpic();

            model.addRow(row);
        }
    }
    
    public void ShowItem(int index)
    {
        txt_hid.setText(Integer.toString(getHotelList().get(index).getHid()));
        txt_hname.setText(getHotelList().get(index).getHname());
        txt_hprice.setText(Float.toString(getHotelList().get(index).getHprice()));
        lbl_image.setIcon(ResizeImage(null,getHotelList().get(index).getHpic()));
    }
    
     
     
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_hid = new javax.swing.JLabel();
        lbl_hname = new javax.swing.JLabel();
        lbl_hprice = new javax.swing.JLabel();
        lbl_hpic = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();
        Btn_Choose_Image = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_Hotels = new javax.swing.JTable();
        txt_hname = new javax.swing.JTextField();
        txt_hprice = new javax.swing.JTextField();
        Btn_Insert = new javax.swing.JButton();
        txt_hid = new javax.swing.JTextField();
        Btn_Update = new javax.swing.JButton();
        Btn_Delete = new javax.swing.JButton();
        Hotels_Details_Banner = new javax.swing.JLabel();
        Btn_First = new javax.swing.JButton();
        Btn_Next = new javax.swing.JButton();
        Btn_Previous = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_hid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_hid.setText("Hotel ID      :");
        jPanel1.add(lbl_hid, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 92, 87, 25));

        lbl_hname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_hname.setText("Hotel Name :");
        jPanel1.add(lbl_hname, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 123, 87, 25));

        lbl_hprice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_hprice.setText("Hotel Price  :");
        jPanel1.add(lbl_hprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 154, 87, 25));

        lbl_hpic.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_hpic.setText("Hotel Pic     :");
        jPanel1.add(lbl_hpic, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 185, 87, 25));

        lbl_image.setBackground(new java.awt.Color(0, 102, 102));
        lbl_image.setForeground(new java.awt.Color(0, 153, 51));
        lbl_image.setOpaque(true);
        jPanel1.add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 216, 141, 98));

        Btn_Choose_Image.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Choose_Image.setText("Choose Image");
        Btn_Choose_Image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Choose_ImageActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Choose_Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 325, -1, -1));

        JTable_Hotels.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hotel ID", "Hotel Name", "Hotel Price", "Hotel pic"
            }
        ));
        JTable_Hotels.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_HotelsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_Hotels);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 440, 170));
        jPanel1.add(txt_hname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 90, -1));
        jPanel1.add(txt_hprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 90, -1));

        Btn_Insert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Insert.setText("Insert");
        Btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InsertActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));
        jPanel1.add(txt_hid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 90, -1));

        Btn_Update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Update.setText("Update");
        Btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, -1));

        Btn_Delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Delete.setText("Delete");
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, -1, -1));

        Hotels_Details_Banner.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Hotels_Details_Banner.setText("Tour Management System - Hotels Details");
        jPanel1.add(Hotels_Details_Banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        Btn_First.setText("First");
        Btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FirstActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_First, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        Btn_Next.setText("Next");
        Btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NextActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        Btn_Previous.setText("Previous");
        jPanel1.add(Btn_Previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, -1, -1));

        Btn_Last.setText("Last");
        Btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LastActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Last, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, -1, -1));

        jButton1.setText("Back To Admin Panel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Choose Image Button Click Event
    private void Btn_Choose_ImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Choose_ImageActionPerformed
        // TODO add your handling code here:
        
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl_image.setIcon(ResizeImage(path, null));
            ImgPath = path;
        }
        else{
            JOptionPane.showMessageDialog(null, "No File Selected");
            System.out.println("No File Selected");
            }  
    }//GEN-LAST:event_Btn_Choose_ImageActionPerformed

//Insert Button Click Event    
    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InsertActionPerformed
        // TODO add your handling code here:
         if(checkinputs() && ImgPath != null)
        {
            try{
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO hotelsp(hid,hname, hprice, hpic)"
                        + "values(?,?,?,?)");

                ps.setString(1, txt_hid.getText());
                ps.setString(2, txt_hname.getText());
                ps.setString(3, txt_hprice.getText());

                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(4, img);
                
                ps.executeUpdate();
                
                Show_Product_In_JTable();

                JOptionPane.showMessageDialog(null, "Data Inserted");

            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }else{
            JOptionPane.showMessageDialog(null, "One or More Fields are Empty");
            }

        System.out.println("Hotel ID => "+txt_hid.getText());
        System.out.println("Hotel Name => "+txt_hname.getText());
        System.out.println("Hotel Price => "+txt_hprice.getText());
        System.out.println("Hotel Pic => "+ImgPath);
        
         Show_Product_In_JTable();

    }//GEN-LAST:event_Btn_InsertActionPerformed

//Update Button Click Event
    private void Btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_UpdateActionPerformed
        // TODO add your handling code here:
        if(checkinputs() && txt_hid.getText() != null)
        {
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = getConnection();
            
        //Update without image
            if(ImgPath == null)
            {
                try{
                    UpdateQuery = "UPDATE hotelsp SET hname=?, hprice=? WHERE hid=?";
                            
                            ps = con.prepareStatement(UpdateQuery);
                            
                            ps.setString(1, txt_hname.getText());
                            ps.setString(2, txt_hprice.getText());
                            ps.setInt(3, Integer.parseInt(txt_hid.getText()));
                   
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Record Updated Without Image");
                
                }catch(SQLException ex){
                            Logger.getLogger(Hotels_Window.class.getName()).log(Level.SEVERE,null,ex);
                            }
            }
        //Update with image
            else
            {
            
            try{
            InputStream img =new FileInputStream(new File(ImgPath));
                
                UpdateQuery = "UPDATE hotelsp SET hname=?, hprice=?, hpic=? WHERE hid=?";
                
                ps = con.prepareStatement(UpdateQuery);
                ps.setString(1, txt_hname.getText());
                ps.setString(2, txt_hprice.getText());

                ps.setBlob(3, img);
                ps.setInt(4, Integer.parseInt(txt_hid.getText()));

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Updated With Image");
                
            }catch (Exception ex){
                   JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
       }else{
                JOptionPane.showMessageDialog(null, "One or More fields are empty or wrong");
            }
         Show_Product_In_JTable();
    }//GEN-LAST:event_Btn_UpdateActionPerformed

//Delete Button Click Event
    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteActionPerformed
        // TODO add your handling code here:
        if(!txt_hid.getText().equals("")){
        
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM hotelsp WHERE hid = ?");
                int hid = Integer.parseInt(txt_hid.getText());
                ps.setInt(1, hid);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Hotel Deleted");
                
            } catch (SQLException ex) {
                Logger.getLogger(Hotels_Window.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Hotel Not Deleted");
            }
        }
        else{
        JOptionPane.showMessageDialog(null, "Hotel Not Deleted. No Hotel Id Found");
        }
        Show_Product_In_JTable();
    }//GEN-LAST:event_Btn_DeleteActionPerformed

//Row Click Event
    private void JTable_HotelsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_HotelsMouseClicked
        // TODO add your handling code here:
        int index = JTable_Hotels.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_JTable_HotelsMouseClicked

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
        // TODO add your handling code here:
        pos = 0;
        ShowItem(pos);
    }//GEN-LAST:event_Btn_FirstActionPerformed

    private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NextActionPerformed
        // TODO add your handling code here:
        pos++;
        if(pos>=getHotelList().size())
        {
            pos = getHotelList().size()-1;
        }
        ShowItem(pos);
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed
        // TODO add your handling code here:
        pos=getHotelList().size()-1;
        ShowItem(pos);
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //AdminPanel a2=new AdminPanel("");
        //a2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */ 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hotels_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hotels_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hotels_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hotels_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hotels_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Choose_Image;
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_Insert;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Previous;
    private javax.swing.JButton Btn_Update;
    private javax.swing.JLabel Hotels_Details_Banner;
    private javax.swing.JTable JTable_Hotels;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_hid;
    private javax.swing.JLabel lbl_hname;
    private javax.swing.JLabel lbl_hpic;
    private javax.swing.JLabel lbl_hprice;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JTextField txt_hid;
    private javax.swing.JTextField txt_hname;
    private javax.swing.JTextField txt_hprice;
    // End of variables declaration//GEN-END:variables
}
