package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import cyc;
import cye;
import cyi;
import rg;

public class RichTextView
  extends TextView
{
  private cyi a;
  
  public RichTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RichTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private final void a()
  {
    a = new cyi(this);
    rg.a(this, a);
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((a != null) && (a.a(paramMotionEvent))) {
      return true;
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Context localContext = getContext();
    int i;
    if ((paramCharSequence instanceof Spanned))
    {
      SpannableString localSpannableString = new SpannableString(paramCharSequence);
      Annotation[] arrayOfAnnotation = (Annotation[])localSpannableString.getSpans(0, localSpannableString.length(), Annotation.class);
      int j = arrayOfAnnotation.length;
      i = 0;
      paramCharSequence = localSpannableString;
      if (i < j)
      {
        paramCharSequence = arrayOfAnnotation[i];
        String str = paramCharSequence.getKey();
        if ("textAppearance".equals(str))
        {
          str = paramCharSequence.getValue();
          int k = localContext.getResources().getIdentifier(str, "style", localContext.getPackageName());
          if (k == 0) {
            Log.w("RichTextView", 33 + "Cannot find resource: " + k);
          }
          cye.a(localSpannableString, paramCharSequence, new TextAppearanceSpan(localContext, k));
        }
        for (;;)
        {
          i += 1;
          break;
          if ("link".equals(str)) {
            cye.a(localSpannableString, paramCharSequence, new cyc(paramCharSequence.getValue()));
          }
        }
      }
    }
    super.setText(paramCharSequence, paramBufferType);
    if ((paramCharSequence instanceof Spanned)) {
      if (((ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class)).length > 0) {
        i = 1;
      }
    }
    while (i != 0)
    {
      setMovementMethod(LinkMovementMethod.getInstance());
      return;
      i = 0;
      continue;
      i = 0;
    }
    setMovementMethod(null);
  }
}

/* Location:
 * Qualified Name:     com.android.setupwizardlib.view.RichTextView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */