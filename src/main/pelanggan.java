/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Annan ID
 */
public class pelanggan extends javax.swing.JFrame {
     public Statement st;
     public ResultSet rs;
     Connection cn = koneksi.koneksi.BukaKoneksi();
     
    public pelanggan() {
        initComponents();
        TampilData();
    }
    
     private void Bersih(){
        kode_plg.setText("");
        nama_plg.setText("");
        alamat_plg.setText("");
        hp_plg.setText("");
       
        simpan.setText("Simpan");
        kode_plg.setEditable(true);
    }
    
    private void TampilData(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM pelanggan");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Kode Pelanggan");
            model.addColumn("Nama");
            model.addColumn("Alamat");
            model.addColumn("No. Hp");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while(rs.next()){
              Object[]data = {
                rs.getString("kode_plg"),
                rs.getString("nama_plg"),
                rs.getString("alamat_plg"),
                rs.getString("hp_plg"),

              };
              model.addRow(data);
              data_plg.setModel(model);
            }
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "error");
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
        jLabel2 = new javax.swing.JLabel();
        kode_plg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nama_plg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        alamat_plg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hp_plg = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        data_plg = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("PELANGGAN");

        jLabel2.setText("Kode Pelanggan");

        jLabel3.setText("Nama Pelanggan");

        jLabel4.setText("Alamat");

        jLabel5.setText("No. Hp");

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        data_plg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Pelanggan", "Nama", "Alamat", "No. Hp"
            }
        ));
        data_plg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_plgMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(data_plg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alamat_plg, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nama_plg, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                .addComponent(kode_plg))
                            .addComponent(hp_plg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(simpan)
                        .addGap(18, 18, 18)
                        .addComponent(batal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapus)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(kode_plg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nama_plg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(alamat_plg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(hp_plg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpan)
                            .addComponent(hapus)
                            .addComponent(batal)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        try{
            st=cn.createStatement();
            if(kode_plg.getText().equals("") || nama_plg.getText().equals("")
               || alamat_plg.getText().equals("")|| hp_plg.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "Validasi Data",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if("Simpan".equals(simpan.getText())){
               String cek = "SELECT * from pelanggan WHERE kode_plg = '" + kode_plg.getText() + "'";
               rs = st.executeQuery(cek);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Upsss....ID ini sudah ada");
                }else{
                    String sql = "INSERT INTO pelanggan VALUES ('" + kode_plg.getText()+
                                 "','" + nama_plg.getText() +
                                 "','" + alamat_plg.getText() +
                                 "','" + hp_plg.getText() + "')";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                    Bersih();
                    TampilData();
                }
            }else{
                //aksi ubah data
                String update = "UPDATE pelanggan SET nama_plg = ' " + nama_plg.getText() +
                                "', alamat_plg = '" + alamat_plg.getText() +
                                "', hp_plg = '" + hp_plg.getText() +
                                "' WHERE kode_plg = '" + kode_plg.getText() + "'";
                st.executeUpdate(update);
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                Bersih();
                TampilData();
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        Bersih();
    }//GEN-LAST:event_batalActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        if(kode_plg.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Silahlan Pilih Data yang akan dihapus !");
        }else{
            int jawab = JOptionPane.showConfirmDialog(null, 
                    "Data ini akan dihapus, lanjutkan??","Konfirmasi",
                    JOptionPane.YES_NO_OPTION);
            if(jawab == 0){
                try{
                    st = cn.createStatement();
                    String sql = "DELETE FROM pelanggan WHERE kode_plg = '" + kode_plg.getText() + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
                    TampilData();
                    Bersih();
                    
                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null, "error");
                }
            }
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void data_plgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_plgMouseClicked
        // TODO add your handling code here:
        kode_plg.setText(data_plg.getValueAt(data_plg.getSelectedRow(),0).toString());
        nama_plg.setText(data_plg.getValueAt(data_plg.getSelectedRow(),1).toString());
        alamat_plg.setText(data_plg.getValueAt(data_plg.getSelectedRow(),2).toString());
        hp_plg.setText(data_plg.getValueAt(data_plg.getSelectedRow(),3).toString());
        
        
        kode_plg.setEditable(false);
        simpan.setText("Ubah");
    }//GEN-LAST:event_data_plgMouseClicked

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
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new pelanggan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat_plg;
    private javax.swing.JButton batal;
    private javax.swing.JTable data_plg;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField hp_plg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kode_plg;
    private javax.swing.JTextField nama_plg;
    private javax.swing.JButton simpan;
    // End of variables declaration//GEN-END:variables
}
