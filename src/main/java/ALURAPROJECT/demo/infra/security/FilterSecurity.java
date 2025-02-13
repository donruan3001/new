package ALURAPROJECT.demo.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@Component
public class FilterSecurity extends OncePerRequestFilter{
    @Autowired
    private TokenService tokenService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
      var tokenJwt = recuperarToken(request);
      var subject= tokenService.getSubject(tokenJwt);

      System.out.println(subject);
        filterChain.doFilter(request, response);
    }

    public String recuperarToken(HttpServletRequest request){
    var headerAutorization= request.getHeader("Authorization");
    if (headerAutorization==null)throw new RuntimeException("Token JWT não enviado ");

    return headerAutorization;
}


}
