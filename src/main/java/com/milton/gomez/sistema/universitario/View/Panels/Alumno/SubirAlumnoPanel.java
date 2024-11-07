/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.milton.gomez.sistema.universitario.View.Panels.Alumno;

import com.milton.gomez.sistema.universitario.Controller.ControllerAlumno;
import com.milton.gomez.sistema.universitario.Controller.ControllerCarrera;
import com.milton.gomez.sistema.universitario.Model.Carrera;
import com.milton.gomez.sistema.universitario.Model.Cursada;
import com.milton.gomez.sistema.universitario.Model.Materia;
import com.milton.gomez.sistema.universitario.Transferible.TransferibleAlumno;
import com.milton.gomez.sistema.universitario.View.ViewMain;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author milton
 */
public class SubirAlumnoPanel extends javax.swing.JPanel {

    /**
     * Creates new form NuevoAlumnoPanel
     */
    
    private Boolean isEdicion = Boolean.FALSE;
    private Integer alumnoId = null;
    
    public SubirAlumnoPanel() {
        initComponents();
        listarCarreras();
        alinearTablaMaterias();
    }
    
    //Si recibe un ID se trata de una edición.
    public SubirAlumnoPanel(Integer id) {
        this();
        alumnoId = id;
        isEdicion = Boolean.TRUE;
        editableView(id);
    }
    
    //Genera la nueva vista de la edición del alumno
    private void editableView(Integer id){
        TransferibleAlumno alumno = ControllerAlumno.obtenerDatosDeAlumno(id);
        
        Title_Label.setText("Editar Alumno");
        Legajo_TextField.setText(alumno.getLegajo().toString());
        DNI_TextField.setText(alumno.getDni().toString());
        Nombre_TextField.setText(alumno.getNombre());
        Apellido_TextField.setText(alumno.getApellido());
        Carreras_List.setSelectedValue(alumno.getCarrera(), true);
        seleccionarMateriasAlumno(alumno);
    }
    
    //Se muestran las materias seleccionadas del alumno.
    private void seleccionarMateriasAlumno(TransferibleAlumno alumno){
        
        List<Cursada> cursadasSeleccionadas = alumno.getCursadas(); // se obtienen las cursadas del alumno

        DefaultTableModel tableModel = (DefaultTableModel) Materias_Table.getModel();
        ListSelectionModel selectionModel = Materias_Table.getSelectionModel();

        // Limpia la selección previa
        selectionModel.clearSelection();

        // Recorre las filas de la tabla
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            // Obtenemos la materia
            Materia materiaTabla = (Materia) tableModel.getValueAt(row, 0);

            // Verifica si alguna cursada contiene la materia mostrada en la fila de la tabla
            for (Cursada cursada : cursadasSeleccionadas) {
                if (cursada.getMateria().equals(materiaTabla) & !cursada.getMateriaAprobada()) {
                    // Selecciona la fila si coincide
                    selectionModel.addSelectionInterval(row, row);
                    break;
                }
            }
        }
        Materias_Table.setSelectionModel(selectionModel);

    }
    
    private void listarCarreras(){
        // Obtener el modelo de la JList
        DefaultListModel<Carrera> listModel = (DefaultListModel<Carrera>) Carreras_List.getModel();

        // Limpiar el modelo actual para evitar duplicados
        listModel.clear();

        // Agregar cada carrera al modelo de la JList
        ControllerCarrera.listarTodasLasCarreras().forEach((c) -> listModel.addElement(c));
    }
    
    private void listarMaterias(){
        // Obtenemos el modelo de la JTable materias
        DefaultTableModel tableModel = (DefaultTableModel) Materias_Table.getModel();
        
        tableModel.setRowCount(0);
        
        ControllerCarrera.listarTodosLosCuatrimestres(Carreras_List.getSelectedValue().getCarreraID())
            .forEach(cuatrimestre -> {
                cuatrimestre.listarTodasLasMaterias().forEach(materia -> {
                    // Solo agregamos la materia si la lista de correlativas está vacía
                    if (materia.getCorrelativas().isEmpty()) {
                        tableModel.addRow(new Object[]{materia});
                    }
                });
            });
    }
    
    
    // carga las materias en la edicion del alumno
    private void listarMaterias(Integer alumnoID){
        // Obtenemos el modelo de la JList materias
        DefaultTableModel tableModel = (DefaultTableModel) Materias_Table.getModel();
        
        tableModel.setRowCount(0);
        
        ControllerCarrera.listarTodosLosCuatrimestres(Carreras_List.getSelectedValue().getCarreraID())
                .forEach(c -> c.listarTodasLasMaterias().forEach(m -> {
                    if(ControllerAlumno.listarMateriasQuePuedeCursar(alumnoID).contains(m) || ControllerAlumno.listarMateriasQueCursa(alumnoID).contains(m)){
                        tableModel.addRow(new Object[]{m});
            }
        }));
    }
    
    private void alinearTablaMaterias(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.LEFT );
        Materias_Table.setDefaultRenderer(Object.class, centerRenderer);
        Materias_Table.setDefaultRenderer(Integer.class, centerRenderer);
    }
    
    private List<Cursada> obtenerMateriasSeleccionadas(){
        List<Cursada> cursadas = new ArrayList<>();
        int[] filasSeleccionadas = Materias_Table.getSelectedRows();
        for (int i = 0; i < filasSeleccionadas.length; i++) {
            int fila = filasSeleccionadas[i];
            cursadas.add(new Cursada((Materia) Materias_Table.getValueAt(fila, 0)));
        }
        return cursadas;
    }
    
    //private void

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background_panel = new javax.swing.JPanel();
        Title_Label = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Legajo_TextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DNI_TextField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        Nombre_TextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Apellido_TextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Carrera_ScrollPane = new javax.swing.JScrollPane();
        Carreras_List = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        Materia_ScrollPane = new javax.swing.JScrollPane();
        Materias_Table = new javax.swing.JTable();
        Aceptar_Button = new javax.swing.JButton();

        Title_Label.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        Title_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/person_icon.png"))); // NOI18N
        Title_Label.setText("Crear nuevo Alumno");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Legajo (6 numeros) *");

        Legajo_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Legajo_TextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Legajo_TextFieldFocusLost(evt);
            }
        });
        Legajo_TextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Legajo_TextFieldMousePressed(evt);
            }
        });
        Legajo_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Legajo_TextFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("DNI (8 numeros) *");

        DNI_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DNI_TextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DNI_TextFieldFocusLost(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("Nombre *");

        Nombre_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Nombre_TextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Nombre_TextFieldFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setText("Apellido *");

        Apellido_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Apellido_TextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Apellido_TextFieldFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setText("Seleccione la Carrera (Max. 1) *");

        Carreras_List.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Carreras_List.setModel(new DefaultListModel<>());
        Carreras_List.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Carreras_List.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                Carreras_ListValueChanged(evt);
            }
        });
        Carrera_ScrollPane.setViewportView(Carreras_List);

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setText("Seleccione las Materias *");

        Materia_ScrollPane.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Materia_ScrollPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Materia_ScrollPaneFocusGained(evt);
            }
        });

        Materias_Table.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        Materias_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Materias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Materias_Table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Materias_TableFocusGained(evt);
            }
        });
        Materia_ScrollPane.setViewportView(Materias_Table);

        Aceptar_Button.setBackground(new java.awt.Color(204, 0, 0));
        Aceptar_Button.setForeground(new java.awt.Color(255, 255, 255));
        Aceptar_Button.setText("Aceptar");
        Aceptar_Button.setBorderPainted(false);
        Aceptar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Background_panelLayout = new javax.swing.GroupLayout(Background_panel);
        Background_panel.setLayout(Background_panelLayout);
        Background_panelLayout.setHorizontalGroup(
            Background_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background_panelLayout.createSequentialGroup()
                .addGroup(Background_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Background_panelLayout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(Title_Label))
                    .addGroup(Background_panelLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Background_panelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(Background_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(Legajo_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(DNI_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(Nombre_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Apellido_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(48, 48, 48)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(Background_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Background_panelLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(Background_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(Carrera_ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(Materia_ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Background_panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Aceptar_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)))))
                .addGap(23, 23, 23))
        );
        Background_panelLayout.setVerticalGroup(
            Background_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background_panelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Title_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(Background_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Background_panelLayout.createSequentialGroup()
                        .addGroup(Background_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Background_panelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(8, 8, 8)
                                .addComponent(Legajo_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3)
                                .addGap(8, 8, 8)
                                .addComponent(DNI_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel4)
                                .addGap(8, 8, 8)
                                .addComponent(Nombre_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Apellido_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Background_panelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)
                        .addComponent(Carrera_ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Materia_ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(Aceptar_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Carreras_ListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_Carreras_ListValueChanged
        
        if(isEdicion){
            listarMaterias(this.alumnoId);
        }
        else{
            listarMaterias();
        }
        
    }//GEN-LAST:event_Carreras_ListValueChanged

    private void Legajo_TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Legajo_TextFieldFocusLost
       
    }//GEN-LAST:event_Legajo_TextFieldFocusLost

    private void Legajo_TextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Legajo_TextFieldMousePressed
    
    }//GEN-LAST:event_Legajo_TextFieldMousePressed

    private void DNI_TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DNI_TextFieldFocusLost
        
    }//GEN-LAST:event_DNI_TextFieldFocusLost

    private void DNI_TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DNI_TextFieldFocusGained
      
    }//GEN-LAST:event_DNI_TextFieldFocusGained

    private void Legajo_TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Legajo_TextFieldFocusGained
       
    }//GEN-LAST:event_Legajo_TextFieldFocusGained

    private void Nombre_TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Nombre_TextFieldFocusGained
        
    }//GEN-LAST:event_Nombre_TextFieldFocusGained

    private void Nombre_TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Nombre_TextFieldFocusLost
       
    }//GEN-LAST:event_Nombre_TextFieldFocusLost

    private void Apellido_TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Apellido_TextFieldFocusGained
    }//GEN-LAST:event_Apellido_TextFieldFocusGained

    private void Apellido_TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Apellido_TextFieldFocusLost
    }//GEN-LAST:event_Apellido_TextFieldFocusLost

    private void Aceptar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar_ButtonActionPerformed
        try{
            if(!Legajo_TextField.getText().isEmpty() || !DNI_TextField.getText().isEmpty() || 
                    !Nombre_TextField.getText().isEmpty() || !Apellido_TextField.getText().isEmpty() || 
                    !(Carreras_List.getSelectedIndex() == -1) || !(Materias_Table.getSelectedRowCount() == 0)){
                
                if(isEdicion){
                    TransferibleAlumno alumno = new TransferibleAlumno();
                    alumno.setId(alumnoId);
                    alumno.setLegajo(Long.valueOf(Legajo_TextField.getText()));
                    alumno.setDni(Long.valueOf(DNI_TextField.getText()));
                    alumno.setNombre(Nombre_TextField.getText());
                    alumno.setApellido(Apellido_TextField.getText());
                    alumno.setCarrera(Carreras_List.getSelectedValue());
                    alumno.setCursadas(obtenerMateriasSeleccionadas());
                    ControllerAlumno.actualizarAlumno(alumno);
                }
                else{
                    ControllerAlumno.crearAlumno(this ,Legajo_TextField, DNI_TextField, Nombre_TextField, 
                        Apellido_TextField, Carreras_List, Materias_Table);
                }
                

                ViewMain.ShowJPanel(new AlumnosPanel());
            }
            else{
                javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                Legajo_TextField.requestFocus();
            }
        }
        catch(NumberFormatException e){
            e.getMessage();
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "El Legajo y el DNI deben ser numeros. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            e.getMessage();
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un problema al crear/actualizar al Alumno. \n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Aceptar_ButtonActionPerformed

    private void Legajo_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Legajo_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Legajo_TextFieldActionPerformed

    private void Materia_ScrollPaneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Materia_ScrollPaneFocusGained
        
    }//GEN-LAST:event_Materia_ScrollPaneFocusGained

    private void Materias_TableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Materias_TableFocusGained

    }//GEN-LAST:event_Materias_TableFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar_Button;
    private javax.swing.JTextField Apellido_TextField;
    private javax.swing.JPanel Background_panel;
    private javax.swing.JScrollPane Carrera_ScrollPane;
    private javax.swing.JList<com.milton.gomez.sistema.universitario.Model.Carrera> Carreras_List;
    private javax.swing.JTextField DNI_TextField;
    private javax.swing.JTextField Legajo_TextField;
    private javax.swing.JScrollPane Materia_ScrollPane;
    private javax.swing.JTable Materias_Table;
    private javax.swing.JTextField Nombre_TextField;
    private javax.swing.JLabel Title_Label;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
