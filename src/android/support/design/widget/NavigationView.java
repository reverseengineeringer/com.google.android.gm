package android.support.design.widget;

import adu;
import aej;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import l;
import o;

public final class NavigationView
  extends o
{
  private static final int[] a = { 16842912 };
  private static final int[] b = { -16842910 };
  private final l c;
  private int d;
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    switch (View.MeasureSpec.getMode(paramInt1))
    {
    default: 
      i = paramInt1;
    }
    for (;;)
    {
      super.onMeasure(i, paramInt2);
      return;
      i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), d), 1073741824);
      continue;
      i = View.MeasureSpec.makeMeasureSpec(d, 1073741824);
    }
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof NavigationView.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    for (;;)
    {
      return;
      Object localObject1 = (NavigationView.SavedState)paramParcelable;
      super.onRestoreInstanceState(((NavigationView.SavedState)localObject1).getSuperState());
      paramParcelable = c;
      localObject1 = a.getSparseParcelableArray("android:menu:presenters");
      if ((localObject1 != null) && (!j.isEmpty()))
      {
        Iterator localIterator = j.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (WeakReference)localIterator.next();
          aej localaej = (aej)((WeakReference)localObject2).get();
          if (localaej == null)
          {
            j.remove(localObject2);
          }
          else
          {
            int i = localaej.b();
            if (i > 0)
            {
              localObject2 = (Parcelable)((SparseArray)localObject1).get(i);
              if (localObject2 != null) {
                localaej.a((Parcelable)localObject2);
              }
            }
          }
        }
      }
    }
  }
  
  protected final Parcelable onSaveInstanceState()
  {
    NavigationView.SavedState localSavedState = new NavigationView.SavedState(super.onSaveInstanceState());
    a = new Bundle();
    c.a(a);
    return localSavedState;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.NavigationView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */