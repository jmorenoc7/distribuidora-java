
package formularios;

import datos.Productos;
import static formularios.pantallaPrincipal.JdpEscritorio;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logica.Conexion;
import logica.fProductos;


public class frmListaProductos extends javax.swing.JInternalFrame {

    Conexion con;
    fProductos func;
    Productos datos = new Productos();
    
    public frmListaProductos(Conexion con) {
        initComponents();
        this.con = con;
        func = new fProductos(con);
        mostrar("",filtroRadioButton());
    }
    
    void mostrar(String buscar, String filtro){
     DefaultTableModel tabla;
     tabla = func.mostrarProductos(buscar, filtro);
     tblLista.setModel(tabla);
     ordenTabla();
    }
    
    void ordenTabla(){
        
         DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
         tcr.setHorizontalAlignment(SwingConstants.CENTER);
         
         tblLista.getColumnModel().getColumn(0).setMaxWidth(50);
         tblLista.getColumnModel().getColumn(0).setMinWidth(50);
         tblLista.getColumnModel().getColumn(0).setPreferredWidth(50);
         
         tblLista.getColumnModel().getColumn(1).setMaxWidth(70);
         tblLista.getColumnModel().getColumn(1).setMinWidth(70);
         tblLista.getColumnModel().getColumn(1).setPreferredWidth(70);
         
         tblLista.getColumnModel().getColumn(2).setMaxWidth(100);
         tblLista.getColumnModel().getColumn(2).setMinWidth(100);
         tblLista.getColumnModel().getColumn(2).setPreferredWidth(100);
         
         tblLista.getColumnModel().getColumn(5).setMaxWidth(50);
         tblLista.getColumnModel().getColumn(5).setMinWidth(50);
         tblLista.getColumnModel().getColumn(5).setPreferredWidth(50);
         
         tblLista.getColumnModel().getColumn(6).setMaxWidth(70);
         tblLista.getColumnModel().getColumn(6).setMinWidth(70);
         tblLista.getColumnModel().getColumn(6).setPreferredWidth(70);
         
         tblLista.getColumnModel().getColumn(7).setMaxWidth(70);
         tblLista.getColumnModel().getColumn(7).setMinWidth(70);
         tblLista.getColumnModel().getColumn(7).setPreferredWidth(70);
         
         tblLista.getColumnModel().getColumn(8).setMaxWidth(70);
         tblLista.getColumnModel().getColumn(8).setMinWidth(70);
         tblLista.getColumnModel().getColumn(8).setPreferredWidth(70);
         
         tblLista.getColumnModel().getColumn(9).setMaxWidth(60);
         tblLista.getColumnModel().getColumn(9).setMinWidth(60);
         tblLista.getColumnModel().getColumn(9).setPreferredWidth(60);
         
         tblLista.getColumnModel().getColumn(10).setMaxWidth(60);
         tblLista.getColumnModel().getColumn(10).setMinWidth(60);
         tblLista.getColumnModel().getColumn(10).setPreferredWidth(60);
         
         tblLista.getColumnModel().getColumn(11).setMaxWidth(60);
         tblLista.getColumnModel().getColumn(11).setMinWidth(60);
         tblLista.getColumnModel().getColumn(11).setPreferredWidth(60);
         
         tblLista.getColumnModel().getColumn(12).setMaxWidth(70);
         tblLista.getColumnModel().getColumn(12).setMinWidth(70);
         tblLista.getColumnModel().getColumn(12).setPreferredWidth(70);
         
         tblLista.getColumnModel().getColumn(13).setMaxWidth(70);
         tblLista.getColumnModel().getColumn(13).setMinWidth(70);
         tblLista.getColumnModel().getColumn(13).setPreferredWidth(70);
         
         tblLista.getColumnModel().getColumn(14).setMaxWidth(70);
         tblLista.getColumnModel().getColumn(14).setMinWidth(70);
         tblLista.getColumnModel().getColumn(14).setPreferredWidth(70);
         
         tblLista.getColumnModel().getColumn(15).setMaxWidth(50);
         tblLista.getColumnModel().getColumn(15).setMinWidth(50);
         tblLista.getColumnModel().getColumn(15).setPreferredWidth(50);
         
         tblLista.getColumnModel().getColumn(16).setMaxWidth(60);
         tblLista.getColumnModel().getColumn(16).setMinWidth(60);
         tblLista.getColumnModel().getColumn(16).setPreferredWidth(60);
         
         tblLista.getColumnModel().getColumn(0).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(1).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(2).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(3).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(4).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(5).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(6).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(7).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(8).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(9).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(10).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(11).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(12).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(13).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(14).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(15).setCellRenderer(tcr);
         tblLista.getColumnModel().getColumn(16).setCellRenderer(tcr);
    }
    
    String filtroRadioButton(){
        if (rbCategoria.isSelected()) {
            return "nombre_cat";
        }
        if (rbNombre.isSelected()) {
            return "nombre";
        }
        if (rbCodBarra.isSelected()) {
            return "codBarra";
        }
        return "nombre";
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        rbNombre = new javax.swing.JRadioButton();
        rbCategoria = new javax.swing.JRadioButton();
        rbCodBarra = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Lista de Productos");
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Lista de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Buscar:");

        TxtBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyReleased(evt);
            }
        });

        buttonGroup1.add(rbNombre);
        rbNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbNombre.setSelected(true);
        rbNombre.setText("Nombre");

        buttonGroup1.add(rbCategoria);
        rbCategoria.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbCategoria.setText("Categoria");

        buttonGroup1.add(rbCodBarra);
        rbCodBarra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbCodBarra.setText("CodBarra");

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
                        .addComponent(rbNombre)
                        .addGap(18, 18, 18)
                        .addComponent(rbCategoria)
                        .addGap(18, 18, 18)
                        .addComponent(rbCodBarra)
                        .addGap(0, 699, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbNombre)
                        .addComponent(rbCategoria)
                        .addComponent(rbCodBarra))
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
                datos.setIdproducto(Integer.parseInt(tblLista.getValueAt(fila, 0).toString()));
                
                if (func.eliminar(datos)) {
                    JOptionPane.showMessageDialog(null, "Se pudo eliminar el Producto correctamente");
                    mostrar("", filtroRadioButton());
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar, intente nuevamente mas tarde");
                }
            }else{
                if (seleccion == 1) {
                    frmProductos prod = new frmProductos(con,tblLista.getValueAt(fila, 0).toString());
                    JdpEscritorio.add(prod);
                    prod.show();
                }
            }
        }
    }//GEN-LAST:event_tblListaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rbCategoria;
    private javax.swing.JRadioButton rbCodBarra;
    private javax.swing.JRadioButton rbNombre;
    private javax.swing.JTable tblLista;
    // End of variables declaration//GEN-END:variables
}
