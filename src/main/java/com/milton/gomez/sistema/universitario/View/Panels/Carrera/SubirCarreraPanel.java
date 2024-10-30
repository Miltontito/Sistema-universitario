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
import com.milton.gomez.sistema.universitario.Transferible.TransferibleCarrera;
import com.milton.gomez.sistema.universitario.Transferible.TransferibleCuatrimestre;
import com.milton.gomez.sistema.universitario.View.Panels.Alumno.AlumnosPanel;
import com.milton.gomez.sistema.universitario.View.ViewMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;
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
        listarMaterias();
    }
    
    public SubirCarreraPanel(Integer id) {
        initComponents();
        listarPlanesDeEstudio();
        this.carreraId = id;
        this.isEdicion = true;
        editableView(id);
    }
    
    private void editableView(Integer id){
        TransferibleCarrera carrera = ControllerCarrera.obtenerDatosCarrera(id);


        carrera.getCuatrimestres().forEach((k,v) -> this.materiasDisponibles.removeAll(v.listarTodasLasMaterias()));
        listarMaterias();

        nombreTextField.setText(carrera.getNombre());
        codigoTextField.setText(carrera.getCodigoCarrera());
        optativasTextField.setText(carrera.getCantMateriasOptativasParaAprobar().toString());

        planesDeEstudioList.setSelectedValue(carrera.getPlanDeEstudio(), false);

        DefaultTableModel tableModel = (DefaultTableModel) cuatrimestresTable.getModel();
        carrera.getCuatrimestres().forEach((k,v) -> tableModel.addRow(new Object[]{k+1,v.listarMateriasOptativas(),v.listarMateriasObligatorias()}));
        cuatrimestresTable.setModel(tableModel);
    }
    
    private void listarPlanesDeEstudio(){
        DefaultListModel<PlanDeEstudio> listModel = (DefaultListModel<PlanDeEstudio>) planesDeEstudioList.getModel();
        listModel.clear();
        ControllerPlanDeEstudio.listarTodosLosPlaneDeEstudio().forEach(p -> listModel.addElement(p));
    }
    
    private void listarMaterias(){
        DefaultListModel<Materia> listModel = (DefaultListModel<Materia>) materiasList.getModel();
        listModel.clear();
        this.materiasDisponibles.forEach(m -> listModel.addElement(m));
    }
    
    private void eliminarMateriasSeleccionadas(){
        DefaultListModel<Materia> listModel = (DefaultListModel<Materia>) materiasList.getModel();
        for(int i : materiasList.getSelectedIndices()){
            listModel.removeElementAt(i);
        }
    }

    private HashMap<Integer, Cuatrimestre> obtenerCuatrimestresCreados(){
        DefaultTableModel table = (DefaultTableModel) cuatrimestresTable.getModel();
        HashMap<Integer, Cuatrimestre> cuatrimestreHash = new HashMap<>();
        for(int i = 0; i < table.getRowCount(); i++){
            Cuatrimestre cuatrimestre = new Cuatrimestre();
            cuatrimestre.setMateriasObligatorias((List<Materia>) table.getValueAt(i,2));
            cuatrimestre.setMateriasOptativas((List<Materia>) table.getValueAt(i,1));
            cuatrimestreHash.put(i+1, cuatrimestre);
        }

        return cuatrimestreHash;
    }

    private void asignarMateria(boolean esObligatoria) {
        
        List<Materia> materiaSeleccionada = materiasList.getSelectedValuesList();

        if (materiaSeleccionada == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar una materia primero. \n", "AVISO", javax.swing.JOptionPane.WARNING_MESSAGE);
            return; // Salir si no se selecciona una materia
        }

        // Obtener el cuatrimestre seleccionado en la tabla
        int filaSeleccionada = cuatrimestresTable.getSelectedRow();
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un cuatrimestre primero. \n", "AVISO", javax.swing.JOptionPane.WARNING_MESSAGE);
            return; // Salir si no se selecciona un cuatrimestre
        }

        // Asignar la materia al cuatrimestre
        DefaultTableModel tableModel = (DefaultTableModel) cuatrimestresTable.getModel();

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

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Background_Panel = new javax.swing.JPanel();
        Title_Panel = new javax.swing.JPanel();
        Separador_Separator = new javax.swing.JSeparator();
        Titulo_Label = new javax.swing.JLabel();
        Body_Panel = new javax.swing.JPanel();
        nombreTextField = new javax.swing.JTextField();
        codigoTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cuatrimestresTable = new javax.swing.JTable();
        removeCuatrimestre_Button = new javax.swing.JButton();
        addCuatrimestre_Button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        planesDeEstudioList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        materiasList = new javax.swing.JList<>();
        Opcional_Button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Obligatoria_Button = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Subir_Button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        optativasTextField = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable1);

        setMaximumSize(new java.awt.Dimension(780, 580));
        setPreferredSize(new java.awt.Dimension(780, 580));

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

        nombreTextField.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });

        codigoTextField.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        codigoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoTextFieldActionPerformed(evt);
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

        cuatrimestresTable.setModel(new javax.swing.table.DefaultTableModel(
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
        cuatrimestresTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        cuatrimestresTable.setColumnSelectionAllowed(true);
        cuatrimestresTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cuatrimestresTablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(cuatrimestresTable);
        cuatrimestresTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (cuatrimestresTable.getColumnModel().getColumnCount() > 0) {
            cuatrimestresTable.getColumnModel().getColumn(0).setMaxWidth(50);
            cuatrimestresTable.getColumnModel().getColumn(1).setMinWidth(90);
            cuatrimestresTable.getColumnModel().getColumn(2).setMinWidth(150);
        }

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

        planesDeEstudioList.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        planesDeEstudioList.setModel(new DefaultListModel<>());
        planesDeEstudioList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(planesDeEstudioList);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("Seleccione las materias *");

        materiasList.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        materiasList.setModel(new DefaultListModel<>());
        jScrollPane3.setViewportView(materiasList);

        Opcional_Button.setBackground(new java.awt.Color(204, 0, 0));
        Opcional_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Opcional_Button.setForeground(new java.awt.Color(255, 255, 255));
        Opcional_Button.setText("Opcional");
        Opcional_Button.setBorderPainted(false);
        Opcional_Button.setMaximumSize(new java.awt.Dimension(134, 34));
        Opcional_Button.setMinimumSize(new java.awt.Dimension(134, 34));
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
        Subir_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Subir_ButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setText("Optativas (Cantidad)");

        optativasTextField.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        optativasTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optativasTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Body_PanelLayout = new javax.swing.GroupLayout(Body_Panel);
        Body_Panel.setLayout(Body_PanelLayout);
        Body_PanelLayout.setHorizontalGroup(
            Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Body_PanelLayout.createSequentialGroup()
                .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Body_PanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(Body_PanelLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1)
                                    .addComponent(optativasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(codigoTextField)
                            .addComponent(nombreTextField))
                        .addGap(36, 36, 36)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Body_PanelLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(removeCuatrimestre_Button)
                        .addGap(36, 36, 36)
                        .addComponent(addCuatrimestre_Button)))
                .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Body_PanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Subir_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addGroup(Body_PanelLayout.createSequentialGroup()
                        .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(Body_PanelLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(Body_PanelLayout.createSequentialGroup()
                                                .addComponent(Opcional_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Obligatoria_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Body_PanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Body_PanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)))
                        .addContainerGap())))
        );
        Body_PanelLayout.setVerticalGroup(
            Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Body_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Body_PanelLayout.createSequentialGroup()
                        .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Body_PanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(6, 6, 6)
                                .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)
                                .addGap(6, 6, 6)
                                .addComponent(codigoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7)
                                .addGap(2, 2, 2)
                                .addComponent(optativasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeCuatrimestre_Button)
                            .addComponent(addCuatrimestre_Button)))
                    .addGroup(Body_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Opcional_Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Obligatoria_Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Subir_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed

    private void addCuatrimestre_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCuatrimestre_ButtonActionPerformed
        DefaultTableModel listModel = (DefaultTableModel) cuatrimestresTable.getModel();
        
        Cuatrimestre c = ControllerCarrera.crearCuatrimestre(nroCuatrimestre);
        listModel.addRow(new Object[]{c, c.getMateriasOptativas(), c.getMateriasObligatorias()});
        
        nroCuatrimestre++;
    }//GEN-LAST:event_addCuatrimestre_ButtonActionPerformed

    private void codigoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoTextFieldActionPerformed

    private void removeCuatrimestre_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCuatrimestre_ButtonActionPerformed
        DefaultTableModel listModel = (DefaultTableModel) cuatrimestresTable.getModel();
        if(listModel.getRowCount() != 0){
            int fila = listModel.getRowCount()-1;
            
            List<Materia> materiasOptativas = (List<Materia>) listModel.getValueAt(fila, 1);
            List<Materia> materiasObligatorias = (List<Materia>) listModel.getValueAt(fila, 2);
            
            DefaultListModel listModelMaterias = (DefaultListModel) materiasList.getModel();
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

    private void cuatrimestresTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cuatrimestresTablePropertyChange
    }//GEN-LAST:event_cuatrimestresTablePropertyChange

    private void Obligatoria_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Obligatoria_ButtonActionPerformed
        asignarMateria(true); // es obligatoria
    }//GEN-LAST:event_Obligatoria_ButtonActionPerformed

    private void Subir_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Subir_ButtonActionPerformed
        try{
            if(!nombreTextField.getText().isEmpty() || !codigoTextField.getText().isEmpty() || !(planesDeEstudioList.getSelectedIndex() == -1)){
                // Construyo el transferible
                TransferibleCarrera transferibleCarrera = new TransferibleCarrera();

                transferibleCarrera.setNombre(nombreTextField.getText());
                transferibleCarrera.setCodigoCarrera(codigoTextField.getText());
                transferibleCarrera.setCantMateriasOptativasParaAprobar(Integer.parseInt(optativasTextField.getText()));
                transferibleCarrera.setCuatrimestres(obtenerCuatrimestresCreados());
                transferibleCarrera.setPlanDeEstudio(planesDeEstudioList.getSelectedValue());
                if(isEdicion){
                    transferibleCarrera.setId(carreraId);
                    ControllerCarrera.actualizarCarrera(transferibleCarrera);
                }
                else{
                    ControllerCarrera.crearCarrera(transferibleCarrera);
                    javax.swing.JOptionPane.showMessageDialog(this, "La carrera fue creada con éxito. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            ViewMain.ShowJPanel(new CarrerasPanel());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_Subir_ButtonActionPerformed

    private void optativasTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optativasTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optativasTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_Panel;
    private javax.swing.JPanel Body_Panel;
    private javax.swing.JButton Obligatoria_Button;
    private javax.swing.JButton Opcional_Button;
    private javax.swing.JSeparator Separador_Separator;
    private javax.swing.JButton Subir_Button;
    private javax.swing.JPanel Title_Panel;
    private javax.swing.JLabel Titulo_Label;
    private javax.swing.JButton addCuatrimestre_Button;
    private javax.swing.JTextField codigoTextField;
    private javax.swing.JTable cuatrimestresTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<com.milton.gomez.sistema.universitario.Model.Materia> materiasList;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JTextField optativasTextField;
    private javax.swing.JList<com.milton.gomez.sistema.universitario.Model.PlanDeEstudio> planesDeEstudioList;
    private javax.swing.JButton removeCuatrimestre_Button;
    // End of variables declaration//GEN-END:variables

}
