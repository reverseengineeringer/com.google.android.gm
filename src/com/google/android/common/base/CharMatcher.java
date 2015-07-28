package com.google.android.common.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class CharMatcher
{
  public static final CharMatcher ANY = new CharMatcher()
  {
    public String collapseFrom(CharSequence paramAnonymousCharSequence, char paramAnonymousChar)
    {
      if (paramAnonymousCharSequence.length() == 0) {
        return "";
      }
      return String.valueOf(paramAnonymousChar);
    }
    
    public int indexIn(CharSequence paramAnonymousCharSequence)
    {
      if (paramAnonymousCharSequence.length() == 0) {
        return -1;
      }
      return 0;
    }
    
    public int indexIn(CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
    {
      int j = paramAnonymousCharSequence.length();
      Preconditions.checkPositionIndex(paramAnonymousInt, j);
      int i = paramAnonymousInt;
      if (paramAnonymousInt == j) {
        i = -1;
      }
      return i;
    }
    
    public boolean matches(char paramAnonymousChar)
    {
      return true;
    }
    
    public CharMatcher negate()
    {
      return NONE;
    }
    
    public CharMatcher or(CharMatcher paramAnonymousCharMatcher)
    {
      Preconditions.checkNotNull(paramAnonymousCharMatcher);
      return this;
    }
    
    public CharMatcher precomputed()
    {
      return this;
    }
    
    public String removeFrom(CharSequence paramAnonymousCharSequence)
    {
      Preconditions.checkNotNull(paramAnonymousCharSequence);
      return "";
    }
    
    public String replaceFrom(CharSequence paramAnonymousCharSequence, char paramAnonymousChar)
    {
      paramAnonymousCharSequence = new char[paramAnonymousCharSequence.length()];
      Arrays.fill(paramAnonymousCharSequence, paramAnonymousChar);
      return new String(paramAnonymousCharSequence);
    }
    
    public String replaceFrom(CharSequence paramAnonymousCharSequence1, CharSequence paramAnonymousCharSequence2)
    {
      StringBuilder localStringBuilder = new StringBuilder(paramAnonymousCharSequence1.length() * paramAnonymousCharSequence2.length());
      int i = 0;
      while (i < paramAnonymousCharSequence1.length())
      {
        localStringBuilder.append(paramAnonymousCharSequence2);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public String trimFrom(CharSequence paramAnonymousCharSequence)
    {
      Preconditions.checkNotNull(paramAnonymousCharSequence);
      return "";
    }
  };
  public static final CharMatcher ASCII;
  public static final CharMatcher BREAKING_WHITESPACE;
  public static final CharMatcher DIGIT;
  public static final CharMatcher INVISIBLE;
  public static final CharMatcher JAVA_DIGIT;
  public static final CharMatcher JAVA_ISO_CONTROL;
  public static final CharMatcher JAVA_LETTER;
  public static final CharMatcher JAVA_LETTER_OR_DIGIT;
  public static final CharMatcher JAVA_LOWER_CASE;
  public static final CharMatcher JAVA_UPPER_CASE;
  public static final CharMatcher JAVA_WHITESPACE;
  @Deprecated
  public static final CharMatcher LEGACY_WHITESPACE;
  public static final CharMatcher NONE = new CharMatcher()
  {
    public String collapseFrom(CharSequence paramAnonymousCharSequence, char paramAnonymousChar)
    {
      return paramAnonymousCharSequence.toString();
    }
    
    public int indexIn(CharSequence paramAnonymousCharSequence)
    {
      Preconditions.checkNotNull(paramAnonymousCharSequence);
      return -1;
    }
    
    public int indexIn(CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
    {
      Preconditions.checkPositionIndex(paramAnonymousInt, paramAnonymousCharSequence.length());
      return -1;
    }
    
    public boolean matches(char paramAnonymousChar)
    {
      return false;
    }
    
    public CharMatcher negate()
    {
      return ANY;
    }
    
    public CharMatcher or(CharMatcher paramAnonymousCharMatcher)
    {
      return (CharMatcher)Preconditions.checkNotNull(paramAnonymousCharMatcher);
    }
    
    public CharMatcher precomputed()
    {
      return this;
    }
    
    public String removeFrom(CharSequence paramAnonymousCharSequence)
    {
      return paramAnonymousCharSequence.toString();
    }
    
    public String replaceFrom(CharSequence paramAnonymousCharSequence, char paramAnonymousChar)
    {
      return paramAnonymousCharSequence.toString();
    }
    
    public String replaceFrom(CharSequence paramAnonymousCharSequence1, CharSequence paramAnonymousCharSequence2)
    {
      Preconditions.checkNotNull(paramAnonymousCharSequence2);
      return paramAnonymousCharSequence1.toString();
    }
    
    protected void setBits(CharMatcher.LookupTable paramAnonymousLookupTable) {}
    
    public String trimFrom(CharSequence paramAnonymousCharSequence)
    {
      return paramAnonymousCharSequence.toString();
    }
  };
  public static final CharMatcher SINGLE_WIDTH;
  public static final CharMatcher WHITESPACE = anyOf("\t\n\013\f\r     　 ᠎ ").or(inRange(' ', ' '));
  
  static
  {
    BREAKING_WHITESPACE = anyOf("\t\n\013\f\r     　").or(inRange(' ', ' ')).or(inRange(' ', ' '));
    ASCII = inRange('\000', '');
    CharMatcher localCharMatcher = inRange('0', '9');
    char[] arrayOfChar = "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
    int j = arrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = arrayOfChar[i];
      localCharMatcher = localCharMatcher.or(inRange(c, (char)(c + '\t')));
      i += 1;
    }
    DIGIT = localCharMatcher;
    JAVA_WHITESPACE = inRange('\t', '\r').or(inRange('\034', ' ')).or(is(' ')).or(is('᠎')).or(inRange(' ', ' ')).or(inRange(' ', '​')).or(inRange(' ', ' ')).or(is(' ')).or(is('　'));
    JAVA_DIGIT = new CharMatcher()
    {
      public boolean matches(char paramAnonymousChar)
      {
        return Character.isDigit(paramAnonymousChar);
      }
    };
    JAVA_LETTER = new CharMatcher()
    {
      public boolean matches(char paramAnonymousChar)
      {
        return Character.isLetter(paramAnonymousChar);
      }
    };
    JAVA_LETTER_OR_DIGIT = new CharMatcher()
    {
      public boolean matches(char paramAnonymousChar)
      {
        return Character.isLetterOrDigit(paramAnonymousChar);
      }
    };
    JAVA_UPPER_CASE = new CharMatcher()
    {
      public boolean matches(char paramAnonymousChar)
      {
        return Character.isUpperCase(paramAnonymousChar);
      }
    };
    JAVA_LOWER_CASE = new CharMatcher()
    {
      public boolean matches(char paramAnonymousChar)
      {
        return Character.isLowerCase(paramAnonymousChar);
      }
    };
    JAVA_ISO_CONTROL = inRange('\000', '\037').or(inRange('', ''));
    INVISIBLE = inRange('\000', ' ').or(inRange('', ' ')).or(is('­')).or(inRange('؀', '؃')).or(anyOf("۝܏ ឴឵᠎")).or(inRange(' ', '‏')).or(inRange(' ', ' ')).or(inRange(' ', '⁤')).or(inRange('⁪', '⁯')).or(is('　')).or(inRange(55296, 63743)).or(anyOf("﻿￹￺￻"));
    SINGLE_WIDTH = inRange('\000', 'ӹ').or(is('־')).or(inRange('א', 'ת')).or(is('׳')).or(is('״')).or(inRange('؀', 'ۿ')).or(inRange('ݐ', 'ݿ')).or(inRange('฀', '๿')).or(inRange('Ḁ', '₯')).or(inRange('℀', '℺')).or(inRange(64336, 65023)).or(inRange(65136, 65279)).or(inRange(65377, 65500));
    LEGACY_WHITESPACE = anyOf(" \r\n\t　   ").precomputed();
  }
  
  public static CharMatcher anyOf(CharSequence paramCharSequence)
  {
    switch (paramCharSequence.length())
    {
    default: 
      paramCharSequence = paramCharSequence.toString().toCharArray();
      Arrays.sort(paramCharSequence);
      new CharMatcher()
      {
        public boolean matches(char paramAnonymousChar)
        {
          return Arrays.binarySearch(val$chars, paramAnonymousChar) >= 0;
        }
        
        protected void setBits(CharMatcher.LookupTable paramAnonymousLookupTable)
        {
          char[] arrayOfChar = val$chars;
          int j = arrayOfChar.length;
          int i = 0;
          while (i < j)
          {
            paramAnonymousLookupTable.set(arrayOfChar[i]);
            i += 1;
          }
        }
      };
    case 0: 
      return NONE;
    case 1: 
      return is(paramCharSequence.charAt(0));
    }
    new CharMatcher()
    {
      public boolean matches(char paramAnonymousChar)
      {
        return (paramAnonymousChar == val$match1) || (paramAnonymousChar == val$match2);
      }
      
      public CharMatcher precomputed()
      {
        return this;
      }
      
      protected void setBits(CharMatcher.LookupTable paramAnonymousLookupTable)
      {
        paramAnonymousLookupTable.set(val$match1);
        paramAnonymousLookupTable.set(val$match2);
      }
    };
  }
  
  public static CharMatcher inRange(char paramChar1, final char paramChar2)
  {
    if (paramChar2 >= paramChar1) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      new CharMatcher()
      {
        public boolean matches(char paramAnonymousChar)
        {
          return (val$startInclusive <= paramAnonymousChar) && (paramAnonymousChar <= paramChar2);
        }
        
        public CharMatcher precomputed()
        {
          return this;
        }
        
        protected void setBits(CharMatcher.LookupTable paramAnonymousLookupTable)
        {
          char c2;
          for (char c1 = val$startInclusive;; c1 = c2)
          {
            paramAnonymousLookupTable.set(c1);
            c2 = (char)(c1 + '\001');
            if (c1 == paramChar2) {
              return;
            }
          }
        }
      };
    }
  }
  
  public static CharMatcher is(char paramChar)
  {
    new CharMatcher()
    {
      public boolean matches(char paramAnonymousChar)
      {
        return paramAnonymousChar == val$match;
      }
      
      public CharMatcher negate()
      {
        return isNot(val$match);
      }
      
      public CharMatcher or(CharMatcher paramAnonymousCharMatcher)
      {
        if (paramAnonymousCharMatcher.matches(val$match)) {
          return paramAnonymousCharMatcher;
        }
        return super.or(paramAnonymousCharMatcher);
      }
      
      public CharMatcher precomputed()
      {
        return this;
      }
      
      public String replaceFrom(CharSequence paramAnonymousCharSequence, char paramAnonymousChar)
      {
        return paramAnonymousCharSequence.toString().replace(val$match, paramAnonymousChar);
      }
      
      protected void setBits(CharMatcher.LookupTable paramAnonymousLookupTable)
      {
        paramAnonymousLookupTable.set(val$match);
      }
    };
  }
  
  public static CharMatcher isNot(char paramChar)
  {
    new CharMatcher()
    {
      public boolean matches(char paramAnonymousChar)
      {
        return paramAnonymousChar != val$match;
      }
      
      public CharMatcher negate()
      {
        return is(val$match);
      }
      
      public CharMatcher or(CharMatcher paramAnonymousCharMatcher)
      {
        Object localObject = this;
        if (paramAnonymousCharMatcher.matches(val$match)) {
          localObject = ANY;
        }
        return (CharMatcher)localObject;
      }
    };
  }
  
  public boolean apply(Character paramCharacter)
  {
    return matches(paramCharacter.charValue());
  }
  
  public String collapseFrom(CharSequence paramCharSequence, char paramChar)
  {
    int i = indexIn(paramCharSequence);
    if (i == -1) {
      return paramCharSequence.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length()).append(paramCharSequence.subSequence(0, i)).append(paramChar);
    int k = 1;
    int j = i + 1;
    if (j < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(j);
      if (apply(Character.valueOf(c)))
      {
        i = k;
        if (k == 0) {
          localStringBuilder.append(paramChar);
        }
      }
      for (i = 1;; i = 0)
      {
        j += 1;
        k = i;
        break;
        localStringBuilder.append(c);
      }
    }
    return localStringBuilder.toString();
  }
  
  public int indexIn(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      if (matches(paramCharSequence.charAt(i))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int indexIn(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length();
    Preconditions.checkPositionIndex(paramInt, i);
    while (paramInt < i)
    {
      if (matches(paramCharSequence.charAt(paramInt))) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  public abstract boolean matches(char paramChar);
  
  public CharMatcher negate()
  {
    new CharMatcher()
    {
      public boolean matches(char paramAnonymousChar)
      {
        return !jdField_this.matches(paramAnonymousChar);
      }
      
      public CharMatcher negate()
      {
        return jdField_this;
      }
    };
  }
  
  public CharMatcher or(CharMatcher paramCharMatcher)
  {
    return new Or(Arrays.asList(new CharMatcher[] { this, (CharMatcher)Preconditions.checkNotNull(paramCharMatcher) }));
  }
  
  public CharMatcher precomputed()
  {
    return Platform.precomputeCharMatcher(this);
  }
  
  CharMatcher precomputedInternal()
  {
    final LookupTable localLookupTable = new LookupTable();
    setBits(localLookupTable);
    new CharMatcher()
    {
      public boolean matches(char paramAnonymousChar)
      {
        return localLookupTable.get(paramAnonymousChar);
      }
      
      public CharMatcher precomputed()
      {
        return this;
      }
    };
  }
  
  public String removeFrom(CharSequence paramCharSequence)
  {
    paramCharSequence = paramCharSequence.toString();
    int i = indexIn(paramCharSequence);
    if (i == -1) {
      return paramCharSequence;
    }
    paramCharSequence = paramCharSequence.toCharArray();
    int j = 1;
    i += 1;
    for (;;)
    {
      if (i == paramCharSequence.length) {
        return new String(paramCharSequence, 0, i - j);
      }
      if (matches(paramCharSequence[i]))
      {
        j += 1;
        break;
      }
      paramCharSequence[(i - j)] = paramCharSequence[i];
      i += 1;
    }
  }
  
  public String replaceFrom(CharSequence paramCharSequence, char paramChar)
  {
    paramCharSequence = paramCharSequence.toString();
    int i = indexIn(paramCharSequence);
    if (i == -1) {
      return paramCharSequence;
    }
    paramCharSequence = paramCharSequence.toCharArray();
    paramCharSequence[i] = paramChar;
    i += 1;
    while (i < paramCharSequence.length)
    {
      if (matches(paramCharSequence[i])) {
        paramCharSequence[i] = paramChar;
      }
      i += 1;
    }
    return new String(paramCharSequence);
  }
  
  public String replaceFrom(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int i = paramCharSequence2.length();
    if (i == 0) {
      paramCharSequence1 = removeFrom(paramCharSequence1);
    }
    String str;
    do
    {
      return paramCharSequence1;
      if (i == 1) {
        return replaceFrom(paramCharSequence1, paramCharSequence2.charAt(0));
      }
      str = paramCharSequence1.toString();
      i = indexIn(str);
      paramCharSequence1 = str;
    } while (i == -1);
    int n = str.length();
    paramCharSequence1 = new StringBuilder((int)(n * 1.5D) + 16);
    int j = 0;
    int k;
    int m;
    do
    {
      paramCharSequence1.append(str, j, i);
      paramCharSequence1.append(paramCharSequence2);
      k = i + 1;
      m = indexIn(str, k);
      j = k;
      i = m;
    } while (m != -1);
    paramCharSequence1.append(str, k, n);
    return paramCharSequence1.toString();
  }
  
  protected void setBits(LookupTable paramLookupTable)
  {
    int j;
    for (int i = 0;; i = j)
    {
      if (matches(i)) {
        paramLookupTable.set(i);
      }
      j = (char)(i + 1);
      if (i == 65535) {
        return;
      }
    }
  }
  
  public String trimAndCollapseFrom(CharSequence paramCharSequence, char paramChar)
  {
    int k = negate().indexIn(paramCharSequence);
    if (k == -1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length());
    int i = 0;
    if (k < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(k);
      if (apply(Character.valueOf(c))) {}
      int j;
      for (i = 1;; i = j)
      {
        k += 1;
        break;
        j = i;
        if (i != 0)
        {
          localStringBuilder.append(paramChar);
          j = 0;
        }
        localStringBuilder.append(c);
      }
    }
    return localStringBuilder.toString();
  }
  
  public String trimFrom(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    int i = 0;
    if ((i >= j) || (!matches(paramCharSequence.charAt(i)))) {
      j -= 1;
    }
    for (;;)
    {
      if ((j <= i) || (!matches(paramCharSequence.charAt(j))))
      {
        return paramCharSequence.subSequence(i, j + 1).toString();
        i += 1;
        break;
      }
      j -= 1;
    }
  }
  
  protected static class LookupTable
  {
    int[] data = new int['ࠀ'];
    
    boolean get(char paramChar)
    {
      return (data[(paramChar >> '\005')] & '\001' << paramChar) != 0;
    }
    
    void set(char paramChar)
    {
      int[] arrayOfInt = data;
      int i = paramChar >> '\005';
      arrayOfInt[i] |= '\001' << paramChar;
    }
  }
  
  private static class Or
    extends CharMatcher
  {
    List<CharMatcher> components;
    
    Or(List<CharMatcher> paramList)
    {
      components = paramList;
    }
    
    public boolean matches(char paramChar)
    {
      Iterator localIterator = components.iterator();
      while (localIterator.hasNext()) {
        if (((CharMatcher)localIterator.next()).matches(paramChar)) {
          return true;
        }
      }
      return false;
    }
    
    public CharMatcher or(CharMatcher paramCharMatcher)
    {
      ArrayList localArrayList = new ArrayList(components);
      localArrayList.add(Preconditions.checkNotNull(paramCharMatcher));
      return new Or(localArrayList);
    }
    
    protected void setBits(CharMatcher.LookupTable paramLookupTable)
    {
      Iterator localIterator = components.iterator();
      while (localIterator.hasNext()) {
        ((CharMatcher)localIterator.next()).setBits(paramLookupTable);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */