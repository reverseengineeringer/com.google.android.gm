package com.android.mail.ui.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.ListPreference;
import android.util.AttributeSet;
import bul;

public class FancySummaryListPreference
  extends ListPreference
{
  private CharSequence[] a;
  
  public FancySummaryListPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FancySummaryListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a = paramContext.obtainStyledAttributes(paramAttributeSet, bul.H, 0, 0).getTextArray(bul.I);
  }
  
  public void setValue(String paramString)
  {
    super.setValue(paramString);
    int i = findIndexOfValue(paramString);
    if ((i >= 0) && (i < a.length)) {}
    for (paramString = a[i];; paramString = null)
    {
      setSummary(paramString);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.settings.FancySummaryListPreference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */