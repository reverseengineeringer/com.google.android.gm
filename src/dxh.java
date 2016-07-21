import android.widget.TextView;

final class dxh
  implements fsm
{
  dxh(dxf paramdxf) {}
  
  public final void a(fsn paramfsn, fyb paramfyb, boolean paramBoolean, int paramInt)
  {
    paramfsn = a;
    paramInt = b;
    if ((paramBoolean) || (paramInt <= 0))
    {
      paramfsn.setVisibility(8);
      return;
    }
    paramfsn.setVisibility(0);
    paramfsn.setText(cxa.a(paramfsn.getContext(), paramInt));
  }
}

/* Location:
 * Qualified Name:     dxh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */