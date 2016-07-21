package com.google.android.gms.feedback;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fjp;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public class FileTeleporter
  implements SafeParcelable
{
  public static final Parcelable.Creator<FileTeleporter> CREATOR = new fjp();
  final int a;
  ParcelFileDescriptor b;
  final String c;
  final String d;
  public File e;
  private byte[] f;
  
  public FileTeleporter(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor, String paramString1, String paramString2)
  {
    a = paramInt;
    b = paramParcelFileDescriptor;
    c = paramString1;
    d = paramString2;
  }
  
  public FileTeleporter(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    this(1, null, paramString1, paramString2);
    f = paramArrayOfByte;
  }
  
  /* Error */
  private final java.io.FileOutputStream a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/google/android/gms/feedback/FileTeleporter:e	Ljava/io/File;
    //   4: ifnonnull +13 -> 17
    //   7: new 54	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 56
    //   13: invokespecial 59	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: ldc 61
    //   19: ldc 63
    //   21: aload_0
    //   22: getfield 52	com/google/android/gms/feedback/FileTeleporter:e	Ljava/io/File;
    //   25: invokestatic 69	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   28: astore_1
    //   29: new 71	java/io/FileOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 74	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_2
    //   38: aload_0
    //   39: aload_1
    //   40: ldc 75
    //   42: invokestatic 81	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   45: putfield 36	com/google/android/gms/feedback/FileTeleporter:b	Landroid/os/ParcelFileDescriptor;
    //   48: aload_1
    //   49: invokevirtual 85	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_2
    //   54: areturn
    //   55: astore_1
    //   56: new 54	java/lang/IllegalStateException
    //   59: dup
    //   60: ldc 87
    //   62: aload_1
    //   63: invokespecial 90	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: athrow
    //   67: astore_1
    //   68: new 54	java/lang/IllegalStateException
    //   71: dup
    //   72: ldc 92
    //   74: invokespecial 59	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	FileTeleporter
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
      Log.w("FileTeleporter", "Could not close stream", paramCloseable);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    DataOutputStream localDataOutputStream;
    if (b == null) {
      localDataOutputStream = new DataOutputStream(a());
    }
    try
    {
      localDataOutputStream.writeInt(f.length);
      localDataOutputStream.writeUTF(c);
      localDataOutputStream.writeUTF(d);
      localDataOutputStream.write(f);
      a(localDataOutputStream);
      int i = emj.a(paramParcel, 20293);
      emj.b(paramParcel, 1, a);
      emj.a(paramParcel, 2, b, paramInt, false);
      emj.a(paramParcel, 3, c, false);
      emj.a(paramParcel, 4, d, false);
      emj.b(paramParcel, i);
      return;
    }
    catch (IOException paramParcel)
    {
      throw new IllegalStateException("Could not write into unlinked file", paramParcel);
    }
    finally
    {
      a(localDataOutputStream);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.feedback.FileTeleporter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */