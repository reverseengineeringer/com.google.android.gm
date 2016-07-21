package com.google.android.gm.autoactivation;

import android.os.Bundle;
import android.os.ResultReceiver;

class AutoActivationEasService$1
  extends ResultReceiver
{
  AutoActivationEasService$1(AutoActivationEasService paramAutoActivationEasService)
  {
    super(null);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramInt == -1)
    {
      AutoActivationEasService.a(a, paramBundle, 1);
      return;
    }
    a.a();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.autoactivation.AutoActivationEasService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */