package app;
import java.util.*;
import javax.swing.table.*;
public class UserFrame extends javax.swing.JFrame {

    /**
     * Creates new form UserFrame
     */
    
    DefaultTableModel table = new DefaultTableModel();
    
    //connects this frame to SQLConnect
    public SQLConnect query = new SQLConnect();
    public UserFrame() {
        initComponents();
        
        jComboBox1.removeAllItems();
        ArrayList data2 = query.select(new String[] {"ArtistID", "Name"}, "Artists");
        for (Object row:data2) {
        jComboBox1.addItem(row.toString());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);
        jTable2.getAccessibleContext().setAccessibleParent(jScrollPane1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 0, 420, 450));

        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Albums");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Artists");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Tracks");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Tracks by Artist");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 360, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/UserBackground.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        table = (DefaultTableModel) jTable2.getModel();
        table.setRowCount(0); //clears rows from table
        table.setColumnCount(0);//clears columns from table      
        table.addColumn("AlbumId");
        table.addColumn("Title");
        table.addColumn("ArtistId");

        //gets albums from database
        ArrayList data = query.select(new String[] {"AlbumId", "Title", "ArtistId"}, "albums");
        
        for(Object row : data) {
            table.addRow(row.toString().split("---"));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        table = (DefaultTableModel) jTable2.getModel();
        table.setRowCount(0); //clears rows from table
        table.setColumnCount(0);//clears columns from table      
        table.addColumn("ArtistId");
        table.addColumn("Name");
        
        //gets artists from database
        ArrayList data = query.select(new String[] {"ArtistId", "Name"}, "artists");
        
        for(Object row : data) {
            table.addRow(row.toString().split("---"));
    }//GEN-LAST:event_jButton2ActionPerformed
}
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        table = (DefaultTableModel) jTable2.getModel();
        table.setRowCount(0); //clears rows from table
        table.setColumnCount(0);//clears columns from table      
        table.addColumn("TrackId");
        table.addColumn("AlbumId");
        table.addColumn("Name");
        table.addColumn("Composer");
        
        //gets tracks from database
        ArrayList data = query.select(new String[] {"TrackId", "AlbumId", "Name", "Composer"}, "tracks");
        
        for(Object row : data) {
            table.addRow(row.toString().split("---"));
    }//GEN-LAST:event_jButton3ActionPerformed
}
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        table = (DefaultTableModel) jTable2.getModel();
        table.setRowCount(0); //clears rows from table
        table.setColumnCount(0);//clears columns from table   
        table.addColumn("AlbumId");
        table.addColumn("Title");
        table.addColumn("ArtistID");
        
        //store in array selection the id and name of artist
        String[] selection = jComboBox1.getSelectedItem().toString().split("---");
        //selection[0] -> artistId ; selection[1] -> Name
        
        //gets the tracks from database where the artistid matches
        ArrayList data = query.selectWhere(new String[] {"AlbumId", "Title", "ArtistID"}, "Albums", "ArtistID", selection[0]);
        for(Object row:data) {
            table.addRow(row.toString().split("---"));
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
