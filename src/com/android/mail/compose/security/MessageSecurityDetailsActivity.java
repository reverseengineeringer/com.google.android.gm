package com.android.mail.compose.security;

import aah;
import aaj;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import buc;
import bue;
import buj;
import ccv;
import zc;
import zh;

public class MessageSecurityDetailsActivity
  extends zh
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    f().a().b(buj.ac);
    setContentView(bue.d);
    paramBundle = new ccv(this, getIntent().getParcelableArrayListExtra("recipients"));
    ((ListView)findViewById(buc.aa)).setAdapter(paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.security.MessageSecurityDetailsActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */