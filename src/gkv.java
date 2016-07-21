import android.os.SystemClock;

abstract class gkv
  implements gku
{
  private final gmz a;
  private final gkz b;
  private final boolean c;
  private final gmk d = gmk.a;
  
  gkv(gks paramgks, int paramInt)
  {
    a = new gmz(paramgks.b());
    if (gla.a == paramInt) {}
    for (b = new gky(this);; b = new gkw(this))
    {
      c = paramgks.a();
      return;
    }
  }
  
  public final void a(hri paramhri)
  {
    a(null, paramhri);
  }
  
  public final void a(String arg1, hri paramhri)
  {
    b.a(???, paramhri);
    paramhri = a;
    synchronized (a)
    {
      b += 1;
      long l = SystemClock.elapsedRealtime();
      if (l - c > 1000L)
      {
        b = 0;
        c = l;
      }
      return;
    }
  }
  
  public final boolean a()
  {
    return (!d.c) && (c) && (!a.a());
  }
  
  protected abstract void b(String paramString, hri paramhri);
}

/* Location:
 * Qualified Name:     gkv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */