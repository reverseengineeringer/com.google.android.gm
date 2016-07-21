import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class fsi
{
  public static volatile Executor a = null;
  private static boolean k;
  public final Context b;
  public final eiz c;
  public final ConcurrentHashMap<String, Bitmap> d = new ConcurrentHashMap();
  public boolean e;
  public fsj f;
  public final LinkedList<fsj> g = new LinkedList();
  boolean h;
  float i;
  float j;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {
      a = AsyncTask.THREAD_POOL_EXECUTOR;
    }
  }
  
  public fsi(Context paramContext, eiz parameiz, boolean paramBoolean)
  {
    b = paramContext;
    c = parameiz;
    h = paramBoolean;
    parameiz = paramContext.getResources();
    j = parameiz.getInteger(fsv.b);
    i = parameiz.getInteger(fsv.a);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (Build.VERSION.SDK_INT >= 19) {}
    for (paramBoolean = paramContext.isLowRamDevice();; paramBoolean = false)
    {
      k = paramBoolean;
      return;
    }
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m;
    if (k) {
      m = 2;
    }
    int n;
    do
    {
      return m;
      n = 1;
      m = 1;
    } while ((paramInt1 <= paramInt4) && (paramInt2 <= paramInt3));
    int i1 = paramInt1 / 2;
    paramInt2 /= 2;
    paramInt1 = n;
    for (;;)
    {
      m = paramInt1;
      if (i1 / paramInt1 < paramInt4) {
        break;
      }
      m = paramInt1;
      if (paramInt2 / paramInt1 < paramInt3) {
        break;
      }
      paramInt1 *= 2;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, float paramFloat)
  {
    int i1 = (int)(paramInt * paramFloat);
    int m = paramBitmap.getWidth();
    int n = paramBitmap.getHeight();
    if ((paramInt == m) && (i1 == n)) {
      return paramBitmap;
    }
    Matrix localMatrix = new Matrix();
    paramFloat = Math.max(paramInt / m, i1 / n);
    localMatrix.setScale(paramFloat, paramFloat);
    paramInt = Math.round(paramInt / paramFloat);
    i1 = Math.round(i1 / paramFloat);
    int i2 = (int)(m * 0.5F - paramInt / 2);
    int i3 = (int)(n * 0.5F - i1 / 2);
    return Bitmap.createBitmap(paramBitmap, Math.max(Math.min(i2, m - paramInt), 0), Math.max(Math.min(i3, n - i1), 0), paramInt, i1, localMatrix, true);
  }
  
  /* Error */
  public static Bitmap a(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 141	android/graphics/BitmapFactory$Options
    //   9: dup
    //   10: invokespecial 142	android/graphics/BitmapFactory$Options:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: iload_1
    //   18: iload_2
    //   19: iload_3
    //   20: iload 4
    //   22: invokestatic 144	fsi:a	(IIII)I
    //   25: putfield 147	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   28: aload 6
    //   30: iconst_0
    //   31: putfield 150	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   34: aload 6
    //   36: iload_1
    //   37: putfield 153	android/graphics/BitmapFactory$Options:outWidth	I
    //   40: aload 6
    //   42: iload_2
    //   43: putfield 156	android/graphics/BitmapFactory$Options:outHeight	I
    //   46: getstatic 97	fsi:k	Z
    //   49: ifeq +11 -> 60
    //   52: aload 6
    //   54: getstatic 162	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   57: putfield 165	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   60: new 167	java/io/FileInputStream
    //   63: dup
    //   64: aload_0
    //   65: invokevirtual 173	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   68: invokespecial 176	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   71: astore 5
    //   73: aload 5
    //   75: aconst_null
    //   76: aload 6
    //   78: invokestatic 182	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   81: astore_0
    //   82: aload 5
    //   84: invokevirtual 187	java/io/InputStream:close	()V
    //   87: aload_0
    //   88: areturn
    //   89: astore 5
    //   91: aload_0
    //   92: areturn
    //   93: astore_0
    //   94: aconst_null
    //   95: astore 5
    //   97: aload 5
    //   99: ifnull +8 -> 107
    //   102: aload 5
    //   104: invokevirtual 187	java/io/InputStream:close	()V
    //   107: aload_0
    //   108: athrow
    //   109: astore 5
    //   111: goto -4 -> 107
    //   114: astore_0
    //   115: goto -18 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramParcelFileDescriptor	ParcelFileDescriptor
    //   0	118	1	paramInt1	int
    //   0	118	2	paramInt2	int
    //   0	118	3	paramInt3	int
    //   0	118	4	paramInt4	int
    //   71	12	5	localFileInputStream	java.io.FileInputStream
    //   89	1	5	localIOException1	IOException
    //   95	8	5	localObject	Object
    //   109	1	5	localIOException2	IOException
    //   13	64	6	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   82	87	89	java/io/IOException
    //   60	73	93	finally
    //   102	107	109	java/io/IOException
    //   73	82	114	finally
  }
  
  private final void a()
  {
    if (g.isEmpty()) {}
    while ((f != null) && (!f.e)) {
      return;
    }
    f = ((fsj)g.remove());
    f.a();
  }
  
  public final void a(ImageView paramImageView)
  {
    paramImageView.setTag(null);
    int m = 0;
    while (m < g.size()) {
      if (g.get(m)).f == paramImageView) {
        g.remove(m);
      } else {
        m += 1;
      }
    }
    if ((f != null) && (f.f == paramImageView))
    {
      f.e = true;
      a();
    }
  }
  
  public final void a(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2, int paramInt3, fsj paramfsj)
  {
    try
    {
      if (f != paramfsj)
      {
        Log.w("AvatarManager", "Got a different request than we're waiting for!");
        if (!e) {
          a();
        }
        if (paramParcelFileDescriptor == null) {}
      }
      do
      {
        boolean bool;
        do
        {
          try
          {
            paramParcelFileDescriptor.close();
            return;
          }
          catch (IOException paramStatus)
          {
            Log.w("AvatarManager", "IOException closing parcel file descriptor");
            return;
          }
          f = null;
          bool = e;
          if (!bool) {
            break;
          }
          if (!e) {
            a();
          }
        } while (paramParcelFileDescriptor == null);
        try
        {
          paramParcelFileDescriptor.close();
          return;
        }
        catch (IOException paramStatus)
        {
          Log.w("AvatarManager", "IOException closing parcel file descriptor");
          return;
        }
        if (f.getTag() == paramfsj)
        {
          bool = e;
          if (!bool) {
            break;
          }
        }
        if (!e) {
          a();
        }
      } while (paramParcelFileDescriptor == null);
      try
      {
        paramParcelFileDescriptor.close();
        return;
      }
      catch (IOException paramStatus)
      {
        Log.w("AvatarManager", "IOException closing parcel file descriptor");
        return;
      }
      if ((!paramStatus.b()) || (paramParcelFileDescriptor == null))
      {
        paramStatus = String.valueOf(paramStatus);
        String str = String.valueOf(paramParcelFileDescriptor);
        new StringBuilder(String.valueOf(paramStatus).length() + 28 + String.valueOf(str).length()).append("Avatar loaded: status=").append(paramStatus).append("  pfd=").append(str);
      }
      if (paramParcelFileDescriptor != null)
      {
        paramStatus = new fsk(this, paramfsj, paramParcelFileDescriptor, paramInt1, paramInt2, paramInt3);
        if (Build.VERSION.SDK_INT >= 11)
        {
          paramStatus.executeOnExecutor(a, new Void[0]);
          label259:
          paramParcelFileDescriptor = null;
        }
      }
      for (;;)
      {
        if (!e) {
          a();
        }
        if (paramParcelFileDescriptor == null) {
          break;
        }
        try
        {
          paramParcelFileDescriptor.close();
          return;
        }
        catch (IOException paramStatus)
        {
          Log.w("AvatarManager", "IOException closing parcel file descriptor");
          return;
        }
        paramStatus.execute(null);
        break label259;
        try
        {
          paramParcelFileDescriptor.close();
          throw paramStatus;
          a(paramfsj, null);
        }
        catch (IOException paramParcelFileDescriptor)
        {
          for (;;)
          {
            Log.w("AvatarManager", "IOException closing parcel file descriptor");
          }
        }
      }
    }
    finally
    {
      if (!e) {
        a();
      }
      if (paramParcelFileDescriptor == null) {}
    }
  }
  
  public final void a(fsj paramfsj)
  {
    if (d.containsKey(g))
    {
      f.setImageBitmap((Bitmap)d.get(g));
      a(f);
    }
    ImageView localImageView;
    do
    {
      return;
      localImageView = f;
      a(localImageView);
    } while (!c.e());
    localImageView.setTag(paramfsj);
    g.add(paramfsj);
    a();
  }
  
  protected void a(fsj paramfsj, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      f.setImageBitmap(paramBitmap);
    }
  }
}

/* Location:
 * Qualified Name:     fsi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */