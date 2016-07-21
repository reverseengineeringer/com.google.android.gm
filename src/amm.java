import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class amm
  extends ContextWrapper
{
  private static final ArrayList<WeakReference<amm>> a = new ArrayList();
  private Resources b;
  private final Resources.Theme c;
  
  private amm(Context paramContext)
  {
    super(paramContext);
    if (ana.a())
    {
      c = getResources().newTheme();
      c.setTo(paramContext.getTheme());
      return;
    }
    c = null;
  }
  
  public static Context a(Context paramContext)
  {
    int i;
    Object localObject;
    int j;
    if (((paramContext instanceof amm)) || ((paramContext.getResources() instanceof amo)) || ((paramContext.getResources() instanceof ana)))
    {
      i = 0;
      localObject = paramContext;
      if (i != 0)
      {
        j = a.size();
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= j) {
        break label122;
      }
      localObject = (WeakReference)a.get(i);
      if (localObject != null) {}
      for (localObject = (amm)((WeakReference)localObject).get();; localObject = null)
      {
        if ((localObject == null) || (((amm)localObject).getBaseContext() != paramContext)) {
          break label115;
        }
        return (Context)localObject;
        if ((aaj.b) && (Build.VERSION.SDK_INT > 20))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      label115:
      i += 1;
    }
    label122:
    paramContext = new amm(paramContext);
    a.add(new WeakReference(paramContext));
    return paramContext;
  }
  
  public final Resources getResources()
  {
    if (b == null) {
      if (c != null) {
        break label37;
      }
    }
    label37:
    for (Object localObject = new amo(this, super.getResources());; localObject = new ana(this, super.getResources()))
    {
      b = ((Resources)localObject);
      return b;
    }
  }
  
  public final Resources.Theme getTheme()
  {
    if (c == null) {
      return super.getTheme();
    }
    return c;
  }
  
  public final void setTheme(int paramInt)
  {
    if (c == null)
    {
      super.setTheme(paramInt);
      return;
    }
    c.applyStyle(paramInt, true);
  }
}

/* Location:
 * Qualified Name:     amm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */