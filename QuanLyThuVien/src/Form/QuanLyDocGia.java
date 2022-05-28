/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DoiTuong.DocGia;
import ReadWrite.DocGiaFile;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell 7559
 */
public class QuanLyDocGia extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyDocGia
     */
    DocGiaFile file = new DocGiaFile();
    
    List<DocGia> list = file.read();
    List<DocGia> listSearch = new ArrayList<DocGia>();
    
    DefaultTableModel model;
    public int indexEdit;

    public QuanLyDocGia() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) tbDocGia.getModel();
        showResult();
    }

    public DocGia getDetailSach() {
        DocGia dg = new DocGia();
        
        dg.setMaDG(txtMDG.getText().trim());
        dg.setTenDG(txtTDG.getText().trim());
        dg.setDiaChi(txtDCDG.getText().trim());
        dg.setSdt(txtSDTDG.getText().trim());
        if(rbNam.isSelected()) {
            dg.setGioiTinh("Nam");
        } else {
            dg.setGioiTinh("Nữ");
        }
        return dg;
    }
   
    public boolean checkmhd() {
        for (DocGia dg : list) {
            if (dg.getMaDG().equals(txtMDG.getText().trim())) {
                return false;
            }
        }
        return true;
    }
    
     public void showResult() {
        model.setRowCount(0);
        for (DocGia dg : list) {
            model.addRow(new Object[]{
                dg.getMaDG(), dg.getTenDG(), dg.getGioiTinh(), dg.getDiaChi(),dg.getSdt()
            });
        }
    }
     public void cancelValues() {
        txtDCDG.setText("");
        txtMDG.setText("");
        txtSDTDG.setText("");
        txtTDG.setText("");
    }
    public void setDetaiSachDG(DocGia s){
        txtMDG1.setEditable(false);
        txtTDG1.setEnabled(false);
        txtSDTDG1.setEnabled(false);
        txtDCDG1.setEnabled(false);
        rbNam1.setEnabled(false);
        rbNu1.setEnabled(false);
        
        txtMDG1.setText(s.getMaDG());
        txtTDG1.setText(s.getTenDG());
        txtDCDG1.setText(s.getDiaChi());
        txtSDTDG1.setText(s.getSdt());
        
        if(s.getGioiTinh().equals("Nam")) {
            rbNam.setSelected(true);
        } else {
            rbNu.setSelected(true);
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

        jDialogThem = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnThemMoi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rbNam = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        rbNu = new javax.swing.JRadioButton();
        txtMDG = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTDG = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDCDG = new javax.swing.JTextField();
        txtSDTDG = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialogChiTiet = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rbNam1 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        rbNu1 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtMDG1 = new javax.swing.JTextField();
        txtTDG1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDCDG1 = new javax.swing.JTextField();
        txtSDTDG1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDocGia = new javax.swing.JTable();
        btnChiTietDG = new javax.swing.JButton();
        btnXoaDG = new javax.swing.JButton();
        btnDongDG = new javax.swing.JButton();
        btnThemDG = new javax.swing.JButton();

        jDialogThem.setLocation(new java.awt.Point(500, 100));
        jDialogThem.setSize(new java.awt.Dimension(280, 400));

        jLabel7.setText("Số điện thoại:");

        jLabel9.setText("Giới tính:");

        btnThemMoi.setText("Thêm");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("THÊM ĐỘC GIẢ MỚI");

        buttonGroup1.add(rbNam);
        rbNam.setSelected(true);
        rbNam.setText("Nam");

        jLabel3.setText("Mã độc giả:");

        buttonGroup1.add(rbNu);
        rbNu.setText("Nữ");

        jLabel5.setText("Tên độc giả:");

        jLabel6.setText("Địa chỉ:");

        javax.swing.GroupLayout jDialogThemLayout = new javax.swing.GroupLayout(jDialogThem.getContentPane());
        jDialogThem.getContentPane().setLayout(jDialogThemLayout);
        jDialogThemLayout.setHorizontalGroup(
            jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogThemLayout.createSequentialGroup()
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogThemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtMDG, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogThemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTDG, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogThemLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2))
                    .addGroup(jDialogThemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemMoi)
                            .addComponent(txtSDTDG, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialogThemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogThemLayout.createSequentialGroup()
                                .addComponent(rbNam)
                                .addGap(18, 18, 18)
                                .addComponent(rbNu))
                            .addComponent(txtDCDG, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jDialogThemLayout.setVerticalGroup(
            jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogThemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rbNam)
                    .addComponent(rbNu))
                .addGap(18, 18, 18)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDCDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSDTDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(btnThemMoi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialogChiTiet.setLocation(new java.awt.Point(500, 100));
        jDialogChiTiet.setSize(new java.awt.Dimension(280, 400));

        jLabel12.setText("Giới tính:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("CHI TIẾT ĐỘC GIẢ");

        rbNam1.setSelected(true);
        rbNam1.setText("Nam");

        jLabel13.setText("Mã độc giả:");

        rbNu1.setText("Nữ");

        jLabel8.setText("Tên độc giả:");

        jLabel10.setText("Địa chỉ:");

        jLabel11.setText("Số điện thoại:");

        javax.swing.GroupLayout jDialogChiTietLayout = new javax.swing.GroupLayout(jDialogChiTiet.getContentPane());
        jDialogChiTiet.getContentPane().setLayout(jDialogChiTietLayout);
        jDialogChiTietLayout.setHorizontalGroup(
            jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogChiTietLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogChiTietLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSDTDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogChiTietLayout.createSequentialGroup()
                        .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogChiTietLayout.createSequentialGroup()
                                .addComponent(rbNam1)
                                .addGap(18, 18, 18)
                                .addComponent(rbNu1))
                            .addComponent(txtDCDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialogChiTietLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtMDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jDialogChiTietLayout.setVerticalGroup(
            jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMDG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTDG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(rbNam1)
                    .addComponent(rbNu1))
                .addGap(18, 18, 18)
                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtDCDG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSDTDG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DANH SÁCH ĐỘC GIẢ");

        tbDocGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã độc giả", "Tên độc giả", "Giới tính", "Địa chỉ", "SĐT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbDocGia);

        btnChiTietDG.setText("Chi tiết");
        btnChiTietDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietDGActionPerformed(evt);
            }
        });

        btnXoaDG.setText("Xóa");
        btnXoaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDGActionPerformed(evt);
            }
        });

        btnDongDG.setText("Đóng");
        btnDongDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongDGActionPerformed(evt);
            }
        });

        btnThemDG.setText("Thêm");
        btnThemDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnThemDG, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(btnChiTietDG, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(btnDongDG, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChiTietDG)
                    .addComponent(btnXoaDG)
                    .addComponent(btnDongDG)
                    .addComponent(btnThemDG))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChiTietDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietDGActionPerformed
        // TODO add your handling code here:
            indexEdit = tbDocGia.getSelectedRow();
            if (indexEdit == -1) {
                JOptionPane.showMessageDialog(rootPane, "Bạn cần chọn 1 hàng để xem chi tiết!!");
            } else if (list.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Bảng trống không thể hiển thị!!");
            } else {
                setDetaiSachDG(list.get(indexEdit));
                jDialogChiTiet.setVisible(true);
            }
    }//GEN-LAST:event_btnChiTietDGActionPerformed

    private void btnDongDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongDGActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnDongDGActionPerformed

    private void btnThemDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDGActionPerformed
        // TODO add your handling code here:
        jDialogThem.setVisible(true);
    }//GEN-LAST:event_btnThemDGActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        // TODO add your handling code here:
        if (checkmhd()) {
            DocGia dg = getDetailSach();
            try {
                list.add(dg);
                file.write(list);
                cancelValues();
            } catch (Exception e) {
                System.out.println("Thêm thất bại.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Mã độc giả đã tồn tại. Bạn hãy nhập lại phiếu");
        }
        showResult();
        jDialogThem.setVisible(false);
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnXoaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDGActionPerformed
        // TODO add your handling code here:
        int indexRemove = tbDocGia.getSelectedRow();
        if (indexRemove == -1) {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần chọn 1 hàng để xóa!!");
        } else if (list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Bảng trống không thể xóa!!");
        } else {
            int reply = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoa không ?", "", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                list.remove(indexRemove);
                file.write(list);
                cancelValues();
                showResult();
            }

        }
    }//GEN-LAST:event_btnXoaDGActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDocGia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTietDG;
    private javax.swing.JButton btnDongDG;
    private javax.swing.JButton btnThemDG;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnXoaDG;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDialog jDialogChiTiet;
    private javax.swing.JDialog jDialogThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNam1;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JRadioButton rbNu1;
    private javax.swing.JTable tbDocGia;
    private javax.swing.JTextField txtDCDG;
    private javax.swing.JTextField txtDCDG1;
    private javax.swing.JTextField txtMDG;
    private javax.swing.JTextField txtMDG1;
    private javax.swing.JTextField txtSDTDG;
    private javax.swing.JTextField txtSDTDG1;
    private javax.swing.JTextField txtTDG;
    private javax.swing.JTextField txtTDG1;
    // End of variables declaration//GEN-END:variables
}
