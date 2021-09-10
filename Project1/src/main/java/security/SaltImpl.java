package security;

import org.mindrot.jbcrypt.BCrypt;

public class SaltImpl implements Salt{

    @Override
    public String getSalt(String phrase) {
        //Salting
        return BCrypt.hashpw(phrase, BCrypt.gensalt(10)).substring(0, 50);
    }

    @Override
    public Boolean checkPass(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
