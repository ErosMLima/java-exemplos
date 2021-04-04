package digytal.java.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		JWTObject object = JWTUtils.object(request.getHeader(JWTUtils.HEADER));
		
		UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(object.getSubject(), null, new ArrayList<>());

        SecurityContextHolder.getContext().setAuthentication(userToken);
        filterChain.doFilter(request, response);
		
	}

}
