import android.text.TextUtils;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class dtu
{
  public long A;
  public String B;
  public int C = -1;
  public int D;
  public int E;
  public int F;
  public String G;
  public String H;
  public String I;
  public int J;
  public String K;
  public String L;
  public dtv M;
  public String a;
  public long b;
  public long c;
  public long d;
  public long e;
  public String f = "";
  public List<String> g = Collections.emptyList();
  public List<String> h = Collections.emptyList();
  public List<String> i = Collections.emptyList();
  public List<String> j = Collections.emptyList();
  public long k;
  public long l;
  public String m;
  public String n;
  public Set<Long> o = new HashSet();
  public String p;
  public int q;
  public List<GmailAttachment> r = new ArrayList();
  public String s;
  public String t;
  public String u;
  public boolean v;
  public boolean w;
  public boolean x;
  public long y;
  public boolean z;
  
  public final GmailAttachment a(String paramString)
  {
    Object localObject = GmailProvider.a(a, d, c, paramString);
    if (localObject != null) {
      return (GmailAttachment)localObject;
    }
    localObject = r.iterator();
    while (((Iterator)localObject).hasNext())
    {
      GmailAttachment localGmailAttachment = (GmailAttachment)((Iterator)localObject).next();
      if (paramString.equals(b)) {
        return localGmailAttachment;
      }
    }
    return null;
  }
  
  public final List<GmailAttachment> a()
  {
    List localList = GmailProvider.a(a, d, c);
    if ((localList != null) && (!localList.isEmpty())) {
      return localList;
    }
    return r;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof dtu))
    {
      paramObject = (dtu)paramObject;
      return (d == d) && (c == c) && (TextUtils.equals(a, a));
    }
    return super.equals(paramObject);
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Long.valueOf(d), Long.valueOf(c), a });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Message: ").append(c);
    localStringBuilder.append(", ").append(d);
    localStringBuilder.append(", from: ").append(f);
    localStringBuilder.append(", to: ").append(TextUtils.join(", ", g));
    if (h.size() != 0) {
      localStringBuilder.append(", cc: ").append(TextUtils.join(", ", h));
    }
    if (i.size() != 0) {
      localStringBuilder.append(", bcc: ").append(TextUtils.join(", ", i));
    }
    if (j.size() != 0) {
      localStringBuilder.append(", replyTo: ").append(TextUtils.join(", ", j));
    }
    localStringBuilder.append(", subject: ").append(m);
    localStringBuilder.append(", snippet: ").append(n);
    localStringBuilder.append(", forward: ").append(w);
    localStringBuilder.append(", includeQuotedText: ").append(x);
    localStringBuilder.append(", quoteStartPos: ").append(y);
    localStringBuilder.append(", clientCreated: ").append(z);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     dtu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */