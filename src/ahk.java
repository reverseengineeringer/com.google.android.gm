import android.content.Context;
import android.view.View;

public final class ahk
  implements aho
{
  private static aln c(ahl paramahl)
  {
    return (aln)paramahl.c();
  }
  
  public final float a(ahl paramahl)
  {
    return ca * 2.0F;
  }
  
  public final void a() {}
  
  public final void a(ahl paramahl, Context paramContext, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramahl.a(new aln(paramInt, paramFloat1));
    paramContext = paramahl.d();
    paramContext.setClipToOutline(true);
    paramContext.setElevation(paramFloat2);
    paramContext = c(paramahl);
    boolean bool1 = paramahl.a();
    boolean bool2 = paramahl.b();
    if ((paramFloat3 != b) || (c != bool1) || (d != bool2))
    {
      b = paramFloat3;
      c = bool1;
      d = bool2;
      paramContext.a(null);
      paramContext.invalidateSelf();
    }
    if (!paramahl.a())
    {
      paramahl.a(0, 0, 0, 0);
      return;
    }
    paramFloat1 = cb;
    paramFloat2 = ca;
    paramInt = (int)Math.ceil(alo.b(paramFloat1, paramFloat2, paramahl.b()));
    int i = (int)Math.ceil(alo.a(paramFloat1, paramFloat2, paramahl.b()));
    paramahl.a(paramInt, i, paramInt, i);
  }
  
  public final float b(ahl paramahl)
  {
    return ca * 2.0F;
  }
}

/* Location:
 * Qualified Name:     ahk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */