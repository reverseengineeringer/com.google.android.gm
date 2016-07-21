package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import elo;
import emj;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BitmapTeleporter
  implements SafeParcelable
{
  public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new elo();
  final int a;
  public ParcelFileDescriptor b;
  final int c;
  public boolean d;
  private Bitmap e;
  private File f;
  
  public BitmapTeleporter(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2)
  {
    a = paramInt1;
    b = paramParcelFileDescriptor;
    c = paramInt2;
    e = null;
    d = false;
  }
  
  public BitmapTeleporter(Bitmap paramBitmap)
  {
    a = 1;
    b = null;
    c = 0;
    e = paramBitmap;
    d = true;
  }
  
  /* Error */
  private final java.io.FileOutputStream a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/google/android/gms/common/data/BitmapTeleporter:f	Ljava/io/File;
    //   4: ifnonnull +13 -> 17
    //   7: new 52	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 54
    //   13: invokespecial 57	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: ldc 59
    //   19: ldc 61
    //   21: aload_0
    //   22: getfield 50	com/google/android/gms/common/data/BitmapTeleporter:f	Ljava/io/File;
    //   25: invokestatic 67	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   28: astore_1
    //   29: new 69	java/io/FileOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 72	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_2
    //   38: aload_0
    //   39: aload_1
    //   40: ldc 73
    //   42: invokestatic 79	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   45: putfield 36	com/google/android/gms/common/data/BitmapTeleporter:b	Landroid/os/ParcelFileDescriptor;
    //   48: aload_1
    //   49: invokevirtual 83	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_2
    //   54: areturn
    //   55: astore_1
    //   56: new 52	java/lang/IllegalStateException
    //   59: dup
    //   60: ldc 85
    //   62: aload_1
    //   63: invokespecial 88	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: athrow
    //   67: astore_1
    //   68: new 52	java/lang/IllegalStateException
    //   71: dup
    //   72: ldc 90
    //   74: invokespecial 57	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	BitmapTeleporter
    //   28	21	1	localFile	File
    //   55	8	1	localIOException	IOException
    //   67	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   37	17	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   17	29	55	java/io/IOException
    //   29	48	67	java/io/FileNotFoundException
  }
  
  private static void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.w("BitmapTeleporter", "Could not close stream", paramCloseable);
    }
  }
  
  public final void a(File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("Cannot set null temp directory");
    }
    f = paramFile;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bitmap localBitmap;
    Object localObject;
    byte[] arrayOfByte;
    if (b == null)
    {
      localBitmap = e;
      localObject = ByteBuffer.allocate(localBitmap.getRowBytes() * localBitmap.getHeight());
      localBitmap.copyPixelsToBuffer((Buffer)localObject);
      arrayOfByte = ((ByteBuffer)localObject).array();
      localObject = new DataOutputStream(a());
    }
    try
    {
      ((DataOutputStream)localObject).writeInt(arrayOfByte.length);
      ((DataOutputStream)localObject).writeInt(localBitmap.getWidth());
      ((DataOutputStream)localObject).writeInt(localBitmap.getHeight());
      ((DataOutputStream)localObject).writeUTF(localBitmap.getConfig().toString());
      ((DataOutputStream)localObject).write(arrayOfByte);
      a((Closeable)localObject);
      int i = emj.a(paramParcel, 20293);
      emj.b(paramParcel, 1, a);
      emj.a(paramParcel, 2, b, paramInt | 0x1, false);
      emj.b(paramParcel, 3, c);
      emj.b(paramParcel, i);
      b = null;
      return;
    }
    catch (IOException paramParcel)
    {
      throw new IllegalStateException("Could not write into unlinked file", paramParcel);
    }
    finally
    {
      a((Closeable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.BitmapTeleporter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */