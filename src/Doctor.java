
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Doctor extends javax.swing.JFrame {

    /**
     * Creates new form patient
     */
    public Doctor() throws SQLException {
        initComponents();
        
    }
    int id;
    String uctype;
    int newid;
            
    public Doctor(int id,String utype) throws SQLException {
        initComponents();
        this.id=id;
        this.uctype=utype;
        
        newid=id;
        //JOptionPane.showMessageDialog(this,newid);
        Connect();
        AutoId();
       
        Doctor_table();
       
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
  public void Connect(){
    try {
        Class.forName("com.mysql.jdbc.Driver");  // MySQL JDBC driver
       con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/saihospital?useSSL=false", "root", "ViruNuta2104");
       System.out.println("Connected ");

  // Replace with your DB credentials
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(user.class.getName()).log(Level.SEVERE, "Driver not found", ex);
    } catch (java.sql.SQLException ex) {
        Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
    }
}
  //Auto increment code
 public void AutoId(){
    try {
        Statement a = (Statement) con.createStatement();
        rs = a.executeQuery("SELECT MAX(d_id) FROM doctor");
        rs.next();
        rs.getString("MAX(d_id)");

        
           if(rs.getString("MAX(d_id)")==null) {
               txtdno.setText("DS001");
           }else {
                // Extract the numeric part of the ID, increment it, and format it back to PSxxx
                long id = Long.parseLong(rs.getString("MAX(d_id)").substring(2));  // Get the number part of PSxxx
                id++;  // Increment the ID
                txtdno.setText("DS" + String.format("%03d", id));  // Format with leading zeros
            }
        
    } catch (SQLException ex) {
        Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
    }
}
 
 public void Doctor_table(){
   
        try {
            pst = con.prepareStatement("SELECT * FROM doctor where log_id=?");
            pst.setInt(1, newid);
            rs = pst.executeQuery();
            ResultSetMetaData Rsm=(ResultSetMetaData) rs.getMetaData();
            
            int c;
            c=Rsm.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                
             
                Vector v2=new Vector();
                for(int i=1;i<=c;i++){
                v2.add(rs.getString("d_id"));
                v2.add(rs.getString("d_name"));
                v2.add(rs.getString("specialization"));
                v2.add(rs.getString("qualification"));
                v2.add(rs.getString("channelFees"));
                 v2.add(rs.getString("phone"));
                v2.add(rs.getString("room"));
              
                
                }
               df.addRow(v2);
            }
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

  
  
  

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        lblpno = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtdno = new javax.swing.JLabel();
        txtdname = new javax.swing.JTextField();
        txtdspe = new javax.swing.JTextField();
        txtdqua = new javax.swing.JTextField();
        txtspho = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtdcha = new javax.swing.JTextField();
        txtdrom = new javax.swing.JSpinner();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));

        lblpno.setBackground(new java.awt.Color(0, 0, 204));
        lblpno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doctor Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Doctor No:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Doctor Name:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Specilization:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Qualification:");

        txtdno.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtdno.setForeground(new java.awt.Color(255, 255, 0));
        txtdno.setText("jLabel6");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phone No:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Channel Fees:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Room No:");

        javax.swing.GroupLayout lblpnoLayout = new javax.swing.GroupLayout(lblpno);
        lblpno.setLayout(lblpnoLayout);
        lblpnoLayout.setHorizontalGroup(
            lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblpnoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(lblpnoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtdqua, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lblpnoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtdspe, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lblpnoLayout.createSequentialGroup()
                        .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblpnoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblpnoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)))
                        .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdno, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdname, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(lblpnoLayout.createSequentialGroup()
                        .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(lblpnoLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel9))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdcha)
                            .addGroup(lblpnoLayout.createSequentialGroup()
                                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtspho, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                    .addComponent(txtdrom))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        lblpnoLayout.setVerticalGroup(
            lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblpnoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtdno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdspe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtdqua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtdcha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtspho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(39, 39, 39)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtdrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        button1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        button1.setLabel("Add");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        button2.setLabel("Update");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        button3.setLabel("Delete");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        button4.setLabel("Exit");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Doctor No", "Doctor Name", "Specilization", "Qualification", "Channel Fees", "Phone No", "Room No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Doctor Registration");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lblpno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(311, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblpno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(467, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
    String did = txtdno.getText();
    String dname = txtdname.getText();
    String dsp = txtdspe.getText();
    String dqua = txtdqua.getText();
    String dch = txtdcha.getText();
    String dph =  txtspho.getText();
    String droom = txtdrom.getValue().toString();

   
 
    try {
        // Correct the SQL statement with VALUES clause
        pst = con.prepareStatement("INSERT INTO doctor (d_id,d_name,specialization,qualification,channelFees,phone,room,log_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        pst.setString(1, did);
        pst.setString(2, dname);
        pst.setString(3, dsp);
        pst.setString(4, dqua);
        pst.setString(5, dch);
        pst.setString(6, dph);
        pst.setString(7, droom);
        pst.setInt(8,newid);
        
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Doctor Inserted Successfully");
        
        AutoId();  // Resetting the auto ID for the next patient
       
        txtdno.setText("");
        txtdname.setText("");
        txtdspe.setText("");
        txtdqua.setText("");
        txtdcha.setText("");
        txtspho.setText("");
        txtdrom.setValue(0);
     
   
        txtdname.requestFocus();
        Doctor_table();
        
    } catch (SQLException ex) {
        Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_button1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1=(DefaultTableModel) jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        txtdno.setText(d1.getValueAt(selectIndex,0).toString());
        txtdname.setText(d1.getValueAt(selectIndex,1).toString());
        txtdspe.setText(d1.getValueAt(selectIndex,2).toString());
        txtdqua.setText(d1.getValueAt(selectIndex,3).toString());
       txtdcha.setText(d1.getValueAt(selectIndex,4).toString());
        txtspho.setText(d1.getValueAt(selectIndex,5).toString());
        txtdrom.setValue(Integer.parseInt(d1.getValueAt(selectIndex,6).toString()));
        
        
     
        
        button1.setEnabled(false);
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
   //Update button
    String did = txtdno.getText();
    String dname = txtdname.getText();
    String dsp = txtdspe.getText();
    String dqua = txtdqua.getText();
    String dch = txtdcha.getText();
    String dph =  txtspho.getText();
    String droom = txtdrom.getValue().toString();

   
 
    try {
        // Correct the SQL statement with VALUES clause
        pst = con.prepareStatement("update doctor set d_name=?,specialization=?,qualification=?,channelFees=?,phone=?,room=? where d_id =? ");

        pst.setString(1, dname);
        pst.setString(2, dsp);
        pst.setString(3, dqua);
        pst.setString(4, dch);
        pst.setString(5, dph);
        pst.setString(6, droom);
       
        pst.setString(7, did);
        
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Doctor Updated Successfully");
        
        AutoId();  // Resetting the auto ID for the next patient
       
        txtdno.setText("");
        txtdname.setText("");
        txtdspe.setText("");
        txtdqua.setText("");
        txtdcha.setText("");
        txtspho.setText("");
        txtdrom.setValue(0);
     
   
        txtdname.requestFocus();
        Doctor_table();
        button1.setEnabled(true);
        
    } catch (SQLException ex) {
        Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
    }
        
// TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        //Delete button
  
   String did = txtdno.getText();
    

   
 
    try {
        // Correct the SQL statement with VALUES clause
        pst = con.prepareStatement("delete from doctor where d_id=? ");

      
       
        pst.setString(1, did);
        
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Doctor Deleted Successfully");
        AutoId();
        txtdno.setText("");
        txtdname.setText("");
        txtdspe.setText("");
        txtdqua.setText("");
        txtdcha.setText("");
        txtspho.setText("");
        txtdrom.setValue(0);
     
   
        txtdname.requestFocus();
        Doctor_table();
        button1.setEnabled(true);
        
    } catch (SQLException ex) {
        Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
    }
    
   
  
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:Exit code
        this.setVisible(false);
    }//GEN-LAST:event_button4ActionPerformed

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
            java.util.logging.Logger.getLogger(patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new patient().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel lblpno;
    private javax.swing.JTextField txtdcha;
    private javax.swing.JTextField txtdname;
    private javax.swing.JLabel txtdno;
    private javax.swing.JTextField txtdqua;
    private javax.swing.JSpinner txtdrom;
    private javax.swing.JTextField txtdspe;
    private javax.swing.JTextField txtspho;
    // End of variables declaration//GEN-END:variables
}
