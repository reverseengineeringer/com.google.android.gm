import android.util.JsonReader;
import android.util.JsonToken;
import java.io.EOFException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

final class gqd
  extends gsy
{
  private final JsonReader a;
  private final gqb b;
  private List<String> c = new ArrayList();
  private gtd d;
  private String e;
  
  gqd(gqb paramgqb, JsonReader paramJsonReader)
  {
    b = paramgqb;
    a = paramJsonReader;
    paramJsonReader.setLenient(true);
  }
  
  private final void p()
  {
    if ((d == gtd.g) || (d == gtd.h)) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.a(bool);
      return;
    }
  }
  
  public final void a()
  {
    a.close();
  }
  
  public final String b()
  {
    if (c.isEmpty()) {
      return null;
    }
    return (String)c.get(c.size() - 1);
  }
  
  public final gtd c()
  {
    return d;
  }
  
  public final gsu d()
  {
    return b;
  }
  
  public final byte e()
  {
    p();
    return Byte.valueOf(e).byteValue();
  }
  
  public final short f()
  {
    p();
    return Short.valueOf(e).shortValue();
  }
  
  public final int g()
  {
    p();
    return Integer.valueOf(e).intValue();
  }
  
  public final float h()
  {
    p();
    return Float.valueOf(e).floatValue();
  }
  
  public final BigInteger i()
  {
    p();
    return new BigInteger(e);
  }
  
  public final BigDecimal j()
  {
    p();
    return new BigDecimal(e);
  }
  
  public final double k()
  {
    p();
    return Double.valueOf(e).doubleValue();
  }
  
  public final long l()
  {
    p();
    return Long.valueOf(e).longValue();
  }
  
  public final String m()
  {
    return e;
  }
  
  public final gtd n()
  {
    if (d != null) {
      switch (gqe.a[d.ordinal()])
      {
      }
    }
    try
    {
      for (;;)
      {
        JsonToken localJsonToken = a.peek();
        switch (gqe.b[localJsonToken.ordinal()])
        {
        default: 
          e = null;
          d = null;
          return d;
          a.beginArray();
          c.add(null);
          continue;
          a.beginObject();
          c.add(null);
        }
      }
    }
    catch (EOFException localEOFException)
    {
      for (;;)
      {
        Object localObject = JsonToken.END_DOCUMENT;
        continue;
        e = "[";
        d = gtd.a;
        continue;
        e = "]";
        d = gtd.b;
        c.remove(c.size() - 1);
        a.endArray();
        continue;
        e = "{";
        d = gtd.c;
        continue;
        e = "}";
        d = gtd.d;
        c.remove(c.size() - 1);
        a.endObject();
        continue;
        if (a.nextBoolean())
        {
          e = "true";
          d = gtd.i;
        }
        else
        {
          e = "false";
          d = gtd.j;
          continue;
          e = "null";
          d = gtd.k;
          a.nextNull();
          continue;
          e = a.nextString();
          d = gtd.f;
          continue;
          e = a.nextString();
          if (e.indexOf('.') == -1) {}
          for (localObject = gtd.g;; localObject = gtd.h)
          {
            d = ((gtd)localObject);
            break;
          }
          e = a.nextName();
          d = gtd.e;
          c.set(c.size() - 1, e);
        }
      }
    }
  }
  
  public final gsy o()
  {
    if (d != null) {}
    switch (gqe.a[d.ordinal()])
    {
    default: 
      return this;
    case 1: 
      a.skipValue();
      e = "]";
      d = gtd.b;
      return this;
    }
    a.skipValue();
    e = "}";
    d = gtd.d;
    return this;
  }
}

/* Location:
 * Qualified Name:     gqd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */