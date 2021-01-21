/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.ClassificationResult;
import model.TopologiaComboBoxModel;
import model.TopologiaTModel;

/**
 *
 * @author User
 */
public class MainView extends javax.swing.JFrame {
    File[] trainFiles;
    File[] testFiles;
    
    MainController mc = new MainController();
    TopologiaComboBoxModel tcm;
    
    
    /**
     * Creates new form MainView
     */
    
    public MainView() {
        initComponents();
        tcm = new TopologiaComboBoxModel(mc.getModels());
        jComboBox1.setModel(tcm);
        jFileChooser1.setMultiSelectionEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jTextTreino = new javax.swing.JTextField();
        jTextTeste = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBAbrirTreino = new javax.swing.JButton();
        jBAbrirTeste = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jBTreinar = new javax.swing.JButton();
        jBTeste = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Documentos para treino:");

        jLabel2.setText("Documentos para teste:");

        jBAbrirTreino.setText("Abrir...");
        jBAbrirTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbrirTreinoActionPerformed(evt);
            }
        });

        jBAbrirTeste.setText("Abrir...");
        jBAbrirTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbrirTesteActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jBTreinar.setText("Treinar");
        jBTreinar.setEnabled(false);
        jBTreinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTreinarActionPerformed(evt);
            }
        });

        jBTeste.setText("Testar");
        jBTeste.setEnabled(false);
        jBTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTesteActionPerformed(evt);
            }
        });

        jLabel3.setText("Modelo:");

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBAbrirTreino)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBTreinar))
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addComponent(jBAbrirTeste)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAbrirTreino)
                    .addComponent(jBTreinar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextTeste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAbrirTeste)
                    .addComponent(jBTeste))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAbrirTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbrirTreinoActionPerformed
        int result = jFileChooser1.showOpenDialog(jLabel1);
        if(result == jFileChooser1.APPROVE_OPTION){
            if(jFileChooser1.getSelectedFile().isDirectory()){
                trainFiles = jFileChooser1.getSelectedFile().listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.toLowerCase().endsWith(".pdf");
                    }
                });
            }else{
                trainFiles = jFileChooser1.getSelectedFiles();
            }
            jTextTreino.setText(jFileChooser1.getCurrentDirectory().getPath());
            jBTreinar.setEnabled(true);
            for(File f: trainFiles){
                System.out.println(f.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_jBAbrirTreinoActionPerformed

    private void jBAbrirTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbrirTesteActionPerformed
        int result = jFileChooser1.showOpenDialog(jLabel1);
        if(result == jFileChooser1.APPROVE_OPTION){
            if(jFileChooser1.getSelectedFile().isDirectory()){
                testFiles = jFileChooser1.getSelectedFile().listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".pdf");
                }
            });
            }else{
                testFiles = jFileChooser1.getSelectedFiles();
            }
            jTextTeste.setText(jFileChooser1.getCurrentDirectory().getPath());
            jBTeste.setEnabled(true);
        }
    }//GEN-LAST:event_jBAbrirTesteActionPerformed

    private void jBTreinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTreinarActionPerformed
        JDialog jd = new JDialog(this, "Treinando");
        JPanel jp = new JPanel();
        JLabel j1 = new JLabel("Aguarde...");
        jd.add(jp);
        jp.add(j1);
        jd.setSize(100, 100);
        jd.setVisible(true);
        mc.trainModel(trainFiles, (TopologiaTModel) jComboBox1.getSelectedItem(), 3);
        jd.dispose();
    }//GEN-LAST:event_jBTreinarActionPerformed

    private void jBTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTesteActionPerformed
        DefaultListModel dlm = new DefaultListModel();
        for(File t : testFiles){
            ClassificationResult cr = mc.testAgainstAllModels(t);
            dlm.add(dlm.size(), cr.getModelName() + ": " + cr.getPercentage() * 100 + "%");
        }
        jList1.setModel(dlm);
    }//GEN-LAST:event_jBTesteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NewModelView window = new NewModelView(this, true, mc);
        window.setVisible(true);
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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAbrirTeste;
    private javax.swing.JButton jBAbrirTreino;
    private javax.swing.JButton jBTeste;
    private javax.swing.JButton jBTreinar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Object> jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextTeste;
    private javax.swing.JTextField jTextTreino;
    // End of variables declaration//GEN-END:variables
}
