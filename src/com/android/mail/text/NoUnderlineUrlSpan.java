package com.android.mail.text;

import android.text.TextPaint;
import android.text.style.URLSpan;

public class NoUnderlineUrlSpan
  extends URLSpan
{
  public NoUnderlineUrlSpan(String paramString)
  {
    super(paramString);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.text.NoUnderlineUrlSpan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */