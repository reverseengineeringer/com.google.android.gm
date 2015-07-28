package com.google.android.common.http;

import android.content.ContentResolver;
import android.util.Log;
import com.google.android.gsf.Gservices;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlRules
{
  private static final Pattern PATTERN_SPACE_PLUS = Pattern.compile(" +");
  private static final Pattern RULE_PATTERN = Pattern.compile("\\W");
  private static UrlRules sCachedRules = new UrlRules(new Rule[0]);
  private static Object sCachedVersionToken;
  private final Pattern mPattern;
  private final Rule[] mRules;
  
  public UrlRules(Rule[] paramArrayOfRule)
  {
    Arrays.sort(paramArrayOfRule);
    StringBuilder localStringBuilder = new StringBuilder("(");
    int i = 0;
    while (i < paramArrayOfRule.length)
    {
      if (i > 0) {
        localStringBuilder.append(")|(");
      }
      localStringBuilder.append(RULE_PATTERN.matcher(mPrefix).replaceAll("\\\\$0"));
      i += 1;
    }
    mPattern = Pattern.compile(")");
    mRules = paramArrayOfRule;
  }
  
  public static UrlRules getRules(ContentResolver paramContentResolver)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = Gservices.getVersionToken(paramContentResolver);
        if (localObject1 == sCachedVersionToken)
        {
          if (Log.isLoggable("UrlRules", 2)) {
            Log.v("UrlRules", "Using cached rules, versionToken: " + localObject1);
          }
          paramContentResolver = sCachedRules;
          return paramContentResolver;
        }
        if (Log.isLoggable("UrlRules", 2)) {
          Log.v("UrlRules", "Scanning for Gservices \"url:*\" rules");
        }
        Object localObject2 = Gservices.getStringsByPrefix(paramContentResolver, new String[] { "url:" });
        paramContentResolver = new ArrayList();
        localObject2 = ((Map)localObject2).entrySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
          try
          {
            String str = ((String)((Map.Entry)localObject3).getKey()).substring(4);
            localObject3 = (String)((Map.Entry)localObject3).getValue();
            if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
              continue;
            }
            if (Log.isLoggable("UrlRules", 2)) {
              Log.v("UrlRules", "  Rule " + str + ": " + (String)localObject3);
            }
            paramContentResolver.add(new Rule(str, (String)localObject3));
          }
          catch (RuleFormatException localRuleFormatException)
          {
            Log.e("UrlRules", "Invalid rule from Gservices", localRuleFormatException);
          }
          continue;
        }
        sCachedRules = new UrlRules((Rule[])paramContentResolver.toArray(new Rule[paramContentResolver.size()]));
      }
      finally {}
      sCachedVersionToken = localObject1;
      if (Log.isLoggable("UrlRules", 2)) {
        Log.v("UrlRules", "New rules stored, versionToken: " + localObject1);
      }
      paramContentResolver = sCachedRules;
    }
  }
  
  public Rule matchRule(String paramString)
  {
    paramString = mPattern.matcher(paramString);
    if (paramString.lookingAt())
    {
      int i = 0;
      while (i < mRules.length)
      {
        if (paramString.group(i + 1) != null) {
          return mRules[i];
        }
        i += 1;
      }
    }
    return Rule.DEFAULT;
  }
  
  public static class Rule
    implements Comparable
  {
    public static final Rule DEFAULT = new Rule();
    public final boolean mBlock;
    public final String mName;
    public final String mPrefix;
    public final String mRewrite;
    
    private Rule()
    {
      mName = "DEFAULT";
      mPrefix = "";
      mRewrite = null;
      mBlock = false;
    }
    
    public Rule(String paramString1, String paramString2)
      throws UrlRules.RuleFormatException
    {
      mName = paramString1;
      String[] arrayOfString = UrlRules.PATTERN_SPACE_PLUS.split(paramString2);
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
  
  public static class RuleFormatException
    extends Exception
  {
    public RuleFormatException(String paramString)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.http.UrlRules
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */