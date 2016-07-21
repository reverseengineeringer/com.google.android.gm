import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Stack;

public abstract class dkd
  extends Activity
  implements dkw
{
  public static final String a = cvl.a;
  public Stack<String> b = new Stack();
  private Handler c = new Handler();
  private but d;
  
  public abstract String a();
  
  public void a(Bundle paramBundle)
  {
    b = new Stack();
    b.addAll(paramBundle.getStringArrayList("fragment_stack"));
  }
  
  public final void a(dkv paramdkv)
  {
    boolean bool = true;
    cvm.b(a, "Gmailify from %s to %s", new Object[] { b(), paramdkv });
    if (!paramdkv.g()) {}
    for (;;)
    {
      c.post(new dke(this, paramdkv, bool));
      a("page", b, 0L);
      return;
      bool = false;
    }
  }
  
  final void a(String paramString)
  {
    if ((b.size() == 0) || (!TextUtils.equals(paramString, (CharSequence)b.peek()))) {
      b.add(paramString);
    }
  }
  
  public final void a(String paramString1, String paramString2, long paramLong)
  {
    d.a(a(), paramString1, paramString2, 0L);
  }
  
  public final dkv b()
  {
    return (dkv)getFragmentManager().findFragmentById(dfy.cd);
  }
  
  public void onBackPressed()
  {
    String str;
    if (b.size() > 1)
    {
      b.pop();
      str = (String)b.peek();
    }
    for (boolean bool = getFragmentManager().popBackStackImmediate(str, 0);; bool = false)
    {
      if (!bool) {
        finish();
      }
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(dga.b);
    d = buo.a();
    if (paramBundle != null)
    {
      a(paramBundle);
      return;
    }
    c();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putStringArrayList("fragment_stack", new ArrayList(b));
  }
  
  protected void onStart()
  {
    super.onStart();
    d.a(this);
    d.a(a(), "start", null, 0L);
  }
  
  protected void onStop()
  {
    d.b(this);
    super.onStop();
  }
}

/* Location:
 * Qualified Name:     dkd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */