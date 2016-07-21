import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public final class cmy
{
  public static final Interpolator a = new DecelerateInterpolator(1.0F);
  static cmy b;
  private float c;
  
  cmy(Context paramContext)
  {
    c = paramContext.getResources().getDimensionPixelOffset(bua.E);
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 <= paramFloat2) {
      return 0.0F;
    }
    if (paramFloat1 >= paramFloat3) {
      return 1.0F;
    }
    return (paramFloat1 - paramFloat2) / (paramFloat3 - paramFloat2);
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
  }
  
  public static void a(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    paramView.setAlpha(1.0F - a(paramFloat, 0.15F, 0.4F));
  }
  
  public static void a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {
      return;
    }
    paramView.setTranslationY(a.getInterpolation(paramFloat2) * paramFloat1);
  }
  
  public static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (paramView == null) {
      return;
    }
    paramFloat5 = a.getInterpolation(paramFloat5);
    paramView.setScaleX((1.0F - paramFloat1) * paramFloat5 + paramFloat1);
    paramView.setScaleY((1.0F - paramFloat2) * paramFloat5 + paramFloat2);
    paramView.setTranslationX((1.0F - paramFloat5) * paramFloat3);
    paramView.setTranslationY((1.0F - paramFloat5) * paramFloat4);
  }
  
  public static void b(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    paramView.setAlpha(a(paramFloat, 0.15F, 0.4F));
  }
  
  public static void b(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {
      return;
    }
    paramView.setTranslationY((1.0F - a.getInterpolation(paramFloat2)) * paramFloat1);
  }
  
  public static void c(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    paramView.setAlpha(a(paramFloat, 0.6F, 1.0F));
  }
  
  public final void d(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    paramView.setTranslationX(-c * (1.0F - a.getInterpolation(paramFloat)));
    paramView.setAlpha(a(paramFloat, 0.15F, 0.6F));
  }
}

/* Location:
 * Qualified Name:     cmy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */