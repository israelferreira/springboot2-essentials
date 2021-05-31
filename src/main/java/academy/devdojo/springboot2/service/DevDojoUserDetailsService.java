package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.repository.DevDojoUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DevDojoUserDetailsService implements UserDetailsService {
	
	private final DevDojoUserRepository devDojoUserRepository;

    public DevDojoUserDetailsService(DevDojoUserRepository devDojoUserRepository) {
        this.devDojoUserRepository = devDojoUserRepository;
    }

    @Override
	public UserDetails loadUserByUsername(String username) {
		return Optional.ofNullable(devDojoUserRepository.findByUsername(username))
				.orElseThrow(() -> new UsernameNotFoundException("DevDojo User not found"));
	}

}
