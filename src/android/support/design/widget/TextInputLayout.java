package android.support.design.widget;

import aa;
import agj;
import aij;
import am;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.widget.Space;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import cf;
import cg;
import ch;
import ci;
import ck;
import cl;
import cm;
import cq;
import d;
import dd;
import h;
import i;
import j;
import jr;
import kx;
import p;
import rg;
import tg;

public class TextInputLayout
  extends LinearLayout
{
  public EditText a;
  boolean b;
  CharSequence c;
  public TextView d;
  public boolean e;
  public final aa f = new aa(this);
  private Paint g;
  private LinearLayout h;
  private int i;
  private boolean j;
  private int k;
  private boolean l;
  private CharSequence m;
  private TextView n;
  private int o;
  private int p;
  private int q;
  private boolean r;
  private ColorStateList s;
  private ColorStateList t;
  private boolean u;
  private cm v;
  private boolean w;
  
  public TextInputLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    cl.a(paramContext);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    Object localObject = f;
    y = p.b;
    ((aa)localObject).b();
    localObject = f;
    x = new AccelerateInterpolator();
    ((aa)localObject).b();
    f.b(8388659);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, j.bl, paramInt, i.d);
    b = paramContext.getBoolean(j.bv, true);
    a(paramContext.getText(j.bm));
    u = paramContext.getBoolean(j.bu, true);
    if (paramContext.hasValue(j.bn))
    {
      paramAttributeSet = paramContext.getColorStateList(j.bn);
      t = paramAttributeSet;
      s = paramAttributeSet;
    }
    if (paramContext.getResourceId(j.bw, -1) != -1)
    {
      paramInt = paramContext.getResourceId(j.bw, 0);
      paramAttributeSet = f;
      localObject = a.getContext().obtainStyledAttributes(paramInt, j.be);
      if (((TypedArray)localObject).hasValue(j.bj)) {
        j = ((TypedArray)localObject).getColor(j.bj, j);
      }
      if (((TypedArray)localObject).hasValue(j.bk)) {
        h = ((TypedArray)localObject).getDimensionPixelSize(j.bk, (int)h);
      }
      C = ((TypedArray)localObject).getInt(j.bf, 0);
      A = ((TypedArray)localObject).getFloat(j.bg, 0.0F);
      B = ((TypedArray)localObject).getFloat(j.bh, 0.0F);
      z = ((TypedArray)localObject).getFloat(j.bi, 0.0F);
      ((TypedArray)localObject).recycle();
      if (Build.VERSION.SDK_INT >= 16) {
        m = paramAttributeSet.c(paramInt);
      }
      paramAttributeSet.b();
      t = ColorStateList.valueOf(f.j);
      if (a != null)
      {
        a(false);
        paramAttributeSet = a(a.getLayoutParams());
        a.setLayoutParams(paramAttributeSet);
        a.requestLayout();
      }
    }
    k = paramContext.getResourceId(j.bt, 0);
    boolean bool1 = paramContext.getBoolean(j.bs, false);
    boolean bool2 = paramContext.getBoolean(j.bo, false);
    paramInt = paramContext.getInt(j.bp, -1);
    if (o != paramInt)
    {
      if (paramInt <= 0) {
        break label610;
      }
      o = paramInt;
      if (e)
      {
        if (a != null) {
          break label618;
        }
        paramInt = 0;
        a(paramInt);
      }
    }
    p = paramContext.getResourceId(j.br, 0);
    q = paramContext.getResourceId(j.bq, 0);
    paramContext.recycle();
    b(bool1);
    if (e != bool2)
    {
      if (!bool2) {
        break label688;
      }
      n = new TextView(getContext());
      n.setMaxLines(1);
    }
    for (;;)
    {
      try
      {
        n.setTextAppearance(getContext(), p);
        a(n, -1);
        if (a == null)
        {
          a(0);
          e = bool2;
          if (rg.d(this) == 0) {
            rg.c(this, 1);
          }
          rg.a(this, new ck(this));
          return;
          label610:
          o = -1;
          break;
          label618:
          paramInt = a.getText().length();
        }
      }
      catch (Exception paramContext)
      {
        n.setTextAppearance(getContext(), i.a);
        n.setTextColor(jr.b(getContext(), d.h));
        continue;
        a(a.getText().length());
        continue;
      }
      label688:
      a(n);
      n = null;
    }
  }
  
  private final LinearLayout.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    Paint localPaint;
    if ((paramLayoutParams instanceof LinearLayout.LayoutParams))
    {
      paramLayoutParams = (LinearLayout.LayoutParams)paramLayoutParams;
      if (!b) {
        break label113;
      }
      if (g == null) {
        g = new Paint();
      }
      localPaint = g;
      localObject = f;
      if (m == null) {
        break label106;
      }
    }
    label106:
    for (Object localObject = m;; localObject = Typeface.DEFAULT)
    {
      localPaint.setTypeface((Typeface)localObject);
      g.setTextSize(f.h);
      topMargin = ((int)-g.ascent());
      return paramLayoutParams;
      paramLayoutParams = new LinearLayout.LayoutParams(paramLayoutParams);
      break;
    }
    label113:
    topMargin = 0;
    return paramLayoutParams;
  }
  
  private final void a()
  {
    rg.a(h, rg.k(a), 0, rg.l(a), a.getPaddingBottom());
  }
  
  private final void a(float paramFloat)
  {
    if (f.c == paramFloat) {
      return;
    }
    if (v == null)
    {
      v = dd.a();
      v.a(p.a);
      v.a(200);
      v.a(new ci(this));
    }
    v.a(f.c, paramFloat);
    v.a.a();
  }
  
  private static void a(Drawable paramDrawable)
  {
    for (;;)
    {
      paramDrawable.clearColorFilter();
      if ((Build.VERSION.SDK_INT != 21) && (Build.VERSION.SDK_INT != 22)) {
        return;
      }
      if ((paramDrawable instanceof InsetDrawable))
      {
        paramDrawable = ((InsetDrawable)paramDrawable).getDrawable();
      }
      else
      {
        if (!(paramDrawable instanceof kx)) {
          break;
        }
        paramDrawable = ((kx)paramDrawable).a();
      }
    }
    if ((paramDrawable instanceof DrawableContainer))
    {
      paramDrawable = (DrawableContainer.DrawableContainerState)((DrawableContainer)paramDrawable).getConstantState();
      if (paramDrawable != null)
      {
        int i1 = 0;
        int i2 = paramDrawable.getChildCount();
        while (i1 < i2)
        {
          a(paramDrawable.getChild(i1));
          i1 += 1;
        }
      }
    }
  }
  
  private final void a(TextView paramTextView)
  {
    if (h != null)
    {
      h.removeView(paramTextView);
      int i1 = i - 1;
      i = i1;
      if (i1 == 0) {
        h.setVisibility(8);
      }
    }
  }
  
  private final void a(TextView paramTextView, int paramInt)
  {
    if (h == null)
    {
      h = new LinearLayout(getContext());
      h.setOrientation(0);
      addView(h, -1, -2);
      Space localSpace = new Space(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      h.addView(localSpace, localLayoutParams);
      if (a != null) {
        a();
      }
    }
    h.setVisibility(0);
    h.addView(paramTextView, paramInt);
    i += 1;
  }
  
  private final void b()
  {
    int i1 = Build.VERSION.SDK_INT;
    Object localObject2;
    Drawable.ConstantState localConstantState;
    if ((i1 == 21) || (i1 == 22))
    {
      localObject2 = a.getBackground();
      if ((localObject2 != null) && (!w))
      {
        localObject1 = ((Drawable)localObject2).getConstantState().newDrawable();
        if ((localObject2 instanceof DrawableContainer))
        {
          localObject2 = (DrawableContainer)localObject2;
          localConstantState = ((Drawable)localObject1).getConstantState();
          if (Build.VERSION.SDK_INT < 9) {
            break label123;
          }
        }
      }
    }
    label123:
    for (boolean bool = am.a((DrawableContainer)localObject2, localConstantState);; bool = am.b((DrawableContainer)localObject2, localConstantState))
    {
      w = bool;
      if (!w)
      {
        a.setBackgroundDrawable((Drawable)localObject1);
        w = true;
      }
      localObject2 = a.getBackground();
      if (localObject2 != null) {
        break;
      }
      return;
    }
    Object localObject1 = localObject2;
    if (aij.c((Drawable)localObject2)) {
      localObject1 = ((Drawable)localObject2).mutate();
    }
    if ((l) && (d != null))
    {
      ((Drawable)localObject1).setColorFilter(agj.a(d.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    if ((r) && (n != null))
    {
      ((Drawable)localObject1).setColorFilter(agj.a(n.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    a((Drawable)localObject1);
    a.refreshDrawableState();
  }
  
  private final void b(boolean paramBoolean)
  {
    if (j != paramBoolean)
    {
      if (d != null) {
        rg.q(d).a();
      }
      if (!paramBoolean) {
        break label124;
      }
    }
    for (d = new TextView(getContext());; d = null)
    {
      try
      {
        d.setTextAppearance(getContext(), k);
        d.setVisibility(4);
        rg.j(d);
        a(d, 0);
        j = paramBoolean;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          d.setTextAppearance(getContext(), i.a);
          d.setTextColor(jr.b(getContext(), d.h));
        }
      }
      label124:
      l = false;
      b();
      a(d);
    }
  }
  
  private final CharSequence c()
  {
    if (j) {
      return m;
    }
    return null;
  }
  
  public final void a(int paramInt)
  {
    boolean bool2 = r;
    if (o == -1)
    {
      n.setText(String.valueOf(paramInt));
      r = false;
      if ((a != null) && (bool2 != r))
      {
        a(false);
        b();
      }
      return;
    }
    boolean bool1;
    label66:
    TextView localTextView;
    Context localContext;
    if (paramInt > o)
    {
      bool1 = true;
      r = bool1;
      if (bool2 != r)
      {
        localTextView = n;
        localContext = getContext();
        if (!r) {
          break label158;
        }
      }
    }
    label158:
    for (int i1 = q;; i1 = p)
    {
      localTextView.setTextAppearance(localContext, i1);
      n.setText(getContext().getString(h.a, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(o) }));
      break;
      bool1 = false;
      break label66;
    }
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    if (b)
    {
      c = paramCharSequence;
      aa localaa = f;
      if ((paramCharSequence == null) || (!paramCharSequence.equals(o)))
      {
        o = paramCharSequence;
        p = null;
        localaa.c();
        localaa.b();
      }
      sendAccessibilityEvent(2048);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    int i3 = 1;
    int i1;
    int i2;
    if ((a != null) && (!TextUtils.isEmpty(a.getText())))
    {
      i1 = 1;
      Object localObject = getDrawableState();
      int i4 = localObject.length;
      i2 = 0;
      label38:
      if (i2 >= i4) {
        break label210;
      }
      if (localObject[i2] != 16842908) {
        break label203;
      }
      i2 = 1;
      label56:
      if (TextUtils.isEmpty(c())) {
        break label215;
      }
      label66:
      if (s != null)
      {
        localObject = f;
        i4 = s.getDefaultColor();
        if (i != i4)
        {
          i = i4;
          ((aa)localObject).b();
        }
      }
      if ((!r) || (n == null)) {
        break label221;
      }
      f.a(n.getCurrentTextColor());
    }
    for (;;)
    {
      if ((i1 != 0) || (i2 != 0) || (i3 != 0))
      {
        if ((v != null) && (v.a.b())) {
          v.a.e();
        }
        if ((paramBoolean) && (u))
        {
          a(1.0F);
          return;
          i1 = 0;
          break;
          label203:
          i2 += 1;
          break label38;
          label210:
          i2 = 0;
          break label56;
          label215:
          i3 = 0;
          break label66;
          label221:
          if ((i2 != 0) && (t != null))
          {
            f.a(t.getDefaultColor());
            continue;
          }
          if (s == null) {
            continue;
          }
          f.a(s.getDefaultColor());
          continue;
        }
        f.a(1.0F);
        return;
      }
    }
    if ((v != null) && (v.a.b())) {
      v.a.e();
    }
    if ((paramBoolean) && (u))
    {
      a(0.0F);
      return;
    }
    f.a(0.0F);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      Object localObject = (EditText)paramView;
      if (a != null) {
        throw new IllegalArgumentException("We already have an EditText, can only have one");
      }
      a = ((EditText)localObject);
      localObject = f;
      Typeface localTypeface = a.getTypeface();
      n = localTypeface;
      m = localTypeface;
      ((aa)localObject).b();
      localObject = f;
      float f1 = a.getTextSize();
      if (g != f1)
      {
        g = f1;
        ((aa)localObject).b();
      }
      paramInt = a.getGravity();
      f.b(0x800007 & paramInt | 0x30);
      localObject = f;
      if (f != paramInt)
      {
        f = paramInt;
        ((aa)localObject).b();
      }
      a.addTextChangedListener(new cf(this));
      if (s == null) {
        s = a.getHintTextColors();
      }
      if ((b) && (TextUtils.isEmpty(c)))
      {
        a(a.getHint());
        a.setHint(null);
      }
      if (n != null) {
        a(a.getText().length());
      }
      if (h != null) {
        a();
      }
      a(false);
      super.addView(paramView, 0, a(paramLayoutParams));
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    if (TextUtils.equals(m, paramCharSequence)) {}
    do
    {
      return;
      m = paramCharSequence;
      if (j) {
        break;
      }
    } while (TextUtils.isEmpty(paramCharSequence));
    b(true);
    boolean bool2 = rg.w(this);
    boolean bool1;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      bool1 = true;
      l = bool1;
      rg.q(d).a();
      if (!l) {
        break label164;
      }
      d.setText(paramCharSequence);
      d.setVisibility(0);
      if (bool2)
      {
        if (rg.e(d) == 1.0F) {
          rg.c(d, 0.0F);
        }
        rg.q(d).a(1.0F).a(200L).a(p.d).a(new cg(this)).b();
      }
    }
    for (;;)
    {
      b();
      a(true);
      return;
      bool1 = false;
      break;
      label164:
      if (d.getVisibility() == 0) {
        if (bool2) {
          rg.q(d).a(0.0F).a(200L).a(p.c).a(new ch(this, paramCharSequence)).b();
        } else {
          d.setVisibility(4);
        }
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    aa localaa;
    int i2;
    float f4;
    int i1;
    float f1;
    label90:
    float f2;
    if (b)
    {
      localaa = f;
      i2 = paramCanvas.save();
      if ((p != null) && (b))
      {
        f4 = k;
        float f3 = l;
        if ((!q) || (r == null)) {
          break label159;
        }
        i1 = 1;
        if (i1 == 0) {
          break label165;
        }
        f1 = t * u;
        f2 = f3;
        if (i1 != 0) {
          f2 = f3 + f1;
        }
        if (u != 1.0F) {
          paramCanvas.scale(u, u, f4, f2);
        }
        if (i1 == 0) {
          break label188;
        }
        paramCanvas.drawBitmap(r, f4, f2, s);
      }
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i2);
      return;
      label159:
      i1 = 0;
      break;
      label165:
      w.ascent();
      f1 = 0.0F;
      w.descent();
      break label90;
      label188:
      paramCanvas.drawText(p, 0, p.length(), f4, f2, w);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((b) && (a != null))
    {
      paramInt1 = a.getLeft() + a.getCompoundPaddingLeft();
      paramInt3 = a.getRight() - a.getCompoundPaddingRight();
      aa localaa = f;
      int i1 = a.getTop() + a.getCompoundPaddingTop();
      int i2 = a.getBottom() - a.getCompoundPaddingBottom();
      if (!aa.a(d, paramInt1, i1, paramInt3, i2))
      {
        d.set(paramInt1, i1, paramInt3, i2);
        v = true;
        localaa.a();
      }
      localaa = f;
      i1 = getPaddingTop();
      paramInt2 = paramInt4 - paramInt2 - getPaddingBottom();
      if (!aa.a(e, paramInt1, i1, paramInt3, paramInt2))
      {
        e.set(paramInt1, i1, paramInt3, paramInt2);
        v = true;
        localaa.a();
      }
      f.b();
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof TextInputLayout.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (TextInputLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    b(a);
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    TextInputLayout.SavedState localSavedState = new TextInputLayout.SavedState(super.onSaveInstanceState());
    if (l) {
      a = c();
    }
    return localSavedState;
  }
  
  public void refreshDrawableState()
  {
    super.refreshDrawableState();
    a(rg.w(this));
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.TextInputLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */