package com.android.setupwizardlib;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.setupwizardlib.view.BottomScrollView;
import com.android.setupwizardlib.view.Illustration;
import com.android.setupwizardlib.view.NavigationBar;
import cxs;
import cxt;
import cxu;
import cxv;
import cxw;
import cxy;
import cya;
import cyj;

public class SetupWizardLayout
  extends cya
{
  private ColorStateList a;
  
  public SetupWizardLayout(Context paramContext)
  {
    super(paramContext, 0, 0);
    a(null, cxs.a);
  }
  
  public SetupWizardLayout(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 0);
  }
  
  public SetupWizardLayout(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1, paramInt2);
    a(null, cxs.a);
  }
  
  public SetupWizardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, cxs.a);
  }
  
  public SetupWizardLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
  }
  
  private final Drawable a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (getContext().getResources().getBoolean(cxt.a))
    {
      if ((paramDrawable2 instanceof BitmapDrawable))
      {
        ((BitmapDrawable)paramDrawable2).setTileModeX(Shader.TileMode.REPEAT);
        ((BitmapDrawable)paramDrawable2).setGravity(48);
      }
      if ((paramDrawable1 instanceof BitmapDrawable)) {
        ((BitmapDrawable)paramDrawable1).setGravity(51);
      }
      paramDrawable2 = new LayerDrawable(new Drawable[] { paramDrawable2, paramDrawable1 });
      if (Build.VERSION.SDK_INT >= 19) {
        paramDrawable2.setAutoMirrored(true);
      }
    }
    do
    {
      return paramDrawable2;
      paramDrawable2 = paramDrawable1;
    } while (Build.VERSION.SDK_INT < 19);
    paramDrawable1.setAutoMirrored(true);
    return paramDrawable1;
  }
  
  private final void a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      ((BitmapDrawable)paramDrawable).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    }
    setLayoutBackground(paramDrawable);
  }
  
  private final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, cxy.aw, paramInt, 0);
    Object localObject = paramAttributeSet.getDrawable(cxy.ax);
    if (localObject != null)
    {
      setLayoutBackground((Drawable)localObject);
      localObject = paramAttributeSet.getDrawable(cxy.aB);
      if (localObject == null) {
        break label192;
      }
      setIllustration((Drawable)localObject);
    }
    for (;;)
    {
      int i = paramAttributeSet.getDimensionPixelSize(cxy.az, -1);
      paramInt = i;
      if (i == -1) {
        paramInt = getResources().getDimensionPixelSize(cxu.a);
      }
      setDecorPaddingTop(paramInt);
      float f2 = paramAttributeSet.getFloat(cxy.aC, -1.0F);
      float f1 = f2;
      if (f2 == -1.0F)
      {
        localObject = new TypedValue();
        getResources().getValue(cxu.b, (TypedValue)localObject, true);
        f1 = ((TypedValue)localObject).getFloat();
      }
      setIllustrationAspectRatio(f1);
      localObject = paramAttributeSet.getText(cxy.aA);
      if (localObject != null) {
        setHeaderText((CharSequence)localObject);
      }
      paramAttributeSet.recycle();
      return;
      localObject = paramAttributeSet.getDrawable(cxy.ay);
      if (localObject == null) {
        break;
      }
      a((Drawable)localObject);
      break;
      label192:
      localObject = paramAttributeSet.getDrawable(cxy.aE);
      Drawable localDrawable = paramAttributeSet.getDrawable(cxy.aD);
      if ((localObject != null) && (localDrawable != null))
      {
        View localView = findViewById(cxv.c);
        if ((localView instanceof Illustration)) {
          ((Illustration)localView).a(a((Drawable)localObject, localDrawable));
        }
      }
    }
  }
  
  protected final View a(LayoutInflater paramLayoutInflater, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = cxw.c;
    }
    try
    {
      paramLayoutInflater = super.a(paramLayoutInflater, i);
      return paramLayoutInflater;
    }
    catch (RuntimeException paramLayoutInflater)
    {
      throw new InflateException("Unable to inflate layout. Are you using @style/SuwThemeMaterial (or its descendant) as your theme?", paramLayoutInflater);
    }
  }
  
  protected final ViewGroup a(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = cxv.b;
    }
    return super.a(i);
  }
  
  public CharSequence getHeaderText()
  {
    TextView localTextView = getHeaderTextView();
    if (localTextView != null) {
      return localTextView.getText();
    }
    return null;
  }
  
  public TextView getHeaderTextView()
  {
    return (TextView)findViewById(cxv.g);
  }
  
  public NavigationBar getNavigationBar()
  {
    View localView = findViewById(cxv.d);
    if ((localView instanceof NavigationBar)) {
      return (NavigationBar)localView;
    }
    return null;
  }
  
  public ColorStateList getProgressBarColor()
  {
    return a;
  }
  
  public ScrollView getScrollView()
  {
    View localView = findViewById(cxv.a);
    if ((localView instanceof ScrollView)) {
      return (ScrollView)localView;
    }
    return null;
  }
  
  @Deprecated
  public void hideProgressBar()
  {
    setProgressBarShown(false);
  }
  
  public boolean isProgressBarShown()
  {
    View localView = findViewById(cxv.e);
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SetupWizardLayout.SavedState))
    {
      String str = String.valueOf(paramParcelable);
      Log.w("SetupWizardLayout", String.valueOf(str).length() + 32 + "Ignoring restore instance state " + str);
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SetupWizardLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (a)
    {
      showProgressBar();
      return;
    }
    hideProgressBar();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SetupWizardLayout.SavedState localSavedState = new SetupWizardLayout.SavedState(super.onSaveInstanceState());
    a = isProgressBarShown();
    return localSavedState;
  }
  
  public void requireScrollToBottom()
  {
    NavigationBar localNavigationBar = getNavigationBar();
    ScrollView localScrollView = getScrollView();
    if ((localNavigationBar != null) && ((localScrollView instanceof BottomScrollView)))
    {
      new cyj(localNavigationBar, (BottomScrollView)localScrollView).a();
      return;
    }
    Log.e("SetupWizardLayout", "Both suw_layout_navigation_bar and suw_bottom_scroll_view must exist in the template to require scrolling.");
  }
  
  public void setBackgroundTile(int paramInt)
  {
    a(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setDecorPaddingTop(int paramInt)
  {
    View localView = findViewById(cxv.c);
    if (localView != null) {
      localView.setPadding(localView.getPaddingLeft(), paramInt, localView.getPaddingRight(), localView.getPaddingBottom());
    }
  }
  
  public void setHeaderText(int paramInt)
  {
    TextView localTextView = getHeaderTextView();
    if (localTextView != null) {
      localTextView.setText(paramInt);
    }
  }
  
  public void setHeaderText(CharSequence paramCharSequence)
  {
    TextView localTextView = getHeaderTextView();
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  public void setIllustration(int paramInt1, int paramInt2)
  {
    Object localObject = findViewById(cxv.c);
    if ((localObject instanceof Illustration))
    {
      localObject = (Illustration)localObject;
      Context localContext = getContext();
      ((Illustration)localObject).a(a(localContext.getResources().getDrawable(paramInt1), localContext.getResources().getDrawable(paramInt2)));
    }
  }
  
  public void setIllustration(Drawable paramDrawable)
  {
    View localView = findViewById(cxv.c);
    if ((localView instanceof Illustration)) {
      ((Illustration)localView).a(paramDrawable);
    }
  }
  
  public void setIllustrationAspectRatio(float paramFloat)
  {
    Object localObject = findViewById(cxv.c);
    if ((localObject instanceof Illustration))
    {
      localObject = (Illustration)localObject;
      a = paramFloat;
      ((Illustration)localObject).invalidate();
      ((Illustration)localObject).requestLayout();
    }
  }
  
  public void setLayoutBackground(Drawable paramDrawable)
  {
    View localView = findViewById(cxv.c);
    if (localView != null) {
      localView.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setProgressBarColor(ColorStateList paramColorStateList)
  {
    a = paramColorStateList;
    if (Build.VERSION.SDK_INT >= 21)
    {
      ProgressBar localProgressBar = (ProgressBar)findViewById(cxv.e);
      if (localProgressBar != null) {
        localProgressBar.setIndeterminateTintList(paramColorStateList);
      }
    }
  }
  
  public void setProgressBarShown(boolean paramBoolean)
  {
    Object localObject = findViewById(cxv.e);
    int i;
    if (localObject != null) {
      if (paramBoolean)
      {
        i = 0;
        ((View)localObject).setVisibility(i);
      }
    }
    do
    {
      do
      {
        return;
        i = 8;
        break;
      } while (!paramBoolean);
      localObject = (ViewStub)findViewById(cxv.f);
      if (localObject != null) {
        ((ViewStub)localObject).inflate();
      }
    } while (a == null);
    setProgressBarColor(a);
  }
  
  @Deprecated
  public void showProgressBar()
  {
    setProgressBarShown(true);
  }
}

/* Location:
 * Qualified Name:     com.android.setupwizardlib.SetupWizardLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */