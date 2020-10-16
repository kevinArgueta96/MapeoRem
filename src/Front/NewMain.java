/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front;

import Logica.funciones;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTP;  
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author argue
 */
public class NewMain {

    public static void main(String[] args) throws Exception {
         /*Configuracion configuracion = new Configuracion();
    configuracion.leerFichero();

    configuracion.setIpHost(configuracion.arregloDatos[0]);
    configuracion.getIpHost();
    configuracion.setUser(configuracion.arregloDatos[1]);
    configuracion.getUser();
    configuracion.setPassword(configuracion.arregloDatos[2]);
    configuracion.getPassword();
    String ipHOST = configuracion.ipHost;
    String usuario = configuracion.user;
    String pass = configuracion.password;
*/
    FTPClient client = new FTPClient();

    String ftp = "128.5.7.11"; //
    File file1 = new File("D:\\prueba.txt");
    try{
        client.connect(ftp,22);
        boolean login = client.login("rbhd", "@Sistema$2019");
        if (login){
            
            client.changeWorkingDirectory("/test");//Cambiar directorio de trabajo
            System.out.println("Iniciando sesión Satisfactoriamente");
            int replay = client.getReplyCode();
            if (FTPReply.isPositiveCompletion(replay)){
                System.out.println("Subida a!");
                File file = new File("D:\\prueba.txt");
                FileInputStream input = new FileInputStream(file);
                /*client.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
                client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
                client.enterLocalPassiveMode();*/
                System.out.println("Subió satisfactoriamente el archivo");


                if (!client.storeFile(file.getName(),input)){
                    System.out.println("Subida fallida!");
                }
                input.close();
            }
   // Cuando cierras sesión el método logout regresa "true".
            boolean logout = client.logout();
            if (logout){
                System.out.println("Salir del servidor FTP");
            }
        }else{
            System.out.println("Falló inciar sesión");
        }
    }
    catch (Exception e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al subir fichero" +e);
    }
    finally{
        try{
            client.disconnect();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
   file1.delete();
  
        /*String[] s= new String[1];
        Claves fun =new Claves();
        String a=fun.desncripta("jYYpdKN62ojpkJ4conI1Xagu8oOiMRNK7l4Iea4avKbpAK4nCJJhqQzzP7HEchSSuWsy0LQSo2hpQ5VdtlqiGWpT8jcA5ugpVilsa9+41hh00Yw2huXttNE/ZEYe9NALomPEvQp22Yrbo1bHZZnvI/yjajd9jJUThVfobzupw1Y=", "?#Cs$#1!jv5:OzY!");
      //  s=fun.encripta(b, b, b, b, b);
        JOptionPane.showMessageDialog(null, a);
        
       /* String caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzñÑ!'#$%&/()=?¡:_;-,.";
        String password="";
        
        for (int x=0; x<10;x++){
            password+=(caracteres.charAt((int)(Math.random() * caracteres.length())));
        }
        JOptionPane.showMessageDialog(null, password);
        /*public static BufferedImage crearQR(String datos, int ancho, int altura) throws WriterException {
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
       
       
        
        
        /* try {
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

}
