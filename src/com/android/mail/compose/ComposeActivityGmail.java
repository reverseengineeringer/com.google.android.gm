package com.android.mail.compose;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gm.provider.UiProvider;

public class ComposeActivityGmail
  extends ComposeActivity
{
  public void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    if ((localIntent.getExtras() != null) && (localIntent.getExtras().containsKey("in-reference-to")))
    {
      localIntent.putExtra("in-reference-to-message-uri", UiProvider.getMessageByIdUri(localIntent.getStringExtra("account"), localIntent.getExtras().getLong("in-reference-to")));
      int j = localIntent.getIntExtra("action", -1);
      int i;
      if (j != 1)
      {
        i = j;
        if (j != -1) {}
      }
      else
      {
        i = 0;
      }
      localIntent.putExtra("action", i);
    }
    super.onCreate(paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.ComposeActivityGmail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */