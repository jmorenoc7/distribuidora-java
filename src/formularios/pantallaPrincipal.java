package formularios;

import datos.DatosLogin;
import datos.Notas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logica.Conexion;
import logica.fPedido;
import logica.fPedidoProv;
import logica.fUsuarios;
import logica.imprimir;

public class pantallaPrincipal extends javax.swing.JFrame {
    Conexion con;
    fPedido func;
    fPedidoProv funcProv;
    fUsuarios funcU;
    Notas datosN = new Notas();
    public pantallaPrincipal(Conexion con) {
        initComponents();
        this.con = con;
        func = new fPedido(con);
        funcProv = new fPedidoProv(con);
        funcU = new fUsuarios(con);
        mostrarPedido();
        mostrarPedidoProv();
        cargarNotas();
        lblNombre.setText(DatosLogin.getNombre());
        lblUsuario.setText(DatosLogin.getUsuario());
        lblPuesto.setText(DatosLogin.getPerfil());
        sumarTabla();
    }
    
    void cargarNotas(){
        String [] registros;
        registros = funcU.buscarNotaUsuario(String.valueOf(DatosLogin.getNusuario()));
        
        if (registros != null) {
            lblIdNota.setText(registros[0]);
            lblFechaNota.setText(registros[3]);
            txtNota.setText(registros[2]);
        }else{
            JOptionPane.showMessageDialog(null, "No hay notas");
        }
    }
    
    void sumarTabla(){
        Double suma = 0.0;
        if (tblPedidoDia.getRowCount() != 0) {
            for (int i = 0; i < tblPedidoDia.getRowCount(); i++) {
                suma = suma + Double.parseDouble(tblPedidoDia.getValueAt(i, 9).toString());
            }
            lblVentas.setText(suma.toString());
        }else{
            lblVentas.setText(suma.toString());
        }
    }
    
    void mostrarPedido(){
        DefaultTableModel tabla;
        
        Calendar fecha = Calendar.getInstance();
        int a,m,d;
        a = fecha.get(Calendar.YEAR);
        m = fecha.get(Calendar.MONTH) + 1;
        d = fecha.get(Calendar.DAY_OF_MONTH);
        //JOptionPane.showMessageDialog(null, a + "-" + m + "-" + d);
        
        tabla = func.mostrarPedidosDia(a + "-" + m + "-" + d);
        tblPedidoDia.setModel(tabla);
        ordenTabla();
        
    }
    
    void mostrarPedidoProv(){
        DefaultTableModel tabla;
        
        Calendar fecha = Calendar.getInstance();
        int a,m,d;
        a = fecha.get(Calendar.YEAR);
        m = fecha.get(Calendar.MONTH) + 1;
        d = fecha.get(Calendar.DAY_OF_MONTH);
        //JOptionPane.showMessageDialog(null, a + "-" + m + "-" + d);
        
        tabla = funcProv.mostrarPedidosMes(String.valueOf(m));
        tblPedidoProv.setModel(tabla);
        ordenTabla();
        
    }
    
    void ordenTabla(){
        
        
         DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
         tcr.setHorizontalAlignment(SwingConstants.CENTER);
         
         tblPedidoDia.getColumnModel().getColumn(0).setMaxWidth(50);
         tblPedidoDia.getColumnModel().getColumn(0).setMinWidth(50);
         tblPedidoDia.getColumnModel().getColumn(0).setPreferredWidth(50);

         tblPedidoDia.getColumnModel().getColumn(1).setMaxWidth(0);
         tblPedidoDia.getColumnModel().getColumn(1).setMinWidth(0);
         tblPedidoDia.getColumnModel().getColumn(1).setPreferredWidth(0);
         
         tblPedidoDia.getColumnModel().getColumn(3).setMaxWidth(0);
         tblPedidoDia.getColumnModel().getColumn(3).setMinWidth(0);
         tblPedidoDia.getColumnModel().getColumn(3).setPreferredWidth(0);
         
         tblPedidoDia.getColumnModel().getColumn(4).setMaxWidth(60);
         tblPedidoDia.getColumnModel().getColumn(4).setMinWidth(60);
         tblPedidoDia.getColumnModel().getColumn(4).setPreferredWidth(60);
         
         tblPedidoDia.getColumnModel().getColumn(7).setMaxWidth(70);
         tblPedidoDia.getColumnModel().getColumn(7).setMinWidth(70);
         tblPedidoDia.getColumnModel().getColumn(7).setPreferredWidth(70);
         
         tblPedidoDia.getColumnModel().getColumn(8).setMaxWidth(50);
         tblPedidoDia.getColumnModel().getColumn(8).setMinWidth(50);
         tblPedidoDia.getColumnModel().getColumn(8).setPreferredWidth(50);
         
         tblPedidoDia.getColumnModel().getColumn(9).setMaxWidth(70);
         tblPedidoDia.getColumnModel().getColumn(9).setMinWidth(70);
         tblPedidoDia.getColumnModel().getColumn(9).setPreferredWidth(70);
         
         tblPedidoDia.getColumnModel().getColumn(0).setCellRenderer(tcr);
         tblPedidoDia.getColumnModel().getColumn(2).setCellRenderer(tcr);
         tblPedidoDia.getColumnModel().getColumn(4).setCellRenderer(tcr);
         tblPedidoDia.getColumnModel().getColumn(5).setCellRenderer(tcr);
         tblPedidoDia.getColumnModel().getColumn(6).setCellRenderer(tcr);
         tblPedidoDia.getColumnModel().getColumn(7).setCellRenderer(tcr);
         tblPedidoDia.getColumnModel().getColumn(8).setCellRenderer(tcr);
         tblPedidoDia.getColumnModel().getColumn(9).setCellRenderer(tcr);
         tblPedidoDia.getColumnModel().getColumn(10).setCellRenderer(tcr);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JdpEscritorio = new javax.swing.JDesktopPane();
        lblFechaNota = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNota = new javax.swing.JTextArea();
        BtnEntregaPedidos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidoDia = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblPuesto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPresupuesto3 = new javax.swing.JLabel();
        lblPresupuesto4 = new javax.swing.JLabel();
        lblPresupuesto5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        lblVentas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPedidoProv = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lblIdNota = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JmiCrearPedido = new javax.swing.JMenuItem();
        JmiListaPedidos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        JmiProductos = new javax.swing.JMenuItem();
        JmiListaProductos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        JmClientes = new javax.swing.JMenu();
        JmiClientes = new javax.swing.JMenuItem();
        JmiListaClientes = new javax.swing.JMenuItem();
        JmSaldos = new javax.swing.JMenuItem();
        JmProveedor = new javax.swing.JMenu();
        JmPedidoProv = new javax.swing.JMenuItem();
        JmiProveedores = new javax.swing.JMenuItem();
        JmListaPP = new javax.swing.JMenuItem();
        JmiListaProveedores = new javax.swing.JMenuItem();
        JmUsuarios = new javax.swing.JMenu();
        JmiUsuarios = new javax.swing.JMenuItem();
        JmiListaUsuarios = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jmModificaciones = new javax.swing.JMenuItem();
        jmCambioUsuario = new javax.swing.JMenu();
        jmSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sistema de Gestion - Golozur");
        setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N

        JdpEscritorio.setBackground(new java.awt.Color(67, 124, 244));

        lblFechaNota.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblFechaNota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtNota.setColumns(20);
        txtNota.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtNota.setRows(5);
        jScrollPane1.setViewportView(txtNota);

        BtnEntregaPedidos.setText("Entrega de Pedidos");
        BtnEntregaPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEntregaPedidosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Pedidos Proveedor del mes");

        tblPedidoDia.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblPedidoDia);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Usuario:");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario");

        lblPuesto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPuesto.setText("Puesto");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Puesto:");

        lblPresupuesto3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPresupuesto3.setText("|");

        lblPresupuesto4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPresupuesto4.setText("|");

        lblPresupuesto5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPresupuesto5.setText("|");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ventas del Dia:");

        lblUsuario1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario1.setText("$");

        lblVentas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblVentas.setText("Usuario");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nombre:");

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre.setText("Nombre");

        tblPedidoProv.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblPedidoProv);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Pedidos del Dia");

        lblIdNota.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Notas");

        JdpEscritorio.setLayer(lblFechaNota, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(BtnEntregaPedidos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(btnActualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(lblUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(lblPuesto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(lblPresupuesto3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(lblPresupuesto4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(lblPresupuesto5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(lblUsuario1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(lblVentas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(lblNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(lblIdNota, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdpEscritorio.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JdpEscritorioLayout = new javax.swing.GroupLayout(JdpEscritorio);
        JdpEscritorio.setLayout(JdpEscritorioLayout);
        JdpEscritorioLayout.setHorizontalGroup(
            JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JdpEscritorioLayout.createSequentialGroup()
                .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JdpEscritorioLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel5)
                        .addGap(87, 87, 87)
                        .addComponent(btnActualizar)
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)
                        .addGap(299, 299, 299)
                        .addComponent(jLabel9)
                        .addGap(10, 10, 10)
                        .addComponent(lblIdNota, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JdpEscritorioLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JdpEscritorioLayout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(BtnEntregaPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaNota, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JdpEscritorioLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel7)
                        .addGap(9, 9, 9)
                        .addComponent(lblNombre)
                        .addGap(57, 57, 57)
                        .addComponent(lblPresupuesto3)
                        .addGap(18, 18, 18)
                        .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JdpEscritorioLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(lblUsuario1))
                            .addComponent(jLabel6))
                        .addGap(11, 11, 11)
                        .addComponent(lblVentas))
                    .addGroup(JdpEscritorioLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JdpEscritorioLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(17, 17, 17)
                                .addComponent(lblPuesto))
                            .addGroup(JdpEscritorioLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(13, 13, 13)
                                .addComponent(lblUsuario)))
                        .addGap(62, 62, 62)
                        .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPresupuesto5)
                            .addComponent(lblPresupuesto4))))
                .addGap(12, 12, 12))
        );
        JdpEscritorioLayout.setVerticalGroup(
            JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JdpEscritorioLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(lblIdNota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JdpEscritorioLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(btnActualizar)
                            .addComponent(jButton1))))
                .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JdpEscritorioLayout.createSequentialGroup()
                        .addComponent(lblFechaNota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JdpEscritorioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JdpEscritorioLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2)
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnEntregaPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lblNombre)
                    .addComponent(lblUsuario1)
                    .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(lblPresupuesto3))
                    .addComponent(lblVentas))
                .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JdpEscritorioLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lblUsuario))
                        .addGap(3, 3, 3)
                        .addGroup(JdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lblPuesto)))
                    .addGroup(JdpEscritorioLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblPresupuesto4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPresupuesto5)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        MenuBar.setBackground(new java.awt.Color(255, 255, 255));
        MenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Venta_96x96.png"))); // NOI18N
        jMenu1.setText("Venta");
        jMenu1.setContentAreaFilled(false);
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.setIconTextGap(3);
        jMenu1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jMenu1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        JmiCrearPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Crear_Pedidos_32x32.png"))); // NOI18N
        JmiCrearPedido.setText("Crear Pedido");
        JmiCrearPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiCrearPedidoActionPerformed(evt);
            }
        });
        jMenu1.add(JmiCrearPedido);

        JmiListaPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Lista_Pedidos_32x32.png"))); // NOI18N
        JmiListaPedidos.setText("Lista de Pedidos");
        JmiListaPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiListaPedidosActionPerformed(evt);
            }
        });
        jMenu1.add(JmiListaPedidos);

        MenuBar.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Productos_96x96.png"))); // NOI18N
        jMenu3.setText("Inventario");
        jMenu3.setContentAreaFilled(false);
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu3.setIconTextGap(3);
        jMenu3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jMenu3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        JmiProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Productos_32x32.png"))); // NOI18N
        JmiProductos.setText("Productos");
        JmiProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiProductosActionPerformed(evt);
            }
        });
        jMenu3.add(JmiProductos);

        JmiListaProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Lista_Productos_32x32.png"))); // NOI18N
        JmiListaProductos.setText("Lista de Productos");
        JmiListaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiListaProductosActionPerformed(evt);
            }
        });
        jMenu3.add(JmiListaProductos);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Categorias_32x32.png"))); // NOI18N
        jMenuItem1.setText("Categorias");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        MenuBar.add(jMenu3);

        JmClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Clientes_96x96.png"))); // NOI18N
        JmClientes.setText("Clientes");
        JmClientes.setContentAreaFilled(false);
        JmClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JmClientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JmClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JmClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JmClientes.setIconTextGap(3);
        JmClientes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        JmClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        JmiClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Cliente_32x32.png"))); // NOI18N
        JmiClientes.setText("Crear Clientes");
        JmiClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiClientesActionPerformed(evt);
            }
        });
        JmClientes.add(JmiClientes);

        JmiListaClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Lista_32x32.png"))); // NOI18N
        JmiListaClientes.setText("Lista Clientes");
        JmiListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiListaClientesActionPerformed(evt);
            }
        });
        JmClientes.add(JmiListaClientes);

        JmSaldos.setText("Saldos");
        JmSaldos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmSaldosActionPerformed(evt);
            }
        });
        JmClientes.add(JmSaldos);

        MenuBar.add(JmClientes);

        JmProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Proveedores_96x96.png"))); // NOI18N
        JmProveedor.setText("Proveedores");
        JmProveedor.setContentAreaFilled(false);
        JmProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JmProveedor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JmProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JmProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JmProveedor.setIconTextGap(3);
        JmProveedor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        JmProveedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        JmPedidoProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Crear_Pedidos_32x32.png"))); // NOI18N
        JmPedidoProv.setText("Crear Pedido Prov");
        JmPedidoProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPedidoProvActionPerformed(evt);
            }
        });
        JmProveedor.add(JmPedidoProv);

        JmiProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Proveedor_32x32.png"))); // NOI18N
        JmiProveedores.setText("Crear Proveedores");
        JmiProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiProveedoresActionPerformed(evt);
            }
        });
        JmProveedor.add(JmiProveedores);

        JmListaPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Lista_Pedidos_32x32.png"))); // NOI18N
        JmListaPP.setText("Lista Pedidos Prov");
        JmListaPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmListaPPActionPerformed(evt);
            }
        });
        JmProveedor.add(JmListaPP);

        JmiListaProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Lista_32x32.png"))); // NOI18N
        JmiListaProveedores.setText("Lista Proveedores");
        JmiListaProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiListaProveedoresActionPerformed(evt);
            }
        });
        JmProveedor.add(JmiListaProveedores);

        MenuBar.add(JmProveedor);

        JmUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Usuarios_96x96.png"))); // NOI18N
        JmUsuarios.setText("Usuarios");
        JmUsuarios.setContentAreaFilled(false);
        JmUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JmUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JmUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JmUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JmUsuarios.setIconTextGap(3);
        JmUsuarios.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        JmUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JmUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmUsuariosMouseClicked(evt);
            }
        });

        JmiUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Usuario_32x32.png"))); // NOI18N
        JmiUsuarios.setText("Crear Usuarios");
        JmiUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiUsuariosActionPerformed(evt);
            }
        });
        JmUsuarios.add(JmiUsuarios);

        JmiListaUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Lista_32x32.png"))); // NOI18N
        JmiListaUsuarios.setText("Lista Usuarios");
        JmiListaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiListaUsuariosActionPerformed(evt);
            }
        });
        JmUsuarios.add(JmiListaUsuarios);

        MenuBar.add(JmUsuarios);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Informes_96x96.png"))); // NOI18N
        jMenu6.setText("Informes");
        jMenu6.setContentAreaFilled(false);
        jMenu6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu6.setIconTextGap(3);
        jMenu6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jMenu6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuBar.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Configuraciones_96x96.png"))); // NOI18N
        jMenu7.setText("Configuraciones");
        jMenu7.setContentAreaFilled(false);
        jMenu7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu7.setIconTextGap(3);
        jMenu7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jMenu7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jmModificaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Modificaciones_32x32.png"))); // NOI18N
        jmModificaciones.setText("Modificaciones");
        jmModificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModificacionesActionPerformed(evt);
            }
        });
        jMenu7.add(jmModificaciones);

        MenuBar.add(jMenu7);

        jmCambioUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Cambio_Usuario_96x96.png"))); // NOI18N
        jmCambioUsuario.setText("Cambio de Usuario");
        jmCambioUsuario.setContentAreaFilled(false);
        jmCambioUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmCambioUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jmCambioUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmCambioUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmCambioUsuario.setIconTextGap(3);
        jmCambioUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jmCambioUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jmCambioUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmCambioUsuarioMousePressed(evt);
            }
        });
        MenuBar.add(jmCambioUsuario);

        jmSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/Salir_96x96.png"))); // NOI18N
        jmSalir.setText("Salir");
        jmSalir.setContentAreaFilled(false);
        jmSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jmSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmSalir.setIconTextGap(3);
        jmSalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jmSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jmSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmSalirMousePressed(evt);
            }
        });
        MenuBar.add(jmSalir);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JdpEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JdpEscritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public class Hilo implements Runnable {

        @Override
        public void run() {
            new Timer(0, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Date d = new Date();
                    SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
                   // lblHora.setText(s.format(d));
                }
            }).start();
        }
    }
    
    private void JmUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmUsuariosMouseClicked
       
    }//GEN-LAST:event_JmUsuariosMouseClicked

    private void JmiUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiUsuariosActionPerformed
        frmUsuarios u = new frmUsuarios(con);
        JdpEscritorio.add(u);
        u.show();
    }//GEN-LAST:event_JmiUsuariosActionPerformed

    private void JmiListaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiListaUsuariosActionPerformed
        frmListaUsuarios lu = new frmListaUsuarios(con);
        JdpEscritorio.add(lu);
        lu.show();
    }//GEN-LAST:event_JmiListaUsuariosActionPerformed

    private void JmiProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiProveedoresActionPerformed
        frmProveedores p = new frmProveedores(con);
        JdpEscritorio.add(p);
        p.show();
    }//GEN-LAST:event_JmiProveedoresActionPerformed

    private void JmiListaProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiListaProveedoresActionPerformed
        frmListaProveedores lp = new frmListaProveedores(con);
        JdpEscritorio.add(lp);
        lp.show();
    }//GEN-LAST:event_JmiListaProveedoresActionPerformed

    private void JmiCrearPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiCrearPedidoActionPerformed
        frmPedido ped = new frmPedido(con);
        JdpEscritorio.add(ped);
        ped.show();
    }//GEN-LAST:event_JmiCrearPedidoActionPerformed

    private void JmiListaPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiListaPedidosActionPerformed
        frmListaPedidos lped = new frmListaPedidos(con);
        JdpEscritorio.add(lped);
        lped.show();
    }//GEN-LAST:event_JmiListaPedidosActionPerformed

    private void JmiProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiProductosActionPerformed
        frmProductos p = new frmProductos(con);
        JdpEscritorio.add(p);
        p.show();
    }//GEN-LAST:event_JmiProductosActionPerformed

    private void JmiListaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiListaProductosActionPerformed
        frmListaProductos lp = new frmListaProductos(con);
        JdpEscritorio.add(lp);
        lp.show();
    }//GEN-LAST:event_JmiListaProductosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        frmCategorias c = new frmCategorias(con);
        JdpEscritorio.add(c);
        c.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmCambioUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmCambioUsuarioMousePressed
        
        if (evt.getClickCount() == 1) {
            frmLogin login = new frmLogin();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_jmCambioUsuarioMousePressed

    private void jmModificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModificacionesActionPerformed
        frmListaModificaciones lmod = new frmListaModificaciones(con);
        JdpEscritorio.add(lmod);
        lmod.show();
    }//GEN-LAST:event_jmModificacionesActionPerformed

    private void JmPedidoProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPedidoProvActionPerformed
        frmPedidoProveedores pp =  new frmPedidoProveedores(con);
        JdpEscritorio.add(pp);
        pp.show();
    }//GEN-LAST:event_JmPedidoProvActionPerformed

    private void JmListaPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmListaPPActionPerformed
        frmListaPP listapp = new frmListaPP(con);
        JdpEscritorio.add(listapp);
        listapp.show();
    }//GEN-LAST:event_JmListaPPActionPerformed

    private void JmiListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiListaClientesActionPerformed
        frmListaClientes lc = new frmListaClientes();
        JdpEscritorio.add(lc);
        lc.show();
    }//GEN-LAST:event_JmiListaClientesActionPerformed

    private void JmiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiClientesActionPerformed
        frmClientes c = new frmClientes(con);
        JdpEscritorio.add(c);
        c.show();
    }//GEN-LAST:event_JmiClientesActionPerformed

    private void JmSaldosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmSaldosActionPerformed
        frmSaldos s = new frmSaldos(con);
        JdpEscritorio.add(s);
        s.show();
    }//GEN-LAST:event_JmSaldosActionPerformed

    private void BtnEntregaPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEntregaPedidosActionPerformed
        frmEntregaPedidos ep = new frmEntregaPedidos(con);
        JdpEscritorio.add(ep);
        ep.show();
    }//GEN-LAST:event_BtnEntregaPedidosActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        mostrarPedido();
        sumarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        imprimir i = new imprimir(con);
        Calendar fecha = Calendar.getInstance();
        int a,m,d;
        a = fecha.get(Calendar.YEAR);
        m = fecha.get(Calendar.MONTH) + 1;
        d = fecha.get(Calendar.DAY_OF_MONTH);
        //JOptionPane.showMessageDialog(null, a + "-" + m + "-" + d);
        
        i.imprimirReportesDia(a + "-" + m + "-" + d);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jmSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmSalirMousePressed
        String [] registros;
        registros = funcU.buscarNotaUsuario(String.valueOf(DatosLogin.getNusuario()));
        
        if (registros == null) {
            datosN.setIdpersona(DatosLogin.getNusuario());
            datosN.setNota(txtNota.getText());
            //Si el registro es nulo, entonces insertamos una ntoa para el usuario
            if (!funcU.insertarNota(datosN)) {
                JOptionPane.showMessageDialog(null, "No se pudo insertar la nota");
            }
        }else{
            //Si el registro no es nulo, modificamos la nota que habia
            datosN.setIdnota(Integer.parseInt(lblIdNota.getText()));
            datosN.setIdpersona(DatosLogin.getNusuario());
            datosN.setNota(txtNota.getText());
            if(!funcU.modificarNota(datosN)){
             JOptionPane.showMessageDialog(null, "No se pudo cargar la nota");
            }
        }
        
        System.exit(0);
    }//GEN-LAST:event_jmSalirMousePressed

    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEntregaPedidos;
    public static javax.swing.JDesktopPane JdpEscritorio;
    private javax.swing.JMenu JmClientes;
    private javax.swing.JMenuItem JmListaPP;
    private javax.swing.JMenuItem JmPedidoProv;
    private javax.swing.JMenu JmProveedor;
    private javax.swing.JMenuItem JmSaldos;
    private javax.swing.JMenu JmUsuarios;
    private javax.swing.JMenuItem JmiClientes;
    private javax.swing.JMenuItem JmiCrearPedido;
    private javax.swing.JMenuItem JmiListaClientes;
    private javax.swing.JMenuItem JmiListaPedidos;
    private javax.swing.JMenuItem JmiListaProductos;
    private javax.swing.JMenuItem JmiListaProveedores;
    private javax.swing.JMenuItem JmiListaUsuarios;
    private javax.swing.JMenuItem JmiProductos;
    private javax.swing.JMenuItem JmiProveedores;
    private javax.swing.JMenuItem JmiUsuarios;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu jmCambioUsuario;
    private javax.swing.JMenuItem jmModificaciones;
    private javax.swing.JMenu jmSalir;
    private javax.swing.JLabel lblFechaNota;
    private javax.swing.JLabel lblIdNota;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPresupuesto3;
    private javax.swing.JLabel lblPresupuesto4;
    private javax.swing.JLabel lblPresupuesto5;
    private javax.swing.JLabel lblPuesto;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JTable tblPedidoDia;
    private javax.swing.JTable tblPedidoProv;
    private javax.swing.JTextArea txtNota;
    // End of variables declaration//GEN-END:variables
}
