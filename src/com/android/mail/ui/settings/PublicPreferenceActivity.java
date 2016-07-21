package com.android.mail.ui.settings;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import crv;
import java.util.Iterator;
import java.util.Set;

public class PublicPreferenceActivity
  extends Activity
{
  public static Class<? extends crv> a;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    paramBundle.removeExtra(":android:show_fragment");
    paramBundle.removeExtra(":android:show_fragment_args");
    paramBundle.removeExtra(":android:show_fragment_short_title");
    paramBundle.removeExtra(":android:show_fragment_title");
    Uri localUri = paramBundle.getData();
    if ((localUri != null) && (localUri.getQueryParameter("preference_fragment_id") != null))
    {
      Object localObject = localUri.getQueryParameterNames();
      Uri.Builder localBuilder = localUri.buildUpon().clearQuery();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!TextUtils.equals(str, "preference_fragment_id")) {
          localBuilder.appendQueryParameter(str, localUri.getQueryParameter(str));
        }
      }
      paramBundle.setData(localBuilder.build());
    }
    if (a == null) {
      a = crv.class;
    }
    paramBundle.setClass(this, a);
    startActivity(paramBundle);
    finish();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.settings.PublicPreferenceActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */