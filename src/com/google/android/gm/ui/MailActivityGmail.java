package com.google.android.gm.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.UriMatcher;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import anf;
import buo;
import but;
import bvd;
import cfm;
import cfr;
import chc;
import cht;
import cjo;
import cjw;
import ckt;
import ckv;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.ui.MailActivity;
import com.android.mail.ui.toastbar.ActionableToastBar;
import com.google.android.gm.happiness.HatsHolder;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.welcome.WelcomeTourActivity;
import com.google.android.gms.people.accountswitcherview.SelectedAccountNavigationView;
import crj;
import cro;
import ctl;
import cui;
import cuo;
import cvl;
import cvm;
import cxd;
import cxf;
import dev;
import dfh;
import dfy;
import dge;
import dgn;
import dgu;
import dhx;
import dhz;
import dkn;
import dmg;
import dmh;
import dmn;
import dmo;
import dmq;
import dmr;
import dmv;
import dnm;
import dnr;
import dqz;
import dra;
import drd;
import dri;
import dwt;
import dwx;
import dwy;
import dxu;
import dyc;
import dyd;
import dyo;
import dyp;
import dyq;
import dyt;
import dyv;
import dyz;
import dzb;
import fsi;
import ftm;
import ghz;
import giy;
import gjg;
import gjh;
import gji;
import gjk;
import gjl;
import gjm;
import glh;
import gnr;
import gnt;
import hlf;
import hlh;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import rg;

public class MailActivityGmail
  extends MailActivity
  implements dyt
{
  private static final UriMatcher D;
  public static final String v = WelcomeTourActivity.a;
  private dmo A;
  private dyq B;
  private dmh C;
  private SelectedAccountNavigationView E;
  public dgu w;
  public dhz x;
  public dyz y;
  private dmr z;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    D = localUriMatcher;
    localUriMatcher.addURI("gmail-ls", "account/*/label/*", 1);
    D.addURI("com.google.android.gm", "*/label/#", 2);
    D.addURI("com.android.gmail.ui", "*/label/*", 3);
  }
  
  public MailActivityGmail()
  {
    p = new dyc();
  }
  
  private final String E()
  {
    Account localAccount = l.a();
    if (localAccount != null) {
      return c;
    }
    return null;
  }
  
  public final chc A()
  {
    return new dgn(this);
  }
  
  protected final void D()
  {
    if (dmn.a(this))
    {
      localObject1 = (HatsHolder)findViewById(dfy.cl);
      if (localObject1 == null) {
        cvm.b(cvm.a, "Survey holder not found.", new Object[0]);
      }
    }
    else
    {
      return;
    }
    if (C == null) {
      C = new dmh(this, (HatsHolder)localObject1);
    }
    Object localObject5 = C;
    if (!cxd.b())
    {
      dri.b(dmh.a, "Not requesting HaTS: JELLY_BEAN_MR1 or later is required. Current version: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      return;
    }
    Object localObject6 = b.n().a();
    if (dyp.a((Account)localObject6))
    {
      localObject1 = dnm.a(b.getApplicationContext(), c);
      localObject2 = b.getContentResolver();
      if (ghz.a((ContentResolver)localObject2, "gmail_hats_force_survey", false))
      {
        i = 1;
        if (i == 0) {
          break label282;
        }
      }
    }
    label282:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label287;
      }
      dri.b(dmh.a, "Not requesting HaTS: Account %s not applicable.", new Object[] { c });
      return;
      long l1 = Calendar.getInstance().getTimeInMillis();
      long l2 = dmv.a().a(b, null, "hats-survey-last-shown-timestamp", 0L);
      long l3 = d.getLong("hats-survey-start-timestamp", 0L);
      if (l3 != 0L)
      {
        long l4 = ghz.a((ContentResolver)localObject2, "gmail_hats_survey_duration", 604800000L);
        if ((l2 + l4 < l1) && (l1 < l3 + l4))
        {
          i = 1;
          break;
        }
      }
      i = 0;
      break;
    }
    label287:
    Object localObject1 = Locale.getDefault();
    Object localObject3 = String.format(Locale.ENGLISH, "%s-%s", new Object[] { ((Locale)localObject1).getLanguage().toLowerCase(Locale.ENGLISH), ((Locale)localObject1).getCountry().toUpperCase(Locale.ENGLISH) });
    Object localObject4 = ((dmh)localObject5).a((String)localObject3);
    Object localObject2 = localObject4;
    localObject1 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject4))
    {
      dri.b(dmh.a, "HaTS no siteId for full locale code: %s", new Object[] { localObject3 });
      localObject1 = Locale.getDefault().getLanguage().toLowerCase(Locale.ENGLISH);
      localObject2 = ((dmh)localObject5).a((String)localObject1);
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = null;
      if (localObject1 == null) {
        dri.b(dmh.a, "Unable to find HaTS site id. Locale: %s.", new Object[] { Locale.getDefault() });
      }
    }
    else
    {
      dri.a(dmh.a, "HaTS Using locale: \"%s\" siteId: %s", new Object[] { localObject1, localObject2 });
      localObject1 = new gjk((String)localObject2).a("locale", (String)localObject1);
      localObject2 = ghz.a(b.getContentResolver(), "gmail_hats_survey_url", "https://clients4.google.com/insights/consumersurveys/async_survey");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        dri.b(dmh.a, "Setting HaTS survey url: %s", new Object[] { localObject2 });
        ((gjk)localObject1).a("survey_url", (String)localObject2);
      }
      localObject2 = dnm.a(b.getApplicationContext(), c).b("hats-survey-additional-params");
      localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        ((gjk)localObject1).b((String)localObject4, (String)((Map)localObject2).get(localObject4));
      }
      ((gjk)localObject1).b("b", dfh.i(b.g()));
      localObject2 = new DisplayMetrics();
      if (cxd.b()) {
        b.getWindow().getWindowManager().getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject2);
      }
      for (;;)
      {
        ((gjk)localObject1).b("w", String.format(Locale.ENGLISH, "%.0f", new Object[] { Float.valueOf(widthPixels / density) }));
        ((gjk)localObject1).b("h", String.format(Locale.ENGLISH, "%.0f", new Object[] { Float.valueOf(heightPixels / density) }));
        break;
        b.getWindow().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
      }
    }
    localObject2 = c;
    localObject4 = b;
    if (m != null)
    {
      dri.b(HatsHolder.a, "We already requested survey. We might be showing the survey at the moment.", new Object[0]);
      return;
    }
    localObject3 = ((HatsHolder)localObject2).getContext();
    b = ((ckv)localObject4);
    g = ((ckv)localObject4).n().a();
    localObject4 = ((HatsHolder)localObject2).getRootView();
    h = ((ActionableToastBar)((View)localObject4).findViewById(dfy.cr));
    i = ((View)localObject4).findViewById(dfy.aj);
    j = ((View)localObject4).findViewById(dfy.ah);
    k = ((View)localObject4).findViewById(dfy.ak);
    l = ((View)localObject4).findViewById(dfy.bb);
    if (l != null)
    {
      rg.c(l, 4);
      l.setOnClickListener((View.OnClickListener)localObject2);
    }
    ((HatsHolder)localObject2).findViewById(dfy.ba).setOnClickListener((View.OnClickListener)localObject2);
    ((HatsHolder)localObject2).findViewById(dfy.bc).setOnClickListener((View.OnClickListener)localObject2);
    dri.b(HatsHolder.a, "Requesting HaTS.", new Object[0]);
    m = new gjg((Context)localObject3, (giy)localObject2, (gjk)localObject1);
    n = new dmg(((Context)localObject3).getContentResolver(), dnr.a((Context)localObject3, g.c), m, ((gjk)localObject1).a("site_id"), ((gjk)localObject1).b("w"), ((gjk)localObject1).b("h"));
    localObject3 = m;
    localObject1 = g.getSettings();
    ((WebSettings)localObject1).setJavaScriptEnabled(true);
    ((WebSettings)localObject1).setDatabaseEnabled(false);
    ((WebSettings)localObject1).setDomStorageEnabled(true);
    localObject4 = c.a("user_agent");
    if (localObject4 != null) {
      ((WebSettings)localObject1).setUserAgentString((String)localObject4);
    }
    i = (int)(d.getResources().getConfiguration().fontScale * 100.0F);
    new StringBuilder(33).append("Setting text zoom to: ").append(i);
    ((WebSettings)localObject1).setTextZoom(i);
    g.addJavascriptInterface(b, "_402m_native");
    g.setOnLongClickListener(new gjh((gjg)localObject3));
    g.setWebChromeClient(new gji((gjg)localObject3));
    g.setWebViewClient(new gjl());
    CookieSyncManager.createInstance(g.getContext());
    localObject4 = CookieManager.getInstance();
    ((CookieManager)localObject4).setAcceptCookie(true);
    ((CookieManager)localObject4).removeAllCookie();
    localObject5 = f;
    localObject1 = ((gjm)localObject5).a();
    if (((String)localObject1).isEmpty()) {}
    Object localObject7;
    for (localObject1 = null;; localObject1 = String.valueOf(localObject1).length() + 26 + String.valueOf(localObject6).length() + String.valueOf(localObject7).length() + String.valueOf(localObject5).length() + (String)localObject1 + "; expires=" + (String)localObject6 + "; path=" + (String)localObject7 + "; domain=" + (String)localObject5)
    {
      if (localObject1 != null)
      {
        localObject5 = String.valueOf(f.c);
        new StringBuilder(String.valueOf(localObject5).length() + 30 + String.valueOf(localObject1).length()).append("Setting cookie on URL=").append((String)localObject5).append(", value=").append((String)localObject1);
        ((CookieManager)localObject4).setCookie(f.c, (String)localObject1);
      }
      CookieSyncManager.getInstance().sync();
      g.onResume();
      String str2 = c.a("site_id");
      localObject1 = String.valueOf(gjg.a("onWindowError", null));
      localObject4 = String.valueOf(gjg.b());
      localObject5 = String.valueOf(gjg.a("onSurveyComplete", new String[] { "justAnswered", "unused" }));
      localObject6 = String.valueOf(gjg.a("onSurveyCanceled", null));
      localObject7 = String.valueOf(gjg.c());
      String str1 = String.valueOf(c.c("_402m"));
      str2 = String.valueOf(String.format("<script src=\"%s?site=%s\"></script>", new Object[] { e, str2 }));
      localObject1 = String.valueOf(localObject1).length() + 194 + String.valueOf(localObject4).length() + String.valueOf(localObject5).length() + String.valueOf(localObject6).length() + String.valueOf(localObject7).length() + String.valueOf(str1).length() + String.valueOf(str2).length() + "<!doctype><html><head><meta name=\"viewport\" content=\"initial-scale=1.0,user-scalable=no\"><script>_402m = {};" + (String)localObject1 + "window.onerror=function(){_402m.onWindowError();};" + (String)localObject4 + (String)localObject5 + (String)localObject6 + (String)localObject7 + str1 + "</script>" + str2 + "</head><body></body></html>";
      g.loadDataWithBaseURL(String.valueOf(f.c).concat("/hats_shim"), (String)localObject1, "text/html", null, null);
      ((HatsHolder)localObject2).i();
      b.getFragmentManager().beginTransaction().add(dfy.bd, m.a(), "hats-survey").commitAllowingStateLoss();
      return;
      localObject6 = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss zzz", Locale.US);
      ((SimpleDateFormat)localObject6).setTimeZone(TimeZone.getTimeZone("GMT"));
      localObject7 = Calendar.getInstance();
      ((Calendar)localObject7).add(1, 1);
      localObject6 = ((SimpleDateFormat)localObject6).format(Long.valueOf(((Calendar)localObject7).getTimeInMillis()));
      localObject7 = b;
      localObject5 = a;
    }
  }
  
  public final bvd a(Context paramContext, anf paramanf)
  {
    return new dwy(paramContext, y.f, l.a().c, paramanf);
  }
  
  public final cro a(Bundle paramBundle)
  {
    if (ghz.a(getContentResolver(), "gmail_enable_asfe_suggestions", true)) {
      return new dwt(this, l, paramBundle);
    }
    return super.a(paramBundle);
  }
  
  public final void a(int paramInt, Account paramAccount)
  {
    dmo localdmo = A;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(38 + "Unknown active event type: " + paramInt);
    case 1: 
      paramInt = 1;
    }
    for (;;)
    {
      localdmo.a(paramInt, paramAccount);
      return;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 5;
      continue;
      paramInt = 6;
      continue;
      paramInt = 7;
      continue;
      paramInt = 8;
      continue;
      paramInt = 9;
      continue;
      paramInt = 10;
      continue;
      paramInt = 11;
      continue;
      paramInt = 12;
      continue;
      paramInt = 13;
      continue;
      paramInt = 14;
    }
  }
  
  public final void a(View paramView)
  {
    if (cxf.a(this))
    {
      dmr localdmr = z;
      String str = E();
      a.a(dmr.a(paramView, new dmq()), str);
    }
  }
  
  public final void a(View paramView, int paramInt)
  {
    if (cxf.a(this))
    {
      dmr localdmr = z;
      String str = E();
      a.a(dmr.a(paramView, new dmq(4)), str);
    }
  }
  
  protected final void a(Account paramAccount)
  {
    dzb.a(this, paramAccount);
  }
  
  public final void a(Account paramAccount, int paramInt)
  {
    if (crj.b(paramInt)) {
      paramInt = dge.bL;
    }
    for (;;)
    {
      Account[] arrayOfAccount = l.k();
      dev.a(this);
      new dyv().a(this, paramAccount, getString(paramInt), arrayOfAccount);
      return;
      if (crj.a(paramInt)) {
        paramInt = dge.bK;
      } else {
        paramInt = dge.bQ;
      }
    }
  }
  
  public final void a(gnr paramgnr)
  {
    if (cxf.a(this, l.a())) {}
    for (String str = E();; str = null)
    {
      a(paramgnr, 25, str);
      return;
    }
  }
  
  public final void a(gnr paramgnr, int paramInt, String paramString)
  {
    cvm.a(cvl.a, "VisualElement: Recording system event with address %s", new Object[] { paramString });
    z.a(paramgnr, 25, paramString);
  }
  
  public final void a(gnr paramgnr, View paramView)
  {
    if (cxf.a(this))
    {
      Object localObject = z;
      String str = E();
      localObject = a;
      dmq localdmq = new dmq(4);
      localdmq.a(paramgnr);
      dmr.a(paramView, localdmq);
      ((dmo)localObject).a(localdmq, str);
    }
  }
  
  public final gnt b(Folder paramFolder)
  {
    int i;
    if (paramFolder != null)
    {
      paramFolder = GmailProvider.a(paramFolder);
      i = -1;
      switch (paramFolder.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return null;
        if (paramFolder.equals("^sq_ig_i_promo"))
        {
          i = 0;
          continue;
          if (paramFolder.equals("^sq_ig_i_social"))
          {
            i = 1;
            continue;
            if (paramFolder.equals("^sq_ig_i_notification"))
            {
              i = 2;
              continue;
              if (paramFolder.equals("^sq_ig_i_group"))
              {
                i = 3;
                continue;
                if (paramFolder.equals("^sq_ig_i_personal"))
                {
                  i = 4;
                  continue;
                  if (paramFolder.equals("^i"))
                  {
                    i = 5;
                    continue;
                    if (paramFolder.equals("^iim")) {
                      i = 6;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return hlf.i;
    return hlf.m;
    return hlf.o;
    return hlf.g;
    return hlh.m;
    return hlh.h;
    return hlh.n;
  }
  
  public final void b(int paramInt, Account paramAccount)
  {
    if (paramInt == dfy.as) {
      paramInt = 2;
    }
    for (;;)
    {
      a(paramInt, paramAccount);
      do
      {
        return;
        if (paramInt == dfy.bM)
        {
          paramInt = 3;
          break;
        }
        if (paramInt == dfy.cs)
        {
          paramInt = 4;
          break;
        }
        if (paramInt == dfy.bm)
        {
          paramInt = 7;
          break;
        }
        if (paramInt == dfy.bn)
        {
          paramInt = 8;
          break;
        }
        if (paramInt == dfy.ax)
        {
          paramInt = 9;
          break;
        }
        if (paramInt == dfy.aw)
        {
          paramInt = 10;
          break;
        }
      } while (paramInt != dfy.bQ);
      paramInt = 11;
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (Build.VERSION.SDK_INT >= 18) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramPrintWriter.append(paramString).append("Gmail account states:");
      paramFileDescriptor = l.k();
      int k = paramFileDescriptor.length;
      i = j;
      while (i < k)
      {
        paramArrayOfString = paramFileDescriptor[i];
        String str = c;
        dnm localdnm = dnm.a(this, str);
        paramPrintWriter.println();
        ctl.a(paramString, paramPrintWriter, str, dfh.a(this, paramArrayOfString), localdnm);
        i += 1;
      }
    }
  }
  
  public final void h(int paramInt)
  {
    if (paramInt == 1000)
    {
      finish();
      return;
    }
    y.g = false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (y.a(paramInt1, paramInt2)) {
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    dev.a(this);
    if (dev.b)
    {
      dev.b = false;
      glh.a.a("Application ready");
    }
    A = ae;
    z = af;
    Object localObject1 = getIntent();
    int k;
    Object localObject3;
    int i;
    int j;
    if (((Intent)localObject1).getBooleanExtra("launched-from-welcome-tour", false))
    {
      k = 0;
      if (k != 0)
      {
        super.onCreate(paramBundle);
        finish();
      }
    }
    else
    {
      localObject3 = dmv.a();
      i = ghz.a(getContentResolver(), "gmail_welcome_tour_debug_mode", -3);
      j = ((dmv)localObject3).l(this);
      if (i == -3) {
        break label932;
      }
      cvm.b(WelcomeTourActivity.a, "Overriding welcome tour version to %d because GServices %s flag was set", new Object[] { Integer.valueOf(i), "gmail_welcome_tour_debug_mode" });
    }
    for (;;)
    {
      if (i == -2)
      {
        cvm.b(WelcomeTourActivity.a, "Shared pref was absent :-( Defaulting to welcome tour for returning user", new Object[0]);
        j = 0;
        i = 1;
      }
      for (;;)
      {
        k = i;
        if (i == 0) {
          break;
        }
        WelcomeTourActivity.c = (Intent)localObject1;
        cvm.b(v, "Retained pendingIntent %s", new Object[] { ((Intent)localObject1).getAction() });
        cvm.b(WelcomeTourActivity.a, "Starting welcome tour", new Object[0]);
        localObject3 = new Intent(this, WelcomeTourActivity.class);
        ((Intent)localObject3).putExtra("tour-highest-version-seen", j);
        ((Intent)localObject3).putExtra("source", ((Intent)localObject1).getAction());
        ((Intent)localObject3).setFlags(67108864);
        startActivity((Intent)localObject3);
        k = i;
        break;
        if (i <= 0)
        {
          cvm.b(WelcomeTourActivity.a, "Displaying welcome tour because seen version %d is less than current %d", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
          j = i;
          i = 1;
        }
        else if (((dmv)localObject3).a(this, null, "force_show_welcome_tour", false))
        {
          cvm.b(WelcomeTourActivity.a, "Force display welcome tour pref was set", new Object[0]);
          j = i;
          i = 1;
        }
        else
        {
          cvm.b(WelcomeTourActivity.a, "Welcome tour not required", new Object[0]);
          j = i;
          i = 0;
        }
      }
      Intent localIntent = getIntent();
      localObject1 = localIntent.getAction();
      if ((localObject1 == null) && (localIntent.hasExtra("label")) && (localIntent.hasExtra("account")))
      {
        localObject1 = localIntent.getStringExtra("label");
        localObject3 = localIntent.getStringExtra("account");
        if ((localObject3 == null) || (localObject1 == null)) {
          break label925;
        }
      }
      Object localObject2;
      label868:
      label875:
      label925:
      for (localObject1 = dfh.b(this, (String)localObject3, (String)localObject1);; localObject2 = localIntent)
      {
        setIntent((Intent)localObject1);
        y = new dxu(this, this, paramBundle, "state-resolving-people-error", "Contacts");
        q = new dyd(this);
        super.onCreate(paramBundle);
        paramBundle = this.l;
        if ((paramBundle != null) && ((paramBundle instanceof cht)))
        {
          w = new dgu();
          J = w;
          x = new dhz();
          m.a(x);
        }
        if (dkn.a()) {
          dkn.a(this, false);
        }
        r = new dhx(dfh.c(this));
        paramBundle = this.l.h();
        if (paramBundle == null) {
          break;
        }
        paramBundle = paramBundle.getView();
        if (paramBundle == null) {
          break;
        }
        E = ((SelectedAccountNavigationView)paramBundle.findViewById(dfy.g));
        return;
        if (("android.intent.action.VIEW".equals(localObject1)) && (localIntent.getData() != null))
        {
          localObject1 = localIntent.getData();
          switch (D.match((Uri)localObject1))
          {
          }
        }
        for (;;)
        {
          localObject1 = null;
          localObject3 = null;
          break;
          localObject1 = localIntent.getData().getPathSegments();
          localObject3 = (String)((List)localObject1).get(1);
          localObject1 = (String)((List)localObject1).get(3);
          break;
          cvm.b(cvm.a, "Public content provider view intent", new Object[0]);
          localObject1 = localIntent.getData().getPathSegments();
          localObject3 = (String)((List)localObject1).get(0);
          localObject1 = (String)((List)localObject1).get(2);
          for (;;)
          {
            try
            {
              long l = Long.parseLong((String)localObject1);
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label875;
              }
              localObject1 = drd.a(this, (String)localObject3, false);
              j = a.size();
              i = 0;
              if (i >= j) {
                break label875;
              }
              dqz localdqz = ((dra)localObject1).a(i);
              if ((localdqz == null) || (localdqz.a() != l)) {
                break label868;
              }
              localObject1 = localdqz.b();
            }
            catch (NumberFormatException localNumberFormatException)
            {
              cvm.e(cvm.a, localNumberFormatException, "problem parsing labelId", new Object[0]);
              localObject2 = null;
            }
            break;
            i += 1;
          }
          localObject2 = null;
          break;
          localObject2 = ((Uri)localObject2).buildUpon().appendQueryParameter("inboxFallback", Boolean.TRUE.toString()).build();
          localIntent.setData((Uri)localObject2);
          localIntent.putExtra("folderUri", (Parcelable)localObject2);
        }
      }
      label932:
      i = j;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (B != null) {
      B.cancel(true);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (ghz.a(getContentResolver(), "gmail_enable_conscrypt_provider", true))
    {
      B = new dyq(this);
      B.execute(new Void[0]);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    y.b(paramBundle);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    y.d();
    ((dyd)q).a();
  }
  
  protected void onStop()
  {
    Object localObject = this.l.k();
    if (dmv.a().l(this) > 0)
    {
      cfm localcfm = cfm.a(this);
      long l = System.currentTimeMillis();
      if (l - d.getLong("analytics-send-nb_accounts-epoch", 0L) > 86400000L)
      {
        e.putLong("analytics-send-nb_accounts-epoch", l).apply();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localcfm = localObject[i];
          String str1 = cui.b(c);
          String str2 = dyp.a(c, str1);
          buo.a().a("account_present", dyp.b(str1, str2), e, 0L);
          i += 1;
        }
      }
    }
    localObject = (dyd)q;
    if (c != null)
    {
      b.unbindService(c);
      c = null;
    }
    d = null;
    y.e();
    super.onStop();
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    if (E != null)
    {
      Object localObject = E;
      if (paramInt >= 60)
      {
        if (j != null)
        {
          if (j.n != null) {
            j.n.setImageBitmap(null);
          }
          if (j.v != null) {
            j.v.setImageBitmap(null);
          }
        }
        if (e != null)
        {
          localObject = e;
          Iterator localIterator = d.values().iterator();
          while (localIterator.hasNext()) {
            ((Bitmap)localIterator.next()).recycle();
          }
          d.clear();
        }
      }
    }
  }
  
  public final ckt v()
  {
    return new dwx(this, y.f, l.a().c);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ui.MailActivityGmail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */