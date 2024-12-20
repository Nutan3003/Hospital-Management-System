
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author admin
 */
public class Item extends javax.swing.JFrame {

    /**
     * Creates new form patient
     */
    public Item() throws SQLException {
        initComponents();
        Connect();
        AutoId();
        Item_table();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {
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

    public void AutoId() {
        try {
            Statement a = (Statement) con.createStatement();
            rs = a.executeQuery("SELECT MAX(item_id) FROM item");

            if (rs.next()) {
                String maxId = rs.getString(1);  // Retrieve the max ID from the first column

                if (maxId == null) {
                    lblitemid.setText("IU001");  // No records, so start from PS001
                } else {
                    // Extract the numeric part of the ID, increment it, and format it back to PSxxx
                    long id = Long.parseLong(maxId.substring(2));  // Get the number part of PSxxx
                    id++;  // Increment the ID
                    lblitemid.setText("IU" + String.format("%03d", id));  // Format with leading zeros
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Item_table() {

        try {
            pst = con.prepareStatement("SELECT * FROM item");
            rs = pst.executeQuery();
            ResultSetMetaData Rsm = (ResultSetMetaData) rs.getMetaData();

            int c;
            c = Rsm.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            while (rs.next()) {

                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("item_id"));
                    v2.add(rs.getString("item_name"));
                    v2.add(rs.getString("description"));
                    v2.add(rs.getString("sellprice"));
                    v2.add(rs.getString("buyprice"));
                    v2.add(rs.getString("qty"));

                }
                df.addRow(v2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        lblpno = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblitemid = new javax.swing.JLabel();
        txtitemname = new javax.swing.JTextField();
        txtitemdesc = new javax.swing.JTextField();
        txtsellprice = new javax.swing.JTextField();
        txtbuyprice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtqty = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
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
        lblpno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Item Id");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Item Name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Description");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sell Price");

        lblitemid.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblitemid.setForeground(new java.awt.Color(255, 255, 0));
        lblitemid.setText("jLabel6");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Qty");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Buy Price");

        javax.swing.GroupLayout lblpnoLayout = new javax.swing.GroupLayout(lblpno);
        lblpno.setLayout(lblpnoLayout);
        lblpnoLayout.setHorizontalGroup(
            lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblpnoLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtqty)
                    .addComponent(txtbuyprice)
                    .addComponent(txtsellprice)
                    .addComponent(txtitemname, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(txtitemdesc)
                    .addComponent(lblitemid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );
        lblpnoLayout.setVerticalGroup(
            lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblpnoLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblitemid, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtitemname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtitemdesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtsellprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtbuyprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(lblpnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item No", "Item Name", "Description", "Sell Price", "Buy Price", "Qty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Create Item");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblpno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblpno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        String itemid = lblitemid.getText();
        String itemname = txtitemname.getText();
        String itemdesc = txtitemdesc.getText();
        String itemsellprice = txtsellprice.getText();
        String itembuyprice = txtbuyprice.getText();
        String itemqty = txtqty.getText();

        try {
            // Correct the SQL statement with VALUES clause
            pst = con.prepareStatement("INSERT INTO item(item_id ,item_name,description,sellprice,buyprice,qty ) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1, itemid);
            pst.setString(2, itemname);
            pst.setString(3, itemdesc);
            pst.setString(4, itemsellprice);
            pst.setString(5, itembuyprice);
            pst.setString(6, itemqty);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Item Inserted Successfully");

            AutoId();  // Resetting the auto ID for the next patient
            txtitemname.setText("");
            txtitemdesc.setText("");
            txtsellprice.setText("");
            txtbuyprice.setText("");
            txtqty.setText("");
            txtitemname.requestFocus();
            Item_table();

        } catch (SQLException ex) {
            Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        lblitemid.setText(d1.getValueAt(selectIndex, 0).toString());
        txtitemname.setText(d1.getValueAt(selectIndex, 1).toString());
        txtitemdesc.setText(d1.getValueAt(selectIndex, 2).toString());
        txtsellprice.setText(d1.getValueAt(selectIndex, 3).toString());
        txtbuyprice.setText(d1.getValueAt(selectIndex, 4).toString());
        txtqty.setText(d1.getValueAt(selectIndex, 5).toString());

        button1.setEnabled(false);


    }//GEN-LAST:event_jTable1MouseClicked

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        //Update button
        String itemname = txtitemname.getText();
        String itemdesc = txtitemdesc.getText();
        String itemqty = txtqty.getText();
        String itemid = lblitemid.getText();

        try {
            // Convert price fields to double to ensure numeric input
            double itemsellprice = Double.parseDouble(txtsellprice.getText());
            double itembuyprice = Double.parseDouble(txtbuyprice.getText());

            // Prepare SQL statement
            pst = con.prepareStatement("UPDATE item SET item_name = ?, description = ?, sellprice = ?, buyprice = ?, qty = ? WHERE item_id = ?");

            // Set values in the prepared statement
            pst.setString(1, itemname);
            pst.setString(2, itemdesc);
            pst.setDouble(3, itemsellprice);
            pst.setDouble(4, itembuyprice);
            pst.setString(5, itemqty);
            pst.setString(6, itemid);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Item updated");

            // Reset input fields after update
            AutoId();
            txtitemname.setText("");
            txtitemdesc.setText("");
            txtsellprice.setText("");
            txtbuyprice.setText("");
            txtqty.setText("");
            txtitemname.requestFocus();
            Item_table();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for sell price and buy price.");
        } catch (SQLException ex) {
            Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
        }

//        String itemname = txtitemname.getText();
//        String itemdesc = txtitemdesc.getText();
//        String itemsellprice = txtsellprice.getText();
//        String itembuyprice = txtbuyprice.getText();
//        String itemqty = txtqty.getText();
//         String itemid = lblitemid.getText();
//
//        try {
//            // Correct the SQL statement with VALUES clause
//
//            pst = con.prepareStatement("update item set item_name=? ,description=?,sellprice=?,buyprice=?,qty=? where item_id=? ");
//          
//            pst.setString(1, itemname);
//            pst.setString(2, itemdesc);
//            pst.setString(3, itemsellprice);
//            pst.setString(4, itembuyprice);
//            pst.setString(5, itemqty);
//              pst.setString(6, itemid);
//
//            pst.executeUpdate();
//
//            JOptionPane.showMessageDialog(this, "Item updated");
//
//            AutoId();  // Resetting the auto ID for the next patient
//            txtitemname.setText("");
//            txtitemdesc.setText("");
//            txtsellprice.setText("");
//            txtbuyprice.setText("");
//            txtqty.setText("");
//            txtitemname.requestFocus();
//            Item_table();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
//        }
// TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        //Delete button

        String itemid = lblitemid.getText();

        try {
            // Correct the SQL statement with VALUES clause
            pst = con.prepareStatement("delete from item where item_id=?");

            pst.setString(1, itemid);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Deleted Succesfully");

            AutoId();  // Resetting the auto ID for the next patient
            txtitemname.setText("");
            txtitemdesc.setText("");
            txtsellprice.setText("");
            txtbuyprice.setText("");
            txtqty.setText("");

            Item_table();
            button1.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
        }// TODO add your handling code here:
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblitemid;
    private javax.swing.JPanel lblpno;
    private javax.swing.JTextField txtbuyprice;
    private javax.swing.JTextField txtitemdesc;
    private javax.swing.JTextField txtitemname;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtsellprice;
    // End of variables declaration//GEN-END:variables
}
