package digytal.java.security;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTUtils {
	public static final String KEY = "SECRET_KEY";
	public static final String PREFIX = "Bearer";
	public static final long TOKEN_EXPIRATION =  1 * 60 * 60 * 1000; //1 hora
	public static final String HEADER_AUTHORIZATION = "Authorization";
	
	public static String create(String subject, Date issuedAt, Date expriration) {
		
		String token = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(issuedAt)
                .setExpiration(expriration)
                .signWith(SignatureAlgorithm.HS512, KEY)
                .compact();
		return PREFIX + " " + token;
	}
	public static JWTObject object(String token) {
		JWTObject object = null;
		try {
			Claims claims = Jwts.parser()
					   .setSigningKey(KEY)
					   .parseClaimsJws(token)
					   .getBody();
			
			object = new JWTObject();
			
			object.setSubject(claims.getSubject());
			object.setExpiration(claims.getExpiration());
			object.setIssuedAt(claims.getIssuedAt());
			
			
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return object;
	
	}
}
