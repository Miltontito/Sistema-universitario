/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.milton.gomez.sistema.universitario.View.Panels.Materias;

import com.milton.gomez.sistema.universitario.Controller.ControllerMateria;
import com.milton.gomez.sistema.universitario.Model.Alumno;
import com.milton.gomez.sistema.universitario.Model.Materia;
import com.milton.gomez.sistema.universitario.View.ViewMain;
import javax.swing.DefaultListModel;

/**
 *
 * @author milton
 */
public class DetallesMateriaPanel extends javax.swing.JPanel {

    private Integer materiaId;
    
    public DetallesMateriaPanel(Integer id) {
        this.materiaId = id;
        initComponents();
        inicializarComponentes(materiaId);
        listarAlumnosAprobados();
        listarAlumnosCursando();
        listarAlumnosSinFinal();
    }

    private void inicializarComponentes(Integer materiaId){
        Materia materia = ControllerMateria.obtenerMateria(materiaId);
        tituloLabel.setText(materia.getNombre());
        idPlaceholder.setText(materia.getCodigoDeMateria());
        promocionablePlaceholder.setText(materia.isPromocionable() ? "Es promocionable": "No es promocionable");
        codMateriaPlaceholder.setText(materia.getCodigoDeMateria());
        DefaultListModel<Materia> model = (DefaultListModel<Materia>) correlativasList.getModel();
        model.addAll(materia.getCorrelativas());
        correlativasList.setModel(model);
    }
    
    private void listarAlumnosAprobados(){
        DefaultListModel<Alumno> model = (DefaultListModel<Alumno>) alumnosAprobadosList.getModel();
        model.addAll(ControllerMateria.obtenerAlumnosAprobados(this.materiaId));
        alumnosAprobadosList.setModel(model);
    }

    private void listarAlumnosCursando(){
        DefaultListModel<Alumno> model = (DefaultListModel<Alumno>) alumnosCursandoList.getModel();
        model.addAll(ControllerMateria.obtenerAlumnosCursando(this.materiaId));
        alumnosCursandoList.setModel(model);
    }

    private void listarAlumnosSinFinal(){
        DefaultListModel<Alumno> model = (DefaultListModel<Alumno>) alumnosSinFinalList.getModel();
        model.addAll(ControllerMateria.obtenerAlumnosQueVanAFinal(this.materiaId));
        alumnosSinFinalList.setModel(model);
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
        tituloLabel = new javax.swing.JLabel();
        Separador_Separator = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codMateriaPlaceholder = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idPlaceholder = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        promocionablePlaceholder = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        correlativasList = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alumnosCursandoList = new javax.swing.JList<>();
        aprobarCursadaButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        alumnosSinFinalList = new javax.swing.JList<>();
        aprobarFinalButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        alumnosAprobadosList = new javax.swing.JList<>();

        tituloLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        tituloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/materia_icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador_Separator)
                    .addComponent(tituloLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(tituloLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Separador_Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setText("Id: ");

        codMateriaPlaceholder.setText("placeholder");

        jLabel3.setText("Cod. Materia:");

        idPlaceholder.setText("placeholder");

        jLabel5.setText("Promocionable:");

        promocionablePlaceholder.setText("placeholder");

        correlativasList.setModel(new DefaultListModel<>());
        jScrollPane1.setViewportView(correlativasList);

        jLabel7.setText("Correlativas:");

        jLabel8.setText("Alumnos cursando:");

        alumnosCursandoList.setModel(new DefaultListModel<>());
        jScrollPane2.setViewportView(alumnosCursandoList);

        aprobarCursadaButton.setBackground(new java.awt.Color(204, 0, 0));
        aprobarCursadaButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        aprobarCursadaButton.setForeground(new java.awt.Color(255, 255, 255));
        aprobarCursadaButton.setText("Aprobar");
        aprobarCursadaButton.setBorderPainted(false);
        aprobarCursadaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprobarCursadaButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("Alumnos sin final:");

        alumnosSinFinalList.setModel(new DefaultListModel<>());
        jScrollPane3.setViewportView(alumnosSinFinalList);

        aprobarFinalButton.setBackground(new java.awt.Color(204, 0, 0));
        aprobarFinalButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        aprobarFinalButton.setForeground(new java.awt.Color(255, 255, 255));
        aprobarFinalButton.setText("Aprobar");
        aprobarFinalButton.setBorderPainted(false);
        aprobarFinalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprobarFinalButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Alumnos aprobados:");

        alumnosAprobadosList.setModel(new DefaultListModel<>());
        jScrollPane4.setViewportView(alumnosAprobadosList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(codMateriaPlaceholder))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(idPlaceholder))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(promocionablePlaceholder))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(88, 88, 88)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(aprobarFinalButton)
                                    .addGap(68, 68, 68))))
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(aprobarCursadaButton))
                                .addGap(99, 99, 99))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(103, 103, 103))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idPlaceholder)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aprobarCursadaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aprobarFinalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(codMateriaPlaceholder))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(promocionablePlaceholder))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void aprobarCursadaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprobarCursadaButtonActionPerformed
        if(alumnosCursandoList.getSelectedIndex() != -1){
            ControllerMateria.aprobarAlumno(alumnosCursandoList.getSelectedValue(), materiaId);
            ViewMain.ShowJPanel(new DetallesMateriaPanel(this.materiaId));
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un alumno de la lista de alumnos cursando. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_aprobarCursadaButtonActionPerformed

    private void aprobarFinalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprobarFinalButtonActionPerformed
        if(alumnosCursandoList.getSelectedIndex() != -1){
            ControllerMateria.aprobarAlumno(alumnosCursandoList.getSelectedValue(), materiaId);
            ViewMain.ShowJPanel(new DetallesMateriaPanel(this.materiaId));
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un alumno de la lista de alumnos sin final. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }    }//GEN-LAST:event_aprobarFinalButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator Separador_Separator;
    private javax.swing.JList<Alumno> alumnosAprobadosList;
    private javax.swing.JList<Alumno> alumnosCursandoList;
    private javax.swing.JList<Alumno> alumnosSinFinalList;
    private javax.swing.JButton aprobarCursadaButton;
    private javax.swing.JButton aprobarFinalButton;
    private javax.swing.JLabel codMateriaPlaceholder;
    private javax.swing.JList<Materia> correlativasList;
    private javax.swing.JLabel idPlaceholder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel promocionablePlaceholder;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
}
