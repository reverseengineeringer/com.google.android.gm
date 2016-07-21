import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

final class aec
  extends FrameLayout
  implements adb
{
  final CollapsibleActionView a;
  
  aec(View paramView)
  {
    super(paramView.getContext());
    a = ((CollapsibleActionView)paramView);
    addView(paramView);
  }
  
  public final void a()
  {
    a.onActionViewExpanded();
  }
  
  public final void b()
  {
    a.onActionViewCollapsed();
  }
}

/* Location:
 * Qualified Name:     aec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */