import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.FolderList;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class cni
{
  public final Context d;
  public final NavigableSet<Folder> e = new TreeSet();
  public final cnj f = new cnj();
  
  public cni(Context paramContext)
  {
    d = paramContext;
    a();
  }
  
  public static void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, cnj paramcnj, mx parammx, Paint paramPaint)
  {
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, h + paramFloat2);
    paramPaint.setColor(paramInt4);
    paramPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, paramInt1, paramInt2), c, c, paramPaint);
    paramPaint.setColor(paramInt3);
    paramPaint.setStyle(Paint.Style.FILL);
    int k = (int)paramPaint.measureText(paramString);
    int j;
    int i;
    if (d.a(paramString, paramString.length()))
    {
      j = d;
      i = e;
      paramInt4 = paramInt1 - e - k;
    }
    for (;;)
    {
      if (k > paramInt1 - e * 2) {
        paramPaint.setShader(new LinearGradient(j, 0.0F, i, 0.0F, paramInt3, cxa.a(paramInt3), Shader.TileMode.CLAMP));
      }
      paramInt1 = paramInt2 / 2;
      paramInt2 = (int)(paramPaint.descent() + paramPaint.ascent()) / 2;
      paramCanvas.drawText(paramString, paramInt4, paramInt1 - paramInt2, paramPaint);
      paramPaint.setShader(null);
      paramCanvas.restore();
      return;
      j = d;
      i = e;
      paramInt4 = e;
      i = paramInt1 - i;
      j = paramInt1 - j;
    }
  }
  
  public static int[] a(Set<Folder> paramSet, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    int j = Math.min(paramInt5, paramSet.size());
    if (j == 0) {
      return new int[0];
    }
    int k = Math.min(paramInt1, (paramInt2 - (j - 1) * paramInt3) / j);
    int[] arrayOfInt = new int[j];
    paramSet = paramSet.iterator();
    paramInt5 = 0;
    paramInt3 = 0;
    paramInt2 = 0;
    if (paramSet.hasNext())
    {
      Folder localFolder = (Folder)paramSet.next();
      if (paramInt5 <= j - 1)
      {
        int m = paramInt4 * 2 + (int)paramPaint.measureText(d);
        if (m > k)
        {
          paramInt3 = paramInt2 - Math.min(m - k, paramInt1 - k);
          if (paramInt3 >= 0) {
            arrayOfInt[paramInt5] = Math.min(m, paramInt1);
          }
          for (paramInt2 = paramInt3;; paramInt2 = 0)
          {
            paramInt3 = -paramInt3;
            paramInt5 += 1;
            break;
            arrayOfInt[paramInt5] = (k + paramInt2);
          }
        }
        int i = k - m;
        arrayOfInt[paramInt5] = m;
        paramInt2 = i;
        if (paramInt3 > 0)
        {
          if (i < paramInt3) {
            break label223;
          }
          paramInt2 = paramInt5 - 1;
          arrayOfInt[paramInt2] += paramInt3;
        }
        for (paramInt2 = i - paramInt3;; paramInt2 = 0)
        {
          paramInt3 = 0;
          break;
          label223:
          paramInt2 = paramInt5 - 1;
          arrayOfInt[paramInt2] = (i + arrayOfInt[paramInt2]);
        }
      }
    }
    return arrayOfInt;
  }
  
  public void a()
  {
    Resources localResources = d.getResources();
    f.a = localResources.getColor(btz.n);
    f.b = localResources.getColor(btz.m);
    f.c = localResources.getDimensionPixelOffset(bua.M);
    f.f = localResources.getDimensionPixelOffset(bua.N);
  }
  
  public void a(Conversation paramConversation, cus paramcus, int paramInt)
  {
    e.clear();
    paramConversation = n.a.iterator();
    while (paramConversation.hasNext())
    {
      Folder localFolder = (Folder)paramConversation.next();
      if (((paramInt < 0) || (!localFolder.d(paramInt))) && ((paramcus == null) || (!paramcus.equals(c)))) {
        e.add(localFolder);
      }
    }
  }
  
  public void b()
  {
    e.clear();
  }
}

/* Location:
 * Qualified Name:     cni
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */