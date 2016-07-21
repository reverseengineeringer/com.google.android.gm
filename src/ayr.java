import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public final class ayr
  implements bgs
{
  public static final String a = cvl.a;
  public static final String b;
  public static final String c;
  public SQLiteDatabase d;
  private String e;
  
  static
  {
    String str1 = String.valueOf("SELECT app_indexing._id as seqno,  CASE app_indexing.action WHEN 0 THEN 'add' WHEN 1 THEN 'del' END AS action, '");
    String str2 = String.valueOf(beb.a);
    String str3 = String.valueOf("app_indexing");
    String str4 = String.valueOf("messageKey");
    String str5 = String.valueOf(a("timeStamp"));
    String str6 = String.valueOf(a("threadId"));
    String str7 = String.valueOf(a("messageId"));
    String str8 = String.valueOf(a("fromList"));
    String str9 = String.valueOf(a("toList"));
    String str10 = String.valueOf(a("ccList"));
    String str11 = String.valueOf(a("bccList"));
    String str12 = String.valueOf(a("subject"));
    String str13 = String.valueOf(a("timeStamp"));
    String str14 = String.valueOf(a("_id"));
    String str15 = String.valueOf("app_indexing");
    String str16 = String.valueOf("Message");
    String str17 = String.valueOf("messageKey");
    String str18 = String.valueOf(a("_id"));
    String str19 = String.valueOf("app_indexing");
    String str20 = String.valueOf("accountKey");
    String str21 = String.valueOf("app_indexing");
    String str22 = String.valueOf("_id");
    String str23 = String.valueOf("app_indexing");
    String str24 = String.valueOf("type");
    String str25 = String.valueOf("app_indexing");
    String str26 = String.valueOf("_id");
    b = String.valueOf(str1).length() + 336 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(str11).length() + String.valueOf(str12).length() + String.valueOf(str13).length() + String.valueOf(str14).length() + String.valueOf(str15).length() + String.valueOf(str16).length() + String.valueOf(str17).length() + String.valueOf(str18).length() + String.valueOf(str19).length() + String.valueOf(str20).length() + String.valueOf(str21).length() + String.valueOf(str22).length() + String.valueOf(str23).length() + String.valueOf(str24).length() + String.valueOf(str25).length() + String.valueOf(str26).length() + str1 + str2 + "/' || " + str3 + "." + str4 + " AS uri, " + str5 + " / 1000 AS doc_score, " + str6 + " AS section_conversation, " + str7 + " AS section_message_id, " + str8 + " AS section_from_address, " + str9 + " || x'0a' || " + str10 + " || x'0a' || " + str11 + " AS section_to_addresses, " + str12 + " AS section_subject, " + str13 + " AS section_date, " + str14 + " AS section_body,  NULL AS section_permalink  FROM " + str15 + " LEFT JOIN " + str16 + " ON " + str17 + " = " + str18 + " WHERE " + str19 + "." + str20 + " = ? AND " + str21 + "." + str22 + " > ? AND " + str23 + "." + str24 + " = 0 ORDER BY " + str25 + "." + str26 + " LIMIT ?;";
    str1 = String.valueOf("SELECT app_indexing._id AS seqno,  CASE app_indexing.action WHEN 0 THEN 'add' WHEN 1 THEN 'del' END AS action, '");
    str2 = String.valueOf(beb.a);
    str3 = String.valueOf("app_indexing");
    str4 = String.valueOf("messageKey");
    str5 = String.valueOf("Mailbox");
    str6 = String.valueOf("displayName");
    str7 = String.valueOf("app_indexing");
    str8 = String.valueOf("Mailbox");
    str9 = String.valueOf("mailboxKey");
    str10 = String.valueOf("Mailbox");
    str11 = String.valueOf("_id");
    str12 = String.valueOf("app_indexing");
    str13 = String.valueOf("accountKey");
    str14 = String.valueOf("app_indexing");
    str15 = String.valueOf("_id");
    str16 = String.valueOf("app_indexing");
    str17 = String.valueOf("type");
    str18 = String.valueOf("app_indexing");
    str19 = String.valueOf("_id");
    c = String.valueOf(str1).length() + 121 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(str11).length() + String.valueOf(str12).length() + String.valueOf(str13).length() + String.valueOf(str14).length() + String.valueOf(str15).length() + String.valueOf(str16).length() + String.valueOf(str17).length() + String.valueOf(str18).length() + String.valueOf(str19).length() + str1 + str2 + "/' || " + str3 + "." + str4 + " AS uri, ifnull(" + str5 + "." + str6 + ",'') AS tag  FROM " + str7 + " LEFT JOIN " + str8 + " ON " + str9 + "=" + str10 + "." + str11 + " WHERE " + str12 + "." + str13 + " = ? AND " + str14 + "." + str15 + " > ? AND " + str16 + "." + str17 + " = 1 ORDER BY " + str18 + "." + str19 + " LIMIT ?;";
  }
  
  public ayr(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    d = paramSQLiteDatabase;
    e = String.valueOf(paramLong);
  }
  
  private static String a(String paramString)
  {
    String str = String.valueOf("Message.");
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      return str.concat(paramString);
    }
    return new String(str);
  }
  
  public final long a()
  {
    Cursor localCursor = d.rawQuery("SELECT MIN(app_indexing._id) FROM app_indexing WHERE accountKey = ?", new String[] { e });
    if (localCursor != null) {}
    try
    {
      if (localCursor.moveToFirst())
      {
        long l = localCursor.getLong(0);
        return l;
      }
      return 0L;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public final void a(long paramLong)
  {
    cvm.b(a, "AppDataSearch: update lastCommittedSequence: %d", new Object[] { Long.valueOf(paramLong) });
    d.execSQL("DELETE FROM app_indexing WHERE _id <= ? AND accountKey = ?", new String[] { String.valueOf(paramLong), e });
  }
  
  public final long b()
  {
    Cursor localCursor = d.rawQuery("SELECT MAX(app_indexing._id) FROM app_indexing WHERE accountKey = ?", new String[] { e });
    if (localCursor != null) {}
    try
    {
      if (localCursor.moveToFirst())
      {
        long l = localCursor.getLong(0);
        return l;
      }
      return 0L;
    }
    finally
    {
      localCursor.close();
    }
  }
}

/* Location:
 * Qualified Name:     ayr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */