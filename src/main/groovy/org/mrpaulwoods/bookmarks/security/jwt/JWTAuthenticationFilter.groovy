package org.mrpaulwoods.bookmarks.security.jwt

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.util.logging.Slf4j
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.mrpaulwoods.bookmarks.security.User
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static org.mrpaulwoods.bookmarks.security.jwt.SecurityConstants.*

@Slf4j
class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager

    JWTAuthenticationFilter(
            AuthenticationManager authenticationManager
    ) {
        this.authenticationManager = authenticationManager
    }

    @Override
    Authentication attemptAuthentication(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws AuthenticationException {

        try {
            User creds = new ObjectMapper()
                    .readValue(req.getInputStream(), User.class)

            log.info "attemptAuthentication(creds:$creds)"

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(), creds.getPassword(), [])
            )

            log.info "success. authentication=$authentication"

            authentication

        } catch (IOException e) {

            log.info "failed"

            throw new RuntimeException(e)
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain,
            Authentication auth
    ) throws IOException, ServletException {

        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact()

        log.info "successfulAuthentication. token=$token"

        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token)
    }

}
