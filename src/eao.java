import android.app.Fragment;
import android.app.FragmentManager;
import com.google.android.gm.welcome.WelcomeTourActivity;

public final class eao
  extends cut
{
  public eao(WelcomeTourActivity paramWelcomeTourActivity, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  private final int d(int paramInt)
  {
    int i = paramInt;
    if (cxe.a(a.b)) {
      i = a() - paramInt - 1;
    }
    return i;
  }
  
  public final int a()
  {
    if (a.a()) {
      return 2;
    }
    return 1;
  }
  
  public final CharSequence a(int paramInt)
  {
    switch (d(paramInt))
    {
    default: 
      return null;
    case 0: 
      return "welcome";
    }
    return "sectioned_inbox";
  }
  
  public final Fragment b(int paramInt)
  {
    switch (d(paramInt))
    {
    default: 
      return null;
    case 0: 
      return new ean();
    }
    return new eak();
  }
}

/* Location:
 * Qualified Name:     eao
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */