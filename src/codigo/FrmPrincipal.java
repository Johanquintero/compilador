/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package codigo;

import static codigo.Tokens.Division;
import static codigo.Tokens.ERROR;
import static codigo.Tokens.MeDueleLaCabeza;
import static codigo.Tokens.For;
import static codigo.Tokens.Identificador;
import static codigo.Tokens.DeUna;
import static codigo.Tokens.Igual;
import static codigo.Tokens.Linea;
import static codigo.Tokens.Llave_a;
import static codigo.Tokens.Llave_c;
import static codigo.Tokens.Relacion;
import static codigo.Tokens.Multiplicacion;
import static codigo.Tokens.Numero;
import static codigo.Tokens.P_coma;
import static codigo.Tokens.Parentesis_a;
import static codigo.Tokens.Parentesis_c;
import static codigo.Tokens.Resta;
import static codigo.Tokens.Suma;
import static codigo.Tokens.While;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

/**
 *
 * @author Johan
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void analizarLexico() throws IOException{
        int cont = 1;
        
        String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA "+ cont + "\t\tSIMBOLO\n";

        while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    resultado += "FIN";
                    txtAnalizarLex.setText(resultado);
                    return;
                }
              switch (tokens) {
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexer.lexeme + "\n";
                    break;
                case Cadena:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case T_dato:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case DeUna:
                    resultado += "  <Reservada if>\t" + lexer.lexeme + "\n";
                    break;
                case MeDueleLaCabeza:
                    resultado += "  <Reservada else>\t" + lexer.lexeme + "\n";
                    break;
                case Do:
                    resultado += "  <Reservada do>\t" + lexer.lexeme + "\n";
                    break;
                case While:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    break;
                case For:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexer.lexeme + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador suma>\t" + lexer.lexeme + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t" + lexer.lexeme + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexer.lexeme + "\n";
                    break;
                case Op_logico:
                    resultado += "  <Operador logico>\t" + lexer.lexeme + "\n";
                    break;
                case Op_incremento:
                    resultado += "  <Operador incremento>\t" + lexer.lexeme + "\n";
                    break;
                case Op_relacional:
                    resultado += "  <Operador relacional>\t" + lexer.lexeme + "\n";
                    break;
                case Op_atribucion:
                    resultado += "  <Operador atribucion>\t" + lexer.lexeme + "\n";
                    break;
                case Op_booleano:
                    resultado += "  <Operador booleano>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_a:
                    resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_c:
                    resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_a:
                    resultado += "  <Llave de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_c:
                    resultado += "  <Llave de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Corchete_a:
                    resultado += "  <Corchete de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Corchete_c:
                    resultado += "  <Corchete de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Relacion:
                    resultado += "  <Reservada main>\t" + lexer.lexeme + "\n";
                    break;
                case P_coma:
                    resultado += "  <Punto y coma>\t" + lexer.lexeme + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
            }
   
    }
    
    private void analizarSin(){
        String ST = txtResultado.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        try {
            s.parse();
            txtAnalizarSin.setText("Analisis realzado correctammente");
            txtAnalizarSin.setForeground(Color.white);
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis. Linea: "+ (sym.right + 1) + "Column: "+ (sym.left + 1) + ",Texto: \"" + sym.value +"\"" ); 
            txtAnalizarSin.setForeground(Color.red);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAnalizarSin = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        btnArchivo = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizaro Sintactico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        btnAnalizarSin.setBackground(new java.awt.Color(102, 204, 255));
        btnAnalizarSin.setForeground(new java.awt.Color(255, 255, 255));
        btnAnalizarSin.setText("Analizar");
        btnAnalizarSin.setBorder(null);
        btnAnalizarSin.setBorderPainted(false);
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });

        txtAnalizarSin.setEditable(false);
        txtAnalizarSin.setBackground(new java.awt.Color(0, 0, 0));
        txtAnalizarSin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAnalizarSin.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(txtAnalizarSin);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(btnAnalizarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAnalizarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Lexico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        btnArchivo.setBackground(new java.awt.Color(102, 204, 255));
        btnArchivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnArchivo.setForeground(new java.awt.Color(255, 255, 255));
        btnArchivo.setText("Abrir Archivo");
        btnArchivo.setBorder(null);
        btnArchivo.setBorderPainted(false);
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        btnAnalizar.setBackground(new java.awt.Color(102, 204, 255));
        btnAnalizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAnalizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAnalizar.setText("Analizar");
        btnAnalizar.setToolTipText("");
        btnAnalizar.setBorder(null);
        btnAnalizar.setBorderPainted(false);
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        txtResultado.setBackground(new java.awt.Color(0, 0, 0));
        txtResultado.setForeground(new java.awt.Color(255, 255, 255));
        txtResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtResultadoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtResultadoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtResultado);

        txtAnalizarLex.setBackground(new java.awt.Color(0, 0, 0));
        txtAnalizarLex.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(txtAnalizarLex);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        try {
            analizarLexico();
//        File archivo = new File("archivo.txt");
//        PrintWriter escribir;
//        try {
//            escribir = new PrintWriter(archivo);
//            escribir.print(txtAnalizarLex.getText());
//            escribir.close();
//        } catch (FileNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
//        try {
//            Reader lector = new BufferedReader(new FileReader("archivo.txt"));
//            Lexer lexer = new Lexer(lector);
//            String resultado = "";
//            while (true) {
//                Tokens tokens = lexer.yylex();
//                if (tokens == null) {
//                    resultado += "FIN";
//                    txtResultado.setText(resultado);
//                    return;
//                }
//                switch  (tokens){
//                    case ERROR -> {
//                        resultado += "Simbolo no definido\n";
//                        break;
//                    }
//                    case Int -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Float -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Bool -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case String -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Number -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case If -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Else -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Try -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Catch -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case For -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Const -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Let -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Var -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case While -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Linea -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Igual -> {
//                        resultado +=  lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Suma -> {
//                        resultado += lexer.lexeme + ": Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Resta -> {
//                        resultado += lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Multiplicacion -> {
//                        resultado += lexer.lexeme +" : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Division -> {
//                        resultado += lexer.lexeme + " : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Diferencia -> {
//                        resultado += lexer.lexeme + ": Es una " + tokens + "\n";
//                        break;
//                    }
//                    case Menor -> {
//                        resultado += lexer.lexeme +" : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Mayor -> {
//                        resultado += lexer.lexeme +" : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case P_coma -> {
//                        resultado += lexer.lexeme +" : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Parentesis_a -> {
//                        resultado += lexer.lexeme +" : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Parentesis_c -> {
//                        resultado += lexer.lexeme +" : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Llave_a -> {
//                        resultado += lexer.lexeme +" : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Llave_c -> {
//                        resultado += lexer.lexeme +" : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Main -> {
//                        resultado += lexer.lexeme +" : Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Identificador -> {
//                        resultado += lexer.lexeme + ": Es un " + tokens + "\n";
//                        break;
//                    }
//                    case Numero -> {
//                        resultado += lexer.lexeme + ": Es un " + tokens + "\n";
//                        break;
//                    }
//                    default -> {
//                        resultado += "Token: " + tokens + "\n";
//                        break;
//                    }
//                }
//            }
//        } catch (FileNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try{
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
        analizarSin();
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

    private void txtResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtResultadoKeyPressed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtResultadoKeyPressed

    private void txtResultadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtResultadoKeyReleased
         analizarSin();
    }//GEN-LAST:event_txtResultadoKeyReleased

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane txtAnalizarLex;
    private javax.swing.JTextPane txtAnalizarSin;
    private javax.swing.JTextPane txtResultado;
    // End of variables declaration//GEN-END:variables
}
