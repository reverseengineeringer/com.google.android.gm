package com.android.mail.browse;

public abstract interface ScrollNotifier
{
  public abstract void addScrollListener(ScrollListener paramScrollListener);
  
  public abstract int computeHorizontalScrollExtent();
  
  public abstract int computeHorizontalScrollOffset();
  
  public abstract int computeHorizontalScrollRange();
  
  public abstract int computeVerticalScrollExtent();
  
  public abstract int computeVerticalScrollOffset();
  
  public abstract int computeVerticalScrollRange();
  
  public static abstract interface ScrollListener
  {
    public abstract void onNotifierScroll(int paramInt1, int paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ScrollNotifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */