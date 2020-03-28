
package formularios;

import datos.Modificaciones;
import datos.Proveedores;
import static formularios.pantallaPrincipal.JdpEscritorio;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Conexion;
import logica.fProveedores;
import logica.funciones;


public class frmListaModificaciones extends javax.swing.JInternalFrame {

    Conexion con;
    funciones func;
    Modificaciones datos = new Modificaciones();
    
    public frmListaModificaciones(Conexion con) {
        initComponents();
        this.con = con;
        func = new funciones(con);
        mostrar("", filtroRadioButton());
    }
    
     void mostrar(String buscar, String filtro){
        DefaultTableModel tabla;
        tabla = func.mostrarProductos(buscar, filtro);
        
        TblLista.setModel(tabla);
    }
    
     String filtroRadioButton(){
        if (RbUsuarios.isSelected()) {
            return "usuario";
        }else{
            if (RbTabla.isSelected()) {
                return "tabla";
            }
        }
        return "usuario";
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        RbUsuarios = new javax.swing.JRadioButton();
        RbTabla = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblLista = new javax.swing.JTable();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Lista Modificaciones");
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Lista de Modificaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Buscar:");

        TxtBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyReleased(evt);
            }
        });

        buttonGroup1.add(RbUsuarios);
        RbUsuarios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RbUsuarios.setText("Usuario");

        buttonGroup1.add(RbTabla);
        RbTabla.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RbTabla.setText("Tabla");

        TblLista.setModel(new javax.swing.table.DefaultTableModel(
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
        TblLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblListaMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(TblLista);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RbUsuarios)
                .addGap(18, 18, 18)
                .addComponent(RbTabla)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RbUsuarios)
                    .addComponent(RbTabla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addGap(14, 14, 14))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        mostrar(TxtBuscar.getText(),filtroRadioButton());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void TblListaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblListaMousePressed
        if (evt.getClickCount()==1) {
            int fila = TblLista.getSelectedRow();
            int seleccion = JOptionPane.showConfirmDialog(null, "Desea Modificar al Proveedor?");
            if (seleccion == 0) {
                frmProveedores prov = new frmProveedores(con, TblLista.getValueAt(fila, 0).toString());
                JdpEscritorio.add(prov);
                prov.show();
            }
        }
    }//GEN-LAST:event_TblListaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RbTabla;
    private javax.swing.JRadioButton RbUsuarios;
    private javax.swing.JTable TblLista;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
