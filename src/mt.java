import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo.Builder;

final class mt
  extends PrintDocumentAdapter
{
  AsyncTask<Uri, Boolean, Bitmap> a;
  Bitmap b = null;
  private PrintAttributes h;
  
  mt(ms paramms, String paramString, Uri paramUri, mw parammw, int paramInt) {}
  
  final void a()
  {
    synchronized (g.c)
    {
      if (g.b != null)
      {
        g.b.requestCancelDecode();
        g.b = null;
      }
      return;
    }
  }
  
  public final void onFinish()
  {
    super.onFinish();
    a();
    if (a != null) {
      a.cancel(true);
    }
    if (b != null)
    {
      b.recycle();
      b = null;
    }
  }
  
  public final void onLayout(PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle)
  {
    boolean bool = true;
    h = paramPrintAttributes2;
    if (paramCancellationSignal.isCanceled())
    {
      paramLayoutResultCallback.onLayoutCancelled();
      return;
    }
    if (b != null)
    {
      paramCancellationSignal = new PrintDocumentInfo.Builder(c).setContentType(1).setPageCount(1).build();
      if (!paramPrintAttributes2.equals(paramPrintAttributes1)) {}
      for (;;)
      {
        paramLayoutResultCallback.onLayoutFinished(paramCancellationSignal, bool);
        return;
        bool = false;
      }
    }
    a = new mu(this, paramCancellationSignal, paramPrintAttributes2, paramPrintAttributes1, paramLayoutResultCallback).execute(new Uri[0]);
  }
  
  /* Error */
  public final void onWrite(android.print.PageRange[] paramArrayOfPageRange, android.os.ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    // Byte code:
    //   0: new 128	android/print/pdf/PrintedPdfDocument
    //   3: dup
    //   4: aload_0
    //   5: getfield 25	mt:g	Lms;
    //   8: getfield 131	ms:a	Landroid/content/Context;
    //   11: aload_0
    //   12: getfield 74	mt:h	Landroid/print/PrintAttributes;
    //   15: invokespecial 134	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
    //   18: astore 9
    //   20: aload_0
    //   21: getfield 38	mt:b	Landroid/graphics/Bitmap;
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 74	mt:h	Landroid/print/PrintAttributes;
    //   29: invokevirtual 138	android/print/PrintAttributes:getColorMode	()I
    //   32: iconst_1
    //   33: if_icmpeq +210 -> 243
    //   36: aload 9
    //   38: iconst_1
    //   39: invokevirtual 142	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
    //   42: astore_3
    //   43: new 144	android/graphics/RectF
    //   46: dup
    //   47: aload_3
    //   48: invokevirtual 150	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
    //   51: invokevirtual 156	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
    //   54: invokespecial 159	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   57: astore 10
    //   59: aload_0
    //   60: getfield 38	mt:b	Landroid/graphics/Bitmap;
    //   63: invokevirtual 162	android/graphics/Bitmap:getWidth	()I
    //   66: istore 6
    //   68: aload_0
    //   69: getfield 38	mt:b	Landroid/graphics/Bitmap;
    //   72: invokevirtual 165	android/graphics/Bitmap:getHeight	()I
    //   75: istore 7
    //   77: aload_0
    //   78: getfield 33	mt:f	I
    //   81: istore 8
    //   83: new 167	android/graphics/Matrix
    //   86: dup
    //   87: invokespecial 168	android/graphics/Matrix:<init>	()V
    //   90: astore 11
    //   92: aload 10
    //   94: invokevirtual 172	android/graphics/RectF:width	()F
    //   97: iload 6
    //   99: i2f
    //   100: fdiv
    //   101: fstore 5
    //   103: iload 8
    //   105: iconst_2
    //   106: if_icmpne +222 -> 328
    //   109: fload 5
    //   111: aload 10
    //   113: invokevirtual 175	android/graphics/RectF:height	()F
    //   116: iload 7
    //   118: i2f
    //   119: fdiv
    //   120: invokestatic 181	java/lang/Math:max	(FF)F
    //   123: fstore 5
    //   125: aload 11
    //   127: fload 5
    //   129: fload 5
    //   131: invokevirtual 185	android/graphics/Matrix:postScale	(FF)Z
    //   134: pop
    //   135: aload 11
    //   137: aload 10
    //   139: invokevirtual 172	android/graphics/RectF:width	()F
    //   142: iload 6
    //   144: i2f
    //   145: fload 5
    //   147: fmul
    //   148: fsub
    //   149: fconst_2
    //   150: fdiv
    //   151: aload 10
    //   153: invokevirtual 175	android/graphics/RectF:height	()F
    //   156: fload 5
    //   158: iload 7
    //   160: i2f
    //   161: fmul
    //   162: fsub
    //   163: fconst_2
    //   164: fdiv
    //   165: invokevirtual 188	android/graphics/Matrix:postTranslate	(FF)Z
    //   168: pop
    //   169: aload_3
    //   170: invokevirtual 192	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
    //   173: aload_1
    //   174: aload 11
    //   176: aconst_null
    //   177: invokevirtual 198	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   180: aload 9
    //   182: aload_3
    //   183: invokevirtual 202	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
    //   186: aload 9
    //   188: new 204	java/io/FileOutputStream
    //   191: dup
    //   192: aload_2
    //   193: invokevirtual 210	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   196: invokespecial 213	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   199: invokevirtual 217	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
    //   202: aload 4
    //   204: iconst_1
    //   205: anewarray 219	android/print/PageRange
    //   208: dup
    //   209: iconst_0
    //   210: getstatic 223	android/print/PageRange:ALL_PAGES	Landroid/print/PageRange;
    //   213: aastore
    //   214: invokevirtual 229	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFinished	([Landroid/print/PageRange;)V
    //   217: aload 9
    //   219: invokevirtual 232	android/print/pdf/PrintedPdfDocument:close	()V
    //   222: aload_2
    //   223: ifnull +7 -> 230
    //   226: aload_2
    //   227: invokevirtual 233	android/os/ParcelFileDescriptor:close	()V
    //   230: aload_1
    //   231: aload_0
    //   232: getfield 38	mt:b	Landroid/graphics/Bitmap;
    //   235: if_acmpeq +7 -> 242
    //   238: aload_1
    //   239: invokevirtual 70	android/graphics/Bitmap:recycle	()V
    //   242: return
    //   243: aload_1
    //   244: invokevirtual 162	android/graphics/Bitmap:getWidth	()I
    //   247: aload_1
    //   248: invokevirtual 165	android/graphics/Bitmap:getHeight	()I
    //   251: getstatic 239	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   254: invokestatic 243	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   257: astore_3
    //   258: new 194	android/graphics/Canvas
    //   261: dup
    //   262: aload_3
    //   263: invokespecial 246	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   266: astore 10
    //   268: new 248	android/graphics/Paint
    //   271: dup
    //   272: invokespecial 249	android/graphics/Paint:<init>	()V
    //   275: astore 11
    //   277: new 251	android/graphics/ColorMatrix
    //   280: dup
    //   281: invokespecial 252	android/graphics/ColorMatrix:<init>	()V
    //   284: astore 12
    //   286: aload 12
    //   288: fconst_0
    //   289: invokevirtual 256	android/graphics/ColorMatrix:setSaturation	(F)V
    //   292: aload 11
    //   294: new 258	android/graphics/ColorMatrixColorFilter
    //   297: dup
    //   298: aload 12
    //   300: invokespecial 261	android/graphics/ColorMatrixColorFilter:<init>	(Landroid/graphics/ColorMatrix;)V
    //   303: invokevirtual 265	android/graphics/Paint:setColorFilter	(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    //   306: pop
    //   307: aload 10
    //   309: aload_1
    //   310: fconst_0
    //   311: fconst_0
    //   312: aload 11
    //   314: invokevirtual 268	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   317: aload 10
    //   319: aconst_null
    //   320: invokevirtual 271	android/graphics/Canvas:setBitmap	(Landroid/graphics/Bitmap;)V
    //   323: aload_3
    //   324: astore_1
    //   325: goto -289 -> 36
    //   328: fload 5
    //   330: aload 10
    //   332: invokevirtual 175	android/graphics/RectF:height	()F
    //   335: iload 7
    //   337: i2f
    //   338: fdiv
    //   339: invokestatic 274	java/lang/Math:min	(FF)F
    //   342: fstore 5
    //   344: goto -219 -> 125
    //   347: astore_3
    //   348: ldc_w 276
    //   351: ldc_w 278
    //   354: aload_3
    //   355: invokestatic 283	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   358: pop
    //   359: aload 4
    //   361: aconst_null
    //   362: invokevirtual 287	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFailed	(Ljava/lang/CharSequence;)V
    //   365: goto -148 -> 217
    //   368: astore_3
    //   369: aload 9
    //   371: invokevirtual 232	android/print/pdf/PrintedPdfDocument:close	()V
    //   374: aload_2
    //   375: ifnull +7 -> 382
    //   378: aload_2
    //   379: invokevirtual 233	android/os/ParcelFileDescriptor:close	()V
    //   382: aload_1
    //   383: aload_0
    //   384: getfield 38	mt:b	Landroid/graphics/Bitmap;
    //   387: if_acmpeq +7 -> 394
    //   390: aload_1
    //   391: invokevirtual 70	android/graphics/Bitmap:recycle	()V
    //   394: aload_3
    //   395: athrow
    //   396: astore_2
    //   397: goto -167 -> 230
    //   400: astore_2
    //   401: goto -19 -> 382
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	mt
    //   0	404	1	paramArrayOfPageRange	android.print.PageRange[]
    //   0	404	2	paramParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   0	404	3	paramCancellationSignal	CancellationSignal
    //   0	404	4	paramWriteResultCallback	android.print.PrintDocumentAdapter.WriteResultCallback
    //   101	242	5	f1	float
    //   66	77	6	i	int
    //   75	261	7	j	int
    //   81	26	8	k	int
    //   18	352	9	localPrintedPdfDocument	android.print.pdf.PrintedPdfDocument
    //   57	274	10	localObject1	Object
    //   90	223	11	localObject2	Object
    //   284	15	12	localColorMatrix	android.graphics.ColorMatrix
    // Exception table:
    //   from	to	target	type
    //   186	217	347	java/io/IOException
    //   36	103	368	finally
    //   109	125	368	finally
    //   125	186	368	finally
    //   186	217	368	finally
    //   328	344	368	finally
    //   348	365	368	finally
    //   226	230	396	java/io/IOException
    //   378	382	400	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     mt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */