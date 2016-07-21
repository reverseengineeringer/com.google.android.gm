import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.Toast;
import com.android.emailcommon.mail.Address;
import com.android.mail.browse.ConversationMessage;
import com.android.mail.browse.ConversationViewHeader;
import com.android.mail.browse.MessageFooterView;
import com.android.mail.browse.MessageHeaderView;
import com.android.mail.browse.MessageScrollView;
import com.android.mail.browse.MessageWebView;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Message;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class byc
  extends Fragment
  implements byy, bzg
{
  static final String a = cvl.a;
  MessageWebView b;
  ConversationViewHeader c;
  MessageHeaderView d;
  MessageFooterView e;
  ConversationMessage f;
  cmn g;
  btq h;
  Uri i;
  boolean j;
  int k;
  public final Map<String, Address> l = Collections.synchronizedMap(new HashMap());
  private final Handler m = new Handler();
  private final byf n = new byf(this);
  private final bye o = new bye(this);
  private MessageScrollView p;
  private byd q;
  private ckt r;
  private bvu s;
  
  final void a()
  {
    Activity localActivity = getActivity();
    Toast.makeText(localActivity, buj.bx, 1).show();
    localActivity.finish();
  }
  
  public final void a(View paramView) {}
  
  public final void a(bxu parambxu, int paramInt) {}
  
  public final void a(bxu parambxu, boolean paramBoolean, int paramInt) {}
  
  public final void a(Message paramMessage)
  {
    b.getSettings().setBlockNetworkImage(false);
  }
  
  public final void a(gnt paramgnt, View paramView) {}
  
  public final void a(String paramString)
  {
    b.getSettings().setBlockNetworkImage(false);
  }
  
  final ckt b()
  {
    if (r == null) {
      r = new ckt(getActivity());
    }
    return r;
  }
  
  public final String b(Message paramMessage)
  {
    return null;
  }
  
  public final void b(View paramView) {}
  
  public final void b(bxu parambxu, int paramInt) {}
  
  public final boolean c()
  {
    return true;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (j)
    {
      a();
      return;
    }
    paramBundle = (byg)getActivity();
    q.c = paramBundle;
    s = l;
    h = new btq(paramBundle);
    d.a(paramBundle, l);
    d.b = b();
    d.a = this;
    d.d = false;
    d.l = true;
    e.a(getLoaderManager(), getFragmentManager(), paramBundle, this, s);
    paramBundle = getLoaderManager();
    paramBundle.initLoader(0, null, n);
    paramBundle.initLoader(2, null, o);
    g.a(true, null);
    paramBundle = getResources();
    k = ((int)(paramBundle.getDimensionPixelOffset(bua.x) / getDisplayMetricsdensity));
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i = ((Uri)getArguments().getParcelable("eml_file_uri"));
    q = new byd(this);
    setHasOptionsMenu(true);
  }
  
  public final void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    if (cxd.c()) {
      paramMenuInflater.inflate(buf.h, paramMenu);
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(bue.ag, paramViewGroup, false);
    p = ((MessageScrollView)paramLayoutInflater.findViewById(buc.el));
    c = ((ConversationViewHeader)paramLayoutInflater.findViewById(buc.ar));
    d = ((MessageHeaderView)paramLayoutInflater.findViewById(buc.cK));
    e = ((MessageFooterView)paramLayoutInflater.findViewById(buc.cJ));
    int i1 = paramLayoutInflater.getResources().getColor(btz.D);
    d.setBackgroundColor(i1);
    e.setBackgroundColor(i1);
    g = new cmn(this, m);
    g.a(paramLayoutInflater);
    b = ((MessageWebView)paramLayoutInflater.findViewById(buc.fN));
    b.setOverScrollMode(2);
    b.setWebViewClient(q);
    paramViewGroup = byj.a;
    b.setOnCreateContextMenuListener(new cah(getActivity(), paramViewGroup.a(null, -1L)));
    b.setFocusable(false);
    paramViewGroup = b.getSettings();
    paramViewGroup.setJavaScriptEnabled(false);
    paramViewGroup.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    ctx.a(getResources(), paramViewGroup);
    paramViewGroup.setSupportZoom(true);
    paramViewGroup.setBuiltInZoomControls(true);
    paramViewGroup.setDisplayZoomControls(false);
    p.a = b;
    return paramLayoutInflater;
  }
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == buc.dz)
    {
      paramMenuItem = f.a();
      Activity localActivity = getActivity();
      ConversationMessage localConversationMessage = f;
      if (paramMenuItem != null) {}
      for (paramMenuItem = d;; paramMenuItem = f.h)
      {
        cft.a(localActivity, localConversationMessage, paramMenuItem, l, "x-thread://message/rfc822/", false);
        return true;
      }
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:
 * Qualified Name:     byc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */