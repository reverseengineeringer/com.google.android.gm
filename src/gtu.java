import java.util.AbstractMap;

final class gtu
  extends AbstractMap<String, Object>
{
  final Object a;
  final gtr b;
  
  gtu(Object paramObject, boolean paramBoolean)
  {
    a = paramObject;
    b = gtr.a(paramObject.getClass(), paramBoolean);
    if (!b.a.isEnum()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      hbe.a(paramBoolean);
      return;
    }
  }
  
  public final gtx a()
  {
    return new gtx(this);
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return get(paramObject) != null;
  }
  
  public final Object get(Object paramObject)
  {
    if (!(paramObject instanceof String)) {}
    do
    {
      return null;
      paramObject = b.a((String)paramObject);
    } while (paramObject == null);
    return ((gtz)paramObject).a(a);
  }
}

/* Location:
 * Qualified Name:     gtu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */