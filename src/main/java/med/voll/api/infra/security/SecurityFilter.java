package med.voll.api.infra.security;

<<<<<<< HEAD

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
=======
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.domain.DTOusuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

<<<<<<< HEAD
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);

        if (tokenJWT != null) {
=======
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        var tokenJWT = recuperarToken(request);

        if (tokenJWT != null){
>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf
            var subject = tokenService.getSubject(tokenJWT);
            var usuario = repository.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
<<<<<<< HEAD

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }

=======
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request){
        var authorization = request.getHeader("Authorization");
        if (authorizationHeader != null);{
            return authorizationHeader.replace("Bearer", "");
        }
>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf
        return null;
    }

}
