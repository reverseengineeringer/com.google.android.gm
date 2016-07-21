import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.TextAppearanceSpan;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.ParticipantInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class bzt
{
  private static final Integer a = Integer.valueOf(-5);
  private static final cwi<Map<Integer, Integer>> b = new cwi(new bzu());
  
  private static int a(int paramInt)
  {
    if (paramInt == 2) {
      return 2;
    }
    return 0;
  }
  
  private static int a(int paramInt1, ConversationInfo paramConversationInfo, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Map localMap = (Map)b.a();
    for (;;)
    {
      try
      {
        localMap.clear();
        paramConversationInfo = a.iterator();
        if (!paramConversationInfo.hasNext()) {
          break label230;
        }
        ParticipantInfo localParticipantInfo = (ParticipantInfo)paramConversationInfo.next();
        String str = a;
        if (TextUtils.isEmpty(str)) {
          break label246;
        }
        i = str.length();
        localMap.put(Integer.valueOf(c), Integer.valueOf(i));
        paramInt5 = Math.max(paramInt5, c);
        continue;
        if (i < paramInt5)
        {
          if (!localMap.containsKey(Integer.valueOf(i + 1))) {
            break label222;
          }
          paramInt2 = ((Integer)localMap.get(Integer.valueOf(i + 1))).intValue();
          paramInt2 += paramInt4;
          if (paramInt4 <= 0) {
            break label219;
          }
          paramInt2 += 2;
          if ((paramInt2 <= paramInt1) || (paramInt3 < 2))
          {
            paramInt4 = paramInt3 + 1;
            paramInt3 = paramInt2;
            paramInt2 = paramInt4;
            i += 1;
            paramInt4 = paramInt3;
            paramInt3 = paramInt2;
            continue;
          }
        }
        return i;
      }
      finally
      {
        b.a(localMap);
      }
      label219:
      continue;
      label222:
      paramInt2 = paramInt3;
      paramInt3 = paramInt4;
      continue;
      label230:
      int i = paramInt3;
      paramInt3 = paramInt4;
      paramInt4 = i;
      i = paramInt2;
      continue;
      label246:
      i = 0;
    }
  }
  
  public static Typeface a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return Typeface.DEFAULT_BOLD;
    }
    return Typeface.DEFAULT;
  }
  
  public static SpannableString a(bzn parambzn)
  {
    SpannableString localSpannableString = new SpannableString(B);
    localSpannableString.setSpan(CharacterStyle.wrap(ag), 0, localSpannableString.length(), 0);
    return localSpannableString;
  }
  
  public static SpannableString a(CharSequence paramCharSequence, CharacterStyle paramCharacterStyle)
  {
    paramCharSequence = new SpannableString(paramCharSequence);
    paramCharSequence.setSpan(CharacterStyle.wrap(paramCharacterStyle), 0, paramCharSequence.length(), 0);
    return paramCharSequence;
  }
  
  public static SpannableStringBuilder a(bzn parambzn, Conversation paramConversation)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject1 = t;
    int k = h;
    Object localObject2 = a.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (TextUtils.isEmpty(nexta));
    for (int i = 1;; i = 0)
    {
      int m = b;
      int n = c;
      boolean bool2;
      label145:
      label162:
      int j;
      label200:
      boolean bool1;
      if (m > 1)
      {
        localObject2 = String.format("%d", new Object[] { Integer.valueOf(m) });
        if (j)
        {
          localObject1 = ah;
          a(parambzn, localSpannableStringBuilder, (CharSequence)localObject2, CharacterStyle.wrap((CharacterStyle)localObject1), false, j);
        }
      }
      else
      {
        if ((i == 0) && (m <= 1)) {
          break label291;
        }
        bool2 = true;
        if (n > 0)
        {
          if (n != 1) {
            break label297;
          }
          localObject1 = t;
          a(parambzn, localSpannableStringBuilder, (CharSequence)localObject1, ab, bool2, j);
        }
        if ((k != 2) && (k != 1) && (k != -1)) {
          break label374;
        }
        j = 1;
        if (j != 0)
        {
          if (n <= 0) {
            break label379;
          }
          bool1 = true;
          label212:
          if (k != 2) {
            break label385;
          }
          localObject1 = v;
          localObject2 = ac;
        }
      }
      for (;;)
      {
        a(parambzn, localSpannableStringBuilder, (CharSequence)localObject1, localObject2, bool2 | bool1, j);
        if ((m > 1) || ((n > 0) && (i != 0)) || (j != 0)) {
          localSpannableStringBuilder.insert(0, C);
        }
        return localSpannableStringBuilder;
        localObject1 = ai;
        break;
        label291:
        bool2 = false;
        break label145;
        label297:
        localObject1 = String.valueOf(u);
        localObject2 = String.valueOf(String.format(y, new Object[] { Integer.valueOf(n) }));
        localObject1 = String.valueOf(localObject1).length() + 0 + String.valueOf(localObject2).length() + (String)localObject1 + (String)localObject2;
        break label162;
        label374:
        j = 0;
        break label200;
        label379:
        bool1 = false;
        break label212;
        label385:
        if (k == 1)
        {
          localObject1 = w;
          localObject2 = ad;
        }
        else
        {
          localObject1 = x;
          localObject2 = ae;
        }
      }
    }
  }
  
  static String a(bzn parambzn, boolean paramBoolean)
  {
    if (paramBoolean) {
      return A;
    }
    return z;
  }
  
  private static void a(bzn parambzn, SpannableStringBuilder paramSpannableStringBuilder, CharSequence paramCharSequence, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramSpannableStringBuilder.length();
    if (paramBoolean1)
    {
      paramSpannableStringBuilder.append(r);
      if (!paramBoolean2) {
        break label72;
      }
    }
    label72:
    for (parambzn = ah;; parambzn = ai)
    {
      paramSpannableStringBuilder.setSpan(CharacterStyle.wrap(parambzn), i, paramSpannableStringBuilder.length(), 33);
      i = paramSpannableStringBuilder.length();
      paramSpannableStringBuilder.append(paramCharSequence);
      paramSpannableStringBuilder.setSpan(paramObject, i, paramSpannableStringBuilder.length(), 33);
      return;
    }
  }
  
  public static void a(bzn parambzn, ConversationInfo paramConversationInfo, String paramString, int paramInt, ArrayList<SpannableString> paramArrayList, ArrayList<String> paramArrayList1, bxe parambxe, Account paramAccount, TextAppearanceSpan paramTextAppearanceSpan, CharacterStyle paramCharacterStyle, boolean paramBoolean)
  {
    int i;
    int j;
    label16:
    int m;
    if (paramArrayList1 != null)
    {
      i = 1;
      if (parambxe == null) {
        break label512;
      }
      j = 1;
      m = paramString.length();
      if (m <= paramInt) {
        break label880;
      }
    }
    label79:
    label129:
    label191:
    label219:
    label270:
    label429:
    label512:
    label526:
    label532:
    label552:
    label560:
    label610:
    label696:
    label865:
    label873:
    label880:
    for (int k = m - paramInt;; k = 0)
    {
      int i1 = a(paramInt, paramConversationInfo, -1, m, 0, 0);
      HashMap localHashMap = new HashMap();
      ArrayList localArrayList = new ArrayList(hgd.a(4));
      Object localObject1 = null;
      m = 0;
      paramInt = 0;
      Object localObject2 = null;
      if (paramInt < a.size())
      {
        ParticipantInfo localParticipantInfo = (ParticipantInfo)a.get(paramInt);
        String str2 = b;
        String str1 = a;
        Object localObject3;
        int n;
        CharacterStyle localCharacterStyle;
        if (!TextUtils.isEmpty(str1))
        {
          localObject3 = str1;
          paramString = (String)localObject3;
          if (((String)localObject3).length() == 0) {
            paramString = a(parambzn, paramBoolean);
          }
          localObject3 = paramString;
          if (k != 0) {
            localObject3 = paramString.substring(0, Math.max(paramString.length() - k, 0));
          }
          n = c;
          if (!d) {
            break label526;
          }
          paramString = paramCharacterStyle;
          localCharacterStyle = CharacterStyle.wrap(paramString);
          if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2))) {
            break label532;
          }
          paramString = c;
          if (n > i1) {
            break label560;
          }
          SpannableString localSpannableString = new SpannableString(aj.a((String)localObject3));
          if (!localHashMap.containsKey(str1)) {
            break label552;
          }
          localObject3 = (Integer)localHashMap.get(str1);
          int i2 = ((Integer)localObject3).intValue();
          if (i2 != a.intValue())
          {
            n = m;
            if (d) {}
          }
          else
          {
            if ((i2 != a.intValue()) && (paramInt > 0) && (i2 == paramInt - 1) && (i2 < paramArrayList.size()))
            {
              paramArrayList.set(i2, null);
              if ((i != 0) && (!TextUtils.isEmpty(str2)))
              {
                n = localArrayList.indexOf(paramString);
                if (n != -1)
                {
                  localArrayList.remove(n);
                  paramArrayList1.remove(n);
                }
              }
            }
            localHashMap.put(str1, Integer.valueOf(paramInt));
            localSpannableString.setSpan(localCharacterStyle, 0, localSpannableString.length(), 0);
            paramArrayList.add(localSpannableString);
            n = m;
          }
          if (i == 0) {
            break label696;
          }
          if (paramInt != 0) {
            break label610;
          }
          localObject1 = str1;
        }
        for (localObject2 = paramString;; localObject2 = localObject3)
        {
          if ((j != 0) && (TextUtils.isEmpty(a)) && (!d)) {
            parambxe.a(str1, paramString, a(e));
          }
          paramInt += 1;
          paramString = (String)localObject2;
          localObject2 = localObject1;
          localObject1 = paramString;
          m = n;
          break label79;
          i = 0;
          break;
          j = 0;
          break label16;
          localObject3 = "";
          break label129;
          paramString = paramTextAppearanceSpan;
          break label191;
          if (TextUtils.isEmpty(str2))
          {
            paramString = str1;
            break label219;
          }
          paramString = str2;
          break label219;
          localObject3 = a;
          break label270;
          n = m;
          if (m != 0) {
            break label429;
          }
          localObject3 = new SpannableString(D);
          ((SpannableString)localObject3).setSpan(localCharacterStyle, 0, ((SpannableString)localObject3).length(), 0);
          n = 1;
          paramArrayList.add(localObject3);
          break label429;
          if (!hbc.a(localObject1, paramString))
          {
            m = localArrayList.indexOf(paramString);
            if (m >= 0)
            {
              localArrayList.remove(m);
              paramArrayList1.remove(m);
            }
            localArrayList.add(paramString);
            paramArrayList1.add(str1);
            if (localArrayList.size() > 4)
            {
              localArrayList.remove(0);
              paramArrayList1.remove(0);
            }
          }
          localObject3 = localObject1;
          localObject1 = localObject2;
        }
      }
      if ((i != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (paramArrayList1.size() < 4) {
          paramArrayList1.add(0, localObject2);
        }
      }
      else if ((j != 0) && (TextUtils.isEmpty(a))) {
        paramInt = a.size() - 1;
      }
      for (;;)
      {
        if (paramInt >= 0)
        {
          paramString = (ParticipantInfo)a.get(paramInt);
          if (TextUtils.isEmpty(a)) {
            break label873;
          }
          if (!TextUtils.isEmpty(b)) {
            break label865;
          }
        }
        for (parambzn = a;; parambzn = b)
        {
          parambxe.a(a, parambzn, a(e));
          if (TextUtils.isEmpty(a)) {
            parambxe.a(a, c, 0);
          }
          return;
          paramArrayList1.set(0, localObject2);
          break;
        }
        paramInt -= 1;
      }
    }
  }
  
  public static void a(bzn parambzn, ConversationInfo paramConversationInfo, String paramString, int paramInt, ArrayList<SpannableString> paramArrayList, ArrayList<String> paramArrayList1, bxe parambxe, Account paramAccount, boolean paramBoolean)
  {
    a(parambzn, paramConversationInfo, paramString, paramInt, paramArrayList, paramArrayList1, parambxe, paramAccount, af, ag, paramBoolean);
  }
}

/* Location:
 * Qualified Name:     bzt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */