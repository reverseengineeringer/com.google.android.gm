import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class hbo
{
  public final gzx a;
  public final boolean b;
  public final hbv c;
  public final int d;
  
  public hbo(hbv paramhbv)
  {
    this(paramhbv, false, gzx.a(), Integer.MAX_VALUE);
  }
  
  public hbo(hbv paramhbv, boolean paramBoolean, gzx paramgzx, int paramInt)
  {
    c = paramhbv;
    b = paramBoolean;
    a = paramgzx;
    d = paramInt;
  }
  
  public static hbo a(gzx paramgzx)
  {
    hbe.a(paramgzx);
    return new hbo(new hbp(paramgzx));
  }
  
  final Iterator<String> a(CharSequence paramCharSequence)
  {
    return c.a(this, paramCharSequence);
  }
  
  public final List<String> b(CharSequence paramCharSequence)
  {
    hbe.a(paramCharSequence);
    paramCharSequence = a(paramCharSequence);
    ArrayList localArrayList = new ArrayList();
    while (paramCharSequence.hasNext()) {
      localArrayList.add((String)paramCharSequence.next());
    }
    return Collections.unmodifiableList(localArrayList);
  }
}

/* Location:
 * Qualified Name:     hbo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */