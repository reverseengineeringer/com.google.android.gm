package com.android.mail.compose;

import android.content.Context;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.android.mail.providers.ReplyFromAccount;
import java.util.Iterator;
import java.util.List;

public class FromAddressSpinnerAdapter
  extends ArrayAdapter<ReplyFromAccount>
{
  public static int ACCOUNT_ADDRESS = 1;
  public static int ACCOUNT_DISPLAY;
  public static int REAL_ACCOUNT = 2;
  private static String sFormatString;
  private LayoutInflater mInflater;
  
  static
  {
    ACCOUNT_DISPLAY = 0;
  }
  
  public FromAddressSpinnerAdapter(Context paramContext)
  {
    super(paramContext, 2130968644, 2131755186);
    sFormatString = getContext().getString(2131492965);
  }
  
  private static CharSequence formatAddress(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return String.format(sFormatString, new Object[] { android.text.util.Rfc822Tokenizer.tokenize(paramString)[0].getAddress() });
  }
  
  public void addAccounts(List<ReplyFromAccount> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      add((ReplyFromAccount)paramList.next());
    }
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (ReplyFromAccount)getItem(paramInt);
    if (isCustomFrom) {}
    for (paramInt = 2130968630;; paramInt = 2130968643)
    {
      paramViewGroup = getInflater().inflate(paramInt, null);
      ((TextView)paramViewGroup.findViewById(2131755186)).setText(name);
      if (isCustomFrom) {
        ((TextView)paramViewGroup.findViewById(2131755187)).setText(formatAddress(address));
      }
      return paramViewGroup;
    }
  }
  
  protected LayoutInflater getInflater()
  {
    if (mInflater == null) {
      mInflater = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    }
    return mInflater;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (getItemisCustomFrom) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (ReplyFromAccount)getItem(paramInt);
    if (isCustomFrom)
    {
      paramInt = 2130968631;
      if (paramView != null) {
        break label83;
      }
      paramView = getInflater().inflate(paramInt, null);
    }
    label83:
    for (;;)
    {
      ((TextView)paramView.findViewById(2131755186)).setText(name);
      if (isCustomFrom) {
        ((TextView)paramView.findViewById(2131755187)).setText(formatAddress(address));
      }
      return paramView;
      paramInt = 2130968644;
      break;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.FromAddressSpinnerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */