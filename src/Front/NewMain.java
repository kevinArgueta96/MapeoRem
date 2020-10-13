/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author argue
 */
public class NewMain {

    //public static void main(String[] args) {
     
    
    
   public static BufferedImage crearQR(String datos, int ancho, int altura) throws WriterException {
        BitMatrix matrix;
        Writer escritor = new QRCodeWriter();
        matrix = escritor.encode(datos, BarcodeFormat.QR_CODE, ancho, altura);
        
        BufferedImage imagen = new BufferedImage(ancho, altura, BufferedImage.TYPE_INT_RGB);
        
        for(int y = 0; y < altura; y++) {
            for(int x = 0; x < ancho; x++) {
                int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
                imagen.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
            }
        }
        
        return imagen;        
    }  
   
   
    public static void main(String[] args) throws IOException {
       
        try {
            Ventana ventana = new Ventana();
            
            ventana.setVisible(true);
            
        } catch (WriterException ex) {
            //Logger.getLogger(EjemploQR.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*Claves cla = new Claves();
        
        String clave=JOptionPane.showInputDialog(null, "Ingrese colntraseña");
        JOptionPane.showMessageDialog(null,cla.desncripta(clave));
        
        
        /*String cadena = "CERTREM-2020100083\n" + "281\n" + "Ente 17-12-2019\n" + "8532168\n" + "09/10/20\n" + "A\n";
        String clave="";
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        Key key = keyGenerator.generateKey();

   
        key = new SecretKeySpec("R!23E!AfaM12348$$".getBytes(), 0, 16, "AES");
        String texto = cadena;
        Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aes.init(Cipher.ENCRYPT_MODE, key);
        
        byte[] encriptado = aes.doFinal(texto.getBytes());
        clave =Base64.getEncoder().encodeToString(encriptado);
        
        System.out.println(clave);
        
        
        
        aes.init(Cipher.DECRYPT_MODE, key);
        byte [] ppp=Base64.getDecoder().decode(clave);
        byte[] desencriptado = aes.doFinal(ppp);
        System.out.println(new String(desencriptado));
        /*conexcion con = new conexcion();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        System.out.println(date);
       // System.out.println(fecha.getMonth());
        /*  try {
           
            CallableStatement cst = con.getConnection().prepareCall("{call db_rem.SPREM_SEC_CERTIFICADO(?)}");
            cst.registerOutParameter(1,java.sql.Types.VARCHAR);
         
            cst.execute();
            String nombre = cst.getString(1);
            System.out.println(nombre);
            //con.desconectar();
        } catch (Exception ex) {
            System.out.println(ex);

        }
    }
        
         */
     
    }
    public void desc(String prueba ){
       
        }
    }

