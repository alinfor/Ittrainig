package af.cmr.indyli.akdemia.ws.service;

import af.cmr.indyli.akdemia.business.service.IUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Custom JWT authentication filter to process JWT tokens in the incoming requests.
 */
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	private final JwtService jwtService;
	private final IUserService userDetailsService;

	/**
	 * Constructor to initialize the JwtAuthFilter.
	 *
	 * @param jwtService        JwtService instance for handling JWT-related operations.
	 * @param userDetailsService IUserService instance for user details service.
	 */
	public JwtAuthFilter(JwtService jwtService, IUserService userDetailsService) {
		this.jwtService = jwtService;
		this.userDetailsService = userDetailsService;
	}

	/**
	 * Processes the incoming request to extract and validate the JWT token.
	 *
	 * @param request     HttpServletRequest instance representing the incoming request.
	 * @param response    HttpServletResponse instance representing the outgoing response.
	 * @param filterChain FilterChain instance for executing the next filter in the chain.
	 * @throws ServletException if an error occurs during servlet processing.
	 * @throws IOException      if an error occurs while reading or writing to the servlet.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String email = null;

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			email = jwtService.extractUsername(token);
		}

		if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(email);
			if (jwtService.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}

		filterChain.doFilter(request, response);
	}
}
