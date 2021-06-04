/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Notebook 15
 */
public class Payment_Window extends javax.swing.JFrame {
String username;
    /**
     * Creates new form Payment_Window
     */
    public Payment_Window(String un) {
        initComponents();
        Show_Product_In_JTable();
        
    }
    
      public Connection getConnection()
      {
          Connection con = null;
          
          try{
              con=DriverManager.getConnection("jdbc:mysql://localhost/hotels_db","root","");
              //JOptionPane.showMessageDialog(null, "Connected");
              System.out.println("Connected");
              return con;
          }catch (SQLException ex){
                    Logger.getLogger(Payment_Window.class.getName()).log(Level.SEVERE,null,ex);
                    JOptionPane.showMessageDialog(null, "Not Connected");
                    System.out.println("Not Connected");
                    return null;
                }
      }
    
    public ArrayList<PaymentDetails> getPaymentDetailsList(){
         
     ArrayList<PaymentDetails>  paymentDetailsList = new ArrayList<PaymentDetails>();
    Connection con = getConnection();
     
     String query = "SELECT * FROM payment";
     
     Statement st;
     ResultSet rs;
     
     try{
        st = con.createStatement();
        rs = st.executeQuery(query);
        PaymentDetails paymentDetails;
     
            while(rs.next())
            {
                paymentDetails = new PaymentDetails(rs.getInt("Payment_ID"),rs.getString("Type"), rs.getString("Card_Number"),rs.getString("Expire_Date"), rs.getInt("Security_Code"),rs.getInt("Amount"));
                paymentDetailsList.add(paymentDetails);
            }
     
    }catch(SQLException ex){
        Logger.getLogger(Payment_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    return paymentDetailsList;
}
// 2 - Populate the JTable
     
    public void Show_Product_In_JTable()
    {
            
        ArrayList<PaymentDetails> list = getPaymentDetailsList();
        DefaultTableModel model = (DefaultTableModel)JTable_Payment_Details.getModel();
         
        Object[] row = new Object[6];
        for(int i=0; i<list.size();i++)
        {
            row[0]=list.get(i).getPid();
            row[1]=list.get(i).getType();
            row[2]=list.get(i).getCN();
            row[3]=list.get(i).getED();
            row[4]=list.get(i).getSC();
            row[5]=list.get(i).getAmount();

            model.addRow(row);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_Payment_Details = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Tour Management System - Admin Panel");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Payment Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 55, -1, -1));

        JTable_Payment_Details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment ID", "Card Type", "Card No", "Expiary Date", "Amount"
            }
        ));
        jScrollPane1.setViewportView(JTable_Payment_Details);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 136, 766, 149));

        jButton1.setText("Back To Admin Panel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 326, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       // AdminPanel a2=new AdminPanel("");
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
            java.util.logging.Logger.getLogger(Payment_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment_Window("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable_Payment_Details;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
