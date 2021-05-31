package academy.devdojo.springboot2.exception;

import java.time.LocalDateTime;

public class ExceptionDetails {
	protected String title;
	protected int status;
	protected String details;
	protected String developerMessage;
	protected LocalDateTime timestamp;

    protected ExceptionDetails(ExceptionDetailsBuilder<?, ?> b) {
        this.title = b.title;
        this.status = b.status;
        this.details = b.details;
        this.developerMessage = b.developerMessage;
        this.timestamp = b.timestamp;
    }

    public static ExceptionDetailsBuilder<?, ?> builder() {
        return new ExceptionDetailsBuilderImpl();
    }

    public String getTitle() {
        return this.title;
    }

    public int getStatus() {
        return this.status;
    }

    public String getDetails() {
        return this.details;
    }

    public String getDeveloperMessage() {
        return this.developerMessage;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ExceptionDetails)) return false;
        final ExceptionDetails other = (ExceptionDetails) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        if (this.getStatus() != other.getStatus()) return false;
        final Object this$details = this.getDetails();
        final Object other$details = other.getDetails();
        if (this$details == null ? other$details != null : !this$details.equals(other$details)) return false;
        final Object this$developerMessage = this.getDeveloperMessage();
        final Object other$developerMessage = other.getDeveloperMessage();
        if (this$developerMessage == null ? other$developerMessage != null : !this$developerMessage.equals(other$developerMessage))
            return false;
        final Object this$timestamp = this.getTimestamp();
        final Object other$timestamp = other.getTimestamp();
        if (this$timestamp == null ? other$timestamp != null : !this$timestamp.equals(other$timestamp)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ExceptionDetails;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        result = result * PRIME + this.getStatus();
        final Object $details = this.getDetails();
        result = result * PRIME + ($details == null ? 43 : $details.hashCode());
        final Object $developerMessage = this.getDeveloperMessage();
        result = result * PRIME + ($developerMessage == null ? 43 : $developerMessage.hashCode());
        final Object $timestamp = this.getTimestamp();
        result = result * PRIME + ($timestamp == null ? 43 : $timestamp.hashCode());
        return result;
    }

    public String toString() {
        return "ExceptionDetails(title=" + this.getTitle() + ", status=" + this.getStatus() + ", details=" + this.getDetails() + ", developerMessage=" + this.getDeveloperMessage() + ", timestamp=" + this.getTimestamp() + ")";
    }

    public static abstract class ExceptionDetailsBuilder<C extends ExceptionDetails, B extends ExceptionDetailsBuilder<C, B>> {
        private String title;
        private int status;
        private String details;
        private String developerMessage;
        private LocalDateTime timestamp;

        public B title(String title) {
            this.title = title;
            return self();
        }

        public B status(int status) {
            this.status = status;
            return self();
        }

        public B details(String details) {
            this.details = details;
            return self();
        }

        public B developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return self();
        }

        public B timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return self();
        }

        protected abstract B self();

        public abstract C build();

        public String toString() {
            return "ExceptionDetails.ExceptionDetailsBuilder(title=" + this.title + ", status=" + this.status + ", details=" + this.details + ", developerMessage=" + this.developerMessage + ", timestamp=" + this.timestamp + ")";
        }
    }

    private static final class ExceptionDetailsBuilderImpl extends ExceptionDetailsBuilder<ExceptionDetails, ExceptionDetailsBuilderImpl> {
        private ExceptionDetailsBuilderImpl() {
        }

        protected ExceptionDetailsBuilderImpl self() {
            return this;
        }

        public ExceptionDetails build() {
            return new ExceptionDetails(this);
        }
    }
}
