package guru.sfg.brewery.configs;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestHeaderAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public RestHeaderAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,
                                                HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {
        String key = httpServletRequest.getHeader("api-key");
        String secret = httpServletRequest.getHeader("api-secret");
        if (key == null) {
            key = "";
        }
        if (secret == null) {
            secret = "";
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(key, secret);
        return this.getAuthenticationManager().authenticate(token);
    }
}
