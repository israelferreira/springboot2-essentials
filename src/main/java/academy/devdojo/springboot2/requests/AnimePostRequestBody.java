package academy.devdojo.springboot2.requests;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;

public class AnimePostRequestBody {
	
	@NotEmpty(message = "The anime name cannot be empty")
	@Schema(description = "This is the Anime's name", example = "Tensei Shittara Slime Datta Ken", required = true)
	private String name;

    public AnimePostRequestBody(@NotEmpty(message = "The anime name cannot be empty") String name) {
        this.name = name;
    }

    public AnimePostRequestBody() {
    }

    public static AnimePostRequestBodyBuilder builder() {
        return new AnimePostRequestBodyBuilder();
    }

    public @NotEmpty(message = "The anime name cannot be empty") String getName() {
        return this.name;
    }

    public void setName(@NotEmpty(message = "The anime name cannot be empty") String name) {
        this.name = name;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AnimePostRequestBody)) return false;
        final AnimePostRequestBody other = (AnimePostRequestBody) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AnimePostRequestBody;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        return "AnimePostRequestBody(name=" + this.getName() + ")";
    }

    public static class AnimePostRequestBodyBuilder {
        private @NotEmpty(message = "The anime name cannot be empty") String name;

        AnimePostRequestBodyBuilder() {
        }

        public AnimePostRequestBodyBuilder name(@NotEmpty(message = "The anime name cannot be empty") String name) {
            this.name = name;
            return this;
        }

        public AnimePostRequestBody build() {
            return new AnimePostRequestBody(name);
        }

        public String toString() {
            return "AnimePostRequestBody.AnimePostRequestBodyBuilder(name=" + this.name + ")";
        }
    }
}
