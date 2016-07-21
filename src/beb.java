import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import com.android.emailcommon.provider.Attachment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class beb
  extends bdv
{
  public static Uri a;
  public static Uri b;
  public static Uri c;
  public static Uri d;
  public static Uri e;
  public static Uri f;
  public static final String[] g = { "_id", "displayName", "timeStamp", "subject", "flagRead", "flagLoaded", "flagFavorite", "flagAttachment", "flags", "syncServerId", "clientId", "messageId", "mailboxKey", "accountKey", "fromList", "toList", "ccList", "bccList", "replyToList", "syncServerTimeStamp", "meetingInfo", "snippet", "protocolSearchInfo", "threadTopic", "syncData", "flagSeen", "mainMailboxKey", "retryCount", "nextRetryTime", "inReplyTo", "mailReferences", "serverThreadId", "threadId", "priority", "eventUid", "eventSubject", "meetingResponseComment", "eventStartTime", "eventEndTime", "proposedStartTime", "proposedEndTime", "eventRecurrenceRule", "draftUpsyncTimestamp", "proposeTimeFromMailRefMessageUri", "proposeTimeFromMailRsvp", "proposeTimeFromMailProposedStartTime", "proposeTimeFromMailProposedEndTime", "flagsEas" };
  public static final String[] h = { "_id", "displayName", "timeStamp", "subject", "flagRead", "flagLoaded", "flagFavorite", "flagAttachment", "flags", "mailboxKey", "accountKey", "syncServerId", "snippet" };
  public static final String[] i = { "_id", "toList", "ccList", "bccList", "subject", "priority", "replyToList", "flagAttachment", "flagRead", "flagFavorite", "timeStamp", "draftUpsyncTimestamp", "syncServerId", "flagsEas" };
  public static final String[] j = { "_id", "syncServerId" };
  public static final String[] k = { "_id" };
  public static final String[] l = { "mailboxKey" };
  public String P;
  public String Q;
  public String R;
  public String S;
  public long T;
  public long U;
  public long V;
  public long W;
  public String X;
  public String Y;
  public String Z;
  public transient ArrayList<Attachment> aA = null;
  public transient int aB;
  public transient boolean aC = false;
  public transient boolean aD = false;
  public transient boolean aE = false;
  public String aa;
  public String ab;
  public String ac;
  public String ad;
  public long ae;
  public String af;
  public String ag;
  public String ah;
  public String ai;
  public int aj;
  public long ak;
  public String al;
  public String am;
  public String an;
  public long ao;
  public long ap;
  public long aq;
  public long ar;
  public String as;
  public int at;
  public long au;
  public long av;
  public String aw;
  public transient String ax;
  public transient String ay;
  public transient long az;
  public String m;
  public long n;
  public String o;
  public boolean p = false;
  public boolean q = false;
  public int r = 0;
  public boolean s = false;
  public boolean t = false;
  public int u = 0;
  public int v = 0;
  public int w = 1;
  public String x;
  public long y;
  public int z;
  
  public beb()
  {
    C = a;
  }
  
  public static long a(Context paramContext, String paramString1, String paramString2)
  {
    return bhn.a(paramContext, a, B, "accountKey=? AND syncServerId=?", new String[] { paramString2, paramString1 }, null, Long.valueOf(-1L)).longValue();
  }
  
  public static beb a(Context paramContext, long paramLong)
  {
    return (beb)bdv.a(paramContext, beb.class, a, g, paramLong);
  }
  
  public static void a()
  {
    Object localObject = String.valueOf(bdv.H);
    localObject = Uri.parse(String.valueOf(localObject).length() + 8 + (String)localObject + "/message");
    a = (Uri)localObject;
    b = a((Uri)localObject, 1);
    localObject = String.valueOf(bdv.H);
    c = Uri.parse(String.valueOf(localObject).length() + 14 + (String)localObject + "/syncedMessage");
    localObject = String.valueOf(bdv.H);
    d = Uri.parse(String.valueOf(localObject).length() + 19 + (String)localObject + "/messageBySelection");
    localObject = String.valueOf(bdv.H);
    e = Uri.parse(String.valueOf(localObject).length() + 15 + (String)localObject + "/deletedMessage");
    localObject = String.valueOf(bdv.I);
    f = Uri.parse(String.valueOf(localObject).length() + 8 + (String)localObject + "/message");
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 5);
  }
  
  public static boolean b(int paramInt)
  {
    return (0x40000 & paramInt) != 0;
  }
  
  public static boolean c(int paramInt)
  {
    return (0x80000 & paramInt) != 0;
  }
  
  public final void a(Cursor paramCursor)
  {
    boolean bool2 = true;
    C = a;
    D = paramCursor.getLong(0);
    m = paramCursor.getString(1);
    n = paramCursor.getLong(2);
    o = paramCursor.getString(3);
    if (paramCursor.getInt(4) == 1)
    {
      bool1 = true;
      p = bool1;
      if (paramCursor.getInt(25) != 1) {
        break label613;
      }
      bool1 = true;
      label85:
      q = bool1;
      r = paramCursor.getInt(5);
      if (paramCursor.getInt(6) != 1) {
        break label618;
      }
      bool1 = true;
      label115:
      s = bool1;
      if (paramCursor.getInt(7) != 1) {
        break label623;
      }
    }
    label613:
    label618:
    label623:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      t = bool1;
      u = paramCursor.getInt(8);
      v = paramCursor.getInt(47);
      x = paramCursor.getString(9);
      y = paramCursor.getLong(19);
      z = paramCursor.getInt(10);
      P = paramCursor.getString(11);
      R = paramCursor.getString(29);
      S = paramCursor.getString(30);
      U = paramCursor.getLong(12);
      W = paramCursor.getLong(26);
      V = paramCursor.getLong(13);
      X = paramCursor.getString(14);
      Y = paramCursor.getString(15);
      Z = paramCursor.getString(16);
      aa = paramCursor.getString(17);
      ab = paramCursor.getString(18);
      ac = paramCursor.getString(20);
      af = paramCursor.getString(21);
      ag = paramCursor.getString(22);
      ah = paramCursor.getString(23);
      ai = paramCursor.getString(24);
      aj = paramCursor.getInt(27);
      ak = paramCursor.getLong(28);
      aw = paramCursor.getString(31);
      T = paramCursor.getLong(32);
      w = paramCursor.getInt(33);
      ad = paramCursor.getString(34);
      al = paramCursor.getString(35);
      am = paramCursor.getString(36);
      ao = paramCursor.getLong(37);
      ap = paramCursor.getLong(38);
      aq = paramCursor.getLong(39);
      ar = paramCursor.getLong(40);
      an = paramCursor.getString(41);
      ae = paramCursor.getLong(42);
      as = paramCursor.getString(43);
      at = paramCursor.getInt(44);
      au = paramCursor.getLong(45);
      av = paramCursor.getLong(46);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label85;
      bool1 = false;
      break label115;
    }
  }
  
  public final void a(ArrayList<ContentProviderOperation> paramArrayList)
  {
    int i1;
    Object localObject1;
    if (!h())
    {
      i1 = 1;
      if (i1 == 0) {
        break label347;
      }
      localObject1 = ContentProviderOperation.newInsert(C);
      label22:
      if (ax == null) {
        break label379;
      }
      af = bhl.b(ax);
    }
    for (;;)
    {
      paramArrayList.add(((ContentProviderOperation.Builder)localObject1).withValues(e()).build());
      Object localObject2 = new ContentValues();
      if (ax != null) {
        ((ContentValues)localObject2).put("textContent", ax);
      }
      if (ay != null) {
        ((ContentValues)localObject2).put("htmlContent", ay);
      }
      if (az != 0L) {
        ((ContentValues)localObject2).put("sourceMessageKey", Long.valueOf(az));
      }
      if (aB != 0) {
        ((ContentValues)localObject2).put("quotedTextStartPos", Integer.valueOf(aB));
      }
      int i2 = paramArrayList.size() - 1;
      if (!((ContentValues)localObject2).keySet().isEmpty())
      {
        localObject1 = ContentProviderOperation.newInsert(bds.a);
        if (i1 == 0) {
          ((ContentValues)localObject2).put("messageKey", Long.valueOf(D));
        }
        ((ContentProviderOperation.Builder)localObject1).withValues((ContentValues)localObject2);
        if (i1 != 0)
        {
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("messageKey", Integer.valueOf(i2));
          ((ContentProviderOperation.Builder)localObject1).withValueBackReferences((ContentValues)localObject2);
        }
        paramArrayList.add(((ContentProviderOperation.Builder)localObject1).build());
      }
      if (aA == null) {
        return;
      }
      localObject1 = aA.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Attachment)((Iterator)localObject1).next();
        if (i1 == 0) {
          o = D;
        }
        localObject2 = ContentProviderOperation.newInsert(Attachment.a).withValues(((Attachment)localObject2).e());
        if (i1 != 0) {
          ((ContentProviderOperation.Builder)localObject2).withValueBackReference("messageKey", i2);
        }
        paramArrayList.add(((ContentProviderOperation.Builder)localObject2).build());
      }
      i1 = 0;
      break;
      label347:
      localObject1 = ContentProviderOperation.newUpdate(C).withSelection("_id=?", new String[] { Long.toString(D) });
      break label22;
      label379:
      if (ay != null) {
        af = bhl.a(ay);
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2;
    if ((paramBoolean1) || (paramBoolean2))
    {
      u &= 0xFFFFFFFC;
      i2 = u;
      if (!paramBoolean1) {
        break label40;
      }
    }
    label40:
    for (int i1 = 1;; i1 = 2)
    {
      u = (i1 | i2);
      return;
    }
  }
  
  public final void d(int paramInt)
  {
    if ((paramInt == 8) || (paramInt == 16) || (paramInt == 32) || (paramInt == 64)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        v &= 0xFFFFFF87;
        v |= paramInt;
      }
      return;
    }
  }
  
  public final ContentValues e()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("displayName", m);
    localContentValues.put("timeStamp", Long.valueOf(n));
    localContentValues.put("subject", o);
    localContentValues.put("flagRead", Boolean.valueOf(p));
    localContentValues.put("flagSeen", Boolean.valueOf(q));
    localContentValues.put("flagLoaded", Integer.valueOf(r));
    localContentValues.put("flagFavorite", Boolean.valueOf(s));
    localContentValues.put("flagAttachment", Boolean.valueOf(t));
    localContentValues.put("flags", Integer.valueOf(u));
    localContentValues.put("flagsEas", Integer.valueOf(v));
    localContentValues.put("syncServerId", x);
    localContentValues.put("syncServerTimeStamp", Long.valueOf(y));
    localContentValues.put("clientId", Integer.valueOf(z));
    localContentValues.put("messageId", P);
    localContentValues.put("androidMessageId", Q);
    localContentValues.put("inReplyTo", R);
    localContentValues.put("mailReferences", S);
    localContentValues.put("mailboxKey", Long.valueOf(U));
    localContentValues.put("accountKey", Long.valueOf(V));
    localContentValues.put("fromList", X);
    localContentValues.put("toList", Y);
    localContentValues.put("ccList", Z);
    localContentValues.put("bccList", aa);
    localContentValues.put("replyToList", ab);
    localContentValues.put("meetingInfo", ac);
    localContentValues.put("snippet", af);
    localContentValues.put("protocolSearchInfo", ag);
    localContentValues.put("threadTopic", ah);
    localContentValues.put("syncData", ai);
    localContentValues.put("mainMailboxKey", Long.valueOf(W));
    localContentValues.put("retryCount", Integer.valueOf(aj));
    localContentValues.put("nextRetryTime", Long.valueOf(ak));
    localContentValues.put("serverThreadId", aw);
    localContentValues.put("threadId", Long.valueOf(T));
    localContentValues.put("priority", Integer.valueOf(w));
    localContentValues.put("eventUid", ad);
    localContentValues.put("eventSubject", al);
    localContentValues.put("meetingResponseComment", am);
    localContentValues.put("eventStartTime", Long.valueOf(ao));
    localContentValues.put("eventEndTime", Long.valueOf(ap));
    localContentValues.put("proposedStartTime", Long.valueOf(aq));
    localContentValues.put("proposedEndTime", Long.valueOf(ar));
    localContentValues.put("eventRecurrenceRule", an);
    localContentValues.put("draftUpsyncTimestamp", Long.valueOf(ae));
    localContentValues.put("proposeTimeFromMailRefMessageUri", as);
    localContentValues.put("proposeTimeFromMailRsvp", Integer.valueOf(at));
    localContentValues.put("proposeTimeFromMailProposedStartTime", Long.valueOf(au));
    localContentValues.put("proposeTimeFromMailProposedEndTime", Long.valueOf(av));
    return localContentValues;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    label695:
    label719:
    label724:
    label729:
    label732:
    for (;;)
    {
      return true;
      if (!(paramObject instanceof beb)) {
        return false;
      }
      paramObject = (beb)paramObject;
      if ((D == D) && (hbc.a(C, C)) && (n == n) && (hbc.a(m, m)) && (y == y) && (hbc.a(o, o)) && (p == p) && (q == q) && (r == r) && (s == s) && (t == t) && (u == u) && (hbc.a(x, x)) && (y == y) && (z == z) && (hbc.a(P, P)) && (hbc.a(Q, Q)) && (hbc.a(R, R)) && (hbc.a(S, S)) && (T == T) && (U == U) && (V == V) && (W == W) && (hbc.a(X, X)) && (hbc.a(Y, Y)) && (hbc.a(Z, Z)) && (hbc.a(aa, aa)) && (hbc.a(ab, ab)) && (hbc.a(ac, ac)) && (hbc.a(af, af)) && (hbc.a(ag, ag)) && (hbc.a(ah, ah)) && (hbc.a(ai, ai)) && (aj == aj) && (ak == ak) && (hbc.a(aw, aw)) && (hbc.a(ax, ax)) && (hbc.a(ay, ay)) && (hbc.a(aA, aA)) && (aC == aC) && (aD == aD) && (aE == aE))
      {
        if (w != w) {
          break label719;
        }
        i1 = 1;
        if ((i1 != 0) && (hbc.a(ad, ad)))
        {
          if ((!hbc.a(al, al)) || (!hbc.a(am, am)) || (!hbc.a(an, an)) || (ao != ao) || (ap != ap) || (aq != aq) || (ar != ar) || (!hbc.a(ad, ad))) {
            break label724;
          }
          i1 = 1;
          if (i1 != 0) {
            if (ae != ae) {
              break label729;
            }
          }
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label732;
        }
        return false;
        i1 = 0;
        break;
        i1 = 0;
        break label695;
      }
    }
  }
  
  public final Uri h(Context paramContext)
  {
    int i1;
    if (!h())
    {
      i1 = 1;
      if ((ax != null) || (ay != null) || ((aA != null) && (!aA.isEmpty()))) {
        break label77;
      }
      if (i1 == 0) {
        break label57;
      }
      paramContext = super.h(paramContext);
    }
    for (;;)
    {
      return paramContext;
      i1 = 0;
      break;
      label57:
      if (a(paramContext, e()) == 1) {
        return g();
      }
      return null;
      label77:
      Object localObject = new ArrayList();
      a((ArrayList)localObject);
      try
      {
        localObject = paramContext.getContentResolver().applyBatch(F, (ArrayList)localObject);
        if (i1 != 0)
        {
          paramContext = 0uri;
          D = Long.parseLong((String)paramContext.getPathSegments().get(1));
          if (aA != null)
          {
            i1 = 0;
            if (i1 >= aA.size()) {
              continue;
            }
            Attachment localAttachment = (Attachment)aA.get(i1);
            int i2 = i1 + 2;
            if (i2 < localObject.length) {}
            for (paramContext = uri;; paramContext = null)
            {
              if (paramContext != null) {
                D = Long.parseLong((String)paramContext.getPathSegments().get(1));
              }
              o = D;
              i1 += 1;
              break;
              cvm.e("Email", 54 + "Invalid index into ContentProviderResults: " + i2, new Object[0]);
            }
          }
        }
        else
        {
          return null;
        }
      }
      catch (RemoteException paramContext)
      {
        return null;
      }
      catch (OperationApplicationException paramContext)
      {
        for (;;) {}
      }
    }
    return paramContext;
  }
  
  public int hashCode()
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    long l1 = D;
    String str1 = String.valueOf(C);
    long l2 = n;
    String str2 = m;
    long l3 = y;
    String str3 = o;
    boolean bool1 = p;
    boolean bool2 = q;
    int i1 = r;
    boolean bool3 = s;
    boolean bool4 = t;
    int i2 = u;
    int i3 = v;
    int i4 = w;
    String str4 = x;
    long l4 = y;
    int i5 = z;
    String str5 = P;
    String str6 = Q;
    String str7 = R;
    String str8 = S;
    long l5 = T;
    long l6 = U;
    long l7 = V;
    long l8 = W;
    String str9 = X;
    String str10 = Y;
    String str11 = Z;
    String str12 = aa;
    String str13 = ab;
    String str14 = ac;
    String str15 = ad;
    long l9 = ae;
    String str16 = af;
    String str17 = ag;
    String str18 = ah;
    String str19 = ai;
    int i6 = aj;
    long l10 = ak;
    String str20 = al;
    String str21 = am;
    String str22 = an;
    long l11 = ao;
    long l12 = ap;
    long l13 = aq;
    long l14 = ar;
    String str23 = aw;
    String str24 = ax;
    String str25 = ay;
    long l15 = az;
    String str26 = String.valueOf(aA);
    int i7 = aB;
    boolean bool5 = aC;
    boolean bool6 = aD;
    boolean bool7 = aE;
    return String.valueOf(str1).length() + 1319 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(str11).length() + String.valueOf(str12).length() + String.valueOf(str13).length() + String.valueOf(str14).length() + String.valueOf(str15).length() + String.valueOf(str16).length() + String.valueOf(str17).length() + String.valueOf(str18).length() + String.valueOf(str19).length() + String.valueOf(str20).length() + String.valueOf(str21).length() + String.valueOf(str22).length() + String.valueOf(str23).length() + String.valueOf(str24).length() + String.valueOf(str25).length() + String.valueOf(str26).length() + "mId: " + l1 + ";\nmBaseUri: " + str1 + ";\n mTimeStamp: " + l2 + ";\n mDisplayName: " + str2 + ";\n mServerTimeStamp: " + l3 + ";\n mSubject: " + str3 + ";\n mFlagRead: " + bool1 + ";\n mFlagSeen: " + bool2 + ";\n mFlagLoaded: " + i1 + ";\n mFlagFavorite: " + bool3 + ";\n mFlagAttachment: " + bool4 + ";\n mFlags: " + i2 + ";\n mFlagsEas: " + i3 + ";\n mPriority: " + i4 + ";\n mServerId: " + str4 + ";\n mServerTimeStamp: " + l4 + ";\n mDraftInfo: " + i5 + ";\n mMessageId: " + str5 + ";\n mAndroidMessageId: " + str6 + ";\n mInReplyTo: " + str7 + ";\n mReferences: " + str8 + ";\n mThreadId: " + l5 + ";\n mMailboxKey: " + l6 + ";\n mAccountKey: " + l7 + ";\n mMainMailboxKey: " + l8 + ";\n mFrom: " + str9 + ";\n mTo: " + str10 + ";\n mCc: " + str11 + ";\n mBcc: " + str12 + ";\n mReplyTo: " + str13 + ";\n mMeetingInfo: " + str14 + ";\n mEventUid: " + str15 + ";\n mDraftsUpsyncTimestamp: " + l9 + ";\n mSnippet: " + str16 + ";\n mProtocolSearchInfo: " + str17 + ";\n mThreadTopic: " + str18 + ";\n mSyncData: " + str19 + ";\n mRetryCount: " + i6 + ";\n mNextRetryTime: " + l10 + ";\n mEventSubject: " + str20 + ";\n mMeetingResponseComment: " + str21 + ";\n mEventRecurrenceRule: " + str22 + ";\n mEventStartTime: " + l11 + ";\n mEventEndTime: " + l12 + ";\n mProposedStartTime: " + l13 + ";\n mProposedEndTime: " + l14 + ";\n mServerThreadId: " + str23 + ";\n mText: " + str24 + ";\n mHtml: " + str25 + ";\n mSourceKey: " + l15 + ";\n mAttachments: " + str26 + ";\n mQuotedTextStartPos: " + i7 + ";\n mDraftTagExists: " + bool5 + ";\n mReadTagExists: " + bool6 + ";\n mFlagTagExists: " + bool7 + ";\n ";
  }
}

/* Location:
 * Qualified Name:     beb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */