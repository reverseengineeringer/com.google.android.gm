import android.util.Log;

final class gls
  implements gmd
{
  public final void a(Throwable paramThrowable)
  {
    if (Log.isLoggable("PrimesExecutor", 5)) {
      Log.w("PrimesExecutor", "Background task failed", paramThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     gls
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */