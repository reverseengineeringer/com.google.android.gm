import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

public final class cdz
  extends cvf
{
  private int b = 0;
  private boolean c = false;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private long i;
  private final Context j;
  private final gir k;
  
  public cdz(Context paramContext)
  {
    j = paramContext;
    k = new gir();
  }
  
  protected final void a(gpa paramgpa)
  {
    int n = 0;
    Object localObject = a;
    int m;
    if (gou.C.equals(localObject))
    {
      m = n;
      if (b > 0)
      {
        b -= 1;
        if (b != 0) {
          break label165;
        }
        Spanned localSpanned = cdv.a(j, d, f, e, null, g);
        localObject = localSpanned;
        if (localSpanned == null) {
          localObject = cdv.a(j, f, null, g, h, i);
        }
        if (localObject != null) {
          a.append((CharSequence)localObject);
        }
        m = 1;
      }
    }
    for (;;)
    {
      if (m == 0) {
        super.a(paramgpa);
      }
      return;
      m = n;
      if (b > 0)
      {
        m = n;
        if (gou.ax.equals(localObject))
        {
          c = false;
          m = 1;
          continue;
          label165:
          m = 1;
        }
      }
    }
  }
  
  public final void a(gpc paramgpc, int paramInt1, int paramInt2)
  {
    if ((c) && ((paramgpc instanceof gpf)))
    {
      f = ((gpf)paramgpc).a();
      return;
    }
    super.a(paramgpc, paramInt1, paramInt2);
  }
  
  protected final void a(gpd paramgpd)
  {
    int n = 1;
    int m = 0;
    Object localObject = a;
    if (gou.C.equals(localObject))
    {
      localObject = paramgpd.a(gou.bk);
      if (localObject != null)
      {
        localObject = ((gpe)localObject).a();
        if (localObject != null)
        {
          localObject = TextUtils.split((String)localObject, " ");
          int i1 = localObject.length;
          m = 0;
          if (m < i1) {
            if ("gmail_drive_chip".equals(localObject[m]))
            {
              m = 1;
              label83:
              if (m == 0) {
                break label153;
              }
              b = 1;
              c = false;
              h = null;
              g = null;
              f = null;
              e = null;
              d = null;
              i = -1L;
              m = n;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (m == 0) {
        super.a(paramgpd);
      }
      return;
      m += 1;
      break;
      m = 0;
      break label83;
      label153:
      if (b > 0)
      {
        b += 1;
        m = n;
      }
      else
      {
        m = 0;
        continue;
        if ((b > 0) && (gou.d.equals(localObject)))
        {
          localObject = paramgpd.a(gou.bJ);
          if (localObject != null)
          {
            e = ((gpe)localObject).a();
            localObject = Uri.parse(e);
            gir localgir = k;
            String str = git.b((Uri)localObject);
            gis localgis;
            Matcher localMatcher;
            if (str != null)
            {
              Iterator localIterator = git.a((Uri)localObject).iterator();
              do
              {
                if (!localIterator.hasNext()) {
                  break;
                }
                localgis = (gis)localIterator.next();
                localMatcher = localgis.a((Uri)localObject, str);
              } while (!localgis.a(localMatcher, (Uri)localObject));
            }
            for (localObject = localgir.a(localgis.b(localMatcher, (Uri)localObject));; localObject = null)
            {
              d = ((String)localObject);
              m = n;
              break;
            }
          }
          localObject = paramgpd.a(gou.cB);
          if (localObject == null) {
            break label486;
          }
          localObject = TextUtils.split(((gpe)localObject).a(), " ");
          h = localObject[0];
          try
          {
            i = Long.parseLong(localObject[1]);
            m = n;
          }
          catch (NumberFormatException localNumberFormatException) {}
        }
      }
    }
    for (;;)
    {
      break;
      gpe localgpe;
      if ((b > 0) && (gou.W.equals(localNumberFormatException)))
      {
        m = n;
        if (g != null) {
          break;
        }
        localgpe = paramgpd.a(gou.cN);
        m = n;
        if (localgpe == null) {
          break;
        }
        g = localgpe.a();
        m = n;
        break;
      }
      if ((b > 0) && (gou.ax.equals(localgpe)))
      {
        c = true;
        m = n;
        break;
      }
      m = 0;
      break;
      label486:
      m = 1;
    }
  }
}

/* Location:
 * Qualified Name:     cdz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */