package academy.devdojo.springboot2.exception;

public class ValidationExceptionDetails extends ExceptionDetails {
	private final String fields;
	private final String fieldsMessage;

    protected ValidationExceptionDetails(ValidationExceptionDetailsBuilder<?, ?> b) {
        super(b);
        this.fields = b.fields;
        this.fieldsMessage = b.fieldsMessage;
    }

    public static ValidationExceptionDetailsBuilder<?, ?> builder() {
        return new ValidationExceptionDetailsBuilderImpl();
    }

    public String getFields() {
        return this.fields;
    }

    public String getFieldsMessage() {
        return this.fieldsMessage;
    }

    public static abstract class ValidationExceptionDetailsBuilder<C extends ValidationExceptionDetails, B extends ValidationExceptionDetailsBuilder<C, B>> extends ExceptionDetailsBuilder<C, B> {
        private String fields;
        private String fieldsMessage;

        public B fields(String fields) {
            this.fields = fields;
            return self();
        }

        public B fieldsMessage(String fieldsMessage) {
            this.fieldsMessage = fieldsMessage;
            return self();
        }

        protected abstract B self();

        public abstract C build();

        public String toString() {
            return "ValidationExceptionDetails.ValidationExceptionDetailsBuilder(super=" + super.toString() + ", fields=" + this.fields + ", fieldsMessage=" + this.fieldsMessage + ")";
        }
    }

    private static final class ValidationExceptionDetailsBuilderImpl extends ValidationExceptionDetailsBuilder<ValidationExceptionDetails, ValidationExceptionDetailsBuilderImpl> {
        private ValidationExceptionDetailsBuilderImpl() {
        }

        protected ValidationExceptionDetailsBuilderImpl self() {
            return this;
        }

        public ValidationExceptionDetails build() {
            return new ValidationExceptionDetails(this);
        }
    }
}
