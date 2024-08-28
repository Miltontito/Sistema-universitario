package VIew;
import VIew.Panels.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*; 
/**
 *
 * @author Milton Gómez
 */
public class MainJFrame extends JFrame {
    int xMouse, yMouse;
    
    public MainJFrame() {
        initComponents();
        initContent();
        SetImageLabel(UNTDF_iconLabel, "src/static/UNTDFLogoTransparente.png");
    }
    
    private void SetImageLabel(JLabel labelName, String ruta_imagen){
        ImageIcon image = new ImageIcon(ruta_imagen);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH));
        labelName.setIcon(icon);
        this.repaint();
    }
    
    private void initContent(){
        ShowJPanel(new PrincipalPanel());
    }
    
    private void ShowJPanel(JPanel p){
        p.setSize(638, 528);
        p.setLocation(0,0);
        
        ContentPanel.removeAll();
        ContentPanel.add(p, BorderLayout.CENTER);
        ContentPanel.revalidate();
        ContentPanel.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        MenuPanel = new javax.swing.JPanel();
        Menu_HeaderPanel = new javax.swing.JPanel();
        UNTDF_iconLabel = new javax.swing.JLabel();
        Menu_ButtonsPanel = new javax.swing.JPanel();
        Alumnos_Button = new javax.swing.JButton();
        Carreras_Button = new javax.swing.JButton();
        Materias_Button = new javax.swing.JButton();
        PlanesDeEstudio_Button = new javax.swing.JButton();
        Ayuda_Button = new javax.swing.JButton();
        HeaderPanel = new javax.swing.JPanel();
        ExitPanel = new javax.swing.JPanel();
        ExitText = new javax.swing.JLabel();
        Title_Label = new javax.swing.JLabel();
        ContentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        BackgroundPanel.setPreferredSize(new java.awt.Dimension(900, 600));
        BackgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuPanel.setBackground(new java.awt.Color(153, 0, 0));
        MenuPanel.setPreferredSize(new java.awt.Dimension(4, 502));

        Menu_HeaderPanel.setBackground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout Menu_HeaderPanelLayout = new javax.swing.GroupLayout(Menu_HeaderPanel);
        Menu_HeaderPanel.setLayout(Menu_HeaderPanelLayout);
        Menu_HeaderPanelLayout.setHorizontalGroup(
            Menu_HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu_HeaderPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UNTDF_iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Menu_HeaderPanelLayout.setVerticalGroup(
            Menu_HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu_HeaderPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(UNTDF_iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Alumnos_Button.setBackground(new java.awt.Color(204, 0, 0));
        Alumnos_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Alumnos_Button.setForeground(new java.awt.Color(255, 255, 255));
        Alumnos_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/people_icon.png"))); // NOI18N
        Alumnos_Button.setText("Alumnos");
        Alumnos_Button.setBorder(null);
        Alumnos_Button.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Alumnos_Button.setPreferredSize(new java.awt.Dimension(128, 64));
        Alumnos_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Alumnos_ButtonMousePressed(evt);
            }
        });
        Alumnos_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alumnos_ButtonActionPerformed(evt);
            }
        });

        Carreras_Button.setBackground(new java.awt.Color(204, 0, 0));
        Carreras_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Carreras_Button.setForeground(new java.awt.Color(255, 255, 255));
        Carreras_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/carrera_icon.png"))); // NOI18N
        Carreras_Button.setText("Carrera");
        Carreras_Button.setBorder(null);
        Carreras_Button.setBorderPainted(false);
        Carreras_Button.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Carreras_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carreras_ButtonActionPerformed(evt);
            }
        });

        Materias_Button.setBackground(new java.awt.Color(204, 0, 0));
        Materias_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Materias_Button.setForeground(new java.awt.Color(255, 255, 255));
        Materias_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/materia_icon.png"))); // NOI18N
        Materias_Button.setText("Materias");
        Materias_Button.setBorder(null);
        Materias_Button.setBorderPainted(false);
        Materias_Button.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Materias_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Materias_ButtonActionPerformed(evt);
            }
        });

        PlanesDeEstudio_Button.setBackground(new java.awt.Color(204, 0, 0));
        PlanesDeEstudio_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        PlanesDeEstudio_Button.setForeground(new java.awt.Color(255, 255, 255));
        PlanesDeEstudio_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/rule_settings_icon.png"))); // NOI18N
        PlanesDeEstudio_Button.setText("Planes de Estudio");
        PlanesDeEstudio_Button.setBorder(null);
        PlanesDeEstudio_Button.setBorderPainted(false);
        PlanesDeEstudio_Button.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PlanesDeEstudio_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlanesDeEstudio_ButtonActionPerformed(evt);
            }
        });

        Ayuda_Button.setBackground(new java.awt.Color(204, 0, 0));
        Ayuda_Button.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Ayuda_Button.setForeground(new java.awt.Color(255, 255, 255));
        Ayuda_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/help_icon.png"))); // NOI18N
        Ayuda_Button.setText("Ayuda");
        Ayuda_Button.setBorder(null);
        Ayuda_Button.setBorderPainted(false);
        Ayuda_Button.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Ayuda_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ayuda_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Menu_ButtonsPanelLayout = new javax.swing.GroupLayout(Menu_ButtonsPanel);
        Menu_ButtonsPanel.setLayout(Menu_ButtonsPanelLayout);
        Menu_ButtonsPanelLayout.setHorizontalGroup(
            Menu_ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Alumnos_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Materias_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Carreras_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Ayuda_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PlanesDeEstudio_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Menu_ButtonsPanelLayout.setVerticalGroup(
            Menu_ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu_ButtonsPanelLayout.createSequentialGroup()
                .addComponent(Alumnos_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Menu_ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Menu_ButtonsPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(Materias_Button))
                    .addComponent(Carreras_Button)
                    .addGroup(Menu_ButtonsPanelLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(Ayuda_Button))
                    .addGroup(Menu_ButtonsPanelLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(PlanesDeEstudio_Button))))
        );

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu_HeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                .addComponent(Menu_ButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addComponent(Menu_HeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Menu_ButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        BackgroundPanel.add(MenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 600));

        HeaderPanel.setBackground(new java.awt.Color(204, 0, 0));
        HeaderPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        HeaderPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeaderPanelMouseDragged(evt);
            }
        });
        HeaderPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeaderPanelMousePressed(evt);
            }
        });

        ExitPanel.setBackground(new java.awt.Color(204, 0, 0));

        ExitText.setBackground(new java.awt.Color(255, 255, 255));
        ExitText.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        ExitText.setForeground(new java.awt.Color(255, 255, 255));
        ExitText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExitText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/close_icon.png"))); // NOI18N
        ExitText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExitText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitTextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitTextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitTextMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ExitPanelLayout = new javax.swing.GroupLayout(ExitPanel);
        ExitPanel.setLayout(ExitPanelLayout);
        ExitPanelLayout.setHorizontalGroup(
            ExitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ExitText, javax.swing.GroupLayout.PREFERRED_SIZE, 61, Short.MAX_VALUE)
        );
        ExitPanelLayout.setVerticalGroup(
            ExitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ExitText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Title_Label.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        Title_Label.setForeground(new java.awt.Color(255, 255, 255));
        Title_Label.setText("Sistema Universitario");

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderPanelLayout.createSequentialGroup()
                .addContainerGap(406, Short.MAX_VALUE)
                .addComponent(Title_Label)
                .addGap(133, 133, 133)
                .addComponent(ExitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addComponent(ExitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        BackgroundPanel.add(HeaderPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 64));

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ContentPanelLayout = new javax.swing.GroupLayout(ContentPanel);
        ContentPanel.setLayout(ContentPanelLayout);
        ContentPanelLayout.setHorizontalGroup(
            ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );
        ContentPanelLayout.setVerticalGroup(
            ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        BackgroundPanel.add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 66, 638, 528));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HeaderPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderPanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HeaderPanelMousePressed

    private void HeaderPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderPanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x- xMouse, y - yMouse);
    }//GEN-LAST:event_HeaderPanelMouseDragged

    private void ExitTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitTextMouseExited
        ExitPanel.setBackground(new Color(204, 0, 0));
    }//GEN-LAST:event_ExitTextMouseExited

    //efecto Hover como css
    private void ExitTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitTextMouseEntered
        ExitPanel.setBackground(Color.red);
    }//GEN-LAST:event_ExitTextMouseEntered

    private void ExitTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitTextMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitTextMouseClicked

    private void PlanesDeEstudio_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlanesDeEstudio_ButtonActionPerformed
        ShowJPanel(new PlanesDeEstudioPanel());
    }//GEN-LAST:event_PlanesDeEstudio_ButtonActionPerformed

    private void Ayuda_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ayuda_ButtonActionPerformed
        ShowJPanel(new AyudaPanel());
    }//GEN-LAST:event_Ayuda_ButtonActionPerformed

    private void Alumnos_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alumnos_ButtonActionPerformed
        ShowJPanel(new AlumnosPanel());
    }//GEN-LAST:event_Alumnos_ButtonActionPerformed

    private void Alumnos_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Alumnos_ButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Alumnos_ButtonMousePressed

    private void Carreras_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Carreras_ButtonActionPerformed
        ShowJPanel(new CarrerasPanel());
    }//GEN-LAST:event_Carreras_ButtonActionPerformed

    private void Materias_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Materias_ButtonActionPerformed
        ShowJPanel(new MateriasPanel());
    }//GEN-LAST:event_Materias_ButtonActionPerformed
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alumnos_Button;
    private javax.swing.JButton Ayuda_Button;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JButton Carreras_Button;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel ExitPanel;
    private javax.swing.JLabel ExitText;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JButton Materias_Button;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JPanel Menu_ButtonsPanel;
    private javax.swing.JPanel Menu_HeaderPanel;
    private javax.swing.JButton PlanesDeEstudio_Button;
    private javax.swing.JLabel Title_Label;
    private javax.swing.JLabel UNTDF_iconLabel;
    // End of variables declaration//GEN-END:variables
}
