import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import com.android.mail.browse.SubjectAndFolderView;
import com.android.mail.providers.Folder;
import java.util.Iterator;
import java.util.NavigableSet;

public final class bzy
  extends cni
{
  public bzy(SubjectAndFolderView paramSubjectAndFolderView, Context paramContext)
  {
    super(paramContext);
  }
  
  private final void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString, int paramInt1, int paramInt2)
  {
    chn localchn = new chn(paramString, paramInt1, paramInt2, f, a.a(), a);
    paramInt1 = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(paramString);
    paramSpannableStringBuilder.setSpan(localchn, paramInt1, paramString.length() + paramInt1, 33);
    paramSpannableStringBuilder.append(" ");
  }
  
  protected final void a()
  {
    super.a();
    Resources localResources = d.getResources();
    f.d = 0;
    f.e = localResources.getDimensionPixelOffset(bua.J);
    f.g = localResources.getDimensionPixelOffset(bua.K);
    f.h = a.g;
  }
  
  public final void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext())
    {
      Folder localFolder = (Folder)localIterator.next();
      a(paramSpannableStringBuilder, d, localFolder.c(f.a), localFolder.b(f.b));
    }
    if (e.isEmpty()) {
      a(paramSpannableStringBuilder, a.a, a.c, a.b);
    }
  }
}

/* Location:
 * Qualified Name:     bzy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */