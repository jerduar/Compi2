package proyecto_lienzo;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;

//IMPORTANDO EL LIENZO
import Lienzo.Lienzo;
import java.awt.Desktop;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jerduar
 */
public class LienzoEdit extends javax.swing.JFrame {

    /**
     * Creates new form LienzoEdit
     */
    Lienzo lienzo;

    public LienzoEdit() {
        initComponents();
        setearIconoBotones();

        //INICIALIZANDO EL ADMINISTRADOR DE ARCHIVOS
        jFileChooser1 = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos LZ", "lz");
        jFileChooser1.setFileFilter(filter);

        //INICIALIZANDO EL LIENZO
        lienzo = new Lienzo();
        lienzo.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        bt_play = new javax.swing.JButton();
        bt_debbug = new javax.swing.JButton();
        bt_error = new javax.swing.JButton();
        jSlider2 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panel_tab = new javax.swing.JTabbedPane();
        lb_fila_columna = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        nueva_pestaña_menuItem = new javax.swing.JMenuItem();
        Abrir_menuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        guardar_menuItem = new javax.swing.JMenuItem();
        guardar_como_menuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Salir_menuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lienzo Edit");
        setName("LienzoEdit"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bt_play.setContentAreaFilled(false);
        bt_play.setSelected(true);
        bt_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_playActionPerformed(evt);
            }
        });

        bt_debbug.setContentAreaFilled(false);
        bt_debbug.setSelected(true);
        bt_debbug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_debbugActionPerformed(evt);
            }
        });

        bt_error.setContentAreaFilled(false);
        bt_error.setSelected(true);

        jLabel1.setText("Ejecutar");

        jLabel2.setText("Debugger");

        jLabel3.setText("Velocidad Debugger");

        jLabel4.setText("Reporte de Errores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_play, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_debbug, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(bt_error, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bt_debbug, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_play, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSlider2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)))
        );

        panel_tab.setAutoscrolls(true);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Nuevo Archivo");
        jMenu1.add(jMenuItem1);

        nueva_pestaña_menuItem.setText("Nueva Pestaña");
        nueva_pestaña_menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueva_pestaña_menuItemActionPerformed(evt);
            }
        });
        jMenu1.add(nueva_pestaña_menuItem);

        Abrir_menuItem.setText("Abrir");
        Abrir_menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Abrir_menuItemActionPerformed(evt);
            }
        });
        jMenu1.add(Abrir_menuItem);
        jMenu1.add(jSeparator1);

        guardar_menuItem.setText("Guardar");
        guardar_menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_menuItemActionPerformed(evt);
            }
        });
        jMenu1.add(guardar_menuItem);

        guardar_como_menuItem.setText("Guardar Como");
        guardar_como_menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_como_menuItemActionPerformed(evt);
            }
        });
        jMenu1.add(guardar_como_menuItem);
        jMenu1.add(jSeparator2);

        Salir_menuItem.setText("Salir");
        Salir_menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salir_menuItemActionPerformed(evt);
            }
        });
        jMenu1.add(Salir_menuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Herramientas");

        jMenuItem6.setText("Ejecutar");
        jMenu2.add(jMenuItem6);

        jMenuItem8.setText("Debugger");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Tabla de Símbolos");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Errores");

        jMenuItem7.setText("Mostrar Errores");
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_tab)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_fila_columna, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(panel_tab, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_fila_columna)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Salir_menuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir_menuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Salir_menuItemActionPerformed

    private void bt_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_playActionPerformed
        TextEdit t = (TextEdit) panel_tab.getSelectedComponent();
        if (t != null) {
            JTextArea text = t.getNueva();
            Ejecutar e = new Ejecutar(0);
            try {
                e.Compilar(text.getText(), lienzo);
            } catch (IOException ex) {
                Logger.getLogger(LienzoEdit.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(LienzoEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bt_playActionPerformed

    private void bt_debbugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_debbugActionPerformed
        TextEdit t = (TextEdit) panel_tab.getSelectedComponent();
        if (t != null) {
            int retardo = 20 * jSlider2.getValue();
            JTextArea text = t.getNueva();
            Ejecutar e = new Ejecutar(retardo);
            try {
                e.Compilar(text.getText(), lienzo);
            } catch (IOException ex) {
                Logger.getLogger(LienzoEdit.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(LienzoEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bt_debbugActionPerformed

    private void nueva_pestaña_menuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueva_pestaña_menuItemActionPerformed
        TextEdit comp = (TextEdit) panel_tab.add("Nuevo", new TextEdit(""));
        PosicionCursor(comp.getNueva());
    }//GEN-LAST:event_nueva_pestaña_menuItemActionPerformed

    private void Abrir_menuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Abrir_menuItemActionPerformed
        try {
            AbrirArchivo();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LienzoEdit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LienzoEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Abrir_menuItemActionPerformed

    private void guardar_como_menuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_como_menuItemActionPerformed
        try {
            GuardarComo();
        } catch (IOException ex) {
            Logger.getLogger(LienzoEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guardar_como_menuItemActionPerformed

    private void guardar_menuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_menuItemActionPerformed
        try {
            Guardar();
        } catch (IOException ex) {
            Logger.getLogger(LienzoEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guardar_menuItemActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        TextEdit t = (TextEdit) panel_tab.getSelectedComponent();
        if (t != null) {
            JTextArea text = t.getNueva();
            Ejecutar e = new Ejecutar(0);
            try {
                e.Compilar(text.getText(), lienzo);
            } catch (IOException ex) {
                Logger.getLogger(LienzoEdit.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(LienzoEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        try {
            File path = new File("tabla_simbolo.html");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    //MÉTODO PARA ABRIR ARCHIVO
    private void AbrirArchivo() throws FileNotFoundException, IOException {
        jFileChooser1.showOpenDialog(this);
        File archivo = jFileChooser1.getSelectedFile();
        String texto = "";

        if (archivo != null) {
            FileReader file = new FileReader(archivo);
            try (BufferedReader buffer = new BufferedReader(file)) {
                String aux;
                while ((aux = buffer.readLine()) != null) {
                    texto += aux + "\n";
                }

                TextEdit nueva = new TextEdit(texto);
                panel_tab.add(archivo.getName(), nueva);
                panel_tab.getSelectedComponent().setName(archivo.getAbsolutePath());
                PosicionCursor(nueva.getNueva());
            }
        }
    }

    //MÉTODO PARA GUARDAR
    private void Guardar() throws IOException {
        if (panel_tab.getSelectedComponent() != null) {
            String path = panel_tab.getSelectedComponent().getName();
            String texto = ((TextEdit) panel_tab.getSelectedComponent()).getNueva().getText();
            try (FileWriter file = new FileWriter(path)) {
                file.write(texto);
            }
        }
    }

    //MÉTODO PARA GUARDAR COMO
    private void GuardarComo() throws IOException {
        JTextArea doc = (JTextArea) panel_tab.getSelectedComponent();
        if (doc != null) {
            jFileChooser1.showSaveDialog(this);
            File file = jFileChooser1.getSelectedFile();
            panel_tab.setTitleAt(panel_tab.getSelectedIndex(), file.getName());
            panel_tab.getSelectedComponent().setName(file.getAbsolutePath());

            if (file != null) {
                try (FileWriter archivo = new FileWriter(file + ".lz")) {
                    archivo.write(doc.getText());
                }
            }
        }
    }

    //MÉTODO PARA SETER ÍCONOS A LOS BOTONES
    private void setearIconoBotones() {
        ImageIcon fot = new ImageIcon("boton_play.png");
        ImageIcon fot2 = new ImageIcon("debbug.png");
        ImageIcon fot3 = new ImageIcon("error.png");

        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(bt_play.getWidth(), bt_play.getHeight(), Image.SCALE_DEFAULT));
        Icon icono2 = new ImageIcon(fot2.getImage().getScaledInstance(bt_debbug.getWidth(), bt_debbug.getHeight(), Image.SCALE_DEFAULT));
        Icon icono3 = new ImageIcon(fot3.getImage().getScaledInstance(bt_error.getWidth(), bt_error.getHeight(), Image.SCALE_DEFAULT));

        bt_play.setIcon(icono);
        bt_debbug.setIcon(icono2);
        bt_error.setIcon(icono3);

        this.repaint();
    }

    //MÉTODO PARA LA POSICIÓN DEL CURSOR
    private void PosicionCursor(JTextArea textarea) {
        textarea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                int linea = 1;
                int columna = 1;

                try {
                    int caretpos = textarea.getCaretPosition();
                    linea = textarea.getLineOfOffset(caretpos);
                    columna = caretpos - textarea.getLineStartOffset(linea);

                    linea += 1;
                    lb_fila_columna.setText("Fila: " + linea + " Columna: " + columna);
                } catch (Exception ex) {
                    System.err.println(ex.toString());
                }
            }

        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LienzoEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LienzoEdit().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir_menuItem;
    private javax.swing.JMenuItem Salir_menuItem;
    private javax.swing.JButton bt_debbug;
    private javax.swing.JButton bt_error;
    private javax.swing.JButton bt_play;
    private javax.swing.JMenuItem guardar_como_menuItem;
    private javax.swing.JMenuItem guardar_menuItem;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JLabel lb_fila_columna;
    private javax.swing.JMenuItem nueva_pestaña_menuItem;
    private javax.swing.JTabbedPane panel_tab;
    // End of variables declaration//GEN-END:variables
}