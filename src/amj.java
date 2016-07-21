import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;

final class amj
{
  static final int[] a = { -16842910 };
  static final int[] b = { 16842908 };
  static final int[] c = { 16843518 };
  static final int[] d = { 16842919 };
  static final int[] e = { 16842912 };
  static final int[] f = { 16842913 };
  static final int[] g = { -16842919, -16842908 };
  static final int[] h = new int[0];
  private static final ThreadLocal<TypedValue> i = new ThreadLocal();
  private static final int[] j = new int[1];
  
  public static int a(Context paramContext, int paramInt)
  {
    j[0] = paramInt;
    paramContext = paramContext.obtainStyledAttributes(null, j);
    try
    {
      paramInt = paramContext.getColor(0, 0);
      return paramInt;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  static int a(Context paramContext, int paramInt, float paramFloat)
  {
    paramInt = a(paramContext, paramInt);
    return km.b(paramInt, Math.round(Color.alpha(paramInt) * paramFloat));
  }
  
  public static ColorStateList b(Context paramContext, int paramInt)
  {
    j[0] = paramInt;
    paramContext = paramContext.obtainStyledAttributes(null, j);
    try
    {
      ColorStateList localColorStateList = paramContext.getColorStateList(0);
      return localColorStateList;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public static int c(Context paramContext, int paramInt)
  {
    Object localObject = b(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {
      return ((ColorStateList)localObject).getColorForState(a, ((ColorStateList)localObject).getDefaultColor());
    }
    TypedValue localTypedValue = (TypedValue)i.get();
    localObject = localTypedValue;
    if (localTypedValue == null)
    {
      localObject = new TypedValue();
      i.set(localObject);
    }
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    return a(paramContext, paramInt, ((TypedValue)localObject).getFloat());
  }
}

/* Location:
 * Qualified Name:     amj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */