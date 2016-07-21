import android.content.res.Resources;
import java.util.Map;

public final class bvh
  extends buz
{
  private static Map<String, Integer> a;
  
  public bvh(Resources paramResources)
  {
    super(paramResources, dfs.a);
    if (a == null) {
      a = new hen().b("hotmail", Integer.valueOf(paramResources.getColor(dfv.k))).b("hotmail.com", Integer.valueOf(paramResources.getColor(dfv.r))).b("hotmail.co.uk", Integer.valueOf(paramResources.getColor(dfv.r))).b("hotmail.com.br", Integer.valueOf(paramResources.getColor(dfv.r))).b("msn.com", Integer.valueOf(paramResources.getColor(dfv.v))).b("live.co.uk", Integer.valueOf(paramResources.getColor(dfv.t))).b("windowslive.com", Integer.valueOf(paramResources.getColor(dfv.x))).b("yahoo", Integer.valueOf(paramResources.getColor(dfv.p))).b("aol", Integer.valueOf(paramResources.getColor(dfv.c))).b("apple", Integer.valueOf(paramResources.getColor(dfv.d))).b("me.com", Integer.valueOf(paramResources.getColor(dfv.u))).b("icloud.com", Integer.valueOf(paramResources.getColor(dfv.s))).b("mail.ru", Integer.valueOf(paramResources.getColor(dfv.i))).b("qq.com", Integer.valueOf(paramResources.getColor(dfv.l))).b("comcast", Integer.valueOf(paramResources.getColor(dfv.f))).b("docomo", Integer.valueOf(paramResources.getColor(dfv.g))).b("bol.com.br", Integer.valueOf(paramResources.getColor(dfv.e))).b("163.com", Integer.valueOf(paramResources.getColor(dfv.b))).b("ig.com.br", Integer.valueOf(paramResources.getColor(dfv.h))).b("terra.com.br", Integer.valueOf(paramResources.getColor(dfv.m))).b("verizon", Integer.valueOf(paramResources.getColor(dfv.o))).b("uol.com.br", Integer.valueOf(paramResources.getColor(dfv.n))).b("orange", Integer.valueOf(paramResources.getColor(dfv.j))).b("hanmail.com", Integer.valueOf(paramResources.getColor(dfv.q))).b("naver.com", Integer.valueOf(paramResources.getColor(dfv.w))).b();
    }
  }
  
  public final int a(String paramString)
  {
    Object localObject = cui.b(paramString);
    Integer localInteger = (Integer)a.get(localObject);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    localObject = cui.a((String)localObject);
    localObject = (Integer)a.get(localObject);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    return super.a(paramString);
  }
}

/* Location:
 * Qualified Name:     bvh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */