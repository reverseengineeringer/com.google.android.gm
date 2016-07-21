import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public final class hf
{
  public Notification A;
  public Notification B = new Notification();
  public ArrayList<String> C;
  public Context a;
  public CharSequence b;
  public CharSequence c;
  public PendingIntent d;
  PendingIntent e;
  RemoteViews f;
  public Bitmap g;
  public CharSequence h;
  public int i;
  int j;
  boolean k = true;
  public boolean l;
  public hs m;
  public CharSequence n;
  int o;
  int p;
  boolean q;
  public String r;
  public boolean s;
  public String t;
  public ArrayList<ha> u = new ArrayList();
  boolean v = false;
  public String w;
  Bundle x;
  public int y = 0;
  public int z = 0;
  
  public hf(Context paramContext)
  {
    a = paramContext;
    B.when = System.currentTimeMillis();
    B.audioStreamType = -1;
    j = 0;
    C = new ArrayList();
  }
  
  public static CharSequence e(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    while (paramCharSequence.length() <= 5120) {
      return paramCharSequence;
    }
    return paramCharSequence.subSequence(0, 5120);
  }
  
  public final hf a()
  {
    a(16, true);
    return this;
  }
  
  public final hf a(int paramInt)
  {
    B.icon = paramInt;
    return this;
  }
  
  public final hf a(long paramLong)
  {
    B.when = paramLong;
    return this;
  }
  
  public final hf a(PendingIntent paramPendingIntent)
  {
    B.deleteIntent = paramPendingIntent;
    return this;
  }
  
  public final hf a(Uri paramUri)
  {
    B.sound = paramUri;
    B.audioStreamType = -1;
    return this;
  }
  
  public final hf a(hh paramhh)
  {
    paramhh.a(this);
    return this;
  }
  
  public final hf a(hs paramhs)
  {
    if (m != paramhs)
    {
      m = paramhs;
      if (m != null) {
        m.a(this);
      }
    }
    return this;
  }
  
  public final hf a(CharSequence paramCharSequence)
  {
    b = e(paramCharSequence);
    return this;
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localNotification = B;
      flags |= paramInt;
      return;
    }
    Notification localNotification = B;
    flags &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final Notification b()
  {
    hj localhj = gz.a;
    new hg();
    return localhj.a(this);
  }
  
  public final hf b(int paramInt)
  {
    B.defaults = paramInt;
    if ((paramInt & 0x4) != 0)
    {
      Notification localNotification = B;
      flags |= 0x1;
    }
    return this;
  }
  
  public final hf b(CharSequence paramCharSequence)
  {
    c = e(paramCharSequence);
    return this;
  }
  
  public final hf c(CharSequence paramCharSequence)
  {
    n = e(paramCharSequence);
    return this;
  }
  
  public final hf d(CharSequence paramCharSequence)
  {
    B.tickerText = e(paramCharSequence);
    return this;
  }
}

/* Location:
 * Qualified Name:     hf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */