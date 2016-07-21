import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class ahg
{
  private static final int[] b = { 16842804, 16843119, 16843117, 16843120, 16843118 };
  private static final int[] c = { aca.N };
  final TextView a;
  private amn d;
  private amn e;
  private amn f;
  private amn g;
  
  ahg(TextView paramTextView)
  {
    a = paramTextView;
  }
  
  static ahg a(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new ahh(paramTextView);
    }
    return new ahg(paramTextView);
  }
  
  protected static amn a(Context paramContext, agj paramagj, int paramInt)
  {
    paramContext = paramagj.b(paramContext, paramInt);
    if (paramContext != null)
    {
      paramagj = new amn();
      d = true;
      a = paramContext;
      return paramagj;
    }
    return null;
  }
  
  private final void a(boolean paramBoolean)
  {
    TextView localTextView = a;
    if (paramBoolean) {}
    for (acx localacx = new acx(a.getContext());; localacx = null)
    {
      localTextView.setTransformationMethod(localacx);
      return;
    }
  }
  
  void a()
  {
    if ((d != null) || (e != null) || (f != null) || (g != null))
    {
      Drawable[] arrayOfDrawable = a.getCompoundDrawables();
      a(arrayOfDrawable[0], d);
      a(arrayOfDrawable[1], e);
      a(arrayOfDrawable[2], f);
      a(arrayOfDrawable[3], g);
    }
  }
  
  final void a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramInt, c);
    if (paramContext.hasValue(0)) {
      a(paramContext.getBoolean(0, false));
    }
    paramContext.recycle();
  }
  
  final void a(Drawable paramDrawable, amn paramamn)
  {
    if ((paramDrawable != null) && (paramamn != null)) {
      agj.a(paramDrawable, paramamn, a.getDrawableState());
    }
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    int j = 1;
    Context localContext = a.getContext();
    Object localObject = agj.a();
    TypedArray localTypedArray = localContext.obtainStyledAttributes(paramAttributeSet, b, paramInt, 0);
    int i = localTypedArray.getResourceId(0, -1);
    if (localTypedArray.hasValue(1)) {
      d = a(localContext, (agj)localObject, localTypedArray.getResourceId(1, 0));
    }
    if (localTypedArray.hasValue(2)) {
      e = a(localContext, (agj)localObject, localTypedArray.getResourceId(2, 0));
    }
    if (localTypedArray.hasValue(3)) {
      f = a(localContext, (agj)localObject, localTypedArray.getResourceId(3, 0));
    }
    if (localTypedArray.hasValue(4)) {
      g = a(localContext, (agj)localObject, localTypedArray.getResourceId(4, 0));
    }
    localTypedArray.recycle();
    boolean bool;
    if (!(a.getTransformationMethod() instanceof PasswordTransformationMethod))
    {
      if (i == -1) {
        break label268;
      }
      localObject = localContext.obtainStyledAttributes(i, ack.cQ);
      if (!((TypedArray)localObject).hasValue(ack.cV)) {
        break label260;
      }
      bool = ((TypedArray)localObject).getBoolean(ack.cV, false);
      i = 1;
      ((TypedArray)localObject).recycle();
    }
    for (;;)
    {
      paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, c, paramInt, 0);
      if (paramAttributeSet.hasValue(0)) {
        bool = paramAttributeSet.getBoolean(0, false);
      }
      for (paramInt = j;; paramInt = i)
      {
        paramAttributeSet.recycle();
        if (paramInt != 0) {
          a(bool);
        }
        return;
      }
      label260:
      i = 0;
      bool = false;
      break;
      label268:
      i = 0;
      bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     ahg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */