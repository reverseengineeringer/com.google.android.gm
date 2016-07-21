import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextUtils.StringSplitter;
import android.util.SparseArray;
import com.android.emailcommon.mail.Address;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class dvt
  extends dvr
{
  private static final String c = cvl.a;
  private final int A;
  private final int B;
  private final int C;
  private final int D;
  private final int E;
  private final int F;
  private final int G;
  private final int H;
  private final int I;
  private final int J;
  private final int K;
  private final int L;
  private final int M;
  private final int N;
  private final int O;
  private final int P;
  private final int Q;
  private final int R;
  private final int S;
  private final int T;
  private final int U;
  private final int V;
  private final int W;
  private final int X;
  private final int Y;
  private final int Z;
  private final int aa;
  private final int ab;
  private final int ac;
  private final int ad;
  private final int ae;
  private final int af;
  private final int ag;
  private final int ah;
  private final int ai;
  private final List<GmailAttachment> aj = new ArrayList();
  private long ak;
  private long al;
  private long am;
  private String an;
  private String ao;
  private boolean ap = false;
  private final Bundle aq;
  private String[] ar;
  private final TextUtils.StringSplitter as = dpy.a();
  private final String d;
  private final String e;
  private final cfm f;
  private final Context g;
  private final String h;
  private final int i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  private final int n;
  private final int o;
  private final int p;
  private final int q;
  private final int r;
  private final int s;
  private final int t;
  private final int u;
  private final int v;
  private final int w;
  private final int x;
  private final int y;
  private final int z;
  
  public dvt(Context paramContext, Cursor paramCursor, String paramString1, String paramString2, cfm paramcfm, String paramString3, String[] paramArrayOfString)
  {
    super(paramCursor, paramArrayOfString);
    d = paramString1;
    e = paramString2;
    f = paramcfm;
    g = paramContext;
    h = paramString3;
    i = paramCursor.getColumnIndexOrThrow("_id");
    j = paramCursor.getColumnIndexOrThrow("messageId");
    k = paramCursor.getColumnIndexOrThrow("conversation");
    l = paramCursor.getColumnIndexOrThrow("subject");
    m = paramCursor.getColumnIndexOrThrow("snippet");
    n = paramCursor.getColumnIndexOrThrow("fromAddress");
    o = paramCursor.getColumnIndexOrThrow("customFromAddress");
    p = paramCursor.getColumnIndexOrThrow("toAddresses");
    q = paramCursor.getColumnIndexOrThrow("ccAddresses");
    r = paramCursor.getColumnIndexOrThrow("bccAddresses");
    s = paramCursor.getColumnIndexOrThrow("replyToAddresses");
    t = paramCursor.getColumnIndexOrThrow("dateReceivedMs");
    u = paramCursor.getColumnIndexOrThrow("body");
    v = paramCursor.getColumnIndexOrThrow("stylesheet");
    w = paramCursor.getColumnIndexOrThrow("stylesheetRestrictor");
    x = paramCursor.getColumnIndexOrThrow("bodyEmbedsExternalResources");
    y = paramCursor.getColumnIndexOrThrow("labelIds");
    z = paramCursor.getColumnIndexOrThrow("refMessageId");
    A = paramCursor.getColumnIndexOrThrow("isDraft");
    B = paramCursor.getColumnIndexOrThrow("forward");
    C = paramCursor.getColumnIndexOrThrow("joinedAttachmentInfos");
    D = paramCursor.getColumnIndexOrThrow("isUnread");
    E = paramCursor.getColumnIndexOrThrow("isStarred");
    F = paramCursor.getColumnIndexOrThrow("isInOutbox");
    G = paramCursor.getColumnIndexOrThrow("isInSending");
    H = paramCursor.getColumnIndexOrThrow("isInFailed");
    I = paramCursor.getColumnIndexOrThrow("quoteStartPos");
    J = paramCursor.getColumnIndexOrThrow("spamDisplayedReasonType");
    K = paramCursor.getColumnIndexOrThrow("clipped");
    L = paramCursor.getColumnIndexOrThrow("permalink");
    N = paramCursor.getColumnIndexOrThrow("unsubscribeSenderIdentifier");
    M = paramCursor.getColumnIndexOrThrow("isSenderUnsubscribed");
    O = 0;
    P = 0;
    Q = 0;
    T = 0;
    R = 0;
    S = 0;
    U = 0;
    V = paramCursor.getColumnIndexOrThrow("hasEvent");
    W = paramCursor.getColumnIndexOrThrow("eventTitle");
    X = paramCursor.getColumnIndexOrThrow("startTime");
    Y = paramCursor.getColumnIndexOrThrow("endTime");
    Z = paramCursor.getColumnIndexOrThrow("allDay");
    aa = paramCursor.getColumnIndexOrThrow("location");
    ab = paramCursor.getColumnIndexOrThrow("organizer");
    ac = paramCursor.getColumnIndexOrThrow("attendees");
    ad = paramCursor.getColumnIndexOrThrow("icalMethod");
    ae = paramCursor.getColumnIndexOrThrow("responder");
    af = paramCursor.getColumnIndexOrThrow("responseStatus");
    ag = paramCursor.getColumnIndexOrThrow("eventId");
    ah = paramCursor.getColumnIndexOrThrow("showUnauthWarning");
    ai = paramCursor.getColumnIndexOrThrow("isLateReclassified");
    paramContext = super.getExtras();
    paramCursor = new Bundle();
    int i1 = i2;
    if (paramContext.containsKey("status"))
    {
      int i3 = paramContext.getInt("status");
      i1 = i2;
      if (a.get(i3) != null) {
        i1 = ((Integer)a.get(i3)).intValue();
      }
    }
    paramCursor.putInt("cursor_status", i1);
    aq = paramCursor;
    ar = TextUtils.split(ghz.a(g.getContentResolver(), "gmail_senders_excluded_from_block_option", "no-reply@accounts.google.com"), ",");
  }
  
  private final int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = super.getInt(J);
    if (dus.c.contains(Integer.valueOf(i2)))
    {
      if (paramBoolean1) {
        return 114;
      }
      if (paramBoolean2) {
        return 115;
      }
      if (super.getLong(ai) != 0L) {}
      for (int i1 = 1; i1 != 0; i1 = 0) {
        return 104;
      }
    }
    if (!paramBoolean1)
    {
      if (i2 == 26) {
        return 116;
      }
      if (i2 == 114) {
        return -1;
      }
    }
    return i2;
  }
  
  private final void b()
  {
    Object localObject;
    if (!ap)
    {
      localObject = super.getString(C);
      aj.addAll(GmailAttachment.a((String)localObject, g.getContentResolver()));
      ak = super.getLong(j);
      am = super.getLong(i);
      al = super.getLong(k);
      localObject = super.getString(n);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label100;
      }
    }
    for (;;)
    {
      an = ((String)localObject);
      ap = true;
      return;
      label100:
      String str = super.getString(o);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "";
      }
    }
  }
  
  private final String[] b(int paramInt)
  {
    return TextUtils.split(a(paramInt), dpy.b);
  }
  
  private final String c()
  {
    if (ao == null) {
      ao = super.getString(u);
    }
    return ao;
  }
  
  private final boolean d()
  {
    if (e == null) {
      return true;
    }
    Object localObject1 = dpy.k(e);
    Object localObject2 = l();
    if (localObject2 == null)
    {
      dri.f(c, "UIMessageCursor#getIsSeen(), MailEngine did not exist", new Object[0]);
      return true;
    }
    try
    {
      long l1 = X.a((String)localObject1);
      localObject2 = super.getString(y);
      TextUtils.StringSplitter localStringSplitter = as;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localStringSplitter.setString((String)localObject1);
      if (!dpy.a(as).contains(Long.valueOf(l1))) {
        return true;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      return true;
    }
    return false;
  }
  
  private final boolean e()
  {
    if (TextUtils.isEmpty(an)) {
      return false;
    }
    drp localdrp = l();
    if (localdrp != null) {
      return localdrp.d(can).a);
    }
    dri.f(c, "UIMessageCursor#isSenderBlocked(), MailEngine did not exist", new Object[0]);
    return false;
  }
  
  private final boolean f()
  {
    return super.getLong(M) != 0L;
  }
  
  private final long g()
  {
    return super.getLong(z);
  }
  
  private final String[] h()
  {
    return b(p);
  }
  
  private final String[] i()
  {
    return b(q);
  }
  
  private final String[] j()
  {
    return b(r);
  }
  
  private final int k()
  {
    int i2 = super.getInt(I);
    int i1 = i2;
    String str;
    if (i2 <= 0)
    {
      str = c();
      if (TextUtils.isEmpty(str)) {
        i1 = -1;
      }
    }
    else
    {
      return i1;
    }
    return str.indexOf(h);
  }
  
  private final drp l()
  {
    if ((Looper.getMainLooper() == Looper.myLooper()) && (!bhk.b())) {
      return drp.a(d);
    }
    return drp.b(g, d);
  }
  
  protected final void a()
  {
    super.a();
    aj.clear();
    ao = null;
    ap = false;
  }
  
  public final Bundle getExtras()
  {
    return aq;
  }
  
  public final int getInt(int paramInt)
  {
    int i5 = 3;
    int i6 = 0;
    int i4 = 0;
    int i3 = 0;
    b();
    if (aj.size() > 0) {}
    int i1;
    for (int i2 = 1;; i2 = 0)
    {
      i1 = i3;
      switch (paramInt)
      {
      case 17: 
      case 21: 
      case 22: 
      case 23: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 38: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
      case 51: 
      case 53: 
      case 59: 
      case 60: 
      case 61: 
      case 62: 
      case 66: 
      case 67: 
      case 68: 
      default: 
        dri.e("Gmail", "UIMessageCursor.getInt(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
        i1 = super.getInt(paramInt);
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 63: 
      case 65: 
      case 69: 
        return i1;
      }
    }
    return super.getInt(x);
    if (super.getLong(A) != 0L)
    {
      paramInt = 1;
      label322:
      if (paramInt == 0) {
        break label939;
      }
      paramInt = i6;
      if (super.getLong(B) != 0L) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        break label357;
      }
      paramInt = 4;
    }
    for (;;)
    {
      return paramInt;
      paramInt = 0;
      break label322;
      label357:
      if (g() != 0L)
      {
        paramInt = i5;
        if (h().length + i().length + j().length <= 1) {
          paramInt = 2;
        }
      }
      else
      {
        paramInt = 1;
        continue;
        i1 = i3;
        if (i2 == 0) {
          break;
        }
        return 1;
        if (super.getLong(D) != 0L) {}
        for (paramInt = 1;; paramInt = 0)
        {
          i1 = i3;
          if (paramInt != 0) {
            break;
          }
          return 1;
        }
        i1 = i3;
        if (!d()) {
          break;
        }
        return 1;
        if (super.getLong(E) != 0L) {}
        for (paramInt = 1;; paramInt = 0)
        {
          i1 = i3;
          if (paramInt == 0) {
            break;
          }
          return 1;
        }
        if (super.getLong(F) != 0L)
        {
          paramInt = 1;
          i1 = i3;
          if (paramInt == 0) {
            break;
          }
          if (super.getLong(H) == 0L) {
            break label527;
          }
        }
        label527:
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label532;
          }
          return -1;
          paramInt = 0;
          break;
        }
        label532:
        paramInt = i4;
        if (super.getLong(G) != 0L) {
          paramInt = 1;
        }
        if (paramInt != 0) {
          return 2;
        }
        return 1;
        if (TextUtils.isEmpty(an))
        {
          dri.b(c, "UIMessageCursor.getInt(%d) on null mFromAddress", new Object[] { Integer.valueOf(paramInt) });
          return 0;
        }
        Object localObject = can).a;
        if (!f.c((String)localObject))
        {
          i1 = i3;
          if (!"mail-noreply@google.com".equals(localObject)) {
            break;
          }
        }
        return 1;
        i1 = i3;
        if (k() < 0) {
          break;
        }
        return 1;
        return k();
        paramInt = a(e(), f());
        if (dus.b.contains(Integer.valueOf(paramInt))) {
          return 2;
        }
        i1 = i3;
        switch (paramInt)
        {
        case -1: 
        default: 
          return 1;
        case 114: 
          return 3;
        case 115: 
          return 4;
        }
        return 5;
        localObject = (Integer)dus.d.get(Integer.valueOf(a(e(), f())));
        i1 = i3;
        if (localObject == null) {
          break;
        }
        return ((Integer)localObject).intValue();
        return super.getInt(K);
        if (TextUtils.isEmpty(an))
        {
          dri.b(c, "UIMessageCursor.getInt(%d) on null mFromAddress", new Object[] { Integer.valueOf(paramInt) });
          return 0;
        }
        localObject = can).a;
        String[] arrayOfString = ar;
        i2 = arrayOfString.length;
        paramInt = 0;
        for (;;)
        {
          i1 = i3;
          if (paramInt >= i2) {
            break;
          }
          if (TextUtils.equals((CharSequence)localObject, arrayOfString[paramInt])) {
            return 1;
          }
          paramInt += 1;
        }
        i1 = i3;
        if (!e()) {
          break;
        }
        return 1;
        return super.getInt(Z);
        return super.getInt(ad);
        return super.getInt(af);
        return 1;
        if (super.getLong(ah) != 0L) {}
        for (paramInt = 1;; paramInt = 0)
        {
          i1 = i3;
          if (paramInt == 0) {
            break;
          }
          return 1;
        }
        label939:
        paramInt = 0;
      }
    }
  }
  
  public final long getLong(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    switch (paramInt)
    {
    default: 
      dri.e("Gmail", "UIMessageCursor.getLong(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      l1 = super.getLong(paramInt);
    case 61: 
    case 62: 
    case 70: 
    case 71: 
    case 0: 
    case 11: 
    case 23: 
      do
      {
        return l1;
        return super.getLong(i);
        return super.getLong(t);
        l1 = l2;
      } while (super.getInt(V) == 0);
      return 16L;
    case 43: 
      return super.getLong(X);
    }
    return super.getLong(Y);
  }
  
  public final String getString(int paramInt)
  {
    int i1 = 1;
    b();
    Object localObject;
    switch (paramInt)
    {
    case 11: 
    case 16: 
    case 18: 
    case 19: 
    case 20: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 39: 
    case 40: 
    case 43: 
    case 44: 
    case 45: 
    case 50: 
    case 52: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 69: 
    case 70: 
    case 71: 
    default: 
      dri.e("Gmail", "UIMessageCursor.getString(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      localObject = super.getString(paramInt);
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 30: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 17: 
    case 21: 
    case 22: 
    case 29: 
    case 31: 
    case 32: 
    case 33: 
    case 38: 
    case 42: 
    case 46: 
      String str;
      do
      {
        do
        {
          return (String)localObject;
          return Long.toString(ak);
          return GmailProvider.d(d, am).toString();
          return GmailProvider.b(d, al);
          return super.getString(l);
          return super.getString(m);
          return an;
          return super.getString(o);
          return TextUtils.join(", ", h());
          return TextUtils.join(", ", i());
          return TextUtils.join(", ", j());
          return TextUtils.join(", ", b(s));
          return c();
          return null;
          return super.getString(v);
          return super.getString(w);
          return GmailProvider.e(d, g());
          if (aj.size() > 0) {}
          for (paramInt = i1; paramInt != 0; paramInt = 0) {
            return GmailProvider.a(d, al, ak, am).toString();
          }
          return null;
          return null;
          localObject = aj;
          str = d;
          long l1 = al;
          long l2 = ak;
          long l3 = am;
          if (localObject == null) {
            return null;
          }
          Iterator localIterator = ((Collection)localObject).iterator();
          while (localIterator.hasNext())
          {
            GmailAttachment localGmailAttachment = (GmailAttachment)localIterator.next();
            e = GmailProvider.a(str, l1, l2, l3, b, localGmailAttachment.l());
          }
          return GmailAttachment.a((Collection)localObject);
          return GmailProvider.b(d).toString();
          return null;
          localObject = (Integer)dus.a.get(Integer.valueOf(a(e(), f())));
          if ((localObject == null) || (((Integer)localObject).intValue() == 0)) {
            return null;
          }
          return g.getResources().getString(((Integer)localObject).intValue());
          return super.getString(L);
          str = super.getString(W);
          localObject = str;
        } while (TextUtils.isEmpty(str));
        return Html.fromHtml(str).toString();
        str = super.getString(aa);
        localObject = str;
      } while (TextUtils.isEmpty(str));
      return Html.fromHtml(str).toString();
    case 47: 
      return super.getString(ab);
    case 48: 
      return TextUtils.join(", ", b(ac));
    case 51: 
      return super.getString(ae);
    case 53: 
      return super.getString(ag);
    case 59: 
      return null;
    case 49: 
      return null;
    case 60: 
      return null;
    case 41: 
      return super.getString(N);
    case 66: 
      return null;
    case 67: 
      localObject = (Integer)dus.e.get(Integer.valueOf(a(e(), f())));
      if ((localObject == null) || (((Integer)localObject).intValue() == 0)) {
        return null;
      }
      return g.getResources().getString(((Integer)localObject).intValue());
    case 68: 
      return null;
    case 72: 
      return null;
    case 73: 
      if (R < 0) {
        return null;
      }
      return super.getString(R);
    }
    if (P < 0) {
      return null;
    }
    return super.getString(S);
  }
}

/* Location:
 * Qualified Name:     dvt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */