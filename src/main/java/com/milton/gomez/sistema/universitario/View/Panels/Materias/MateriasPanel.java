package com.milton.gomez.sistema.universitario.View.Panels.Materias;

import com.milton.gomez.sistema.universitario.View.Panels.Alumno.SubirAlumnoPanel;
import com.milton.gomez.sistema.universitario.Controller.ControllerAlumno;
import com.milton.gomez.sistema.universitario.Controller.ControllerMateria;
import com.milton.gomez.sistema.universitario.Model.Alumno;
import com.milton.gomez.sistema.universitario.Model.Materia;
import com.milton.gomez.sistema.universitario.View.ViewMain;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author milton
 */
public class MateriasPanel extends javax.swing.JPanel {

    /**
     * Creates new form AlumnoPanel
     */
    public MateriasPanel() {
        initComponents();
        cargarMaterias();
        alinearTablaMaterias();
    }
    
    private void cargarMaterias(){
        
        // "ID", "Codigo", "Nombre", "esPromocionable?", "Correlativas"
        DefaultTableModel model = (DefaultTableModel)materiasTable.getModel();
        
        model.setRowCount(0);
        
        ControllerMateria.listarTodasLasMaterias()
                .forEach((m) -> model
                        .addRow(new Object[]{
                            m.getMateriaID(),
                            m.getCodigoDeMateria(), 
                            m.getNombre(), 
                            m.isPromocionable(), 
                            m.getCorrelativas()
                        }));
    }
    
    private void alinearTablaMaterias(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        materiasTable.setDefaultRenderer(Object.class, centerRenderer);
        materiasTable.setDefaultRenderer(Integer.class, centerRenderer);
        materiasTable.setDefaultRenderer(Long.class, centerRenderer);
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
        tituloLabel = new javax.swing.JLabel();
        Separador_Separator = new javax.swing.JSeparator();
        Body_Panel = new javax.swing.JPanel();
        materiasBusquedaPanel = new javax.swing.JPanel();
        materiaTextField = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        listaMateriasPanel = new javax.swing.JPanel();
        materiasScrollPane = new javax.swing.JScrollPane();
        materiasTable = new javax.swing.JTable();
        materiaEditDeletePanel = new javax.swing.JPanel();
        eliminarButton = new javax.swing.JButton();
        editarButon = new javax.swing.JButton();
        nuevoButton = new javax.swing.JButton();
        detallesButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        tituloLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        tituloLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/materia_icon.png"))); // NOI18N
        tituloLabel.setText("Gestion de Materias");

        javax.swing.GroupLayout Header_PanelLayout = new javax.swing.GroupLayout(Header_Panel);
        Header_Panel.setLayout(Header_PanelLayout);
        Header_PanelLayout.setHorizontalGroup(
            Header_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Header_PanelLayout.createSequentialGroup()
                .addGroup(Header_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Header_PanelLayout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(tituloLabel))
                    .addGroup(Header_PanelLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(Separador_Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Header_PanelLayout.setVerticalGroup(
            Header_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Header_PanelLayout.createSequentialGroup()
                .addComponent(tituloLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Separador_Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        materiaTextField.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        materiaTextField.setText("Inserte el Id de la materia...");
        materiaTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                materiaTextFieldFocusLost(evt);
            }
        });
        materiaTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                materiaTextFieldMousePressed(evt);
            }
        });
        materiaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materiaTextFieldActionPerformed(evt);
            }
        });

        buscarButton.setBackground(new java.awt.Color(204, 0, 0));
        buscarButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        buscarButton.setForeground(new java.awt.Color(255, 255, 255));
        buscarButton.setText("Buscar");
        buscarButton.setBorder(null);
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout materiasBusquedaPanelLayout = new javax.swing.GroupLayout(materiasBusquedaPanel);
        materiasBusquedaPanel.setLayout(materiasBusquedaPanelLayout);
        materiasBusquedaPanelLayout.setHorizontalGroup(
            materiasBusquedaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(materiasBusquedaPanelLayout.createSequentialGroup()
                .addComponent(materiaTextField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        materiasBusquedaPanelLayout.setVerticalGroup(
            materiasBusquedaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(materiasBusquedaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(materiasBusquedaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(materiaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(buscarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        materiasScrollPane.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        materiasTable.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        materiasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo", "Nombre", "Promocionable", "Correlativas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        materiasTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        materiasTable.setShowGrid(false);
        materiasScrollPane.setViewportView(materiasTable);
        if (materiasTable.getColumnModel().getColumnCount() > 0) {
            materiasTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        javax.swing.GroupLayout listaMateriasPanelLayout = new javax.swing.GroupLayout(listaMateriasPanel);
        listaMateriasPanel.setLayout(listaMateriasPanelLayout);
        listaMateriasPanelLayout.setHorizontalGroup(
            listaMateriasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materiasScrollPane)
        );
        listaMateriasPanelLayout.setVerticalGroup(
            listaMateriasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materiasScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        eliminarButton.setBackground(new java.awt.Color(204, 0, 0));
        eliminarButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        eliminarButton.setForeground(new java.awt.Color(255, 255, 255));
        eliminarButton.setText("Eliminar");
        eliminarButton.setBorder(null);
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        editarButon.setBackground(new java.awt.Color(204, 0, 0));
        editarButon.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        editarButon.setForeground(new java.awt.Color(255, 255, 255));
        editarButon.setText("Editar");
        editarButon.setBorder(null);
        editarButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButonActionPerformed(evt);
            }
        });

        nuevoButton.setBackground(new java.awt.Color(204, 0, 0));
        nuevoButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        nuevoButton.setForeground(new java.awt.Color(255, 255, 255));
        nuevoButton.setText("Nuevo");
        nuevoButton.setBorder(null);
        nuevoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoButtonActionPerformed(evt);
            }
        });

        detallesButton.setBackground(new java.awt.Color(204, 0, 0));
        detallesButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        detallesButton.setForeground(new java.awt.Color(255, 255, 255));
        detallesButton.setText("Detalles");
        detallesButton.setBorder(null);
        detallesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detallesButtonActionPerformed(evt);
            }
        });

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh_icon.png"))); // NOI18N
        refreshButton.setBorderPainted(false);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout materiaEditDeletePanelLayout = new javax.swing.GroupLayout(materiaEditDeletePanel);
        materiaEditDeletePanel.setLayout(materiaEditDeletePanelLayout);
        materiaEditDeletePanelLayout.setHorizontalGroup(
            materiaEditDeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, materiaEditDeletePanelLayout.createSequentialGroup()
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(nuevoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detallesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editarButon, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        materiaEditDeletePanelLayout.setVerticalGroup(
            materiaEditDeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(materiaEditDeletePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(materiaEditDeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editarButon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detallesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(materiaEditDeletePanelLayout.createSequentialGroup()
                .addComponent(refreshButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Body_PanelLayout = new javax.swing.GroupLayout(Body_Panel);
        Body_Panel.setLayout(Body_PanelLayout);
        Body_PanelLayout.setHorizontalGroup(
            Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materiasBusquedaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listaMateriasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(materiaEditDeletePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Body_PanelLayout.setVerticalGroup(
            Body_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Body_PanelLayout.createSequentialGroup()
                .addComponent(materiasBusquedaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaMateriasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(materiaEditDeletePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout Background_PanelLayout = new javax.swing.GroupLayout(Background_Panel);
        Background_Panel.setLayout(Background_PanelLayout);
        Background_PanelLayout.setHorizontalGroup(
            Background_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Background_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Body_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Background_PanelLayout.setVerticalGroup(
            Background_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background_PanelLayout.createSequentialGroup()
                .addComponent(Header_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Body_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Background_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void materiaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materiaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materiaTextFieldActionPerformed

    private void nuevoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoButtonActionPerformed
        ViewMain.ShowJPanel(new SubirMateriaPanel());
    }//GEN-LAST:event_nuevoButtonActionPerformed

    private void materiaTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_materiaTextFieldFocusLost
        if(materiaTextField.getText().isEmpty()){
            materiaTextField.setForeground(Color.gray);
            materiaTextField.setText("Inserte el Id de la materia...");
        }
    }//GEN-LAST:event_materiaTextFieldFocusLost

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        cargarMaterias();
        materiaTextField.setText("Inserte el Id de la materia...");
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void materiaTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materiaTextFieldMousePressed
        if(materiaTextField.getText().equals("Inserte el Id de la materia...")){
            materiaTextField.setText("");
            materiaTextField.setForeground(Color.black);
        }
    }//GEN-LAST:event_materiaTextFieldMousePressed

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        if(!materiaTextField.getText().equals("Inserte el Id de la materia...")){
            try{
                Integer idMateria = Integer.parseInt(materiaTextField.getText());
                DefaultTableModel model = (DefaultTableModel) materiasTable.getModel();
                model.setRowCount(0);
                Materia m = ControllerMateria.obtenerMateria(idMateria);
                model.addRow(new Object[]{
                    m.getMateriaID(),
                    m.getCodigoDeMateria(),
                    m.getNombre(),
                    m.isPromocionable(),
                    m.getCorrelativas()
                });
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar el Id de la Materia primero. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void detallesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detallesButtonActionPerformed
        if(materiasTable.getSelectedRow() != -1){
            ViewMain.ShowJPanel(new DetallesMateriaPanel((Integer) materiasTable.getValueAt(materiasTable.getSelectedRow(),0)));
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar una Materia primero. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_detallesButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        if(materiasTable.getSelectedColumnCount() != 0){
            DefaultTableModel model = (DefaultTableModel)materiasTable.getModel();
            try{
                // filas seleccionadas
                int[] filasSeleccionadas = materiasTable.getSelectedRows();

                // Recorre las filas seleccionadas en orden inverso
                for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
                    int fila = filasSeleccionadas[i];
                    // Elimina el alumno usando el índice correspondiente
                    ControllerMateria.eliminarMateria((Integer) materiasTable.getValueAt(fila, 0));
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
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar una Materia primero. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void editarButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButonActionPerformed
        if(materiasTable.getSelectedRow() != -1){
            ViewMain.ShowJPanel(new SubirMateriaPanel((Integer) materiasTable.getValueAt(materiasTable.getSelectedRow(),0)));
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar una Materia primero. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_editarButonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_Panel;
    private javax.swing.JPanel Body_Panel;
    private javax.swing.JPanel Header_Panel;
    private javax.swing.JSeparator Separador_Separator;
    private javax.swing.JButton buscarButton;
    private javax.swing.JButton detallesButton;
    private javax.swing.JButton editarButon;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel listaMateriasPanel;
    private javax.swing.JPanel materiaEditDeletePanel;
    private javax.swing.JTextField materiaTextField;
    private javax.swing.JPanel materiasBusquedaPanel;
    private javax.swing.JScrollPane materiasScrollPane;
    private javax.swing.JTable materiasTable;
    private javax.swing.JButton nuevoButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
}
