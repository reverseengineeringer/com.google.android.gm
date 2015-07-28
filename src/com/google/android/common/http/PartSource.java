package com.google.android.common.http;

import java.io.IOException;
import java.io.InputStream;

public abstract interface PartSource
{
  public abstract InputStream createInputStream()
    throws IOException;
  
  public abstract String getFileName();
  
  public abstract long getLength();
}

/* Location:
 * Qualified Name:     com.google.android.common.http.PartSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */