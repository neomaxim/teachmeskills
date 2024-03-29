package auto.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Authorities {

    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    public boolean isAdmin() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).anyMatch(ADMIN::equals);
    }

}