package com.android.email.activity.setup;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import arc;
import are;
import arf;
import avw;

public class MultilineSelectionGroup
  extends LinearLayout
  implements View.OnClickListener
{
  public int a = -1;
  public int b;
  public avw c;
  public View[] d;
  private boolean e;
  
  public MultilineSelectionGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public MultilineSelectionGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MultilineSelectionGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static void a(View paramView, boolean paramBoolean)
  {
    ((RadioButton)paramView.findViewById(are.aL)).setChecked(paramBoolean);
  }
  
  private final String c(int paramInt)
  {
    if (paramInt > 0) {
      return getResources().getString(paramInt);
    }
    return null;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramLayoutInflater, paramInt1, paramInt2, c(paramInt3), c(paramInt4));
  }
  
  public final View a(LayoutInflater paramLayoutInflater, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if ((paramInt1 >= b) || (TextUtils.isEmpty(paramString1))) {
      return null;
    }
    TextView localTextView2;
    if (e)
    {
      paramLayoutInflater = paramLayoutInflater.inflate(arf.E, this, false);
      TextView localTextView1 = (TextView)paramLayoutInflater.findViewById(are.aB);
      localTextView2 = (TextView)paramLayoutInflater.findViewById(are.aA);
      localTextView1.setText(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        break label143;
      }
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      paramLayoutInflater.setOnClickListener(this);
      paramLayoutInflater.setId(paramInt2);
      if (!e) {
        break label153;
      }
      if (getChildCount() == 0) {
        paramLayoutInflater.findViewById(are.aT).setVisibility(0);
      }
      d[paramInt1] = paramLayoutInflater;
      addView(paramLayoutInflater);
      return paramLayoutInflater;
      paramLayoutInflater = paramLayoutInflater.inflate(arf.D, this, false);
      break;
      label143:
      localTextView2.setText(paramString2);
    }
    label153:
    if (a == paramInt1) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramLayoutInflater, bool);
      break;
    }
  }
  
  public final void a()
  {
    int i = 0;
    if (i < d.length)
    {
      View localView = d[i];
      if (localView != null) {
        if (a != i) {
          break label44;
        }
      }
      label44:
      for (boolean bool = true;; bool = false)
      {
        a(localView, bool);
        i += 1;
        break;
      }
    }
  }
  
  public final void a(int paramInt)
  {
    b = paramInt;
    d = new View[b];
  }
  
  public final void a(boolean paramBoolean)
  {
    e = false;
    int i;
    if (e)
    {
      i = (int)getResources().getDimension(arc.b);
      if (!e) {
        break label57;
      }
    }
    label57:
    for (int j = (int)getResources().getDimension(arc.a);; j = 0)
    {
      setPadding(0, i, 0, j);
      return;
      i = 0;
      break;
    }
  }
  
  public final void b(int paramInt)
  {
    a = paramInt;
    a();
  }
  
  public final boolean b()
  {
    return a == -1;
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    int i = 0;
    for (;;)
    {
      if (i < d.length)
      {
        paramView = d[i];
        if ((paramView == null) || (paramView.getId() != j)) {
          break label61;
        }
        a = i;
        a();
        if (c != null) {
          c.e();
        }
      }
      return;
      label61:
      i += 1;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setOrientation(1);
    a(3);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (MultilineSelectionGroup.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    a = a;
    e = b;
  }
  
  public Parcelable onSaveInstanceState()
  {
    MultilineSelectionGroup.SavedState localSavedState = new MultilineSelectionGroup.SavedState(super.onSaveInstanceState());
    a = a;
    b = e;
    return localSavedState;
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.MultilineSelectionGroup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */