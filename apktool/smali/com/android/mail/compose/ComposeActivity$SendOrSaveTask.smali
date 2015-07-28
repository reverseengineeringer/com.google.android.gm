.class public Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;
.super Ljava/lang/Object;
.source "ComposeActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/compose/ComposeActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendOrSaveTask"
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;

.field public final mSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

.field public final mSendOrSaveMessage:Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "message"    # Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;
    .param p3, "callback"    # Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    .prologue
    .line 1796
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1797
    iput-object p1, p0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;->mContext:Landroid/content/Context;

    .line 1798
    iput-object p3, p0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;->mSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    .line 1799
    iput-object p2, p0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;->mSendOrSaveMessage:Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;

    .line 1800
    return-void
.end method


# virtual methods
.method public run()V
    .locals 17

    .prologue
    .line 1804
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;->mSendOrSaveMessage:Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;

    .line 1806
    .local v14, "sendOrSaveMessage":Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;
    iget-object v13, v14, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mAccount:Lcom/android/mail/providers/ReplyFromAccount;

    .line 1807
    .local v13, "selectedAccount":Lcom/android/mail/providers/ReplyFromAccount;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;->mSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    invoke-interface {v3}, Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;->getMessage()Lcom/android/mail/providers/Message;

    move-result-object v7

    .line 1808
    .local v7, "message":Lcom/android/mail/providers/Message;
    if-eqz v7, :cond_4

    iget-wide v9, v7, Lcom/android/mail/providers/Message;->id:J

    .line 1812
    .local v9, "messageId":J
    :goto_0
    iget-object v3, v14, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mAccount:Lcom/android/mail/providers/ReplyFromAccount;

    invoke-virtual {v13, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 1813
    const-wide/16 v3, -0x1

    cmp-long v3, v9, v3

    if-eqz v3, :cond_1

    .line 1814
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 1815
    .local v1, "resolver":Landroid/content/ContentResolver;
    new-instance v15, Landroid/content/ContentValues;

    invoke-direct {v15}, Landroid/content/ContentValues;-><init>()V

    .line 1816
    .local v15, "values":Landroid/content/ContentValues;
    const-string v3, "_id"

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v15, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1817
    iget-object v3, v13, Lcom/android/mail/providers/ReplyFromAccount;->account:Lcom/android/mail/providers/Account;

    iget-object v3, v3, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    if-eqz v3, :cond_0

    .line 1818
    iget-object v3, v13, Lcom/android/mail/providers/ReplyFromAccount;->account:Lcom/android/mail/providers/Account;

    iget-object v3, v3, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v1, v3, v15, v4, v5}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1824
    :cond_0
    const-wide/16 v9, -0x1

    .line 1828
    .end local v1    # "resolver":Landroid/content/ContentResolver;
    .end local v15    # "values":Landroid/content/ContentValues;
    :cond_1
    move-wide v11, v9

    .line 1829
    .local v11, "messageIdToSave":J
    const-wide/16 v3, -0x1

    cmp-long v3, v11, v3

    if-eqz v3, :cond_6

    .line 1830
    iget-object v3, v14, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mValues:Landroid/content/ContentValues;

    const-string v4, "_id"

    invoke-static {v11, v12}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1831
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    iget-boolean v3, v14, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mSave:Z

    if-eqz v3, :cond_5

    iget-object v3, v7, Lcom/android/mail/providers/Message;->saveUri:Ljava/lang/String;

    :goto_1
    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    iget-object v5, v14, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mValues:Landroid/content/ContentValues;

    const/4 v6, 0x0

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v4, v3, v5, v6, v0}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1858
    :cond_2
    :goto_2
    iget-boolean v3, v14, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mSave:Z

    if-nez v3, :cond_3

    .line 1859
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;->mContext:Landroid/content/Context;

    iget-object v3, v14, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mValues:Landroid/content/ContentValues;

    const-string v5, "toAddresses"

    invoke-virtual {v3, v5}, Landroid/content/ContentValues;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v4, v3}, Lcom/android/mail/providers/UIProvider;->incrementRecipientsTimesContacted(Landroid/content/Context;Ljava/lang/String;)V

    .line 1861
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;->mContext:Landroid/content/Context;

    iget-object v3, v14, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mValues:Landroid/content/ContentValues;

    const-string v5, "ccAddresses"

    invoke-virtual {v3, v5}, Landroid/content/ContentValues;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v4, v3}, Lcom/android/mail/providers/UIProvider;->incrementRecipientsTimesContacted(Landroid/content/Context;Ljava/lang/String;)V

    .line 1863
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;->mContext:Landroid/content/Context;

    iget-object v3, v14, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mValues:Landroid/content/ContentValues;

    const-string v5, "bccAddresses"

    invoke-virtual {v3, v5}, Landroid/content/ContentValues;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v4, v3}, Lcom/android/mail/providers/UIProvider;->incrementRecipientsTimesContacted(Landroid/content/Context;Ljava/lang/String;)V

    .line 1866
    :cond_3
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;->mSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    const/4 v4, 0x1

    move-object/from16 v0, p0

    invoke-interface {v3, v0, v4}, Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;->sendOrSaveFinished(Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;Z)V

    .line 1867
    return-void

    .line 1808
    .end local v9    # "messageId":J
    .end local v11    # "messageIdToSave":J
    :cond_4
    const-wide/16 v9, -0x1

    goto/16 :goto_0

    .line 1831
    .restart local v9    # "messageId":J
    .restart local v11    # "messageIdToSave":J
    :cond_5
    iget-object v3, v7, Lcom/android/mail/providers/Message;->sendUri:Ljava/lang/String;

    goto :goto_1

    .line 1835
    :cond_6
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 1836
    .restart local v1    # "resolver":Landroid/content/ContentResolver;
    iget-boolean v3, v14, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mSave:Z

    if-eqz v3, :cond_8

    iget-object v3, v13, Lcom/android/mail/providers/ReplyFromAccount;->account:Lcom/android/mail/providers/Account;

    iget-object v3, v3, Lcom/android/mail/providers/Account;->saveDraftUri:Landroid/net/Uri;

    :goto_3
    iget-object v4, v14, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mValues:Landroid/content/ContentValues;

    invoke-virtual {v1, v3, v4}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v2

    .line 1840
    .local v2, "messageUri":Landroid/net/Uri;
    iget-boolean v3, v14, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mSave:Z

    if-eqz v3, :cond_2

    if-eqz v2, :cond_2

    .line 1841
    sget-object v3, Lcom/android/mail/providers/UIProvider;->MESSAGE_PROJECTION:[Ljava/lang/String;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 1843
    .local v8, "messageCursor":Landroid/database/Cursor;
    if-eqz v8, :cond_2

    .line 1845
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_7

    .line 1848
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;->mSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    new-instance v4, Lcom/android/mail/providers/Message;

    invoke-direct {v4, v8}, Lcom/android/mail/providers/Message;-><init>(Landroid/database/Cursor;)V

    invoke-interface {v3, v14, v4}, Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;->notifyMessageIdAllocated(Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;Lcom/android/mail/providers/Message;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1852
    :cond_7
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    goto/16 :goto_2

    .line 1836
    .end local v2    # "messageUri":Landroid/net/Uri;
    .end local v8    # "messageCursor":Landroid/database/Cursor;
    :cond_8
    iget-object v3, v13, Lcom/android/mail/providers/ReplyFromAccount;->account:Lcom/android/mail/providers/Account;

    iget-object v3, v3, Lcom/android/mail/providers/Account;->sendMessageUri:Landroid/net/Uri;

    goto :goto_3

    .line 1852
    .restart local v2    # "messageUri":Landroid/net/Uri;
    .restart local v8    # "messageCursor":Landroid/database/Cursor;
    :catchall_0
    move-exception v3

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v3
.end method
