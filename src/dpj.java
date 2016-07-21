import android.content.Loader.OnLoadCompleteListener;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;

final class dpj
  implements Loader.OnLoadCompleteListener<Cursor>
{
  final Handler a = new Handler(Looper.getMainLooper());
  final Runnable b = new dpk(this);
  
  dpj(dpf paramdpf) {}
}

/* Location:
 * Qualified Name:     dpj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */