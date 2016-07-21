package com.google.android.libraries.social.licenses;

import aah;
import aaj;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;
import gnw;
import gny;
import goa;
import gob;
import zc;
import zh;

public final class LicenseActivity
  extends zh
{
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(gob.b);
    Object localObject = (License)getIntent().getParcelableExtra("license");
    f().a().a(a);
    f().a().a(true);
    f().a().b(true);
    f().a().a(null);
    paramBundle = (TextView)findViewById(goa.d);
    localObject = gny.a(this, (License)localObject);
    if (localObject == null)
    {
      finish();
      return;
    }
    paramBundle.setText((CharSequence)localObject);
  }
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    ScrollView localScrollView = (ScrollView)findViewById(goa.c);
    localScrollView.post(new gnw(this, paramBundle.getInt("scroll_pos"), localScrollView));
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    ScrollView localScrollView = (ScrollView)findViewById(goa.c);
    TextView localTextView = (TextView)findViewById(goa.d);
    int i = localTextView.getLayout().getLineForVertical(localScrollView.getScrollY());
    paramBundle.putInt("scroll_pos", localTextView.getLayout().getLineStart(i));
  }
}

/* Location:
 * Qualified Name:     com.google.android.libraries.social.licenses.LicenseActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */