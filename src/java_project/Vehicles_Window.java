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

/**
 *
 * @author Notebook 15
 */
public class Vehicles_Window extends javax.swing.JFrame {

    /**
     * Creates new form Vehicles_Window
     */
    public Vehicles_Window() {
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
          if(   txt_vtype.getText() == null 
             || txt_vrate.getText() == null )
                {
                    JOptionPane.showMessageDialog(null, "Invalid Inputs");
                    return false;
                }
          else
          {
            try{
                Float.parseFloat(txt_vrate.getText());
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
     public ImageIcon ResizeImage(String imagePath, byte[] Vehicle_Pic)
      {
          ImageIcon myImage = null;
          
          if(imagePath != null )
          {
              myImage = new ImageIcon(imagePath);
          }
          else{
              myImage = new ImageIcon(Vehicle_Pic);
          }
          
          Image img = myImage.getImage();
          Image img2 = img.getScaledInstance(lbl_vimage.getWidth(), lbl_vimage.getHeight(), Image.SCALE_SMOOTH);
          ImageIcon image = new ImageIcon(img2);
          return image;
      }
     
//Display Data In JTable
     
     // 1 - Fill Array List with Data
     
    /**
     *
     * @return
     */
         
     public ArrayList<Vehicle> getVehicleList(){
         
     ArrayList<Vehicle>  vehicleList = new ArrayList<Vehicle>();
    Connection con = getConnection();
     
     String query = "SELECT * FROM vehicle";
     
     Statement st;
     ResultSet rs;
     
     try{
        st = con.createStatement();
        rs = st.executeQuery(query);
        Vehicle vehicle;
     
            while(rs.next())
            {
                vehicle = new Vehicle(rs.getInt("Vehicle_ID"),rs.getString("Type"), Float.parseFloat(rs.getString("Rate")),rs.getBytes("Vehicle_Pic"));
                vehicleList.add(vehicle);
            }
     
    }catch(SQLException ex){
        Logger.getLogger(Hotels_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    return vehicleList;
}
// 2 - Populate the JTable
     
    public void Show_Product_In_JTable()
    {
            
        ArrayList<Vehicle> list = getVehicleList();
        DefaultTableModel model = (DefaultTableModel)JTable_Vehicles.getModel();
        model.setRowCount(0);
         
        Object[] row = new Object[4];
        for(int i=0; i<list.size();i++)
        {
            row[0]=list.get(i).getVid();
            row[1]=list.get(i).getVtype();
            row[2]=list.get(i).getVrate();
            row[3]=list.get(i).getVpic();

            model.addRow(row);
        }
    }
     
    public void ShowItem(int index)
    {
        txt_vid.setText(Integer.toString(getVehicleList().get(index).getVid()));
        txt_vtype.setText(getVehicleList().get(index).getVtype());
        txt_vrate.setText(Float.toString(getVehicleList().get(index).getVrate()));
        lbl_vimage.setIcon(ResizeImage(null,getVehicleList().get(index).getVpic()));
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
        lbl_vid = new javax.swing.JLabel();
        lbl_vtype = new javax.swing.JLabel();
        lbl_vrate = new javax.swing.JLabel();
        lbl_vpic = new javax.swing.JLabel();
        lbl_vimage = new javax.swing.JLabel();
        Btn_Choose_Image = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_Vehicles = new javax.swing.JTable();
        Btn_Insert = new javax.swing.JButton();
        Btn_Delete = new javax.swing.JButton();
        Btn_Update = new javax.swing.JButton();
        Btn_First = new javax.swing.JButton();
        Btn_Next = new javax.swing.JButton();
        Btn_Previous = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();
        txt_vrate = new javax.swing.JTextField();
        txt_vtype = new javax.swing.JTextField();
        txt_vid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_vid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_vid.setText("Vehicle ID");
        jPanel1.add(lbl_vid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 85, 29));

        lbl_vtype.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_vtype.setText("Vehicle Type");
        jPanel1.add(lbl_vtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 85, 29));

        lbl_vrate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_vrate.setText("Vehicle Rate");
        jPanel1.add(lbl_vrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 85, 29));

        lbl_vpic.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_vpic.setText("Vehicle Pic");
        jPanel1.add(lbl_vpic, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 85, 29));

        lbl_vimage.setBackground(new java.awt.Color(0, 0, 255));
        lbl_vimage.setOpaque(true);
        jPanel1.add(lbl_vimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 129, 92));

        Btn_Choose_Image.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Choose_Image.setText("Choose Image");
        Btn_Choose_Image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Choose_ImageActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Choose_Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tour Management System - Vehicle Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        JTable_Vehicles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehicle ID", "Vehicle Type", "Vehicle Rate", "Vehicle Pic"
            }
        ));
        JTable_Vehicles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_VehiclesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_Vehicles);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, 110));

        Btn_Insert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Insert.setText("Insert");
        Btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InsertActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        Btn_Delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Delete.setText("Delete");
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        Btn_Update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Update.setText("Update");
        Btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        Btn_First.setText("First");
        Btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FirstActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_First, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        Btn_Next.setText("Next");
        Btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NextActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, -1));

        Btn_Previous.setText("Previous");
        Btn_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PreviousActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));

        Btn_Last.setText("Last");
        Btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LastActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Last, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, -1, -1));
        jPanel1.add(txt_vrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 100, -1));
        jPanel1.add(txt_vtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 100, -1));
        jPanel1.add(txt_vid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 100, -1));

        jButton1.setText("Back to Admin Panel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Choose Image Button
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
            lbl_vimage.setIcon(ResizeImage(path, null));
            ImgPath = path;
        }
        else{
            JOptionPane.showMessageDialog(null, "No File Selected");
            System.out.println("No File Selected");
            }  
    }//GEN-LAST:event_Btn_Choose_ImageActionPerformed
//insert button click event
    
    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InsertActionPerformed
        // TODO add your handling code here:
         if(checkinputs() && ImgPath != null)
        {
            try{
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO vehicle(Vehicle_ID,Type, Rate, Vehicle_Pic)"
                        + "values(?,?,?,?)");

                ps.setString(1, txt_vid.getText());
                ps.setString(2, txt_vtype.getText());
                ps.setString(3, txt_vrate.getText());

                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(4, img);
                ps.executeUpdate();
                //Show_Product_In_JTable();

                JOptionPane.showMessageDialog(null, "Data Inserted");

            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }else{
            JOptionPane.showMessageDialog(null, "One or More Fields are Empty");
            }

        System.out.println("Hotel ID => "+txt_vid.getText());
        System.out.println("Hotel Name => "+txt_vtype.getText());
        System.out.println("Hotel Price => "+txt_vrate.getText());
        System.out.println("Hotel Pic => "+ImgPath);
        
        Show_Product_In_JTable();

    }//GEN-LAST:event_Btn_InsertActionPerformed
//Update Button
    private void Btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_UpdateActionPerformed
        // TODO add your handling code here:
        if(checkinputs() && txt_vid.getText() != null)
        {
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = getConnection();
            
        //Update without image
            if(ImgPath == null)
            {
                try{
                    UpdateQuery = "UPDATE vehicle SET Type=?, Rate=? WHERE Vehicle_ID=?";
                            
                            ps = con.prepareStatement(UpdateQuery);
                            ps.setString(1, txt_vtype.getText());
                            ps.setString(2, txt_vrate.getText());
                            ps.setInt(3, Integer.parseInt(txt_vid.getText()));
                                              
                            ps.executeUpdate();
                            
                            JOptionPane.showMessageDialog(null, "Record Updated Without Image");
                
                }catch(SQLException ex){
                            Logger.getLogger(Vehicles_Window.class.getName()).log(Level.SEVERE,null,ex);
                            }
                
            }
        //Update with image
            else
            {
            
            try{
            InputStream img =new FileInputStream(new File(ImgPath));
                
                UpdateQuery = "UPDATE vehicle SET Type=?,Rate=?,Vehicle_Pic=? WHERE Vehicle_ID=?";
                
                ps = con.prepareStatement(UpdateQuery);
                ps.setString(1, txt_vtype.getText());
                ps.setString(2, txt_vrate.getText());

                ps.setBlob(3, img);
                ps.setInt(3, Integer.parseInt(txt_vid.getText()));

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
      
        if(!txt_vid.getText().equals("")){
        
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM vehicle WHERE Vehicle_ID = ?");
                int Vehicle_ID = Integer.parseInt(txt_vid.getText());
                ps.setInt(1, Vehicle_ID);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Vehicle Deleted");
                
            } catch (SQLException ex) {
                Logger.getLogger(Vehicles_Window.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Vehicle Not Deleted");
            }
        }
        else{
        JOptionPane.showMessageDialog(null, "Vehicle Not Deleted. No Hotel Id Found");
        }
        Show_Product_In_JTable();
    }//GEN-LAST:event_Btn_DeleteActionPerformed

    //Table Row click Event
    private void JTable_VehiclesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_VehiclesMouseClicked
        // TODO add your handling code here:
        int index = JTable_Vehicles.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_JTable_VehiclesMouseClicked

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
        // TODO add your handling code here:
        pos = 0;
        ShowItem(pos);
    }//GEN-LAST:event_Btn_FirstActionPerformed

    private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NextActionPerformed
        // TODO add your handling code here:
            pos++;
        if(pos>=getVehicleList().size())
        {
            pos = getVehicleList().size()-1;
        }
        ShowItem(pos);
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void Btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PreviousActionPerformed
        // TODO add your handling code here:
        pos--;
        
        if(pos<0)
        {
            pos=0;
        }
        
        ShowItem(pos);
    }//GEN-LAST:event_Btn_PreviousActionPerformed

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed
        // TODO add your handling code here:
        pos=getVehicleList().size()-1;
        ShowItem(pos);
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //AdminPanel a1 = new AdminPanel("");
        //a1.setVisible(true);
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
            java.util.logging.Logger.getLogger(Vehicles_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vehicles_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vehicles_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vehicles_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vehicles_Window().setVisible(true);
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
    private javax.swing.JTable JTable_Vehicles;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_vid;
    private javax.swing.JLabel lbl_vimage;
    private javax.swing.JLabel lbl_vpic;
    private javax.swing.JLabel lbl_vrate;
    private javax.swing.JLabel lbl_vtype;
    private javax.swing.JTextField txt_vid;
    private javax.swing.JTextField txt_vrate;
    private javax.swing.JTextField txt_vtype;
    // End of variables declaration//GEN-END:variables
}
