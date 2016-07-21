import android.view.View;

public final class arl
{
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = paramView.findViewById(paramInt1);
    if (paramView != null) {
      paramView.setVisibility(paramInt2);
    }
  }
}

/* Location:
 * Qualified Name:     arl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */