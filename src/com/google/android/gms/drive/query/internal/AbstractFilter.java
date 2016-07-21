package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.query.Filter;
import fgu;

public abstract class AbstractFilter
  implements Filter
{
  public String toString()
  {
    return String.format("Filter[%s]", new Object[] { a(new fgu()) });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.query.internal.AbstractFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */