import java.util.Map;

final class fnm
  extends fnp<K, V>
{
  fnm(fnl paramfnl) {}
  
  protected final int a()
  {
    return a.h;
  }
  
  protected final int a(Object paramObject)
  {
    if (paramObject == null) {
      return a.a();
    }
    return a.a(paramObject, paramObject.hashCode());
  }
  
  protected final Object a(int paramInt1, int paramInt2)
  {
    return a.g[((paramInt1 << 1) + paramInt2)];
  }
  
  protected final V a(int paramInt, V paramV)
  {
    fnl localfnl = a;
    paramInt = (paramInt << 1) + 1;
    Object localObject = g[paramInt];
    g[paramInt] = paramV;
    return (V)localObject;
  }
  
  protected final void a(int paramInt)
  {
    a.b(paramInt);
  }
  
  protected final void a(K paramK, V paramV)
  {
    a.put(paramK, paramV);
  }
  
  protected final int b(Object paramObject)
  {
    return a.a(paramObject);
  }
  
  protected final Map<K, V> b()
  {
    return a;
  }
  
  protected final void c()
  {
    a.clear();
  }
}

/* Location:
 * Qualified Name:     fnm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */