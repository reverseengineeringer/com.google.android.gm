import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public final class agz
  extends Spinner
  implements rb
{
  static final boolean a;
  private static final boolean e;
  private static final int[] f;
  ahc b;
  int c;
  final Rect d;
  private agj g;
  private agf h;
  private Context i;
  private ajr j;
  private SpinnerAdapter k;
  private boolean l;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool = true;
      a = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      e = bool;
      f = new int[] { 16843505 };
      return;
      bool = false;
      break;
    }
  }
  
  public agz(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, aca.L);
  }
  
  public agz(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private agz(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  /* Error */
  private agz(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: iload_3
    //   7: invokespecial 62	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   10: aload_0
    //   11: new 64	android/graphics/Rect
    //   14: dup
    //   15: invokespecial 66	android/graphics/Rect:<init>	()V
    //   18: putfield 68	agz:d	Landroid/graphics/Rect;
    //   21: aload_1
    //   22: aload_2
    //   23: getstatic 73	ack:cf	[I
    //   26: iload_3
    //   27: invokestatic 78	amp:a	(Landroid/content/Context;Landroid/util/AttributeSet;[II)Lamp;
    //   30: astore 9
    //   32: aload_0
    //   33: invokestatic 83	agj:a	()Lagj;
    //   36: putfield 85	agz:g	Lagj;
    //   39: aload_0
    //   40: new 87	agf
    //   43: dup
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 85	agz:g	Lagj;
    //   49: invokespecial 90	agf:<init>	(Landroid/view/View;Lagj;)V
    //   52: putfield 92	agz:h	Lagf;
    //   55: aload 9
    //   57: getstatic 95	ack:ck	I
    //   60: iconst_0
    //   61: invokevirtual 98	amp:e	(II)I
    //   64: istore 5
    //   66: iload 5
    //   68: ifeq +290 -> 358
    //   71: new 100	adc
    //   74: dup
    //   75: aload_1
    //   76: iload 5
    //   78: invokespecial 103	adc:<init>	(Landroid/content/Context;I)V
    //   81: astore 7
    //   83: aload_0
    //   84: aload 7
    //   86: putfield 105	agz:i	Landroid/content/Context;
    //   89: aload_0
    //   90: getfield 105	agz:i	Landroid/content/Context;
    //   93: ifnull +175 -> 268
    //   96: getstatic 35	android/os/Build$VERSION:SDK_INT	I
    //   99: bipush 11
    //   101: if_icmplt +318 -> 419
    //   104: aload_1
    //   105: aload_2
    //   106: getstatic 42	agz:f	[I
    //   109: iload_3
    //   110: iconst_0
    //   111: invokevirtual 111	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   114: astore 7
    //   116: iload 4
    //   118: istore 5
    //   120: aload 7
    //   122: iconst_0
    //   123: invokevirtual 117	android/content/res/TypedArray:hasValue	(I)Z
    //   126: ifeq +12 -> 138
    //   129: aload 7
    //   131: iconst_0
    //   132: iconst_0
    //   133: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
    //   136: istore 5
    //   138: iload 5
    //   140: istore 6
    //   142: aload 7
    //   144: ifnull +12 -> 156
    //   147: aload 7
    //   149: invokevirtual 123	android/content/res/TypedArray:recycle	()V
    //   152: iload 5
    //   154: istore 6
    //   156: iload 6
    //   158: iconst_1
    //   159: if_icmpne +109 -> 268
    //   162: new 125	ahc
    //   165: dup
    //   166: aload_0
    //   167: aload_0
    //   168: getfield 105	agz:i	Landroid/content/Context;
    //   171: aload_2
    //   172: iload_3
    //   173: invokespecial 128	ahc:<init>	(Lagz;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   176: astore 7
    //   178: aload_0
    //   179: getfield 105	agz:i	Landroid/content/Context;
    //   182: aload_2
    //   183: getstatic 73	ack:cf	[I
    //   186: iload_3
    //   187: invokestatic 78	amp:a	(Landroid/content/Context;Landroid/util/AttributeSet;[II)Lamp;
    //   190: astore 8
    //   192: aload_0
    //   193: aload 8
    //   195: getstatic 131	ack:cg	I
    //   198: bipush -2
    //   200: invokevirtual 133	amp:d	(II)I
    //   203: putfield 135	agz:c	I
    //   206: aload 7
    //   208: aload 8
    //   210: getstatic 138	ack:ci	I
    //   213: invokevirtual 141	amp:a	(I)Landroid/graphics/drawable/Drawable;
    //   216: invokevirtual 144	ahc:a	(Landroid/graphics/drawable/Drawable;)V
    //   219: getstatic 147	ack:cj	I
    //   222: istore 4
    //   224: aload 7
    //   226: aload 9
    //   228: getfield 150	amp:a	Landroid/content/res/TypedArray;
    //   231: iload 4
    //   233: invokevirtual 154	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   236: putfield 157	ahc:a	Ljava/lang/CharSequence;
    //   239: aload 8
    //   241: getfield 150	amp:a	Landroid/content/res/TypedArray;
    //   244: invokevirtual 123	android/content/res/TypedArray:recycle	()V
    //   247: aload_0
    //   248: aload 7
    //   250: putfield 159	agz:b	Lahc;
    //   253: aload_0
    //   254: new 161	aha
    //   257: dup
    //   258: aload_0
    //   259: aload_0
    //   260: aload 7
    //   262: invokespecial 164	aha:<init>	(Lagz;Landroid/view/View;Lahc;)V
    //   265: putfield 166	agz:j	Lajr;
    //   268: getstatic 169	ack:ch	I
    //   271: istore 4
    //   273: aload 9
    //   275: getfield 150	amp:a	Landroid/content/res/TypedArray;
    //   278: iload 4
    //   280: invokevirtual 173	android/content/res/TypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   283: astore 7
    //   285: aload 7
    //   287: ifnull +28 -> 315
    //   290: new 175	android/widget/ArrayAdapter
    //   293: dup
    //   294: aload_1
    //   295: ldc -80
    //   297: aload 7
    //   299: invokespecial 179	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   302: astore_1
    //   303: aload_1
    //   304: getstatic 184	ach:q	I
    //   307: invokevirtual 188	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   310: aload_0
    //   311: aload_1
    //   312: invokevirtual 192	agz:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   315: aload 9
    //   317: getfield 150	amp:a	Landroid/content/res/TypedArray;
    //   320: invokevirtual 123	android/content/res/TypedArray:recycle	()V
    //   323: aload_0
    //   324: iconst_1
    //   325: putfield 194	agz:l	Z
    //   328: aload_0
    //   329: getfield 196	agz:k	Landroid/widget/SpinnerAdapter;
    //   332: ifnull +16 -> 348
    //   335: aload_0
    //   336: aload_0
    //   337: getfield 196	agz:k	Landroid/widget/SpinnerAdapter;
    //   340: invokevirtual 192	agz:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   343: aload_0
    //   344: aconst_null
    //   345: putfield 196	agz:k	Landroid/widget/SpinnerAdapter;
    //   348: aload_0
    //   349: getfield 92	agz:h	Lagf;
    //   352: aload_2
    //   353: iload_3
    //   354: invokevirtual 199	agf:a	(Landroid/util/AttributeSet;I)V
    //   357: return
    //   358: getstatic 37	agz:a	Z
    //   361: ifne +9 -> 370
    //   364: aload_1
    //   365: astore 7
    //   367: goto -284 -> 83
    //   370: aconst_null
    //   371: astore 7
    //   373: goto -290 -> 83
    //   376: astore 7
    //   378: aconst_null
    //   379: astore 7
    //   381: iload 4
    //   383: istore 6
    //   385: aload 7
    //   387: ifnull -231 -> 156
    //   390: aload 7
    //   392: invokevirtual 123	android/content/res/TypedArray:recycle	()V
    //   395: iload 4
    //   397: istore 6
    //   399: goto -243 -> 156
    //   402: astore_1
    //   403: aload 8
    //   405: astore 7
    //   407: aload 7
    //   409: ifnull +8 -> 417
    //   412: aload 7
    //   414: invokevirtual 123	android/content/res/TypedArray:recycle	()V
    //   417: aload_1
    //   418: athrow
    //   419: iconst_1
    //   420: istore 6
    //   422: goto -266 -> 156
    //   425: astore_1
    //   426: goto -19 -> 407
    //   429: astore 8
    //   431: goto -50 -> 381
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	agz
    //   0	434	1	paramContext	Context
    //   0	434	2	paramAttributeSet	AttributeSet
    //   0	434	3	paramInt1	int
    //   0	434	4	paramInt2	int
    //   64	89	5	m	int
    //   140	281	6	n	int
    //   81	291	7	localObject	Object
    //   376	1	7	localException1	Exception
    //   379	34	7	localamp1	amp
    //   1	403	8	localamp2	amp
    //   429	1	8	localException2	Exception
    //   30	286	9	localamp3	amp
    // Exception table:
    //   from	to	target	type
    //   104	116	376	java/lang/Exception
    //   104	116	402	finally
    //   120	138	425	finally
    //   120	138	429	java/lang/Exception
  }
  
  final int a(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int i3 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int i4 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int m = Math.max(0, getSelectedItemPosition());
    int i5 = Math.min(paramSpinnerAdapter.getCount(), m + 15);
    int n = Math.max(0, m - (15 - (i5 - m)));
    View localView = null;
    int i1 = 0;
    m = 0;
    if (n < i5)
    {
      int i2 = paramSpinnerAdapter.getItemViewType(n);
      if (i2 == m) {
        break label204;
      }
      localView = null;
      m = i2;
    }
    label204:
    for (;;)
    {
      localView = paramSpinnerAdapter.getView(n, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(i3, i4);
      i1 = Math.max(i1, localView.getMeasuredWidth());
      n += 1;
      break;
      if (paramDrawable != null)
      {
        paramDrawable.getPadding(d);
        return d.left + d.right + i1;
      }
      return i1;
    }
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    if (h != null) {
      h.a(paramColorStateList);
    }
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    if (h != null) {
      h.a(paramMode);
    }
  }
  
  public final ColorStateList c()
  {
    if (h != null) {
      return h.a();
    }
    return null;
  }
  
  public final PorterDuff.Mode d()
  {
    if (h != null) {
      return h.b();
    }
    return null;
  }
  
  protected final void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (h != null) {
      h.c();
    }
  }
  
  public final int getDropDownHorizontalOffset()
  {
    if (b != null) {
      return b.h;
    }
    if (e) {
      return super.getDropDownHorizontalOffset();
    }
    return 0;
  }
  
  public final int getDropDownVerticalOffset()
  {
    if (b != null)
    {
      localahc = b;
      if (j) {}
    }
    while (!e)
    {
      ahc localahc;
      return 0;
      return i;
    }
    return super.getDropDownVerticalOffset();
  }
  
  public final int getDropDownWidth()
  {
    if (b != null) {
      return c;
    }
    if (e) {
      return super.getDropDownWidth();
    }
    return 0;
  }
  
  public final Drawable getPopupBackground()
  {
    if (b != null) {
      return b.e.getBackground();
    }
    if (e) {
      return super.getPopupBackground();
    }
    return null;
  }
  
  public final Context getPopupContext()
  {
    if (b != null) {
      return i;
    }
    if (a) {
      return super.getPopupContext();
    }
    return null;
  }
  
  public final CharSequence getPrompt()
  {
    if (b != null) {
      return b.a;
    }
    return super.getPrompt();
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((b != null) && (b.e.isShowing())) {
      b.d();
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((b != null) && (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((j != null) && (j.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public final boolean performClick()
  {
    if (b != null)
    {
      if (!b.e.isShowing()) {
        b.b();
      }
      return true;
    }
    return super.performClick();
  }
  
  public final void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!l) {
      k = paramSpinnerAdapter;
    }
    do
    {
      return;
      super.setAdapter(paramSpinnerAdapter);
    } while (b == null);
    if (i == null) {}
    for (Context localContext = getContext();; localContext = i)
    {
      b.a(new ahb(paramSpinnerAdapter, localContext.getTheme()));
      return;
    }
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (h != null) {
      h.b(null);
    }
  }
  
  public final void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (h != null) {
      h.a(paramInt);
    }
  }
  
  public final void setDropDownHorizontalOffset(int paramInt)
  {
    if (b != null) {
      b.h = paramInt;
    }
    while (!e) {
      return;
    }
    super.setDropDownHorizontalOffset(paramInt);
  }
  
  public final void setDropDownVerticalOffset(int paramInt)
  {
    if (b != null)
    {
      localahc = b;
      i = paramInt;
      j = true;
    }
    while (!e)
    {
      ahc localahc;
      return;
    }
    super.setDropDownVerticalOffset(paramInt);
  }
  
  public final void setDropDownWidth(int paramInt)
  {
    if (b != null) {
      c = paramInt;
    }
    while (!e) {
      return;
    }
    super.setDropDownWidth(paramInt);
  }
  
  public final void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    if (b != null) {
      b.a(paramDrawable);
    }
    while (!e) {
      return;
    }
    super.setPopupBackgroundDrawable(paramDrawable);
  }
  
  public final void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(jr.a(getPopupContext(), paramInt));
  }
  
  public final void setPrompt(CharSequence paramCharSequence)
  {
    if (b != null)
    {
      b.a = paramCharSequence;
      return;
    }
    super.setPrompt(paramCharSequence);
  }
}

/* Location:
 * Qualified Name:     agz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */