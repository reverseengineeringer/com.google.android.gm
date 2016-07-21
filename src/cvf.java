import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.QuoteSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cvf
  implements gpr<Spanned>
{
  private static Pattern e;
  private static Pattern f;
  public final SpannableStringBuilder a = new SpannableStringBuilder();
  private final LinkedList<cvg> b = new LinkedList();
  private final gpt c = new gpt();
  private int d = 0;
  
  private static int a(String paramString)
  {
    if (paramString.startsWith("rgb("))
    {
      if (f == null) {
        f = Pattern.compile("\\(\\s*(\\d{1,3})\\s*,\\s*(\\d{1,3})\\s*,\\s*(\\d{1,3})\\s*\\)");
      }
      paramString = f.matcher(paramString);
      if (paramString.find())
      {
        if (paramString.groupCount() != 3) {
          throw new IllegalArgumentException("Invalid rgb() format. rgb() requires exactly three values");
        }
        int i = Integer.valueOf(paramString.group(1)).intValue();
        int j = Integer.valueOf(paramString.group(2)).intValue();
        int k = Integer.valueOf(paramString.group(3)).intValue();
        if ((i < 0) || (i > 255) || (j < 0) || (j > 255) || (k < 0) || (j > 255)) {
          throw new IllegalArgumentException("Invalid rgb() format. rgb() values need to be within 0 - 255");
        }
        return k | i << 16 | j << 8;
      }
      throw new IllegalArgumentException("Invalid rgb() format. Could not parse rgb() values");
    }
    Integer localInteger = (Integer)cvb.b.get(paramString.toLowerCase(Locale.US));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return Color.parseColor(paramString);
  }
  
  private final void a(cvg paramcvg)
  {
    int i = 0;
    int j = b;
    int k = a.length();
    Object localObject1 = a.a(gou.bq);
    if (localObject1 != null) {}
    try
    {
      int m = a(((gpe)localObject1).a());
      a.setSpan(new ForegroundColorSpan(m | 0xFF000000), j, k, 33);
      localObject1 = a.a(gou.cL);
      if (localObject1 != null)
      {
        m = Integer.parseInt(((gpe)localObject1).a());
        if (m != -1) {
          a.setSpan(new AbsoluteSizeSpan(m * 6, true), j, k, 33);
        }
      }
      localObject1 = a.a(gou.bD);
      if (localObject1 != null)
      {
        localObject1 = ((gpe)localObject1).a().split(",");
        m = localObject1.length;
        while (i < m)
        {
          Object localObject2 = localObject1[i];
          a.setSpan(new TypefaceSpan(((String)localObject2).trim()), j, k, 33);
          i += 1;
        }
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        cvm.d(cvb.a, "Unknown color: %s", new Object[] { ((gpe)localObject1).a() });
      }
      a(paramcvg, j, k);
    }
  }
  
  private final void a(cvg paramcvg, int paramInt1, int paramInt2)
  {
    paramcvg = a.a(gou.cQ);
    if (paramcvg != null)
    {
      if (e == null) {
        e = Pattern.compile("\\bbackground(?:-color)?\\s*:\\s*(#[0-9A-Fa-f]{6}\\b|rgb\\(\\s*\\d{1,3}\\s*,\\s*\\d{1,3}\\s*,\\s*\\d{1,3}\\s*\\)|(\\w+))");
      }
      paramcvg = e.matcher(paramcvg.a());
      if (paramcvg.find())
      {
        paramcvg = paramcvg.group(1);
        if (paramcvg == null) {}
      }
    }
    try
    {
      int i = a(paramcvg);
      a.setSpan(new BackgroundColorSpan(i | 0xFF000000), paramInt1, paramInt2, 33);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      cvm.d(cvb.a, "Unknown color while setting background: %s", new Object[] { paramcvg });
    }
  }
  
  public final int a()
  {
    return a.length();
  }
  
  public void a(gpa paramgpa)
  {
    gos localgos = a;
    cvg localcvg;
    do
    {
      localcvg = (cvg)b.poll();
    } while ((localcvg != null) && (a.a != null) && (!a.a.equals(localgos)));
    if (localcvg == null) {
      return;
    }
    Object localObject = null;
    if (gou.j.equals(localgos)) {
      paramgpa = new StyleSpan(1);
    }
    for (;;)
    {
      int i = b;
      int j = a.length();
      if ((paramgpa == null) || (i == j)) {
        break;
      }
      a.setSpan(paramgpa, i, j, 33);
      return;
      if (gou.U.equals(localgos))
      {
        paramgpa = new StyleSpan(2);
      }
      else if (gou.aN.equals(localgos))
      {
        paramgpa = new UnderlineSpan();
      }
      else
      {
        if (gou.d.equals(localgos))
        {
          paramgpa = a.a(gou.bJ);
          if (paramgpa == null) {
            break;
          }
          paramgpa = new URLSpan(paramgpa.a());
          continue;
        }
        if (gou.o.equals(localgos))
        {
          paramgpa = new QuoteSpan();
        }
        else if (gou.H.equals(localgos))
        {
          a(localcvg);
          paramgpa = (gpa)localObject;
        }
        else
        {
          paramgpa = (gpa)localObject;
          if (gou.ax.equals(localgos))
          {
            a(localcvg, b, a.length());
            paramgpa = (gpa)localObject;
          }
        }
      }
    }
  }
  
  public void a(gpc paramgpc, int paramInt1, int paramInt2)
  {
    c.a(paramgpc, paramInt1, paramInt2);
    if ((paramgpc instanceof gpd)) {
      a((gpd)paramgpc);
    }
    for (;;)
    {
      paramgpc = c.a.a.toString();
      if (paramgpc.length() > d)
      {
        a.append(paramgpc.substring(d));
        d = paramgpc.length();
      }
      return;
      if ((paramgpc instanceof gpa)) {
        a((gpa)paramgpc);
      }
    }
  }
  
  public void a(gpd paramgpd)
  {
    if (!c) {
      b.push(new cvg(paramgpd, a.length()));
    }
  }
}

/* Location:
 * Qualified Name:     cvf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */