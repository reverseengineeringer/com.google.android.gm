import android.app.Activity;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public abstract class ckn
  extends DialogFragment
  implements DialogInterface.OnClickListener, View.OnClickListener
{
  private static final String a = cvl.a;
  
  static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "cancel";
    case -1: 
      return "accept";
    }
    return "decline";
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected final aag a(Spanned paramSpanned)
  {
    View localView = getActivity().getLayoutInflater().inflate(bue.ad, null);
    ((TextView)localView.findViewById(buc.ec)).setText(paramSpanned);
    paramSpanned = localView.findViewById(buc.eb);
    if (a() != 0)
    {
      paramSpanned.setOnClickListener(this);
      paramSpanned.setVisibility(0);
    }
    for (;;)
    {
      return new aag(getActivity()).a(localView);
      paramSpanned.setVisibility(8);
    }
  }
  
  abstract void a(int paramInt);
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    a(0);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = (ckv)getActivity();
    if (localObject != null)
    {
      localObject = ((ckv)localObject).k().ad();
      if (localObject != null)
      {
        a(paramInt);
        ((DialogInterface.OnClickListener)localObject).onClick(paramDialogInterface, paramInt);
        return;
      }
    }
    cvm.d(a, "Failed to get DialogListener for Report Spam dialog", new Object[0]);
  }
  
  public void onClick(View paramView)
  {
    int i = a();
    if ((paramView.getId() == buc.eb) && (i != 0))
    {
      paramView = getActivity();
      ((btr)paramView.getApplication()).a().a(paramView, i);
    }
  }
}

/* Location:
 * Qualified Name:     ckn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */