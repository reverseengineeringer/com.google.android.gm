package com.google.wireless.gdata2.parser.xml;

import android.util.Log;
import android.util.Xml;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SimplePullParser
{
  private String mCurrentStartTag;
  private String mLogTag = null;
  private final XmlPullParser mParser;
  private Closeable source;
  
  public SimplePullParser(InputStream paramInputStream, String paramString)
    throws SimplePullParser.ParseException, IOException
  {
    try
    {
      XmlPullParser localXmlPullParser = Xml.newPullParser();
      localXmlPullParser.setInput(paramInputStream, paramString);
      moveToStartDocument(localXmlPullParser);
      mParser = localXmlPullParser;
      mCurrentStartTag = null;
      source = paramInputStream;
      return;
    }
    catch (XmlPullParserException paramInputStream)
    {
      throw new ParseException(paramInputStream);
    }
  }
  
  public SimplePullParser(Reader paramReader)
    throws IOException, SimplePullParser.ParseException
  {
    try
    {
      XmlPullParser localXmlPullParser = Xml.newPullParser();
      localXmlPullParser.setInput(paramReader);
      moveToStartDocument(localXmlPullParser);
      mParser = localXmlPullParser;
      mCurrentStartTag = null;
      source = paramReader;
      return;
    }
    catch (XmlPullParserException paramReader)
    {
      throw new ParseException(paramReader);
    }
  }
  
  public SimplePullParser(String paramString)
    throws IOException, SimplePullParser.ParseException
  {
    this(new StringReader(paramString));
  }
  
  private static void moveToStartDocument(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    if (paramXmlPullParser.getEventType() != 0) {
      throw new XmlPullParserException("Not at start of response");
    }
  }
  
  public int getDepth()
  {
    return mParser.getDepth();
  }
  
  public int getIntAttribute(String paramString1, String paramString2)
    throws SimplePullParser.ParseException
  {
    paramString1 = getStringAttribute(paramString1, paramString2);
    try
    {
      int i = Integer.parseInt(paramString1);
      return i;
    }
    catch (NumberFormatException paramString2)
    {
      throw new ParseException("Cannot parse '" + paramString1 + "' as an integer");
    }
  }
  
  public int getIntAttribute(String paramString1, String paramString2, int paramInt)
    throws SimplePullParser.ParseException
  {
    paramString1 = mParser.getAttributeValue(paramString1, paramString2);
    if (paramString1 == null) {
      return paramInt;
    }
    try
    {
      paramInt = Integer.parseInt(paramString1);
      return paramInt;
    }
    catch (NumberFormatException paramString2)
    {
      throw new ParseException("Cannot parse '" + paramString1 + "' as an integer");
    }
  }
  
  public long getLongAttribute(String paramString1, String paramString2)
    throws SimplePullParser.ParseException
  {
    paramString1 = getStringAttribute(paramString1, paramString2);
    try
    {
      long l = Long.parseLong(paramString1);
      return l;
    }
    catch (NumberFormatException paramString2)
    {
      throw new ParseException("Cannot parse '" + paramString1 + "' as a long");
    }
  }
  
  public String getStringAttribute(String paramString1, String paramString2)
    throws SimplePullParser.ParseException
  {
    paramString1 = mParser.getAttributeValue(paramString1, paramString2);
    if (paramString1 == null) {
      throw new ParseException("missing '" + paramString2 + "' attribute on '" + mCurrentStartTag + "' element");
    }
    return paramString1;
  }
  
  public String nextTag(int paramInt)
    throws IOException, SimplePullParser.ParseException
  {
    return nextTagOrText(paramInt, null);
  }
  
  public String nextTagOrText(int paramInt, StringBuilder paramStringBuilder)
    throws IOException, SimplePullParser.ParseException
  {
    Object localObject = null;
    int j;
    int i;
    label225:
    label237:
    do
    {
      try
      {
        j = mParser.next();
        i = mParser.getDepth();
        mCurrentStartTag = null;
        if ((j != 2) || (i != paramInt + 1)) {
          break label237;
        }
        mCurrentStartTag = mParser.getName();
        if ((mLogTag == null) || (!Log.isLoggable(mLogTag, 3))) {
          break label225;
        }
        paramStringBuilder = new StringBuilder();
        paramInt = 0;
        while (paramInt < i)
        {
          paramStringBuilder.append("  ");
          paramInt += 1;
        }
        paramStringBuilder.append("<").append(mParser.getName());
      }
      catch (XmlPullParserException paramStringBuilder)
      {
        throw new ParseException(paramStringBuilder);
      }
      i = mParser.getAttributeCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramStringBuilder.append(" ");
        paramStringBuilder.append(mParser.getAttributeName(paramInt));
        paramStringBuilder.append("=\"");
        paramStringBuilder.append(mParser.getAttributeValue(paramInt));
        paramStringBuilder.append("\"");
        paramInt += 1;
      }
      paramStringBuilder.append(">");
      Log.d(mLogTag, paramStringBuilder.toString());
      paramStringBuilder = mParser.getName();
      do
      {
        do
        {
          do
          {
            return paramStringBuilder;
            if ((j != 3) || (i != paramInt)) {
              break;
            }
            paramStringBuilder = (StringBuilder)localObject;
          } while (mLogTag == null);
          paramStringBuilder = (StringBuilder)localObject;
        } while (!Log.isLoggable(mLogTag, 3));
        paramStringBuilder = new StringBuilder();
        paramInt = 0;
        while (paramInt < i)
        {
          paramStringBuilder.append("  ");
          paramInt += 1;
        }
        paramStringBuilder.append("</>");
        Log.d(mLogTag, paramStringBuilder.toString());
        return null;
        if ((j != 1) || (paramInt != 0)) {
          break;
        }
        paramStringBuilder = (StringBuilder)localObject;
      } while (source == null);
      source.close();
      source = null;
      return null;
    } while ((j != 4) || (i != paramInt) || (paramStringBuilder == null));
    paramStringBuilder.append(mParser.getText());
    return "![CDATA[";
  }
  
  public static final class ParseException
    extends Exception
  {
    public ParseException(String paramString)
    {
      super();
    }
    
    public ParseException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    public ParseException(Throwable paramThrowable)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.wireless.gdata2.parser.xml.SimplePullParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */