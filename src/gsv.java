import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class gsv
{
  public abstract void a();
  
  public abstract void a(double paramDouble);
  
  public abstract void a(float paramFloat);
  
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong);
  
  public abstract void a(String paramString);
  
  public abstract void a(BigDecimal paramBigDecimal);
  
  public abstract void a(BigInteger paramBigInteger);
  
  public abstract void a(boolean paramBoolean);
  
  public final void a(boolean paramBoolean, Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {
      return;
    }
    Object localObject1 = paramObject.getClass();
    if (gtt.a(paramObject))
    {
      d();
      return;
    }
    if ((paramObject instanceof String))
    {
      b((String)paramObject);
      return;
    }
    if ((paramObject instanceof Number))
    {
      if (paramBoolean)
      {
        b(paramObject.toString());
        return;
      }
      if ((paramObject instanceof BigDecimal))
      {
        a((BigDecimal)paramObject);
        return;
      }
      if ((paramObject instanceof BigInteger))
      {
        a((BigInteger)paramObject);
        return;
      }
      if ((paramObject instanceof Long))
      {
        a(((Long)paramObject).longValue());
        return;
      }
      if ((paramObject instanceof Float))
      {
        float f = ((Number)paramObject).floatValue();
        if ((!Float.isInfinite(f)) && (!Float.isNaN(f))) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          hbe.a(paramBoolean);
          a(f);
          return;
        }
      }
      if (((paramObject instanceof Integer)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte)))
      {
        a(((Number)paramObject).intValue());
        return;
      }
      double d = ((Number)paramObject).doubleValue();
      if ((!Double.isInfinite(d)) && (!Double.isNaN(d))) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        hbe.a(paramBoolean);
        a(d);
        return;
      }
    }
    if ((paramObject instanceof Boolean))
    {
      a(((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof gty))
    {
      b(((gty)paramObject).a());
      return;
    }
    if (((paramObject instanceof Iterable)) || (((Class)localObject1).isArray()))
    {
      e();
      paramObject = gus.a(paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        a(paramBoolean, ((Iterator)paramObject).next());
      }
      b();
      return;
    }
    if (((Class)localObject1).isEnum())
    {
      paramObject = ac;
      if (paramObject == null)
      {
        d();
        return;
      }
      b((String)paramObject);
      return;
    }
    f();
    int i;
    label394:
    label410:
    Object localObject2;
    String str;
    if (((paramObject instanceof Map)) && (!(paramObject instanceof gua)))
    {
      i = 1;
      if (i == 0) {
        break label486;
      }
      localObject1 = null;
      Iterator localIterator = gtt.b(paramObject).entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramObject = (Map.Entry)localIterator.next();
        localObject2 = ((Map.Entry)paramObject).getValue();
      } while (localObject2 == null);
      str = (String)((Map.Entry)paramObject).getKey();
      if (i == 0) {
        break label496;
      }
      bool = paramBoolean;
    }
    for (;;)
    {
      a(str);
      a(bool, localObject2);
      break label410;
      i = 0;
      break;
      label486:
      localObject1 = gtr.a((Class)localObject1);
      break label394;
      label496:
      paramObject = ((gtr)localObject1).a(str);
      if (paramObject == null) {}
      for (paramObject = null;; paramObject = b)
      {
        if ((paramObject == null) || (((Field)paramObject).getAnnotation(gtc.class) == null)) {
          break label537;
        }
        bool = true;
        break;
      }
      label537:
      bool = false;
    }
    c();
  }
  
  public abstract void b();
  
  public abstract void b(String paramString);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public void g() {}
}

/* Location:
 * Qualified Name:     gsv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */