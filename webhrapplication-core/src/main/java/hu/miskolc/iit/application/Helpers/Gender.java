package hu.miskolc.iit.application.Helpers;

public enum Gender {
        MALE("Male"),
        FEMALE("Female"),
        OTHER("Other");

        private final String description;

        private Gender(String description)
        {
            this.description = description;
        }

        @Override
        public String toString()
        {
            return name().toLowerCase();
        }
}
