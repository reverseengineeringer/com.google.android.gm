package com.android.mail.providers;

import android.text.Html;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import com.android.common.Rfc822Validator;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.james.mime4j.decoder.DecoderUtil;

public class Address
{
  private static final Address[] EMPTY_ADDRESS_ARRAY = new Address[0];
  private static final String LOG_TAG = LogTag.getLogTag();
  private static final Pattern REMOVE_OPTIONAL_BRACKET = Pattern.compile("^<?([^>]+)>?$");
  private static final Pattern REMOVE_OPTIONAL_DQUOTE = Pattern.compile("^\"?([^\"]*)\"?$");
  private static final Pattern UNQUOTE = Pattern.compile("\\\\([\\\\\"])");
  private String mAddress;
  private String mName;
  private String mSimplifiedName;
  
  public Address(String paramString1, String paramString2)
  {
    setName(paramString1);
    setAddress(paramString2);
  }
  
  public static Address getEmailAddress(String paramString)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool)
        {
          paramString = null;
          return paramString;
        }
        localObject = Rfc822Tokenizer.tokenize(paramString);
        if (localObject.length <= 0) {
          break label104;
        }
        paramString = localObject[0].getName();
        if (paramString != null)
        {
          paramString = Html.fromHtml(paramString.trim()).toString();
          String str = Html.fromHtml(localObject[0].getAddress()).toString();
          localObject = paramString;
          paramString = str;
          paramString = new Address((String)localObject, paramString);
          continue;
        }
        paramString = "";
      }
      finally {}
      continue;
      label104:
      do
      {
        paramString = Html.fromHtml(paramString).toString();
        break;
        localObject = "";
      } while (paramString != null);
      paramString = "";
    }
  }
  
  static boolean isValidAddress(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return false;
      i = paramString.indexOf("@");
    } while (i == -1);
    return new Rfc822Validator(paramString.substring(0, i)).isValid(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Address)) {
      return getAddress().equals(((Address)paramObject).getAddress());
    }
    return super.equals(paramObject);
  }
  
  public String getAddress()
  {
    return mAddress;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public String getSimplifiedName()
  {
    int i;
    String str;
    if (mSimplifiedName == null)
    {
      if ((!TextUtils.isEmpty(mName)) || (TextUtils.isEmpty(mAddress))) {
        break label68;
      }
      i = mAddress.indexOf('@');
      if (i == -1) {
        break label62;
      }
      str = mAddress.substring(0, i);
      mSimplifiedName = str;
    }
    for (;;)
    {
      return mSimplifiedName;
      label62:
      str = "";
      break;
      label68:
      if (!TextUtils.isEmpty(mName))
      {
        i = mName.indexOf(' ');
        while ((i > 0) && (mName.charAt(i - 1) == ',')) {
          i -= 1;
        }
        if (i < 1) {}
        for (str = mName;; str = mName.substring(0, i))
        {
          mSimplifiedName = str;
          break;
        }
      }
      LogUtils.w(LOG_TAG, "Unable to get a simplified name", new Object[0]);
      mSimplifiedName = "";
    }
  }
  
  public void setAddress(String paramString)
  {
    mAddress = REMOVE_OPTIONAL_BRACKET.matcher(paramString).replaceAll("$1");
  }
  
  public void setName(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      paramString = REMOVE_OPTIONAL_DQUOTE.matcher(paramString).replaceAll("$1");
      paramString = DecoderUtil.decodeEncodedWords(UNQUOTE.matcher(paramString).replaceAll("$1"));
      str = paramString;
      if (paramString.length() == 0) {
        str = null;
      }
    }
    mName = str;
  }
  
  public String toString()
  {
    if ((mName != null) && (!mName.equals(mAddress)))
    {
      if (mName.matches(".*[\\(\\)<>@,;:\\\\\".\\[\\]].*")) {
        return Utils.ensureQuotedString(mName) + " <" + mAddress + ">";
      }
      return mName + " <" + mAddress + ">";
    }
    return mAddress;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Address
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */