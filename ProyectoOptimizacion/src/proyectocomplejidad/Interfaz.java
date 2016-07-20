package proyectocomplejidad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import lpsolve.LpSolveException;

public class Interfaz extends javax.swing.JFrame {

    /*Variables globales*/
    int numeroCajas = 0;
    double[] pesosCajas = null;
    double[] volumenesCajas = null;
    int[] numerosCaja = null;
    double pesoMorral = 0;
    double volumenMorral = 0;

    ProyectoComplejidad modelo;

    DefaultTableModel modelMorral;
    DefaultTableModel modelCaja;
    DefaultTableModel modelResultado;
    DefaultTableModel modelResultado2;

    int[] morrales = null;
    int[] morrales2 = null;
    String[] cajasEnMorrales = null;
    String[] cajasEnMorrales2 = null;
    double valorFO = 0;
    int tamanoArregloResultado = 0;
    int tamanoArregloResultado2 = 0;
    //Arreglos donde cada pos es una columna de la tabla
    String datosResultado[] = null;
    String datosResultado2[] = null;
    //arreglos que guardan lo que devuelve modelar() de la clase Modelo y Modelo2
    String resultadoModelo[] = null;
    String resultadoModelo2[] = null;

    //Arreglo que guarda en cada pos la cadena de la distribucion de cajas en el morral de pos i+1. Para calcular abs
    String ordenMorrales[] = null;
    String ordenMorrales2[] = null;
    int indiceordenMorrales = 0;
    int indiceordenMorrales2 = 0;
    //Para calcular los valores de abs  y mandarselo a la clase que construye el modelo 2
    int pesoTotalMorral1 = 0;
    int diferencias[] = null;//arreglo que almacena (cada diferencia del peso del morral 1 con el morral igual a numero de pos)= (cada abs)

    /*Constructor*/
    @SuppressWarnings("empty-statement")
    public Interfaz() {
        modelo = new ProyectoComplejidad();
        initComponents();
        this.setTitle("Optimizacion Morrales");
        centrar_datos();
        modelCaja = (DefaultTableModel) tablaCaja.getModel();
        modelResultado = (DefaultTableModel) tablaResultado.getModel();

    }

    public void centrar_datos() {

        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        tablaCaja.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        tablaCaja.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
        tablaCaja.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rutArchivo = new javax.swing.JTextField();
        examinarArchivo = new javax.swing.JButton();
        Calcular = new javax.swing.JButton();
        funcionobjetivolabel = new javax.swing.JLabel();
        resultado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tiempoejecucionlabel1 = new javax.swing.JLabel();
        limpiarTabla = new javax.swing.JButton();
        tiempoEje = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCaja = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaResultado = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulacion ascensor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Problema Cosecha");

        rutArchivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        examinarArchivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        examinarArchivo.setText("Examinar");
        examinarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarArchivoActionPerformed(evt);
            }
        });

        Calcular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Calcular.setText("Calcular");
        Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularActionPerformed(evt);
            }
        });

        funcionobjetivolabel.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        funcionobjetivolabel.setForeground(new java.awt.Color(102, 102, 102));
        funcionobjetivolabel.setText("Utilidad máxima");
        funcionobjetivolabel.setToolTipText("Total minimo de morrales");

        resultado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Temperatura, precipitación y demandas máxima y mínima");

        labelPrecio.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        labelPrecio.setForeground(new java.awt.Color(102, 102, 102));
        labelPrecio.setText("Precio de las papas =");

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Meses de coseca");

        tiempoejecucionlabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        tiempoejecucionlabel1.setForeground(new java.awt.Color(102, 102, 102));
        tiempoejecucionlabel1.setText("Tiempo de ejecucion");

        limpiarTabla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        limpiarTabla.setText("Limpiar datos");
        limpiarTabla.setToolTipText("Limpiar una fila de las tablas");
        limpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarTablaActionPerformed(evt);
            }
        });

        tiempoEje.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tablaCaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mes", "Precipitación", "Temperatura", "Demanda max", "Demanda min"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCaja.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaCaja);
        if (tablaCaja.getColumnModel().getColumnCount() > 0) {
            tablaCaja.getColumnModel().getColumn(0).setResizable(false);
            tablaCaja.getColumnModel().getColumn(1).setResizable(false);
            tablaCaja.getColumnModel().getColumn(2).setResizable(false);
            tablaCaja.getColumnModel().getColumn(3).setResizable(false);
            tablaCaja.getColumnModel().getColumn(4).setResizable(false);
        }

        jScrollPane5.setViewportView(jScrollPane1);

        tablaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaResultado.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tablaResultado);
        if (tablaResultado.getColumnModel().getColumnCount() > 0) {
            tablaResultado.getColumnModel().getColumn(0).setResizable(false);
        }

        jScrollPane6.setViewportView(jScrollPane4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rutArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(examinarArchivo)
                        .addGap(320, 320, 320))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(funcionobjetivolabel)
                                    .addComponent(resultado)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(352, 352, 352)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(limpiarTabla)
                                        .addGap(38, 38, 38)
                                        .addComponent(Calcular))
                                    .addComponent(tiempoejecucionlabel1)
                                    .addComponent(tiempoEje, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(examinarArchivo))
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labelPrecio)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(limpiarTabla)
                            .addComponent(Calcular))
                        .addGap(32, 32, 32)
                        .addComponent(tiempoejecucionlabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tiempoEje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(funcionobjetivolabel)
                        .addGap(18, 18, 18)
                        .addComponent(resultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel4);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarTablaActionPerformed

        this.tiempoEje.setText("");

        for (int x = 0; x < tablaCaja.getRowCount(); x++) {
            this.modelCaja.removeRow(x);

        }

        for (int x = 0; x < tablaResultado.getRowCount(); x++) {
            this.modelResultado.removeRow(x);

        }

        resultado.setText("");
    }//GEN-LAST:event_limpiarTablaActionPerformed

    private void CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularActionPerformed

        //MODELO 1******************************************************************
        ejecutarModelo1();
    }//GEN-LAST:event_CalcularActionPerformed

    private void examinarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarArchivoActionPerformed

        String aux_temperatura, aux_precipitacion, aux_demanda_minima, aux_demanda_maxima = "";

        JFileChooser dialogo = new JFileChooser();
        int opcion = dialogo.showOpenDialog(this);

        if (opcion == JFileChooser.APPROVE_OPTION) {

            tablaCaja.removeAll();
            String ruta = dialogo.getSelectedFile().getPath();
            rutArchivo.setText(ruta);
            File archivo = dialogo.getSelectedFile();
            FileReader filer = null;
            BufferedReader buffer = null;

            try {

                FileReader f = new FileReader(ruta);
                BufferedReader b = new BufferedReader(f);
                modelo.setMeses(Integer.parseInt(b.readLine()));

                int vector_temperatura[] = new int[modelo.getMeses()];
                int vector_precipitacion[] = new int[modelo.getMeses()];
                int vector_demanda_minima[] = new int[modelo.getMeses()];
                int vector_demanda_maxima[] = new int[modelo.getMeses()];

                aux_temperatura = b.readLine();
                aux_precipitacion = b.readLine();
                aux_demanda_minima = b.readLine();
                aux_demanda_maxima = b.readLine();
                modelo.setProduccion_estimada(Integer.parseInt(b.readLine()));
                modelo.setValor_bulto(Integer.parseInt(b.readLine()));

                //Dividir las lineas de temperatura, precicipation y demandas en tokens para poder trabajar con ellos individualemnte
                StringTokenizer tokens_t = new StringTokenizer(aux_temperatura);
                StringTokenizer tokens_p = new StringTokenizer(aux_precipitacion);
                StringTokenizer tokens_dmin = new StringTokenizer(aux_demanda_minima);
                StringTokenizer tokens_dmax = new StringTokenizer(aux_demanda_maxima);

                for (int i = 0; i < modelo.getMeses(); i++) {

                    vector_temperatura[i] = Integer.parseInt(tokens_t.nextToken());
                    vector_precipitacion[i] = Integer.parseInt(tokens_p.nextToken());
                    vector_demanda_minima[i] = Integer.parseInt(tokens_dmin.nextToken());
                    vector_demanda_maxima[i] = Integer.parseInt(tokens_dmax.nextToken());

                }

                Integer[] datos = new Integer[5];
                for (int i = 0; i < modelo.getMeses(); i++) {

                    datos[0] = i + 1;
                    datos[1] = vector_temperatura[i];
                    datos[2] = vector_precipitacion[i];
                    datos[3] = vector_demanda_minima[i];
                    datos[4] = vector_demanda_maxima[i];
                    modelCaja.addRow(datos);

                }

                modelo.setVector_demanda_minima(vector_demanda_minima);
                modelo.setVector_demanda_maxima(vector_demanda_maxima);
                modelo.setVector_precipitacion(vector_precipitacion);
                modelo.setVector_temperatura(vector_temperatura);

                labelPrecio.setText("Precio de las papas = $" + modelo.getValor_bulto());

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

    }//GEN-LAST:event_examinarArchivoActionPerformed

    private void ejecutarModelo1() {

        long time = System.currentTimeMillis();
        modelo.Preprocesamiento();
        modelo.Solucionar();

        time = System.currentTimeMillis() - time;

        tiempoEje.setText(time + " ms");

        resultado.setText(conversion(modelo.getGanancia()));

        Double datos[] = new Double[1];
        double sol[] = modelo.getVar_sol();
        for (int i = 0; i < modelo.getMeses(); i++) {

            if (sol[i] != 0.0) {
                datos[0] = (double) i + 4;
                modelResultado.addRow(datos);
            }

        }
        
        escribirResultado();
    }

    public void escribirResultado() {

        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("resultados.txt");
            pw = new PrintWriter(fichero);

            pw.println("" + conversion(modelo.getGanancia()));
            pw.println("" + sumaMeses());

            double sol[] = modelo.getVar_sol();

            for (int i = 0; i < modelo.getMeses(); i++) {

                if (sol[i] != 0.0) {
                    int num = i + 4;
                    pw.println("" + num);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public int sumaMeses() {

        int meses = 0;
        double sol[] = modelo.getVar_sol();
        for (int i = 0; i < modelo.getMeses(); i++) {
            meses += sol[i];
        }

        return meses;

    }

    public String conversion(double valor) {
        Locale.setDefault(Locale.US);
        DecimalFormat num = new DecimalFormat("#,###.00");
        return num.format(valor);
    }

    public static void main(String args[]) {

        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Calcular;
    private javax.swing.JButton examinarArchivo;
    private javax.swing.JLabel funcionobjetivolabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JButton limpiarTabla;
    private javax.swing.JTextField resultado;
    private javax.swing.JTextField rutArchivo;
    private javax.swing.JTable tablaCaja;
    private javax.swing.JTable tablaResultado;
    private javax.swing.JTextField tiempoEje;
    private javax.swing.JLabel tiempoejecucionlabel1;
    // End of variables declaration//GEN-END:variables

    public int calcularPesoMorral(String cajas) {
        double totalPesoMorral = 0;
        String cajasdeMorral[] = new String[numeroCajas];
        cajasdeMorral = cajas.split(";");
        for (int i = 0; i < cajasdeMorral.length; i++) {
            int numeroCaja = Integer.parseInt(cajasdeMorral[i].substring(5, cajasdeMorral[i].length()));
            totalPesoMorral += pesosCajas[numeroCaja - 1];
//            System.out.println("Arreglo cajas de Morral " + cajasdeMorral[i]
//                    + " Peso de caja " + numeroCaja + " = " +pesosCajas[numeroCaja-1]
//                    + " Peso total Morral " + totalPesoMorral
//          );

        }
        return (int) totalPesoMorral;
    }

}
