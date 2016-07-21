import android.content.res.TypedArray;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class ajc
  extends ViewGroup.MarginLayoutParams
{
  private static final ajb c;
  private static final int d;
  private static final int e = acu.U;
  private static final int f = acu.W;
  private static final int g = acu.Y;
  private static final int h = acu.X;
  private static final int i = acu.V;
  private static final int j = acu.Z;
  private static final int k = acu.aa;
  private static final int l = acu.ab;
  private static final int m = acu.ad;
  private static final int n = acu.ae;
  private static final int o = acu.af;
  private static final int p = acu.ac;
  public ajf a = ajf.a;
  public ajf b = ajf.a;
  
  static
  {
    ajb localajb = new ajb(Integer.MIN_VALUE, -2147483647);
    c = localajb;
    d = localajb.a();
  }
  
  public ajc()
  {
    this(ajf.a, ajf.a, (byte)0);
  }
  
  private ajc(ajf paramajf1, ajf paramajf2)
  {
    super(-2, -2);
    setMargins(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    a = paramajf1;
    b = paramajf2;
  }
  
  private ajc(ajf paramajf1, ajf paramajf2, byte paramByte)
  {
    this(paramajf1, paramajf2);
  }
  
  /* Error */
  public ajc(android.content.Context paramContext, android.util.AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 124	android/view/ViewGroup$MarginLayoutParams:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: getstatic 107	ajf:a	Lajf;
    //   10: putfield 113	ajc:a	Lajf;
    //   13: aload_0
    //   14: getstatic 107	ajf:a	Lajf;
    //   17: putfield 115	ajc:b	Lajf;
    //   20: aload_1
    //   21: aload_2
    //   22: getstatic 128	acu:T	[I
    //   25: invokevirtual 134	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   28: astore 7
    //   30: aload 7
    //   32: getstatic 47	ajc:e	I
    //   35: ldc 28
    //   37: invokevirtual 140	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   40: istore 4
    //   42: aload_0
    //   43: aload 7
    //   45: getstatic 52	ajc:f	I
    //   48: iload 4
    //   50: invokevirtual 140	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   53: putfield 143	ajc:leftMargin	I
    //   56: aload_0
    //   57: aload 7
    //   59: getstatic 57	ajc:g	I
    //   62: iload 4
    //   64: invokevirtual 140	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   67: putfield 146	ajc:topMargin	I
    //   70: aload_0
    //   71: aload 7
    //   73: getstatic 62	ajc:h	I
    //   76: iload 4
    //   78: invokevirtual 140	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   81: putfield 149	ajc:rightMargin	I
    //   84: aload_0
    //   85: aload 7
    //   87: getstatic 67	ajc:i	I
    //   90: iload 4
    //   92: invokevirtual 140	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   95: putfield 152	ajc:bottomMargin	I
    //   98: aload 7
    //   100: invokevirtual 155	android/content/res/TypedArray:recycle	()V
    //   103: aload_1
    //   104: aload_2
    //   105: getstatic 128	acu:T	[I
    //   108: invokevirtual 134	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   111: astore_1
    //   112: aload_1
    //   113: getstatic 102	ajc:p	I
    //   116: iconst_0
    //   117: invokevirtual 158	android/content/res/TypedArray:getInt	(II)I
    //   120: istore 4
    //   122: aload_1
    //   123: getstatic 72	ajc:j	I
    //   126: ldc 28
    //   128: invokevirtual 158	android/content/res/TypedArray:getInt	(II)I
    //   131: istore 5
    //   133: aload_1
    //   134: getstatic 77	ajc:k	I
    //   137: getstatic 40	ajc:d	I
    //   140: invokevirtual 158	android/content/res/TypedArray:getInt	(II)I
    //   143: istore 6
    //   145: aload_1
    //   146: getstatic 82	ajc:l	I
    //   149: fconst_0
    //   150: invokevirtual 162	android/content/res/TypedArray:getFloat	(IF)F
    //   153: fstore_3
    //   154: aload_0
    //   155: iload 5
    //   157: iload 6
    //   159: iload 4
    //   161: iconst_1
    //   162: invokestatic 167	android/support/v7/widget/GridLayout:a	(IZ)Laiv;
    //   165: fload_3
    //   166: invokestatic 170	android/support/v7/widget/GridLayout:a	(IILaiv;F)Lajf;
    //   169: putfield 115	ajc:b	Lajf;
    //   172: aload_1
    //   173: getstatic 87	ajc:m	I
    //   176: ldc 28
    //   178: invokevirtual 158	android/content/res/TypedArray:getInt	(II)I
    //   181: istore 5
    //   183: aload_1
    //   184: getstatic 92	ajc:n	I
    //   187: getstatic 40	ajc:d	I
    //   190: invokevirtual 158	android/content/res/TypedArray:getInt	(II)I
    //   193: istore 6
    //   195: aload_1
    //   196: getstatic 97	ajc:o	I
    //   199: fconst_0
    //   200: invokevirtual 162	android/content/res/TypedArray:getFloat	(IF)F
    //   203: fstore_3
    //   204: aload_0
    //   205: iload 5
    //   207: iload 6
    //   209: iload 4
    //   211: iconst_0
    //   212: invokestatic 167	android/support/v7/widget/GridLayout:a	(IZ)Laiv;
    //   215: fload_3
    //   216: invokestatic 170	android/support/v7/widget/GridLayout:a	(IILaiv;F)Lajf;
    //   219: putfield 113	ajc:a	Lajf;
    //   222: aload_1
    //   223: invokevirtual 155	android/content/res/TypedArray:recycle	()V
    //   226: return
    //   227: astore_1
    //   228: aload 7
    //   230: invokevirtual 155	android/content/res/TypedArray:recycle	()V
    //   233: aload_1
    //   234: athrow
    //   235: astore_2
    //   236: aload_1
    //   237: invokevirtual 155	android/content/res/TypedArray:recycle	()V
    //   240: aload_2
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	ajc
    //   0	242	1	paramContext	android.content.Context
    //   0	242	2	paramAttributeSet	android.util.AttributeSet
    //   153	63	3	f1	float
    //   40	170	4	i1	int
    //   131	75	5	i2	int
    //   143	65	6	i3	int
    //   28	201	7	localTypedArray	TypedArray
    // Exception table:
    //   from	to	target	type
    //   30	98	227	finally
    //   112	222	235	finally
  }
  
  public ajc(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ajc)paramObject;
      if (!b.equals(b)) {
        return false;
      }
    } while (a.equals(a));
    return false;
  }
  
  public final int hashCode()
  {
    return a.hashCode() * 31 + b.hashCode();
  }
  
  protected final void setBaseAttributes(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    width = paramTypedArray.getLayoutDimension(paramInt1, -2);
    height = paramTypedArray.getLayoutDimension(paramInt2, -2);
  }
}

/* Location:
 * Qualified Name:     ajc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */