package com.android.exchange.provider;

import brk;
import java.util.ArrayList;

public class GalResult
{
  public int a;
  public ArrayList<brk> b = new ArrayList();
  
  public void addGalData(long paramLong, String paramString1, String paramString2)
  {
    b.add(new brk(paramLong, paramString1, paramString2));
  }
  
  public void addGalData(brk parambrk)
  {
    b.add(parambrk);
  }
}

/* Location:
 * Qualified Name:     com.android.exchange.provider.GalResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */