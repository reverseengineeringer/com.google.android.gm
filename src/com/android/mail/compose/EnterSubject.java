package com.android.mail.compose;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class EnterSubject
  extends EditText
{
  public EnterSubject(Context paramContext)
  {
    super(paramContext);
  }
  
  public EnterSubject(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EnterSubject(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    int i = imeOptions & 0xFF;
    if ((i & 0x5) != 0)
    {
      imeOptions = (i ^ imeOptions);
      imeOptions |= 0x5;
    }
    if ((imeOptions & 0x40000000) != 0) {
      imeOptions &= 0xBFFFFFFF;
    }
    return localInputConnection;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.EnterSubject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */