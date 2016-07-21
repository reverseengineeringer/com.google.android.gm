import java.util.HashMap;
import java.util.Map;

public final class ffo
{
  private static final Map<String, ffi<?>> a = new HashMap();
  
  static
  {
    a(fnw.a);
    a(fnw.G);
    a(fnw.x);
    a(fnw.E);
    a(fnw.H);
    a(fnw.n);
    a(fnw.m);
    a(fnw.o);
    a(fnw.p);
    a(fnw.q);
    a(fnw.k);
    a(fnw.s);
    a(fnw.t);
    a(fnw.u);
    a(fnw.C);
    a(fnw.b);
    a(fnw.z);
    a(fnw.d);
    a(fnw.l);
    a(fnw.e);
    a(fnw.f);
    a(fnw.g);
    a(fnw.h);
    a(fnw.w);
    a(fnw.r);
    a(fnw.y);
    a(fnw.A);
    a(fnw.B);
    a(fnw.D);
    a(fnw.I);
    a(fnw.J);
    a(fnw.j);
    a(fnw.i);
    a(fnw.F);
    a(fnw.v);
    a(fnw.c);
    a(fnw.K);
    a(fnw.L);
    a(fnw.M);
    a(fnw.N);
    a(fnw.O);
    a(foi.a);
    a(foi.c);
    a(foi.d);
    a(foi.e);
    a(foi.b);
    a(fop.a);
    a(fop.b);
  }
  
  public static ffi<?> a(String paramString)
  {
    return (ffi)a.get(paramString);
  }
  
  private static void a(ffi<?> paramffi)
  {
    if (a.containsKey(paramffi.a())) {
      throw new IllegalArgumentException("Duplicate field name registered: " + paramffi.a());
    }
    a.put(paramffi.a(), paramffi);
  }
}

/* Location:
 * Qualified Name:     ffo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */