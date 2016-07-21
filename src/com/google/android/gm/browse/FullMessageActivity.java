package com.google.android.gm.browse;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import buc;
import buj;
import cjp;
import cuo;
import dev;
import die;
import dyv;

public class FullMessageActivity
  extends cjp
{
  protected final void a(String paramString)
  {
    dev.a(this);
    new dyv().a(this, n, getString(buj.aV), null);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      Object localObject = getIntent();
      paramBundle = ((Intent)localObject).getStringExtra("permalink");
      String str = ((Intent)localObject).getStringExtra("account-name");
      localObject = ((Intent)localObject).getStringExtra("server-message-id");
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      int i = buc.eh;
      die localdie = new die();
      Bundle localBundle = new Bundle(3);
      localBundle.putString("permalink", paramBundle);
      localBundle.putString("account-name", str);
      localBundle.putString("server-message-id", (String)localObject);
      localdie.setArguments(localBundle);
      localFragmentTransaction.add(i, localdie, "full_message_fragment");
      localFragmentTransaction.commit();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.browse.FullMessageActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */