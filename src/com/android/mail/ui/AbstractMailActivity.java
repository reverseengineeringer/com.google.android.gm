package com.android.mail.ui;

import android.app.Activity;
import android.content.Context;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Bundle;

public abstract class AbstractMailActivity
  extends Activity
  implements RestrictedActivity
{
  private static AbstractMailActivity sForegroundInstance;
  private NdefMessage mForegroundNdef;
  private NfcAdapter mNfcAdapter;
  private final UiHandler mUiHandler = new UiHandler();
  
  public Context getActivityContext()
  {
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
    if (mNfcAdapter != null) {}
    mUiHandler.setEnabled(true);
  }
  
  protected void onPause()
  {
    super.onPause();
    try
    {
      if ((mNfcAdapter != null) && (mForegroundNdef != null)) {
        mNfcAdapter.disableForegroundNdefPush(this);
      }
      sForegroundInstance = null;
      return;
    }
    finally {}
  }
  
  protected void onResume()
  {
    super.onResume();
    try
    {
      sForegroundInstance = this;
      if ((mNfcAdapter != null) && (mForegroundNdef != null)) {
        mNfcAdapter.enableForegroundNdefPush(this, mForegroundNdef);
      }
      mUiHandler.setEnabled(true);
      return;
    }
    finally {}
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    mUiHandler.setEnabled(false);
  }
  
  protected void onStart()
  {
    super.onStart();
    mUiHandler.setEnabled(true);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractMailActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */