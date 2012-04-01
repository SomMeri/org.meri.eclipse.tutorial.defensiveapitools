package org.meri.eclipse.defensiveapitools.srot;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;

public class AdapterDemo {

  public Plus adapterFactoryDemo(Minus minus) {
    return (Plus) Platform.getAdapterManager().getAdapter(minus, Plus.class);
  }

  @SuppressWarnings("rawtypes")
  public static Object getAdapter(Object obj, Class type) {
    // if the object implements or extends the desired interface, use it
    if (type.isInstance(obj))
      return obj;

    // if the object is able to adapt itself, let it do it
    if (obj instanceof IAdaptable) {
      IAdaptable adaptable = (IAdaptable) obj;
      Object adapter = adaptable.getAdapter(type);
      if (adapter != null)
        return adapter;
    }

    // delegate to the global adapter manager
    return Platform.getAdapterManager().getAdapter(obj, type);
  }

}
