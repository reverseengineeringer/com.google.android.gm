package com.google.android.gm.ui;

import android.content.Intent;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Bundle;
import com.android.mail.ui.MailActivity;
import com.google.android.gm.Utils;
import java.util.List;

public class MailActivityGmail
  extends MailActivity
{
  static final String EXTRA_ACCOUNT = "account";
  static final String EXTRA_LABEL = "label";
  private static final UriMatcher sUrlMatcher = new UriMatcher(-1);
  
  static
  {
    sUrlMatcher.addURI("gmail-ls", "account/*/label/*", 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Intent localIntent2 = getIntent();
    Object localObject4 = localIntent2.getAction();
    Intent localIntent1 = null;
    Object localObject3 = null;
    Object localObject2;
    Object localObject1;
    if ((localObject4 == null) && (localIntent2.hasExtra("label")) && (localIntent2.hasExtra("account")))
    {
      localObject2 = localIntent2.getStringExtra("label");
      localObject1 = localIntent2.getStringExtra("account");
    }
    for (;;)
    {
      localIntent1 = localIntent2;
      if (localObject1 != null)
      {
        localIntent1 = localIntent2;
        if (localObject2 != null) {
          localIntent1 = Utils.createViewFolderIntent(this, (String)localObject1, (String)localObject2);
        }
      }
      setIntent(localIntent1);
      super.onCreate(paramBundle);
      return;
      localObject1 = localIntent1;
      localObject2 = localObject3;
      if ("android.intent.action.VIEW".equals(localObject4))
      {
        localObject1 = localIntent1;
        localObject2 = localObject3;
        if (localIntent2.getData() != null)
        {
          localObject4 = localIntent2.getData();
          localObject1 = localIntent1;
          localObject2 = localObject3;
          if (sUrlMatcher.match((Uri)localObject4) != -1)
          {
            localObject2 = localIntent2.getData().getPathSegments();
            localObject1 = (String)((List)localObject2).get(1);
            localObject2 = (String)((List)localObject2).get(3);
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ui.MailActivityGmail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */