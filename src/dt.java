import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class dt
  extends ds
{
  static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
  dz c;
  boolean d = true;
  private PorterDuffColorFilter e;
  private ColorFilter f;
  private boolean g;
  private Drawable.ConstantState h;
  private final float[] i = new float[9];
  private final Matrix j = new Matrix();
  private final Rect k = new Rect();
  
  dt()
  {
    c = new dz();
  }
  
  dt(dz paramdz)
  {
    c = paramdz;
    e = a(c, d);
  }
  
  static int a(int paramInt, float paramFloat)
  {
    return (int)(Color.alpha(paramInt) * paramFloat) << 24 | 0xFFFFFF & paramInt;
  }
  
  private final PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  public static dt a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = new dt();
      if (Build.VERSION.SDK_INT >= 21) {}
      for (paramResources = paramResources.getDrawable(paramInt, paramTheme);; paramResources = paramResources.getDrawable(paramInt))
      {
        b = paramResources;
        h = new ea(b.getConstantState());
        return (dt)localObject;
      }
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2) {
        throw new XmlPullParserException("No start tag found");
      }
    }
    catch (XmlPullParserException paramResources)
    {
      AttributeSet localAttributeSet;
      Log.e("VectorDrawableCompat", "parser error", paramResources);
      return null;
      paramResources = a(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
      return paramResources;
    }
    catch (IOException paramResources)
    {
      for (;;)
      {
        Log.e("VectorDrawableCompat", "parser error", paramResources);
      }
    }
  }
  
  public static dt a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    dt localdt = new dt();
    localdt.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return localdt;
  }
  
  private final void b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    dz localdz = c;
    dy localdy = b;
    int m = 1;
    Stack localStack = new Stack();
    localStack.push(c);
    int n = paramXmlPullParser.getEventType();
    if (n != 1)
    {
      Object localObject1;
      dw localdw;
      Object localObject2;
      Object localObject3;
      if (n == 2)
      {
        localObject1 = paramXmlPullParser.getName();
        localdw = (dw)localStack.peek();
        if ("path".equals(localObject1))
        {
          localObject2 = new dv();
          localObject3 = ds.a(paramResources, paramTheme, paramAttributeSet, dj.c);
          a = null;
          if (dr.a(paramXmlPullParser, "pathData"))
          {
            localObject1 = ((TypedArray)localObject3).getString(0);
            if (localObject1 != null) {
              o = ((String)localObject1);
            }
            localObject1 = ((TypedArray)localObject3).getString(2);
            if (localObject1 != null) {
              n = do.a((String)localObject1);
            }
            d = dr.a((TypedArray)localObject3, paramXmlPullParser, "fillColor", 1, d);
            g = dr.a((TypedArray)localObject3, paramXmlPullParser, "fillAlpha", 12, g);
            m = dr.a((TypedArray)localObject3, paramXmlPullParser, "strokeLineCap", 8);
            localObject1 = k;
          }
          switch (m)
          {
          default: 
            label252:
            k = ((Paint.Cap)localObject1);
            m = dr.a((TypedArray)localObject3, paramXmlPullParser, "strokeLineJoin", 9);
            localObject1 = l;
            switch (m)
            {
            default: 
              label308:
              l = ((Paint.Join)localObject1);
              m = dr.a((TypedArray)localObject3, paramXmlPullParser, "strokeMiterLimit", 10, m);
              b = dr.a((TypedArray)localObject3, paramXmlPullParser, "strokeColor", 3, b);
              e = dr.a((TypedArray)localObject3, paramXmlPullParser, "strokeAlpha", 11, e);
              c = dr.a((TypedArray)localObject3, paramXmlPullParser, "strokeWidth", 4, c);
              i = dr.a((TypedArray)localObject3, paramXmlPullParser, "trimPathEnd", 6, i);
              j = dr.a((TypedArray)localObject3, paramXmlPullParser, "trimPathOffset", 7, j);
              h = dr.a((TypedArray)localObject3, paramXmlPullParser, "trimPathStart", 5, h);
              ((TypedArray)localObject3).recycle();
              b.add(localObject2);
              if (o != null) {
                j.put(o, localObject2);
              }
              m = 0;
              a |= p;
            }
            break;
          }
        }
      }
      for (;;)
      {
        n = paramXmlPullParser.next();
        break;
        localObject1 = Paint.Cap.BUTT;
        break label252;
        localObject1 = Paint.Cap.ROUND;
        break label252;
        localObject1 = Paint.Cap.SQUARE;
        break label252;
        localObject1 = Paint.Join.MITER;
        break label308;
        localObject1 = Paint.Join.ROUND;
        break label308;
        localObject1 = Paint.Join.BEVEL;
        break label308;
        if ("clip-path".equals(localObject1))
        {
          localObject1 = new du();
          if (dr.a(paramXmlPullParser, "pathData"))
          {
            localObject2 = ds.a(paramResources, paramTheme, paramAttributeSet, dj.d);
            localObject3 = ((TypedArray)localObject2).getString(0);
            if (localObject3 != null) {
              o = ((String)localObject3);
            }
            localObject3 = ((TypedArray)localObject2).getString(1);
            if (localObject3 != null) {
              n = do.a((String)localObject3);
            }
            ((TypedArray)localObject2).recycle();
          }
          b.add(localObject1);
          if (o != null) {
            j.put(o, localObject1);
          }
          a |= p;
        }
        else
        {
          if ("group".equals(localObject1))
          {
            localObject1 = new dw();
            localObject2 = ds.a(paramResources, paramTheme, paramAttributeSet, dj.b);
            l = null;
            c = dr.a((TypedArray)localObject2, paramXmlPullParser, "rotation", 5, c);
            d = ((TypedArray)localObject2).getFloat(1, d);
            e = ((TypedArray)localObject2).getFloat(2, e);
            f = dr.a((TypedArray)localObject2, paramXmlPullParser, "scaleX", 3, f);
            g = dr.a((TypedArray)localObject2, paramXmlPullParser, "scaleY", 4, g);
            h = dr.a((TypedArray)localObject2, paramXmlPullParser, "translateX", 6, h);
            i = dr.a((TypedArray)localObject2, paramXmlPullParser, "translateY", 7, i);
            localObject3 = ((TypedArray)localObject2).getString(0);
            if (localObject3 != null) {
              m = ((String)localObject3);
            }
            j.reset();
            j.postTranslate(-d, -e);
            j.postScale(f, g);
            j.postRotate(c, 0.0F, 0.0F);
            j.postTranslate(h + d, i + e);
            ((TypedArray)localObject2).recycle();
            b.add(localObject1);
            localStack.push(localObject1);
            if (m != null) {
              j.put(m, localObject1);
            }
            a |= k;
          }
          continue;
          if ((n == 3) && ("group".equals(paramXmlPullParser.getName()))) {
            localStack.pop();
          }
        }
      }
    }
    if (m != 0)
    {
      paramResources = new StringBuffer();
      if (paramResources.length() > 0) {
        paramResources.append(" or ");
      }
      paramResources.append("path");
      throw new XmlPullParserException("no " + paramResources + " defined");
    }
  }
  
  public final boolean canApplyTheme()
  {
    if (b != null) {
      kn.d(b);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    float f2 = 1.0F;
    if (b != null) {
      b.draw(paramCanvas);
    }
    do
    {
      return;
      copyBounds(k);
    } while ((k.width() <= 0) || (k.height() <= 0));
    Object localObject;
    float f3;
    float f1;
    if (f == null)
    {
      localObject = e;
      paramCanvas.getMatrix(j);
      j.getValues(i);
      f3 = Math.abs(i[0]);
      f1 = Math.abs(i[4]);
      float f4 = Math.abs(i[1]);
      float f5 = Math.abs(i[3]);
      if ((f4 == 0.0F) && (f5 == 0.0F)) {
        break label617;
      }
      f1 = 1.0F;
    }
    for (;;)
    {
      int n = (int)(f2 * k.width());
      int m = (int)(f1 * k.height());
      int i1 = Math.min(2048, n);
      int i2 = Math.min(2048, m);
      if ((i1 <= 0) || (i2 <= 0)) {
        break;
      }
      n = paramCanvas.save();
      paramCanvas.translate(k.left, k.top);
      k.offsetTo(0, 0);
      dz localdz = c;
      if (f != null)
      {
        if ((i1 != f.getWidth()) || (i2 != f.getHeight())) {
          break label387;
        }
        m = 1;
        label271:
        if (m != 0) {}
      }
      else
      {
        f = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
        k = true;
      }
      label315:
      Rect localRect;
      if (!d)
      {
        c.a(i1, i2);
        localdz = c;
        localRect = k;
        if (b.h >= 255) {
          break label545;
        }
        m = 1;
        label344:
        if ((m != 0) || (localObject != null)) {
          break label551;
        }
      }
      for (localObject = null;; localObject = l)
      {
        paramCanvas.drawBitmap(f, null, localRect, (Paint)localObject);
        paramCanvas.restoreToCount(n);
        return;
        localObject = f;
        break;
        label387:
        m = 0;
        break label271;
        localdz = c;
        if ((!k) && (g == c) && (h == d) && (j == e) && (i == b.h)) {}
        for (m = 1;; m = 0)
        {
          if (m != 0) {
            break label543;
          }
          c.a(i1, i2);
          localdz = c;
          g = c;
          h = d;
          i = b.h;
          j = e;
          k = false;
          break;
        }
        label543:
        break label315;
        label545:
        m = 0;
        break label344;
        label551:
        if (l == null)
        {
          l = new Paint();
          l.setFilterBitmap(true);
        }
        l.setAlpha(b.h);
        l.setColorFilter((ColorFilter)localObject);
      }
      label617:
      f2 = f3;
    }
  }
  
  public final int getAlpha()
  {
    if (b != null) {
      return kn.c(b);
    }
    return c.b.h;
  }
  
  public final int getChangingConfigurations()
  {
    if (b != null) {
      return b.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | c.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (b != null) {
      return new ea(b.getConstantState());
    }
    c.a = getChangingConfigurations();
    return c;
  }
  
  public final int getIntrinsicHeight()
  {
    if (b != null) {
      return b.getIntrinsicHeight();
    }
    return (int)c.b.e;
  }
  
  public final int getIntrinsicWidth()
  {
    if (b != null) {
      return b.getIntrinsicWidth();
    }
    return (int)c.b.d;
  }
  
  public final int getOpacity()
  {
    if (b != null) {
      return b.getOpacity();
    }
    return -3;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    if (b != null)
    {
      b.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (b != null)
    {
      kn.a(b, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    dz localdz1 = c;
    b = new dy();
    TypedArray localTypedArray = a(paramResources, paramTheme, paramAttributeSet, dj.a);
    dz localdz2 = c;
    dy localdy = b;
    int m = dr.a(localTypedArray, paramXmlPullParser, "tintMode", 6);
    PorterDuff.Mode localMode = PorterDuff.Mode.SRC_IN;
    Object localObject = localMode;
    boolean bool;
    switch (m)
    {
    default: 
      localObject = localMode;
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
      d = ((PorterDuff.Mode)localObject);
      localObject = localTypedArray.getColorStateList(1);
      if (localObject != null) {
        c = ((ColorStateList)localObject);
      }
      bool = e;
      if (dr.a(paramXmlPullParser, "autoMirrored")) {
        break;
      }
    }
    for (;;)
    {
      e = bool;
      f = dr.a(localTypedArray, paramXmlPullParser, "viewportWidth", 7, f);
      g = dr.a(localTypedArray, paramXmlPullParser, "viewportHeight", 8, g);
      if (f > 0.0F) {
        break label356;
      }
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
      localObject = PorterDuff.Mode.SRC_OVER;
      break;
      localObject = PorterDuff.Mode.SRC_IN;
      break;
      localObject = PorterDuff.Mode.SRC_ATOP;
      break;
      localObject = PorterDuff.Mode.MULTIPLY;
      break;
      localObject = PorterDuff.Mode.SCREEN;
      break;
      localObject = PorterDuff.Mode.ADD;
      break;
      bool = localTypedArray.getBoolean(5, bool);
    }
    label356:
    if (g <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }
    d = localTypedArray.getDimension(3, d);
    e = localTypedArray.getDimension(2, e);
    if (d <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    }
    if (e <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    }
    h = ((int)(dr.a(localTypedArray, paramXmlPullParser, "alpha", 4, h / 255.0F) * 255.0F));
    localObject = localTypedArray.getString(0);
    if (localObject != null)
    {
      i = ((String)localObject);
      j.put(localObject, localdy);
    }
    localTypedArray.recycle();
    a = getChangingConfigurations();
    k = true;
    b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    e = a(c, d);
  }
  
  public final void invalidateSelf()
  {
    if (b != null)
    {
      b.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public final boolean isStateful()
  {
    if (b != null) {
      return b.isStateful();
    }
    return (super.isStateful()) || ((c != null) && (c.c != null) && (c.c.isStateful()));
  }
  
  public final Drawable mutate()
  {
    if (b != null) {
      b.mutate();
    }
    while ((g) || (super.mutate() != this)) {
      return this;
    }
    c = new dz(c);
    g = true;
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (b != null) {
      b.setBounds(paramRect);
    }
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (b != null) {
      return b.setState(paramArrayOfInt);
    }
    paramArrayOfInt = c;
    if ((c != null) && (d != null))
    {
      e = a(c, d);
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (b != null)
    {
      b.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (b != null) {
      b.setAlpha(paramInt);
    }
    while (c.b.h == paramInt) {
      return;
    }
    c.b.h = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (b != null)
    {
      b.setColorFilter(paramColorFilter);
      return;
    }
    f = paramColorFilter;
    invalidateSelf();
  }
  
  public final void setTint(int paramInt)
  {
    if (b != null)
    {
      kn.a(b, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (b != null) {
      kn.a(b, paramColorStateList);
    }
    dz localdz;
    do
    {
      return;
      localdz = c;
    } while (c == paramColorStateList);
    c = paramColorStateList;
    e = a(paramColorStateList, d);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (b != null) {
      kn.a(b, paramMode);
    }
    dz localdz;
    do
    {
      return;
      localdz = c;
    } while (d == paramMode);
    d = paramMode;
    e = a(c, paramMode);
    invalidateSelf();
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (b != null) {
      return b.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void unscheduleSelf(Runnable paramRunnable)
  {
    if (b != null)
    {
      b.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     dt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */