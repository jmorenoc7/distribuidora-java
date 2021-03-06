
package formularios;

import datos.Pedidos;
import static formularios.pantallaPrincipal.JdpEscritorio;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logica.Conexion;
import logica.fPedido;
import logica.imprimir;


public class frmListaPedidos extends javax.swing.JInternalFrame {

    Conexion con;
    fPedido func;
    Pedidos datos = new Pedidos();
    imprimir i;
    public frmListaPedidos(Conexion con) {
        initComponents();
        this.con=con;
        func = new fPedido(con);
        i = new imprimir(con);
        mostrar("",filtroRadioButton());
    }

    void mostrar(String buscar, String filtro){
        DefaultTableModel tabla;
        tabla = func.mostrarPedidos(buscar, filtro);
        tblLista.setModel(tabla);
        ordenTabla();
    }
    
    void ordenTabla(){
        
        
         DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
         tcr.setHorizontalAlignment(SwingConstants.CENTER);
         
         tblLista.getColumnModel().getColumn(0).setMaxWidth(50);
         tblLista.getColumnModel().getColumn(0).setMinWidth(50);
         tblLista.getColumnModel().getColumn(0).setPreferredWidth(50);

         tblLista.getColumnModel().getColumn(1).setMaxWidth(0);
         tblLista.getColumnModel().getColumn(1).setMinWidth(0);
         tblLista.getColumnModel().getColumn(1).setPreferredWidth(0);
         
         tblLista.getColumnModel().getColumn(3).setMaxWidth(0);
         tblLista.getColumnModel().getColumn(3).setMinWidth(0);
         tblLista.getColumnModel().getColumn(3).setPreferredWidth(0);
         
         tblLista.getColumnModel().getColumn(4).setMaxWidth(60);
         tblLista.getColumnModel().getColumn(4).setMinWidth(60);
         tblLista.getColumnModel().getColumn(4).setPreferredWidth(60);
         
         tblLista.getColumnModel().getColumn(7).setMaxWidth(70);
         tblLista.getColumnModel().getColumn(7).setMinWidth(70);
         tblLista.getColumnModel().getColumn(7).setPreferredWidth(70);
         
         tblLista.getColumnModel().getColumn(8).setMaxWidth(50);
         tblLista.getColumnModel().getColumn(8).setMinWidth(50);
         tblLista.getColumnModel().getColumn(8).setPreferredWidth(50);
         
         tblLista.getColumnModel().getColumn(9).setMaxWidth(70);
         tblLista.getColumnModel().getColumn(9).setMinWidth(70);
         tblLista.getColumnModel().getColumn(9).setPreferredWidth(70);
         
         tblLista.getColumnModel().getColumn(0).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(2).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(4).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(5).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(6).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(7).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(8).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(9).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(10).setCellRenderer(tcr);
    }
    
    String filtroRadioButton(){
        if (rbCliente.isSelected()) {
            return "apellido";
        }
        if (rbCodPedido.isSelected()) {
            return "codPedido";
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
        rbCodPedido = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Lista de Pedidos");
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Lista de Pedidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

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

        buttonGroup1.add(rbCodPedido);
        rbCodPedido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbCodPedido.setText("CodPedido");

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
                        .addGap(18, 18, 18)
                        .addComponent(rbCliente)
                        .addGap(18, 18, 18)
                        .addComponent(rbCodPedido)
                        .addGap(0, 764, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbCliente)
                    .addComponent(rbCodPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            String [] opciones = {"Modificar", "Imprimir"};
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if (seleccion == 0) {
                datos.setIdpedido(Integer.parseInt(tblLista.getValueAt(fila, 0).toString()));
                frmPedido pedido = new frmPedido(con,tblLista.getValueAt(fila, 0).toString());
                JdpEscritorio.add(pedido);
                pedido.show();
            }
            if (seleccion == 1) {
                i.imprimirReporte(tblLista.getValueAt(fila, 0).toString());
            }
        }
    }//GEN-LAST:event_tblListaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rbCliente;
    private javax.swing.JRadioButton rbCodPedido;
    private javax.swing.JTable tblLista;
    // End of variables declaration//GEN-END:variables
}
