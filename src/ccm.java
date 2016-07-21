import android.content.Context;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public final class ccm
  extends ArrayAdapter<cha>
{
  private static String a;
  private LayoutInflater b;
  
  public ccm(Context paramContext)
  {
    super(paramContext, bue.M, buc.eU);
    a = getContext().getString(buj.bV);
  }
  
  private final LayoutInflater a()
  {
    if (b == null) {
      b = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    }
    return b;
  }
  
  private static CharSequence a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return String.format(a, new Object[] { android.text.util.Rfc822Tokenizer.tokenize(paramString)[0].getAddress() });
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (cha)getItem(paramInt);
    if (e) {}
    for (paramInt = bue.z;; paramInt = bue.L)
    {
      paramViewGroup = a().inflate(paramInt, null);
      if (!e) {
        break;
      }
      ((TextView)paramViewGroup.findViewById(buc.eV)).setText(c);
      ((TextView)paramViewGroup.findViewById(buc.eU)).setText(a(b));
      return paramViewGroup;
    }
    ((TextView)paramViewGroup.findViewById(buc.eU)).setText(b);
    return paramViewGroup;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    cha localcha = (cha)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = a().inflate(bue.M, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(buc.eV);
    if (e)
    {
      paramView.setText(c);
      paramView.setVisibility(0);
      ((TextView)paramViewGroup.findViewById(buc.eU)).setText(a(b));
      return paramViewGroup;
    }
    paramView.setVisibility(8);
    ((TextView)paramViewGroup.findViewById(buc.eU)).setText(b);
    return paramViewGroup;
  }
}

/* Location:
 * Qualified Name:     ccm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */