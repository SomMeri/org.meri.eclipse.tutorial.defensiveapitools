package org.meri.eclipse.defensiveapitools.srot;

import org.eclipse.core.runtime.IAdapterFactory;

@SuppressWarnings("rawtypes")
public class ArithmeticAdapterFactory implements IAdapterFactory {

  @Override
  public Object getAdapter(Object adaptee, Class type) {
    if (Plus.class.equals(type) && Minus.class.equals(adaptee))
      return new MinusToPlusAdapter((Minus)adaptee);

    return null;
  }

  @Override
  public Class[] getAdapterList() {
    return new Class[] { Plus.class };
  }

}
