import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;

public final class gjf
  extends DialogFragment
{
  WebView a;
  Runnable b;
  private ViewGroup c;
  
  final void a()
  {
    if ((a != null) && (c != null))
    {
      ViewGroup localViewGroup = (ViewGroup)a.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(a);
      }
      c.addView(a, 0, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (b != null) {
      b.run();
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setCancelable(true);
    paramLayoutInflater = paramLayoutInflater.inflate(gjp.a, paramViewGroup, false);
    c = ((ViewGroup)paramLayoutInflater.findViewById(gjo.a));
    a();
    return paramLayoutInflater;
  }
}

/* Location:
 * Qualified Name:     gjf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */