import android.util.SparseArray;

public final class alg
{
  public int a = -1;
  public int b = 1;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public boolean f = false;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public boolean j = false;
  public boolean k = false;
  private SparseArray<Object> l;
  
  public final int a()
  {
    if (g) {
      return d - e;
    }
    return c;
  }
  
  public final void a(int paramInt)
  {
    if ((b & paramInt) == 0) {
      throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(b));
    }
  }
  
  public final String toString()
  {
    return "State{mTargetPosition=" + a + ", mData=" + l + ", mItemCount=" + c + ", mPreviousLayoutItemCount=" + d + ", mDeletedInvisibleItemCountSincePreviousLayout=" + e + ", mStructureChanged=" + f + ", mInPreLayout=" + g + ", mRunSimpleAnimations=" + h + ", mRunPredictiveAnimations=" + i + '}';
  }
}

/* Location:
 * Qualified Name:     alg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */