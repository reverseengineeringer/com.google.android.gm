import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import com.android.mail.browse.ConversationContainer;
import com.android.mail.browse.ConversationWebView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.ui.ConversationViewFragment;
import com.android.mail.ui.ConversationViewState;
import com.google.android.gm.ads.AdToastBarOperation;
import com.google.android.gm.provider.Advertisement;
import com.google.android.gm.provider.Advertisement.AdvertisementOptions;
import com.google.android.gm.provider.Advertisement.AppInstallAdData;
import com.google.android.gm.ui.MailActivityGmail;

public final class dhn
  extends ConversationViewFragment
  implements View.OnClickListener, bzp, dhv, dhy
{
  static final String ac = cvl.a;
  Advertisement ad;
  dgx ae;
  final dhp af = new dhp(this);
  private String ag;
  private Uri ah;
  private String ai;
  private String aj;
  private String ak;
  private String al;
  private String am;
  private View an;
  private boolean ao = true;
  private int ap;
  private boolean aq;
  private final dhq ar = new dhq(this);
  private final doz as = new dho(this);
  
  private final boolean D()
  {
    return (ad.D.a()) && (ad.D.b()) && (ad.D.d() != 2);
  }
  
  private final boolean E()
  {
    try
    {
      int i = getActivitygetPackageManagergetPackageInfoag, 0).versionCode;
      return i >= 80300024;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      cvm.e(ac, localNameNotFoundException, "Package Not Found: %s", new Object[] { ag });
    }
    return false;
  }
  
  static boolean a(Context paramContext, String paramString, Advertisement paramAdvertisement)
  {
    paramContext = ghz.a(paramContext.getContentResolver(), "gmail-ad-body-feedback-url", "gmail-ads://trigger_gsp_feedback");
    return (B.d) && (paramString != null) && (paramString.startsWith(paramContext));
  }
  
  protected final boolean A()
  {
    return false;
  }
  
  protected final void B()
  {
    getLoaderManager().initLoader(0, Bundle.EMPTY, ar);
  }
  
  protected final void C()
  {
    getLoaderManager().destroyLoader(0);
  }
  
  protected final String a(byw parambyw, boolean paramBoolean)
  {
    cvm.b(ac, "IN renderMessageBodies, fragment=%s", new Object[] { this });
    A.c = null;
    F.a();
    m = new ConversationViewState(m);
    parambyw = ad;
    int i = e(F.a(new dgw(parambyw, aq, this)));
    E.a(B.e, B.b(J), B.b(i), 0);
    if (!D()) {}
    for (boolean bool = false;; bool = true)
    {
      parambyw = ad;
      ae = new dgx(f, parambyw, this);
      int j = F.a(ae);
      i = F.a(new dgv(bool));
      j = e(j);
      i = e(i);
      E.a(parambyw, true, true, B.b(j), B.b(i));
      c("rendered message");
      B.getSettings().setBlockNetworkImage(false);
      return E.a(0, e, e, B.e, B.a(J), paramBoolean, a(f), false, false);
      LayoutInflater.from(getActivity()).inflate(dga.g, (ViewGroup)A.findViewById(dfy.am)).findViewById(dfy.z).setOnClickListener(this);
      an = A.findViewById(dfy.A);
    }
  }
  
  public final void a(int paramInt)
  {
    boolean bool;
    View localView;
    if (D())
    {
      int i = B.getHeight();
      int j = Math.round(B.getContentHeight() * B.getScale());
      if (i + paramInt + ap >= j) {
        break label87;
      }
      bool = true;
      if (ao != bool)
      {
        localView = an;
        if (!bool) {
          break label93;
        }
      }
    }
    label87:
    label93:
    for (paramInt = dfx.b;; paramInt = dfx.a)
    {
      localView.setBackgroundResource(paramInt);
      ao = bool;
      return;
      bool = false;
      break;
    }
  }
  
  final void a(String paramString, Advertisement paramAdvertisement)
  {
    if ((b instanceof MailActivityGmail))
    {
      dhz localdhz = b).x;
      if (localdhz != null) {
        localdhz.a(paramString, paramAdvertisement);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (aq != paramBoolean)
    {
      aq = paramBoolean;
      b(null);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    Object localObject2 = ad.D.c;
    Object localObject1 = ad.D.g;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      cvm.e(ac, "Package name is empty.", new Object[0]);
    }
    do
    {
      do
      {
        return;
        if (TextUtils.isEmpty(ad.D.i)) {
          break;
        }
      } while (getActivity() == null);
      localObject1 = ad.a(Uri.parse(ad.D.i));
    } while (!dfh.a(getActivity(), (Uri)localObject1, true));
    af.a = ((Uri)localObject1);
    AsyncTask.execute(af);
    return;
    int i;
    if ((paramBoolean) && (E()))
    {
      Intent localIntent = new Intent(ai);
      localIntent.putExtra(aj, (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localIntent.putExtra(ak, (String)localObject1);
      }
      i = 12;
      startActivityForResult(localIntent, 111);
    }
    for (;;)
    {
      AsyncTask.execute(new dht(this, ad, i));
      return;
      localObject2 = ah.buildUpon().appendQueryParameter(al, (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((Uri.Builder)localObject2).appendQueryParameter(am, (String)localObject1);
      }
      localObject1 = new Intent("android.intent.action.VIEW", ((Uri.Builder)localObject2).build());
      i = 11;
      startActivity((Intent)localObject1);
    }
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final void b_(View paramView) {}
  
  protected final void i()
  {
    super.i();
    ad = ((Advertisement)getArguments().getParcelable("advertisement"));
  }
  
  protected final void j()
  {
    int i = f.c.hashCode();
    String str = ad.e;
    e = (String.valueOf(str).length() + 23 + "x-thread://" + i + "/" + str);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = byj.a;
    Activity localActivity = getActivity();
    Account localAccount = f;
    if (d != null) {}
    for (long l = d.b;; l = -1L)
    {
      paramBundle = new dhs(this, localActivity, paramBundle.a(localAccount, l));
      b = this;
      B.setOnCreateContextMenuListener(paramBundle);
      B.a(this);
      paramBundle = j.getContentResolver();
      ag = ghz.a(paramBundle, "gmail-ads-vending-activity-package", "com.android.vending");
      ah = Uri.parse(ghz.a(paramBundle, "gmail-ads-play-store-app-details", "market://details"));
      ai = ghz.a(paramBundle, "gmail-ads-inline-app-install-activity", "com.android.finsky.APP_DETAILS_DIALOG");
      aj = ghz.a(paramBundle, "gmail-ads-inline-app-install-package", "docid");
      ak = ghz.a(paramBundle, "gmail-ads-inline-app-install-referrer", "referrer");
      al = ghz.a(paramBundle, "gmail-ads-app-install-url-package-key", "id");
      am = ghz.a(paramBundle, "gmail-ads-app-install-url-referrer-key", "referrer");
      ap = getActivity().getResources().getDimensionPixelSize(dfw.b);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 111)
    {
      paramIntent = ad;
      if (paramInt2 == -1) {}
      for (paramInt1 = 13;; paramInt1 = 14)
      {
        AsyncTask.execute(new dht(this, paramIntent, paramInt1));
        return;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == dfy.z) {
      b(ad.D.d);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    if (paramBundle != null) {
      aq = paramBundle.getBoolean("wta_tooltip_open");
    }
  }
  
  public final void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(dgb.a, paramMenu);
  }
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == dfy.at)
    {
      paramMenuItem = ad;
      a(null, null);
      b.onBackPressed();
      as.b = paramMenuItem;
      J = System.currentTimeMillis();
      AsyncTask.execute(as);
      b.a_(new AdToastBarOperation(paramMenuItem, f));
      return true;
    }
    return false;
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("wta_tooltip_open", aq);
  }
  
  protected final void p() {}
  
  protected final cmg w()
  {
    return new dhr(this, f);
  }
  
  protected final void x() {}
}

/* Location:
 * Qualified Name:     dhn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */