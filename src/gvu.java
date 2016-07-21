public class gvu<T>
  extends gra<T>
{
  @gug
  private String alt;
  @gug
  private String fields;
  @gug
  private String key;
  @gug(a="oauth_token")
  private String oauthToken;
  @gug
  private Boolean prettyPrint;
  @gug
  private String quotaUser;
  @gug
  private String userIp;
  
  public gvu(gvr paramgvr, String paramString1, String paramString2, Object paramObject, Class<T> paramClass)
  {
    super(paramgvr, paramString1, paramString2, paramObject, paramClass);
  }
  
  public gvu<T> e(String paramString, Object paramObject)
  {
    return (gvu)super.c(paramString, paramObject);
  }
}

/* Location:
 * Qualified Name:     gvu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */