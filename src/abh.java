import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class abh
  implements View.OnClickListener
{
  private final View a;
  private final String b;
  private Method c;
  private Context d;
  
  public abh(View paramView, String paramString)
  {
    a = paramView;
    b = paramString;
  }
  
  public final void onClick(View paramView)
  {
    Context localContext;
    if (c == null) {
      localContext = a.getContext();
    }
    while (localContext != null) {
      try
      {
        if (!localContext.isRestricted())
        {
          Method localMethod = localContext.getClass().getMethod(b, new Class[] { View.class });
          if (localMethod != null)
          {
            c = localMethod;
            d = localContext;
          }
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          c.invoke(d, new Object[] { paramView });
          return;
        }
        catch (IllegalAccessException paramView)
        {
          int i;
          throw new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
        }
        catch (InvocationTargetException paramView)
        {
          throw new IllegalStateException("Could not execute method for android:onClick", paramView);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        if ((localContext instanceof ContextWrapper)) {
          localContext = ((ContextWrapper)localContext).getBaseContext();
        } else {
          localContext = null;
        }
      }
    }
    i = a.getId();
    if (i == -1) {}
    for (paramView = "";; paramView = " with id '" + a.getContext().getResources().getResourceEntryName(i) + "'") {
      throw new IllegalStateException("Could not find method " + b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + a.getClass() + paramView);
    }
  }
}

/* Location:
 * Qualified Name:     abh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */