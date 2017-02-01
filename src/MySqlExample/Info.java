/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySqlExample;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP Word
 */
public class Info extends javax.swing.JFrame {

    /**
     * Creates new form Tutorial
     */
    public Info() {
        initComponents();
        setSize(540, 575);
        setLocationRelativeTo(null);
        
    }
//
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbInfo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        txtSex = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        btnDelete1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 80, 70, 30);
        getContentPane().add(txtName);
        txtName.setBounds(120, 80, 160, 30);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(290, 40, 110, 40);

        tbInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Sex", "Age", "Salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbInfo);
        if (tbInfo.getColumnModel().getColumnCount() > 0) {
            tbInfo.getColumnModel().getColumn(0).setResizable(false);
            tbInfo.getColumnModel().getColumn(1).setResizable(false);
            tbInfo.getColumnModel().getColumn(2).setResizable(false);
            tbInfo.getColumnModel().getColumn(3).setResizable(false);
            tbInfo.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 290, 460, 220);

        jLabel2.setText("Sex");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 120, 70, 30);

        txtSearch.setForeground(new java.awt.Color(204, 204, 255));
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch);
        txtSearch.setBounds(40, 250, 160, 30);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit);
        btnEdit.setBounds(290, 90, 110, 40);

        jLabel3.setText("Salary");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 200, 70, 30);
        getContentPane().add(txtAge);
        txtAge.setBounds(120, 160, 160, 30);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch);
        btnSearch.setBounds(210, 250, 120, 30);
        getContentPane().add(txtSex);
        txtSex.setBounds(120, 120, 160, 30);

        jLabel4.setText("Age");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 160, 70, 30);
        getContentPane().add(txtSalary);
        txtSalary.setBounds(120, 200, 160, 30);

        btnDelete1.setText("Delete");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete1);
        btnDelete1.setBounds(290, 140, 110, 40);

        jLabel5.setText("ID");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 40, 70, 30);
        getContentPane().add(txtID);
        txtID.setBounds(120, 40, 160, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Statement stm;
        int age, salary, id;
        String name, sex;
        age = Integer.parseInt(txtAge.getText());
        id = Integer.parseInt(txtID.getText());
        name = txtName.getText();
        sex = txtSex.getText();
        salary = Integer.parseInt(txtSalary.getText());
        try {
            stm = con.createStatement();
            stm.execute("insert into tbinfo(id,name,sex,age,salary) values(" + id + ",'" + name + "','" + sex + "'," + age + "," + salary + ")");
            JOptionPane.showMessageDialog(null, "Inserted");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        clear();
        readData();
        clearControl();
        //String s= txtAge.getText().toString();
    }//GEN-LAST:event_btnAddActionPerformed
    DefaultTableModel mode;

    public void readData() {
        mode = (DefaultTableModel) tbInfo.getModel();
        Statement stm;
        ResultSet rs;
        try {
            stm = con.createStatement();
            rs = stm.executeQuery("select * from tbinfo");
            if (rs.first()) {
                do {
                    String[] data = {rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5)
                    };
                    mode.addRow(data);
                } while (rs.next());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void clear() {
        while (mode.getRowCount() > 0) {
            mode.removeRow(0);
        }

    }

    Connection con;

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtSearch.setText("Search name in here");
        try {
            con = SqlConnection.getConnect("localhost", "sample", "admin", "1111");
            //JOptionPane.showMessageDialog(null,"connected");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        readData();
        
    }//GEN-LAST:event_formWindowOpened

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
       
        delete();
        clear();
        readData();
    }//GEN-LAST:event_btnDelete1ActionPerformed
    public void delete() {
        Statement stm;
        int row, id;
        row = tbInfo.getSelectedRow();
        id = Integer.parseInt(""+tbInfo.getValueAt(row, 0));
        //JOptionPane.showMessageDialog(null, id);
        try {
            stm = con.createStatement();
            stm.execute("delete  from tbinfo where id="+id);
            JOptionPane.showMessageDialog(this, "Deleted");
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }

    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        edit();
        clear();
        readData();
        clearControl();

    }//GEN-LAST:event_btnEditActionPerformed
    public void edit(){
        int row =tbInfo.getSelectedRow();
        if(btnEdit.getText().equalsIgnoreCase("Edit")){
            txtID.setText(""+tbInfo.getValueAt(row, 0));
            txtName.setText(""+tbInfo.getValueAt(row, 1));
            txtSex.setText(""+tbInfo.getValueAt(row, 2));
            txtAge.setText(""+tbInfo.getValueAt(row, 3));
            txtSalary.setText(""+tbInfo.getValueAt(row,  4));
            btnEdit.setText("Update");
        }
        else if(btnEdit.getText().equalsIgnoreCase("Update")){
            btnEdit.setText("Edit");
            
            int id,age,salary;
            String name,sex;
            id=Integer.parseInt(txtID.getText());
            age=Integer.parseInt(txtAge.getText());
            salary=Integer.parseInt(txtSalary.getText());
            name=txtName.getText();
            sex=txtSex.getText();
            Statement stm;
            int condi=Integer.parseInt(""+tbInfo.getValueAt(row,0));
            
            try {
                stm=con.createStatement();
                stm.execute("update tbinfo set name='"+name+"',sex='"+sex+"'"
                        + ",age="+age+",salary="+salary+" where id="+condi);
                JOptionPane .showMessageDialog(null,"Updated");
            } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex);
            }
            
        }
        
    }
    public void search(){
        clear();
        Statement stm;
        ResultSet rs;
        String s = txtSearch.getText().trim();
        try {
            stm = con.createStatement();
            rs = stm.executeQuery("select * from tbinfo where name like '" + '%' + s + '%' + "' ");
            if (rs.first()) {
                do {
                    String[] data = {rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5)
                    };
                    mode.addRow(data);
                } while (rs.next());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        // TODO add your handling code here:
        
        txtSearch.setText("Serch name in here");
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        // TODO add your handling code here:
        txtSearch.setText(null);
    }//GEN-LAST:event_txtSearchMouseClicked

    private void tbInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInfoMouseClicked
        JMenuItem add=new JMenuItem("Add");
        JMenuItem edit=new JMenuItem("Edit");
        JMenuItem delete=new JMenuItem("Delete");
        JMenuItem refresh=new JMenuItem("Refresh");
        JPopupMenu pop=new JPopupMenu();
        JPopupMenu pop1=new JPopupMenu();
        
        pop.add(add);
        pop.add(edit);
        pop.add(delete);
        
        pop.add(refresh, 3);
        pop.setBackground(Color.red);
        tbInfo.setComponentPopupMenu(pop);
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                JOptionPane.showMessageDialog(null, "Hello PopupMenu");
                }catch(Exception ex){
                    
                    JOptionPane.showMessageDialog(null, ex);
                }
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }//GEN-LAST:event_tbInfoMouseClicked
public void clearControl(){
    
    txtID.setText(null);
    txtSearch.setText(null);
    txtName.setText(null);
    txtSex.setText(null);
    txtSalary.setText(null);
    txtAge.setText(null);
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
            java.util.logging.Logger.getLogger(Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbInfo;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSex;
    // End of variables declaration//GEN-END:variables
}
