package academy.devdojo.springboot2.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
public class DevDojoUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "The user's name cannot be empty")
	private String name;
	private String username;
	private String password;
	private String authorities;

    public DevDojoUser(Long id, @NotEmpty(message = "The user's name cannot be empty") String name, String username, String password, String authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public DevDojoUser() {
    }

    public static DevDojoUserBuilder builder() {
        return new DevDojoUserBuilder();
    }

    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(authorities.split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {		
		return this.password;
	}

	@Override
	public String getUsername() {		
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {		
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

    public Long getId() {
        return this.id;
    }

    public @NotEmpty(message = "The user's name cannot be empty") String getName() {
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(@NotEmpty(message = "The user's name cannot be empty") String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof DevDojoUser)) return false;
        final DevDojoUser other = (DevDojoUser) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$authorities = this.getAuthorities();
        final Object other$authorities = other.getAuthorities();
        if (this$authorities == null ? other$authorities != null : !this$authorities.equals(other$authorities))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DevDojoUser;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $authorities = this.getAuthorities();
        result = result * PRIME + ($authorities == null ? 43 : $authorities.hashCode());
        return result;
    }

    public String toString() {
        return "DevDojoUser(id=" + this.getId() + ", name=" + this.getName() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", authorities=" + this.getAuthorities() + ")";
    }

    public static class DevDojoUserBuilder {
        private Long id;
        private @NotEmpty(message = "The user's name cannot be empty") String name;
        private String username;
        private String password;
        private String authorities;

        DevDojoUserBuilder() {
        }

        public DevDojoUserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DevDojoUserBuilder name(@NotEmpty(message = "The user's name cannot be empty") String name) {
            this.name = name;
            return this;
        }

        public DevDojoUserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public DevDojoUserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public DevDojoUserBuilder authorities(String authorities) {
            this.authorities = authorities;
            return this;
        }

        public DevDojoUser build() {
            return new DevDojoUser(id, name, username, password, authorities);
        }

        public String toString() {
            return "DevDojoUser.DevDojoUserBuilder(id=" + this.id + ", name=" + this.name + ", username=" + this.username + ", password=" + this.password + ", authorities=" + this.authorities + ")";
        }
    }
}
