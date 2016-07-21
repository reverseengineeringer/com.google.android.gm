import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public final class dk
  extends ds
  implements Animatable
{
  final Drawable.Callback a = new dl(this);
  private dm c;
  private Context d;
  private ArgbEvaluator e = null;
  
  dk()
  {
    this(null, (byte)0);
  }
  
  public dk(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private dk(Context paramContext, byte paramByte)
  {
    d = paramContext;
    c = new dm(null, a, null);
  }
  
  private final void a(Animator paramAnimator)
  {
    Object localObject;
    if ((paramAnimator instanceof AnimatorSet))
    {
      localObject = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          a((Animator)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      localObject = paramAnimator.getPropertyName();
      if (("fillColor".equals(localObject)) || ("strokeColor".equals(localObject)))
      {
        if (e == null) {
          e = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(e);
      }
    }
  }
  
  private final boolean a()
  {
    ArrayList localArrayList = c.c;
    if (localArrayList == null) {
      return false;
    }
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((Animator)localArrayList.get(i)).isRunning()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final void applyTheme(Resources.Theme paramTheme)
  {
    if (b != null) {
      kn.a(b, paramTheme);
    }
  }
  
  public final boolean canApplyTheme()
  {
    if (b != null) {
      return kn.d(b);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (b != null) {
      b.draw(paramCanvas);
    }
    do
    {
      return;
      c.b.draw(paramCanvas);
    } while (!a());
    invalidateSelf();
  }
  
  public final int getAlpha()
  {
    if (b != null) {
      return kn.c(b);
    }
    return c.b.getAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (b != null) {
      return b.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | c.a;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (b != null) {
      return new dn(b.getConstantState());
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    if (b != null) {
      return b.getIntrinsicHeight();
    }
    return c.b.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth()
  {
    if (b != null) {
      return b.getIntrinsicWidth();
    }
    return c.b.getIntrinsicWidth();
  }
  
  public final int getOpacity()
  {
    if (b != null) {
      return b.getOpacity();
    }
    return c.b.getOpacity();
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (b != null)
    {
      kn.a(b, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    int i = paramXmlPullParser.getEventType();
    label28:
    Object localObject1;
    label77:
    Object localObject2;
    if (i != 1) {
      if (i == 2)
      {
        localObject1 = paramXmlPullParser.getName();
        if (!"animated-vector".equals(localObject1)) {
          break label177;
        }
        localObject1 = dj.e;
        if (paramTheme != null) {
          break label162;
        }
        localObject1 = paramResources.obtainAttributes(paramAttributeSet, (int[])localObject1);
        i = ((TypedArray)localObject1).getResourceId(0, 0);
        if (i != 0)
        {
          localObject2 = dt.a(paramResources, i, paramTheme);
          d = false;
          ((dt)localObject2).setCallback(a);
          if (c.b != null) {
            c.b.setCallback(null);
          }
          c.b = ((dt)localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
    }
    for (;;)
    {
      i = paramXmlPullParser.next();
      break label28;
      break;
      label162:
      localObject1 = paramTheme.obtainStyledAttributes(paramAttributeSet, (int[])localObject1, 0, 0);
      break label77;
      label177:
      if ("target".equals(localObject1))
      {
        localObject1 = paramResources.obtainAttributes(paramAttributeSet, dj.f);
        localObject2 = ((TypedArray)localObject1).getString(0);
        i = ((TypedArray)localObject1).getResourceId(1, 0);
        if (i != 0)
        {
          if (d == null) {
            break label351;
          }
          Animator localAnimator = AnimatorInflater.loadAnimator(d, i);
          localAnimator.setTarget(c.b.c.b.j.get(localObject2));
          if (Build.VERSION.SDK_INT < 21) {
            a(localAnimator);
          }
          if (c.c == null)
          {
            c.c = new ArrayList();
            c.d = new ns();
          }
          c.c.add(localAnimator);
          c.d.put(localAnimator, localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
    }
    label351:
    throw new IllegalStateException("Context can't be null when inflating animators");
  }
  
  public final boolean isRunning()
  {
    if (b != null) {
      return ((AnimatedVectorDrawable)b).isRunning();
    }
    ArrayList localArrayList = c.c;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((Animator)localArrayList.get(i)).isRunning()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final boolean isStateful()
  {
    if (b != null) {
      return b.isStateful();
    }
    return c.b.isStateful();
  }
  
  public final Drawable mutate()
  {
    if (b != null)
    {
      b.mutate();
      return this;
    }
    throw new IllegalStateException("Mutate() is not supported for older platform");
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (b != null)
    {
      b.setBounds(paramRect);
      return;
    }
    c.b.setBounds(paramRect);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    if (b != null) {
      return b.setLevel(paramInt);
    }
    return c.b.setLevel(paramInt);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (b != null) {
      return b.setState(paramArrayOfInt);
    }
    return c.b.setState(paramArrayOfInt);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (b != null)
    {
      b.setAlpha(paramInt);
      return;
    }
    c.b.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (b != null)
    {
      b.setColorFilter(paramColorFilter);
      return;
    }
    c.b.setColorFilter(paramColorFilter);
  }
  
  public final void setTint(int paramInt)
  {
    if (b != null)
    {
      kn.a(b, paramInt);
      return;
    }
    c.b.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (b != null)
    {
      kn.a(b, paramColorStateList);
      return;
    }
    c.b.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (b != null)
    {
      kn.a(b, paramMode);
      return;
    }
    c.b.setTintMode(paramMode);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (b != null) {
      return b.setVisible(paramBoolean1, paramBoolean2);
    }
    c.b.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void start()
  {
    if (b != null) {
      ((AnimatedVectorDrawable)b).start();
    }
    while (a()) {
      return;
    }
    ArrayList localArrayList = c.c;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((Animator)localArrayList.get(i)).start();
      i += 1;
    }
    invalidateSelf();
  }
  
  public final void stop()
  {
    if (b != null) {
      ((AnimatedVectorDrawable)b).stop();
    }
    for (;;)
    {
      return;
      ArrayList localArrayList = c.c;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((Animator)localArrayList.get(i)).end();
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     dk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */