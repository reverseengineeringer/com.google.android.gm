package com.google.android.gm.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.ListPreference;
import android.util.AttributeSet;
import com.google.android.gm.R.styleable;

public class FancySummaryListPreference
  extends ListPreference
{
  private CharSequence[] mEntrySummaries;
  
  public FancySummaryListPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FancySummaryListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mEntrySummaries = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FancySummaryListPreference, 0, 0).getTextArray(0);
  }
  
  private CharSequence getSummaryForValue(String paramString)
  {
    int i = findIndexOfValue(paramString);
    if ((i >= 0) && (i < mEntrySummaries.length)) {
      return mEntrySummaries[i];
    }
    return null;
  }
  
  public void setValue(String paramString)
  {
    super.setValue(paramString);
    setSummary(getSummaryForValue(paramString));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.FancySummaryListPreference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */