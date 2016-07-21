import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.android.email.activity.setup.SetupDataFragment;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;

public abstract class asp
  extends ats
  implements View.OnClickListener
{
  public Context a;
  public boolean b;
  public int c;
  public boolean d;
  public HostAuth e;
  public HostAuth f;
  public SetupDataFragment g;
  public TextView h;
  public String i = "protocol";
  final Handler j = new Handler();
  private boolean t;
  
  public static Bundle a(int paramInt, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle(2);
    localBundle.putInt("mode", paramInt);
    localBundle.putBoolean("additionalAuthNeeded", paramBoolean);
    return localBundle;
  }
  
  public abstract void a();
  
  protected final void a(View paramView)
  {
    if ((c == 1) || (c == 2) || (c == 3))
    {
      paramView.findViewById(are.H).setOnClickListener(this);
      h = ((TextView)paramView.findViewById(are.ab));
      h.setOnClickListener(this);
      h.setEnabled(false);
      if (d) {
        h.setText(arh.bO);
      }
      return;
    }
    a(p);
  }
  
  public final void a(String paramString)
  {
    p = paramString;
    if (TextUtils.isEmpty(p))
    {
      a();
      return;
    }
    f_();
  }
  
  protected final void a(String paramString1, String paramString2)
  {
    ((ass)getActivity()).a(paramString1, paramString2);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (h != null)
    {
      h.setEnabled(paramBoolean);
      return;
    }
    a_(paramBoolean);
  }
  
  public boolean c()
  {
    boolean bool = false;
    f();
    Object localObject = g.b;
    HostAuth localHostAuth = ((Account)localObject).c(a);
    int k;
    if ((e != null) && (!e.equals(localHostAuth)))
    {
      k = 1;
      localObject = ((Account)localObject).d(a);
      if ((f == null) || (f.equals(localObject))) {
        break label97;
      }
    }
    label97:
    for (int m = 1;; m = 0)
    {
      if ((k != 0) || (m != 0)) {
        bool = true;
      }
      return bool;
      k = 0;
      break;
    }
  }
  
  public void d()
  {
    getLoaderManager().initLoader(0, null, new asq(this));
  }
  
  public abstract Loader<Boolean> e();
  
  public abstract int f();
  
  public abstract void f_();
  
  public final void g()
  {
    int k = f();
    ((ass)getActivity()).a(k);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    Activity localActivity = getActivity();
    b = ((ass)localActivity).a();
    a = localActivity.getApplicationContext();
    if ((c == 1) && (paramBundle != null)) {
      localActivity.setTitle(paramBundle.getString("AccountServerBaseFragment.title"));
    }
    g = ((awp)localActivity).l();
    super.onActivityCreated(paramBundle);
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k == are.H)
    {
      f();
      getActivity().onBackPressed();
      return;
    }
    if (k == are.ab)
    {
      g();
      return;
    }
    super.onClick(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      c = paramBundle.getInt("AccountServerBaseFragment.mode");
      d = paramBundle.getBoolean("AccountServerBaseFragment.additionalAuthNeeded");
      t = paramBundle.getBoolean("AccountServerBaseFragment.saving");
      e = ((HostAuth)paramBundle.getParcelable("AccountServerBaseFragment.sendAuth"));
      f = ((HostAuth)paramBundle.getParcelable("AccountServerBaseFragment.recvAuth"));
    }
    for (;;)
    {
      setHasOptionsMenu(true);
      return;
      c = getArguments().getInt("mode");
      d = getArguments().getBoolean("additionalAuthNeeded");
    }
  }
  
  public void onPause()
  {
    ((InputMethodManager)a.getSystemService("input_method")).hideSoftInputFromWindow(getView().getWindowToken(), 0);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (t) {
      d();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("AccountServerBaseFragment.title", (String)getActivity().getTitle());
    paramBundle.putInt("AccountServerBaseFragment.mode", c);
    paramBundle.putBoolean("AccountServerBaseFragment.additionalAuthNeeded", d);
    paramBundle.putParcelable("AccountServerBaseFragment.sendAuth", e);
    paramBundle.putParcelable("AccountServerBaseFragment.recvAuth", f);
  }
}

/* Location:
 * Qualified Name:     asp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */