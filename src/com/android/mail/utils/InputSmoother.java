package com.android.mail.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.google.common.collect.Lists;
import java.util.Deque;
import java.util.Iterator;

public class InputSmoother
{
  private final float mDensity;
  private final Deque<Sample> mRecentSamples = Lists.newLinkedList();
  
  public InputSmoother(Context paramContext)
  {
    mDensity = getResourcesgetDisplayMetricsdensity;
  }
  
  public Float getSmoothedVelocity()
  {
    if (mRecentSamples.size() < 2) {
      return null;
    }
    int j = 0;
    int i = mRecentSamples.getFirst()).pos;
    long l = mRecentSamples.getLast()).millis - mRecentSamples.getFirst()).millis;
    if (l <= 0L) {
      return null;
    }
    Iterator localIterator = mRecentSamples.iterator();
    while (localIterator.hasNext())
    {
      Sample localSample = (Sample)localIterator.next();
      j += Math.abs(pos - i);
      i = pos;
    }
    return Float.valueOf(1000.0F * (j / mDensity) / (float)l);
  }
  
  public void onInput(int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    Sample localSample = (Sample)mRecentSamples.peekLast();
    if ((localSample != null) && (l - millis > 200L)) {
      mRecentSamples.clear();
    }
    if (mRecentSamples.size() == 5) {}
    for (localSample = (Sample)mRecentSamples.removeFirst();; localSample = new Sample(null))
    {
      pos = paramInt;
      millis = l;
      mRecentSamples.add(localSample);
      return;
    }
  }
  
  private static class Sample
  {
    long millis;
    int pos;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.InputSmoother
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */