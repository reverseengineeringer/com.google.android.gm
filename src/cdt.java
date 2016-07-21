import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ReplacementSpan;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class cdt
  extends ReplacementSpan
{
  private static final Map<String, Integer> b = new hen().b("application/pdf", Integer.valueOf(bub.B)).b("text/plain", Integer.valueOf(bub.F)).b("application/vnd.google-apps.document", Integer.valueOf(bub.z)).b("application/vnd.google-apps.spreadsheet", Integer.valueOf(bub.E)).b("application/vnd.google-apps.presentation", Integer.valueOf(bub.D)).b("application/vnd.openxmlformats-officedocument.wordprocessingml.document", Integer.valueOf(bub.I)).b("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", Integer.valueOf(bub.J)).b("application/vnd.openxmlformats-officedocument.presentationml.presentation", Integer.valueOf(bub.C)).b("application/msword", Integer.valueOf(bub.I)).b("application/vnd.ms-excel", Integer.valueOf(bub.J)).b("application/vnd.ms-powerpoint", Integer.valueOf(bub.C)).b();
  public final cdy a;
  private final TextPaint c = new TextPaint();
  private final Rect d = new Rect();
  private final Paint.FontMetricsInt e = new Paint.FontMetricsInt();
  private final int f;
  private final int g;
  private final int h;
  private final float i;
  private final int j;
  private final int k;
  private final int l;
  private CharSequence m;
  private int n;
  private final Drawable o;
  private final int p;
  private final Context q;
  private boolean r;
  
  private cdt(Context paramContext, cdy paramcdy)
  {
    Resources localResources = paramContext.getResources();
    a = paramcdy;
    q = paramContext;
    r = false;
    f = localResources.getDimensionPixelSize(bua.I);
    g = localResources.getDimensionPixelSize(bua.G);
    h = localResources.getDimensionPixelSize(bua.H);
    i = localResources.getDimension(bua.F);
    j = localResources.getColor(btz.p);
    l = localResources.getColor(btz.q);
    k = localResources.getColor(btz.r);
    paramContext = b();
    paramcdy = a.e;
    int i1;
    if (((paramcdy != null) && (paramcdy.endsWith("icon_11_image_list.png"))) || (paramContext.startsWith("image/"))) {
      i1 = bub.A;
    }
    for (;;)
    {
      o = localResources.getDrawable(i1);
      p = o.getIntrinsicWidth();
      return;
      if (((paramcdy != null) && (paramcdy.endsWith("icon_11_video_list.png"))) || (paramContext.startsWith("video/"))) {
        i1 = bub.H;
      } else if (b.containsKey(paramContext)) {
        i1 = ((Integer)b.get(paramContext)).intValue();
      } else {
        i1 = bub.G;
      }
    }
  }
  
  public static Spanned a(Context paramContext, cdy paramcdy)
  {
    Object localObject = c;
    localObject = new SpannableString(String.valueOf(localObject).length() + 2 + " " + (String)localObject + " ");
    ((SpannableString)localObject).setSpan(new cdt(paramContext, paramcdy), 0, ((SpannableString)localObject).length(), 33);
    return new SpannedString((CharSequence)localObject);
  }
  
  private final void a(Paint.FontMetricsInt paramFontMetricsInt, Paint paramPaint)
  {
    c.set(paramPaint);
    c.setTextSize(i);
    c.setTypeface(Typeface.DEFAULT_BOLD);
    if (paramFontMetricsInt != null) {
      c.getFontMetricsInt(paramFontMetricsInt);
    }
  }
  
  private final String b()
  {
    if (!TextUtils.isEmpty(a.d)) {
      return a.d;
    }
    if (!TextUtils.isEmpty(a.e))
    {
      String str = Uri.parse(a.e).getLastPathSegment();
      if (str != null)
      {
        Iterator localIterator = cdv.a.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (str.equals(localEntry.getValue())) {
            return (String)localEntry.getKey();
          }
        }
      }
    }
    return "";
  }
  
  public final String a(cdx paramcdx)
  {
    return a.a(paramcdx);
  }
  
  public final void a()
  {
    if ((!r) && ((a instanceof cdr)))
    {
      cdr localcdr = (cdr)a;
      Context localContext = q;
      if (localcdr.a()) {
        AsyncTask.execute(new cds(localcdr, localContext));
      }
    }
    r = true;
  }
  
  public final boolean a(String paramString)
  {
    if ((a instanceof cdr))
    {
      cdr localcdr = (cdr)a;
      String str;
      if (localcdr.a())
      {
        f = paramString;
        str = String.valueOf("https://drive.google.com/open?id=");
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0)
        {
          paramString = str.concat(paramString);
          g = paramString;
          b = -1L;
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label95;
        }
        return true;
        paramString = new String(str);
        break;
      }
    }
    label95:
    return false;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    a(e, paramPaint);
    e.top = Math.min(e.top, e.ascent - f);
    e.bottom = Math.max(e.bottom, f);
    paramInt2 = e.top + paramInt4;
    paramInt3 = e.bottom + paramInt4;
    paramInt1 = Math.round(paramFloat);
    d.set(g + paramInt1, paramInt2, n + paramInt1 - g, paramInt3);
    d.inset(1, 1);
    c.setColor(l);
    c.setStyle(Paint.Style.STROKE);
    c.setStrokeWidth(0.0F);
    paramCanvas.drawRect(d, c);
    c.setColor(j);
    c.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(d, c);
    paramInt2 += (paramInt3 - paramInt2 - o.getIntrinsicHeight()) / 2;
    o.setBounds(g + paramInt1 + f, paramInt2, g + paramInt1 + f + p, o.getIntrinsicHeight() + paramInt2);
    o.draw(paramCanvas);
    c.setColor(k);
    c.setTextSize(i);
    c.setTypeface(Typeface.DEFAULT_BOLD);
    paramCanvas.drawText(m, 0, m.length(), g + paramInt1 + f + p + f, paramInt4, c);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof cdt)) && (a.equals(a));
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    a(paramFontMetricsInt, paramPaint);
    if (paramFontMetricsInt != null)
    {
      paramInt1 = g / 2;
      ascent = (Math.min(top, ascent - f) - paramInt1);
      descent = (paramInt1 + Math.max(bottom, f));
      top = ascent;
      bottom = descent;
    }
    paramInt1 = h;
    m = TextUtils.ellipsize(a.c, c, paramInt1, TextUtils.TruncateAt.END);
    n = ((int)c.measureText(m, 0, m.length()) + f + p + f * 2 + g * 2);
    return n;
  }
}

/* Location:
 * Qualified Name:     cdt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */