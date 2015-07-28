package com.android.mail.providers;

public final class UIProvider$SyncStatus
{
  public static boolean isSyncInProgress(int paramInt)
  {
    return (paramInt & 0x27) != 0;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.UIProvider.SyncStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */