
package formularios;

import datos.DatosLogin;
import datos.Modificaciones;
import datos.Productos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Conexion;
import logica.fCategorias;
import logica.fProductos;
import logica.funciones;


public class frmProductos extends javax.swing.JInternalFrame {

    Conexion con;
    Productos datos = new Productos();
    fProductos func;
    fCategorias funcCat;
    int bandera = 1;
    funciones f;
    Modificaciones datosF = new Modificaciones();
    public frmProductos(Conexion con) {
        initComponents();
        this.con = con;
        func = new fProductos(con);
        funcCat = new fCategorias(con);
        f = new funciones(con);
        cargarCbo();
        cargarIdCat(cbCat.getSelectedItem().toString());
        deshabilitar();
    }
    
    public frmProductos(Conexion con, String idProd) {
        initComponents();
        this.con = con;
        func = new fProductos(con);
        funcCat = new fCategorias(con);
        f = new funciones(con);
        cargarCbo();
        cargarIdCat(cbCat.getSelectedItem().toString());
        cargarDatos(idProd);
        
        bandera = 0;
    }
    
    void cargarDatos(String producto){
        String [] registros = func.buscarIdProducto(producto);
        
        if (registros != null) {
            JOptionPane.showMessageDialog(null, registros);
            
            LblIdProducto.setText(registros[0]);
            TxtIdCat.setText(registros[1]);
            
            cbCat.setSelectedItem(registros[2]);
            TxtNombre.setText(registros[4]);
            TxtDescripcion.setText(registros[5]);
            TxtPrecio1.setText(registros[10]);
            TxtPCompra1.setText(registros[7]);
            TxtMargen1.setText(registros[13]);
            TxtPrecio2.setText(registros[11]);
            TxtPCompra2.setText(registros[8]);
            TxtMargen2.setText(registros[14]);
            TxtPrecio3.setText(registros[12]);
            TxtPCompra3.setText(registros[9]);
            TxtMargen3.setText(registros[15]);
            TxtStock.setText(registros[6]);
            TxtCantMin.setText(registros[16]);
            TxtCodBarra.setText(registros[3]);
            CboEstado.setSelectedItem(registros[17]);
            
            habilitar();
            
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo cargar el Producto");
            this.dispose();
        }
    }
    
    void cargarCbo(){
        ArrayList<String> lista = new ArrayList<String>();
        lista = funcCat.listaCat();
        
        for (String s : lista) {
            cbCat.addItem(s);
        }
    }
    
    void cargarIdCat(String cat){
        TxtIdCat.setText(funcCat.buscarIdCat(cat));
    }
    
    void habilitar(){
        TxtNombre.setEnabled(true);
        TxtDescripcion.setEnabled(true);
        //TxtPrecio1.setEnabled(true);
        TxtPCompra1.setEnabled(true);
        //TxtMargen1.setEnabled(true);
        //TxtPrecio2.setEnabled(true);
        TxtPCompra2.setEnabled(true);
        //TxtMargen2.setEnabled(true);
        //TxtPrecio3.setEnabled(true);
        TxtPCompra3.setEnabled(true);
        //TxtMargen3.setEnabled(true);
        TxtStock.setEnabled(true);
        TxtCantMin.setEnabled(true);
        TxtCodBarra.setEnabled(true);
        
        cbCat.setEnabled(true);
        CboEstado.setEnabled(true);
        
        BtnGuardar.setEnabled(true);
        BtnCancelar.setEnabled(true);
        BtnNuevo.setEnabled(false);
        
        
    }
    
    void deshabilitar(){
        TxtNombre.setEnabled(false);
        TxtDescripcion.setEnabled(false);
        TxtPrecio1.setEnabled(false);
        TxtPCompra1.setEnabled(false);
        TxtMargen1.setEnabled(false);
        TxtPrecio2.setEnabled(false);
        TxtPCompra2.setEnabled(false);
        TxtMargen2.setEnabled(false);
        TxtPrecio3.setEnabled(false);
        TxtPCompra3.setEnabled(false);
        TxtMargen3.setEnabled(false);
        TxtStock.setEnabled(false);
        TxtCantMin.setEnabled(false);
        TxtCodBarra.setEnabled(false);
        
        TxtNombre.setText("");
        TxtDescripcion.setText("");
        TxtPrecio1.setText("0");
        TxtPCompra1.setText("0");
        TxtMargen1.setText("0");
        TxtPrecio2.setText("0");
        TxtPCompra2.setText("0");
        TxtMargen2.setText("0");
        TxtPrecio3.setText("0");
        TxtPCompra3.setText("0");
        TxtMargen3.setText("0");
        TxtStock.setText("0");
        TxtCantMin.setText("0");
        TxtCodBarra.setText("");
        
        cbCat.setEnabled(false);
        CboEstado.setEnabled(false);
        
        BtnGuardar.setEnabled(false);
        BtnCancelar.setEnabled(false);
        BtnNuevo.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtCodBarra = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtStock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtPCompra1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TxtPrecio1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TxtMargen1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtDescripcion = new javax.swing.JTextArea();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        TxtIdCat = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TxtPrecio2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TxtMargen2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CboEstado = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        TxtPCompra2 = new javax.swing.JTextField();
        TxtPCompra3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TxtMargen3 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        TxtPrecio3 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TxtCantMin = new javax.swing.JTextField();
        LblIdProducto = new javax.swing.JLabel();
        cbCat = new javax.swing.JComboBox<>();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Productos");
        setToolTipText("");
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Creacion y Modificacion de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Categoria:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Cod Barra:");

        TxtCodBarra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TxtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nombre: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Descripcion:  ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Stock:");

        TxtStock.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtStock.setText("0");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Precio Compra1: ");

        TxtPCompra1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPCompra1.setText("0");
        TxtPCompra1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtPCompra1KeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Precio 1:");

        TxtPrecio1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPrecio1.setText("0");
        TxtPrecio1.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Margen 1: ");

        TxtMargen1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtMargen1.setText("0");
        TxtMargen1.setEnabled(false);
        TxtMargen1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtMargen1KeyReleased(evt);
            }
        });

        TxtDescripcion.setColumns(20);
        TxtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtDescripcion.setRows(5);
        jScrollPane2.setViewportView(TxtDescripcion);

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

        TxtIdCat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtIdCat.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Precio 2:");

        TxtPrecio2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPrecio2.setText("0");
        TxtPrecio2.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Margen 2: ");

        TxtMargen2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtMargen2.setText("0");
        TxtMargen2.setEnabled(false);
        TxtMargen2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtMargen2KeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Estado:");

        CboEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Precio Compra2: ");

        TxtPCompra2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPCompra2.setText("0");
        TxtPCompra2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtPCompra2KeyReleased(evt);
            }
        });

        TxtPCompra3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPCompra3.setText("0");
        TxtPCompra3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtPCompra3KeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Precio Compra3: ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Margen 3: ");

        TxtMargen3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtMargen3.setText("0");
        TxtMargen3.setEnabled(false);
        TxtMargen3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtMargen3KeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Precio 3:");

        TxtPrecio3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPrecio3.setText("0");
        TxtPrecio3.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Cant Min:");

        TxtCantMin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtCantMin.setText("0");

        cbCat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbCat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCatItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LblIdProducto))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtIdCat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbCat, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TxtCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtPCompra1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtPCompra2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtPCompra3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtMargen1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtMargen2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtMargen3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtPrecio2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(TxtPrecio3)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(jLabel7)
                        .addGap(36, 36, 36)
                        .addComponent(TxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(TxtCantMin, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(217, 217, 217)
                        .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnCancelar, BtnGuardar, BtnNuevo});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TxtCodBarra, jScrollPane2});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TxtPCompra1, TxtPCompra2, TxtPCompra3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TxtMargen1, TxtMargen2, TxtMargen3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TxtPrecio1, TxtPrecio2, TxtPrecio3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtIdCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addComponent(TxtPCompra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10)
                                        .addComponent(TxtMargen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(TxtMargen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(TxtPCompra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel16)
                                    .addComponent(TxtMargen3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(TxtPCompra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(70, 70, 70)
                                        .addComponent(jLabel17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(TxtPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtPrecio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtPrecio3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel14)
                                    .addComponent(CboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtCantMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnGuardar)
                    .addComponent(BtnNuevo)
                    .addComponent(BtnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblIdProducto))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnCancelar, BtnGuardar, BtnNuevo});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCatItemStateChanged
        cargarIdCat(cbCat.getSelectedItem().toString());
    }//GEN-LAST:event_cbCatItemStateChanged

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        habilitar();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        deshabilitar();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        datos.setIdcategoria(Integer.parseInt(TxtIdCat.getText()));
        datos.setNombre(TxtNombre.getText());
        datos.setDescripcion(TxtDescripcion.getText());
        datos.setCodBarra(TxtCodBarra.getText());
        datos.setStock(Integer.parseInt(TxtStock.getText()));
        datos.setCatMin(Integer.parseInt(TxtCantMin.getText()));
        datos.setPrecioC1(Double.parseDouble(TxtPCompra1.getText()));
        datos.setPrecioC2(Double.parseDouble(TxtPCompra2.getText()));
        datos.setPrecioC3(Double.parseDouble(TxtPCompra3.getText()));
        datos.setMargen1(Double.parseDouble(TxtMargen1.getText()));
        datos.setMargen2(Double.parseDouble(TxtMargen2.getText()));
        datos.setMargen3(Double.parseDouble(TxtMargen3.getText()));
        datos.setPrecioV1(Double.parseDouble(TxtPrecio1.getText()));
        datos.setPrecioV2(Double.parseDouble(TxtPrecio2.getText()));
        datos.setPrecioV3(Double.parseDouble(TxtPrecio3.getText()));
        datos.setEstado(CboEstado.getSelectedItem().toString());
        
        if (bandera == 1) {
            if (func.insertar(datos)) {
                JOptionPane.showMessageDialog(null, "Se inserto el producto correctamente");
                deshabilitar();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo insertar el producto, intente mas tarde");
            }
        }
        if (bandera == 0) {
            datos.setIdproducto(Integer.parseInt(LblIdProducto.getText()));
            if (func.modificar(datos)) {
                datosF.setIdregTabla(Integer.parseInt(LblIdProducto.getText()));
                datosF.setTabla("productos");
                datosF.setUsuario(DatosLogin.getUsuario());
                if (!f.insertar(datosF)) {
                    JOptionPane.showMessageDialog(null, "No se pudo ingresar en la tabla de modificaciones");
                }
                JOptionPane.showMessageDialog(null, "Se modifico correctamente el producto");
                deshabilitar();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo modificar el producto, intente mas tarde");
            }
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed
 
    
    private void TxtPCompra1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPCompra1KeyReleased
        try {
            if (Double.parseDouble(TxtPCompra1.getText())>0.0) {
                TxtMargen1.setEnabled(true);
            }else{
                TxtMargen1.setEnabled(false);
            }
        } catch (NumberFormatException e) {
            TxtMargen1.setEnabled(false);
        }
        
        
    }//GEN-LAST:event_TxtPCompra1KeyReleased

    private void TxtPCompra2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPCompra2KeyReleased
        try {
            if (Double.parseDouble(TxtPCompra2.getText())>0.0) {
                TxtMargen2.setEnabled(true);
            }else{
                TxtMargen2.setEnabled(false);
            }
        } catch (NumberFormatException e) {
            TxtMargen2.setEnabled(false);
        }
        
    }//GEN-LAST:event_TxtPCompra2KeyReleased

    private void TxtPCompra3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPCompra3KeyReleased
        try {
            if (Double.parseDouble(TxtPCompra3.getText())>0.0) {
                TxtMargen3.setEnabled(true);
            }else{
                TxtMargen3.setEnabled(false);
            }
        } catch (NumberFormatException e) {
            TxtMargen3.setEnabled(false);
        }
        
        
    }//GEN-LAST:event_TxtPCompra3KeyReleased

    private void TxtMargen1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtMargen1KeyReleased
        try {
            Double precio = 0.0;
            Double precioCompra = Double.parseDouble(TxtPCompra1.getText());
            Double margen = Double.parseDouble(TxtMargen1.getText());
            precio = precioCompra * ((margen/100)+1);
            precio = Math.round(precio * 100) / 100d;
            TxtPrecio1.setText(precio.toString());
        } catch (NumberFormatException e) {
            TxtPrecio1.setText("0");
        }
        
    }//GEN-LAST:event_TxtMargen1KeyReleased

    private void TxtMargen2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtMargen2KeyReleased
       try {
            Double precio = 0.0;
            Double precioCompra = Double.parseDouble(TxtPCompra2.getText());
            Double margen = Double.parseDouble(TxtMargen2.getText());
            precio = precioCompra * ((margen/100)+1);
            precio = Math.round(precio * 100) / 100d;
            TxtPrecio2.setText(precio.toString());
        } catch (NumberFormatException e) {
            TxtPrecio2.setText("0");
        }
    }//GEN-LAST:event_TxtMargen2KeyReleased

    private void TxtMargen3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtMargen3KeyReleased
        try {
            Double precio = 0.0;
            Double precioCompra = Double.parseDouble(TxtPCompra3.getText());
            Double margen = Double.parseDouble(TxtMargen3.getText());
            precio = precioCompra * ((margen/100)+1);
            precio = Math.round(precio * 100) / 100d;
            TxtPrecio3.setText(precio.toString());
        } catch (NumberFormatException e) {
            TxtPrecio3.setText("0");
        }
    }//GEN-LAST:event_TxtMargen3KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> CboEstado;
    private javax.swing.JLabel LblIdProducto;
    private javax.swing.JTextField TxtCantMin;
    private javax.swing.JTextField TxtCodBarra;
    private javax.swing.JTextArea TxtDescripcion;
    private javax.swing.JTextField TxtIdCat;
    private javax.swing.JTextField TxtMargen1;
    private javax.swing.JTextField TxtMargen2;
    private javax.swing.JTextField TxtMargen3;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtPCompra1;
    private javax.swing.JTextField TxtPCompra2;
    private javax.swing.JTextField TxtPCompra3;
    private javax.swing.JTextField TxtPrecio1;
    private javax.swing.JTextField TxtPrecio2;
    private javax.swing.JTextField TxtPrecio3;
    private javax.swing.JTextField TxtStock;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCat;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
