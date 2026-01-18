// SPI Subtypes Main artifact Module descriptor
module tools.jackson.module.spisubtypes
{
    requires com.fasterxml.jackson.annotation;

    requires tools.jackson.core;
    requires tools.jackson.databind;

    exports tools.jackson.module.spisubtypes;

    provides tools.jackson.databind.JacksonModule with
        tools.jackson.module.spisubtypes.SubtypesModule;
}
