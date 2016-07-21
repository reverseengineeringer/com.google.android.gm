package com.android.email.activity.setup;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class PolicyListPreference
  extends Preference
{
  public PolicyListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PolicyListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
    ((TextView)paramView.findViewById(16908304)).setMaxLines(24);
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.PolicyListPreference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */