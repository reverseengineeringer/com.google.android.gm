package com.android.mail.browse;

import adg;
import adu;
import aeh;
import akg;
import akh;
import aki;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.AsyncQueryHandler;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.TextAppearanceSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import aoa;
import bhk;
import btn;
import bto;
import btq;
import btr;
import btz;
import bua;
import bub;
import buc;
import bue;
import buf;
import buh;
import buj;
import buk;
import buo;
import bus;
import but;
import bva;
import bvz;
import bwd;
import bxh;
import bxp;
import bxu;
import bxz;
import byz;
import bza;
import bzb;
import bzc;
import bzd;
import bzf;
import bzg;
import bzh;
import bzl;
import bzm;
import bzt;
import bzv;
import car;
import cas;
import caz;
import cba;
import cbf;
import cbk;
import cer;
import cev;
import cez;
import cff;
import cft;
import cjf;
import com.android.emailcommon.mail.Address;
import com.android.mail.browse.calendar.ProposedNewTimeHeaderView;
import com.android.mail.browse.calendar.RsvpAgendaView;
import com.android.mail.browse.calendar.RsvpHeaderView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Event;
import com.android.mail.providers.Message;
import com.android.mail.providers.Settings;
import com.android.mail.text.EmailAddressSpan;
import com.android.mail.ui.MailActivity;
import cop;
import cts;
import cui;
import cuo;
import cvl;
import cvm;
import cwm;
import cwt;
import cxa;
import cxd;
import cxf;
import gnu;
import hbc;
import hlg;
import java.io.IOException;
import java.io.StringReader;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jr;
import mx;
import yq;
import yw;

public class MessageHeaderView
  extends LinearLayout
  implements aki, View.OnClickListener, bwd, bzb, bzl
{
  private static final String m = cvl.a;
  private View A;
  private ProposedNewTimeHeaderView B;
  private View C;
  private View D;
  private View E;
  private View F;
  private TextView G;
  private View H;
  private View I;
  private ImageView J;
  private final bxz K = new bxz(getContext());
  private boolean L;
  private String[] M;
  private String[] N;
  private String[] O;
  private String[] P;
  private String[] Q;
  private boolean R = false;
  private int S;
  private String T;
  private Address U;
  private boolean V;
  private bvz W;
  public bzg a;
  private Map<String, Address> aa;
  private boolean ab;
  private bza ac;
  private ConversationMessage ad;
  private boolean ae;
  private boolean af;
  private final LayoutInflater ag;
  private AsyncQueryHandler ah;
  private boolean ai;
  private boolean aj = false;
  private final String ak;
  private final DataSetObserver al = new bzc(this);
  private cff am;
  private final int an;
  private final int ao;
  private final int ap;
  private mx aq;
  private final cez ar = new cez();
  private int as = 0;
  public bto b;
  public bxu c;
  public boolean d = true;
  public LoaderManager e;
  public FragmentManager f;
  public bzf g;
  public cbf h;
  public cba i;
  public bzh j;
  public cas k;
  public boolean l = false;
  private View n;
  private View o;
  private ViewGroup p;
  private TextView q;
  private LinearLayout r;
  private TextView s;
  private View t;
  private TextView u;
  private byz v;
  private ViewGroup w;
  private ViewGroup x;
  private SpamWarningView y;
  private TextView z;
  
  public MessageHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MessageHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ag = LayoutInflater.from(paramContext);
    ak = paramContext.getString(buj.cW);
    paramContext = getResources();
    an = paramContext.getDimensionPixelSize(bua.r);
    ao = paramContext.getDimensionPixelSize(bua.q);
    ap = paramContext.getDimensionPixelSize(bua.C);
  }
  
  private final String a(Address paramAddress)
  {
    if (paramAddress == null) {
      return "";
    }
    String str2 = b;
    mx localmx = j();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = a;
    }
    return localmx.a(str1);
  }
  
  private final void a(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    Resources localResources = getResources();
    Account localAccount = h();
    mx localmx = j();
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return;
    }
    Object localObject3 = new String[paramArrayOfString.length];
    int i1 = 0;
    if (i1 < paramArrayOfString.length)
    {
      localObject2 = cxa.a(aa, paramArrayOfString[i1]);
      if (localObject2 == null)
      {
        localObject1 = null;
        label66:
        if (localObject2 != null) {
          break label123;
        }
        localObject2 = null;
        label74:
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equalsIgnoreCase((String)localObject2))) {
          break label133;
        }
        localObject3[i1] = localmx.a((String)localObject2);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localObject1 = b;
        break label66;
        label123:
        localObject2 = a;
        break label74;
        label133:
        localObject3[i1] = localResources.getString(buj.k, new Object[] { localmx.a((String)localObject1), localmx.a((String)localObject2) });
      }
    }
    paramArrayOfString = (TextView)x.findViewById(paramInt1);
    paramArrayOfString.setVisibility(0);
    Object localObject1 = (TextView)x.findViewById(paramInt2);
    ((TextView)localObject1).setText(TextUtils.join("\n", (Object[])localObject3));
    Object localObject2 = (Spannable)((TextView)localObject1).getText();
    localObject3 = ((TextView)localObject1).getUrls();
    paramInt2 = localObject3.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      localmx = localObject3[paramInt1];
      i1 = ((Spannable)localObject2).getSpanStart(localmx);
      int i2 = ((Spannable)localObject2).getSpanEnd(localmx);
      ((Spannable)localObject2).removeSpan(localmx);
      ((Spannable)localObject2).setSpan(new EmailAddressSpan(localAccount, localmx.getURL().substring(7)), i1, i2, 33);
      paramInt1 += 1;
    }
    ((TextView)localObject1).setContentDescription(localResources.getString(buj.aY, new Object[] { paramArrayOfString.getText(), ((TextView)localObject1).getText() }));
    ((TextView)localObject1).setVisibility(0);
  }
  
  private final void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 8)
    {
      p();
      u();
      s();
      q();
      r();
      p.setOnCreateContextMenuListener(null);
      return;
    }
    d(c.h);
    label82:
    Object localObject7;
    Object localObject5;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    Object localObject2;
    Object localObject8;
    Object localObject9;
    Object localObject6;
    label364:
    label431:
    label493:
    label603:
    label744:
    label752:
    boolean bool;
    if (ad.K == null)
    {
      u();
      if (!ab) {
        break label1423;
      }
      if (!c.i) {
        break label1416;
      }
      e(true);
      if (!ad.d()) {
        break label1995;
      }
      if (A == null)
      {
        A = ag.inflate(bue.Q, this, false);
        w.addView(A);
      }
      localObject7 = (RsvpHeaderView)A;
      localObject5 = h();
      localObject3 = ad;
      localObject4 = e;
      localObject1 = f;
      localObject2 = aa;
      localObject8 = j();
      localObject9 = g;
      cbf localcbf = h;
      localObject6 = c.m;
      cas localcas = k;
      p = ((Message)localObject3);
      q = ((FragmentManager)localObject1);
      r = ((Map)localObject2);
      s = ((mx)localObject8);
      t = ((bzf)localObject9);
      u = localcbf;
      v = localcas;
      localObject1 = Calendar.getInstance();
      w = car.a(T.d, T.b, ((Calendar)localObject1).getTimeZone());
      ((Calendar)localObject1).setTimeInMillis(w);
      localObject8 = ((RsvpHeaderView)localObject7).getContext();
      b.setText(((Calendar)localObject1).getDisplayName(2, 1, Locale.getDefault()));
      c.setText(String.valueOf(((Calendar)localObject1).get(5)));
      localObject2 = d;
      if (!TextUtils.isEmpty(T.a)) {
        break label1430;
      }
      localObject1 = ((Context)localObject8).getText(buj.cw);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      if (T.i != 0) {
        break label1443;
      }
      e.setVisibility(8);
      f.setVisibility(0);
      g.setVisibility(8);
      h.setVisibility(8);
      i.setVisibility(8);
      j.setText(car.a((Context)localObject8, T.b, T.c, T.d, false));
      if (!TextUtils.isEmpty(T.e)) {
        break label1764;
      }
      k.setVisibility(8);
      localObject1 = ((RsvpHeaderView)localObject7).getContext();
      localObject1 = new bzm((Context)localObject1, null, null, ((Context)localObject1).getText(buj.bL), r, s);
      g = false;
      f = false;
      ((bzm)localObject1).a(p.T.f);
      ((bzm)localObject1).a(Message.f(p.T.g));
      localObject1 = c;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1876;
      }
      m.setVisibility(8);
      localObject1 = o;
      b = c;
      c = this;
      d = ((Message)localObject3);
      e = ((LoaderManager)localObject4);
      f = ((btq)localObject6);
      h = false;
      localObject2 = Integer.valueOf(f.hashCode());
      if ((g != null) && (!hbc.a(g, localObject2)))
      {
        ((LoaderManager)localObject4).destroyLoader(g.intValue());
        ((RsvpAgendaView)localObject1).removeAllViews();
      }
      g = ((Integer)localObject2);
      if (!paramBoolean)
      {
        if (!cwm.a(((RsvpAgendaView)localObject1).getContext(), "android.permission.READ_CALENDAR")) {
          break label1898;
        }
        ((RsvpAgendaView)localObject1).a();
        bus.a("calendar_agenda", "enabled");
      }
      A.setVisibility(0);
      if (ad != null) {}
      switch (ad.ad)
      {
      default: 
        bool = false;
        label798:
        if (bool)
        {
          if (B == null)
          {
            B = ((ProposedNewTimeHeaderView)ag.inflate(bue.ab, this, false));
            w.addView(B);
          }
          localObject3 = B;
          localObject2 = ad;
          localObject1 = h();
          if (localObject1 != null)
          {
            localObject1 = c;
            label869:
            localObject4 = g;
            localObject5 = e;
            localObject6 = j();
            localObject7 = i;
            localObject8 = j;
            localObject9 = ad.F;
            n = ((Message)localObject2);
            o = ((String)localObject1);
            p = ((bzf)localObject4);
            s = ((LoaderManager)localObject5);
            t = ((mx)localObject6);
            u = ((cba)localObject7);
            v = ((bzh)localObject8);
            r = ((String)localObject9);
            if (v != null) {
              v.a((bzl)localObject3);
            }
            if (n != null) {}
            switch (n.ad)
            {
            default: 
              ((ProposedNewTimeHeaderView)localObject3).setVisibility(8);
              label1039:
              B.setVisibility(0);
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      p.setOnCreateContextMenuListener(K);
      return;
      if (y == null)
      {
        y = ((SpamWarningView)ag.inflate(bue.u, this, false));
        w.addView(y);
      }
      localObject1 = y;
      localObject2 = ad;
      localObject5 = U;
      localObject3 = h();
      localObject4 = ((SpamWarningView)localObject1).getResources();
      ((SpamWarningView)localObject1).setVisibility(0);
      localObject5 = a;
      localObject6 = cui.b((String)localObject5);
      localObject5 = Html.fromHtml(String.format(K, new Object[] { localObject5, localObject6 }));
      if ((localObject3 != null) && (ag != null))
      {
        localObject6 = ((Resources)localObject4).getString(buj.cP);
        localObject7 = new SpannableString(new StringBuilder().append((CharSequence)localObject5).append(" ").append((String)localObject6));
        ((SpannableString)localObject7).setSpan(new bzv((SpamWarningView)localObject1, (Account)localObject3, (Message)localObject2, (Resources)localObject4), ((Spanned)localObject5).length() + 1, ((Spanned)localObject5).length() + 1 + ((String)localObject6).length(), 33);
        g.setMovementMethod(LinkMovementMethod.getInstance());
        g.setText((CharSequence)localObject7);
        label1296:
        if (L != 2) {
          break label1381;
        }
        g.setTextColor(((Resources)localObject4).getColor(btz.t));
        i.setBackgroundColor(((Resources)localObject4).getColor(btz.N));
      }
      while ((L == 3) || (L == 4))
      {
        h.setVisibility(8);
        break;
        g.setText((CharSequence)localObject5);
        break label1296;
        label1381:
        g.setTextColor(((Resources)localObject4).getColor(btz.B));
        i.setBackgroundColor(((Resources)localObject4).getColor(btz.P));
      }
      label1416:
      t();
      break label82;
      label1423:
      s();
      break label82;
      label1430:
      localObject1 = T.a;
      break label364;
      label1443:
      if (T.i == 4)
      {
        e.setText(buj.cr);
        ((RsvpHeaderView)localObject7).b();
        break label431;
      }
      if (T.i == 2)
      {
        paramInt = T.k;
        if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
        {
          ((RsvpHeaderView)localObject7).a();
          g.setEnabled(false);
          h.setEnabled(false);
          i.setEnabled(false);
          cvm.e(RsvpHeaderView.a, "unrecognized response status: %s", new Object[] { Integer.valueOf(T.k) });
          cvm.b(RsvpHeaderView.a, "event: %s", new Object[] { T });
          break label431;
        }
        switch (paramInt)
        {
        default: 
          paramInt = buj.cF;
          label1624:
          localObject9 = cxa.a(r, T.j);
          if (localObject9 == null) {
            localObject1 = "";
          }
          break;
        }
        for (;;)
        {
          e.setText(Html.fromHtml(((Context)localObject8).getString(paramInt, new Object[] { s.a((String)localObject1) })));
          ((RsvpHeaderView)localObject7).b();
          break;
          paramInt = buj.cn;
          break label1624;
          paramInt = buj.cv;
          break label1624;
          localObject2 = b;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = a;
          }
        }
      }
      ((RsvpHeaderView)localObject7).a();
      ((RsvpHeaderView)localObject7).a(u.c(p));
      break label431;
      label1764:
      k.setVisibility(0);
      localObject1 = aoa.a(T.e);
      l.setText((CharSequence)localObject1);
      if (((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), Object.class).length > 0)
      {
        k.setOnClickListener(null);
        l.setMovementMethod(LinkMovementMethod.getInstance());
        cwt.a((Spannable)l.getText());
        break label493;
      }
      k.setOnClickListener((View.OnClickListener)localObject7);
      l.setMovementMethod(null);
      break label493;
      label1876:
      m.setVisibility(0);
      n.setText((CharSequence)localObject1);
      break label603;
      label1898:
      ((RsvpAgendaView)localObject1).removeAllViews();
      localObject2 = ((RsvpAgendaView)localObject1).getContext();
      localObject4 = (TextView)LayoutInflater.from((Context)localObject2).inflate(bue.R, (ViewGroup)localObject1, false);
      ((TextView)localObject4).setText(((Context)localObject2).getString(buj.cD, new Object[] { car.a((Context)localObject2, T.b, T.d) }));
      ((RsvpAgendaView)localObject1).addView((View)localObject4);
      bus.a("calendar_agenda", "disabled");
      h = false;
      break label744;
      label1995:
      q();
      break label752;
      bool = true;
      break label798;
      bool = ad.f();
      break label798;
      localObject1 = null;
      break label869;
      ((ProposedNewTimeHeaderView)localObject3).setVisibility(0);
      g.setVisibility(0);
      j.setVisibility(8);
      break label1039;
      ((ProposedNewTimeHeaderView)localObject3).setVisibility(0);
      g.setVisibility(8);
      j.setVisibility(0);
      h.setVisibility(8);
      i.setVisibility(0);
      break label1039;
      if (n.f())
      {
        if (n != null)
        {
          d.setText(w.a(((ProposedNewTimeHeaderView)localObject3).getContext(), n.aa, n.ab));
          if (!TextUtils.isEmpty(n.Z)) {
            break label2436;
          }
          f.setVisibility(8);
          label2181:
          if (n.T != null)
          {
            b.setText(n.T.a);
            c.setText(x.a(((ProposedNewTimeHeaderView)localObject3).getContext(), n.T.b, n.T.c));
          }
          localObject1 = null;
          localObject4 = Address.c(n.j);
          if (localObject4 != null)
          {
            if (localObject4 != null) {
              break label2464;
            }
            localObject1 = "";
          }
          label2286:
          switch (n.ac)
          {
          default: 
            localObject1 = null;
            label2323:
            if (localObject1 != null) {
              e.setText((CharSequence)localObject1);
            }
            if ((r != null) && (!paramBoolean))
            {
              if ((!cwm.a(((ProposedNewTimeHeaderView)localObject3).getContext(), "android.permission.READ_CALENDAR")) || (!cwm.a(((ProposedNewTimeHeaderView)localObject3).getContext(), "android.permission.WRITE_CALENDAR"))) {
                break label2592;
              }
              paramInt = 1;
              label2380:
              if (paramInt == 0) {
                break label2597;
              }
              ((ProposedNewTimeHeaderView)localObject3).b();
            }
            break;
          }
        }
        for (;;)
        {
          ((ProposedNewTimeHeaderView)localObject3).setVisibility(0);
          g.setVisibility(8);
          j.setVisibility(0);
          h.setVisibility(0);
          i.setVisibility(8);
          break;
          label2436:
          f.setText(n.Z);
          f.setVisibility(0);
          break label2181;
          label2464:
          localObject2 = b;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label2286;
          }
          localObject1 = a;
          break label2286;
          localObject1 = t.a(((ProposedNewTimeHeaderView)localObject3).getResources().getString(buj.dL, new Object[] { localObject1 }));
          break label2323;
          localObject1 = t.a(((ProposedNewTimeHeaderView)localObject3).getResources().getString(buj.dN, new Object[] { localObject1 }));
          break label2323;
          localObject1 = t.a(((ProposedNewTimeHeaderView)localObject3).getResources().getString(buj.dM, new Object[] { localObject1 }));
          break label2323;
          label2592:
          paramInt = 0;
          break label2380;
          label2597:
          ((ProposedNewTimeHeaderView)localObject3).a();
        }
      }
      ((ProposedNewTimeHeaderView)localObject3).setVisibility(8);
      break label1039;
      r();
    }
  }
  
  private static void a(int paramInt, View... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = paramVarArgs[i1];
      if (localView != null) {
        localView.setVisibility(paramInt);
      }
      i1 += 1;
    }
  }
  
  private static void a(View paramView, int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    if (cxd.b()) {
      localMarginLayoutParams.setMarginEnd(paramInt);
    }
    for (;;)
    {
      paramView.setLayoutParams(localMarginLayoutParams);
      return;
      rightMargin = paramInt;
    }
  }
  
  private final void a(String paramString)
  {
    if (ad != null) {
      if (ad.W != 2) {
        break label37;
      }
    }
    label37:
    for (String str = "icon_visible";; str = "icon_gone")
    {
      buo.a().a("gmail_tls", paramString, str, 0L);
      return;
    }
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    paramString = new StringReader(paramString);
    for (;;)
    {
      try
      {
        int i2 = paramString.read();
        if ((i2 != -1) && (localStringBuilder.length() < 100))
        {
          i1 = i2;
          if (!Character.isWhitespace(i2)) {
            continue;
          }
          localStringBuilder.append(' ');
          i1 = paramString.read();
          if (Character.isWhitespace(i1)) {
            continue;
          }
          if (i1 != -1)
          {
            continue;
            i1 = paramString.read();
            if ((i1 != -1) && (i1 != 62)) {
              continue;
            }
            if (i1 != -1) {
              continue;
            }
          }
        }
        return localStringBuilder.toString();
        if (i1 == 38)
        {
          localObject = new StringBuilder();
          i1 = paramString.read();
          if ((i1 != -1) && (i1 != 59))
          {
            ((StringBuilder)localObject).append((char)i1);
            continue;
          }
        }
      }
      catch (IOException paramString)
      {
        int i1;
        cvm.f(m, paramString, "Really? IOException while reading a freaking string?!? ", new Object[0]);
        continue;
        Object localObject = ((StringBuilder)localObject).toString();
        if ("nbsp".equals(localObject))
        {
          localStringBuilder.append(' ');
        }
        else if ("lt".equals(localObject))
        {
          localStringBuilder.append('<');
        }
        else if ("gt".equals(localObject))
        {
          localStringBuilder.append('>');
        }
        else if ("amp".equals(localObject))
        {
          localStringBuilder.append('&');
        }
        else if ("quot".equals(localObject))
        {
          localStringBuilder.append('"');
        }
        else if (("apos".equals(localObject)) || ("#39".equals(localObject)))
        {
          localStringBuilder.append('\'');
        }
        else
        {
          localStringBuilder.append('&').append((String)localObject);
          if (i1 == 59)
          {
            localStringBuilder.append(';');
            continue;
            localStringBuilder.append((char)i1);
            continue;
            if (i1 != 60) {
              continue;
            }
            continue;
          }
        }
        if (i1 == -1) {}
      }
    }
  }
  
  private final void b(boolean paramBoolean)
  {
    setActivated(paramBoolean);
    if (c != null)
    {
      bxu localbxu = c;
      if (g != paramBoolean) {
        g = paramBoolean;
      }
    }
  }
  
  private final boolean b(View paramView, int paramInt)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    if (ad == null)
    {
      cvm.c(m, "ignoring message header tap on unbound view", new Object[0]);
      return bool2;
    }
    if (paramInt == buc.dR)
    {
      a.a(hlg.i, this);
      cbk.c(getContext(), h(), ad);
      bool1 = true;
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (paramInt == buc.df) {
        break;
      }
      bool2 = bool1;
      if (paramInt == buc.ab) {
        break;
      }
      buo.a().a("menu_item", paramInt, "message_header");
      return bool1;
      if (paramInt == buc.dS)
      {
        a.a(hlg.h, this);
        cbk.d(getContext(), h(), ad);
        bool1 = true;
      }
      else if (paramInt == buc.bG)
      {
        a.a(hlg.q, this);
        cbk.e(getContext(), h(), ad);
        bool1 = true;
      }
      else
      {
        if (paramInt == buc.u)
        {
          ad.a(true);
          if (L) {}
          for (paramView = "flag_";; paramView = "star_")
          {
            cer.a(paramView, "cv_message_menu", true);
            bool1 = true;
            break;
          }
        }
        if (paramInt == buc.dQ)
        {
          ad.a(false);
          if (L) {}
          for (paramView = "flag_";; paramView = "star_")
          {
            cer.a(paramView, "cv_message_menu", false);
            bool1 = true;
            break;
          }
        }
        Object localObject1;
        if (paramInt == buc.dz)
        {
          if (c.e != null) {}
          for (bool1 = true;; bool1 = false)
          {
            localObject1 = h();
            paramView = ad.a();
            getContext();
            localObject1 = cjf.a((Account)localObject1, paramView);
            cft.a(getContext(), ad, d, aa, paramView.a((String)localObject1), bool1);
            bool1 = true;
            break;
          }
        }
        Object localObject2;
        Object localObject3;
        String str;
        if (paramInt == buc.dZ)
        {
          paramView = getContext().getString(buj.el);
          localObject1 = getContext();
          localObject2 = h();
          localObject3 = ad;
          str = String.valueOf(a.b(ad));
          cbk.a((Context)localObject1, (Account)localObject2, (Message)localObject3, String.valueOf(paramView).length() + 2 + String.valueOf(str).length() + paramView + "\n\n" + str);
          bool1 = true;
        }
        else if (paramInt == buc.dY)
        {
          paramView = getContext().getString(buj.ek);
          localObject1 = getContext();
          localObject2 = h();
          localObject3 = ad;
          str = String.valueOf(a.b(ad));
          cbk.a((Context)localObject1, (Account)localObject2, (Message)localObject3, String.valueOf(paramView).length() + 2 + String.valueOf(str).length() + paramView + "\n\n" + str);
          bool1 = true;
        }
        else if (paramInt == buc.bk)
        {
          if (ad.u == 5)
          {
            paramView = k;
            c = ad;
            localObject1 = cbk.b(i.getActivity(), k, c);
            i.startActivityForResult((Intent)localObject1, 6);
            bool1 = true;
          }
          else if (ad.u == 6)
          {
            paramView = k;
            c = ad;
            localObject1 = cbk.b(i.getActivity(), k, c);
            i.startActivityForResult((Intent)localObject1, 7);
            bool1 = true;
          }
          else
          {
            cbk.a(getContext(), h(), ad);
            bool1 = true;
          }
        }
        else if (paramInt == buc.df)
        {
          ac.a();
          bool1 = true;
        }
        else
        {
          int i1;
          if ((paramInt == buc.eB) || (paramInt == buc.bP) || (paramInt == buc.aX))
          {
            i1 = k();
            if (x != null)
            {
              bool1 = bool3;
              if (x.getVisibility() != 8) {}
            }
            else
            {
              bool1 = true;
            }
            d(bool1);
            f();
            if (a != null) {
              a.a(c, bool1, i1);
            }
            bool1 = true;
          }
          else
          {
            if (paramInt == buc.fC)
            {
              if (d) {
                if (d()) {
                  break label991;
                }
              }
              label991:
              for (bool1 = true;; bool1 = false)
              {
                b(bool1);
                q.setText(l());
                m();
                n();
                u.setText(T);
                c(false);
                i1 = k();
                c.a(i1);
                if (a != null)
                {
                  a.b(c, i1);
                  if (i()) {
                    a.b(this);
                  }
                }
                bool1 = true;
                break;
              }
            }
            if (paramInt == buc.eN)
            {
              localObject1 = (Integer)paramView.getTag();
              if (localObject1 != null) {
                switch (((Integer)localObject1).intValue())
                {
                }
              }
              for (;;)
              {
                bool1 = true;
                break;
                if (a != null) {
                  a.a(ad);
                }
                if (c != null) {
                  c.i = true;
                }
                if (l)
                {
                  s();
                  bool1 = true;
                  break;
                }
                e(false);
                bool1 = true;
                break;
                localObject1 = ad;
                if (ah == null) {
                  ah = new bzd(this, getContext().getContentResolver());
                }
                localObject2 = ah;
                A = true;
                localObject3 = new ContentValues(1);
                ((ContentValues)localObject3).put("alwaysShowImages", Integer.valueOf(1));
                ((AsyncQueryHandler)localObject2).startUpdate(0, null, f, (ContentValues)localObject3, null, null);
                if (a != null) {
                  a.a(ad.j);
                }
                ab = false;
                paramView.setTag(null);
                paramView.setVisibility(8);
                f();
                Toast.makeText(getContext(), buj.o, 0).show();
              }
            }
            if (paramInt == buc.N)
            {
              ad.b(true);
              bool1 = true;
            }
            else if (paramInt == buc.fv)
            {
              ad.b(false);
              bool1 = true;
            }
            else
            {
              if (paramInt == buc.ab)
              {
                paramView = (MailActivity)getContext();
                ((btr)paramView.getApplication()).a().a(paramView, W.a(), getContext().getString(buj.ad), null);
                if (ad.W == 2) {
                  if (ad.X == null) {
                    paramView = "not_supported_generic";
                  }
                }
                for (;;)
                {
                  buo.a().a("gmail_tls", "message_header_learn_more", paramView, 0L);
                  bool1 = true;
                  break;
                  paramView = "not_supported_specific";
                  continue;
                  paramView = "supported";
                }
              }
              if (paramInt != buc.eO) {
                cvm.c(m, "unrecognized header tap: %d", new Object[] { Integer.valueOf(paramInt) });
              } else {
                bool1 = true;
              }
            }
          }
        }
      }
    }
  }
  
  private final void c(boolean paramBoolean)
  {
    int i4 = 8;
    View localView;
    int i2;
    if (l)
    {
      a(0, paramBoolean);
      a(8, new View[] { H, I, C, D, E, F, J, G, u });
      a(0, new View[] { v, r });
      a(o, 0);
      bxp localbxp = c.e;
      if (localbxp == null) {
        break label786;
      }
      localView = n;
      i1 = c.c - 1;
      i2 = p.size();
      if ((i1 < 0) || (i1 >= i2) || (((bxh)p.get(i1)).a() != 4)) {
        break label776;
      }
      i1 = 1;
      label196:
      if (i1 == 0) {
        break label781;
      }
    }
    label235:
    label398:
    label430:
    label445:
    label494:
    label633:
    label742:
    label776:
    label781:
    for (int i1 = i4;; i1 = 0)
    {
      localView.setVisibility(i1);
      return;
      if (d())
      {
        a(0, paramBoolean);
        if (R)
        {
          i1 = 0;
          i2 = 8;
          if (!R) {
            break label398;
          }
          a(8, new View[] { H, I });
        }
        for (;;)
        {
          a(i2, new View[] { v, C, D });
          a(i1, new View[] { E, F });
          a(0, new View[] { r });
          a(8, new View[] { J, G, u });
          a(o, 0);
          if ((!aj) || (paramBoolean)) {
            break;
          }
          a("message_header_to_field_messages");
          break;
          i1 = 8;
          i2 = 0;
          break label235;
          if (D != null) {
            break label430;
          }
          a(0, new View[] { H, I });
        }
        boolean bool = o();
        if (bool)
        {
          i3 = 8;
          a(i3, new View[] { H });
          if (!bool) {
            break label494;
          }
        }
        for (int i3 = 0;; i3 = 8)
        {
          a(i3, new View[] { I });
          break;
          i3 = 0;
          break label445;
        }
      }
      a(8, paramBoolean);
      a(0, new View[] { u, G });
      a(8, new View[] { F, H, I, C, D, r, s, t });
      if (ad.d())
      {
        a(0, new View[] { J });
        J.setImageResource(bub.U);
        if (!R) {
          break label742;
        }
        a(0, new View[] { E });
        a(8, new View[] { v });
      }
      for (;;)
      {
        a(o, ap);
        break;
        if (ad.w)
        {
          a(0, new View[] { J });
          J.setImageResource(bub.aC);
          break label633;
        }
        a(8, new View[] { J });
        break label633;
        a(8, new View[] { E });
        a(0, new View[] { v });
      }
      i1 = 0;
      break label196;
    }
    label786:
    n.setVisibility(0);
  }
  
  private final void d(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      if (x != null) {
        break label465;
      }
      localObject1 = ag;
      localObject2 = w;
      localObject1 = ((LayoutInflater)localObject1).inflate(bue.s, (ViewGroup)localObject2, false);
      ((View)localObject1).setOnClickListener(this);
      x = ((ViewGroup)localObject1);
    }
    label465:
    for (int i5 = 1;; i5 = 0)
    {
      if (!af)
      {
        localObject1 = getResources();
        localObject2 = c;
        ((bxu)localObject2).g();
        localObject2 = l;
        a(buc.bK, buc.bJ, M);
        a(buc.dX, buc.dW, Q);
        a(buc.fq, buc.fp, N);
        a(buc.U, buc.T, O);
        a(buc.M, buc.L, P);
        TextView localTextView1 = (TextView)x.findViewById(buc.aT);
        localTextView1.setVisibility(0);
        TextView localTextView2 = (TextView)x.findViewById(buc.aS);
        localTextView2.setText((CharSequence)localObject2);
        localTextView2.setContentDescription(((Resources)localObject1).getString(buj.aY, new Object[] { localTextView1.getText(), localObject2 }));
        localTextView2.setVisibility(0);
      }
      int i3;
      int i4;
      int i2;
      int i1;
      switch (ad.E)
      {
      case 1: 
      default: 
        i3 = 0;
        i4 = 0;
        i2 = 0;
        i1 = 8;
        localObject1 = x.findViewById(buc.dC);
        localObject2 = (TextView)x.findViewById(buc.dB);
        ((View)localObject1).setVisibility(i1);
        ((TextView)localObject2).setVisibility(i1);
        if (i1 == 0)
        {
          yq.a.a((TextView)localObject2, i2, 0, 0, 0);
          ((TextView)localObject2).setText(i4);
          ((TextView)localObject2).setTextColor(jr.b(getContext(), i3));
        }
        af = true;
        if (i5 != 0) {
          w.addView(x, 0);
        }
        x.setVisibility(0);
        s.setVisibility(8);
        t.setVisibility(0);
      }
      for (;;)
      {
        if (c != null) {
          c.h = paramBoolean;
        }
        return;
        i2 = bub.az;
        i4 = buj.aI;
        i3 = btz.i;
        i1 = 0;
        break;
        i2 = bub.aH;
        i4 = buj.aH;
        i3 = btz.h;
        i1 = 0;
        break;
        p();
      }
    }
  }
  
  private final void e(boolean paramBoolean)
  {
    if (paramBoolean) {
      t();
    }
    z.setText(buj.n);
    z.setTag(Integer.valueOf(2));
    if (!paramBoolean) {
      f();
    }
  }
  
  private final Account h()
  {
    if (W != null) {
      return W.a();
    }
    return null;
  }
  
  private final boolean i()
  {
    try
    {
      gnu.a(this, new cev(hlg.b, Long.parseLong(ad.e), d()));
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      cvm.e(m, localNumberFormatException, "VisualElement: Couldn't attach MessageVisualElement", new Object[0]);
    }
    return false;
  }
  
  private final mx j()
  {
    bxp localbxp;
    if (aq == null)
    {
      if (c == null) {
        break label38;
      }
      localbxp = c.e;
      if (localbxp != null) {
        break label43;
      }
    }
    label38:
    label43:
    for (aq = mx.a();; aq = v)
    {
      return aq;
      localbxp = null;
      break;
    }
  }
  
  private final int k()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup == null)
    {
      if (!bhk.a()) {
        cvm.e(m, new Error(), "Unable to measure height of detached header", new Object[0]);
      }
      return getHeight();
    }
    V = true;
    int i1 = cxa.a(this, localViewGroup);
    V = false;
    return i1;
  }
  
  private final CharSequence l()
  {
    switch (S)
    {
    case 0: 
    default: 
      if (R)
      {
        Context localContext = getContext();
        return bzt.a(localContext.getResources().getQuantityString(buh.o, 1), new TextAppearanceSpan(localContext, buk.b));
      }
      break;
    case 1: 
      return getResources().getString(buj.de);
    case 2: 
      return getResources().getString(buj.eG);
    case -1: 
      return getResources().getString(buj.dc);
    }
    return a(U);
  }
  
  private final void m()
  {
    if (!ae) {
      if (c.n == null)
      {
        localObject = h();
        if (localObject == null) {
          break label240;
        }
      }
    }
    label240:
    for (Object localObject = c;; localObject = "")
    {
      bxu localbxu = c;
      Context localContext = getContext();
      String str = ak;
      String[] arrayOfString1 = N;
      String[] arrayOfString2 = O;
      String[] arrayOfString3 = P;
      Map localMap = aa;
      mx localmx = j();
      localObject = new bzm(localContext, (String)localObject, str, localContext.getText(buj.bL), localMap, localmx);
      ((bzm)localObject).a(arrayOfString1);
      ((bzm)localObject).a(arrayOfString2);
      if (bzm.a(arrayOfString3, 50 - d))
      {
        if (!e)
        {
          c.append(b);
          e = true;
        }
        c.append(a.getString(buj.L));
      }
      ((bzm)localObject).a(arrayOfString3);
      n = a.getString(buj.fg, new Object[] { c });
      ((TextView)r.findViewById(buc.dM)).setText(c.n);
      int i1 = ad.W;
      ae = true;
      return;
    }
  }
  
  private final void n()
  {
    s.setMovementMethod(LinkMovementMethod.getInstance());
    TextView localTextView = s;
    Resources localResources = getResources();
    int i1 = buj.aR;
    bxu localbxu = c;
    localbxu.g();
    localTextView.setText(Html.fromHtml(localResources.getString(i1, new Object[] { k })));
    cwt.a((Spannable)s.getText(), null);
  }
  
  private final boolean o()
  {
    Account localAccount = h();
    return (localAccount != null) && (z.c == 1);
  }
  
  private final void p()
  {
    if (x != null) {
      x.setVisibility(8);
    }
    s.setVisibility(0);
    t.setVisibility(8);
  }
  
  private final void q()
  {
    if (A != null) {
      A.setVisibility(8);
    }
  }
  
  private final void r()
  {
    if (B != null) {
      B.setVisibility(8);
    }
  }
  
  private final void s()
  {
    if (z != null) {
      z.setVisibility(8);
    }
  }
  
  private final void t()
  {
    if (z == null)
    {
      z = ((TextView)ag.inflate(bue.t, this, false));
      w.addView(z);
      z.setOnClickListener(this);
    }
    z.setVisibility(0);
    z.setText(buj.eP);
    z.setTag(Integer.valueOf(1));
  }
  
  private final void u()
  {
    if (y != null) {
      y.setVisibility(8);
    }
  }
  
  public final void a()
  {
    e();
  }
  
  public final void a(bvz parambvz, Map<String, Address> paramMap)
  {
    W = parambvz;
    aa = paramMap;
    paramMap = v;
    e = parambvz;
    paramMap.setOnClickListener(paramMap);
  }
  
  public final void a(bxu parambxu, boolean paramBoolean)
  {
    if ((c != null) && (c == parambxu)) {}
    do
    {
      return;
      c = parambxu;
      a(paramBoolean);
    } while ((paramBoolean) || (!cxf.a(getContext(), h())) || (!i()));
    a.a(this);
  }
  
  public final void a(boolean paramBoolean)
  {
    boolean bool2 = false;
    if (c == null) {
      return;
    }
    cez.a();
    ae = false;
    af = false;
    ad = c.f;
    Account localAccount = h();
    int i1;
    Object localObject1;
    int i2;
    label111:
    boolean bool1;
    if ((localAccount != null) && (z.q == 0))
    {
      i1 = 1;
      localObject1 = ad;
      if ((A) || ((!s) && ((TextUtils.isEmpty(o)) || (!Message.c.matcher(o).find())))) {
        break label450;
      }
      i2 = 1;
      if ((i2 == 0) || ((!a.c()) && (i1 != 0))) {
        break label455;
      }
      bool1 = true;
      label134:
      ab = bool1;
      b(c.g);
      M = ad.g();
      N = ad.h();
      O = ad.i();
      P = ad.j();
      Q = ad.k();
      if (!ad.p())
      {
        if (ad.N != -1) {
          break label461;
        }
        i1 = 1;
        label229:
        bool1 = bool2;
        if (i1 == 0) {}
      }
      else
      {
        bool1 = true;
      }
      R = bool1;
      S = ad.N;
      Object localObject2 = ad.j;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (localAccount == null) {
          break label466;
        }
        localObject1 = c;
      }
      label290:
      U = cxa.a(aa, (String)localObject1);
      c(paramBoolean);
      if ((!R) && (S == 0)) {
        break label473;
      }
      localObject1 = b(ad.i);
      label334:
      if (localObject1 != null) {
        break label485;
      }
      localObject1 = null;
      label342:
      T = ((String)localObject1);
      q.setText(l());
      m();
      n();
      u.setText(T);
      if (U != null) {
        K.b = U.a;
      }
      if (G != null)
      {
        localObject1 = G;
        localObject2 = c;
        ((bxu)localObject2).g();
        ((TextView)localObject1).setText(j);
      }
      if (!paramBoolean) {
        break label499;
      }
      e();
    }
    for (;;)
    {
      cez.b();
      return;
      i1 = 0;
      break;
      label450:
      i2 = 0;
      break label111;
      label455:
      bool1 = false;
      break label134;
      label461:
      i1 = 0;
      break label229;
      label466:
      localObject1 = "";
      break label290;
      label473:
      localObject1 = ad.i;
      break label334;
      label485:
      localObject1 = j().a((String)localObject1);
      break label342;
      label499:
      g();
      if ((!ai) && (b != null))
      {
        b.a(al);
        ai = true;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem)
  {
    ac.d.f();
    return b(null, paramMenuItem.getItemId());
  }
  
  public final void b()
  {
    boolean bool1 = o();
    adu localadu = ac.b;
    localadu.findItem(buc.dR).setVisible(bool1);
    Object localObject1 = localadu.findItem(buc.dS);
    boolean bool2;
    int i1;
    label114:
    Object localObject2;
    if (!bool1)
    {
      bool1 = true;
      ((MenuItem)localObject1).setVisible(bool1);
      localadu.findItem(buc.dz).setVisible(cxd.c());
      bool2 = ad.D;
      L = false;
      localObject1 = ad.a();
      if (localObject1 == null) {
        break label551;
      }
      if (((Conversation)localObject1).e()) {
        break label466;
      }
      i1 = 1;
      localObject2 = W.a();
      if ((localObject2 == null) || (!((Account)localObject2).a(2147483648L))) {
        break label471;
      }
      bool1 = true;
      label143:
      L = bool1;
    }
    for (;;)
    {
      localObject2 = localadu.findItem(buc.u);
      MenuItem localMenuItem = localadu.findItem(buc.dQ);
      if (L)
      {
        ((MenuItem)localObject2).setTitle(buj.g);
        localMenuItem.setTitle(buj.ec);
        label201:
        if ((i1 == 0) || (bool2)) {
          break label501;
        }
        bool1 = true;
        label211:
        ((MenuItem)localObject2).setVisible(bool1);
        if ((i1 == 0) || (!bool2)) {
          break label506;
        }
      }
      label466:
      label471:
      label501:
      label506:
      for (bool1 = true;; bool1 = false)
      {
        localMenuItem.setVisible(bool1);
        localadu.findItem(buc.dY).setVisible(false);
        localadu.findItem(buc.dZ).setVisible(false);
        localadu.findItem(buc.N).setVisible(false);
        localadu.findItem(buc.fv).setVisible(false);
        if ((h() != null) && (h().a(16777216L)) && (!ad.Q) && (U != null))
        {
          localObject2 = a(U);
          if ((!h().b(U.a)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!((Conversation)localObject1).e()) && ((!q) || (ad.R)))
          {
            localObject1 = getContext();
            if (!ad.R) {
              break label511;
            }
            localadu.findItem(buc.fv).setVisible(true).setTitle(((Context)localObject1).getString(buj.fn, new Object[] { localObject2 }));
          }
        }
        return;
        bool1 = false;
        break;
        i1 = 0;
        break label114;
        bool1 = false;
        break label143;
        ((MenuItem)localObject2).setTitle(buj.i);
        localMenuItem.setTitle(buj.ee);
        break label201;
        bool1 = false;
        break label211;
      }
      label511:
      localadu.findItem(buc.N).setVisible(true).setTitle(((Context)localObject1).getString(buj.N, new Object[] { localObject2 }));
      return;
      label551:
      i1 = 1;
    }
  }
  
  public final void c()
  {
    if (d()) {
      a("message_header_to_field_conversation");
    }
    aj = true;
  }
  
  public final boolean d()
  {
    return (c == null) || (c.g);
  }
  
  public final void e()
  {
    c = null;
    ad = null;
    if (ai)
    {
      b.b(al);
      ai = false;
    }
    Object localObject;
    if (A != null)
    {
      localObject = (RsvpHeaderView)A;
      p = null;
      w = 0L;
      if (t != null) {
        t.u_();
      }
      t = null;
    }
    if (B != null)
    {
      localObject = B;
      if (r != null) {
        s.destroyLoader(r.hashCode());
      }
      n = null;
      if (p != null) {
        p.u_();
      }
      p = null;
      s = null;
      t = null;
      u = null;
      if (v != null) {
        v.b((bzl)localObject);
      }
      v = null;
      r = null;
      k = false;
      q = 0L;
      l = 0L;
      m = 0L;
    }
  }
  
  public final void f()
  {
    if (c == null) {}
    int i1;
    do
    {
      do
      {
        return;
        i1 = k();
      } while (i1 == as);
      as = i1;
      c.a(i1);
    } while (a == null);
    a.a(c, i1);
  }
  
  public final void g()
  {
    Object localObject2 = v;
    int i1;
    if ((b == null) || (U == null))
    {
      localObject1 = getResources().getString(buj.ax);
      ((byz)localObject2).setContentDescription((CharSequence)localObject1);
      i1 = ad.r();
      if (i1 == 0) {
        break label226;
      }
      localObject1 = v;
      d = i1;
      switch (i1)
      {
      }
    }
    Object localObject3;
    for (;;)
    {
      v.a(U, null);
      return;
      localObject3 = getResources();
      i1 = buj.aw;
      if (!TextUtils.isEmpty(U.b)) {}
      for (localObject1 = U.b;; localObject1 = U.a)
      {
        localObject1 = ((Resources)localObject3).getString(i1, new Object[] { localObject1 });
        break;
      }
      if (b == null) {
        b = ((byz)localObject1).getResources().getDrawable(bub.l);
      }
      ((byz)localObject1).setImageDrawable(b);
      continue;
      if (c == null)
      {
        c = new bva(((byz)localObject1).getResources());
        c.e = 2;
      }
      ((byz)localObject1).setImageDrawable(c);
    }
    label226:
    if ((b == null) || (U == null))
    {
      localObject1 = v;
      if (a == null) {
        a = ((byz)localObject1).getResources().getDrawable(bub.u);
      }
      ((byz)localObject1).setImageDrawable(a);
      v.a(U, null);
      return;
    }
    Object localObject1 = U.a;
    localObject2 = b.a((String)localObject1);
    v.a(U, (btn)localObject2);
    if ((localObject2 != null) && (c != null)) {}
    for (localObject1 = c;; localObject1 = am.a((cop)localObject3, (String)localObject2, (String)localObject1))
    {
      v.setImageBitmap(cts.a((Bitmap)localObject1));
      return;
      localObject2 = U.b;
      if (am == null) {
        am = new cff(getContext().getResources());
      }
      localObject3 = new cop(an, ao);
    }
  }
  
  public void onClick(View paramView)
  {
    b(paramView, paramView.getId());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    n = findViewById(buc.cL);
    p = ((ViewGroup)findViewById(buc.fC));
    o = findViewById(buc.fn);
    q = ((TextView)findViewById(buc.eC));
    r = ((LinearLayout)findViewById(buc.dN));
    s = ((TextView)findViewById(buc.eB));
    t = findViewById(buc.bP);
    u = ((TextView)findViewById(buc.bm));
    v = ((byz)findViewById(buc.an));
    H = findViewById(buc.dR);
    I = findViewById(buc.dS);
    C = findViewById(buc.bG);
    D = findViewById(buc.df);
    E = findViewById(buc.bf);
    F = findViewById(buc.bk);
    G = ((TextView)findViewById(buc.fB));
    J = ((ImageView)findViewById(buc.y));
    w = ((ViewGroup)findViewById(buc.bM));
    b(true);
    View localView1 = H;
    Object localObject = I;
    View localView2 = C;
    View localView3 = F;
    View localView4 = D;
    ViewGroup localViewGroup = p;
    TextView localTextView = s;
    View localView5 = t;
    int i1 = 0;
    while (i1 < 8)
    {
      View localView6 = new View[] { localView1, localObject, localView2, localView3, localView4, localViewGroup, localTextView, localView5 }[i1];
      if (localView6 != null) {
        localView6.setOnClickListener(this);
      }
      i1 += 1;
    }
    ac = new bza(getContext(), D);
    new adg(ac.a).inflate(buf.k, ac.b);
    ac.e = this;
    ac.g = this;
    localView1 = D;
    localObject = ac;
    if (f == null) {
      f = new akh((akg)localObject, c);
    }
    localView1.setOnTouchListener(f);
    p.setOnCreateContextMenuListener(K);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    cez.a();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    cez.b();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!V) {
      cez.b();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageHeaderView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */