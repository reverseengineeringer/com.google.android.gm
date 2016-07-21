import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.LruCache;
import android.util.Pair;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.Folder;
import com.android.mail.providers.ParticipantInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class bxd
{
  public static LruCache<Pair<String, Long>, bxd> a = new LruCache(100);
  public static Folder b;
  public final bxe A = new bxe();
  public final ArrayList<String> B = new ArrayList();
  public final ArrayList<SpannableString> C = new ArrayList();
  public int c;
  public int d;
  public boolean e;
  public CharSequence f;
  public boolean g = true;
  public Bitmap h;
  public String i;
  public int j = 0;
  public boolean k = false;
  public String l;
  public SpannableStringBuilder m;
  public StaticLayout n;
  public boolean o;
  public int p;
  @Deprecated
  public int q;
  public int r;
  public Conversation s;
  public bwy t;
  public boolean u;
  public boolean v;
  public boolean w;
  public SpannableStringBuilder x;
  public int y;
  public String z;
  
  public static int a(CharSequence paramCharSequence, Object paramObject, List<Folder> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null) {
      return -1;
    }
    return Arrays.hashCode(new Object[] { paramObject, paramCharSequence, paramList, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private static bxd a(String arg0, long paramLong)
  {
    Object localObject1 = new Pair(???, Long.valueOf(paramLong));
    synchronized (a)
    {
      localObject1 = (bxd)a.get(localObject1);
      return (bxd)localObject1;
    }
  }
  
  public static bxd a(String paramString, Conversation paramConversation)
  {
    boolean bool2 = true;
    paramString = b(paramString, b);
    s = paramConversation;
    if (!j)
    {
      bool1 = true;
      e = bool1;
      if ((o & 0x8) != 8) {
        break label81;
      }
      bool1 = true;
      label44:
      u = bool1;
      if ((o & 0x4) != 4) {
        break label86;
      }
    }
    label81:
    label86:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      v = bool1;
      w = paramConversation.c();
      return paramString;
      bool1 = false;
      break;
      bool1 = false;
      break label44;
    }
  }
  
  private static bxd b(String paramString, long paramLong)
  {
    synchronized (a)
    {
      bxd localbxd2 = a(paramString, paramLong);
      bxd localbxd1 = localbxd2;
      if (localbxd2 == null)
      {
        paramString = new Pair(paramString, Long.valueOf(paramLong));
        localbxd1 = new bxd();
        a.put(paramString, localbxd1);
      }
      return localbxd1;
    }
  }
  
  public final int a()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(c), Integer.valueOf(p), Integer.valueOf(q), Integer.valueOf(r) });
  }
  
  public final CharSequence a(Context paramContext, bzn parambzn, boolean paramBoolean, String paramString)
  {
    int i1;
    if (z == null)
    {
      if (s.t.a == null) {
        break label360;
      }
      i1 = s.t.a.size() - 1;
      label37:
      if (i1 == -1) {
        break label546;
      }
    }
    label99:
    label189:
    label198:
    label287:
    label360:
    label454:
    label502:
    label526:
    label546:
    for (Object localObject2 = s.t.a.get(i1)).a;; localObject2 = "")
    {
      Object localObject1;
      if (s.j)
      {
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (localObject1 = bzt.a(parambzn, paramBoolean);; localObject1 = localObject2)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label526;
          }
          localObject3 = "";
          localObject1 = localObject3;
          if (paramBoolean)
          {
            localObject1 = localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = bzt.a(parambzn).toString();
            }
          }
          paramBoolean = DateUtils.isToday(s.e);
          localObject3 = DateUtils.getRelativeTimeSpanString(paramContext, s.e).toString();
          if ((s.j) || (!s.l)) {
            break label454;
          }
          parambzn = paramContext.getString(buj.fp);
          if (!paramBoolean) {
            break label502;
          }
          i1 = buj.aB;
          z = paramContext.getString(i1, new Object[] { parambzn, localObject1, localObject2, s.d, s.d(), localObject3 });
          switch (s.m)
          {
          case 1: 
          default: 
            i1 = 0;
            if (i1 != 0) {
              z = paramContext.getString(buj.aD, new Object[] { z, paramContext.getString(i1) });
            }
            if (paramString != null) {
              z = paramContext.getString(buj.aC, new Object[] { z, paramString });
            }
            return z;
            i1 = -1;
            break label37;
          }
        }
      }
      Object localObject3 = s.t.a.iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (ParticipantInfo)((Iterator)localObject3).next();
      } while (d);
      for (;;)
      {
        if (localObject1 != null)
        {
          if (TextUtils.isEmpty(a))
          {
            localObject1 = bzt.a(parambzn, paramBoolean);
            break;
          }
          localObject1 = a;
          break;
          if (!s.j)
          {
            parambzn = paramContext.getString(buj.fq);
            break label189;
          }
          if (s.l)
          {
            parambzn = paramContext.getString(buj.eW);
            break label189;
          }
          parambzn = "";
          break label189;
          i1 = buj.aA;
          break label198;
          i1 = buj.cU;
          break label287;
          i1 = buj.cm;
          break label287;
          localObject2 = localObject1;
          break label99;
        }
        localObject1 = "";
        break;
        localObject1 = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     bxd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */