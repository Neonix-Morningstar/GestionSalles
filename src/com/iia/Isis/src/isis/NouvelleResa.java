/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis;

import com.iia.osiris.metier.Salarie;
import com.iia.osiris.metier.Salle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Darkadok
 */
public class NouvelleResa extends javax.swing.JFrame {

    ArrayList<Salle> listSalles = new ArrayList<>();

    public NouvelleResa() {
        Connection cnx = null;
        Statement stmt = null;
        ResultSet ResultSalles = null;
        ResultSet ResultSalarie = null;
        ArrayList<Salarie> ListPersonne = new ArrayList<Salarie>();
        Salarie newSalarie = null;
        try {
            cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
            stmt = cnx.createStatement();
            ResultSalles = stmt.executeQuery("SELECT *  FROM Salle");
            stmt = cnx.createStatement();
            ResultSalarie = stmt.executeQuery("SELECT *  FROM Salarie");
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
        initComponents();
        try {
            this.jComboBox_Salle.removeAllItems();
            while (ResultSalles.next()) {
                this.jComboBox_Salle.addItem(new Salle(ResultSalles.getInt("Identifiant"), ResultSalles.getString("NumeroTerminal"), ResultSalles.getString("NomSalle"), null, null));
            }
            this.jComboBox_Salle.updateUI();

            this.jComboBox_Responsable.removeAllItems();
            this.jList_Personnes.removeAll();
            while (ResultSalarie.next()) {
                newSalarie = new Salarie(ResultSalarie.getInt("Identifiant"), ResultSalarie.getString("Nom"), ResultSalarie.getString("Prenom"), ResultSalarie.getString("Badge"), ResultSalarie.getBoolean("EstAdmin"));
                this.jComboBox_Responsable.addItem(newSalarie);
                ListPersonne.add(newSalarie);
            }
            this.jComboBox_Responsable.updateUI();

            this.jList_Personnes.setListData(ListPersonne.toArray());
            jList_Personnes.updateUI();

            cnx.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null, ex.getStackTrace(), "Error", 0);
            this.setVisible(false);
            this.dispose();
        }
        this.jComboBox_Responsable.setSelectedIndex(-1);
        this.jComboBox_Salle.setSelectedIndex(-1);
        cnx = null;
        stmt = null;
        ResultSalles = null;
        ResultSalarie = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSCDatePicker1 = new com.javaswingcomponents.datepicker.JSCDatePicker();
        jComboBox_Salle = new javax.swing.JComboBox();
        jComboBox_Responsable = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_Personnes = new javax.swing.JList();
        jButton_Annuler = new javax.swing.JButton();
        jButton_ok = new javax.swing.JButton();
        jButton_RAZ = new javax.swing.JButton();
        jComboBox_Deb = new javax.swing.JComboBox();
        jComboBox_fin = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton_Chercher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Réserver une salle");

        jLabel1.setText("Date");

        jLabel2.setText("Salle");

        jLabel3.setText("Responsable");

        jLabel4.setText("Personnes autorisées");

        jComboBox_Salle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox_Responsable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_Responsable.setEnabled(false);

        jList_Personnes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList_Personnes.setEnabled(false);
        jScrollPane1.setViewportView(jList_Personnes);

        jButton_Annuler.setText("Annuler");
        jButton_Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AnnulerActionPerformed(evt);
            }
        });

        jButton_ok.setText("OK");
        jButton_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_okActionPerformed(evt);
            }
        });

        jButton_RAZ.setLabel("RàZ");
        jButton_RAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RAZActionPerformed(evt);
            }
        });

        jComboBox_Deb.setEnabled(false);

        jComboBox_fin.setEnabled(false);

        jLabel5.setText("Heure de début");

        jLabel6.setText("Heure de fin");

        jButton_Chercher.setText("Chercher disponibilités");
        jButton_Chercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChercherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_RAZ)
                        .addGap(129, 129, 129)
                        .addComponent(jButton_Chercher))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jSCDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox_Salle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox_Deb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox_Responsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_Annuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_ok))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(320, 320, 320))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_Responsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSCDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton_RAZ)
                                    .addComponent(jButton_Chercher)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox_Salle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox_Deb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Annuler)
                    .addComponent(jButton_ok)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_okActionPerformed
        Connection cnx = null;
        PreparedStatement prestmt;
        int IntDateDeb = -1;
        int IntDateFin = -1;
        int identifiant_jour = -1;
        int idReservation = -1;
        if (this.jComboBox_Responsable.getSelectedIndex() >= 0 && this.jComboBox_Salle.getSelectedIndex() >= 0 && this.jSCDatePicker1.getSelectedDate() != null) {
            IntDateDeb = Integer.parseInt(((String) jComboBox_Deb.getSelectedItem()).substring(0, 2).trim());
            IntDateFin = Integer.parseInt(((String) jComboBox_fin.getSelectedItem()).substring(0, 2).trim());
            if (IntDateDeb > IntDateFin) {
                javax.swing.JOptionPane.showMessageDialog(null, "Veuillez choisir une heure de fin postérieure à l'heure de début ", "Attention !", 2);
            } else {
                try {
                    cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
                    cnx.setAutoCommit(false);
                    identifiant_jour = jSCDatePicker1.getSelectedDate().getDay();
                    prestmt = cnx.prepareStatement("INSERT INTO reservation VALUES (NULL,?,?,?,?,?,?); ", Statement.RETURN_GENERATED_KEYS);
                    prestmt.setDate(1, new java.sql.Date(this.jSCDatePicker1.getSelectedDate().getTime()));

                    prestmt.setTime(2, new Time(IntDateDeb, 0, 0));

                    prestmt.setTime(3, new Time(IntDateFin, 59, 00));
                    prestmt.setInt(4, identifiant_jour);
                    prestmt.setInt(5, ((Salarie) jComboBox_Responsable.getSelectedItem()).getIdentifiant());
                    prestmt.setInt(6, ((Salle) jComboBox_Salle.getSelectedItem()).getIdentifiant());
                    prestmt.executeUpdate();
                    cnx.commit();
                    ResultSet tmpSet = prestmt.getGeneratedKeys();
                    tmpSet.next();
                    idReservation = tmpSet.getInt(1);
                    tmpSet = null;
                    //ajouter les autorisés
                    for (Salarie selected : (ArrayList<Salarie>) jList_Personnes.getSelectedValuesList()) {
                        prestmt = cnx.prepareStatement("INSERT INTO autorise VALUES (?,?);");
                        prestmt.setInt(1, selected.getIdentifiant());
                        prestmt.setInt(2, idReservation);
                        prestmt.executeUpdate();
                        cnx.commit();
                    }
                    javax.swing.JOptionPane.showMessageDialog(null, "Réservation effectuée avec succès !", "Information !", 1);
                    prestmt = null;
                    cnx.close();
                    
                    this.setVisible(false);
                    this.dispose();
                } catch (Exception ex) {
                    System.out.println(ex.getStackTrace());
                    try {
                        cnx.rollback();
                    } catch (SQLException ex1) {
                        System.out.println(ex1.getStackTrace());
                    }
                }
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs", "Attention !", 2);
        }

    }//GEN-LAST:event_jButton_okActionPerformed

    private void jButton_AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AnnulerActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton_AnnulerActionPerformed

    private void jButton_RAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RAZActionPerformed
        this.jList_Personnes.clearSelection();
        this.jComboBox_Responsable.setSelectedIndex(-1);
        this.jComboBox_Salle.setSelectedIndex(-1);
        this.jSCDatePicker1.setSelectedDate(null);
    }//GEN-LAST:event_jButton_RAZActionPerformed

    private void jButton_ChercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChercherActionPerformed
        Connection cnx = null;
        PreparedStatement prestmt = null;
        ResultSet result = null;
        Time heurDeb1 = null;
        Time heurDeb2 = null;
        Time heurFin1 = null;
        Time heurFin2 = null;
        int tmp = -1;

        if (jComboBox_Salle.getSelectedIndex() >= 0) {
            jComboBox_Deb.setEnabled(true);
            jComboBox_fin.setEnabled(true);
            jComboBox_Responsable.setEnabled(true);
            jList_Personnes.setEnabled(true);

            try {//A TESTER !!!!
                cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
                prestmt = cnx.prepareStatement("SELECT * FROM disponibilite WHERE identifiantSalle = ?;");
                prestmt.setInt(1, ((Salle) jComboBox_Salle.getSelectedItem()).getIdentifiant());
                result = prestmt.executeQuery();
                while (result.next()) {
                    heurDeb1 = result.getTime("HoraireDebMat");
                    heurDeb2 = result.getTime("HoraireDebSoir");
                    heurFin1 = result.getTime("HoraireFinMat");
                    heurFin2 = result.getTime("HoraireFinSoir");

                    jComboBox_Deb.removeAllItems();
                    jComboBox_fin.removeAllItems();

                    if (heurDeb1 != null && heurFin1 != null) {
                        tmp = heurDeb1.getHours();
                        while (tmp <= heurFin1.getHours()) {
                            jComboBox_Deb.addItem(tmp + " : 00");
                            jComboBox_fin.addItem(tmp + " : 59");
                            tmp++;
                        }
                    }

                    if (heurDeb2 != null && heurFin2 != null) {
                        tmp = heurDeb2.getHours();
                        while (tmp <= heurFin2.getHours()) {
                            jComboBox_Deb.addItem(tmp + " : 00");
                            jComboBox_fin.addItem(tmp + " : 59");
                            tmp++;
                        }
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getStackTrace());
            }
        }
    }//GEN-LAST:event_jButton_ChercherActionPerformed

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
            java.util.logging.Logger.getLogger(NouvelleResa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NouvelleResa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NouvelleResa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NouvelleResa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NouvelleResa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Annuler;
    private javax.swing.JButton jButton_Chercher;
    private javax.swing.JButton jButton_RAZ;
    private javax.swing.JButton jButton_ok;
    private javax.swing.JComboBox jComboBox_Deb;
    private javax.swing.JComboBox jComboBox_Responsable;
    private javax.swing.JComboBox jComboBox_Salle;
    private javax.swing.JComboBox jComboBox_fin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jList_Personnes;
    private javax.swing.JPanel jPanel1;
    private com.javaswingcomponents.datepicker.JSCDatePicker jSCDatePicker1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
