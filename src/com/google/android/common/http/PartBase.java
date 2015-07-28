package com.google.android.common.http;

public abstract class PartBase
  extends Part
{
  private String charSet;
  private String contentType;
  private String name;
  private String transferEncoding;
  
  public PartBase(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Name must not be null");
    }
    name = paramString1;
    contentType = paramString2;
    charSet = paramString3;
    transferEncoding = paramString4;
  }
  
  public String getCharSet()
  {
    return charSet;
  }
  
  public String getContentType()
  {
    return contentType;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getTransferEncoding()
  {
    return transferEncoding;
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.http.PartBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */