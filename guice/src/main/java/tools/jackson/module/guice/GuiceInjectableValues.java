package tools.jackson.module.guice;

import tools.jackson.databind.BeanProperty;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.InjectableValues;
import com.google.inject.Injector;
import com.google.inject.Key;

public class GuiceInjectableValues extends InjectableValues
{
  private final Injector injector;

  public GuiceInjectableValues(Injector injector) {this.injector = injector;}

  @Override
  public InjectableValues snapshot() {
      // 23-Feb-2018, tatu: Not sure if and how this could work really...
      return this;
  }

  @Override
  public Object findInjectableValue(DeserializationContext ctxt,
      Object valueId, BeanProperty forProperty, Object beanInstance,
      Boolean optional)
  {
    return injector.getInstance((Key<?>) valueId);
  }
}
