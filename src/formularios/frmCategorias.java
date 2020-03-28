
package formularios;

import datos.Categorias;
import datos.DatosLogin;
import datos.Modificaciones;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Conexion;
import logica.fCategorias;
import logica.funciones;


public class frmCategorias extends javax.swing.JInternalFrame {

    Conexion con;
    fCategorias func;
    Categorias datos = new Categorias();
    funciones f;
    Modificaciones datosF = new Modificaciones();
    
    public frmCategorias(Conexion con) {
        initComponents();
        this.con = con;
        func = new fCategorias(con);
        f = new funciones(con);
        mostrar("");
        deshabilitar();
    }

    void mostrar(String buscar){
        DefaultTableModel tabla;
        tabla = func.mostrarCategorias(buscar);
        tblLista.setModel(tabla);
    }
    
    void habilitar(){
        TxtNombre.setEnabled(true);
        TxtDescripcion.setEnabled(true);
        CboEstado.setEnabled(true);
        
        BtnGuardar.setEnabled(true);
        BtnCancelar.setEnabled(true);
        
        BtnNuevo.setEnabled(false);
    }
    
    void deshabilitar(){
        TxtNombre.setEnabled(false);
        TxtDescripcion.setEnabled(false);
        CboEstado.setEnabled(false);
        
        TxtNombre.setText("");
        TxtDescripcion.setText("");
        
        BtnGuardar.setEnabled(false);
        BtnCancelar.setEnabled(false);
        
        BtnNuevo.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        TxtIdCat = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CboEstado = new javax.swing.JComboBox<>();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Categorias");
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Categorias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Buscar:");

        TxtBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyReleased(evt);
            }
        });

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblListaMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblLista);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Nombre: ");

        TxtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TxtDescripcion.setColumns(20);
        TxtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtDescripcion.setRows(5);
        jScrollPane2.setViewportView(TxtDescripcion);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Descripcion:  ");

        TxtIdCat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtIdCat.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Estado:");

        CboEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        BtnNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Nuevo_48x48.png"))); // NOI18N
        BtnNuevo.setText("Nuevo");
        BtnNuevo.setBorder(null);
        BtnNuevo.setContentAreaFilled(false);
        BtnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnNuevo.setIconTextGap(3);
        BtnNuevo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        BtnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Modificar_48x48.png"))); // NOI18N
        BtnGuardar.setText("Guardar");
        BtnGuardar.setBorder(null);
        BtnGuardar.setContentAreaFilled(false);
        BtnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnGuardar.setIconTextGap(3);
        BtnGuardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Cancelar_48x48.png"))); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.setBorder(null);
        BtnCancelar.setContentAreaFilled(false);
        BtnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnCancelar.setIconTextGap(3);
        BtnCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(TxtIdCat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtIdCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel14)
                                .addGap(42, 42, 42)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BtnNuevo)
                                    .addComponent(BtnGuardar)
                                    .addComponent(BtnCancelar))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        mostrar(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        habilitar();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        deshabilitar();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        
        if ((TxtNombre.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Ingrese un Nombre");
            return;
        }
        if ((TxtDescripcion.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Ingrese una Descripcion");
            return;
        }

        datos.setNombre_cat(TxtNombre.getText());
        datos.setDescripcion_cat(TxtDescripcion.getText());
        datos.setEstado(CboEstado.getSelectedItem().toString());
        if (BtnGuardar.getText().equals("Guardar")) {
            if (func.insertar(datos)) {
                JOptionPane.showMessageDialog(null, "Se inserto correctamente");
                mostrar("");
                deshabilitar();
            } else {
                JOptionPane.showMessageDialog(null, "Error no se pudo insertar");
            }
        }
        if (BtnGuardar.getText().equals("Modificar")) {
            datos.setIdcategoria(Integer.parseInt(TxtIdCat.getText()));
            if (func.modificar(datos)) {
                datosF.setIdregTabla(Integer.parseInt(TxtIdCat.getText()));
                datosF.setTabla("categorias");
                datosF.setUsuario(DatosLogin.getUsuario());
                if (!f.insertar(datosF)) {
                    JOptionPane.showMessageDialog(null, "No se pudo cargar en tabla de modificaciones");
                }
                JOptionPane.showMessageDialog(null, "Se modifico correctamente");
                mostrar("");
                deshabilitar();
            } else {
                JOptionPane.showMessageDialog(null, "Error no se pudo insertar");
            }
        }
        
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void tblListaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMousePressed
        if (evt.getClickCount() == 1) {
            int fila = tblLista.getSelectedRow();
            
            TxtIdCat.setText(tblLista.getValueAt(fila,0).toString());
            TxtNombre.setText(tblLista.getValueAt(fila,1).toString());
            if (!(tblLista.getValueAt(fila,2).toString() == null)) {
                TxtDescripcion.setText(tblLista.getValueAt(fila,2).toString());
            }
            
            CboEstado.setSelectedItem(tblLista.getValueAt(fila,3).toString());
            
            BtnGuardar.setText("Modificar");
            habilitar();
        }
    }//GEN-LAST:event_tblListaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> CboEstado;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextArea TxtDescripcion;
    private javax.swing.JTextField TxtIdCat;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblLista;
    // End of variables declaration//GEN-END:variables
}
