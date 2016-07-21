import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import org.xmlpull.v1.XmlPullParser;

public final class adg
  extends MenuInflater
{
  static final Class<?>[] a;
  static final Class<?>[] b;
  final Object[] c;
  final Object[] d;
  Context e;
  Object f;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    a = arrayOfClass;
    b = arrayOfClass;
  }
  
  public adg(Context paramContext)
  {
    super(paramContext);
    e = paramContext;
    c = new Object[] { paramContext };
    d = c;
  }
  
  private final void a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
  {
    adi localadi = new adi(this, paramMenu);
    int i = paramXmlPullParser.getEventType();
    int j = 0;
    paramMenu = null;
    Object localObject;
    int k;
    if (i == 2)
    {
      localObject = paramXmlPullParser.getName();
      if (((String)localObject).equals("menu"))
      {
        k = paramXmlPullParser.next();
        label56:
        i = 0;
        label59:
        if (i != 0) {
          return;
        }
      }
    }
    switch (k)
    {
    default: 
    case 2: 
    case 3: 
      for (;;)
      {
        k = paramXmlPullParser.next();
        break label59;
        throw new RuntimeException("Expecting menu, got " + (String)localObject);
        k = paramXmlPullParser.next();
        i = k;
        if (k != 1) {
          break;
        }
        break label56;
        if (j == 0)
        {
          localObject = paramXmlPullParser.getName();
          if (((String)localObject).equals("group"))
          {
            localObject = z.e.obtainStyledAttributes(paramAttributeSet, ack.bn);
            b = ((TypedArray)localObject).getResourceId(ack.bq, 0);
            c = ((TypedArray)localObject).getInt(ack.br, 0);
            d = ((TypedArray)localObject).getInt(ack.bs, 0);
            e = ((TypedArray)localObject).getInt(ack.bo, 0);
            f = ((TypedArray)localObject).getBoolean(ack.bt, true);
            g = ((TypedArray)localObject).getBoolean(ack.bp, true);
            ((TypedArray)localObject).recycle();
          }
          else
          {
            if (((String)localObject).equals("item"))
            {
              localObject = z.e.obtainStyledAttributes(paramAttributeSet, ack.bu);
              i = ((TypedArray)localObject).getResourceId(ack.bD, 0);
              j = (((TypedArray)localObject).getInt(ack.bE, c) & 0xFFFF0000 | ((TypedArray)localObject).getInt(ack.bH, d) & 0xFFFF);
              k = ((TypedArray)localObject).getText(ack.bI);
              l = ((TypedArray)localObject).getText(ack.bJ);
              m = ((TypedArray)localObject).getResourceId(ack.bC, 0);
              n = adi.a(((TypedArray)localObject).getString(ack.by));
              o = adi.a(((TypedArray)localObject).getString(ack.bF));
              if (((TypedArray)localObject).hasValue(ack.bz)) {
                if (((TypedArray)localObject).getBoolean(ack.bz, false))
                {
                  k = 1;
                  label458:
                  p = k;
                  label465:
                  q = ((TypedArray)localObject).getBoolean(ack.bA, false);
                  r = ((TypedArray)localObject).getBoolean(ack.bK, f);
                  s = ((TypedArray)localObject).getBoolean(ack.bB, g);
                  t = ((TypedArray)localObject).getInt(ack.bL, -1);
                  x = ((TypedArray)localObject).getString(ack.bG);
                  u = ((TypedArray)localObject).getResourceId(ack.bv, 0);
                  v = ((TypedArray)localObject).getString(ack.bx);
                  w = ((TypedArray)localObject).getString(ack.bw);
                  if (w == null) {
                    break label676;
                  }
                  k = 1;
                  label593:
                  if ((k == 0) || (u != 0) || (v != null)) {
                    break label682;
                  }
                }
              }
              for (y = ((oy)localadi.a(w, b, z.d));; y = null)
              {
                ((TypedArray)localObject).recycle();
                h = false;
                break;
                k = 0;
                break label458;
                p = e;
                break label465;
                label676:
                k = 0;
                break label593;
                label682:
                if (k != 0) {
                  Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
              }
            }
            if (((String)localObject).equals("menu"))
            {
              a(paramXmlPullParser, paramAttributeSet, localadi.b());
            }
            else
            {
              j = 1;
              paramMenu = (Menu)localObject;
              continue;
              localObject = paramXmlPullParser.getName();
              if ((j != 0) && (((String)localObject).equals(paramMenu)))
              {
                j = 0;
                paramMenu = null;
              }
              else if (((String)localObject).equals("group"))
              {
                localadi.a();
              }
              else if (((String)localObject).equals("item"))
              {
                if (!h) {
                  if ((y != null) && (y.e()))
                  {
                    localadi.b();
                  }
                  else
                  {
                    h = true;
                    localadi.a(a.add(b, i, j, k));
                  }
                }
              }
              else if (((String)localObject).equals("menu"))
              {
                i = 1;
              }
            }
          }
        }
      }
    }
    throw new RuntimeException("Unexpected end of document");
  }
  
  final Object a(Object paramObject)
  {
    for (;;)
    {
      if ((paramObject instanceof Activity)) {}
      while (!(paramObject instanceof ContextWrapper)) {
        return paramObject;
      }
      paramObject = ((ContextWrapper)paramObject).getBaseContext();
    }
  }
  
  /* Error */
  public final void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 333
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 335	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: aload_0
    //   23: getfield 32	adg:e	Landroid/content/Context;
    //   26: invokevirtual 339	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 345	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   33: astore 6
    //   35: aload 6
    //   37: astore 4
    //   39: aload 6
    //   41: astore_3
    //   42: aload 6
    //   44: astore 5
    //   46: aload_0
    //   47: aload 6
    //   49: aload 6
    //   51: invokestatic 351	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   54: aload_2
    //   55: invokespecial 297	adg:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   58: aload 6
    //   60: ifnull -47 -> 13
    //   63: aload 6
    //   65: invokeinterface 356 1 0
    //   70: return
    //   71: astore_2
    //   72: aload 4
    //   74: astore_3
    //   75: new 358	android/view/InflateException
    //   78: dup
    //   79: ldc_w 360
    //   82: aload_2
    //   83: invokespecial 363	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: astore_2
    //   88: aload_3
    //   89: ifnull +9 -> 98
    //   92: aload_3
    //   93: invokeinterface 356 1 0
    //   98: aload_2
    //   99: athrow
    //   100: astore_2
    //   101: aload 5
    //   103: astore_3
    //   104: new 358	android/view/InflateException
    //   107: dup
    //   108: ldc_w 360
    //   111: aload_2
    //   112: invokespecial 363	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	adg
    //   0	116	1	paramInt	int
    //   0	116	2	paramMenu	Menu
    //   15	89	3	localObject1	Object
    //   20	53	4	localObject2	Object
    //   17	85	5	localObject3	Object
    //   33	31	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   22	35	71	org/xmlpull/v1/XmlPullParserException
    //   46	58	71	org/xmlpull/v1/XmlPullParserException
    //   22	35	87	finally
    //   46	58	87	finally
    //   75	87	87	finally
    //   104	116	87	finally
    //   22	35	100	java/io/IOException
    //   46	58	100	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     adg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */