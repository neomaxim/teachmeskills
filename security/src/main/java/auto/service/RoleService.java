package auto.service;



import auto.entity.Role;

import java.util.Optional;

public interface RoleService {


    Optional<Role> findByName(String name);
}