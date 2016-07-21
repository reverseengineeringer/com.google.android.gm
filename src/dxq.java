import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.util.Pair;
import com.android.mail.providers.Account;

public final class dxq
  extends fsc
{
  private static final String k = cvl.a;
  private final oi<String, dxp> l;
  private int m;
  private int n;
  private int o;
  private int p;
  private cff q;
  private cff r;
  private LruCache<Pair<String, Integer>, Bitmap> s = new LruCache(5);
  
  public dxq(Context paramContext, eiz parameiz, oi<String, dxp> paramoi)
  {
    super(paramContext, parameiz);
    l = paramoi;
    paramContext = paramContext.getResources();
    o = paramContext.getDimensionPixelSize(dfw.m);
    p = paramContext.getDimensionPixelSize(dfw.l);
    m = paramContext.getDimensionPixelSize(dfw.a);
    n = paramContext.getDimensionPixelSize(dfw.k);
    q = new cff(paramContext, new bvh(paramContext));
    r = new cff(paramContext, new buz(paramContext, dfs.b));
  }
  
  public final Bitmap a(Context paramContext, fyb paramfyb, int paramInt)
  {
    String str = paramfyb.b();
    Pair localPair = new Pair(str, Integer.valueOf(paramInt));
    Bitmap localBitmap = (Bitmap)s.get(localPair);
    Object localObject = localBitmap;
    if (localBitmap == null)
    {
      localObject = (dxp)l.get(str);
      if (localObject != null) {
        break label93;
      }
    }
    for (paramContext = super.a(b, paramfyb, paramInt);; paramContext = super.a(paramContext, paramfyb, paramInt))
    {
      s.put(localPair, paramContext);
      localObject = paramContext;
      return (Bitmap)localObject;
      label93:
      localObject = a;
      if (localObject != null) {
        break;
      }
      cvm.d(k, "GmailOwnerAvatar has a gmailOwner but a null account", new Object[0]);
    }
    paramContext = r;
    paramfyb = q;
    label171:
    int i;
    switch (paramInt)
    {
    default: 
      f = n;
      i = (int)f;
      switch (paramInt)
      {
      }
      break;
    }
    for (float f = p;; f = o)
    {
      paramContext = dww.a((Account)localObject, paramContext, paramfyb, i, f, true);
      break;
      f = m;
      break label171;
    }
  }
}

/* Location:
 * Qualified Name:     dxq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */