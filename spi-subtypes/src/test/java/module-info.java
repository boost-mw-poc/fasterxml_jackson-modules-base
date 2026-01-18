// SPI Subtypes (unit) Test artifact Module descriptor
module tools.jackson.module.spisubtypes
{
    // Since we are not split from Main artifact, will not
    // need to depend on Main artifact -- but need its dependencies

    requires com.fasterxml.jackson.annotation;
    requires tools.jackson.core;
    requires tools.jackson.databind;

    // Additional test lib/framework dependencies

    requires org.junit.jupiter.api;
    requires org.junit.jupiter.params;

    // Further, need to open up some packages for JUnit et al
    opens tools.jackson.module.spisubtypes;

    provides tools.jackson.databind.JacksonModule with
        tools.jackson.module.spisubtypes.SubtypesModule;
    uses tools.jackson.databind.JacksonModule;
}
