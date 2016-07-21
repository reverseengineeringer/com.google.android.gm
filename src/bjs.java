import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListPopupWindow;
import com.android.ex.chips.RecipientEditTextView;

public final class bjs
  implements AdapterView.OnItemClickListener
{
  public bjs(RecipientEditTextView paramRecipientEditTextView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a.j.setOnItemClickListener(null);
    a.a(a.m, ((bjk)paramAdapterView.getAdapter()).a(paramInt));
    paramAdapterView = Message.obtain(a.f, RecipientEditTextView.a);
    obj = a.j;
    a.f.sendMessageDelayed(paramAdapterView, 300L);
    a.clearComposingText();
  }
}

/* Location:
 * Qualified Name:     bjs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */