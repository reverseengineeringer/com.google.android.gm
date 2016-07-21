import android.app.UiModeManager;
import android.content.Context;
import android.view.Window;
import android.view.Window.Callback;

final class aaq
  extends aao
{
  private final UiModeManager z;
  
  aaq(Context paramContext, Window paramWindow, aai paramaai)
  {
    super(paramContext, paramWindow, paramaai);
    z = ((UiModeManager)paramContext.getSystemService("uimode"));
  }
  
  final Window.Callback a(Window.Callback paramCallback)
  {
    return new aar(this, paramCallback);
  }
  
  final int f(int paramInt)
  {
    if ((paramInt == 0) && (z.getNightMode() == 0)) {
      return -1;
    }
    return super.f(paramInt);
  }
}

/* Location:
 * Qualified Name:     aaq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */