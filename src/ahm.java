import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;

public class ahm
  implements aho
{
  final RectF a = new RectF();
  
  private static alo c(ahl paramahl)
  {
    return (alo)paramahl.c();
  }
  
  public final float a(ahl paramahl)
  {
    paramahl = c(paramahl);
    float f1 = Math.max(k, h + b + k / 2.0F);
    float f2 = k;
    return (b + f2) * 2.0F + f1 * 2.0F;
  }
  
  public void a()
  {
    alo.c = new ahn(this);
  }
  
  public final void a(ahl paramahl, Context paramContext, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramContext = new alo(paramContext.getResources(), paramInt, paramFloat1, paramFloat2, paramFloat3);
    n = paramahl.b();
    paramContext.invalidateSelf();
    paramahl.a(paramContext);
    paramContext = new Rect();
    c(paramahl).getPadding(paramContext);
    alo localalo = c(paramahl);
    paramFloat1 = Math.max(k, h + b + k / 2.0F);
    paramFloat2 = k;
    paramInt = (int)Math.ceil((b + paramFloat2) * 2.0F + paramFloat1 * 2.0F);
    localalo = c(paramahl);
    paramFloat1 = Math.max(k, h + b + k * 1.5F / 2.0F);
    paramFloat2 = k;
    paramahl.a(paramInt, (int)Math.ceil((b + paramFloat2 * 1.5F) * 2.0F + paramFloat1 * 2.0F));
    paramahl.a(left, top, right, bottom);
  }
  
  public final float b(ahl paramahl)
  {
    paramahl = c(paramahl);
    float f1 = Math.max(k, h + b + k * 1.5F / 2.0F);
    float f2 = k;
    return (b + f2 * 1.5F) * 2.0F + f1 * 2.0F;
  }
}

/* Location:
 * Qualified Name:     ahm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */