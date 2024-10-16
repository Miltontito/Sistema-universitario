/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package com.milton.gomez.sistema.universitario.View.Panels.Carrera;

import com.milton.gomez.sistema.universitario.Controller.ControllerCarrera;
import com.milton.gomez.sistema.universitario.Controller.ControllerMateria;
import com.milton.gomez.sistema.universitario.Controller.ControllerPlanDeEstudio;
import com.milton.gomez.sistema.universitario.Model.Cuatrimestre;
import com.milton.gomez.sistema.universitario.Model.Materia;
import com.milton.gomez.sistema.universitario.Model.PlanDeEstudio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author milton
 */
public class SubirCarreraPanel extends javax.swing.JPanel {

    private Integer carreraId;
    private Boolean isEdicion = false;
    private Integer nroCuatrimestre = 0;
    private List<Materia> materiasDisponibles = ControllerMateria.listarTodasLasMaterias();
    
    /** Creates new form SubirCarreraPanel */
    public SubirCarreraPanel() {
        initComponents();
        listarPlanesDeEstudio();
        configurarEventosTabla();
    }
    
    public SubirCarreraPanel(Integer carreraId) {
        initComponents();
        listarPlanesDeEstudio();
        this.carreraId = carreraId;
        this.isEdicion = true;
    }
    
    private void listarPlanesDeEstudio(){
        DefaultListModel<PlanDeEstudio> listModel = (DefaultListModel<PlanDeEstudio>) PlanesDeEstudio_List.getModel();
        listModel.clear();
        ControllerPlanDeEstudio.listarTodosLosPlaneDeEstudio().forEach(p -> listModel.addElement(p));
    }
    
    private void listarMaterias(){
        DefaultListModel<Materia> listModel = (DefaultListModel<Materia>) Materias_List.getModel();
        listModel.clear();
        this.materiasDisponibles.forEach(m -> listModel.addElement(m));
    }
    
    private void eliminarMateriasSeleccionadas(){
        DefaultListModel<Materia> listModel = (DefaultListModel<Materia>) Materias_List.getModel();
        for(int i : Materias_List.getSelectedIndices()){
            listModel.removeElementAt(i);
        }
    }
    
    // Método para configurar eventos, en este caso un Selection Listener de la tabla Cuatrimestres.
    private void configurarEventosTabla() {
        ListSelectionModel seleccionModel = Cuatrimestres_Table.getSelectionModel();
        seleccionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = Cuatrimestres_Table.getSelectedRow();
                if (filaSeleccionada != -1) {
                    listarMaterias();
                }
            }
        });
    }
    private void asignarMateria(boolean esObligatoria) {
        
        List<Materia> materiaSeleccionada = Materias_List.getSelectedValuesList();

        if (materiaSeleccionada == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar una materia primero. \n", "AVISO", javax.swing.JOptionPane.WARNING_MESSAGE);
            return; // Salir si no se selecciona una materia
        }

        // Obtener el cuatrimestre seleccionado en la tabla
        int filaSeleccionada = Cuatrimestres_Table.getSelectedRow();
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un cuatrimestre primero. \n", "AVISO", javax.swing.JOptionPane.WARNING_MESSAGE);
            return; // Salir si no se selecciona un cuatrimestre
        }

        // Asignar la materia al cuatrimestre
        DefaultTableModel tableModel = (DefaultTableModel) Cuatrimestres_Table.getModel();

        if (esObligatoria) {
            // Recuperar la lista de materias obligatorias existente
            List<Materia> materiasObligatorias = (List<Materia>) tableModel.getValueAt(filaSeleccionada, 2);
            
            if (materiasObligatorias == null) { // Si la lista no existe, crear una nueva
                materiasObligatorias = new ArrayList<>();
            }
            
            materiasObligatorias.addAll(materiaSeleccionada);
            tableModel.setValueAt(materiasObligatorias, filaSeleccionada, 2); // Columna de obligatoria
            eliminarMateriasSeleccionadas();
        } else {
            // Recuperar la lista de materias optativas existente
            List<Materia> materiasOptativas = (List<Materia>) tableModel.getValueAt(filaSeleccionada, 1);
            
            if (materiasOptativas == null) { // Si la lista no existe, crear una nueva
                materiasOptativas = new ArrayList<>();
            }
            
            materiasOptativas.addAll(materiaSeleccionada);
            tableModel.setValueAt(materiasOptativas, filaSeleccionada, 1); // Columna de opcional
            eliminarMateriasSeleccionadas();
        }
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background_Panel = new javax.swing.JPanel();
        Title_Panel = new javax.swing.JPanel();
        Separador_Separator = new javax.swing.JSeparator();
        Titulo_Label = new javax.swing.JLabel();
        Body_Panel = new javax.swing.JPanel();
        Nombre_TextField = new javax.swing.JTextField();
        CodigoCarrera_TextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Cuatrimestres_Table = new javax.swing.JTable();
        removeCuatrimestre_Button = new javax.swing.JButton();
        addCuatrimestre_Button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PlanesDeEstudio_List = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Materias_List = new javax.swing.JList<>();
        Opcional_Button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Obligatoria_Button = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Subir_Button = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(780, 580));

        Titulo_Label.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        Titulo_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrera_icon.png"))); // NOI18N
        Titulo_Label.setText("Crear nueva Carrera");

        javax.swing.GroupLayout Title_PanelLayout = new javax.swing.GroupLayout(Title_Panel);
        Title_Panel.setLayout(Title_PanelLayout);
        Title_PanelLayout.setHorizontalGroup(
            Title_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Title_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Title_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Title_PanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(Titulo_Label))
                    .addComponent(Separador_Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(176, 176, 176))
        );
        Title_PanelLayout.setVerticalGroup(
            Title_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Title_PanelLayout.createSequentialGroup()
                .addComponent(Titulo_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separador_Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Nombre_TextField.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Nombre_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_TextFieldActionPerformed(evt);
            }
        });

        CodigoCarrera_TextField.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        CodigoCarrera_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoCarrera_TextFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("Seleccione un Cuatrimestre *");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jScrollPane1PropertyChange(evt);
            }
        });

        Cuatrimestres_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Optativa", "Obligatoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Cuatrimestres_Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        Cuatrimestres_Table.setColumnSelectionAllowed(true);
        Cuatrimestres_Table.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Cuatrimestres_TablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(Cuatrimestres_Table);
        Cuatrimestres_Table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        removeCuatrimestre_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        removeCuatrimestre_Button.setText("-");
        removeCuatrimestre_Button.setBorderPainted(false);
        removeCuatrimestre_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCuatrimestre_ButtonActionPerformed(evt);
            }
        });

        addCuatrimestre_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        addCuatrimestre_Button.setText("+");
        addCuatrimestre_Button.setBorderPainted(false);
        addCuatrimestre_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCuatrimestre_ButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Seleccione el plan de estudio *");

        PlanesDeEstudio_List.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        PlanesDeEstudio_List.setModel(new DefaultListModel<>());
        PlanesDeEstudio_List.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(PlanesDeEstudio_List);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("Seleccione las materias *");

        Materias_List.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Materias_List.setModel(new DefaultListModel<>());
        jScrollPane3.setViewportView(Materias_List);

        Opcional_Button.setBackground(new java.awt.Color(204, 0, 0));
        Opcional_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Opcional_Button.setForeground(new java.awt.Color(255, 255, 255));
        Opcional_Button.setText("Opcional");
        Opcional_Button.setBorderPainted(false);
        Opcional_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opcional_ButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("Nombre *");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setText("Codigo *");

        Obligatoria_Button.setBackground(new java.awt.Color(204, 0, 0));
        Obligatoria_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Obligatoria_Button.setForeground(new java.awt.Color(255, 255, 255));
        Obligatoria_Button.setText("Obligatoria");
        Obligatoria_Button.setBorderPainted(false);
        Obligatoria_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Obligatoria_ButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Subir_Button.setBackground(new java.awt.Color(204, 0, 0));
        Subir_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Subir_Button.setForeground(new java.awt.Color(255, 255, 255));
        Subir_Button.setText("Subir");
        Subir_Button.setBorderPainted(false);

        javax.swing.GroupLayout Body_PanelLayout = new javax.swing.GroupLayout(Body_Panel);
        Body_Panel.setLayout(Body_PanelLayout);
        Body_PanelLayout.setHorizontalGroup(
            Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Body_PanelLayout.createSequentialGroup()
                .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Body_PanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(Nombre_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                .addComponent(CodigoCarrera_TextField))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Body_PanelLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(removeCuatrimestre_Button)
                        .addGap(37, 37, 37)
                        .addComponent(addCuatrimestre_Button)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Body_PanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(Body_PanelLayout.createSequentialGroup()
                                        .addComponent(Opcional_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Obligatoria_Button))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Body_PanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Subir_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
        );
        Body_PanelLayout.setVerticalGroup(
            Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Body_PanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Body_PanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Body_PanelLayout.createSequentialGroup()
                        .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Body_PanelLayout.createSequentialGroup()
                                .addComponent(Nombre_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel5))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Body_PanelLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Opcional_Button)
                                    .addComponent(Obligatoria_Button))
                                .addGap(37, 37, 37)
                                .addComponent(Subir_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(Body_PanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CodigoCarrera_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addCuatrimestre_Button)
                                    .addComponent(removeCuatrimestre_Button))
                                .addGap(51, 51, 51))))))
        );

        javax.swing.GroupLayout Background_PanelLayout = new javax.swing.GroupLayout(Background_Panel);
        Background_Panel.setLayout(Background_PanelLayout);
        Background_PanelLayout.setHorizontalGroup(
            Background_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Body_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Background_PanelLayout.setVerticalGroup(
            Background_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background_PanelLayout.createSequentialGroup()
                .addComponent(Title_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Body_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Nombre_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_TextFieldActionPerformed

    private void addCuatrimestre_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCuatrimestre_ButtonActionPerformed
        DefaultTableModel listModel = (DefaultTableModel) Cuatrimestres_Table.getModel();
        
        Cuatrimestre c = ControllerCarrera.crearCuatrimestre(nroCuatrimestre);
        listModel.addRow(new Object[]{c, c.getMateriasOptativas(), c.getMateriasObligatorias()});
        
        nroCuatrimestre++;
    }//GEN-LAST:event_addCuatrimestre_ButtonActionPerformed

    private void CodigoCarrera_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoCarrera_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoCarrera_TextFieldActionPerformed

    private void removeCuatrimestre_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCuatrimestre_ButtonActionPerformed
        DefaultTableModel listModel = (DefaultTableModel) Cuatrimestres_Table.getModel();
        if(listModel.getRowCount() != 0){
            int fila = listModel.getRowCount()-1;
            
            List<Materia> materiasOptativas = (List<Materia>) listModel.getValueAt(fila, 1);
            List<Materia> materiasObligatorias = (List<Materia>) listModel.getValueAt(fila, 2);
            
            DefaultListModel listModelMaterias = (DefaultListModel) Materias_List.getModel();
            listModelMaterias.addAll(materiasOptativas);
            listModelMaterias.addAll(materiasObligatorias);
            listModel.removeRow(fila);
            nroCuatrimestre--;
        }
    }//GEN-LAST:event_removeCuatrimestre_ButtonActionPerformed

    private void Opcional_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opcional_ButtonActionPerformed
        asignarMateria(false); // no es obligatoria
    }//GEN-LAST:event_Opcional_ButtonActionPerformed

    private void jScrollPane1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jScrollPane1PropertyChange
    }//GEN-LAST:event_jScrollPane1PropertyChange

    private void Cuatrimestres_TablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Cuatrimestres_TablePropertyChange
    }//GEN-LAST:event_Cuatrimestres_TablePropertyChange

    private void Obligatoria_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Obligatoria_ButtonActionPerformed
        asignarMateria(true); // es obligatoria
    }//GEN-LAST:event_Obligatoria_ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_Panel;
    private javax.swing.JPanel Body_Panel;
    private javax.swing.JTextField CodigoCarrera_TextField;
    private javax.swing.JTable Cuatrimestres_Table;
    private javax.swing.JList<com.milton.gomez.sistema.universitario.Model.Materia> Materias_List;
    private javax.swing.JTextField Nombre_TextField;
    private javax.swing.JButton Obligatoria_Button;
    private javax.swing.JButton Opcional_Button;
    private javax.swing.JList<com.milton.gomez.sistema.universitario.Model.PlanDeEstudio> PlanesDeEstudio_List;
    private javax.swing.JSeparator Separador_Separator;
    private javax.swing.JButton Subir_Button;
    private javax.swing.JPanel Title_Panel;
    private javax.swing.JLabel Titulo_Label;
    private javax.swing.JButton addCuatrimestre_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton removeCuatrimestre_Button;
    // End of variables declaration//GEN-END:variables

}
