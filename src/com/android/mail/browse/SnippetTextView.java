package com.android.mail.browse;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;

public class SnippetTextView
  extends TextView
{
  private int mLastHSpec;
  private int mLastWSpec;
  private int mMaxLines;
  
  public SnippetTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SnippetTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public String getTextRemainder(String paramString)
  {
    Object localObject2;
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject2 = null;
    }
    CharSequence localCharSequence;
    TextUtils.TruncateAt localTruncateAt;
    Object localObject1;
    do
    {
      return (String)localObject2;
      localCharSequence = getText();
      localTruncateAt = getEllipsize();
      setEllipsize(null);
      setText(paramString);
      localObject2 = getLayout();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        measure(mLastWSpec, mLastHSpec);
        localObject1 = getLayout();
      }
      localObject2 = paramString;
    } while (localObject1 == null);
    if (((Layout)localObject1).getLineCount() <= mMaxLines) {}
    for (paramString = null;; paramString = paramString.substring(((Layout)localObject1).getLineStart(mMaxLines), paramString.length()))
    {
      setEllipsize(localTruncateAt);
      setText(localCharSequence);
      return paramString;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    mLastWSpec = paramInt1;
    mLastHSpec = paramInt2;
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    mMaxLines = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.SnippetTextView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */