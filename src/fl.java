import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.io.PrintWriter;

final class fl
  extends fp<fj>
{
  public fl(fj paramfj)
  {
    super(paramfj);
  }
  
  public final View a(int paramInt)
  {
    return a.findViewById(paramInt);
  }
  
  public final void a(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramBundle = a;
    j = true;
    if (paramInt == -1) {}
    try
    {
      en.a(paramBundle, paramIntent, -1, null);
      return;
    }
    finally
    {
      j = false;
    }
    if ((0xFFFF0000 & paramInt) != 0) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
    en.a(paramBundle, paramIntent, (paramBundle.a(paramFragment) + 1 << 16) + (0xFFFF & paramInt), null);
    j = false;
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    a.dump(paramString, null, paramPrintWriter, paramArrayOfString);
  }
  
  public final boolean a()
  {
    Window localWindow = a.getWindow();
    return (localWindow != null) && (localWindow.peekDecorView() != null);
  }
  
  public final boolean b()
  {
    return !a.isFinishing();
  }
  
  public final LayoutInflater c()
  {
    return a.getLayoutInflater().cloneInContext(a);
  }
  
  public final void d()
  {
    a.C_();
  }
  
  public final boolean e()
  {
    return a.getWindow() != null;
  }
  
  public final int f()
  {
    Window localWindow = a.getWindow();
    if (localWindow == null) {
      return 0;
    }
    return getAttributeswindowAnimations;
  }
}

/* Location:
 * Qualified Name:     fl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */