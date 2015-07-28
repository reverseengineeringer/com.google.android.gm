package com.google.android.gm;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.LogUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class LicenseActivity
  extends Activity
{
  private WebView mWebView;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968658);
    paramBundle = getActionBar();
    if (paramBundle != null)
    {
      paramBundle.setDisplayHomeAsUpEnabled(true);
      if (Gmail.isRunningICSOrLater()) {
        paramBundle.setHomeButtonEnabled(true);
      }
    }
    mWebView = ((WebView)findViewById(2131755016));
    try
    {
      Object localObject = getResources().openRawResource(2131230720);
      paramBundle = new BufferedReader(new InputStreamReader((InputStream)localObject));
      int n = ((InputStream)localObject).available();
      localObject = new char[n];
      int i = 0;
      int j = 0;
      int k;
      int m;
      do
      {
        k = i + j;
        m = paramBundle.read((char[])localObject, k, n - k);
        if (m <= -1) {
          break;
        }
        j = m;
        i = k;
      } while (k + m < n);
      paramBundle.close();
      paramBundle = new String((char[])localObject);
      mWebView.loadData(paramBundle, "text/html", null);
      return;
    }
    catch (IOException paramBundle)
    {
      LogUtils.e("Gmail", paramBundle, "Error reading licence file", new Object[0]);
      finish();
    }
  }
  
  protected void onDestroy()
  {
    mWebView.destroy();
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.LicenseActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */