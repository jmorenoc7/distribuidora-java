
package formularios;

import datos.DatosLogin;
import dialog.Mensaje;
import dialog.Servidor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.Conexion;
import logica.fUsuarios;


public class frmLogin extends javax.swing.JFrame {
    
    DatosLogin dlogin = new DatosLogin();
    Conexion con;
    fUsuarios func;
    Mensaje b;
    
    public frmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        DatosLogin.setServidor("localhost:3306");
        DatosLogin.setDb("distribuidoraweb");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtPass = new javax.swing.JPasswordField();
        BtnAceptar = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        BtnConfig = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(5, 56, 166));
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(67, 124, 244));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(5, 56, 166))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Logo_246x150.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 256, 150));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel2.setText("Usuario: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        TxtUsuario.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        TxtUsuario.setText("rzurita");
        TxtUsuario.setMaximumSize(new java.awt.Dimension(6, 37));
        jPanel1.add(TxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 284, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setText("Contraseña: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        TxtPass.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        TxtPass.setText("moreno1450");
        TxtPass.setMaximumSize(new java.awt.Dimension(6, 37));
        jPanel1.add(TxtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 231, -1));

        BtnAceptar.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        BtnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Check_48x48.png"))); // NOI18N
        BtnAceptar.setText("Aceptar");
        BtnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 180, 50));

        BtnSalir.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        BtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Exit_48x48.png"))); // NOI18N
        BtnSalir.setText("Salir");
        BtnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 180, 50));

        BtnConfig.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        BtnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Configuraciones_64x64.png"))); // NOI18N
        BtnConfig.setBorder(null);
        BtnConfig.setContentAreaFilled(false);
        BtnConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnConfig.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnConfig.setIconTextGap(-3);
        BtnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfigActionPerformed(evt);
            }
        });
        jPanel1.add(BtnConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfigActionPerformed
       Servidor servidor = new Servidor(this, rootPaneCheckingEnabled);
       servidor.setVisible(true);
    }//GEN-LAST:event_BtnConfigActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarActionPerformed
        con = new Conexion();
        con.setServidor(DatosLogin.getServidor());
        con.setDb(DatosLogin.getDb());
        
        
        if (con.conectar() == 1) {
            func = new fUsuarios(con);
           if(func.login(TxtUsuario.getText(), TxtPass.getText())){
               b = new Mensaje(this, true,"Bienvenido!!",DatosLogin.getNombre());
               
               pantallaPrincipal p = new pantallaPrincipal(con);
               p.setExtendedState(JFrame.MAXIMIZED_BOTH);
               p.setVisible(true);
               this.setVisible(false);
               
               /*principal p;
                try {
                    p = new principal();
                    p.setVisible(true);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex);
                }*/
               
               this.setVisible(false);
           }else{
               b = new Mensaje(this, true,"Error!!","Usuario o Contrasenia Incorrecta");
           }
        }else{
            b = new Mensaje(this, true,"Error!!","Falla en la conexion con el Servidor");
        }
    }//GEN-LAST:event_BtnAceptarActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JButton BtnConfig;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JPasswordField TxtPass;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
