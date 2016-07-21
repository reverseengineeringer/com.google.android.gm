import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class dgv
  extends bxh
{
  private boolean e;
  
  public dgv(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public final int a()
  {
    return 7;
  }
  
  public final View a(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(dga.h, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.getLayoutParams();
    paramContext = paramContext.getResources();
    if (e) {}
    for (int i = dfw.e;; i = dfw.d)
    {
      height = paramContext.getDimensionPixelSize(i);
      paramLayoutInflater.setLayoutParams(paramViewGroup);
      return paramLayoutInflater;
    }
  }
  
  public final void a(View paramView, boolean paramBoolean) {}
  
  public final boolean b()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     dgv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */