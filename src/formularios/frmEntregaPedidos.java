
package formularios;

import datos.Items;
import datos.Pedidos;
import datos.Saldos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Conexion;
import logica.fSaldos;


public class frmEntregaPedidos extends javax.swing.JInternalFrame {

    Conexion con;
    fSaldos func;
    Items datos = new Items();
    Saldos datoS = new Saldos();
    Pedidos datosP = new Pedidos();
    int cantVieja;
    //String [][] registros = new String[10][10];
    String [] registros = new String[6];
    String [] tituloCambios  = {"Id","Cambio","CantVieja","CantNueva","P Unit","idProd"};
    String [] tituloItems = {"Id","Cantidad","IdProd","Producto","P Unit","Desc","Total"};
      
    DefaultTableModel tabla;
    
    
    public frmEntregaPedidos(Conexion con) {
        initComponents();
        this.con = con;
        func = new fSaldos(con);
        tabla = new DefaultTableModel(null,tituloCambios);
        tblCambios.setModel(tabla);
        tabla = new DefaultTableModel(null,tituloItems);
        tblItems.setModel(tabla);
        txtMonto.setEnabled(false);
    }

    void buscarCliente(String buscar){
        String registros[];
        
        
        registros = func.buscarIdPedido(buscar);
        
        if (registros !=null) {
            txtMonto.setText(registros[9]);
            lblPedidoMonto.setText(registros[9]);
            lblCliente.setText(registros[2]);
            lblDireccion.setText(registros[3]);
            cboEstado.setSelectedItem(registros[10]);
            lblIdCliente.setText(registros[1]);
            lblIdPedido.setText(registros[0]);
            
            tabla = func.mostrarItems(buscar);
            
            tblItems.setModel(tabla);
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro el Pedido");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdPedido = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCambios = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        lblIdCliente = new javax.swing.JLabel();
        lblIdPedido = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblPedidoMonto = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cambio de Estado de Pedidos");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Pedido:");

        txtIdPedido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtIdPedido.setToolTipText("Id del Pedido");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Cliente:");

        lblCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCliente.setText("Cliente");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Estado: ");

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDireccion.setText("Direccion");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Direccion:");

        cboEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Preparando", "Entregado-Pagado", "Entregado-Saldo", "No recibido-Suspendido" }));
        cboEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboEstadoItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Pago: ");

        txtMonto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("$");

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
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
        tblItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblItemsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblItems);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblCambios.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCambios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCambiosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblCambios);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Lista de Cambios:");

        lblIdCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIdCliente.setText("id");

        lblIdPedido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Pedido:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("$");

        lblPedidoMonto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnBuscar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel8)
                                    .addGap(6, 6, 6)
                                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblPedidoMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnGuardar)
                        .addGap(54, 54, 54)
                        .addComponent(btnCancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblCliente)
                            .addComponent(lblIdCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDireccion)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                            .addComponent(lblPedidoMonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar))
                        .addGap(32, 32, 32)
                        .addComponent(lblIdPedido))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    void cargarCambios() {
        //Verificamos si la tabla contiene cambios
        if (tblCambios.getRowCount() > 0) {
            //Recorremos cada cambio
            for (int i = 0; i < tblCambios.getRowCount(); i++) {

                //Si es para eliminar----------------------------
                if (tblCambios.getValueAt(i, 1).equals("Eliminar")) {

                    datos.setIditempedido(Integer.parseInt(tblCambios.getValueAt(i, 0).toString()));
                    datos.setIdproducto(Integer.parseInt(tblCambios.getValueAt(i, 5).toString()));
                    datos.setCantidad(Integer.parseInt(tblCambios.getValueAt(i, 2).toString()));

                    JOptionPane.showMessageDialog(null, tblCambios.getValueAt(i, 2).toString());

                    if (func.sumarStock(datos)) {

                        if (!func.eliminarItem(datos)) {
                            JOptionPane.showMessageDialog(null, "No se pudo eliminar items del pedido");
                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "Hubo un problema al actualizar stock (Eliminar)");

                    }

                }

                //Si es para modificar---------------------------
                if (tblCambios.getValueAt(i, 1).equals("Modificar")) {
                    datos.setIditempedido(Integer.parseInt(tblCambios.getValueAt(i, 0).toString()));
                    datos.setPrecioUni(Double.parseDouble(tblCambios.getValueAt(i, 4).toString()));
                    datos.setCantidad(Integer.parseInt(tblCambios.getValueAt(i, 3).toString()));
                    datos.setIdproducto(Integer.parseInt(tblCambios.getValueAt(i, 5).toString()));

                    int cantNueva = Integer.parseInt(tblCambios.getValueAt(i, 3).toString());
                    Double pUni = Double.parseDouble(tblCambios.getValueAt(i, 4).toString());
                    Double total = cantNueva * pUni;
                    total = Math.round(total * 100) / 100d;

                    datos.setTotal(total);

                    if (func.modificarItems(datos)) {
                        cantVieja = Integer.parseInt(tblCambios.getValueAt(i, 2).toString());
                        if (cantVieja > cantNueva) {
                            cantNueva = cantVieja - cantNueva;
                            datos.setCantidad(cantNueva);
                            //sumamos a stock cantNueva;
                            if (!func.sumarStock(datos)) {
                                JOptionPane.showMessageDialog(null, "Hubo un problema al actualizar el stock");
                            }
                        } else {
                            //Si la cantidad Nueva es mayor que la vieja
                            cantNueva = cantNueva - cantVieja;
                            datos.setCantidad(cantNueva);
                            //restamos a stock cantNueva
                            if (!func.restarStock(datos)) {
                                JOptionPane.showMessageDialog(null, "Hubo un problema al actualizar el stock");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un problema al mofificar el item");
                    }
                }
            }
        }

    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //----------------------------------------------------------------------------------------------------------------
        if (cboEstado.getSelectedItem().equals("Entregado-Pagado")) {
            //No se carga saldo en el pedido, pero se revisa si hay modificaciones
            //en la tabla de cambios se modifica pedido
            cargarCambios();
            //Actualizamos pedido
            datosP.setIdpedido(Integer.parseInt(lblIdPedido.getText()));
            datosP.setNeto(Double.parseDouble(lblPedidoMonto.getText()));
            datosP.setEstado(cboEstado.getSelectedItem().toString());
            //Lamamos a la funcion modificar en la clase fSaldos
            if (!func.modificar(datosP)) {
                JOptionPane.showMessageDialog(null, "Hubo un problema, no se pudo actualizar el pedido");
            }
        }
        //-----------------------------------------------------------------------------------------------------------------
        if (cboEstado.getSelectedItem().equals("Entregado-Saldo")) {
            //Se carga el saldo que se ingrese en la opcion pago y si hay modificaciones
            //en la tabla de cambios se modifica el pedido
            
            Double montoPedido = Double.parseDouble(lblPedidoMonto.getText());
            Double pago = Double.parseDouble(txtIdPedido.getText());
            Double saldo = 0.0;
            
            if (montoPedido < pago) {
            //Caso si ingresa un monto mayor al de la factura
                JOptionPane.showMessageDialog(null, "Verifique el pago ingresado\nNo puedo ser mayor al importe de la factura");
            }else{
            //Si el monto ingresado es menor al de la factura
                if (montoPedido > pago) {
                    saldo = montoPedido - pago;
                    
                    //Cargamos el Saldo
                    //Cargamos datos
                    datoS.setIdPedido(Integer.parseInt(lblIdPedido.getText()));
                    datoS.setIdCliente(Integer.parseInt(lblIdCliente.getText()));
                    datoS.setEstado(cboEstado.getSelectedItem().toString());
                    datoS.setSaldo(saldo);
                    datoS.setNota("");
                    
                    if (func.insertar(datoS)) {
                        JOptionPane.showMessageDialog(null, "Saldo cargado correctamente");
                        cargarCambios();
                        //Actualizamos pedido
                        datosP.setIdpedido(Integer.parseInt(lblIdPedido.getText()));
                        datosP.setNeto(Double.parseDouble(lblPedidoMonto.getText()));
                        datosP.setEstado(cboEstado.getSelectedItem().toString());
                        

                        if (!func.modificar(datosP)) {
                           JOptionPane.showMessageDialog(null, "Hubo un problema, no se pudo actualizar el pedido");
                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "Hubo un problema, no se pudo cargar el saldo");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Verifique los montos ingresados y estado");

                }
            }
            
            
            
            

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarCliente(txtIdPedido.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblItemsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemsMousePressed
        if (evt.getClickCount() == 1) {
            int fila = tblItems.getSelectedRow();
            String [] opciones = {"Eliminar","Modificar"};
            tabla = (DefaultTableModel) tblCambios.getModel();
            
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            
            //Caso en el que se elimina un items
            if (seleccion == 0) {
                try {
                     Double monto = Double.parseDouble(txtMonto.getText());
                     int cant = Integer.parseInt(tblItems.getValueAt(fila, 1).toString());
                     Double pTotal = Double.parseDouble(tblItems.getValueAt(fila, 6).toString());
                     monto = monto - pTotal;
                     monto = Math.round(monto * 100) / 100d;
                     txtMonto.setText(monto.toString());
                     
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error al convertir un numero");
                    return;
                }
                registros[0] = tblItems.getValueAt(fila, 0).toString();
                registros[1] = "Eliminar";
                registros[2] = tblItems.getValueAt(fila, 1).toString();;
                registros[3] = "0";
                registros[4] = "0";
                registros[5] = tblItems.getValueAt(fila, 2).toString();
                JOptionPane.showMessageDialog(null, "Los cambios se realizaran despues de guardar");
                tabla.addRow(registros);
                tblCambios.setModel(tabla);
                
               
            }
            //Caso en el que se modifica un items
            if (seleccion == 1) {
                Double pUnit;
                int cant;
                try {
                     Double monto = Double.parseDouble(txtMonto.getText());
                     cantVieja = Integer.parseInt(tblItems.getValueAt(fila, 1).toString());
                     cant = Integer.parseInt(JOptionPane.showInputDialog(null, 
                        "Ingrese la nueva Cantidad", tblItems.getValueAt(fila, 1).toString()));
                     pUnit = Double.parseDouble(JOptionPane.showInputDialog(null, 
                        "Ingrese el nuevo P Unit", tblItems.getValueAt(fila, 4).toString()));
                     
                     monto = monto - Double.parseDouble(tblItems.getValueAt(fila, 6).toString());
                     monto = monto + (cant*pUnit);
                     monto = Math.round(monto * 100) / 100d;
                     txtMonto.setText(monto.toString());
                     
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error al convertir un numero");
                    return;
                }
                registros[0] = tblItems.getValueAt(fila, 0).toString();
                registros[1] = "Modificar";
                registros[2] = String.valueOf(cantVieja);
                registros[3] = String.valueOf(cant);
                registros[4] = pUnit.toString();
                registros[5] = tblItems.getValueAt(fila, 2).toString();
                /*for (int i = 0; i < 7; i++) {
                    registros[cantMod][i] = tblItems.getValueAt(fila, i).toString();
                }*/
                //cantMod = cantMod + 1;
                //JOptionPane.showMessageDialog(null, registros);
                tabla.addRow(registros);
                tblCambios.setModel(tabla);
                JOptionPane.showMessageDialog(null, "Los cambios se realizaran despues de guardar");
            }
        }
    }//GEN-LAST:event_tblItemsMousePressed

    private void tblCambiosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCambiosMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCambiosMousePressed

    private void cboEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboEstadoItemStateChanged
        if (cboEstado.getSelectedItem().equals("Entregado-Saldo") || cboEstado.getSelectedItem().equals("No recibido-Suspendido") ) {
            txtMonto.setEnabled(true);
        }
    }//GEN-LAST:event_cboEstadoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblIdPedido;
    private javax.swing.JLabel lblPedidoMonto;
    private javax.swing.JTable tblCambios;
    private javax.swing.JTable tblItems;
    private javax.swing.JTextField txtIdPedido;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
