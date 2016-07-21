import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.android.mail.providers.Folder;
import java.util.Set;

public class col
  extends coe
{
  private final Context b;
  
  public col(Context paramContext, Cursor paramCursor, int paramInt, Folder paramFolder)
  {
    super(paramContext, paramCursor, paramInt, paramFolder);
    b = paramContext;
  }
  
  public col(Context paramContext, Cursor paramCursor, Set<String> paramSet, int paramInt)
  {
    super(paramContext, paramCursor, paramSet, paramInt);
    b = paramContext;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = super.getView(paramInt, paramView, paramViewGroup);
    cuq localcuq = (cuq)getItem(paramInt);
    Folder localFolder = a;
    CompoundButton localCompoundButton = (CompoundButton)paramViewGroup.findViewById(buc.ae);
    TextView localTextView = (TextView)paramViewGroup.findViewById(buc.bB);
    if (TextUtils.isEmpty(c))
    {
      paramView = d;
      if (localCompoundButton == null) {
        break label131;
      }
      if (!TextUtils.isEmpty(c)) {
        break label115;
      }
    }
    label115:
    for (paramView = d;; paramView = cup.a(c, b))
    {
      localCompoundButton.setText(paramView, TextView.BufferType.SPANNABLE);
      return paramViewGroup;
      paramView = cup.a(c, b);
      break;
    }
    label131:
    localTextView.setText(paramView, TextView.BufferType.SPANNABLE);
    return paramViewGroup;
  }
}

/* Location:
 * Qualified Name:     col
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */