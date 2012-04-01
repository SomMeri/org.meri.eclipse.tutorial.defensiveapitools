package org.meri.eclipse.defensiveapitools.srot;

import org.eclipse.core.runtime.IAdaptable;

public class MinusImpl implements Minus, IAdaptable {

  @Override
  public int minus(int x, int y) {
    return x - y;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public Object getAdapter(Class type) {
    if (Plus.class.equals(type))
      return new MinusToPlusAdapter(this);

    return null;
  }

}
