package com.milton.gomez.sistema.universitario.View.Panels.Alumno;

import com.milton.gomez.sistema.universitario.Controller.ControllerAlumno;
import com.milton.gomez.sistema.universitario.Transferible.TransferibleAlumno;
import com.milton.gomez.sistema.universitario.View.ViewMain;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author milton
 */
public class AlumnosPanel extends javax.swing.JPanel {

    /**
     * Creates new form AlumnoPanel
     */
    public AlumnosPanel() {
        initComponents();
        cargarAlumnos();
        alinearTablaAlumnos();
    }
    
    private void cargarAlumnos(){
        TransferibleAlumno alumno = new TransferibleAlumno();
        Alumnos_Table.setModel(ControllerAlumno.listarTodosLosAlumnos(this.Alumnos_Table));
    }
    private void alinearTablaAlumnos(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        Alumnos_Table.setDefaultRenderer(Object.class, centerRenderer);
        Alumnos_Table.setDefaultRenderer(Integer.class, centerRenderer);
        Alumnos_Table.setDefaultRenderer(Long.class, centerRenderer);
    }
    private void buscarAlumno(){
        try{
            if(Alumno_TextField.getText().length() == 8){
            Alumnos_Table.setModel(ControllerAlumno.obtenerAlumnoPorDNI(Alumnos_Table, Alumno_TextField));
            }
            else if (Alumno_TextField.getText().length() == 6){
                Alumnos_Table.setModel(ControllerAlumno.obtenerAlumnoPorLegajo(Alumnos_Table, Alumno_TextField));
            }
            else if(Alumno_TextField.getText().equals("Inserte el DNI o Legajo del Alumno...")){
                javax.swing.JOptionPane.showMessageDialog(this, "Debe escribir un Legajo o un DNI. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                javax.swing.JOptionPane.showMessageDialog(this, "Inserte un Legajo (6 digitos) o un DNI (8 digitos). \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(NumberFormatException e){
            javax.swing.JOptionPane.showMessageDialog(this, "Introduzca solo valores númericos. \n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch(NullPointerException e){
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró el alumno. \n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
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

        jMenu1 = new javax.swing.JMenu();
        Background_Panel = new javax.swing.JPanel();
        Header_Panel = new javax.swing.JPanel();
        Titulo_Label = new javax.swing.JLabel();
        Separador_Separator = new javax.swing.JSeparator();
        Body_Panel = new javax.swing.JPanel();
        AlumnoBusqueda_Panel = new javax.swing.JPanel();
        Alumno_TextField = new javax.swing.JTextField();
        Buscar_Button = new javax.swing.JButton();
        ListAlumnos_Panel = new javax.swing.JPanel();
        Alumnos_ScrollPane = new javax.swing.JScrollPane();
        Alumnos_Table = new javax.swing.JTable();
        AlumnoEditDelete_Panel = new javax.swing.JPanel();
        Eliminar_Button = new javax.swing.JButton();
        Editar_Button = new javax.swing.JButton();
        Nuevo_Button = new javax.swing.JButton();
        Detalles_Button = new javax.swing.JButton();
        Refresh_Button = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setPreferredSize(new java.awt.Dimension(780, 580));

        Background_Panel.setPreferredSize(new java.awt.Dimension(780, 580));

        Titulo_Label.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        Titulo_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/people_icon.png"))); // NOI18N
        Titulo_Label.setText("Gestion de Alumnos");

        javax.swing.GroupLayout Header_PanelLayout = new javax.swing.GroupLayout(Header_Panel);
        Header_Panel.setLayout(Header_PanelLayout);
        Header_PanelLayout.setHorizontalGroup(
            Header_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Header_PanelLayout.createSequentialGroup()
                .addGroup(Header_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Header_PanelLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(Separador_Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Header_PanelLayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(Titulo_Label)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Header_PanelLayout.setVerticalGroup(
            Header_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Header_PanelLayout.createSequentialGroup()
                .addComponent(Titulo_Label)
                .addGap(1, 1, 1)
                .addComponent(Separador_Separator, javax.swing.GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE)
                .addContainerGap())
        );

        Alumno_TextField.setText("Inserte el DNI o Legajo del Alumno...");
        Alumno_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Alumno_TextFieldFocusLost(evt);
            }
        });
        Alumno_TextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Alumno_TextFieldMousePressed(evt);
            }
        });
        Alumno_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alumno_TextFieldActionPerformed(evt);
            }
        });

        Buscar_Button.setBackground(new java.awt.Color(204, 0, 0));
        Buscar_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Buscar_Button.setForeground(new java.awt.Color(255, 255, 255));
        Buscar_Button.setText("Buscar");
        Buscar_Button.setBorder(null);
        Buscar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AlumnoBusqueda_PanelLayout = new javax.swing.GroupLayout(AlumnoBusqueda_Panel);
        AlumnoBusqueda_Panel.setLayout(AlumnoBusqueda_PanelLayout);
        AlumnoBusqueda_PanelLayout.setHorizontalGroup(
            AlumnoBusqueda_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AlumnoBusqueda_PanelLayout.createSequentialGroup()
                .addComponent(Alumno_TextField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buscar_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        AlumnoBusqueda_PanelLayout.setVerticalGroup(
            AlumnoBusqueda_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AlumnoBusqueda_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AlumnoBusqueda_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Alumno_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(Buscar_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Alumnos_ScrollPane.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        Alumnos_Table.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Alumnos_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Legajo", "DNI", "Nombre", "Apellido", "Carrera"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Alumnos_Table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Alumnos_Table.setShowGrid(false);
        Alumnos_ScrollPane.setViewportView(Alumnos_Table);
        if (Alumnos_Table.getColumnModel().getColumnCount() > 0) {
            Alumnos_Table.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        javax.swing.GroupLayout ListAlumnos_PanelLayout = new javax.swing.GroupLayout(ListAlumnos_Panel);
        ListAlumnos_Panel.setLayout(ListAlumnos_PanelLayout);
        ListAlumnos_PanelLayout.setHorizontalGroup(
            ListAlumnos_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Alumnos_ScrollPane)
        );
        ListAlumnos_PanelLayout.setVerticalGroup(
            ListAlumnos_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Alumnos_ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Eliminar_Button.setBackground(new java.awt.Color(204, 0, 0));
        Eliminar_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Eliminar_Button.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar_Button.setText("Eliminar");
        Eliminar_Button.setBorder(null);
        Eliminar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_ButtonActionPerformed(evt);
            }
        });

        Editar_Button.setBackground(new java.awt.Color(204, 0, 0));
        Editar_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Editar_Button.setForeground(new java.awt.Color(255, 255, 255));
        Editar_Button.setText("Editar");
        Editar_Button.setBorder(null);
        Editar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_ButtonActionPerformed(evt);
            }
        });

        Nuevo_Button.setBackground(new java.awt.Color(204, 0, 0));
        Nuevo_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Nuevo_Button.setForeground(new java.awt.Color(255, 255, 255));
        Nuevo_Button.setText("Nuevo");
        Nuevo_Button.setBorder(null);
        Nuevo_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nuevo_ButtonActionPerformed(evt);
            }
        });

        Detalles_Button.setBackground(new java.awt.Color(204, 0, 0));
        Detalles_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Detalles_Button.setForeground(new java.awt.Color(255, 255, 255));
        Detalles_Button.setText("Detalles");
        Detalles_Button.setBorder(null);
        Detalles_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Detalles_ButtonActionPerformed(evt);
            }
        });

        Refresh_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh_icon.png"))); // NOI18N
        Refresh_Button.setBorderPainted(false);
        Refresh_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Refresh_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AlumnoEditDelete_PanelLayout = new javax.swing.GroupLayout(AlumnoEditDelete_Panel);
        AlumnoEditDelete_Panel.setLayout(AlumnoEditDelete_PanelLayout);
        AlumnoEditDelete_PanelLayout.setHorizontalGroup(
            AlumnoEditDelete_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AlumnoEditDelete_PanelLayout.createSequentialGroup()
                .addComponent(Refresh_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(Nuevo_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Detalles_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Editar_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Eliminar_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        AlumnoEditDelete_PanelLayout.setVerticalGroup(
            AlumnoEditDelete_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AlumnoEditDelete_PanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(AlumnoEditDelete_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Eliminar_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Editar_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nuevo_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Detalles_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AlumnoEditDelete_PanelLayout.createSequentialGroup()
                .addComponent(Refresh_Button)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Body_PanelLayout = new javax.swing.GroupLayout(Body_Panel);
        Body_Panel.setLayout(Body_PanelLayout);
        Body_PanelLayout.setHorizontalGroup(
            Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AlumnoBusqueda_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ListAlumnos_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AlumnoEditDelete_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Body_PanelLayout.setVerticalGroup(
            Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Body_PanelLayout.createSequentialGroup()
                .addComponent(AlumnoBusqueda_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ListAlumnos_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AlumnoEditDelete_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout Background_PanelLayout = new javax.swing.GroupLayout(Background_Panel);
        Background_Panel.setLayout(Background_PanelLayout);
        Background_PanelLayout.setHorizontalGroup(
            Background_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Background_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Header_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Body_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Background_PanelLayout.setVerticalGroup(
            Background_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background_PanelLayout.createSequentialGroup()
                .addComponent(Header_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Body_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Alumno_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alumno_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Alumno_TextFieldActionPerformed

    private void Nuevo_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nuevo_ButtonActionPerformed
        ViewMain.ShowJPanel(new SubirAlumnoPanel());
    }//GEN-LAST:event_Nuevo_ButtonActionPerformed

    private void Alumno_TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Alumno_TextFieldFocusLost
        if(Alumno_TextField.getText().isEmpty()){
            Alumno_TextField.setForeground(Color.gray);
            Alumno_TextField.setText("Inserte el DNI o Legajo del Alumno...");
        }
    }//GEN-LAST:event_Alumno_TextFieldFocusLost

    private void Refresh_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh_ButtonActionPerformed
        cargarAlumnos();
        Alumno_TextField.setText("Inserte el DNI o Legajo del Alumno...");
    }//GEN-LAST:event_Refresh_ButtonActionPerformed

    private void Alumno_TextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Alumno_TextFieldMousePressed
        if(Alumno_TextField.getText().equals("Inserte el DNI o Legajo del Alumno...")){
            Alumno_TextField.setText("");
            Alumno_TextField.setForeground(Color.black);
        }
    }//GEN-LAST:event_Alumno_TextFieldMousePressed

    private void Buscar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_ButtonActionPerformed
        buscarAlumno();
    }//GEN-LAST:event_Buscar_ButtonActionPerformed

    private void Eliminar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_ButtonActionPerformed
        
        if(Alumnos_Table.getSelectedColumnCount() != 0){
            DefaultTableModel model = (DefaultTableModel)Alumnos_Table.getModel();
            try{
                // filas seleccionadas
                int[] filasSeleccionadas = Alumnos_Table.getSelectedRows();

                // Recorre las filas seleccionadas en orden inverso
                for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
                    int fila = filasSeleccionadas[i];
                    // Elimina el alumno usando el índice correspondiente
                    ControllerAlumno.eliminarAlumno((Integer) Alumnos_Table.getValueAt(fila, 0));
                    // Elimina la fila del modelo
                    model.removeRow(fila);
}
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un Alumno primero. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_Eliminar_ButtonActionPerformed

    private void Detalles_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Detalles_ButtonActionPerformed
        if(Alumnos_Table.getSelectedRow() != -1){
            ViewMain.ShowJPanel(new DetallesAlumno((Integer) Alumnos_Table.getValueAt(Alumnos_Table.getSelectedRow(),0)));
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un Alumno primero. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_Detalles_ButtonActionPerformed

    private void Editar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_ButtonActionPerformed
        if(Alumnos_Table.getSelectedRow() != -1){
            ViewMain.ShowJPanel(new SubirAlumnoPanel((Integer) Alumnos_Table.getValueAt(Alumnos_Table.getSelectedRow(),0)));
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un Alumno primero. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);            
        }
    }//GEN-LAST:event_Editar_ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AlumnoBusqueda_Panel;
    private javax.swing.JPanel AlumnoEditDelete_Panel;
    private javax.swing.JTextField Alumno_TextField;
    private javax.swing.JScrollPane Alumnos_ScrollPane;
    private javax.swing.JTable Alumnos_Table;
    private javax.swing.JPanel Background_Panel;
    private javax.swing.JPanel Body_Panel;
    private javax.swing.JButton Buscar_Button;
    private javax.swing.JButton Detalles_Button;
    private javax.swing.JButton Editar_Button;
    private javax.swing.JButton Eliminar_Button;
    private javax.swing.JPanel Header_Panel;
    private javax.swing.JPanel ListAlumnos_Panel;
    private javax.swing.JButton Nuevo_Button;
    private javax.swing.JButton Refresh_Button;
    private javax.swing.JSeparator Separador_Separator;
    private javax.swing.JLabel Titulo_Label;
    private javax.swing.JMenu jMenu1;
    // End of variables declaration//GEN-END:variables
}
