package com.android.mail.browse;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import com.android.mail.providers.Address;
import java.util.Map;

class MessageHeaderView$RecipientListsBuilder
{
  private final Map<String, Address> mAddressCache;
  private final SpannableStringBuilder mBuilder = new SpannableStringBuilder();
  private final CharSequence mComma;
  private final Context mContext;
  boolean mFirst = true;
  private final String mMe;
  int mRecipientCount = 0;
  
  public MessageHeaderView$RecipientListsBuilder(Context paramContext, String paramString, Map<String, Address> paramMap)
  {
    mContext = paramContext;
    mMe = paramString;
    mComma = mContext.getText(2131493073);
    mAddressCache = paramMap;
  }
  
  private CharSequence getSummaryTextForHeading(int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramInt2 == 0)) {
      localObject = null;
    }
    SpannableStringBuilder localSpannableStringBuilder;
    int i;
    do
    {
      return (CharSequence)localObject;
      localSpannableStringBuilder = new SpannableStringBuilder(mContext.getString(paramInt1));
      localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(' ');
      i = Math.min(paramInt2, paramArrayOfString.length);
      paramInt2 = 1;
      paramInt1 = 0;
      localObject = localSpannableStringBuilder;
    } while (paramInt1 >= i);
    Object localObject = MessageHeaderView.access$100(mAddressCache, paramArrayOfString[paramInt1]);
    if (mMe.equals(((Address)localObject).getAddress()))
    {
      localObject = mContext.getString(2131493019);
      label125:
      if (paramInt2 == 0) {
        break label156;
      }
      paramInt2 = 0;
    }
    for (;;)
    {
      localSpannableStringBuilder.append((CharSequence)localObject);
      paramInt1 += 1;
      break;
      localObject = ((Address)localObject).getSimplifiedName();
      break label125;
      label156:
      localSpannableStringBuilder.append(mComma);
    }
  }
  
  public void append(String[] paramArrayOfString, int paramInt)
  {
    int i = 50 - mRecipientCount;
    CharSequence localCharSequence = getSummaryTextForHeading(paramInt, paramArrayOfString, i);
    if (localCharSequence != null)
    {
      if (!mFirst) {
        break label60;
      }
      mFirst = false;
    }
    for (;;)
    {
      mBuilder.append(localCharSequence);
      mRecipientCount += Math.min(i, paramArrayOfString.length);
      return;
      label60:
      mBuilder.append("   ");
    }
  }
  
  public CharSequence build()
  {
    return mBuilder;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageHeaderView.RecipientListsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */