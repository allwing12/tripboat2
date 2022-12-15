package tripboat.tripboat1.Util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordUtils {
    public static boolean equls(String plaintext, String hashed) {
        if(plaintext == null || plaintext.length() < 1) {
            return false;
        }
        if(hashed == null || hashed.length() < 1) {
            return false;
        }
        return BCrypt.checkpw(plaintext, hashed);
    }
    public static String encPassword(String planintext) {
        if(planintext == null || planintext.length() < 1) {
            return "";
        }
        return BCrypt.hashpw(planintext,BCrypt.gensalt());
    }
}
