package academy.devdojo.springboot2.exception;

public class BadRequestExceptionDetails extends ExceptionDetails {

    protected BadRequestExceptionDetails(BadRequestExceptionDetailsBuilder<?, ?> b) {
        super(b);
    }

    public static BadRequestExceptionDetailsBuilder<?, ?> builder() {
        return new BadRequestExceptionDetailsBuilderImpl();
    }

    public static abstract class BadRequestExceptionDetailsBuilder<C extends BadRequestExceptionDetails, B extends BadRequestExceptionDetailsBuilder<C, B>> extends ExceptionDetailsBuilder<C, B> {
        protected abstract B self();

        public abstract C build();

        public String toString() {
            return "BadRequestExceptionDetails.BadRequestExceptionDetailsBuilder(super=" + super.toString() + ")";
        }
    }

    private static final class BadRequestExceptionDetailsBuilderImpl extends BadRequestExceptionDetailsBuilder<BadRequestExceptionDetails, BadRequestExceptionDetailsBuilderImpl> {
        private BadRequestExceptionDetailsBuilderImpl() {
        }

        protected BadRequestExceptionDetailsBuilderImpl self() {
            return this;
        }

        public BadRequestExceptionDetails build() {
            return new BadRequestExceptionDetails(this);
        }
    }
}
