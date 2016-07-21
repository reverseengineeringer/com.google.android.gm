import android.text.TextUtils;
import java.util.Arrays;
import java.util.Set;

public final class dtp
{
  public long a;
  public long b;
  public long c;
  public int d;
  @Deprecated
  public String e;
  public byte[] f;
  public long g;
  public String h;
  public String i;
  public int j;
  public boolean k;
  public String l;
  public String m;
  public Set<Long> n;
  public int o;
  public boolean p;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("conversationId: ").append(a);
    localStringBuilder.append(", sortMessageId: ").append(b);
    localStringBuilder.append(", maxMessageId: ").append(c);
    localStringBuilder.append(", numMessage: ").append(d);
    localStringBuilder.append(", date: ").append(g);
    if (h != null) {
      localStringBuilder.append(", subject: ").append(h);
    }
    if (i != null) {
      localStringBuilder.append(", snippet: ").append(i);
    }
    localStringBuilder.append(", hasAttachments: ").append(k);
    if (e != null) {
      localStringBuilder.append(", fromAddress: '").append(e.replace('\n', '|')).append('\'');
    }
    if (f != null) {
      localStringBuilder.append(", fromCompact: '").append(Arrays.toString(f));
    }
    localStringBuilder.append(", labelIds: ").append(TextUtils.join("|", n));
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     dtp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */