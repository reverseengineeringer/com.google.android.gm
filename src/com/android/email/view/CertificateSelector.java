package com.android.email.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import are;
import arh;
import bbq;

public class CertificateSelector
  extends LinearLayout
  implements View.OnClickListener
{
  public String a;
  public bbq b;
  private TextView c;
  private TextView d;
  
  public CertificateSelector(Context paramContext)
  {
    super(paramContext);
  }
  
  public CertificateSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CertificateSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(String paramString)
  {
    Resources localResources = getResources();
    a = paramString;
    TextView localTextView = d;
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = localResources.getString(arh.M);
      localTextView.setText((CharSequence)localObject);
      localObject = c;
      if (!TextUtils.isEmpty(paramString)) {
        break label71;
      }
    }
    label71:
    for (int i = arh.O;; i = arh.N)
    {
      ((TextView)localObject).setText(localResources.getString(i));
      return;
      localObject = paramString;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == c) && (b != null)) {
      if (a == null) {
        break label34;
      }
    }
    label34:
    for (int i = 1; i != 0; i = 0)
    {
      a(null);
      return;
    }
    b.a(getContext());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    d = ((TextView)findViewById(are.J));
    c = ((TextView)findViewById(are.aN));
    c.setOnClickListener(this);
    a(null);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (CertificateSelector.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    a(a);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    return new CertificateSelector.SavedState(super.onSaveInstanceState(), a);
  }
}

/* Location:
 * Qualified Name:     com.android.email.view.CertificateSelector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */