
package formularios;

import datos.Clientes;
import static formularios.pantallaPrincipal.JdpEscritorio;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Conexion;
import logica.fClientes;


public class frmListaClientes extends javax.swing.JInternalFrame {
    Conexion con;
    fClientes func;
    Clientes datos = new Clientes();
    
    public frmListaClientes() {
        initComponents();
        this.con = con;
        func = new fClientes(con);
        mostrar("", filtroRadioButton());
    }
    
    void mostrar(String buscar, String filtro){
        DefaultTableModel tabla;
        String filtro2 = cbEstado.getSelectedItem().toString();
        tabla = func.mostrarClientes(buscar, filtro, filtro2);
        
        tblLista.setModel(tabla);
    }
    
    String filtroRadioButton(){
        if (rbCliente.isSelected()) {
            return "apellido";
        }else{
            if (rbCiudad.isSelected()) {
                return "ciudad1";
            }else{
                if (rbTipo.isSelected()) {
                    return "tipoUsuario";
                }
            }
        }
        return "apellido";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        rbCliente = new javax.swing.JRadioButton();
        rbTipo = new javax.swing.JRadioButton();
        rbCiudad = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        cbEstado = new javax.swing.JComboBox<>();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Lista de Clientes");
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Lista de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Buscar:");

        TxtBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyReleased(evt);
            }
        });

        buttonGroup1.add(rbCliente);
        rbCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbCliente.setSelected(true);
        rbCliente.setText("Cliente");

        buttonGroup1.add(rbTipo);
        rbTipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbTipo.setText("Tipo");

        buttonGroup1.add(rbCiudad);
        rbCiudad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbCiudad.setText("Ciudad");

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

        cbEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEstadoItemStateChanged(evt);
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
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(rbCliente)
                        .addGap(18, 18, 18)
                        .addComponent(rbTipo)
                        .addGap(18, 18, 18)
                        .addComponent(rbCiudad)
                        .addGap(38, 38, 38)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 538, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbCliente)
                        .addComponent(rbTipo)
                        .addComponent(rbCiudad)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        mostrar(TxtBuscar.getText(), filtroRadioButton());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void tblListaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMousePressed
        if (evt.getClickCount()==1) {
            int fila = tblLista.getSelectedRow();
            String [] opciones = {"Eliminar","Modificar"};
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if (seleccion == 0) {
                datos.setIdcliente(Integer.parseInt(tblLista.getValueAt(fila, 0).toString()));
                
                if (func.eliminar(datos)) {
                    JOptionPane.showMessageDialog(null, "Se pudo eliminar el cliente correctamente");
                    mostrar("", filtroRadioButton());
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar, intente nuevamente mas tarde");
                }
            }else{
                if (seleccion == 1) {
                    frmClientes cliente = new frmClientes(con,tblLista.getValueAt(fila, 0).toString());
                    JdpEscritorio.add(cliente);
                    cliente.show();
                }
            }
        }
    }//GEN-LAST:event_tblListaMousePressed

    private void cbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstadoItemStateChanged
        mostrar("", filtroRadioButton());
    }//GEN-LAST:event_cbEstadoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rbCiudad;
    private javax.swing.JRadioButton rbCliente;
    private javax.swing.JRadioButton rbTipo;
    private javax.swing.JTable tblLista;
    // End of variables declaration//GEN-END:variables
}
