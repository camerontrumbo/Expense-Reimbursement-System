package security;

public interface Salt {
    String getSalt(String phrase);
    Boolean checkPass(String password, String hashedPassword);
}
