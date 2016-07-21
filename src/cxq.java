import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;

public final class cxq
  extends cya
{
  private ColorStateList a;
  
  protected final View a(LayoutInflater paramLayoutInflater, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = cxw.a;
    }
    try
    {
      paramLayoutInflater = super.a(paramLayoutInflater, i);
      return paramLayoutInflater;
    }
    catch (RuntimeException paramLayoutInflater)
    {
      throw new InflateException("Unable to inflate layout. Are you using @style/SuwThemeGlif (or its descendant) as your theme?", paramLayoutInflater);
    }
  }
  
  protected final ViewGroup a(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = cxv.b;
    }
    return super.a(i);
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = findViewById(cxv.e);
    if (paramBoolean) {
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        localObject = a;
        if (Build.VERSION.SDK_INT >= 21)
        {
          localProgressBar = (ProgressBar)findViewById(cxv.e);
          if (localProgressBar != null) {
            localProgressBar.setIndeterminateTintList((ColorStateList)localObject);
          }
        }
      }
    }
    while (localObject == null) {
      for (;;)
      {
        ProgressBar localProgressBar;
        return;
        localObject = (ViewStub)findViewById(cxv.f);
        if (localObject != null) {
          ((ViewStub)localObject).inflate();
        }
      }
    }
    ((View)localObject).setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     cxq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */