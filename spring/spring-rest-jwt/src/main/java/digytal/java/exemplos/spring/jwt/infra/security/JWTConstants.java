package digytal.java.exemplos.spring.jwt.infra.security;

public class JWTConstants {
	public static final String KEY = "SECRET_KEY";
	public static final String PREFIX = "Bearer ";
	public static final long TOKEN_EXPIRATION =  1 * 60 * 60 * 1000;
}
