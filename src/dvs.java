import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gm.provider.GmailProvider;
import java.util.Set;

public final class dvs
  extends dvr
{
  private static final Set<String> c = new hfe().c("^i").c("^iim").b(dpy.a).a();
  private static final Set<String> d = hfd.a("^k", "^r");
  private static final Set<String> e = new hfe().c("^i").c("^iim").b(dpy.a).a();
  private static final Set<String> f = hfd.a("^k", "^b", "^^out", "^r", "^all");
  private static final Set<String> g = new hfe().c("^i").c("^iim").b(dpy.a).a();
  private static final Set<String> h;
  private static final Set<String> i;
  private static final Set<String> j = hfd.a("^s", "^k");
  private final String k;
  private final drp l;
  private final Set<String> m;
  private final int n;
  private final int o;
  private final int p;
  private final int q;
  private final int r;
  private final int s;
  private final int t;
  private final int u;
  private long v;
  private String w;
  private Uri x;
  private String y;
  private final String z;
  
  static
  {
    hfd localhfd = hfd.b("^s");
    h = localhfd;
    i = localhfd;
  }
  
  public dvs(Cursor paramCursor, drp paramdrp, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    super(paramCursor, paramArrayOfString);
    k = paramString1;
    l = paramdrp;
    if (l != null) {}
    for (paramdrp = hfd.a(l.K());; paramdrp = null)
    {
      m = paramdrp;
      z = paramString2;
      n = paramCursor.getColumnIndex("_id");
      o = paramCursor.getColumnIndex("name");
      p = paramCursor.getColumnIndex("canonicalName");
      q = paramCursor.getColumnIndex("numConversations");
      r = paramCursor.getColumnIndex("numUnreadConversations");
      s = paramCursor.getColumnIndex("numUnseenConversations");
      t = paramCursor.getColumnIndex("color");
      u = paramCursor.getColumnIndex("lastMessageTimestamp");
      return;
    }
  }
  
  private final void b()
  {
    if (w == null)
    {
      w = super.getString(p);
      v = super.getLong(n);
      if (v == -1L) {
        break label70;
      }
    }
    label70:
    for (x = GmailProvider.a(k, v);; x = GmailProvider.b(k, w))
    {
      y = super.getString(t);
      return;
    }
  }
  
  protected final void a()
  {
    super.a();
    w = null;
  }
  
  public final int getInt(int paramInt)
  {
    int i3 = 0;
    int i4 = 0;
    int i2 = 0;
    b();
    int i1 = i2;
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 3: 
    case 7: 
    case 8: 
    case 12: 
    default: 
      dri.e("Gmail", new Error(), "UILabelCursor.getInt(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      i1 = super.getInt(paramInt);
    case 4: 
      return i1;
    case 0: 
      return w.hashCode();
    case 9: 
      return super.getInt(s);
    case 10: 
      return super.getInt(r);
    case 11: 
      return super.getInt(q);
    case 5: 
      if (!c.contains(w)) {
        break;
      }
    }
    for (i1 = 2;; i1 = 0)
    {
      paramInt = i1;
      if (!f.contains(w)) {
        paramInt = i1 | 0x40;
      }
      i1 = paramInt;
      if (!d.contains(w)) {
        i1 = paramInt | 0x4;
      }
      paramInt = i1;
      if (!h.contains(w)) {
        paramInt = i1 | 0x8;
      }
      i1 = paramInt;
      if (i.contains(w)) {
        i1 = paramInt | 0x10;
      }
      paramInt = i1;
      if (e.contains(w)) {
        paramInt = i1 | 0x20;
      }
      i1 = paramInt;
      if (j.contains(w)) {
        i1 = paramInt | 0x20000;
      }
      i2 = i1;
      if (g.contains(w)) {
        i2 = i1 | 0x40000;
      }
      paramInt = i2;
      if (dpy.j(w)) {
        paramInt = i2 | 0x1;
      }
      String str = w;
      if ((!dpy.k.contains(str)) && (!dpy.i(str)))
      {
        i2 = i3;
        if (!str.startsWith("^sq_ig_i_")) {}
      }
      else
      {
        i2 = 1;
      }
      i1 = paramInt;
      if (i2 != 0) {
        i1 = paramInt | 0x400;
      }
      if (!"^io_im".equals(w))
      {
        paramInt = i1;
        if (!"^iim".equals(w)) {}
      }
      else
      {
        paramInt = i1 | 0x80;
      }
      i1 = paramInt;
      if (!dpy.a.contains(w)) {
        i1 = paramInt | 0x800;
      }
      paramInt = i1;
      if ("^all".equals(w)) {
        paramInt = i1 | 0x1000;
      }
      i1 = paramInt;
      if (dpy.i(w)) {
        i1 = paramInt | 0x4000;
      }
      paramInt = i1;
      if (dpy.g(w))
      {
        paramInt = i1;
        if (!"^sq_ig_i_personal".equals(w)) {
          paramInt = i1 | 0x8000;
        }
      }
      return paramInt;
      if ((m != null) && (m.contains(w))) {}
      for (paramInt = 1;; paramInt = 0)
      {
        i1 = i2;
        if (paramInt == 0) {
          break;
        }
        return 1;
      }
      i1 = i2;
      if (l == null) {
        break;
      }
      i1 = i4;
      if (l.y()) {
        i1 = 4;
      }
      paramInt = i1;
      if (l.z()) {
        paramInt = i1 | 0x2;
      }
      i1 = paramInt;
      if (!l.A()) {
        break;
      }
      return paramInt | 0x1;
      i1 = i2;
      if (l == null) {
        break;
      }
      return l.B();
      return GmailProvider.i(w);
      return dqz.a(w);
    }
  }
  
  public final long getLong(int paramInt)
  {
    b();
    switch (paramInt)
    {
    default: 
      dri.e("Gmail", new Error(), "UILabelCursor.getLong(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      return super.getLong(paramInt);
    case 0: 
      return w.hashCode();
    }
    return super.getLong(u);
  }
  
  public final String getString(int paramInt)
  {
    Object localObject2 = null;
    b();
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 11: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 22: 
    default: 
      dri.e("Gmail", new Error(), "UILabelCursor.getString(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      localObject1 = super.getString(paramInt);
    }
    do
    {
      return (String)localObject1;
      return w;
      localObject1 = GmailProvider.a(k, w);
      if (z != null) {
        return ((Uri)localObject1).buildUpon().appendQueryParameter("defaultParent", z).build().toString();
      }
      return ((Uri)localObject1).toString();
      return super.getString(o);
      return x.toString();
      return GmailProvider.a(k, v, w, null);
      paramInt = dqz.a(k, w, y);
      return 11 + paramInt;
      paramInt = dqz.b(k, w, y);
      return 11 + paramInt;
      localObject1 = localObject2;
    } while (z == null);
    return z;
  }
}

/* Location:
 * Qualified Name:     dvs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */