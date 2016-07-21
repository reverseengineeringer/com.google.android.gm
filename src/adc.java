import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;

public final class adc
  extends ContextWrapper
{
  public int a;
  private Resources.Theme b;
  private LayoutInflater c;
  
  public adc(Context paramContext, int paramInt)
  {
    super(paramContext);
    a = paramInt;
  }
  
  public adc(Context paramContext, Resources.Theme paramTheme)
  {
    super(paramContext);
    b = paramTheme;
  }
  
  private final void a()
  {
    if (b == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        b = getResources().newTheme();
        Resources.Theme localTheme = getBaseContext().getTheme();
        if (localTheme != null) {
          b.setTo(localTheme);
        }
      }
      b.applyStyle(a, true);
      return;
    }
  }
  
  public final Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (c == null) {
        c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      return c;
    }
    return getBaseContext().getSystemService(paramString);
  }
  
  public final Resources.Theme getTheme()
  {
    if (b != null) {
      return b;
    }
    if (a == 0) {
      a = acj.c;
    }
    a();
    return b;
  }
  
  public final void setTheme(int paramInt)
  {
    if (a != paramInt)
    {
      a = paramInt;
      a();
    }
  }
}

/* Location:
 * Qualified Name:     adc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */