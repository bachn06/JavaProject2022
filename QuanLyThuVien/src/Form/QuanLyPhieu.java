/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DoiTuong.Phieu;
import ReadWrite.PhieuFile;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell 7559
 */
public final class QuanLyPhieu extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyPhieu
     */
    PhieuFile file = new PhieuFile();

    List<Phieu> list = file.read();
    List<Phieu> listSearch = new ArrayList<Phieu>();
    DefaultTableModel model;
    DefaultTableModel model1;
    int indexEdit;
    Boolean valid = false;
    Boolean valid1 = false;

    public QuanLyPhieu() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) tbPhieu.getModel();
        showNameCol();
        model1 = (DefaultTableModel) tbSearch.getModel();
        showNameCol1();
        showResult();
        txtNgayMuon.setText(DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH).format(java.time.LocalDate.now()));
    }

    public void showNameCol() {
        model.setColumnIdentifiers(new Object[]{
            "Mã phiếu", "Mã sách", "Mã độc giả", "Số lượng", "Giá", "Ngày mượn", "Ngày trả"
        });
    }

    public void showNameCol1() {
        model1.setColumnIdentifiers(new Object[]{
            "Mã phiếu", "Mã sách", "Mã độc giả", "Số lượng", "Giá", "Ngày mượn", "Ngày trả"
        });
    }

    public boolean checkDate(String input) {
        String regex = "^(29/02/(2000|2400|2800|(19|2[0-9])(0[48]|[2468][048]|[13579][26])))$"
                + "|^((0[1-9]|1[0-9]|2[0-8])/02/((19|2[0-9])[0-9]{2}))$"
                + "|^((0[1-9]|[12][0-9]|3[01])/(0[13578]|10|12)/((19|2[0-9])[0-9]{2}))$"
                + "|^((0[1-9]|[12][0-9]|30)/(0[469]|11)/((19|2[0-9])[0-9]{2}))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean checkMaP(String input) {
        String regex = "MP[0-9][0-9][0-9][0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean checkMaS(String input) {
        String regex = "MS[0-9][0-9][0-9][0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean checkMaDG(String input) {
        String regex = "MDG[0-9][0-9][0-9][0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean checkSL(String input) {
        String regex = "^[0-9]*[1-9][0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean checkGia(String input) {
        String regex = "[+-]?([0-9]*[.])?[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private Phieu getDetailPhieu() {
        Phieu p = new Phieu();
        if (checkDate(txtNgayMuon.getText()) && checkDate(txtNgayTra.getText())
                && checkMaP(txtMaP.getText())
                && checkMaS(txtMaS.getText())
                && checkMaDG(txtMaDG.getText())
                && checkSL(txtSL.getText())
                && checkGia(txtGia.getText())) {
            p.setMaP(txtMaP.getText().trim());
            p.setMaS(txtMaS.getText().trim());
            p.setMaDG(txtMaDG.getText().trim());
            p.setsL(Integer.parseInt(txtSL.getText()));
            p.setGia(Float.parseFloat(txtGia.getText()));
            p.setNgaymuon(txtNgayMuon.getText().trim());
            p.setNgaytra(txtNgayTra.getText().trim());
            validMaP.setText("");
            validMaS.setText("");
            validMaDG.setText("");
            validGia.setText("");
            validSL.setText("");
            validNgayMuon.setText("");
            validNgayTra.setText("");
            valid = true;
        } else {

            if (!checkDate(txtNgayMuon.getText())) {
                validNgayMuon.setText("Ngày mượn có dạng dd/mm/yyyy");
            } else {
                validNgayMuon.setText("");
            }
            if (!checkDate(txtNgayTra.getText())) {
                validNgayTra.setText("Ngày trả có dạng dd/mm/yyyy");
            } else {
                validNgayTra.setText("");
            }
            if (!checkMaP(txtMaP.getText().trim())) {
                validMaP.setText("Mã phiếu có dạng MPxxxx. Ví dụ:MP0001");
            } else {
                validMaP.setText("");
            }
            if (!checkMaS(txtMaS.getText().trim())) {
                validMaS.setText("Mã sách có dạng MSxxxx. Ví dụ:MS0001");
            } else {
                validMaS.setText("");
            }
            if (!checkMaDG(txtMaDG.getText().trim())) {
                validMaDG.setText("Mã độc giả dạng MDGxxxx. Ví dụ:MDG0001");
            } else {
                validMaDG.setText("");
            }
            if (!checkSL(txtSL.getText().trim())) {
                validSL.setText("Số lượng là số nguyên dương");
            } else {
                validSL.setText("");
            }
            if (!checkGia(txtGia.getText().trim())) {
                validGia.setText("Giá bán phải là số dương");
            } else {
                validGia.setText("");
            }
        }
        return p;
    }

    private Phieu getDetailPhieuEdit() {
        Phieu p = new Phieu();
        if (checkDate(txtNgayMuon1.getText()) && checkDate(txtNgayTra1.getText())
                && checkMaP(txtMaP1.getText())
                && checkMaS(txtMaS1.getText())
                && checkMaDG(txtMaDG1.getText())
                && checkSL(txtSL1.getText())
                && checkGia(txtGia1.getText())) {
            p.setMaP(txtMaP1.getText().trim());
            p.setMaS(txtMaS1.getText().trim());
            p.setMaDG(txtMaDG1.getText().trim());
            p.setsL(Integer.parseInt(txtSL1.getText()));
            p.setGia(Float.parseFloat(txtGia1.getText()));
            p.setNgaymuon(txtNgayMuon1.getText().trim());
            p.setNgaytra(txtNgayTra1.getText().trim());
            validMaP1.setText("");
            validMaS1.setText("");
            validMaDG1.setText("");
            validGia1.setText("");
            validSL1.setText("");
            validNgayMuon1.setText("");
            validNgayTra1.setText("");
            valid1 = true;
        } else {

            if (!checkDate(txtNgayMuon1.getText())) {
                validNgayMuon1.setText("Ngày mượn có dạng dd/mm/yyyy");
            } else {
                validNgayMuon1.setText("");
            }
            if (!checkDate(txtNgayTra1.getText())) {
                validNgayTra1.setText("Ngày trả có dạng dd/mm/yyyy");
            } else {
                validNgayTra1.setText("");
            }
            if (!checkMaP(txtMaP1.getText().trim())) {
                validMaP1.setText("Mã phiếu có dạng MPxxxx. Ví dụ:MP0001");
            } else {
                validMaP1.setText("");
            }
            if (!checkMaS(txtMaS1.getText().trim())) {
                validMaS1.setText("Mã sách có dạng MSxxxx. Ví dụ:MS0001");
            } else {
                validMaS1.setText("");
            }
            if (!checkMaDG(txtMaDG1.getText().trim())) {
                validMaDG1.setText("Mã độc giả dạng MDGxxxx. Ví dụ:MDG0001");
            } else {
                validMaDG1.setText("");
            }
            if (!checkSL(txtSL1.getText().trim())) {
                validSL1.setText("Số lượng là số nguyên dương");
            } else {
                validSL1.setText("");
            }
            if (!checkGia(txtGia1.getText().trim())) {
                validGia1.setText("Giá bán phải là số dương");
            } else {
                validGia1.setText("");
            }
        }
        return p;
    }

    public boolean checkmhd() {
        for (Phieu p : list) {
            if (p.getMaP().equals(txtMaP.getText())) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchForm = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSearch = new javax.swing.JTable();
        addForm = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        txtMaP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNgayMuon = new javax.swing.JTextField();
        txtMaS = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNgayTra = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtMaDG = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        validNgayTra = new javax.swing.JLabel();
        validGia = new javax.swing.JLabel();
        validMaP = new javax.swing.JLabel();
        validMaS = new javax.swing.JLabel();
        validMaDG = new javax.swing.JLabel();
        validSL = new javax.swing.JLabel();
        validNgayMuon = new javax.swing.JLabel();
        btnHuy = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        editForm = new javax.swing.JDialog();
        jLabel18 = new javax.swing.JLabel();
        validMaDG1 = new javax.swing.JLabel();
        validSL1 = new javax.swing.JLabel();
        validNgayMuon1 = new javax.swing.JLabel();
        btnHuy1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        validNgayTra1 = new javax.swing.JLabel();
        validGia1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        validMaP1 = new javax.swing.JLabel();
        txtNgayMuon1 = new javax.swing.JTextField();
        validMaS1 = new javax.swing.JLabel();
        txtMaS1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtGia1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtNgayTra1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtMaDG1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtSL1 = new javax.swing.JTextField();
        txtMaP1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnDisplayThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnDisplaySua = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPhieu = new javax.swing.JTable();
        btnDong = new javax.swing.JButton();

        searchForm.setSize(new java.awt.Dimension(591, 426));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Nhập mã phiếu:");

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Hủy bỏ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tbSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(tbSearch);

        javax.swing.GroupLayout searchFormLayout = new javax.swing.GroupLayout(searchForm.getContentPane());
        searchForm.getContentPane().setLayout(searchFormLayout);
        searchFormLayout.setHorizontalGroup(
            searchFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchFormLayout.createSequentialGroup()
                .addGroup(searchFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchFormLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(searchFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(searchFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(searchFormLayout.createSequentialGroup()
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(78, 78, 78)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(searchFormLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        searchFormLayout.setVerticalGroup(
            searchFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchFormLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(searchFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        addForm.setBackground(new java.awt.Color(204, 255, 204));
        addForm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addForm.setSize(new java.awt.Dimension(569, 600));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Mã phiếu:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Ngày mượn:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Mã sách:");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Giá tiền:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Ngày trả");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Mã đọc giả:");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Số lượng:");

        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThem.setText("Thêm phiếu");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        validNgayTra.setForeground(new java.awt.Color(255, 0, 0));

        validGia.setForeground(new java.awt.Color(255, 0, 0));

        validMaP.setForeground(new java.awt.Color(255, 0, 0));

        validMaS.setForeground(new java.awt.Color(255, 0, 0));

        validMaDG.setForeground(new java.awt.Color(255, 0, 0));

        validSL.setForeground(new java.awt.Color(255, 0, 0));

        validNgayMuon.setForeground(new java.awt.Color(255, 0, 0));

        btnHuy.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 255));
        jLabel3.setText("THÊM PHIẾU MỚI");

        javax.swing.GroupLayout addFormLayout = new javax.swing.GroupLayout(addForm.getContentPane());
        addForm.getContentPane().setLayout(addFormLayout);
        addFormLayout.setHorizontalGroup(
            addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addFormLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addFormLayout.createSequentialGroup()
                        .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(addFormLayout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(24, 24, 24)
                                        .addComponent(txtMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addFormLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(36, 36, 36)
                                        .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(validMaDG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(validSL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addFormLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(validMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(validGia, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(addFormLayout.createSequentialGroup()
                                    .addComponent(btnThem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnHuy))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addFormLayout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(21, 21, 21)
                                    .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(addFormLayout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(validNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(validNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(109, Short.MAX_VALUE))
                    .addGroup(addFormLayout.createSequentialGroup()
                        .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addGap(34, 34, 34)
                        .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(validMaP, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addFormLayout.createSequentialGroup()
                                .addComponent(txtMaP, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        addFormLayout.setVerticalGroup(
            addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addFormLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(txtMaP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validMaP, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(validSL, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validGia, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(addFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnHuy))
                .addGap(45, 45, 45))
        );

        editForm.setSize(new java.awt.Dimension(535, 552));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Ngày mượn:");

        validMaDG1.setForeground(new java.awt.Color(255, 0, 0));

        validSL1.setForeground(new java.awt.Color(255, 0, 0));

        validNgayMuon1.setForeground(new java.awt.Color(255, 0, 0));

        btnHuy1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnHuy1.setText("Hủy");
        btnHuy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuy1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 255));
        jLabel4.setText("SỬA PHIẾU");

        btnSua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSua.setText("Sửa phiếu");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        validNgayTra1.setForeground(new java.awt.Color(255, 0, 0));

        validGia1.setForeground(new java.awt.Color(255, 0, 0));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Mã sách:");

        validMaP1.setForeground(new java.awt.Color(255, 0, 0));

        validMaS1.setForeground(new java.awt.Color(255, 0, 0));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("Giá tiền:");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("Ngày trả");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setText("Mã đọc giả:");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setText("Số lượng:");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setText("Mã phiếu:");

        javax.swing.GroupLayout editFormLayout = new javax.swing.GroupLayout(editForm.getContentPane());
        editForm.getContentPane().setLayout(editFormLayout);
        editFormLayout.setHorizontalGroup(
            editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editFormLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(editFormLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(24, 24, 24)
                                .addComponent(txtMaDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editFormLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(36, 36, 36)
                                .addComponent(txtSL1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(validMaDG1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(validSL1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editFormLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGia1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(validMaS1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(validGia1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editFormLayout.createSequentialGroup()
                        .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel19))
                        .addGap(34, 34, 34)
                        .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaS1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(validMaP1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaP1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(editFormLayout.createSequentialGroup()
                            .addComponent(btnSua)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHuy1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editFormLayout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addGap(21, 21, 21)
                            .addComponent(txtNgayMuon1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(editFormLayout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNgayTra1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(validNgayTra1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(validNgayMuon1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        editFormLayout.setVerticalGroup(
            editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editFormLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtMaP1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validMaP1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtMaS1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validMaS1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMaDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validMaDG1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(txtSL1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(validSL1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtGia1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validGia1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNgayMuon1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validNgayMuon1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtNgayTra1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validNgayTra1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(editFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnHuy1))
                .addGap(45, 45, 45))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("QUẢN LÝ PHIẾU");

        btnDisplayThem.setBackground(new java.awt.Color(204, 204, 204));
        btnDisplayThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDisplayThem.setText("Thêm phiếu");
        btnDisplayThem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDisplayThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(204, 204, 204));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setText("Xóa phiếu");
        btnXoa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoa.setMaximumSize(new java.awt.Dimension(92, 22));
        btnXoa.setMinimumSize(new java.awt.Dimension(92, 22));
        btnXoa.setPreferredSize(new java.awt.Dimension(92, 22));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnDisplaySua.setBackground(new java.awt.Color(204, 204, 204));
        btnDisplaySua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDisplaySua.setText("Sửa phiếu");
        btnDisplaySua.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDisplaySua.setMaximumSize(new java.awt.Dimension(92, 22));
        btnDisplaySua.setMinimumSize(new java.awt.Dimension(92, 22));
        btnDisplaySua.setPreferredSize(new java.awt.Dimension(92, 22));
        btnDisplaySua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplaySuaActionPerformed(evt);
            }
        });

        btnTim.setBackground(new java.awt.Color(204, 204, 204));
        btnTim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTim.setText("Tìm kiếm");
        btnTim.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTim.setMaximumSize(new java.awt.Dimension(92, 22));
        btnTim.setMinimumSize(new java.awt.Dimension(92, 22));
        btnTim.setPreferredSize(new java.awt.Dimension(92, 22));
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        tbPhieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tbPhieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhieuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPhieu);

        btnDong.setBackground(new java.awt.Color(204, 204, 204));
        btnDong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDong.setText("Đóng");
        btnDong.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDong.setMaximumSize(new java.awt.Dimension(92, 22));
        btnDong.setMinimumSize(new java.awt.Dimension(92, 22));
        btnDong.setPreferredSize(new java.awt.Dimension(92, 22));
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDisplayThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnDisplaySua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDisplayThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDisplaySua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDisplayThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayThemActionPerformed
        // TODO add your handling code here:
        addForm.setVisible(true);
        addForm.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnDisplayThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int indexRemove = tbPhieu.getSelectedRow();
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
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnDisplaySuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplaySuaActionPerformed
        // TODO add your handling code here:
        indexEdit = tbPhieu.getSelectedRow();
        if (indexEdit == -1) {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần chọn 1 hàng để sửa!!");
        } else if (list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Bảng trống không thể sửa!!");
        } else {
            editForm.setVisible(true);
            editForm.setLocationRelativeTo(this);
        }
    }//GEN-LAST:event_btnDisplaySuaActionPerformed

    private void tbPhieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhieuMouseClicked
        // TODO add your handling code here:
        indexEdit = tbPhieu.getSelectedRow();
        setEditData(list.get(indexEdit));
    }//GEN-LAST:event_tbPhieuMouseClicked

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        searchForm.setVisible(true);
        searchForm.setLocationRelativeTo(this);


    }//GEN-LAST:event_btnTimActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        searchForm.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Boolean check = false;
        for (Phieu phieu : list) {
            if (phieu.getMaP().equals(txtSearch.getText())) {
                listSearch.add(phieu);
                showResultSearch();
                listSearch.clear();
                check = true;
            }
        }
        if (!check) {
            JOptionPane.showMessageDialog(rootPane, "Mã phiếu bạn nhập không tồn tại!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (checkmhd()) {
            try {
                Phieu p = getDetailPhieu();

                if (valid) {
                    list.add(p);
                    file.write(list);
                    cancelValues();
                    showResult();
                    addForm.dispose();
                }
            } catch (Exception e) {
                System.out.println("Thêm thất bại.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Mã phiếu đã tồn tại. Bạn hãy nhập lại phiếu");
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        addForm.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnHuy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuy1ActionPerformed
        // TODO add your handling code here:
        editForm.dispose();
    }//GEN-LAST:event_btnHuy1ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        Phieu a = getDetailPhieuEdit();
        if (valid1) {
            list.set(indexEdit, a);
            file.write(list);
            showResult();
            cancelValues();
            editForm.dispose();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    public void setEditData(Phieu p) {
        txtMaP1.setText(p.getMaP());
        txtMaS1.setText(p.getMaS());
        txtMaDG1.setText(p.getMaDG());
        txtGia1.setText(p.getGia() + "");
        txtSL1.setText(p.getsL() + "");
        txtNgayMuon1.setText(p.getNgaymuon());
        txtNgayTra1.setText(p.getNgaytra());
    }

    public void cancelValues() {
        txtMaP.setText("");
        txtMaS.setText("");
        txtGia.setText("");
        txtNgayTra.setText("");
        txtMaDG.setText("");
        txtSL.setText("");
        txtNgayMuon.setText("");
    }

    public void showResult() {
        model.setRowCount(0);
        for (Phieu p : list) {
            model.addRow(new Object[]{
                p.getMaP(), p.getMaS(), p.getMaDG(), p.getsL(), p.getGia(), p.getNgaymuon(), p.getNgaytra()
            });
        }
    }

    public void showResultSearch() {
        model1.setRowCount(0);
        for (Phieu p : listSearch) {
            model1.addRow(new Object[]{
                p.getMaP(), p.getMaS(), p.getMaDG(), p.getsL(), p.getGia(), p.getNgaymuon(), p.getNgaytra()
            });
        }
    }

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
            java.util.logging.Logger.getLogger(QuanLyPhieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new QuanLyPhieu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog addForm;
    private javax.swing.JButton btnDisplaySua;
    private javax.swing.JButton btnDisplayThem;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnHuy1;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JDialog editForm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JDialog searchForm;
    private javax.swing.JTable tbPhieu;
    private javax.swing.JTable tbSearch;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGia1;
    private javax.swing.JTextField txtMaDG;
    private javax.swing.JTextField txtMaDG1;
    private javax.swing.JTextField txtMaP;
    private javax.swing.JTextField txtMaP1;
    private javax.swing.JTextField txtMaS;
    private javax.swing.JTextField txtMaS1;
    private javax.swing.JTextField txtNgayMuon;
    private javax.swing.JTextField txtNgayMuon1;
    private javax.swing.JTextField txtNgayTra;
    private javax.swing.JTextField txtNgayTra1;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtSL1;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel validGia;
    private javax.swing.JLabel validGia1;
    private javax.swing.JLabel validMaDG;
    private javax.swing.JLabel validMaDG1;
    private javax.swing.JLabel validMaP;
    private javax.swing.JLabel validMaP1;
    private javax.swing.JLabel validMaS;
    private javax.swing.JLabel validMaS1;
    private javax.swing.JLabel validNgayMuon;
    private javax.swing.JLabel validNgayMuon1;
    private javax.swing.JLabel validNgayTra;
    private javax.swing.JLabel validNgayTra1;
    private javax.swing.JLabel validSL;
    private javax.swing.JLabel validSL1;
    // End of variables declaration//GEN-END:variables
}
