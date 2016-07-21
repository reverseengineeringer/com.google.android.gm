import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class ayo
  extends SQLiteOpenHelper
{
  final Context a;
  
  public ayo(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 171);
    a = paramContext;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    cvm.b("EmailProvider", "Creating EmailProvider database", new Object[0]);
    aym.b(a, paramSQLiteDatabase);
    aym.q(paramSQLiteDatabase);
    aym.r(paramSQLiteDatabase);
    aym.o(paramSQLiteDatabase);
    aym.m(paramSQLiteDatabase);
    aym.i(paramSQLiteDatabase);
    aym.g(paramSQLiteDatabase);
    aym.h(paramSQLiteDatabase);
    aym.l(paramSQLiteDatabase);
    aym.t(paramSQLiteDatabase);
    aym.b(paramSQLiteDatabase);
    aym.c(paramSQLiteDatabase);
    aym.k(paramSQLiteDatabase);
    aym.d(paramSQLiteDatabase);
    aym.e(paramSQLiteDatabase);
    chb.a(paramSQLiteDatabase);
    cgd.a(paramSQLiteDatabase);
    azz.a(paramSQLiteDatabase);
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 101) && (paramInt2 == 100))
    {
      cvm.b("EmailProvider", "Downgrade from v101 to v100", new Object[0]);
      return;
    }
    super.onDowngrade(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM Account WHERE displayName ISNULL;");
      paramSQLiteDatabase.execSQL("DELETE FROM HostAuth WHERE protocol ISNULL;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.e("EmailProvider", paramSQLiteDatabase, "Exception cleaning EmailProvider.db", new Object[0]);
      aym.a("doOpen");
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt1 < 5)
    {
      localObject1 = AccountManager.get(a).getAccountsByType("eas");
      int i = localObject1.length;
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        localObject2 = localObject1[paramInt2];
        AccountManager.get(a).removeAccount((Account)localObject2, null, null);
        paramInt2 += 1;
      }
      aym.c(a, paramSQLiteDatabase);
      aym.s(paramSQLiteDatabase);
      aym.p(paramSQLiteDatabase);
      aym.n(paramSQLiteDatabase);
      aym.j(paramSQLiteDatabase);
    }
    for (;;)
    {
      if (paramInt1 <= 127) {
        aym.H(paramSQLiteDatabase);
      }
      if (paramInt1 <= 128) {
        aym.I(paramSQLiteDatabase);
      }
      if (paramInt1 <= 129) {
        aym.J(paramSQLiteDatabase);
      }
      if (paramInt1 <= 130) {
        aym.K(paramSQLiteDatabase);
      }
      if (paramInt1 <= 132) {
        aym.L(paramSQLiteDatabase);
      }
      if (paramInt1 <= 133) {
        aym.M(paramSQLiteDatabase);
      }
      if (paramInt1 <= 134) {
        aym.N(paramSQLiteDatabase);
      }
      if (paramInt1 <= 135) {
        aym.O(paramSQLiteDatabase);
      }
      if (paramInt1 <= 136) {
        aym.P(paramSQLiteDatabase);
      }
      if (paramInt1 <= 137) {
        aym.Q(paramSQLiteDatabase);
      }
      if (paramInt1 <= 138) {
        aym.R(paramSQLiteDatabase);
      }
      if (paramInt1 <= 139) {
        aym.S(paramSQLiteDatabase);
      }
      if (paramInt1 <= 140) {
        aym.T(paramSQLiteDatabase);
      }
      if (paramInt1 <= 141) {
        aym.U(paramSQLiteDatabase);
      }
      if (paramInt1 <= 142) {
        aym.V(paramSQLiteDatabase);
      }
      if (paramInt1 <= 143) {
        aym.W(paramSQLiteDatabase);
      }
      if (paramInt1 <= 145) {
        aym.X(paramSQLiteDatabase);
      }
      if (paramInt1 <= 146) {
        aym.Y(paramSQLiteDatabase);
      }
      if (paramInt1 <= 147) {
        aym.Z(paramSQLiteDatabase);
      }
      if (paramInt1 <= 148) {
        aym.aa(paramSQLiteDatabase);
      }
      if (paramInt1 <= 149) {
        aym.ab(paramSQLiteDatabase);
      }
      if (paramInt1 <= 150) {
        aym.ac(paramSQLiteDatabase);
      }
      if (paramInt1 <= 151) {
        aym.ad(paramSQLiteDatabase);
      }
      if (paramInt1 <= 152) {
        aym.ae(paramSQLiteDatabase);
      }
      if (paramInt1 <= 153) {
        aym.af(paramSQLiteDatabase);
      }
      if (paramInt1 <= 154) {
        aym.ag(paramSQLiteDatabase);
      }
      if (paramInt1 <= 155) {
        aym.ah(paramSQLiteDatabase);
      }
      if (paramInt1 <= 156) {
        aym.ai(paramSQLiteDatabase);
      }
      if (paramInt1 <= 157) {
        aym.aj(paramSQLiteDatabase);
      }
      if (paramInt1 <= 158) {
        aym.ak(paramSQLiteDatabase);
      }
      if (paramInt1 <= 159) {
        aym.al(paramSQLiteDatabase);
      }
      if (paramInt1 <= 162) {
        aym.am(paramSQLiteDatabase);
      }
      if (paramInt1 <= 163) {
        aym.an(paramSQLiteDatabase);
      }
      if (paramInt1 <= 164) {
        aym.ao(paramSQLiteDatabase);
      }
      if (paramInt1 <= 165) {
        aym.ap(paramSQLiteDatabase);
      }
      if (paramInt1 <= 166) {
        aym.aq(paramSQLiteDatabase);
      }
      if (paramInt1 <= 167) {
        aym.ar(paramSQLiteDatabase);
      }
      if (paramInt1 <= 168) {
        aym.as(paramSQLiteDatabase);
      }
      if (paramInt1 <= 169) {
        aym.a(a);
      }
      if (paramInt1 <= 170) {
        aym.at(paramSQLiteDatabase);
      }
      return;
      if (paramInt1 == 5) {}
      try
      {
        paramSQLiteDatabase.execSQL("alter table Message add column syncServerTimeStamp integer;");
        paramSQLiteDatabase.execSQL("alter table Message_Updates add column syncServerTimeStamp integer;");
        paramSQLiteDatabase.execSQL("alter table Message_Deletes add column syncServerTimeStamp integer;");
        if (paramInt1 <= 6)
        {
          paramSQLiteDatabase.execSQL("drop trigger mailbox_delete;");
          paramSQLiteDatabase.execSQL("create trigger mailbox_delete before delete on Mailbox begin delete from Message  where mailboxKey=old._id; delete from Message_Deletes  where mailboxKey=old._id; end");
        }
        if (paramInt1 > 7) {}
      }
      catch (SQLException localSQLException31)
      {
        try
        {
          paramSQLiteDatabase.execSQL("alter table Account add column securityFlags integer;");
          if (paramInt1 > 8) {}
        }
        catch (SQLException localSQLException31)
        {
          try
          {
            paramSQLiteDatabase.execSQL("alter table Account add column securitySyncKey text;");
            paramSQLiteDatabase.execSQL("alter table Account add column signature text;");
            if (paramInt1 > 9) {}
          }
          catch (SQLException localSQLException31)
          {
            try
            {
              paramSQLiteDatabase.execSQL("alter table Message add column meetingInfo text;");
              paramSQLiteDatabase.execSQL("alter table Message_Updates add column meetingInfo text;");
              paramSQLiteDatabase.execSQL("alter table Message_Deletes add column meetingInfo text;");
              if (paramInt1 > 10) {}
            }
            catch (SQLException localSQLException31)
            {
              try
              {
                paramSQLiteDatabase.execSQL("alter table Attachment add column content text;");
                paramSQLiteDatabase.execSQL("alter table Attachment add column flags integer;");
                if (paramInt1 > 11) {}
              }
              catch (SQLException localSQLException31)
              {
                try
                {
                  paramSQLiteDatabase.execSQL("alter table Attachment add column content_bytes blob;");
                  if (paramInt1 > 12) {}
                }
                catch (SQLException localSQLException31)
                {
                  try
                  {
                    paramSQLiteDatabase.execSQL("alter table Mailbox add column messageCount integer not null default 0;");
                    aym.y(paramSQLiteDatabase);
                    if (paramInt1 > 13) {}
                  }
                  catch (SQLException localSQLException31)
                  {
                    try
                    {
                      paramSQLiteDatabase.execSQL("alter table Message add column snippet text;");
                      if (paramInt1 > 14) {}
                    }
                    catch (SQLException localSQLException31)
                    {
                      try
                      {
                        paramSQLiteDatabase.execSQL("alter table Message_Deletes add column snippet text;");
                        paramSQLiteDatabase.execSQL("alter table Message_Updates add column snippet text;");
                        if (paramInt1 > 15) {}
                      }
                      catch (SQLException localSQLException31)
                      {
                        try
                        {
                          paramSQLiteDatabase.execSQL("alter table Attachment add column accountKey integer;");
                          paramSQLiteDatabase.execSQL("update Attachment set accountKey= (SELECT Message.accountKey from Message where Message._id = Attachment.messageKey)");
                          if (paramInt1 > 16) {}
                        }
                        catch (SQLException localSQLException31)
                        {
                          try
                          {
                            paramSQLiteDatabase.execSQL("alter table Mailbox add column parentKey integer;");
                            if (paramInt1 <= 17) {
                              aym.A(paramSQLiteDatabase);
                            }
                            if (paramInt1 > 18) {}
                          }
                          catch (SQLException localSQLException31)
                          {
                            try
                            {
                              paramSQLiteDatabase.execSQL("alter table Account add column policyKey integer;");
                              paramSQLiteDatabase.execSQL("drop trigger account_delete;");
                              paramSQLiteDatabase.execSQL("create trigger account_delete before delete on Account begin delete from Mailbox where accountKey=old._id; delete from HostAuth where _id=old.hostAuthKeyRecv; delete from HostAuth where _id=old.hostAuthKeySend; delete from Policy where _id=old.policyKey; end");
                              aym.l(paramSQLiteDatabase);
                              aym.z(paramSQLiteDatabase);
                              if (paramInt1 > 19) {}
                            }
                            catch (SQLException localSQLException31)
                            {
                              try
                              {
                                paramSQLiteDatabase.execSQL("alter table Policy add column requireManualSyncRoaming integer;");
                                paramSQLiteDatabase.execSQL("alter table Policy add column dontAllowCamera integer;");
                                paramSQLiteDatabase.execSQL("alter table Policy add column dontAllowAttachments integer;");
                                paramSQLiteDatabase.execSQL("alter table Policy add column dontAllowHtml integer;");
                                paramSQLiteDatabase.execSQL("alter table Policy add column maxAttachmentSize integer;");
                                paramSQLiteDatabase.execSQL("alter table Policy add column maxTextTruncationSize integer;");
                                paramSQLiteDatabase.execSQL("alter table Policy add column maxHTMLTruncationSize integer;");
                                paramSQLiteDatabase.execSQL("alter table Policy add column maxEmailLookback integer;");
                                paramSQLiteDatabase.execSQL("alter table Policy add column maxCalendarLookback integer;");
                                paramSQLiteDatabase.execSQL("alter table Policy add column passwordRecoveryEnabled integer;");
                                if (paramInt1 <= 21)
                                {
                                  aym.a(paramSQLiteDatabase, a);
                                  paramInt2 = 22;
                                  if (paramInt2 <= 22) {
                                    aym.B(paramSQLiteDatabase);
                                  }
                                  if (paramInt2 <= 23) {
                                    aym.C(paramSQLiteDatabase);
                                  }
                                  if (paramInt2 <= 24) {
                                    aym.D(paramSQLiteDatabase);
                                  }
                                  if (paramInt2 <= 25) {
                                    aym.E(paramSQLiteDatabase);
                                  }
                                  if (paramInt2 > 26) {}
                                }
                              }
                              catch (SQLException localSQLException31)
                              {
                                for (;;)
                                {
                                  try
                                  {
                                    paramSQLiteDatabase.execSQL("alter table Message add column protocolSearchInfo text;");
                                    paramSQLiteDatabase.execSQL("alter table Message_Deletes add column protocolSearchInfo text;");
                                    paramSQLiteDatabase.execSQL("alter table Message_Updates add column protocolSearchInfo text;");
                                    if (paramInt2 > 28) {}
                                  }
                                  catch (SQLException localSQLException31)
                                  {
                                    try
                                    {
                                      paramSQLiteDatabase.execSQL("alter table Policy add column protocolPoliciesEnforced text;");
                                      paramSQLiteDatabase.execSQL("alter table Policy add column protocolPoliciesUnsupported text;");
                                      if (paramInt2 <= 29) {
                                        aym.F(paramSQLiteDatabase);
                                      }
                                      if (paramInt2 > 30) {}
                                    }
                                    catch (SQLException localSQLException31)
                                    {
                                      try
                                      {
                                        paramSQLiteDatabase.execSQL("alter table Mailbox add column uiSyncStatus integer;");
                                        paramSQLiteDatabase.execSQL("alter table Mailbox add column uiLastSyncResult integer;");
                                        if (paramInt2 > 31) {}
                                      }
                                      catch (SQLException localSQLException31)
                                      {
                                        try
                                        {
                                          paramSQLiteDatabase.execSQL("alter table Mailbox add column lastNotifiedMessageKey integer;");
                                          paramSQLiteDatabase.execSQL("alter table Mailbox add column lastNotifiedMessageCount integer;");
                                          paramSQLiteDatabase.execSQL("update Mailbox set lastNotifiedMessageKey=0 where lastNotifiedMessageKey IS NULL");
                                          paramSQLiteDatabase.execSQL("update Mailbox set lastNotifiedMessageCount=0 where lastNotifiedMessageCount IS NULL");
                                          if (paramInt2 > 32) {}
                                        }
                                        catch (SQLException localSQLException31)
                                        {
                                          try
                                          {
                                            paramSQLiteDatabase.execSQL("alter table Attachment add column uiState integer;");
                                            paramSQLiteDatabase.execSQL("alter table Attachment add column uiDestination integer;");
                                            paramSQLiteDatabase.execSQL("alter table Attachment add column uiDownloadedSize integer;");
                                            paramSQLiteDatabase.execSQL("update Attachment set uiState=3 where contentUri is not null;");
                                            if (paramInt2 > 33) {}
                                          }
                                          catch (SQLException localSQLException31)
                                          {
                                            try
                                            {
                                              paramSQLiteDatabase.execSQL("alter table Mailbox add column totalCount integer;");
                                              if (paramInt2 > 34) {}
                                            }
                                            catch (SQLException localSQLException31)
                                            {
                                              try
                                              {
                                                paramSQLiteDatabase.execSQL("update Mailbox set lastTouchedTime = 2 WHERE type = 3");
                                                paramSQLiteDatabase.execSQL("update Mailbox set lastTouchedTime = 1 WHERE type = 5");
                                                if (paramInt2 > 36) {}
                                              }
                                              catch (SQLException localSQLException31)
                                              {
                                                try
                                                {
                                                  paramSQLiteDatabase.execSQL("update Mailbox set flags=flags|64 where (flags&8)!=0 and accountKey IN (SELECT Account._id from Account,HostAuth where Account.hostAuthKeyRecv=HostAuth._id and protocol='eas')");
                                                  if (paramInt2 > 37) {}
                                                }
                                                catch (SQLException localSQLException31)
                                                {
                                                  try
                                                  {
                                                    paramSQLiteDatabase.execSQL("alter table Message add column threadTopic text;");
                                                    if (paramInt2 > 38) {}
                                                  }
                                                  catch (SQLException localSQLException31)
                                                  {
                                                    try
                                                    {
                                                      paramSQLiteDatabase.execSQL("alter table Message_Deletes add column threadTopic text;");
                                                      paramSQLiteDatabase.execSQL("alter table Message_Updates add column threadTopic text;");
                                                      if (paramInt2 <= 39) {
                                                        aym.au(paramSQLiteDatabase);
                                                      }
                                                      if (paramInt2 > 102) {}
                                                    }
                                                    catch (SQLException localSQLException31)
                                                    {
                                                      try
                                                      {
                                                        paramSQLiteDatabase.execSQL("alter table Mailbox add hierarchicalName text");
                                                        if (paramInt2 > 103) {}
                                                      }
                                                      catch (SQLException localSQLException31)
                                                      {
                                                        try
                                                        {
                                                          paramSQLiteDatabase.execSQL("alter table Message add syncData text");
                                                          if (paramInt2 > 104) {}
                                                        }
                                                        catch (SQLException localSQLException31)
                                                        {
                                                          try
                                                          {
                                                            paramSQLiteDatabase.execSQL("alter table Message_Updates add syncData text");
                                                            paramSQLiteDatabase.execSQL("alter table Message_Deletes add syncData text");
                                                            if (paramInt2 > 105) {}
                                                          }
                                                          catch (SQLException localSQLException31)
                                                          {
                                                            try
                                                            {
                                                              paramSQLiteDatabase.execSQL("alter table HostAuth add serverCert blob");
                                                              if (paramInt2 > 106) {}
                                                            }
                                                            catch (SQLException localSQLException31)
                                                            {
                                                              try
                                                              {
                                                                paramSQLiteDatabase.execSQL("alter table Message add flagSeen integer");
                                                                paramSQLiteDatabase.execSQL("alter table Message_Updates add flagSeen integer");
                                                                paramSQLiteDatabase.execSQL("alter table Message_Deletes add flagSeen integer");
                                                                if (paramInt2 > 107) {}
                                                              }
                                                              catch (SQLException localSQLException31)
                                                              {
                                                                try
                                                                {
                                                                  paramSQLiteDatabase.execSQL("alter table Attachment add column cachedFile text;");
                                                                  if (paramInt2 <= 108) {
                                                                    aym.b(paramSQLiteDatabase, a);
                                                                  }
                                                                  if (paramInt2 <= 109)
                                                                  {
                                                                    paramSQLiteDatabase.execSQL("update Mailbox set syncInterval=-2 where syncInterval<-2");
                                                                    paramSQLiteDatabase.execSQL("update Account set syncLookback=3 where syncLookback is null or syncLookback<1 or syncLookback>6");
                                                                    paramSQLiteDatabase.execSQL("update Mailbox set syncLookback=0 where syncLookback is null or syncLookback<1 or syncLookback>6");
                                                                  }
                                                                  if (paramInt2 <= 110) {
                                                                    paramSQLiteDatabase.execSQL("delete from Mailbox where type=68");
                                                                  }
                                                                  if (paramInt2 <= 111) {
                                                                    paramSQLiteDatabase.execSQL("update Mailbox set syncInterval=case when syncInterval=-1 then 0 else 1 end");
                                                                  }
                                                                  if ((paramInt2 >= 110) && (paramInt2 <= 112))
                                                                  {
                                                                    aym.y(paramSQLiteDatabase);
                                                                    aym.a(paramSQLiteDatabase);
                                                                  }
                                                                  if (paramInt2 > 113) {}
                                                                }
                                                                catch (SQLException localSQLException31)
                                                                {
                                                                  try
                                                                  {
                                                                    paramSQLiteDatabase.execSQL("alter table Mailbox add column lastFullSyncTime integer;");
                                                                    localObject1 = new ContentValues(1);
                                                                    ((ContentValues)localObject1).put("lastFullSyncTime", Integer.valueOf(0));
                                                                    paramSQLiteDatabase.update("Mailbox", (ContentValues)localObject1, null, null);
                                                                    if (paramInt2 > 114) {}
                                                                  }
                                                                  catch (SQLException localSQLException31)
                                                                  {
                                                                    try
                                                                    {
                                                                      paramSQLiteDatabase.execSQL("alter table Account add column pingDuration integer;");
                                                                      localObject1 = new ContentValues(1);
                                                                      ((ContentValues)localObject1).put("pingDuration", Integer.valueOf(0));
                                                                      paramSQLiteDatabase.update("Account", (ContentValues)localObject1, null, null);
                                                                      if (paramInt2 <= 115)
                                                                      {
                                                                        paramSQLiteDatabase.execSQL("create table MessageMove (_id integer primary key autoincrement, messageKey integer, messageServerId text, accountKey integer, status integer, srcFolderKey integer, dstFolderKey integer, srcFolderServerId text, dstFolderServerId text);");
                                                                        aym.a(paramSQLiteDatabase, "MessageMove");
                                                                        aym.b(paramSQLiteDatabase, "MessageMove");
                                                                        paramSQLiteDatabase.execSQL("create table MessageStateChange (_id integer primary key autoincrement, messageKey integer, messageServerId text, accountKey integer, status integer, oldFlagRead integer, newFlagRead integer, oldFlagFavorite integer, newFlagFavorite integer);");
                                                                        aym.a(paramSQLiteDatabase, "MessageStateChange");
                                                                        aym.b(paramSQLiteDatabase, "MessageStateChange");
                                                                      }
                                                                      if (paramInt2 <= 117)
                                                                      {
                                                                        localObject1 = String.valueOf("update Mailbox set syncInterval=0 where accountKey in (select Account._id from Account join HostAuth where HostAuth._id=Account.hostAuthKeyRecv and (HostAuth.protocol='");
                                                                        localObject2 = String.valueOf(a.getString(arh.cm));
                                                                        String str1 = String.valueOf("HostAuth");
                                                                        String str2 = String.valueOf("protocol");
                                                                        String str3 = String.valueOf(a.getString(arh.cl));
                                                                        String str4 = String.valueOf("HostAuth");
                                                                        String str5 = String.valueOf("protocol");
                                                                        paramSQLiteDatabase.execSQL(String.valueOf(localObject1).length() + 24 + String.valueOf(localObject2).length() + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + (String)localObject1 + (String)localObject2 + "' or " + str1 + "." + str2 + "='" + str3 + "' or " + str4 + "." + str5 + "='imap'));");
                                                                      }
                                                                      if (paramInt2 <= 118)
                                                                      {
                                                                        paramSQLiteDatabase.execSQL("update Mailbox set syncInterval=0 where type=3");
                                                                        paramSQLiteDatabase.execSQL("delete from Message where (syncServerId not null and syncServerId!='') and mailboxKey in (select _id from Mailbox where type=3)");
                                                                      }
                                                                      if (paramInt2 <= 120)
                                                                      {
                                                                        paramSQLiteDatabase.execSQL("alter table Message add mainMailboxKey integer");
                                                                        paramSQLiteDatabase.execSQL("delete from Mailbox where type=8");
                                                                      }
                                                                      if (paramInt2 <= 121)
                                                                      {
                                                                        paramSQLiteDatabase.execSQL("alter table Message_Updates add mainMailboxKey integer");
                                                                        paramSQLiteDatabase.execSQL("alter table Message_Deletes add mainMailboxKey integer");
                                                                      }
                                                                      if (paramInt2 <= 122)
                                                                      {
                                                                        if (paramInt2 >= 117) {
                                                                          aym.f(paramSQLiteDatabase);
                                                                        }
                                                                        aym.a(a, paramSQLiteDatabase);
                                                                      }
                                                                      if (paramInt2 > 123) {}
                                                                    }
                                                                    catch (SQLException localSQLException31)
                                                                    {
                                                                      try
                                                                      {
                                                                        paramSQLiteDatabase.execSQL("alter table Account add column maxAttachmentSize integer;");
                                                                        localObject1 = new ContentValues(1);
                                                                        ((ContentValues)localObject1).put("maxAttachmentSize", Integer.valueOf(0));
                                                                        paramSQLiteDatabase.update("Account", (ContentValues)localObject1, null, null);
                                                                        if (paramInt2 <= 124)
                                                                        {
                                                                          aym.b(paramSQLiteDatabase);
                                                                          paramSQLiteDatabase.execSQL("alter table HostAuth add credentialKey integer");
                                                                          paramSQLiteDatabase.execSQL("update HostAuth set credentialKey=-1");
                                                                        }
                                                                        if (paramInt2 <= 125) {
                                                                          aym.G(paramSQLiteDatabase);
                                                                        }
                                                                        if (paramInt2 > 126) {
                                                                          break;
                                                                        }
                                                                        aym.e(a, paramSQLiteDatabase);
                                                                        break;
                                                                        localSQLException1 = localSQLException1;
                                                                        cvm.d("EmailProvider", localSQLException1, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(5), Integer.valueOf(6) });
                                                                        aym.a("to_v6");
                                                                        continue;
                                                                        localSQLException2 = localSQLException2;
                                                                        cvm.d("EmailProvider", localSQLException2, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(7), Integer.valueOf(8) });
                                                                        aym.a("to_v8");
                                                                        continue;
                                                                        localSQLException3 = localSQLException3;
                                                                        cvm.d("EmailProvider", localSQLException3, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(8), Integer.valueOf(9) });
                                                                        aym.a("to_v9");
                                                                        continue;
                                                                        localSQLException4 = localSQLException4;
                                                                        cvm.d("EmailProvider", localSQLException4, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(9), Integer.valueOf(10) });
                                                                        aym.a("to_v10");
                                                                        continue;
                                                                        localSQLException5 = localSQLException5;
                                                                        cvm.d("EmailProvider", localSQLException5, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(10), Integer.valueOf(11) });
                                                                        aym.a("to_v11");
                                                                        continue;
                                                                        localSQLException6 = localSQLException6;
                                                                        cvm.d("EmailProvider", localSQLException6, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(11), Integer.valueOf(12) });
                                                                        aym.a("to_v12");
                                                                        continue;
                                                                        localSQLException7 = localSQLException7;
                                                                        cvm.d("EmailProvider", localSQLException7, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(12), Integer.valueOf(13) });
                                                                        aym.a("to_v13");
                                                                        continue;
                                                                        localSQLException8 = localSQLException8;
                                                                        cvm.d("EmailProvider", localSQLException8, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(13), Integer.valueOf(14) });
                                                                        aym.a("to_v14");
                                                                        continue;
                                                                        localSQLException9 = localSQLException9;
                                                                        cvm.d("EmailProvider", localSQLException9, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(14), Integer.valueOf(15) });
                                                                        aym.a("to_v15");
                                                                        continue;
                                                                        localSQLException10 = localSQLException10;
                                                                        cvm.d("EmailProvider", localSQLException10, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(15), Integer.valueOf(16) });
                                                                        aym.a("to_v16");
                                                                        continue;
                                                                        localSQLException11 = localSQLException11;
                                                                        cvm.d("EmailProvider", localSQLException11, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(16), Integer.valueOf(17) });
                                                                        aym.a("to_v17");
                                                                        continue;
                                                                        localSQLException12 = localSQLException12;
                                                                        cvm.d("EmailProvider", localSQLException12, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(18), Integer.valueOf(19) });
                                                                        aym.a("to_v19");
                                                                        continue;
                                                                        localSQLException13 = localSQLException13;
                                                                        cvm.d("EmailProvider", localSQLException13, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(19), Integer.valueOf(20) });
                                                                        aym.a("to_v20");
                                                                        continue;
                                                                        localSQLException14 = localSQLException14;
                                                                        cvm.d("EmailProvider", localSQLException14, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(26), Integer.valueOf(27) });
                                                                        aym.a("to_v27");
                                                                        continue;
                                                                        localSQLException15 = localSQLException15;
                                                                        cvm.d("EmailProvider", localSQLException15, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(28), Integer.valueOf(29) });
                                                                        aym.a("to_v29");
                                                                        continue;
                                                                        localSQLException16 = localSQLException16;
                                                                        cvm.d("EmailProvider", localSQLException16, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(30), Integer.valueOf(31) });
                                                                        aym.a("to_v31");
                                                                        continue;
                                                                        localSQLException17 = localSQLException17;
                                                                        cvm.d("EmailProvider", localSQLException17, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(31), Integer.valueOf(32) });
                                                                        aym.a("to_v32");
                                                                        continue;
                                                                        localSQLException18 = localSQLException18;
                                                                        cvm.d("EmailProvider", localSQLException18, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(32), Integer.valueOf(33) });
                                                                        aym.a("to_v33");
                                                                        continue;
                                                                        localSQLException19 = localSQLException19;
                                                                        cvm.d("EmailProvider", localSQLException19, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(33), Integer.valueOf(34) });
                                                                        aym.a("to_v34");
                                                                        continue;
                                                                        localSQLException20 = localSQLException20;
                                                                        cvm.d("EmailProvider", localSQLException20, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(34), Integer.valueOf(35) });
                                                                        aym.a("to_v35");
                                                                        continue;
                                                                        localSQLException21 = localSQLException21;
                                                                        cvm.d("EmailProvider", localSQLException21, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(35), Integer.valueOf(36) });
                                                                        aym.a("to_v36");
                                                                        continue;
                                                                        localSQLException22 = localSQLException22;
                                                                        cvm.d("EmailProvider", localSQLException22, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(37), Integer.valueOf(38) });
                                                                        aym.a("to_v38");
                                                                        continue;
                                                                        localSQLException23 = localSQLException23;
                                                                        cvm.d("EmailProvider", localSQLException23, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(38), Integer.valueOf(39) });
                                                                        aym.a("to_v39");
                                                                        continue;
                                                                        localSQLException24 = localSQLException24;
                                                                        cvm.d("EmailProvider", localSQLException24, "Exception upgrading EmailProvider.db from v10x to v103", new Object[0]);
                                                                        aym.a("to_v103");
                                                                        continue;
                                                                        localSQLException25 = localSQLException25;
                                                                        cvm.d("EmailProvider", localSQLException25, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(103), Integer.valueOf(104) });
                                                                        aym.a("to_v104");
                                                                        continue;
                                                                        localSQLException26 = localSQLException26;
                                                                        cvm.d("EmailProvider", localSQLException26, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(104), Integer.valueOf(105) });
                                                                        aym.a("to_v105");
                                                                        continue;
                                                                        localSQLException27 = localSQLException27;
                                                                        cvm.d("EmailProvider", localSQLException27, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(105), Integer.valueOf(106) });
                                                                        aym.a("to_v106");
                                                                        continue;
                                                                        localSQLException28 = localSQLException28;
                                                                        cvm.d("EmailProvider", localSQLException28, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(106), Integer.valueOf(107) });
                                                                        aym.a("to_v107");
                                                                        continue;
                                                                        localSQLException29 = localSQLException29;
                                                                        cvm.d("EmailProvider", localSQLException29, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(107), Integer.valueOf(108) });
                                                                        aym.a("to_v108");
                                                                        continue;
                                                                        localSQLException30 = localSQLException30;
                                                                        cvm.d("EmailProvider", localSQLException30, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(113), Integer.valueOf(114) });
                                                                        aym.a("to_v114");
                                                                        continue;
                                                                        localSQLException31 = localSQLException31;
                                                                        cvm.d("EmailProvider", localSQLException31, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(114), Integer.valueOf(115) });
                                                                        aym.a("to_v115");
                                                                      }
                                                                      catch (SQLException localSQLException32)
                                                                      {
                                                                        cvm.d("EmailProvider", localSQLException32, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(123), Integer.valueOf(124) });
                                                                        aym.a("to_v124");
                                                                        continue;
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                  paramInt2 = paramInt1;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     ayo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */