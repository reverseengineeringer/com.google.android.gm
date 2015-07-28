package com.android.common;

import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.widget.AutoCompleteTextView.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public class Rfc822Validator
  implements AutoCompleteTextView.Validator
{
  private static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("[^\\s@]+@([^\\s@\\.]+\\.)+[a-zA-z][a-zA-Z][a-zA-Z]*");
  private String mDomain;
  private boolean mRemoveInvalid = false;
  
  public Rfc822Validator(String paramString)
  {
    mDomain = paramString;
  }
  
  private String removeIllegalCharacters(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if ((c <= ' ') || (c > '~')) {}
      for (;;)
      {
        i += 1;
        break;
        if ((c != '(') && (c != ')') && (c != '<') && (c != '>') && (c != '@') && (c != ',') && (c != ';') && (c != ':') && (c != '\\') && (c != '"') && (c != '[') && (c != ']')) {
          localStringBuilder.append(c);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public CharSequence fixText(CharSequence paramCharSequence)
  {
    if (TextUtils.getTrimmedLength(paramCharSequence) == 0) {
      paramCharSequence = "";
    }
    Rfc822Token[] arrayOfRfc822Token;
    StringBuilder localStringBuilder;
    int i;
    do
    {
      return paramCharSequence;
      arrayOfRfc822Token = Rfc822Tokenizer.tokenize(paramCharSequence);
      localStringBuilder = new StringBuilder();
      i = 0;
      paramCharSequence = localStringBuilder;
    } while (i >= arrayOfRfc822Token.length);
    paramCharSequence = arrayOfRfc822Token[i].getAddress();
    if ((mRemoveInvalid) && (!isValid(paramCharSequence))) {}
    int j;
    label157:
    Object localObject;
    do
    {
      for (;;)
      {
        i += 1;
        break;
        j = paramCharSequence.indexOf('@');
        if (j >= 0) {
          break label157;
        }
        if (mDomain != null) {
          arrayOfRfc822Token[i].setAddress(removeIllegalCharacters(paramCharSequence) + "@" + mDomain);
        }
        localStringBuilder.append(arrayOfRfc822Token[i].toString());
        if (i + 1 < arrayOfRfc822Token.length) {
          localStringBuilder.append(", ");
        }
      }
      localObject = removeIllegalCharacters(paramCharSequence.substring(0, j));
    } while (TextUtils.isEmpty((CharSequence)localObject));
    paramCharSequence = removeIllegalCharacters(paramCharSequence.substring(j + 1));
    label198:
    Rfc822Token localRfc822Token;
    if (paramCharSequence.length() == 0)
    {
      j = 1;
      if ((j != 0) && (mDomain == null)) {
        break label258;
      }
      localRfc822Token = arrayOfRfc822Token[i];
      localObject = new StringBuilder().append((String)localObject).append("@");
      if (j != 0) {
        break label260;
      }
    }
    for (;;)
    {
      localRfc822Token.setAddress(paramCharSequence);
      break;
      j = 0;
      break label198;
      label258:
      break;
      label260:
      paramCharSequence = mDomain;
    }
  }
  
  public boolean isValid(CharSequence paramCharSequence)
  {
    paramCharSequence = Rfc822Tokenizer.tokenize(paramCharSequence);
    return (paramCharSequence.length == 1) && (EMAIL_ADDRESS_PATTERN.matcher(paramCharSequence[0].getAddress()).matches());
  }
}

/* Location:
 * Qualified Name:     com.android.common.Rfc822Validator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */