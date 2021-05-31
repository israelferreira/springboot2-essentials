package academy.devdojo.springboot2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Anime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "The anime name cannot be empty")
	private String name;

	public Anime(Long id, @NotEmpty(message = "The anime name cannot be empty") String name) {
		this.id = id;
		this.name = name;
	}

	public Anime() {
	}

	public static AnimeBuilder builder() {
		return new AnimeBuilder();
	}

	public Long getId() {
		return this.id;
	}

	public @NotEmpty(message = "The anime name cannot be empty") String getName() {
		return this.name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(@NotEmpty(message = "The anime name cannot be empty") String name) {
		this.name = name;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof Anime)) return false;
		final Anime other = (Anime) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$id = this.getId();
		final Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
		final Object this$name = this.getName();
		final Object other$name = other.getName();
		if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof Anime;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		final Object $name = this.getName();
		result = result * PRIME + ($name == null ? 43 : $name.hashCode());
		return result;
	}

	public String toString() {
		return "Anime(id=" + this.getId() + ", name=" + this.getName() + ")";
	}

	public static class AnimeBuilder {
		private Long id;
		private @NotEmpty(message = "The anime name cannot be empty") String name;

		AnimeBuilder() {
		}

		public AnimeBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public AnimeBuilder name(@NotEmpty(message = "The anime name cannot be empty") String name) {
			this.name = name;
			return this;
		}

		public Anime build() {
			return new Anime(id, name);
		}

		public String toString() {
			return "Anime.AnimeBuilder(id=" + this.id + ", name=" + this.name + ")";
		}
	}
}
