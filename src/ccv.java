import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mail.compose.security.MessageSecurityRecipient;
import java.util.ArrayList;

public final class ccv
  extends BaseAdapter
{
  private final Context a;
  private final ArrayList<MessageSecurityRecipient> b;
  private final cff c;
  
  public ccv(Context paramContext, ArrayList paramArrayList)
  {
    a = paramContext;
    b = paramArrayList;
    c = new cff(paramContext.getResources());
  }
  
  private final MessageSecurityRecipient a(int paramInt)
  {
    if (paramInt == 0) {
      return null;
    }
    return (MessageSecurityRecipient)b.get(paramInt - 1);
  }
  
  public final int getCount()
  {
    return b.size() + 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageSecurityRecipient localMessageSecurityRecipient = a(paramInt);
    ccw localccw;
    float f;
    cff localcff;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(a).inflate(bue.e, paramViewGroup, false);
      localccw = new ccw(this);
      a = ((ImageView)paramViewGroup.findViewById(buc.X));
      b = ((TextView)paramViewGroup.findViewById(buc.Z));
      c = ((TextView)paramViewGroup.findViewById(buc.W));
      d = ((TextView)paramViewGroup.findViewById(buc.Y));
      e = ((ImageView)paramViewGroup.findViewById(buc.V));
      paramViewGroup.setTag(localccw);
      if (paramInt == 0) {
        break label489;
      }
      f = 88.0F;
      a.setVisibility(4);
      b.setText(a);
      c.setText(b);
      d.setText(a.getResources().getString(buj.X, new Object[] { c }));
      d.setVisibility(0);
      ImageView localImageView = e;
      paramView = a.getResources();
      localcff = c;
      if (e == null) {
        break label351;
      }
      paramView = e;
      localImageView.setImageBitmap(paramView);
      e.setVisibility(0);
      if (!a.equals(b)) {
        break label435;
      }
      paramView = a.getResources().getString(buj.ab, new Object[] { c.getText(), d.getText() });
    }
    for (;;)
    {
      paramViewGroup.setMinimumHeight((int)TypedValue.applyDimension(1, f, a.getResources().getDisplayMetrics()));
      paramViewGroup.setContentDescription(paramView);
      return paramViewGroup;
      localccw = (ccw)paramView.getTag();
      paramViewGroup = paramView;
      break;
      label351:
      if (d == null) {}
      for (paramView = localcff.a(new cop((int)paramView.getDimension(bua.n), (int)paramView.getDimension(bua.m)), a, b);; paramView = BitmapFactory.decodeByteArray(d, 0, d.length))
      {
        e = cts.a(paramView);
        paramView = e;
        break;
      }
      label435:
      paramView = a.getResources().getString(buj.aa, new Object[] { b.getText(), c.getText(), d.getText() });
      continue;
      label489:
      f = 72.0F;
      a.setVisibility(0);
      b.setText(buj.Y);
      c.setText(a.getResources().getQuantityString(buh.a, b.size(), new Object[] { Integer.valueOf(b.size()) }));
      d.setVisibility(8);
      e.setVisibility(8);
      paramView = a.getResources().getString(buj.Z, new Object[] { b.getText(), c.getText() });
    }
  }
}

/* Location:
 * Qualified Name:     ccv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */