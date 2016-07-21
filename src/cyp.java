import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;

public final class cyp
  implements View.OnApplyWindowInsetsListener
{
  private int a;
  private boolean b = false;
  
  public final WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    if (!b)
    {
      localObject = new int[2];
      paramView.getLocationInWindow((int[])localObject);
      a = (paramView.getRootView().getHeight() - localObject[1] - paramView.getHeight());
      b = true;
    }
    int i = paramWindowInsets.getSystemWindowInsetBottom();
    int j = Math.max(paramWindowInsets.getSystemWindowInsetBottom() - a, 0);
    Object localObject = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    if (j < bottomMargin + paramView.getHeight())
    {
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(leftMargin, topMargin, rightMargin, j);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      i = 0;
    }
    for (;;)
    {
      return paramWindowInsets.replaceSystemWindowInsets(paramWindowInsets.getSystemWindowInsetLeft(), paramWindowInsets.getSystemWindowInsetTop(), paramWindowInsets.getSystemWindowInsetRight(), i);
    }
  }
}

/* Location:
 * Qualified Name:     cyp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */