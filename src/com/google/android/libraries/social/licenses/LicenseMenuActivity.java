package com.google.android.libraries.social.licenses;

import aah;
import aaj;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import gnx;
import gny;
import goa;
import gob;
import zc;
import zh;

public final class LicenseMenuActivity
  extends zh
{
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(gob.c);
    if (f().a() != null) {
      f().a().b(true);
    }
    paramBundle = gny.a(this);
    paramBundle = new ArrayAdapter(this, gob.a, goa.b, paramBundle);
    ListView localListView = (ListView)findViewById(goa.e);
    localListView.setAdapter(paramBundle);
    localListView.setOnItemClickListener(new gnx(this));
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
}

/* Location:
 * Qualified Name:     com.google.android.libraries.social.licenses.LicenseMenuActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */