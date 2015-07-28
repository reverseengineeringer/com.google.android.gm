package com.google.android.gm.provider;

import java.util.zip.Inflater;

final class ZipUtils$1
  extends Inflater
{
  ZipUtils$1(byte[] paramArrayOfByte) {}
  
  public boolean needsDictionary()
  {
    if (super.needsDictionary()) {
      setDictionary(val$dict);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.ZipUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */