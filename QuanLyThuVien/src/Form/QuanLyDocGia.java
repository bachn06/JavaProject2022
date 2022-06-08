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
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    DefaultTableModel model1;
    public int indexEdit;
    boolean checkDialog = false; 

    public QuanLyDocGia() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) tbDocGia.getModel();
        model1 = (DefaultTableModel) tblDocGIa1.getModel();
        showResult();
    }

    public DocGia getDetailSach() {
        DocGia dg = new DocGia();
        boolean check = true;
        
        errLabel01.setText("");
        errLabel02.setText("");
        errLabel03.setText("");
        errLabel04.setText("");
        
        String mdg = txtMDG.getText().trim();
        if(!validate0(mdg).equals("")) {
            check = false;
            errLabel04.setText(validate0(mdg));
        }
            
        String tdg = txtTDG.getText().trim();
        if(!validate1(tdg).equals("")) {
            check = false;
            errLabel03.setText(validate1(tdg));
        }
            
        String diaChi = txtDCDG.getText().trim();
        if(!validate1(diaChi).equals("")) {
            check = false;
            errLabel02.setText(validate1(diaChi));
        }
            
        String gt;
        if(rbNam.isSelected()) {
            gt = "Nam";
        } else {
            gt = "Nữ";
        }
            
        String sdt = txtSDTDG.getText().trim();
        if(!validate2(sdt).equals("")) {
            check = false;
            errLabel01.setText(validate2(sdt));
        }
        
        if(check) {
            dg.setMaDG(txtMDG.getText().trim());
            dg.setTenDG(txtTDG.getText().trim());
            dg.setDiaChi(txtDCDG.getText().trim());
            dg.setSdt(txtSDTDG.getText().trim());
            if(rbNam.isSelected()) {
                dg.setGioiTinh("Nam");
            } else {
                dg.setGioiTinh("Nữ");
            }
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
    public boolean checkmhd2() {
        for (DocGia dg : list) {
            if (dg.getMaDG().equals(txtMDG2.getText().trim()) && !dg.getMaDG().equals(list.get(indexEdit).getMaDG())) {
                return false;
            }
        }
        return true;
    }
    public String validate1(String value) {
        
        Pattern patternDate = Pattern.compile("^[A-Za-z]{1,}$");
        Matcher matcher = patternDate.matcher(value);
        if(!matcher.find()) {
           return "Không được để trống thông tin và chỉ chứa kí tự A-Z";
        }
        return "";
    }
    public String validate2(String value) {

        Pattern patternDate = Pattern.compile("^[0-9]{10,10}$");
        Matcher matcher = patternDate.matcher(value);
        if(!matcher.find()) {
            return "Số điện thoại chỉ chứa số và 10 kí tự";
        }
        return "";
    }
    public String validate0(String value) {

        String regex = "MDG[0-9][0-9][0-9][0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        
        if(!matcher.find()) {
            return "Mã độc giả phải có dạng MDGxxxx (Với x là số)";
        }
        return "";
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
    public void setDetaiSachDG2(DocGia s){
        
        txtMDG2.setText(s.getMaDG());
        txtTDG2.setText(s.getTenDG());
        txtDCDG2.setText(s.getDiaChi());
        txtSDTDG2.setText(s.getSdt());
        
        if(s.getGioiTinh().equals("Nam")) {
            rbNam2.setSelected(true);
        } else {
            rbNu2.setSelected(true);
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
        errLabel01 = new javax.swing.JLabel();
        errLabel02 = new javax.swing.JLabel();
        errLabel03 = new javax.swing.JLabel();
        errLabel04 = new javax.swing.JLabel();
        btnCLoseAddDG = new javax.swing.JButton();
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
        closeDetailForm = new javax.swing.JButton();
        jDialogSua = new javax.swing.JDialog();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rbNam2 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        rbNu2 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        txtMDG2 = new javax.swing.JTextField();
        txtTDG2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDCDG2 = new javax.swing.JTextField();
        txtSDTDG2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnXacNhanSuaDocGia = new javax.swing.JButton();
        errLabel2 = new javax.swing.JLabel();
        errLabel4 = new javax.swing.JLabel();
        errLabel3 = new javax.swing.JLabel();
        errLabel1 = new javax.swing.JLabel();
        btnCLoseSuaDG = new javax.swing.JButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jDialogTimKiem = new javax.swing.JDialog();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButtonTimKIemDG = new javax.swing.JButton();
        jButtonCancalTimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDocGIa1 = new javax.swing.JTable();
        jButtonSuaSub = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDocGia = new javax.swing.JTable();
        btnChiTietDG = new javax.swing.JButton();
        btnXoaDG = new javax.swing.JButton();
        btnDongDG = new javax.swing.JButton();
        btnThemDG = new javax.swing.JButton();
        btnSuaDG = new javax.swing.JButton();
        btnTimKiemDG = new javax.swing.JButton();

        jDialogThem.setLocation(new java.awt.Point(500, 100));
        jDialogThem.setSize(new java.awt.Dimension(566, 527));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Số điện thoại:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Giới tính:");

        btnThemMoi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThemMoi.setText("Thêm");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("THÊM ĐỘC GIẢ MỚI");

        buttonGroup1.add(rbNam);
        rbNam.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rbNam.setSelected(true);
        rbNam.setText("Nam");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Mã độc giả:");

        buttonGroup1.add(rbNu);
        rbNu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rbNu.setText("Nữ");
        rbNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNuActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Tên độc giả:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Địa chỉ:");

        errLabel01.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        errLabel01.setForeground(new java.awt.Color(255, 0, 0));
        errLabel01.setToolTipText("");

        errLabel02.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        errLabel02.setForeground(new java.awt.Color(255, 0, 0));
        errLabel02.setToolTipText("");

        errLabel03.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        errLabel03.setForeground(new java.awt.Color(255, 0, 0));
        errLabel03.setToolTipText("");

        errLabel04.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        errLabel04.setForeground(new java.awt.Color(255, 0, 0));
        errLabel04.setToolTipText("");

        btnCLoseAddDG.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCLoseAddDG.setText("Hủy");
        btnCLoseAddDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLoseAddDGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogThemLayout = new javax.swing.GroupLayout(jDialogThem.getContentPane());
        jDialogThem.getContentPane().setLayout(jDialogThemLayout);
        jDialogThemLayout.setHorizontalGroup(
            jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogThemLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jDialogThemLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogThemLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errLabel02)
                            .addComponent(txtDCDG, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialogThemLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTDG, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errLabel03)))
                    .addGroup(jDialogThemLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(rbNam)
                        .addGap(18, 18, 18)
                        .addComponent(rbNu))
                    .addGroup(jDialogThemLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMDG, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errLabel04)))
                    .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jDialogThemLayout.createSequentialGroup()
                            .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCLoseAddDG, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogThemLayout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSDTDG, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(errLabel01)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jDialogThemLayout.setVerticalGroup(
            jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogThemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMDG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errLabel04, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTDG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rbNam)
                    .addComponent(rbNu))
                .addGap(30, 30, 30)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDCDG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSDTDG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCLoseAddDG, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jDialogChiTiet.setLocation(new java.awt.Point(500, 100));
        jDialogChiTiet.setSize(new java.awt.Dimension(517, 475));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Giới tính:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setText("THÔNG TIN ĐỘC GIẢ");

        rbNam1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rbNam1.setSelected(true);
        rbNam1.setText("Nam");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Mã độc giả:");

        rbNu1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rbNu1.setText("Nữ");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Tên độc giả:");

        txtMDG1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtTDG1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Địa chỉ:");

        txtDCDG1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtSDTDG1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Số điện thoại:");

        closeDetailForm.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        closeDetailForm.setText("Đóng");
        closeDetailForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeDetailFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogChiTietLayout = new javax.swing.GroupLayout(jDialogChiTiet.getContentPane());
        jDialogChiTiet.getContentPane().setLayout(jDialogChiTietLayout);
        jDialogChiTietLayout.setHorizontalGroup(
            jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogChiTietLayout.createSequentialGroup()
                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogChiTietLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogChiTietLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSDTDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(txtDCDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jDialogChiTietLayout.createSequentialGroup()
                                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDialogChiTietLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogChiTietLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0))))))
                    .addGroup(jDialogChiTietLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel4)))
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogChiTietLayout.createSequentialGroup()
                .addComponent(closeDetailForm, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        jDialogChiTietLayout.setVerticalGroup(
            jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(42, 42, 42)
                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(rbNam1)
                    .addComponent(rbNu1))
                .addGap(30, 30, 30)
                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtDCDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jDialogChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSDTDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(closeDetailForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jDialogSua.setLocation(new java.awt.Point(500, 100));
        jDialogSua.setResizable(false);
        jDialogSua.setSize(new java.awt.Dimension(595, 527));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Giới tính:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel15.setText("SỬA THÔNG TIN ĐỘC GIẢ");

        buttonGroup2.add(rbNam2);
        rbNam2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rbNam2.setSelected(true);
        rbNam2.setText("Nam");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Mã độc giả:");

        buttonGroup2.add(rbNu2);
        rbNu2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rbNu2.setText("Nữ");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Tên độc giả:");

        txtMDG2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtTDG2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Địa chỉ:");

        txtDCDG2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtSDTDG2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Số điện thoại:");

        btnXacNhanSuaDocGia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXacNhanSuaDocGia.setText("Sửa");
        btnXacNhanSuaDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanSuaDocGiaActionPerformed(evt);
            }
        });

        errLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        errLabel2.setForeground(new java.awt.Color(255, 51, 51));

        errLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        errLabel4.setForeground(new java.awt.Color(255, 51, 51));

        errLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        errLabel3.setForeground(new java.awt.Color(255, 51, 51));

        errLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        errLabel1.setForeground(new java.awt.Color(255, 51, 51));

        btnCLoseSuaDG.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCLoseSuaDG.setText("Hủy");
        btnCLoseSuaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLoseSuaDGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogSuaLayout = new javax.swing.GroupLayout(jDialogSua.getContentPane());
        jDialogSua.getContentPane().setLayout(jDialogSuaLayout);
        jDialogSuaLayout.setHorizontalGroup(
            jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSuaLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSuaLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDialogSuaLayout.createSequentialGroup()
                        .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errLabel3)
                            .addComponent(txtDCDG2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDialogSuaLayout.createSequentialGroup()
                                .addComponent(rbNam2)
                                .addGap(18, 18, 18)
                                .addComponent(rbNu2))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSuaLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errLabel4)
                            .addComponent(txtSDTDG2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialogSuaLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(65, 65, 65)
                        .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errLabel1)
                            .addComponent(txtMDG2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialogSuaLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errLabel2)
                            .addComponent(txtTDG2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialogSuaLayout.createSequentialGroup()
                        .addComponent(btnXacNhanSuaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCLoseSuaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
        );
        jDialogSuaLayout.setVerticalGroup(
            jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSuaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtMDG2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTDG2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(rbNam2)
                    .addComponent(rbNu2))
                .addGap(30, 30, 30)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtDCDG2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtSDTDG2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhanSuaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCLoseSuaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        jDialogTimKiem.setSize(new java.awt.Dimension(632, 381));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Tìm kiếm độc giả");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setText("Nhập mã sách :");

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jButtonTimKIemDG.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonTimKIemDG.setText("Tìm kiếm");
        jButtonTimKIemDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKIemDGActionPerformed(evt);
            }
        });

        jButtonCancalTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonCancalTimKiem.setText("Hủy bỏ");
        jButtonCancalTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancalTimKiemActionPerformed(evt);
            }
        });

        tblDocGIa1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblDocGIa1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã độc giả", "Tên độc giả", "Giới tính", "Địa chỉ", "Số điện thoại"
            }
        ));
        tblDocGIa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDocGIa1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDocGIa1);

        jButtonSuaSub.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonSuaSub.setText("Sửa");
        jButtonSuaSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaSubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogTimKiemLayout = new javax.swing.GroupLayout(jDialogTimKiem.getContentPane());
        jDialogTimKiem.getContentPane().setLayout(jDialogTimKiemLayout);
        jDialogTimKiemLayout.setHorizontalGroup(
            jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(53, 53, 53)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonTimKIemDG))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                        .addComponent(jButtonSuaSub, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancalTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
            .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogTimKiemLayout.setVerticalGroup(
            jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(53, 53, 53)
                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTimKIemDG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancalTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSuaSub, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(550, 400));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("DANH SÁCH ĐỘC GIẢ");

        tbDocGia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbDocGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã độc giả", "Tên độc giả", "Giới tính", "Địa chỉ", "Số điện thoại"
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

        btnChiTietDG.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnChiTietDG.setText("Chi tiết");
        btnChiTietDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietDGActionPerformed(evt);
            }
        });

        btnXoaDG.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXoaDG.setText("Xóa");
        btnXoaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDGActionPerformed(evt);
            }
        });

        btnDongDG.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDongDG.setText("Đóng");
        btnDongDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongDGActionPerformed(evt);
            }
        });

        btnThemDG.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThemDG.setText("Thêm");
        btnThemDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDGActionPerformed(evt);
            }
        });

        btnSuaDG.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSuaDG.setText("Sửa");
        btnSuaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDGActionPerformed(evt);
            }
        });

        btnTimKiemDG.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTimKiemDG.setText("Tìm kiếm");
        btnTimKiemDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemDGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThemDG, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnChiTietDG, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnSuaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnTimKiemDG, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnXoaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnDongDG, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(314, 314, 314)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChiTietDG, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnXoaDG, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnDongDG, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnThemDG, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnSuaDG, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnTimKiemDG, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(102, 102, 102))
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
                tbDocGia.getSelectionModel().clearSelection();
            }
    }//GEN-LAST:event_btnChiTietDGActionPerformed

    private void btnDongDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongDGActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnDongDGActionPerformed

    private void btnThemDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDGActionPerformed
        // TODO add your handling code here:
        jDialogThem.setVisible(true);
        jDialogThem.setLocationRelativeTo(this);
        tbDocGia.getSelectionModel().clearSelection();
    }//GEN-LAST:event_btnThemDGActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        // TODO add your handling code here:
        if (checkmhd()) {
            DocGia dg = getDetailSach();
            try {
                if(dg.getMaDG().equals("")) {
                    throw new Exception();
                }
                list.add(dg);
                file.write(list);
                cancelValues();
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Mã độc giả đã tồn tại. Bạn hãy nhập lại phiếu");
        }
        showResult();

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

    private void btnSuaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDGActionPerformed
        // TODO add your handling code here:
        int indexChange = tbDocGia.getSelectedRow();
        if (indexChange == -1) {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần chọn 1 hàng để sửa!!");
        } else if (list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Bảng trống không có độc giả để sửa!!");
        } else {
            indexEdit = indexChange;
            setDetaiSachDG2(list.get(indexChange));
            jDialogSua.setVisible(true);
            jDialogSua.setLocationRelativeTo(this);
            tbDocGia.getSelectionModel().clearSelection();
        }
        
    }//GEN-LAST:event_btnSuaDGActionPerformed

    private void btnXacNhanSuaDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanSuaDocGiaActionPerformed
        // TODO add your handling code here:
        if(checkmhd2()) {
            boolean check = true;
            
            String mdg = txtMDG2.getText().trim();
            if(!validate0(mdg).equals("")) {
                check = false;
                errLabel1.setText(validate0(mdg));
            }
            
            String tdg = txtTDG2.getText().trim();
            if(!validate1(tdg).equals("")) {
                check = false;
                errLabel2.setText(validate1(tdg));
            }
            
            String diaChi = txtDCDG2.getText().trim();
            if(!validate1(diaChi).equals("")) {
                check = false;
                errLabel3.setText(validate1(diaChi));
            }
            
            String gt;
            if(rbNam2.isSelected()) {
                gt = "Nam";
            } else {
                gt = "Nữ";
            }
            
            String sdt = txtSDTDG2.getText().trim();
            if(!validate2(sdt).equals("")) {
                check = false;
                errLabel4.setText(validate2(sdt));
            }
            JOptionPane.showMessageDialog(rootPane, check);
            if(check) {
                int reply = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa không ?", "", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    list.get(indexEdit).setMaDG(mdg);
                    list.get(indexEdit).setTenDG(tdg);
                    list.get(indexEdit).setGioiTinh(gt);
                    list.get(indexEdit).setDiaChi(diaChi);
                    list.get(indexEdit).setSdt(sdt);
                    file.write(list);
                    
                    errLabel1.setText("");
                    errLabel2.setText("");
                    errLabel3.setText("");
                    errLabel4.setText("");
                    
                    jDialogSua.setVisible(false);
                    showResult();
                }
                if(checkDialog) {
                    listSearch.add(list.get(indexEdit));
                    showResultSearch();
                    listSearch.clear();
                    checkDialog = false;
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Mã độc giả bạn nhập đã tồn tại!");
        }
    }//GEN-LAST:event_btnXacNhanSuaDocGiaActionPerformed

    private void btnTimKiemDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemDGActionPerformed
        // TODO add your handling code here:
        jDialogTimKiem.setVisible(true);
        jDialogTimKiem.setLocationRelativeTo(this);
        tbDocGia.getSelectionModel().clearSelection();
        tblDocGIa1.remove(0);
    }//GEN-LAST:event_btnTimKiemDGActionPerformed
    public void showResultSearch() {
        model1.setRowCount(0);
        for (DocGia dg : listSearch) {
            model1.addRow(new Object[]{
                dg.getMaDG(), dg.getTenDG(), dg.getGioiTinh(), dg.getDiaChi(), dg.getSdt()
            });
        }
    }
    private void jButtonTimKIemDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKIemDGActionPerformed
        // TODO add your handling code here:
        Boolean check = false;
        int index = 0;
        model1.setRowCount(0);
        for (DocGia dg : list) {
            if (dg.getMaDG().toLowerCase().equals(txtSearch.getText().toLowerCase())) {
                listSearch.add(dg);
                showResultSearch();
                listSearch.clear();
                check = true;
                txtSearch.setText("");
                indexEdit = index;
            }
            index++;
        }
        if (!check) {
            JOptionPane.showMessageDialog(rootPane, "Mã độc giả bạn nhập không tồn tại!");
        }
    }//GEN-LAST:event_jButtonTimKIemDGActionPerformed

    private void jButtonCancalTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancalTimKiemActionPerformed
        // TODO add your handling code here:
        showResultSearch();
        txtSearch.setText("");
        jDialogTimKiem.setVisible(false);
    }//GEN-LAST:event_jButtonCancalTimKiemActionPerformed

    private void tblDocGIa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocGIa1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDocGIa1MouseClicked

    private void jButtonSuaSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaSubActionPerformed
        // TODO add your handling code here:
        int indexChange = tblDocGIa1.getSelectedRow();
        if (indexChange == -1) {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần chọn 1 hàng để sửa!!");
        } else if (list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Bảng trống không có độc giả để sửa!!");
        } else {
            setDetaiSachDG2(list.get(indexEdit));            
            
            jDialogSua.setVisible(true);
            jDialogSua.setLocationRelativeTo(this);
            checkDialog = true;
            tbDocGia.getSelectionModel().clearSelection();
        }
    }//GEN-LAST:event_jButtonSuaSubActionPerformed

    private void rbNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNuActionPerformed

    private void closeDetailFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeDetailFormActionPerformed
        // TODO add your handling code here:
        jDialogChiTiet.setVisible(false);
    }//GEN-LAST:event_closeDetailFormActionPerformed

    private void btnCLoseSuaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLoseSuaDGActionPerformed
        // TODO add your handling code here:
        jDialogSua.setVisible(false);
    }//GEN-LAST:event_btnCLoseSuaDGActionPerformed

    private void btnCLoseAddDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLoseAddDGActionPerformed
        // TODO add your handling code here:
        cancelValues();
        jDialogThem.setVisible(false);
    }//GEN-LAST:event_btnCLoseAddDGActionPerformed

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
    private javax.swing.JButton btnCLoseAddDG;
    private javax.swing.JButton btnCLoseSuaDG;
    private javax.swing.JButton btnChiTietDG;
    private javax.swing.JButton btnDongDG;
    private javax.swing.JButton btnSuaDG;
    private javax.swing.JButton btnThemDG;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTimKiemDG;
    private javax.swing.JButton btnXacNhanSuaDocGia;
    private javax.swing.JButton btnXoaDG;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton closeDetailForm;
    private javax.swing.JLabel errLabel01;
    private javax.swing.JLabel errLabel02;
    private javax.swing.JLabel errLabel03;
    private javax.swing.JLabel errLabel04;
    private javax.swing.JLabel errLabel1;
    private javax.swing.JLabel errLabel2;
    private javax.swing.JLabel errLabel3;
    private javax.swing.JLabel errLabel4;
    private javax.swing.JButton jButtonCancalTimKiem;
    private javax.swing.JButton jButtonSuaSub;
    private javax.swing.JButton jButtonTimKIemDG;
    private javax.swing.JDialog jDialogChiTiet;
    private javax.swing.JDialog jDialogSua;
    private javax.swing.JDialog jDialogThem;
    private javax.swing.JDialog jDialogTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNam1;
    private javax.swing.JRadioButton rbNam2;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JRadioButton rbNu1;
    private javax.swing.JRadioButton rbNu2;
    private javax.swing.JTable tbDocGia;
    private javax.swing.JTable tblDocGIa1;
    private javax.swing.JTextField txtDCDG;
    private javax.swing.JTextField txtDCDG1;
    private javax.swing.JTextField txtDCDG2;
    private javax.swing.JTextField txtMDG;
    private javax.swing.JTextField txtMDG1;
    private javax.swing.JTextField txtMDG2;
    private javax.swing.JTextField txtSDTDG;
    private javax.swing.JTextField txtSDTDG1;
    private javax.swing.JTextField txtSDTDG2;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTDG;
    private javax.swing.JTextField txtTDG1;
    private javax.swing.JTextField txtTDG2;
    // End of variables declaration//GEN-END:variables


}
