import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

public final class aro
  extends Fragment
{
  public static final String a = cvl.a;
  private int b = 0;
  private int c;
  private Bundle d;
  private boolean e;
  private boolean f = false;
  private bdi g;
  private arp h;
  
  protected static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0;
    case 2: 
      return 3;
    case 4: 
      return 4;
    case 8: 
      return 2;
    }
    return 1;
  }
  
  public static aro a(int paramInt, Bundle paramBundle)
  {
    aro localaro = new aro();
    Bundle localBundle = new Bundle(2);
    localBundle.putInt("mode", paramInt);
    localBundle.putBundle("autodiscoverRedirectBundle", paramBundle);
    localaro.setArguments(localBundle);
    return localaro;
  }
  
  private final arr a()
  {
    Object localObject = getTargetFragment();
    if ((localObject instanceof arr)) {
      return (arr)localObject;
    }
    localObject = getActivity();
    if ((localObject instanceof arr)) {
      return (arr)localObject;
    }
    throw new IllegalStateException();
  }
  
  protected static String a(Context paramContext, int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while ((paramContext != null) && (paramInt > 0))
    {
      return paramContext.getString(paramInt);
      paramInt = arh.F;
      continue;
      paramInt = arh.B;
      continue;
      paramInt = arh.C;
      continue;
      paramInt = arh.E;
    }
    return null;
  }
  
  final void a(int paramInt, bdi parambdi)
  {
    b = paramInt;
    g = parambdi;
    if ((e) && (!f)) {}
    switch (paramInt)
    {
    default: 
      parambdi = a().g();
      if (parambdi != null) {
        parambdi.a(a(getActivity(), b));
      }
      return;
    case 5: 
      a().f();
      return;
    case 6: 
      String str = parambdi.getMessage();
      parambdi = str;
      if (str != null) {
        parambdi = str.trim();
      }
      a().a(parambdi);
      return;
    case 7: 
      a().a(parambdi);
      return;
    }
    a().a((arq)parambdi);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    e = true;
    if (h == null)
    {
      paramBundle = (awp)getActivity();
      h = ((arp)new arp(getActivity().getApplicationContext(), this, c, paramBundle.l(), d).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]));
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(true);
    c = getArguments().getInt("mode");
    d = getArguments().getBundle("autodiscoverRedirectBundle");
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    if (h != null)
    {
      bhn.a(h);
      h = null;
    }
  }
  
  public final void onDetach()
  {
    super.onDetach();
    e = false;
  }
  
  public final void onPause()
  {
    super.onPause();
    f = true;
  }
  
  public final void onResume()
  {
    super.onResume();
    f = false;
    if (b != 0) {
      a(b, g);
    }
  }
}

/* Location:
 * Qualified Name:     aro
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */