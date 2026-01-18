package tools.jackson.module.spisubtypes;

import tools.jackson.core.Version;
import tools.jackson.databind.JacksonModule;

/**
 * Subtypes module for registering subtypes without annotating the parent class.
 * See <a href="https://github.com/FasterXML/jackson-databind/issues/2104">this issues</a> in jackson-databind.
 *
 * @since 2.21 / 3.1
 */
public class SubtypesModule extends JacksonModule {

    protected SubtypesAnnotationIntrospector _introspector;

    public SubtypesModule() {
        this(new SubtypesAnnotationIntrospector());
    }

    public SubtypesModule(SubtypesAnnotationIntrospector introspector) {
        _introspector = introspector;
    }

    @Override
    public String getModuleName() {
        return getClass().getSimpleName();
    }

    @Override
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Override
    public void setupModule(SetupContext context) {
        context.insertAnnotationIntrospector(_introspector);
    }
}
