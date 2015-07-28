package com.google.android.gm;

import android.app.Activity;
import android.content.Context;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import com.google.android.gm.persistence.Persistence;
import com.google.android.gm.provider.MailEngine;
import com.google.android.gm.provider.MailEngine.MailEngineResultCallback;

public abstract class GmailBaseActivity
  extends Activity
  implements ApplicationMenuHandler.HelpCallback, RestrictedActivity
{
  private static GmailBaseActivity sForegroundInstance;
  private NdefMessage mForegroundNdef;
  private NfcAdapter mNfcAdapter;
  MailEngine.MailEngineResultCallback mOnMailEnginePrepared = new MailEngine.MailEngineResultCallback()
  {
    public void onMailEngineResult(MailEngine paramAnonymousMailEngine) {}
  };
  private final UiHandler mUiHandler = new UiHandler();
  
  public Context getContext()
  {
    return this;
  }
  
  public String getHelpContext()
  {
    return "gm";
  }
  
  public UiHandler getUiHandler()
  {
    return mUiHandler;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
    if (mNfcAdapter != null)
    {
      paramBundle = Persistence.getInstance().getActiveAccount(this);
      if (paramBundle != null) {
        MailEngine.getOrMakeMailEngineAsync(this, paramBundle, mOnMailEnginePrepared);
      }
    }
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
 * Qualified Name:     com.google.android.gm.GmailBaseActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */