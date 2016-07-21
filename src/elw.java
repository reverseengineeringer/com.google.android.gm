import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.ImageManager.ImageReceiver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public final class elw
  implements Runnable
{
  private final Uri b;
  private final Bitmap c;
  private final CountDownLatch d;
  private boolean e;
  
  public elw(ImageManager paramImageManager, Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
  {
    b = paramUri;
    c = paramBitmap;
    e = paramBoolean;
    d = paramCountDownLatch;
  }
  
  private final void a(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
  {
    ArrayList localArrayList = a;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      elx localelx = (elx)localArrayList.get(i);
      Object localObject2;
      Object localObject1;
      if (paramBoolean)
      {
        localObject2 = ImageManager.b(a);
        localObject1 = c;
        if (localObject1 == null) {
          throw new IllegalArgumentException("null reference");
        }
        paramImageReceiver = (ImageManager.ImageReceiver)localObject1;
        if ((c & 0x1) != 0) {
          paramImageReceiver = fni.a((Bitmap)localObject1);
        }
        new BitmapDrawable(((Context)localObject2).getResources(), paramImageReceiver);
        localelx.a();
        if (!(localelx instanceof elz)) {
          ImageManager.a(a).remove(localelx);
        }
        i += 1;
      }
      else
      {
        ImageManager.d(a).put(b, Long.valueOf(SystemClock.elapsedRealtime()));
        paramImageReceiver = ImageManager.b(a);
        localObject2 = ImageManager.c(a);
        int k;
        Resources localResources;
        if (b != 0)
        {
          k = b;
          localResources = paramImageReceiver.getResources();
          if (c <= 0) {
            break label366;
          }
          fnk localfnk = new fnk(k, c);
          if ((Drawable)((fnj)localObject2).b(localfnk) == null)
          {
            localObject1 = localResources.getDrawable(k);
            paramImageReceiver = (ImageManager.ImageReceiver)localObject1;
            if ((c & 0x1) != 0)
            {
              if (localObject1 != null) {
                break label292;
              }
              paramImageReceiver = null;
              label261:
              paramImageReceiver = new BitmapDrawable(localResources, fni.a(paramImageReceiver));
            }
            ((fnj)localObject2).a(localfnk, paramImageReceiver);
          }
        }
        for (;;)
        {
          localelx.a();
          break;
          label292:
          if ((localObject1 instanceof BitmapDrawable))
          {
            paramImageReceiver = ((BitmapDrawable)localObject1).getBitmap();
            break label261;
          }
          paramImageReceiver = Bitmap.createBitmap(((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(paramImageReceiver);
          ((Drawable)localObject1).setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
          ((Drawable)localObject1).draw(localCanvas);
          break label261;
          label366:
          localResources.getDrawable(k);
        }
      }
    }
  }
  
  public final void run()
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
      throw new IllegalStateException("OnBitmapLoadedRunnable must be executed in the main thread");
    }
    boolean bool;
    if (c != null) {
      bool = true;
    }
    while (ImageManager.h(a) != null) {
      if (e)
      {
        ImageManager.h(a).a(-1);
        System.gc();
        e = false;
        ImageManager.g(a).post(this);
        return;
        bool = false;
      }
      else if (bool)
      {
        ImageManager.h(a).a(new ely(b), c);
      }
    }
    ??? = (ImageManager.ImageReceiver)ImageManager.e(a).remove(b);
    if (??? != null) {
      a((ImageManager.ImageReceiver)???, bool);
    }
    d.countDown();
    synchronized (ImageManager.a)
    {
      ImageManager.b.remove(b);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     elw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */