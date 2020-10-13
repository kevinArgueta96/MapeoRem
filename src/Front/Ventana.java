/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front;
import com.google.zxing.WriterException;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author kjarguetab
 */
public class Ventana extends JFrame {
    public Ventana() throws WriterException, IOException {
        NewMain generaQR = new NewMain();
        //BufferedImage imagen = generaQR.crearQR("HOLA COMO ESTAS", 300, 300);
        BufferedImage imagen = ImageIO.read(new FileInputStream("diseño/logo.png"));
        
        ImageIcon icono = new ImageIcon(imagen);
        
        JLabel etiqueta = new JLabel("");
        
        
        etiqueta.setIcon(icono);
        
        this.setIconImage(imagen);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Ejemplo de codigo QR");
        this.getContentPane().add(etiqueta);
        this.pack(); 
        //this.setVisible(true);
    }
}
