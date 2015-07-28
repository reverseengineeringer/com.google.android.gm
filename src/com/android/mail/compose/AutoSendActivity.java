package com.android.mail.compose;

import android.content.Intent;
import android.os.Bundle;

public class AutoSendActivity
  extends ComposeActivity
{
  private boolean mDontSaveOrSend = false;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mDontSaveOrSend = getIntent().getBooleanExtra("dontSendOrSave", false);
    sendOrSaveWithSanityChecks(false, true);
  }
  
  protected boolean sendOrSaveWithSanityChecks(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mDontSaveOrSend) {
      return false;
    }
    return super.sendOrSaveWithSanityChecks(paramBoolean1, paramBoolean2, false, true);
  }
  
  protected boolean showEmptyTextWarnings()
  {
    return false;
  }
  
  protected boolean showSendConfirmation()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.AutoSendActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */