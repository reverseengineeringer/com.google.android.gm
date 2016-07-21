import android.view.View;

final class rw
{
  private static void a(View paramView)
  {
    float f = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f);
    paramView.setTranslationY(f);
  }
  
  static void a(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
    a(paramView);
    paramView = paramView.getParent();
    if ((paramView instanceof View)) {
      a((View)paramView);
    }
  }
  
  static void b(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
    a(paramView);
    paramView = paramView.getParent();
    if ((paramView instanceof View)) {
      a((View)paramView);
    }
  }
}

/* Location:
 * Qualified Name:     rw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */