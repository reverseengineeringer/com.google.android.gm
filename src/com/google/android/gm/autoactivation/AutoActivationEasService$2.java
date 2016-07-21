package com.google.android.gm.autoactivation;

import android.os.Bundle;
import android.os.ResultReceiver;

class AutoActivationEasService$2
  extends ResultReceiver
{
  AutoActivationEasService$2(AutoActivationEasService paramAutoActivationEasService)
  {
    super(null);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramInt == -1)
    {
      AutoActivationEasService.c = true;
      AutoActivationEasService.a(a, paramBundle, 3);
      return;
    }
    a.a();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.autoactivation.AutoActivationEasService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */