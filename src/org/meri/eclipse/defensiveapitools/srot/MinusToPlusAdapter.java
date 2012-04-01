package org.meri.eclipse.defensiveapitools.srot;

public class MinusToPlusAdapter implements Plus {

  private final Minus adaptee;
  
  public MinusToPlusAdapter(Minus minus) {
    super();
    this.adaptee = minus;
  }

  @Override
  public int plus(int x, int y) {
    return adaptee.minus(x, -y);
  }

}
