package com.google.android.common.http;

import java.util.regex.Pattern;

public class UrlRules$Rule
  implements Comparable
{
  public static final Rule DEFAULT = new Rule();
  public final boolean mBlock;
  public final String mName;
  public final String mPrefix;
  public final String mRewrite;
  
  private UrlRules$Rule()
  {
    mName = "DEFAULT";
    mPrefix = "";
    mRewrite = null;
    mBlock = false;
  }
  
  public UrlRules$Rule(String paramString1, String paramString2)
    throws UrlRules.RuleFormatException
  {
    mName = paramString1;
    String[] arrayOfString = UrlRules.access$000().split(paramString2);
    if (arrayOfString.length == 0) {
      throw new UrlRules.RuleFormatException("Empty rule");
    }
    mPrefix = arrayOfString[0];
    paramString1 = null;
    boolean bool = false;
    int i = 1;
    while (i < arrayOfString.length)
    {
      String str = arrayOfString[i].toLowerCase();
      if ((str.equals("rewrite")) && (i + 1 < arrayOfString.length))
      {
        paramString1 = arrayOfString[(i + 1)];
        i += 2;
      }
      else if (str.equals("block"))
      {
        bool = true;
        i += 1;
      }
      else
      {
        throw new UrlRules.RuleFormatException("Illegal rule: " + paramString2);
      }
    }
    mRewrite = paramString1;
    mBlock = bool;
  }
  
  public String apply(String paramString)
  {
    String str;
    if (mBlock) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (mRewrite == null);
    return mRewrite + paramString.substring(mPrefix.length());
  }
  
  public int compareTo(Object paramObject)
  {
    return mPrefix.compareTo(mPrefix);
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.http.UrlRules.Rule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */