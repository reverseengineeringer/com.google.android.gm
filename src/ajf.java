import android.support.v7.widget.GridLayout;

public class ajf
{
  static final ajf a = ;
  public final boolean b;
  public final ajb c;
  final aiv d;
  final float e;
  
  public ajf(boolean paramBoolean, int paramInt1, int paramInt2, aiv paramaiv, float paramFloat)
  {
    this(paramBoolean, new ajb(paramInt1, paramInt1 + paramInt2), paramaiv, paramFloat);
  }
  
  private ajf(boolean paramBoolean, ajb paramajb, aiv paramaiv, float paramFloat)
  {
    b = paramBoolean;
    c = paramajb;
    d = paramaiv;
    e = paramFloat;
  }
  
  public final aiv a(boolean paramBoolean)
  {
    if (d != GridLayout.k) {
      return d;
    }
    if (e == 0.0F)
    {
      if (paramBoolean) {
        return GridLayout.n;
      }
      return GridLayout.s;
    }
    return GridLayout.t;
  }
  
  public final ajf a(ajb paramajb)
  {
    return new ajf(b, paramajb, d, e);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ajf)paramObject;
      if (!d.equals(d)) {
        return false;
      }
    } while (c.equals(c));
    return false;
  }
  
  public int hashCode()
  {
    return c.hashCode() * 31 + d.hashCode();
  }
}

/* Location:
 * Qualified Name:     ajf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */