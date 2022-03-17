package africa.ozi.files.filter;

import africa.ozi.files.data.models.PrinterUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Slf4j
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    private final ObjectMapper mapper;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
        this.mapper = new ObjectMapper();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try{
            PrinterUser user = mapper.readValue(request.getInputStream(),
                    PrinterUser.class);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken
                    (user.getUsername(), user.getPassword());
            return authenticationManager.authenticate(token);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return super.attemptAuthentication(request,response);
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authenticationResult){
        String jwtToken = JWT.create().withSubject(((User)authenticationResult.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()))
                .sign(Algorithm.HMAC256("beingsweetandwritingcode@395".getBytes()));
        response.addHeader("Authorization", jwtToken);
    }

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        String header = request.getHeader("Authentication");
        if ( header == null || !header.startsWith("Bearer") ) chain.doFilter(request, response);
        else SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(JWT.require(Algorithm.HMAC256("beingsweetandwritingcode@395"))
                .build().verify(header.replace("Bearer", "")).getSubject(), null, new ArrayList<>()));
    }
}
