package academy.devdojo.springboot2.requests;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;

public class AnimePutRequestBody {

	private Long id;

	@NotEmpty(message = "The anime name cannot be empty")
	@Schema(description = "This is the Anime's name", example = "Tensei Shittara Slime Datta Ken", required = true)
	private String name;

    AnimePutRequestBody(Long id, @NotEmpty(message = "The anime name cannot be empty") String name) {
        this.id = id;
        this.name = name;
    }

    public static AnimePutRequestBodyBuilder builder() {
        return new AnimePutRequestBodyBuilder();
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
        if (!(o instanceof AnimePutRequestBody)) return false;
        final AnimePutRequestBody other = (AnimePutRequestBody) o;
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
        return other instanceof AnimePutRequestBody;
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
        return "AnimePutRequestBody(id=" + this.getId() + ", name=" + this.getName() + ")";
    }

    public static class AnimePutRequestBodyBuilder {
        private Long id;
        private @NotEmpty(message = "The anime name cannot be empty") String name;

        AnimePutRequestBodyBuilder() {
        }

        public AnimePutRequestBodyBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public AnimePutRequestBodyBuilder name(@NotEmpty(message = "The anime name cannot be empty") String name) {
            this.name = name;
            return this;
        }

        public AnimePutRequestBody build() {
            return new AnimePutRequestBody(id, name);
        }

        public String toString() {
            return "AnimePutRequestBody.AnimePutRequestBodyBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }
}
