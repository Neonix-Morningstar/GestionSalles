/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.ihm;

import com.iia.osiris.metier.HistoriqueSalarieTableModel;
import com.iia.osiris.metier.HistoriqueSalleTableModel;

/**
 *
 * @author Akimar
 */
public class AccesFrame extends javax.swing.JFrame {

    HistoriqueSalarieTableModel historiqueSalarieTableModel;
    HistoriqueSalleTableModel historiqueSalleTableModel;
    /**
     * Creates new form AccesFrame
     */
    public AccesFrame(int indexModel, int id) {
        initComponents();
        
        if(indexModel == 1)
        {
            historiqueSalarieTableModel = new HistoriqueSalarieTableModel();
            historiqueSalarieTableModel.fillTable(id);
            
            tableAccess.setModel(historiqueSalarieTableModel);
        }
        else
        {
            historiqueSalleTableModel = new HistoriqueSalleTableModel();
            historiqueSalleTableModel.fillTable(id);
            tableAccess.setModel(historiqueSalleTableModel);
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

        tablePane = new javax.swing.JScrollPane();
        tableAccess = new javax.swing.JTable();
        titreLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tableAccess.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePane.setViewportView(tableAccess);

        titreLabel.setText("Historique des accès");
        titreLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(311, Short.MAX_VALUE)
                .addComponent(titreLabel)
                .addGap(311, 311, 311))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titreLabel)
                .addGap(18, 18, 18)
                .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        if(tableAccess.getRowCount() == 0)
        {
            this.dispose();
        }
    }//GEN-LAST:event_formWindowOpened

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable tableAccess;
    private javax.swing.JScrollPane tablePane;
    private javax.swing.JLabel titreLabel;
    // End of variables declaration//GEN-END:variables
}
