package Front;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 *
 * @author kjarguetab
 */
public class Claves {

    public String encripta(String datos) throws Exception {
        String clave = "";
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        Key key = keyGenerator.generateKey();

        key = new SecretKeySpec("R!23E!AfaM12348$$".getBytes(), 0, 16, "AES");
        Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aes.init(Cipher.ENCRYPT_MODE, key);

        byte[] encriptado = aes.doFinal(datos.getBytes());
        clave = Base64.getEncoder().encodeToString(encriptado);

        return clave;
    }

    public String desncripta(String datos) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        Key key = keyGenerator.generateKey();

        key = new SecretKeySpec("R!23E!AfaM12348$$".getBytes(), 0, 16, "AES");
        Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aes.init(Cipher.DECRYPT_MODE, key);

        byte[] byteencrip = Base64.getDecoder().decode(datos);
        byte[] desencriptado = aes.doFinal(byteencrip);
        
        return new String(desencriptado);
    }
}
