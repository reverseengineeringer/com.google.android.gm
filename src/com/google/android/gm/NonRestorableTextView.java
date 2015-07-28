package com.google.android.gm;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;

public class NonRestorableTextView
  extends TextView
{
  public NonRestorableTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NonRestorableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NonRestorableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Parcelable onSaveInstanceState()
  {
    super.onSaveInstanceState();
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.NonRestorableTextView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */