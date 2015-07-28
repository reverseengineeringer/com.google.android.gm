package com.google.android.gm;

import android.text.Html;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddress
{
  private static final Matcher sEmailMatcher = Pattern.compile("\\\"?([^\"<]*?)\\\"?\\s*<(.*)>").matcher("");
  private final String mAddress;
  private final String mName;
  
  private EmailAddress(String paramString1, String paramString2)
  {
    mName = paramString1;
    mAddress = paramString2;
  }
  
  public static EmailAddress getEmailAddress(String paramString)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = sEmailMatcher.reset(paramString);
        Object localObject2;
        if (((Matcher)localObject1).matches())
        {
          localObject2 = ((Matcher)localObject1).group(1);
          paramString = ((Matcher)localObject1).group(2);
          if (localObject2 == null)
          {
            localObject1 = "";
            break label145;
            paramString = new EmailAddress((String)localObject1, paramString);
            return paramString;
          }
          else
          {
            localObject1 = Html.fromHtml(((String)localObject2).trim()).toString();
            break label145;
            paramString = Html.fromHtml(paramString).toString();
            continue;
          }
        }
        else
        {
          localObject2 = Rfc822Tokenizer.tokenize(paramString);
          if (localObject2.length <= 0) {
            break label161;
          }
          paramString = localObject2[0].getName();
          if (paramString == null) {
            break label155;
          }
          localObject1 = Html.fromHtml(paramString.trim()).toString();
          paramString = Html.fromHtml(localObject2[0].getAddress()).toString();
          continue;
          paramString = Html.fromHtml(paramString).toString();
        }
      }
      finally {}
      label145:
      if (paramString == null)
      {
        paramString = "";
        continue;
        label155:
        localObject1 = "";
        continue;
        label161:
        localObject1 = "";
        if (paramString == null) {
          paramString = "";
        }
      }
    }
  }
  
  public String getAddress()
  {
    return mAddress;
  }
  
  String getName()
  {
    return mName;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.EmailAddress
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */