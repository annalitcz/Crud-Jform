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
 * @author AnnanID
 */
public class AllData extends javax.swing.JFrame {
     public Statement st;
     public ResultSet rs;
     Connection cn = koneksi.koneksi.BukaKoneksi();
     
    public AllData() {
        initComponents();
        TampilDataBarang();
        TampilDataPelanggan();
        TampilDataFaktur();
        TampilDataKwitansi();
        
        barang.setDefaultEditor(Object.class, null);
        pelanggan.setDefaultEditor(Object.class, null);
        faktur.setDefaultEditor(Object.class, null);
        kwitansi.setDefaultEditor(Object.class, null);
    }
    
    private void TampilDataBarang(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM barang");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Kode Barang");
            model.addColumn("Nama Barang");
            model.addColumn("Stok Barang");
            model.addColumn("Harga Barang");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while(rs.next()){
              Object[]data = {
                rs.getString("kode_brg"),
                rs.getString("nama_brg"),
                rs.getString("stock_brg"),
                rs.getString("harga_brg"),

              };
              model.addRow(data);
              barang.setModel(model);
            }
            
        }catch (SQLException e){
            
        }
    }
    
    private void TampilDataPelanggan(){
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
              pelanggan.setModel(model);
            }
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "error");
        }
    }
    private void TampilDataFaktur(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM faktur");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nomor Faktur");
            model.addColumn("Tanggal");
            model.addColumn("Kode Pelanggan");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while(rs.next()){
              Object[]data = {
                rs.getString("nomor_faktur"),
                rs.getString("tgl_faktur"),
                rs.getString("kode_plg"),
              };
              model.addRow(data);
              faktur.setModel(model);
            }
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "error");
        }
    }
    private void TampilDataKwitansi(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM kwitansi");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nomor Kwitansi");
            model.addColumn("Tanggal");
            model.addColumn("Nomor Faktur");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            boolean isEmpty = true;
            
            while(rs.next()){
              isEmpty = false;
              Object[]data = {
                rs.getString("nomer_kwi"),
                rs.getString("tgl_kwi"),
                rs.getString("nomor_faktur"),
              };
              model.addRow(data);
              kwitansi.setModel(model);
            }
            
            if (isEmpty) {
                JOptionPane.showMessageDialog(null, "Data masih kosong", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch (HeadlessException | SQLException e){    
            JOptionPane.showMessageDialog(null, "Data gagal dimuat. Terjadi kesalahan: " +
            e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        barang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        pelanggan = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        faktur = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        kwitansi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Semua Data");

        barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama", "Stok ", "Harga"
            }
        ));
        jScrollPane1.setViewportView(barang);

        pelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Pelanggan", "Nama", "Alamat", "No.HP"
            }
        ));
        jScrollPane2.setViewportView(pelanggan);

        faktur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nomor Faktur", "Tanggal", "Kode Pelanggan"
            }
        ));
        jScrollPane3.setViewportView(faktur);

        kwitansi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nomor Kwitansi", "Tanggal", "Nomor Faktur"
            }
        ));
        jScrollPane4.setViewportView(kwitansi);

        jLabel2.setText("barang");

        jLabel3.setText("pelanggan");

        jLabel4.setText("Faktur");

        jLabel5.setText("kwitansi");

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(223, 223, 223))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(429, 429, 429)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(464, 464, 464)
                        .addComponent(refresh)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(refresh)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        TampilDataBarang();
        TampilDataPelanggan();
        TampilDataFaktur();
        TampilDataKwitansi();
    }//GEN-LAST:event_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(AllData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AllData().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable barang;
    private javax.swing.JTable faktur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable kwitansi;
    private javax.swing.JTable pelanggan;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables
}
