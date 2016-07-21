import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.android.mail.providers.Account;
import com.android.mail.ui.MailboxSelectionActivity;

public final class cow
  extends SimpleCursorAdapter
{
  public cow(MailboxSelectionActivity paramMailboxSelectionActivity, Context paramContext, int paramInt, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramContext, paramInt, paramCursor, paramArrayOfString, paramArrayOfInt, 0);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = (TextView)paramView.findViewById(buc.cx);
    Account.b();
    paramViewGroup.setText(agetItema);
    return paramView;
  }
}

/* Location:
 * Qualified Name:     cow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */