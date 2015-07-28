package com.google.android.gm;

import com.google.android.common.html.parser.HtmlTree.PlainTextConverter;
import com.google.android.common.html.parser.HtmlTree.PlainTextConverterFactory;

final class Utils$1
  implements HtmlTree.PlainTextConverterFactory
{
  public HtmlTree.PlainTextConverter createInstance()
  {
    return new Utils.GmailMessagePlainTextConverter();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.Utils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */