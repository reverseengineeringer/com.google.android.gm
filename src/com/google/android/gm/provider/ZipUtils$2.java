package com.google.android.gm.provider;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

final class ZipUtils$2
  extends InflaterInputStream
{
  ZipUtils$2(InputStream paramInputStream, Inflater paramInflater)
  {
    super(paramInputStream, paramInflater);
  }
  
  public void close()
    throws IOException
  {
    super.close();
    inf.end();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.ZipUtils.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */