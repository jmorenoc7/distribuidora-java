
package formularios;

import datos.DatosLogin;
import datos.Modificaciones;
import datos.Usuarios;
import javax.swing.JOptionPane;
import logica.Conexion;
import logica.fUsuarios;
import logica.funciones;


public class frmUsuarios extends javax.swing.JInternalFrame {

    Conexion con;
    Usuarios datos = new Usuarios();
    fUsuarios func;
    int bandera = 1;
    funciones f;
    Modificaciones datosF = new Modificaciones();
    public frmUsuarios(Conexion con) {
        initComponents();
        this.con = con;
        func = new fUsuarios(con);
        f = new funciones(con);
        deshabilitar();
    }
    
    public frmUsuarios(Conexion con, String usuario) {
        initComponents();
        this.con = con;
        func = new fUsuarios(con);
        cargarDatos(usuario);
        BtnNuevo.setEnabled(false);
        BtnCancelar.setEnabled(false);
        f = new funciones(con);
        bandera = 0;
        habilitar();
    }
    
    void cargarDatos(String usuario){
        String [] registros = func.buscarIdUsuario(usuario);
        
        if (registros != null) {
            LblIdUsuario.setText(registros[0]);
            TxtApellido.setText(registros[1]);
            TxtNombre.setText(registros[2]);
            TxtDni.setText(registros[3]);
            TxtDomicilio1.setText(registros[4]);
            TxtCiudad1.setText(registros[5]);
            TxtDomicilio2.setText(registros[6]);
            TxtCiudad2.setText(registros[7]);
            TxtTelefono1.setText(registros[8]);
            TxtTelefono2.setText(registros[9]);
            TxtEmail1.setText(registros[10]);
            TxtEmail2.setText(registros[11]);
            
            TxtUsuario.setText(registros[13]);
            TxtPass.setText(registros[14]);
            TxtPresupuesto.setText(registros[15]);
            TxtPuesto.setText(registros[16]);
            cbEstado.setSelectedItem(registros[17]);
            
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo cargar el Cliente");
            this.dispose();
        }
    }
    
    void deshabilitar(){
        TxtNombre.setEnabled(false);
        TxtApellido.setEnabled(false);
        TxtDni.setEnabled(false);
        TxtDomicilio1.setEnabled(false);
        TxtDomicilio2.setEnabled(false);
        TxtTelefono1.setEnabled(false);
        TxtTelefono2.setEnabled(false);
        TxtEmail1.setEnabled(false);
        TxtEmail2.setEnabled(false);
        DcFecha_Ingreso.setEnabled(false);
        TxtCiudad1.setEnabled(false);
        TxtCiudad2.setEnabled(false);
        TxtUsuario.setEnabled(false);
        TxtPass.setEnabled(false);
        TxtPass2.setEnabled(false);
        TxtPresupuesto.setEnabled(false);
        TxtPuesto.setEnabled(false);
        cbEstado.setEnabled(false);
        
        BtnGuardar.setEnabled(false);
        BtnCancelar.setEnabled(false);
        BtnNuevo.setEnabled(true);
        
        TxtNombre.setText("");
        TxtApellido.setText("");
        TxtDni.setText("");
        TxtDomicilio1.setText("");
        TxtDomicilio2.setText("");
        TxtTelefono1.setText("");
        TxtTelefono2.setText("");
        TxtEmail1.setText("");
        TxtEmail2.setText("");
        TxtCiudad1.setText("");
        TxtCiudad2.setText("");
        TxtUsuario.setText("");
        TxtPass.setText("");
        TxtPass2.setText("");
        TxtPresupuesto.setText("");
        TxtPuesto.setText("");
    }
    
    void habilitar(){
        TxtNombre.setEnabled(true);
        TxtApellido.setEnabled(true);
        TxtDni.setEnabled(true);
        TxtDomicilio1.setEnabled(true);
        TxtDomicilio2.setEnabled(true);
        TxtTelefono1.setEnabled(true);
        TxtTelefono2.setEnabled(true);
        TxtEmail1.setEnabled(true);
        TxtEmail2.setEnabled(true);
        DcFecha_Ingreso.setEnabled(true);
        TxtCiudad1.setEnabled(true);
        TxtCiudad2.setEnabled(true);
        TxtUsuario.setEnabled(true);
        TxtPass.setEnabled(true);
        TxtPass2.setEnabled(true);
        TxtPresupuesto.setEnabled(true);
        TxtPuesto.setEnabled(true);
        cbEstado.setEnabled(true);
        
        BtnGuardar.setEnabled(true);
        BtnCancelar.setEnabled(true);
        BtnNuevo.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtApellido = new javax.swing.JTextField();
        TxtDni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtTelefono1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtTelefono2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TxtEmail1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TxtEmail2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtDomicilio2 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtDomicilio1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        TxtPresupuesto = new javax.swing.JTextField();
        TxtPuesto = new javax.swing.JTextField();
        TxtPass = new javax.swing.JPasswordField();
        TxtPass2 = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        DcFecha_Ingreso = new com.toedter.calendar.JDateChooser();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        TxtCiudad1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TxtCiudad2 = new javax.swing.JTextField();
        LblIdUsuario = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Usuarios");
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Creacion y Modificacion de Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nombre: ");

        TxtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtNombre.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Apellido:");

        TxtApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtApellido.setEnabled(false);

        TxtDni.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtDni.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Dni: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Domicilio 1: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Domicilio 2: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Telefono 1:");

        TxtTelefono1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtTelefono1.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Telefono 2:");

        TxtTelefono2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtTelefono2.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Email 1:");

        TxtEmail1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtEmail1.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Email 2:");

        TxtEmail2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtEmail2.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Fecha Ing: ");

        TxtDomicilio2.setColumns(20);
        TxtDomicilio2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtDomicilio2.setRows(5);
        TxtDomicilio2.setEnabled(false);
        jScrollPane1.setViewportView(TxtDomicilio2);

        TxtDomicilio1.setColumns(20);
        TxtDomicilio1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtDomicilio1.setRows(5);
        TxtDomicilio1.setEnabled(false);
        jScrollPane2.setViewportView(TxtDomicilio1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos de Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Usuario: ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Contraseña: ");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Presupuesto: ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Puesto:");

        TxtUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtUsuario.setEnabled(false);

        TxtPresupuesto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPresupuesto.setEnabled(false);

        TxtPuesto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPuesto.setEnabled(false);

        TxtPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPass.setEnabled(false);

        TxtPass2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPass2.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Nuevamente Cont: ");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Estado:");

        cbEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TxtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(TxtUsuario, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtPuesto)
                            .addComponent(TxtPresupuesto)
                            .addComponent(cbEstado, 0, 164, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(TxtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(TxtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(TxtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(TxtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        DcFecha_Ingreso.setEnabled(false);
        DcFecha_Ingreso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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
        BtnGuardar.setEnabled(false);
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
        BtnCancelar.setEnabled(false);
        BtnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnCancelar.setIconTextGap(3);
        BtnCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Ciudad 1:");

        TxtCiudad1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtCiudad1.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Ciudad 2:");

        TxtCiudad2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtCiudad2.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtTelefono2)
                            .addComponent(TxtTelefono1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(TxtDni)
                            .addComponent(TxtApellido)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtCiudad1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtCiudad2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtEmail1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(TxtEmail2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DcFecha_Ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LblIdUsuario))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnCancelar, BtnGuardar, BtnNuevo});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TxtApellido, TxtDni, TxtNombre, TxtTelefono1, TxtTelefono2, jScrollPane1, jScrollPane2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(234, 234, 234))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(TxtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(DcFecha_Ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(BtnNuevo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LblIdUsuario)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtCiudad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtCiudad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(280, 280, 280))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(BtnGuardar)
                                .addGap(85, 85, 85)
                                .addComponent(BtnCancelar))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnCancelar, BtnGuardar, BtnNuevo});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        habilitar();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        deshabilitar();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    boolean verificarUsuario(String usuario){
        boolean resultado;
        resultado = func.verificarUsuario(usuario);
        return resultado;
    }
    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        if (verificarUsuario(TxtUsuario.getText())) {
            //si es verdadero es porque si existe el usuario en la base de datos
            JOptionPane.showMessageDialog(null, "Usuario ya existe, escriba otro");
            return;
        }
        if (!(TxtPass.getText().equals(TxtPass2.getText()))) {
            JOptionPane.showMessageDialog(null, "Las Password son distinta, vuelva a escribirlas");
            return;
        }
        if ((TxtPuesto.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Ingrese el puesto");
            return;
        }
        if ((TxtPresupuesto.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Ingrese un presupuesto");
            return;
        }
        boolean resultado;
        try {
            Double.parseDouble(TxtPresupuesto.getText());
            resultado = true;
            
        } catch (NumberFormatException e) {
            resultado = false;
        }
        if (!resultado) {
            JOptionPane.showMessageDialog(null, "Ingrese un numero en el presupuesto");
            return;
        }
        
        //Carga de datos
        datos.setNombre(TxtNombre.getText());
        datos.setApellido(TxtApellido.getText());
        datos.setDni(TxtDni.getText());
        datos.setDomicilio1(TxtDomicilio1.getText());
        datos.setCiudad1(TxtCiudad1.getText());
        datos.setDomicilio2(TxtDomicilio2.getText());
        datos.setCiudad2(TxtCiudad2.getText());
        datos.setTelefono1(TxtTelefono1.getText());
        datos.setTelefono2(TxtTelefono2.getText());
        datos.setEmail1(TxtEmail1.getText());
        datos.setEmail2(TxtEmail2.getText());
        datos.setUsuario(TxtUsuario.getText());
        datos.setPass(TxtPass.getText());
        datos.setPresupuesto(Double.parseDouble(TxtPresupuesto.getText()));
        datos.setPuesto(TxtPuesto.getText());
        datos.setEstado(cbEstado.getSelectedItem().toString());
        if (bandera == 1) {
           if (func.insertar(datos)) {
            JOptionPane.showMessageDialog(null, "Se inserto usuario correctamente");
            deshabilitar();
            }else{
                JOptionPane.showMessageDialog(null, "Se produjo un error\n\n Intente mas tarde");
            } 
        }else{
            datos.setIdpersona(Integer.parseInt(LblIdUsuario.getText()));
            if (bandera == 0) {
                if (func.modificar(datos)) {
                    datosF.setIdregTabla(Integer.parseInt(LblIdUsuario.getText()));
                    datosF.setTabla("usuarios");
                    datosF.setUsuario(DatosLogin.getUsuario());
                    if (!f.insertar(datosF)) {
                        JOptionPane.showMessageDialog(null, "No se pudo ingresar en la tabla de modificaciones");
                    }
                    JOptionPane.showMessageDialog(null, "Se modifico correctamente");
                    this.dispose();
                }
            }
        }
        
    }//GEN-LAST:event_BtnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnNuevo;
    public static com.toedter.calendar.JDateChooser DcFecha_Ingreso;
    private javax.swing.JLabel LblIdUsuario;
    private javax.swing.JTextField TxtApellido;
    private javax.swing.JTextField TxtCiudad1;
    private javax.swing.JTextField TxtCiudad2;
    private javax.swing.JTextField TxtDni;
    private javax.swing.JTextArea TxtDomicilio1;
    private javax.swing.JTextArea TxtDomicilio2;
    private javax.swing.JTextField TxtEmail1;
    private javax.swing.JTextField TxtEmail2;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JPasswordField TxtPass;
    private javax.swing.JPasswordField TxtPass2;
    private javax.swing.JTextField TxtPresupuesto;
    private javax.swing.JTextField TxtPuesto;
    private javax.swing.JTextField TxtTelefono1;
    private javax.swing.JTextField TxtTelefono2;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
