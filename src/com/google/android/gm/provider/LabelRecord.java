package com.google.android.gm.provider;

class LabelRecord
{
  public long dateReceived = 0L;
  public boolean isZombie = true;
  public long sortMessageId = 0L;
  
  public LabelRecord() {}
  
  public LabelRecord(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    sortMessageId = paramLong1;
    dateReceived = paramLong2;
    isZombie = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.LabelRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */