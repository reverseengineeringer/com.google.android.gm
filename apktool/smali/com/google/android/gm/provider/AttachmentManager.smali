.class public Lcom/google/android/gm/provider/AttachmentManager;
.super Ljava/lang/Object;
.source "AttachmentManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;
    }
.end annotation


# static fields
.field public static ATTACHMENT_FROM:Ljava/lang/String;

.field private static final ATTACHMENT_NAME_STATUS_PROJECTION:[Ljava/lang/String;

.field private static final ATTACHMENT_PROJECTION:[Ljava/lang/String;

.field private static final sAccountsMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static sRandom:Ljava/util/Random;


# instance fields
.field private final mAccount:Ljava/lang/String;

.field private final mAccountManager:Landroid/accounts/AccountManager;

.field private final mContentResolver:Landroid/content/ContentResolver;

.field private final mContext:Landroid/content/Context;

.field private final mDb:Landroid/database/sqlite/SQLiteDatabase;

.field private final mDownloadManager:Landroid/app/DownloadManager;

.field private final mRestrictedMailEngine:Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;

.field private final mUrls:Lcom/google/android/gm/provider/Urls;

.field private mUsedSpace:J


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 47
    const-string v0, "attachment_from_sender"

    sput-object v0, Lcom/google/android/gm/provider/AttachmentManager;->ATTACHMENT_FROM:Ljava/lang/String;

    .line 95
    new-array v0, v4, [Ljava/lang/String;

    const-string v1, "filename"

    aput-object v1, v0, v2

    const-string v1, "status"

    aput-object v1, v0, v3

    sput-object v0, Lcom/google/android/gm/provider/AttachmentManager;->ATTACHMENT_NAME_STATUS_PROJECTION:[Ljava/lang/String;

    .line 98
    const/16 v0, 0x9

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "attachments._id"

    aput-object v1, v0, v2

    const-string v1, "messages_conversation"

    aput-object v1, v0, v3

    const-string v1, "messages_messageId"

    aput-object v1, v0, v4

    const/4 v1, 0x3

    const-string v2, "messages_partId"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "desiredRendition"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "saveToSd"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "filename"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "mimeType"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "fromAddress"

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/gm/provider/AttachmentManager;->ATTACHMENT_PROJECTION:[Ljava/lang/String;

    .line 105
    new-instance v0, Ljava/util/Random;

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v1

    invoke-direct {v0, v1, v2}, Ljava/util/Random;-><init>(J)V

    sput-object v0, Lcom/google/android/gm/provider/AttachmentManager;->sRandom:Ljava/util/Random;

    .line 142
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/AttachmentManager;->sAccountsMap:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Lcom/google/android/gm/provider/Urls;Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p4, "urls"    # Lcom/google/android/gm/provider/Urls;
    .param p5, "restrictedMailEngine"    # Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;

    .prologue
    .line 155
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 156
    iput-object p1, p0, Lcom/google/android/gm/provider/AttachmentManager;->mContext:Landroid/content/Context;

    .line 157
    iput-object p2, p0, Lcom/google/android/gm/provider/AttachmentManager;->mAccount:Ljava/lang/String;

    .line 158
    iput-object p3, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    .line 159
    iput-object p4, p0, Lcom/google/android/gm/provider/AttachmentManager;->mUrls:Lcom/google/android/gm/provider/Urls;

    .line 160
    iput-object p5, p0, Lcom/google/android/gm/provider/AttachmentManager;->mRestrictedMailEngine:Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;

    .line 161
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mContentResolver:Landroid/content/ContentResolver;

    .line 162
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mContext:Landroid/content/Context;

    const-string v1, "download"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/DownloadManager;

    iput-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDownloadManager:Landroid/app/DownloadManager;

    .line 163
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mContext:Landroid/content/Context;

    invoke-static {v0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mAccountManager:Landroid/accounts/AccountManager;

    .line 164
    invoke-direct {p0, p2}, Lcom/google/android/gm/provider/AttachmentManager;->getUsedSpacePerAccount(Ljava/lang/String;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mUsedSpace:J

    .line 166
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mRestrictedMailEngine:Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;

    new-instance v1, Lcom/google/android/gm/provider/AttachmentManager$1;

    invoke-direct {v1, p0}, Lcom/google/android/gm/provider/AttachmentManager$1;-><init>(Lcom/google/android/gm/provider/AttachmentManager;)V

    invoke-interface {v0, v1}, Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;->postBackgroundTask(Ljava/lang/Runnable;)V

    .line 173
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mRestrictedMailEngine:Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;

    invoke-interface {v0}, Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;->enqueueAttachmentDownloadTask()V

    .line 174
    return-void
.end method

.method public static canDownloadAttachment(Landroid/content/Context;Lcom/google/android/gm/provider/Gmail$Attachment;)Z
    .locals 7

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 1336
    const-string v0, "connectivity"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 1339
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 1340
    if-nez v0, :cond_1

    .line 1348
    :cond_0
    :goto_0
    return v1

    .line 1342
    :cond_1
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v3

    if-eqz v3, :cond_2

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v3

    if-eqz v3, :cond_2

    move v1, v2

    .line 1343
    goto :goto_0

    .line 1344
    :cond_2
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v3

    if-nez v3, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1345
    invoke-static {p0}, Landroid/app/DownloadManager;->getMaxBytesOverMobile(Landroid/content/Context;)Ljava/lang/Long;

    move-result-object v0

    .line 1346
    if-eqz v0, :cond_3

    iget v3, p1, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I

    int-to-long v3, v3

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    cmp-long v0, v3, v5

    if-gtz v0, :cond_4

    :cond_3
    move v0, v2

    :goto_1
    move v1, v0

    goto :goto_0

    :cond_4
    move v0, v1

    goto :goto_1
.end method

.method private copyAttachment(JJJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 18

    .prologue
    .line 1205
    if-eqz p9, :cond_5

    sget-object v2, Landroid/os/Environment;->DIRECTORY_DOWNLOADS:Ljava/lang/String;

    invoke-static {v2}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    .line 1208
    :goto_0
    move-object/from16 v0, p10

    invoke-static {v2, v0}, Lcom/google/android/gm/provider/AttachmentManager;->getUniqueFileName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 1213
    :try_start_0
    invoke-static/range {p11 .. p12}, Lcom/google/android/gm/provider/AttachmentManager;->isDownloadIdValid(J)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 1214
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDownloadManager:Landroid/app/DownloadManager;

    move-wide/from16 v0, p11

    invoke-virtual {v2, v0, v1}, Landroid/app/DownloadManager;->openDownloadedFile(J)Landroid/os/ParcelFileDescriptor;

    move-result-object v3

    .line 1215
    new-instance v2, Landroid/os/ParcelFileDescriptor$AutoCloseInputStream;

    invoke-direct {v2, v3}, Landroid/os/ParcelFileDescriptor$AutoCloseInputStream;-><init>(Landroid/os/ParcelFileDescriptor;)V

    move-object v15, v2

    .line 1219
    :goto_1
    new-instance v17, Ljava/io/FileOutputStream;

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-direct {v0, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_2

    .line 1233
    :try_start_1
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v3

    .line 1234
    const/16 v2, 0x1000

    new-array v5, v2, [B

    .line 1235
    const/4 v2, 0x0

    move v14, v2

    .line 1237
    :goto_2
    invoke-virtual {v15, v5}, Ljava/io/InputStream;->read([B)I

    move-result v6

    .line 1238
    const/4 v2, -0x1

    if-eq v6, v2, :cond_8

    .line 1239
    const/4 v2, 0x0

    move-object/from16 v0, v17

    invoke-virtual {v0, v5, v2, v6}, Ljava/io/FileOutputStream;->write([BII)V

    .line 1241
    add-int v2, v14, v6

    .line 1243
    if-nez p9, :cond_0

    .line 1244
    move-object/from16 v0, p0

    iget-wide v7, v0, Lcom/google/android/gm/provider/AttachmentManager;->mUsedSpace:J

    int-to-long v9, v6

    add-long v6, v7, v9

    move-object/from16 v0, p0

    iput-wide v6, v0, Lcom/google/android/gm/provider/AttachmentManager;->mUsedSpace:J

    .line 1249
    :cond_0
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v6

    sub-long/2addr v6, v3

    const-wide/32 v8, 0x36ee80

    cmp-long v6, v6, v8

    if-lez v6, :cond_7

    .line 1250
    new-instance v2, Ljava/io/IOException;

    const-string v3, "Timed out reading attachment data."

    invoke-direct {v2, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 1284
    :catch_0
    move-exception v2

    .line 1286
    const-string v3, "Gmail"

    const-string v4, "Cannot write to file %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v16, v5, v6

    invoke-static {v3, v2, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1287
    new-instance v2, Ljava/io/File;

    move-object/from16 v0, v16

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    .line 1289
    const/16 v12, 0x3e8

    const/4 v13, 0x0

    move-object/from16 v2, p0

    move-wide/from16 v3, p1

    move-wide/from16 v5, p3

    move-wide/from16 v7, p5

    move-object/from16 v9, p7

    move-object/from16 v10, p8

    move/from16 v11, p9

    invoke-direct/range {v2 .. v13}, Lcom/google/android/gm/provider/AttachmentManager;->onAttachmentDownloadFinished(JJJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZILjava/lang/String;)V

    .line 1294
    :cond_1
    :goto_3
    :try_start_2
    invoke-static/range {p11 .. p12}, Lcom/google/android/gm/provider/AttachmentManager;->isDownloadIdValid(J)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1296
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDownloadManager:Landroid/app/DownloadManager;

    const/4 v3, 0x1

    new-array v3, v3, [J

    const/4 v4, 0x0

    aput-wide p11, v3, v4

    invoke-virtual {v2, v3}, Landroid/app/DownloadManager;->remove([J)I
    :try_end_2
    .catch Ljava/lang/NullPointerException; {:try_start_2 .. :try_end_2} :catch_4

    .line 1303
    :cond_2
    :goto_4
    if-eqz v15, :cond_3

    .line 1304
    :try_start_3
    invoke-virtual {v15}, Ljava/io/InputStream;->close()V

    .line 1306
    :cond_3
    if-eqz v17, :cond_4

    .line 1307
    invoke-virtual/range {v17 .. v17}, Ljava/io/FileOutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_5

    .line 1311
    :cond_4
    :goto_5
    return-void

    .line 1205
    :cond_5
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentManager;->mAccount:Ljava/lang/String;

    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lcom/google/android/gm/provider/AttachmentManager;->getCacheDir(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 1217
    :cond_6
    :try_start_4
    new-instance v2, Ljava/io/FileInputStream;

    invoke-static/range {p13 .. p13}, Lcom/google/android/gm/provider/AttachmentManager;->getPathFromUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V
    :try_end_4
    .catch Ljava/io/FileNotFoundException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/NullPointerException; {:try_start_4 .. :try_end_4} :catch_2

    move-object v15, v2

    goto/16 :goto_1

    .line 1220
    :catch_1
    move-exception v2

    .line 1221
    const-string v2, "Gmail"

    const-string v3, "File not found for download %d or file %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static/range {p11 .. p12}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object p13, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1222
    const/16 v12, 0x194

    const/4 v13, 0x0

    move-object/from16 v2, p0

    move-wide/from16 v3, p1

    move-wide/from16 v5, p3

    move-wide/from16 v7, p5

    move-object/from16 v9, p7

    move-object/from16 v10, p8

    move/from16 v11, p9

    invoke-direct/range {v2 .. v13}, Lcom/google/android/gm/provider/AttachmentManager;->onAttachmentDownloadFinished(JJJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZILjava/lang/String;)V

    goto :goto_5

    .line 1225
    :catch_2
    move-exception v2

    .line 1226
    const-string v2, "Gmail"

    const-string v3, "This maybe called from tests where we don\'t have Download Manager."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1227
    const/16 v12, 0xc8

    const/4 v13, 0x0

    move-object/from16 v2, p0

    move-wide/from16 v3, p1

    move-wide/from16 v5, p3

    move-wide/from16 v7, p5

    move-object/from16 v9, p7

    move-object/from16 v10, p8

    move/from16 v11, p9

    invoke-direct/range {v2 .. v13}, Lcom/google/android/gm/provider/AttachmentManager;->onAttachmentDownloadFinished(JJJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZILjava/lang/String;)V

    goto :goto_5

    :cond_7
    move v14, v2

    .line 1252
    goto/16 :goto_2

    .line 1254
    :cond_8
    :try_start_5
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "file://"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 1255
    const/16 v12, 0xc8

    move-object/from16 v2, p0

    move-wide/from16 v3, p1

    move-wide/from16 v5, p3

    move-wide/from16 v7, p5

    move-object/from16 v9, p7

    move-object/from16 v10, p8

    move/from16 v11, p9

    invoke-direct/range {v2 .. v13}, Lcom/google/android/gm/provider/AttachmentManager;->onAttachmentDownloadFinished(JJJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZILjava/lang/String;)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0

    .line 1259
    if-eqz p9, :cond_1

    .line 1260
    if-nez p15, :cond_a

    move-object/from16 v4, p16

    .line 1262
    :goto_6
    if-nez v4, :cond_9

    move-object/from16 v4, p10

    .line 1269
    :cond_9
    :try_start_6
    invoke-static/range {p10 .. p10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_b

    move-object/from16 v3, p10

    .line 1271
    :goto_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDownloadManager:Landroid/app/DownloadManager;

    const/4 v5, 0x1

    int-to-long v8, v14

    const/4 v10, 0x0

    move-object/from16 v6, p14

    move-object/from16 v7, v16

    invoke-virtual/range {v2 .. v10}, Landroid/app/DownloadManager;->addCompletedDownload(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JZ)J
    :try_end_6
    .catch Ljava/lang/IllegalArgumentException; {:try_start_6 .. :try_end_6} :catch_3
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_0

    .line 1280
    :goto_8
    :try_start_7
    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.MEDIA_SCANNER_SCAN_FILE"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1281
    invoke-static {v13}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 1282
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/AttachmentManager;->mContext:Landroid/content/Context;

    invoke-virtual {v3, v2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_3

    .line 1260
    :cond_a
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p15, v2, v3

    move-object/from16 v0, p17

    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_0

    move-result-object v4

    goto :goto_6

    .line 1269
    :cond_b
    :try_start_8
    invoke-static/range {v16 .. v16}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;
    :try_end_8
    .catch Ljava/lang/IllegalArgumentException; {:try_start_8 .. :try_end_8} :catch_3
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_0

    move-result-object v3

    goto :goto_7

    .line 1275
    :catch_3
    move-exception v2

    .line 1278
    :try_start_9
    const-string v3, "Gmail"

    const-string v4, "Failed to save download to Downloads app."

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v3, v2, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_0

    goto :goto_8

    .line 1298
    :catch_4
    move-exception v2

    .line 1299
    const-string v2, "Gmail"

    const-string v3, "This maybe called from tests where we don\'t have Download Manager."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto/16 :goto_4

    .line 1309
    :catch_5
    move-exception v2

    goto/16 :goto_5
.end method

.method private deleteAttachment(JJLjava/lang/String;)V
    .locals 7
    .param p1, "conversationId"    # J
    .param p3, "attachmentId"    # J
    .param p5, "fileUri"    # Ljava/lang/String;

    .prologue
    const/4 v3, -0x1

    .line 592
    if-eqz p5, :cond_0

    .line 593
    new-instance v1, Ljava/io/File;

    invoke-static {p5}, Lcom/google/android/gm/provider/AttachmentManager;->getPathFromUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    .line 600
    :cond_0
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 601
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "status"

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 602
    const-string v1, "downloadId"

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 603
    iget-object v1, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "attachments"

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p3, p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v1, v2, v0, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 605
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/AttachmentManager;->notifyChanged(J)V

    .line 606
    return-void
.end method

.method public static getAccountFromDownloadId(J)Ljava/lang/String;
    .locals 2
    .param p0, "downloadId"    # J

    .prologue
    .line 151
    sget-object v0, Lcom/google/android/gm/provider/AttachmentManager;->sAccountsMap:Ljava/util/Map;

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method private getCacheDir(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 236
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getPathFromUri(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "fileUri"    # Ljava/lang/String;

    .prologue
    .line 263
    const-string v0, "file://"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 264
    const/4 v0, 0x7

    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    .line 266
    :cond_0
    return-object p0
.end method

.method private static getUniqueFileName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p0, "path"    # Ljava/lang/String;
    .param p1, "fileName"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x0

    const/4 v9, -0x1

    .line 1140
    const/16 v8, 0x2e

    invoke-virtual {p1, v8}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v1

    .line 1141
    .local v1, "dotPosition":I
    const-string v2, ""

    .line 1142
    .local v2, "extension":Ljava/lang/String;
    if-eq v1, v9, :cond_0

    .line 1143
    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    .line 1144
    const/4 v8, 0x0

    invoke-virtual {p1, v8, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    .line 1149
    :cond_0
    sget-char v8, Ljava/io/File;->separatorChar:C

    invoke-virtual {p1, v8}, Ljava/lang/String;->indexOf(I)I

    move-result v8

    if-eq v8, v9, :cond_1

    .line 1150
    sget-char v8, Ljava/io/File;->separatorChar:C

    const/16 v9, 0x5f

    invoke-virtual {p1, v8, v9}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object p1

    .line 1154
    :cond_1
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1155
    .local v0, "dir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v8

    if-nez v8, :cond_5

    .line 1156
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 1162
    :cond_2
    sget-object v8, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {p0, v8}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_3

    .line 1163
    sget-object v8, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {p0, v8}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    .line 1166
    :cond_3
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1167
    .local v3, "fullFileName":Ljava/lang/String;
    new-instance v8, Ljava/io/File;

    invoke-direct {v8, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-nez v8, :cond_6

    .line 1193
    .end local v3    # "fullFileName":Ljava/lang/String;
    :cond_4
    :goto_0
    return-object v3

    .line 1157
    :cond_5
    invoke-virtual {v0}, Ljava/io/File;->isDirectory()Z

    move-result v8

    if-nez v8, :cond_2

    move-object v3, v7

    .line 1158
    goto :goto_0

    .line 1170
    .restart local v3    # "fullFileName":Ljava/lang/String;
    :cond_6
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "-"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 1183
    const/4 v6, 0x1

    .line 1184
    .local v6, "sequence":I
    const/4 v5, 0x1

    .local v5, "magnitude":I
    :goto_1
    const v8, 0x3b9aca00

    if-ge v5, v8, :cond_8

    .line 1185
    const/4 v4, 0x0

    .local v4, "iteration":I
    :goto_2
    const/16 v8, 0x9

    if-ge v4, v8, :cond_7

    .line 1186
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1187
    new-instance v8, Ljava/io/File;

    invoke-direct {v8, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_4

    .line 1190
    sget-object v8, Lcom/google/android/gm/provider/AttachmentManager;->sRandom:Ljava/util/Random;

    invoke-virtual {v8, v5}, Ljava/util/Random;->nextInt(I)I

    move-result v8

    add-int/lit8 v8, v8, 0x1

    add-int/2addr v6, v8

    .line 1185
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 1184
    :cond_7
    mul-int/lit8 v5, v5, 0xa

    goto :goto_1

    .end local v4    # "iteration":I
    :cond_8
    move-object v3, v7

    .line 1193
    goto :goto_0
.end method

.method private getUsedSpacePerAccount(Ljava/lang/String;)J
    .locals 9
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 246
    const-wide/16 v5, 0x0

    .line 247
    .local v5, "usedSpace":J
    new-instance v0, Ljava/io/File;

    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/AttachmentManager;->getCacheDir(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v0, v7}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 248
    .local v0, "accountDir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v7

    if-eqz v7, :cond_0

    .line 249
    invoke-virtual {v0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v1

    .local v1, "arr$":[Ljava/io/File;
    array-length v4, v1

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v2, v1, v3

    .line 250
    .local v2, "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->length()J

    move-result-wide v7

    add-long/2addr v5, v7

    .line 249
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 253
    .end local v1    # "arr$":[Ljava/io/File;
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    :cond_0
    return-wide v5
.end method

.method private static isDownloadIdValid(J)Z
    .locals 2
    .param p0, "downloadId"    # J

    .prologue
    .line 226
    const-wide/16 v0, -0x1

    cmp-long v0, p0, v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isDownloadStillPresent(Ljava/lang/String;)Z
    .locals 2
    .param p0, "fileUri"    # Ljava/lang/String;

    .prologue
    .line 582
    new-instance v0, Ljava/io/File;

    invoke-static {p0}, Lcom/google/android/gm/provider/AttachmentManager;->getPathFromUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    return v0
.end method

.method private isLowSpace()Z
    .locals 13

    .prologue
    const/high16 v12, 0x3e800000    # 0.25f

    const/4 v9, 0x0

    .line 275
    iget-object v10, p0, Lcom/google/android/gm/provider/AttachmentManager;->mContext:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v0

    .line 276
    .local v0, "cacheDir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->getTotalSpace()J

    move-result-wide v5

    .line 277
    .local v5, "totalSpace":J
    invoke-virtual {v0}, Ljava/io/File;->getUsableSpace()J

    move-result-wide v7

    .line 278
    .local v7, "usableSpace":J
    const/4 v2, 0x1

    .line 281
    .local v2, "numberOfAccounts":I
    :try_start_0
    iget-object v10, p0, Lcom/google/android/gm/provider/AttachmentManager;->mAccountManager:Landroid/accounts/AccountManager;

    invoke-virtual {v10}, Landroid/accounts/AccountManager;->getAccounts()[Landroid/accounts/Account;

    move-result-object v10

    array-length v2, v10
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    .line 289
    long-to-float v10, v5

    mul-float/2addr v10, v12

    int-to-float v11, v2

    div-float/2addr v10, v11

    float-to-long v3, v10

    .line 292
    .local v3, "perAccountSpace":J
    iget-wide v10, p0, Lcom/google/android/gm/provider/AttachmentManager;->mUsedSpace:J

    cmp-long v10, v10, v3

    if-ltz v10, :cond_0

    .line 293
    const-wide/16 v10, 0x0

    iput-wide v10, p0, Lcom/google/android/gm/provider/AttachmentManager;->mUsedSpace:J

    .line 294
    iget-object v10, p0, Lcom/google/android/gm/provider/AttachmentManager;->mAccount:Ljava/lang/String;

    invoke-direct {p0, v10}, Lcom/google/android/gm/provider/AttachmentManager;->getUsedSpacePerAccount(Ljava/lang/String;)J

    move-result-wide v10

    iput-wide v10, p0, Lcom/google/android/gm/provider/AttachmentManager;->mUsedSpace:J

    .line 297
    :cond_0
    long-to-float v10, v7

    long-to-float v11, v5

    mul-float/2addr v11, v12

    cmpg-float v10, v10, v11

    if-gez v10, :cond_1

    iget-wide v10, p0, Lcom/google/android/gm/provider/AttachmentManager;->mUsedSpace:J

    cmp-long v10, v10, v3

    if-ltz v10, :cond_1

    const/4 v9, 0x1

    .end local v3    # "perAccountSpace":J
    :cond_1
    :goto_0
    return v9

    .line 282
    :catch_0
    move-exception v1

    .line 283
    .local v1, "e":Ljava/lang/NullPointerException;
    const-string v10, "Gmail"

    const-string v11, "This maybe called from tests where we don\'t have Account Manager."

    new-array v12, v9, [Ljava/lang/Object;

    invoke-static {v10, v11, v12}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method public static isStatusError(I)Z
    .locals 1
    .param p0, "status"    # I

    .prologue
    .line 215
    const/16 v0, 0xc8

    if-le p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isStatusPaused(I)Z
    .locals 1
    .param p0, "status"    # I

    .prologue
    .line 201
    const/16 v0, 0xc1

    if-ne p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isStatusPending(I)Z
    .locals 1
    .param p0, "status"    # I

    .prologue
    .line 187
    const/16 v0, 0xbe

    if-ne p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isStatusRunning(I)Z
    .locals 1
    .param p0, "status"    # I

    .prologue
    .line 194
    const/16 v0, 0xc0

    if-ne p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isStatusSuccess(I)Z
    .locals 1
    .param p0, "status"    # I

    .prologue
    .line 208
    const/16 v0, 0xc8

    if-ne p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isStatusValid(I)Z
    .locals 1
    .param p0, "status"    # I

    .prologue
    .line 180
    const/4 v0, -0x1

    if-eq p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private newAttachmentCursor(JLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 9
    .param p1, "messageId"    # J
    .param p3, "partId"    # Ljava/lang/String;
    .param p4, "rendition"    # Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .param p5, "saveToSd"    # Z
    .param p6, "projection"    # [Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 703
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "attachments"

    const-string v3, "messages_messageId = ? AND messages_partId = ? AND desiredRendition = ? AND saveToSd = ?"

    const/4 v2, 0x4

    new-array v4, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v2

    const/4 v2, 0x1

    aput-object p3, v4, v2

    const/4 v2, 0x2

    invoke-virtual {p4}, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v2

    const/4 v2, 0x3

    if-eqz p5, :cond_0

    const-wide/16 v6, 0x1

    :goto_0
    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v2

    move-object v2, p6

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 708
    .local v8, "cursor":Landroid/database/Cursor;
    return-object v8

    .line 703
    .end local v8    # "cursor":Landroid/database/Cursor;
    :cond_0
    const-wide/16 v6, 0x0

    goto :goto_0
.end method

.method private notifyChanged(J)V
    .locals 4
    .param p1, "conversationId"    # J

    .prologue
    .line 316
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/provider/AttachmentManager;->mAccount:Ljava/lang/String;

    invoke-static {v1, p1, p2}, Lcom/google/android/gm/provider/Gmail;->getAttachmentsForConversationUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 320
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mAccount:Ljava/lang/String;

    invoke-static {v0, p1, p2}, Lcom/google/android/gm/provider/UiProvider;->notifyAttachmentChanged(Ljava/lang/String;J)V

    .line 321
    return-void
.end method

.method private onAttachmentDownloadFinished(JJJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZILjava/lang/String;)V
    .locals 12
    .param p1, "attachmentId"    # J
    .param p3, "conversationId"    # J
    .param p5, "messageId"    # J
    .param p7, "partId"    # Ljava/lang/String;
    .param p8, "rendition"    # Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .param p9, "saveToSd"    # Z
    .param p10, "status"    # I
    .param p11, "fileUri"    # Ljava/lang/String;

    .prologue
    .line 994
    move/from16 v0, p10

    move-object/from16 v1, p11

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/google/android/gm/provider/AttachmentManager;->updateAttachmentEntry(JILjava/lang/String;)V

    .line 996
    sget-object v2, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->BEST:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    move-object/from16 v0, p8

    if-ne v0, v2, :cond_2

    .line 998
    if-eqz p9, :cond_0

    const/4 v8, 0x1

    .line 1001
    .local v8, "destination":I
    :goto_0
    invoke-static/range {p10 .. p10}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusSuccess(I)Z

    move-result v2

    if-eqz v2, :cond_1

    const/4 v9, 0x3

    .line 1005
    .local v9, "downloadStatus":I
    :goto_1
    iget-object v2, p0, Lcom/google/android/gm/provider/AttachmentManager;->mAccount:Ljava/lang/String;

    move-wide v3, p3

    move-wide/from16 v5, p5

    move-object/from16 v7, p7

    move/from16 v10, p10

    move-object/from16 v11, p11

    invoke-static/range {v2 .. v11}, Lcom/google/android/gm/provider/UiProvider;->onAttachmentDownloadFinished(Ljava/lang/String;JJLjava/lang/String;IIILjava/lang/String;)V

    .line 1011
    .end local v8    # "destination":I
    .end local v9    # "downloadStatus":I
    :goto_2
    return-void

    .line 998
    :cond_0
    const/4 v8, 0x0

    goto :goto_0

    .line 1001
    .restart local v8    # "destination":I
    :cond_1
    const/4 v9, 0x1

    goto :goto_1

    .line 1008
    .end local v8    # "destination":I
    :cond_2
    const-string v2, "Gmail"

    const-string v3, "Dropping download finished, as this is an thumbnail attachment.  %d/%d/%d/%s"

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static/range {p5 .. p6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x3

    aput-object p7, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_2
.end method

.method private purgeAttachmentEntries(Ljava/util/List;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 634
    .local p1, "attachmentIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    .line 635
    .local v2, "numDownloads":I
    if-lez v2, :cond_2

    .line 636
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 637
    .local v3, "whereSb":Ljava/lang/StringBuilder;
    const-string v4, "_id IN ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 638
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_1

    .line 639
    if-lez v1, :cond_0

    .line 640
    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 645
    :cond_0
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 646
    .local v0, "attachmentId":Ljava/lang/Long;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "\'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Long;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 638
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 648
    .end local v0    # "attachmentId":Ljava/lang/Long;
    :cond_1
    const/16 v4, 0x29

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 650
    iget-object v4, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "attachments"

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v4, v5, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 652
    .end local v1    # "i":I
    .end local v3    # "whereSb":Ljava/lang/StringBuilder;
    :cond_2
    return-void
.end method

.method private purgeInvalidAttachments()V
    .locals 15

    .prologue
    .line 1044
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v10

    .line 1045
    .local v10, "attachmentIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v13

    .line 1046
    .local v13, "fileNames":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "attachments"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "filename"

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string v4, "saveToSd"

    aput-object v4, v2, v3

    const-string v3, "status NOT IN (?, ?, ?, ?)"

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const/16 v6, 0xbe

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const/16 v6, 0xc0

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const/16 v6, 0xc1

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x3

    const/16 v6, 0xc8

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 1054
    .local v11, "cursor":Landroid/database/Cursor;
    :goto_0
    :try_start_0
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1055
    const/4 v0, 0x0

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    .line 1056
    .local v8, "attachmentId":J
    const/4 v0, 0x1

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    .line 1057
    .local v12, "fileName":Ljava/lang/String;
    const/4 v0, 0x2

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-eqz v0, :cond_1

    const/4 v14, 0x1

    .line 1058
    .local v14, "saveToSd":Z
    :goto_1
    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v10, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1059
    if-eqz v14, :cond_0

    const/4 v12, 0x0

    .end local v12    # "fileName":Ljava/lang/String;
    :cond_0
    invoke-virtual {v13, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 1062
    .end local v8    # "attachmentId":J
    .end local v14    # "saveToSd":Z
    :catchall_0
    move-exception v0

    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    throw v0

    .line 1057
    .restart local v8    # "attachmentId":J
    .restart local v12    # "fileName":Ljava/lang/String;
    :cond_1
    const/4 v14, 0x0

    goto :goto_1

    .line 1062
    .end local v8    # "attachmentId":J
    .end local v12    # "fileName":Ljava/lang/String;
    :cond_2
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 1066
    invoke-direct {p0, v13}, Lcom/google/android/gm/provider/AttachmentManager;->purgeOldAttachmentFiles(Ljava/util/List;)V

    .line 1069
    invoke-direct {p0, v10}, Lcom/google/android/gm/provider/AttachmentManager;->purgeAttachmentEntries(Ljava/util/List;)V

    .line 1070
    return-void
.end method

.method private purgeInvalidDownloadingAttachments()V
    .locals 23

    .prologue
    .line 1076
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v12

    .line 1077
    .local v12, "attachmentIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v19

    .line 1078
    .local v19, "fileNames":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "attachments"

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "_id"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-string v6, "downloadId"

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const-string v6, "filename"

    aput-object v6, v4, v5

    const/4 v5, 0x3

    const-string v6, "saveToSd"

    aput-object v6, v4, v5

    const-string v5, "status = ?"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    const/16 v8, 0xc0

    invoke-static {v8}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual/range {v2 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v14

    .line 1083
    .local v14, "cursor":Landroid/database/Cursor;
    :cond_0
    :goto_0
    :try_start_0
    invoke-interface {v14}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 1084
    const/4 v2, 0x0

    invoke-interface {v14, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    .line 1085
    .local v10, "attachmentId":J
    const/4 v2, 0x1

    invoke-interface {v14, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v16

    .line 1086
    .local v16, "downloadId":J
    new-instance v2, Landroid/app/DownloadManager$Query;

    invoke-direct {v2}, Landroid/app/DownloadManager$Query;-><init>()V

    const/4 v3, 0x1

    new-array v3, v3, [J

    const/4 v4, 0x0

    aput-wide v16, v3, v4

    invoke-virtual {v2, v3}, Landroid/app/DownloadManager$Query;->setFilterById([J)Landroid/app/DownloadManager$Query;

    move-result-object v20

    .line 1087
    .local v20, "query":Landroid/app/DownloadManager$Query;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDownloadManager:Landroid/app/DownloadManager;

    move-object/from16 v0, v20

    invoke-virtual {v2, v0}, Landroid/app/DownloadManager;->query(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v15

    .line 1088
    .local v15, "downloadCursor":Landroid/database/Cursor;
    if-eqz v15, :cond_0

    .line 1090
    :try_start_1
    invoke-interface {v15}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1091
    const-string v2, "status"

    invoke-interface {v15, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v13

    .line 1093
    .local v13, "columnStatus":I
    invoke-interface {v15, v13}, Landroid/database/Cursor;->getInt(I)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v22

    .line 1094
    .local v22, "status":I
    const/4 v2, 0x1

    move/from16 v0, v22

    if-eq v0, v2, :cond_1

    const/4 v2, 0x2

    move/from16 v0, v22

    if-eq v0, v2, :cond_1

    const/4 v2, 0x4

    move/from16 v0, v22

    if-ne v0, v2, :cond_2

    .line 1103
    :cond_1
    :try_start_2
    invoke-interface {v15}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 1111
    .end local v10    # "attachmentId":J
    .end local v13    # "columnStatus":I
    .end local v15    # "downloadCursor":Landroid/database/Cursor;
    .end local v16    # "downloadId":J
    .end local v20    # "query":Landroid/app/DownloadManager$Query;
    .end local v22    # "status":I
    :catchall_0
    move-exception v2

    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    throw v2

    .line 1103
    .restart local v10    # "attachmentId":J
    .restart local v15    # "downloadCursor":Landroid/database/Cursor;
    .restart local v16    # "downloadId":J
    .restart local v20    # "query":Landroid/app/DownloadManager$Query;
    :cond_2
    :try_start_3
    invoke-interface {v15}, Landroid/database/Cursor;->close()V

    .line 1105
    const/4 v2, 0x2

    invoke-interface {v14, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v18

    .line 1106
    .local v18, "fileName":Ljava/lang/String;
    const/4 v2, 0x3

    invoke-interface {v14, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    if-eqz v2, :cond_4

    const/16 v21, 0x1

    .line 1107
    .local v21, "saveToSd":Z
    :goto_1
    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v12, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1108
    if-eqz v21, :cond_3

    const/16 v18, 0x0

    .end local v18    # "fileName":Ljava/lang/String;
    :cond_3
    move-object/from16 v0, v19

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1103
    .end local v21    # "saveToSd":Z
    :catchall_1
    move-exception v2

    invoke-interface {v15}, Landroid/database/Cursor;->close()V

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1106
    .restart local v18    # "fileName":Ljava/lang/String;
    :cond_4
    const/16 v21, 0x0

    goto :goto_1

    .line 1111
    .end local v10    # "attachmentId":J
    .end local v15    # "downloadCursor":Landroid/database/Cursor;
    .end local v16    # "downloadId":J
    .end local v18    # "fileName":Ljava/lang/String;
    .end local v20    # "query":Landroid/app/DownloadManager$Query;
    :cond_5
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    .line 1115
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-direct {v0, v1}, Lcom/google/android/gm/provider/AttachmentManager;->purgeOldAttachmentFiles(Ljava/util/List;)V

    .line 1118
    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Lcom/google/android/gm/provider/AttachmentManager;->purgeAttachmentEntries(Ljava/util/List;)V

    .line 1119
    return-void
.end method

.method private purgeOldAttachmentFiles(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1122
    .local p1, "fileUris":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz p1, :cond_1

    .line 1123
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1124
    .local v0, "fileUri":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 1125
    new-instance v2, Ljava/io/File;

    invoke-static {v0}, Lcom/google/android/gm/provider/AttachmentManager;->getPathFromUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    goto :goto_0

    .line 1129
    .end local v0    # "fileUri":Ljava/lang/String;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    return-void
.end method

.method private static requestDescription(JJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Ljava/lang/String;
    .locals 3
    .param p0, "conversationId"    # J
    .param p2, "messageId"    # J
    .param p4, "partId"    # Ljava/lang/String;
    .param p5, "rendition"    # Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .param p6, "saveToSd"    # Z

    .prologue
    .line 306
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "conversationId = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", messageId = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", partId = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", rendition = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p5}, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", saveToSd = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p6}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 309
    .local v0, "requestDescription":Ljava/lang/String;
    return-object v0
.end method

.method private resetAttachment(JJLjava/lang/String;)V
    .locals 7
    .param p1, "conversationId"    # J
    .param p3, "attachmentId"    # J
    .param p5, "fileUri"    # Ljava/lang/String;

    .prologue
    .line 615
    if-eqz p5, :cond_0

    .line 616
    new-instance v1, Ljava/io/File;

    invoke-static {p5}, Lcom/google/android/gm/provider/AttachmentManager;->getPathFromUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    .line 620
    :cond_0
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 621
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "status"

    const/16 v2, 0xbe

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 622
    const-string v1, "downloadId"

    const/4 v2, -0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 623
    iget-object v1, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "attachments"

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p3, p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v1, v2, v0, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 625
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/AttachmentManager;->notifyChanged(J)V

    .line 626
    return-void
.end method

.method private startAttachmentDownloadInDownloadManager(JJZ)V
    .locals 33
    .param p1, "attachmentId"    # J
    .param p3, "copyAttachmentId"    # J
    .param p5, "wifiOnly"    # Z

    .prologue
    .line 353
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->isDbLockedByCurrentThread()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 356
    const-string v3, "Gmail"

    const-string v4, "SQLiteDatabase lock held beforecalling startAttachmentDownloadInDownloadManager"

    const/16 v29, 0x0

    move/from16 v0, v29

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    invoke-static {v3, v4, v0}, Lcom/google/android/gm/provider/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 359
    :cond_0
    const/16 v3, 0x8

    new-array v5, v3, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "messages_conversation"

    aput-object v4, v5, v3

    const/4 v3, 0x1

    const-string v4, "messages_messageId"

    aput-object v4, v5, v3

    const/4 v3, 0x2

    const-string v4, "messages_partId"

    aput-object v4, v5, v3

    const/4 v3, 0x3

    const-string v4, "originExtras"

    aput-object v4, v5, v3

    const/4 v3, 0x4

    const-string v4, "downloadedRendition"

    aput-object v4, v5, v3

    const/4 v3, 0x5

    const-string v4, "saveToSd"

    aput-object v4, v5, v3

    const/4 v3, 0x6

    const-string v4, "filename"

    aput-object v4, v5, v3

    const/4 v3, 0x7

    const-string v4, "automatic"

    aput-object v4, v5, v3

    .line 362
    .local v5, "attachmentProjection":[Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "attachments"

    const-string v6, "_id = ?"

    const/16 v29, 0x1

    move/from16 v0, v29

    new-array v7, v0, [Ljava/lang/String;

    const/16 v29, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v30

    aput-object v30, v7, v29

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual/range {v3 .. v10}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v13

    .line 365
    .local v13, "attachmentCursor":Landroid/database/Cursor;
    :try_start_0
    invoke-interface {v13}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 366
    const-string v3, "Gmail"

    const-string v4, "Cannot find attachment %d"

    const/16 v29, 0x1

    move/from16 v0, v29

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v29, v0

    const/16 v30, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v31

    aput-object v31, v29, v30

    move-object/from16 v0, v29

    invoke-static {v3, v4, v0}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 450
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    .line 452
    :goto_0
    return-void

    .line 370
    :cond_1
    const/4 v3, 0x0

    :try_start_1
    invoke-interface {v13, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    .line 371
    .local v6, "conversationId":J
    const/4 v3, 0x1

    invoke-interface {v13, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    .line 372
    .local v8, "messageId":J
    const/4 v3, 0x2

    invoke-interface {v13, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 373
    .local v10, "partId":Ljava/lang/String;
    const/4 v3, 0x3

    invoke-interface {v13, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v20

    .line 374
    .local v20, "originExtras":Ljava/lang/String;
    const/4 v3, 0x4

    invoke-interface {v13, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->valueOf(Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    move-result-object v11

    .line 376
    .local v11, "rendition":Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    const/4 v3, 0x5

    invoke-interface {v13, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-eqz v3, :cond_2

    const/4 v12, 0x1

    .line 377
    .local v12, "saveToSd":Z
    :goto_1
    const/4 v3, 0x6

    invoke-interface {v13, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v18

    .line 379
    .local v18, "fileName":Ljava/lang/String;
    invoke-static/range {v6 .. v12}, Lcom/google/android/gm/provider/AttachmentManager;->requestDescription(JJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Ljava/lang/String;

    move-result-object v23

    .line 383
    .local v23, "requestDescription":Ljava/lang/String;
    sget-object v3, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->SIMPLE:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    if-eq v11, v3, :cond_3

    const/16 v19, 0x1

    .line 384
    .local v19, "fullVersion":Z
    :goto_2
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/AttachmentManager;->mUrls:Lcom/google/android/gm/provider/Urls;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/AttachmentManager;->mRestrictedMailEngine:Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;

    invoke-interface {v4}, Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;->getRequestVersion()I

    move-result v4

    const/16 v29, 0x100

    move-object/from16 v0, v20

    move/from16 v1, v29

    move/from16 v2, v19

    invoke-virtual {v3, v4, v0, v1, v2}, Lcom/google/android/gm/provider/Urls;->getFetchAttachmentUri(ILjava/lang/String;IZ)Ljava/net/URI;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v27

    .line 387
    .local v27, "uri":Ljava/net/URI;
    const/4 v14, 0x0

    .line 389
    .local v14, "authToken":Ljava/lang/String;
    :try_start_2
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/AttachmentManager;->mRestrictedMailEngine:Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;

    invoke-interface {v3}, Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;->getAuthToken()Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v14

    .line 394
    :goto_3
    if-nez v14, :cond_4

    .line 398
    :try_start_3
    const-string v3, "Gmail"

    const-string v4, "Authentication failed for attachment %d, %s"

    const/16 v29, 0x2

    move/from16 v0, v29

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v29, v0

    const/16 v30, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v31

    aput-object v31, v29, v30

    const/16 v30, 0x1

    aput-object v23, v29, v30

    move-object/from16 v0, v29

    invoke-static {v3, v4, v0}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 450
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 376
    .end local v12    # "saveToSd":Z
    .end local v14    # "authToken":Ljava/lang/String;
    .end local v18    # "fileName":Ljava/lang/String;
    .end local v19    # "fullVersion":Z
    .end local v23    # "requestDescription":Ljava/lang/String;
    .end local v27    # "uri":Ljava/net/URI;
    :cond_2
    const/4 v12, 0x0

    goto :goto_1

    .line 383
    .restart local v12    # "saveToSd":Z
    .restart local v18    # "fileName":Ljava/lang/String;
    .restart local v23    # "requestDescription":Ljava/lang/String;
    :cond_3
    const/16 v19, 0x0

    goto :goto_2

    .line 403
    .restart local v14    # "authToken":Ljava/lang/String;
    .restart local v19    # "fullVersion":Z
    .restart local v27    # "uri":Ljava/net/URI;
    :cond_4
    :try_start_4
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/AttachmentManager;->mAccount:Ljava/lang/String;

    invoke-static {v3, v14}, Lcom/google/android/gm/provider/Urls;->getCookieString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 405
    .local v15, "cookieHeader":Ljava/lang/String;
    invoke-virtual/range {v27 .. v27}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v21

    .line 406
    .local v21, "originalUrl":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/AttachmentManager;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {v3}, Lcom/google/android/common/http/UrlRules;->getRules(Landroid/content/ContentResolver;)Lcom/google/android/common/http/UrlRules;

    move-result-object v26

    .line 407
    .local v26, "rules":Lcom/google/android/common/http/UrlRules;
    move-object/from16 v0, v26

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/google/android/common/http/UrlRules;->matchRule(Ljava/lang/String;)Lcom/google/android/common/http/UrlRules$Rule;

    move-result-object v25

    .line 408
    .local v25, "rule":Lcom/google/android/common/http/UrlRules$Rule;
    move-object/from16 v0, v25

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/google/android/common/http/UrlRules$Rule;->apply(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 410
    .local v24, "rewrittenUrl":Ljava/lang/String;
    if-nez v24, :cond_5

    .line 411
    const-string v3, "Gmail"

    const-string v4, "Abandon download of %s because it is blocked by rules."

    const/16 v29, 0x1

    move/from16 v0, v29

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v29, v0

    const/16 v30, 0x0

    aput-object v27, v29, v30

    move-object/from16 v0, v29

    invoke-static {v3, v4, v0}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 413
    new-instance v28, Landroid/content/ContentValues;

    invoke-direct/range {v28 .. v28}, Landroid/content/ContentValues;-><init>()V

    .line 414
    .local v28, "values":Landroid/content/ContentValues;
    const-string v3, "status"

    const/16 v4, 0x3e8

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    move-object/from16 v0, v28

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 415
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "attachments"

    const-string v29, "_id = ? OR _id = ?"

    const/16 v30, 0x2

    move/from16 v0, v30

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v30, v0

    const/16 v31, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v32

    aput-object v32, v30, v31

    const/16 v31, 0x1

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v32

    aput-object v32, v30, v31

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v3, v4, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 448
    :goto_4
    move-object/from16 v0, p0

    invoke-direct {v0, v6, v7}, Lcom/google/android/gm/provider/AttachmentManager;->notifyChanged(J)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 450
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    goto/16 :goto_0

    .line 424
    .end local v28    # "values":Landroid/content/ContentValues;
    :cond_5
    :try_start_5
    new-instance v3, Landroid/app/DownloadManager$Request;

    invoke-static/range {v24 .. v24}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-direct {v3, v4}, Landroid/app/DownloadManager$Request;-><init>(Landroid/net/Uri;)V

    const-string v4, "Cookie"

    invoke-virtual {v3, v4, v15}, Landroid/app/DownloadManager$Request;->addRequestHeader(Ljava/lang/String;Ljava/lang/String;)Landroid/app/DownloadManager$Request;

    move-result-object v3

    move-object/from16 v0, v18

    invoke-virtual {v3, v0}, Landroid/app/DownloadManager$Request;->setTitle(Ljava/lang/CharSequence;)Landroid/app/DownloadManager$Request;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/app/DownloadManager$Request;->setVisibleInDownloadsUi(Z)Landroid/app/DownloadManager$Request;

    move-result-object v22

    .line 426
    .local v22, "request":Landroid/app/DownloadManager$Request;
    const-wide/16 v3, -0x1

    cmp-long v3, p3, v3

    if-nez v3, :cond_6

    .line 427
    const/4 v3, 0x2

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Landroid/app/DownloadManager$Request;->setNotificationVisibility(I)Landroid/app/DownloadManager$Request;

    .line 432
    :cond_6
    if-eqz p5, :cond_7

    .line 433
    const/4 v3, 0x2

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Landroid/app/DownloadManager$Request;->setAllowedNetworkTypes(I)Landroid/app/DownloadManager$Request;

    .line 436
    :cond_7
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDownloadManager:Landroid/app/DownloadManager;

    move-object/from16 v0, v22

    invoke-virtual {v3, v0}, Landroid/app/DownloadManager;->enqueue(Landroid/app/DownloadManager$Request;)J

    move-result-wide v16

    .line 437
    .local v16, "downloadId":J
    sget-object v3, Lcom/google/android/gm/provider/AttachmentManager;->sAccountsMap:Ljava/util/Map;

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gm/provider/AttachmentManager;->mAccount:Ljava/lang/String;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    invoke-interface {v3, v4, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 439
    new-instance v28, Landroid/content/ContentValues;

    invoke-direct/range {v28 .. v28}, Landroid/content/ContentValues;-><init>()V

    .line 440
    .restart local v28    # "values":Landroid/content/ContentValues;
    const-string v3, "downloadId"

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    move-object/from16 v0, v28

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 441
    const-string v3, "status"

    const/16 v4, 0xc0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    move-object/from16 v0, v28

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 442
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "attachments"

    const-string v29, "_id = ? OR _id = ?"

    const/16 v30, 0x2

    move/from16 v0, v30

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v30, v0

    const/16 v31, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v32

    aput-object v32, v30, v31

    const/16 v31, 0x1

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v32

    aput-object v32, v30, v31

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v3, v4, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 445
    const-string v3, "Gmail"

    const-string v4, "ATTACHMENT: start downloading attachment %d dlid=%d, %s"

    const/16 v29, 0x3

    move/from16 v0, v29

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v29, v0

    const/16 v30, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v31

    aput-object v31, v29, v30

    const/16 v30, 0x1

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v31

    aput-object v31, v29, v30

    const/16 v30, 0x2

    aput-object v23, v29, v30

    move-object/from16 v0, v29

    invoke-static {v3, v4, v0}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto/16 :goto_4

    .line 450
    .end local v6    # "conversationId":J
    .end local v8    # "messageId":J
    .end local v10    # "partId":Ljava/lang/String;
    .end local v11    # "rendition":Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .end local v12    # "saveToSd":Z
    .end local v14    # "authToken":Ljava/lang/String;
    .end local v15    # "cookieHeader":Ljava/lang/String;
    .end local v16    # "downloadId":J
    .end local v18    # "fileName":Ljava/lang/String;
    .end local v19    # "fullVersion":Z
    .end local v20    # "originExtras":Ljava/lang/String;
    .end local v21    # "originalUrl":Ljava/lang/String;
    .end local v22    # "request":Landroid/app/DownloadManager$Request;
    .end local v23    # "requestDescription":Ljava/lang/String;
    .end local v24    # "rewrittenUrl":Ljava/lang/String;
    .end local v25    # "rule":Lcom/google/android/common/http/UrlRules$Rule;
    .end local v26    # "rules":Lcom/google/android/common/http/UrlRules;
    .end local v27    # "uri":Ljava/net/URI;
    .end local v28    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v3

    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    throw v3

    .line 390
    .restart local v6    # "conversationId":J
    .restart local v8    # "messageId":J
    .restart local v10    # "partId":Ljava/lang/String;
    .restart local v11    # "rendition":Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .restart local v12    # "saveToSd":Z
    .restart local v14    # "authToken":Ljava/lang/String;
    .restart local v18    # "fileName":Ljava/lang/String;
    .restart local v19    # "fullVersion":Z
    .restart local v20    # "originExtras":Ljava/lang/String;
    .restart local v23    # "requestDescription":Ljava/lang/String;
    .restart local v27    # "uri":Ljava/net/URI;
    :catch_0
    move-exception v3

    goto/16 :goto_3
.end method

.method private updateAttachmentEntry(JILjava/lang/String;)V
    .locals 7
    .param p1, "attachmentId"    # J
    .param p3, "status"    # I
    .param p4, "fileUri"    # Ljava/lang/String;

    .prologue
    .line 1015
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1016
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "downloadId"

    const/4 v2, -0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1017
    if-eqz p4, :cond_0

    .line 1018
    const-string v1, "filename"

    invoke-virtual {v0, v1, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1020
    :cond_0
    const-string v1, "status"

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1021
    iget-object v1, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "attachments"

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v1, v2, v0, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1022
    return-void
.end method


# virtual methods
.method public cancelDownloadRequest(JJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)I
    .locals 13
    .param p1, "conversationId"    # J
    .param p3, "messageId"    # J
    .param p5, "partId"    # Ljava/lang/String;
    .param p6, "rendition"    # Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .param p7, "saveToSd"    # Z

    .prologue
    .line 779
    const-string v0, "Gmail"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 780
    invoke-static/range {p1 .. p7}, Lcom/google/android/gm/provider/AttachmentManager;->requestDescription(JJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Ljava/lang/String;

    move-result-object v11

    .line 782
    .local v11, "requestDescription":Ljava/lang/String;
    const-string v0, "Gmail"

    const-string v1, "cancelDownloadRequest: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v11, v2, v6

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 785
    .end local v11    # "requestDescription":Ljava/lang/String;
    :cond_0
    const/4 v0, 0x5

    new-array v6, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "_id"

    aput-object v1, v6, v0

    const/4 v0, 0x1

    const-string v1, "downloadId"

    aput-object v1, v6, v0

    const/4 v0, 0x2

    const-string v1, "automatic"

    aput-object v1, v6, v0

    const/4 v0, 0x3

    const-string v1, "status"

    aput-object v1, v6, v0

    const/4 v0, 0x4

    const-string v1, "filename"

    aput-object v1, v6, v0

    move-object v0, p0

    move-wide/from16 v1, p3

    move-object/from16 v3, p5

    move-object/from16 v4, p6

    move/from16 v5, p7

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gm/provider/AttachmentManager;->newAttachmentCursor(JLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 789
    .local v8, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 790
    const/4 v0, 0x0

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    .line 791
    .local v3, "attachmentId":J
    const/4 v0, 0x1

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v9

    .line 792
    .local v9, "downloadId":J
    const/4 v0, 0x2

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-eqz v0, :cond_2

    const/4 v7, 0x1

    .line 793
    .local v7, "automatic":Z
    :goto_0
    const/4 v0, 0x3

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v12

    .line 794
    .local v12, "status":I
    const/4 v0, 0x4

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 797
    .local v5, "fileName":Ljava/lang/String;
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDownloadManager:Landroid/app/DownloadManager;

    if-eqz v0, :cond_1

    invoke-static {v9, v10}, Lcom/google/android/gm/provider/AttachmentManager;->isDownloadIdValid(J)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 798
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDownloadManager:Landroid/app/DownloadManager;

    const/4 v1, 0x1

    new-array v1, v1, [J

    const/4 v2, 0x0

    aput-wide v9, v1, v2

    invoke-virtual {v0, v1}, Landroid/app/DownloadManager;->remove([J)I

    :cond_1
    move-object v0, p0

    move-wide v1, p1

    .line 800
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/AttachmentManager;->deleteAttachment(JJLjava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 801
    const/4 v0, 0x1

    .line 804
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 806
    .end local v3    # "attachmentId":J
    .end local v5    # "fileName":Ljava/lang/String;
    .end local v7    # "automatic":Z
    .end local v9    # "downloadId":J
    .end local v12    # "status":I
    :goto_1
    return v0

    .line 792
    .restart local v3    # "attachmentId":J
    .restart local v9    # "downloadId":J
    :cond_2
    const/4 v7, 0x0

    goto :goto_0

    .line 804
    .end local v3    # "attachmentId":J
    .end local v9    # "downloadId":J
    :cond_3
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 806
    const/4 v0, 0x0

    goto :goto_1

    .line 804
    :catchall_0
    move-exception v0

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method public enqueueAttachment(JJLcom/google/android/gm/provider/Gmail$Attachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZZI)V
    .locals 16
    .param p1, "conversationId"    # J
    .param p3, "messageId"    # J
    .param p5, "attachment"    # Lcom/google/android/gm/provider/Gmail$Attachment;
    .param p6, "rendition"    # Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .param p7, "saveToSd"    # Z
    .param p8, "automatic"    # Z
    .param p9, "priority"    # I

    .prologue
    .line 332
    const-wide/16 v8, 0x0

    move-object/from16 v1, p0

    move-wide/from16 v2, p1

    move-wide/from16 v4, p3

    move-object/from16 v6, p5

    move-object/from16 v7, p6

    move/from16 v10, p7

    move/from16 v11, p8

    move/from16 v12, p9

    invoke-virtual/range {v1 .. v12}, Lcom/google/android/gm/provider/AttachmentManager;->recordAttachmentInDb(JJLcom/google/android/gm/provider/Gmail$Attachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;JZZI)J

    move-result-wide v13

    .line 335
    .local v13, "attachmentId":J
    const-string v1, "Gmail"

    const/4 v2, 0x3

    invoke-static {v1, v2}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 336
    move-object/from16 v0, p5

    iget-object v5, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    move-wide/from16 v1, p1

    move-wide/from16 v3, p3

    move-object/from16 v6, p6

    move/from16 v7, p7

    invoke-static/range {v1 .. v7}, Lcom/google/android/gm/provider/AttachmentManager;->requestDescription(JJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Ljava/lang/String;

    move-result-object v15

    .line 338
    .local v15, "requestDescription":Ljava/lang/String;
    const-string v1, "Gmail"

    const-string v2, "enqueueAttachment attachmentId: %d: %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v13, v14}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object v15, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 342
    .end local v15    # "requestDescription":Ljava/lang/String;
    :cond_0
    invoke-direct/range {p0 .. p2}, Lcom/google/android/gm/provider/AttachmentManager;->notifyChanged(J)V

    .line 343
    return-void
.end method

.method public handleDownloadManagerIntent(Landroid/content/Intent;)V
    .locals 13
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 717
    const-string v0, "extra_download_id"

    const-wide/16 v4, -0x1

    invoke-virtual {p1, v0, v4, v5}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v1

    .line 718
    .local v1, "downloadId":J
    const-wide/16 v4, -0x1

    cmp-long v0, v1, v4

    if-nez v0, :cond_0

    .line 719
    const-string v0, "Gmail"

    const-string v4, "Received notification from DownloadManager with invalid download id"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v0, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 756
    :goto_0
    return-void

    .line 723
    :cond_0
    new-instance v0, Landroid/app/DownloadManager$Query;

    invoke-direct {v0}, Landroid/app/DownloadManager$Query;-><init>()V

    const/4 v4, 0x1

    new-array v4, v4, [J

    const/4 v5, 0x0

    aput-wide v1, v4, v5

    invoke-virtual {v0, v4}, Landroid/app/DownloadManager$Query;->setFilterById([J)Landroid/app/DownloadManager$Query;

    move-result-object v11

    .line 724
    .local v11, "query":Landroid/app/DownloadManager$Query;
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDownloadManager:Landroid/app/DownloadManager;

    invoke-virtual {v0, v11}, Landroid/app/DownloadManager;->query(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;

    move-result-object v9

    .line 726
    .local v9, "cursor":Landroid/database/Cursor;
    if-nez v9, :cond_1

    .line 727
    const-string v0, "Gmail"

    const-string v4, "null cursor from DownloadManager"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v0, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 732
    :cond_1
    :try_start_0
    const-string v0, "status"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    .line 733
    .local v8, "columnStatus":I
    const-string v0, "reason"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 734
    .local v7, "columnError":I
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 735
    invoke-interface {v9, v8}, Landroid/database/Cursor;->getInt(I)I

    move-result v12

    .line 736
    .local v12, "status":I
    invoke-interface {v9, v7}, Landroid/database/Cursor;->getInt(I)I

    move-result v10

    .line 737
    .local v10, "error":I
    const/4 v3, 0x0

    .line 739
    .local v3, "internalStatus":I
    sparse-switch v12, :sswitch_data_0

    .line 748
    :goto_1
    sget-object v0, Lcom/google/android/gm/provider/AttachmentManager;->ATTACHMENT_FROM:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v6

    .line 750
    .local v6, "attachmentFrom":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v0, 0x0

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    const/4 v0, 0x1

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/AttachmentManager;->onDownloadCompletedByDownloadManager(JILjava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 754
    .end local v3    # "internalStatus":I
    .end local v6    # "attachmentFrom":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v10    # "error":I
    .end local v12    # "status":I
    :cond_2
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 741
    .restart local v3    # "internalStatus":I
    .restart local v10    # "error":I
    .restart local v12    # "status":I
    :sswitch_0
    const/16 v3, 0xc8

    .line 742
    goto :goto_1

    .line 744
    :sswitch_1
    move v3, v10

    goto :goto_1

    .line 754
    .end local v3    # "internalStatus":I
    .end local v7    # "columnError":I
    .end local v8    # "columnStatus":I
    .end local v10    # "error":I
    .end local v12    # "status":I
    :catchall_0
    move-exception v0

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v0

    .line 739
    nop

    :sswitch_data_0
    .sparse-switch
        0x8 -> :sswitch_0
        0x10 -> :sswitch_1
    .end sparse-switch
.end method

.method public maybeStartNextAttachmentDownload()V
    .locals 19

    .prologue
    .line 849
    invoke-direct/range {p0 .. p0}, Lcom/google/android/gm/provider/AttachmentManager;->isLowSpace()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 851
    const-string v1, "Gmail"

    const-string v4, "Not enough free space to download attachments in background"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v1, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 930
    :goto_0
    return-void

    .line 857
    :cond_0
    const/16 v16, 0x0

    .line 860
    .local v16, "isPausedByDownloadManager":Z
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "attachments"

    const/4 v4, 0x1

    new-array v3, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "downloadId"

    aput-object v5, v3, v4

    const-string v4, "status = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    const/16 v8, 0xc0

    invoke-static {v8}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 864
    .local v10, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-interface {v10}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_5

    .line 865
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v13

    .line 866
    .local v13, "downloadingAttachments":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    :goto_1
    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 867
    const/4 v1, 0x0

    invoke-interface {v10, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v13, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 903
    .end local v13    # "downloadingAttachments":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    :catchall_0
    move-exception v1

    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    throw v1

    .line 869
    .restart local v13    # "downloadingAttachments":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    :cond_1
    :try_start_1
    new-instance v1, Landroid/app/DownloadManager$Query;

    invoke-direct {v1}, Landroid/app/DownloadManager$Query;-><init>()V

    const/4 v4, 0x2

    invoke-virtual {v1, v4}, Landroid/app/DownloadManager$Query;->setFilterByStatus(I)Landroid/app/DownloadManager$Query;

    move-result-object v17

    .line 870
    .local v17, "query":Landroid/app/DownloadManager$Query;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDownloadManager:Landroid/app/DownloadManager;

    move-object/from16 v0, v17

    invoke-virtual {v1, v0}, Landroid/app/DownloadManager;->query(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;

    move-result-object v11

    .line 871
    .local v11, "downloadCursor":Landroid/database/Cursor;
    if-nez v11, :cond_2

    .line 872
    const-string v1, "Gmail"

    const-string v4, "null cursor from DownloadManager"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v1, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 903
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 876
    :cond_2
    :try_start_2
    const-string v1, "_id"

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v9

    .line 877
    .local v9, "columnId":I
    :cond_3
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 878
    invoke-interface {v11, v9}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v14

    .line 879
    .local v14, "id":J
    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v13, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 882
    const-string v1, "Gmail"

    const-string v4, "ATTACHMENT: existing download in progress (dlid=%d), exiting"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v5, v7

    invoke-static {v1, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 888
    :try_start_3
    invoke-interface {v11}, Landroid/database/Cursor;->close()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 903
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto/16 :goto_0

    .line 888
    .end local v14    # "id":J
    :cond_4
    :try_start_4
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 891
    new-instance v1, Landroid/app/DownloadManager$Query;

    invoke-direct {v1}, Landroid/app/DownloadManager$Query;-><init>()V

    const/4 v4, 0x4

    invoke-virtual {v1, v4}, Landroid/app/DownloadManager$Query;->setFilterByStatus(I)Landroid/app/DownloadManager$Query;

    move-result-object v17

    .line 892
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDownloadManager:Landroid/app/DownloadManager;

    move-object/from16 v0, v17

    invoke-virtual {v1, v0}, Landroid/app/DownloadManager;->query(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-result-object v11

    .line 893
    if-eqz v11, :cond_5

    .line 896
    :try_start_5
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    move-result v1

    if-lez v1, :cond_7

    const/16 v16, 0x1

    .line 898
    :goto_2
    :try_start_6
    invoke-interface {v11}, Landroid/database/Cursor;->close()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 903
    .end local v9    # "columnId":I
    .end local v11    # "downloadCursor":Landroid/database/Cursor;
    .end local v13    # "downloadingAttachments":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    .end local v17    # "query":Landroid/app/DownloadManager$Query;
    :cond_5
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 906
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "attachments"

    const/4 v4, 0x2

    new-array v3, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "_id"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string v5, "downloadedRendition"

    aput-object v5, v3, v4

    const-string v4, "downloadId = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    const-string v8, "0"

    aput-object v8, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "priority DESC"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v12

    .line 910
    .local v12, "downloadablesCursor":Landroid/database/Cursor;
    :try_start_7
    invoke-interface {v12}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_a

    .line 911
    const/4 v1, 0x0

    invoke-interface {v12, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    .line 912
    .local v2, "attachmentId":J
    const/4 v1, 0x1

    invoke-interface {v12, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->valueOf(Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    move-result-object v18

    .line 914
    .local v18, "rendition":Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    sget-object v1, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->SIMPLE:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    move-object/from16 v0, v18

    if-eq v0, v1, :cond_8

    const/4 v6, 0x1

    .line 917
    .local v6, "fullVersion":Z
    :goto_3
    if-eqz v6, :cond_6

    if-nez v16, :cond_9

    .line 918
    :cond_6
    const-wide/16 v4, -0x1

    move-object/from16 v1, p0

    invoke-direct/range {v1 .. v6}, Lcom/google/android/gm/provider/AttachmentManager;->startAttachmentDownloadInDownloadManager(JJZ)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    .line 928
    .end local v2    # "attachmentId":J
    .end local v6    # "fullVersion":Z
    .end local v18    # "rendition":Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    :goto_4
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    goto/16 :goto_0

    .line 888
    .end local v12    # "downloadablesCursor":Landroid/database/Cursor;
    .restart local v11    # "downloadCursor":Landroid/database/Cursor;
    .restart local v13    # "downloadingAttachments":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    .restart local v17    # "query":Landroid/app/DownloadManager$Query;
    :catchall_1
    move-exception v1

    :try_start_8
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    throw v1

    .line 896
    .restart local v9    # "columnId":I
    :cond_7
    const/16 v16, 0x0

    goto :goto_2

    .line 898
    :catchall_2
    move-exception v1

    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    throw v1
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 914
    .end local v9    # "columnId":I
    .end local v11    # "downloadCursor":Landroid/database/Cursor;
    .end local v13    # "downloadingAttachments":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    .end local v17    # "query":Landroid/app/DownloadManager$Query;
    .restart local v2    # "attachmentId":J
    .restart local v12    # "downloadablesCursor":Landroid/database/Cursor;
    .restart local v18    # "rendition":Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    :cond_8
    const/4 v6, 0x0

    goto :goto_3

    .line 920
    .restart local v6    # "fullVersion":Z
    :cond_9
    :try_start_9
    const-string v1, "Gmail"

    const-string v4, "ATTACHMENT: unable to download full version id=%d b/c DL mgr has paused an existing DL."

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v5, v7

    invoke-static {v1, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_3

    goto :goto_4

    .line 928
    .end local v2    # "attachmentId":J
    .end local v6    # "fullVersion":Z
    .end local v18    # "rendition":Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    :catchall_3
    move-exception v1

    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    throw v1

    .line 924
    :cond_a
    :try_start_a
    const-string v1, "Gmail"

    const-string v4, "ATTACHMENT: unable to find attachment download record to work on, exiting"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v1, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_3

    goto :goto_4
.end method

.method onDownloadCompletedByDownloadManager(JILjava/lang/String;Ljava/lang/String;)V
    .locals 39
    .param p1, "downloadId"    # J
    .param p3, "status"    # I
    .param p4, "attachmentFrom"    # Ljava/lang/String;
    .param p5, "attachmentFromSender"    # Ljava/lang/String;

    .prologue
    .line 936
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "attachments, messages"

    sget-object v4, Lcom/google/android/gm/provider/AttachmentManager;->ATTACHMENT_PROJECTION:[Ljava/lang/String;

    const-string v5, "downloadId = ? AND attachments.messages_messageId = messages.messageId"

    const/4 v9, 0x1

    new-array v6, v9, [Ljava/lang/String;

    const/4 v9, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v12

    aput-object v12, v6, v9

    const/4 v7, 0x0

    const/4 v8, 0x0

    const-string v9, "saveToSd DESC"

    invoke-virtual/range {v2 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v37

    .line 940
    .local v37, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-interface/range {v37 .. v37}, Landroid/database/Cursor;->getCount()I

    move-result v9

    if-nez v9, :cond_0

    .line 941
    const-string v9, "Gmail"

    const-string v12, "No attachments found with downloadId %d"

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-static {v9, v12, v13}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 944
    :cond_0
    :goto_0
    invoke-interface/range {v37 .. v37}, Landroid/database/Cursor;->moveToNext()Z

    move-result v9

    if-eqz v9, :cond_4

    .line 945
    const/4 v9, 0x0

    move-object/from16 v0, v37

    invoke-interface {v0, v9}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    .line 946
    .local v10, "attachmentId":J
    const/4 v9, 0x1

    move-object/from16 v0, v37

    invoke-interface {v0, v9}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    .line 947
    .local v2, "conversationId":J
    const/4 v9, 0x2

    move-object/from16 v0, v37

    invoke-interface {v0, v9}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 948
    .local v4, "messageId":J
    const/4 v9, 0x3

    move-object/from16 v0, v37

    invoke-interface {v0, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 949
    .local v6, "partId":Ljava/lang/String;
    const/4 v9, 0x4

    move-object/from16 v0, v37

    invoke-interface {v0, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->valueOf(Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    move-result-object v7

    .line 951
    .local v7, "rendition":Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    const/4 v9, 0x5

    move-object/from16 v0, v37

    invoke-interface {v0, v9}, Landroid/database/Cursor;->getInt(I)I

    move-result v9

    if-eqz v9, :cond_1

    const/4 v8, 0x1

    .line 952
    .local v8, "saveToSd":Z
    :goto_1
    invoke-static/range {v2 .. v8}, Lcom/google/android/gm/provider/AttachmentManager;->requestDescription(JJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Ljava/lang/String;

    move-result-object v38

    .line 954
    .local v38, "requestDescription":Ljava/lang/String;
    const-string v9, "Gmail"

    const-string v12, "Download finished with status %d for download %d. %s"

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    invoke-static/range {p3 .. p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    const/4 v14, 0x1

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v15

    aput-object v15, v13, v14

    const/4 v14, 0x2

    aput-object v38, v13, v14

    invoke-static {v9, v12, v13}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 956
    invoke-interface/range {v37 .. v37}, Landroid/database/Cursor;->isFirst()Z

    move-result v9

    if-eqz v9, :cond_3

    .line 957
    const/4 v9, 0x6

    move-object/from16 v0, v37

    invoke-interface {v0, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v19

    .line 958
    .local v19, "fileName":Ljava/lang/String;
    const/4 v9, 0x7

    move-object/from16 v0, v37

    invoke-interface {v0, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v23

    .line 959
    .local v23, "mimeType":Ljava/lang/String;
    const/16 v9, 0x8

    move-object/from16 v0, v37

    invoke-interface {v0, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v24

    .line 961
    .local v24, "sender":Ljava/lang/String;
    invoke-static/range {p3 .. p3}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusSuccess(I)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 963
    const/16 v22, 0x0

    move-object/from16 v9, p0

    move-wide v12, v2

    move-wide v14, v4

    move-object/from16 v16, v6

    move-object/from16 v17, v7

    move/from16 v18, v8

    move-wide/from16 v20, p1

    move-object/from16 v25, p4

    move-object/from16 v26, p5

    invoke-direct/range {v9 .. v26}, Lcom/google/android/gm/provider/AttachmentManager;->copyAttachment(JJJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 973
    :goto_2
    move-object/from16 v0, p0

    invoke-direct {v0, v2, v3}, Lcom/google/android/gm/provider/AttachmentManager;->notifyChanged(J)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto/16 :goto_0

    .line 980
    .end local v2    # "conversationId":J
    .end local v4    # "messageId":J
    .end local v6    # "partId":Ljava/lang/String;
    .end local v7    # "rendition":Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .end local v8    # "saveToSd":Z
    .end local v10    # "attachmentId":J
    .end local v19    # "fileName":Ljava/lang/String;
    .end local v23    # "mimeType":Ljava/lang/String;
    .end local v24    # "sender":Ljava/lang/String;
    .end local v38    # "requestDescription":Ljava/lang/String;
    :catchall_0
    move-exception v9

    invoke-interface/range {v37 .. v37}, Landroid/database/Cursor;->close()V

    throw v9

    .line 951
    .restart local v2    # "conversationId":J
    .restart local v4    # "messageId":J
    .restart local v6    # "partId":Ljava/lang/String;
    .restart local v7    # "rendition":Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .restart local v10    # "attachmentId":J
    :cond_1
    const/4 v8, 0x0

    goto :goto_1

    .line 967
    .restart local v8    # "saveToSd":Z
    .restart local v19    # "fileName":Ljava/lang/String;
    .restart local v23    # "mimeType":Ljava/lang/String;
    .restart local v24    # "sender":Ljava/lang/String;
    .restart local v38    # "requestDescription":Ljava/lang/String;
    :cond_2
    :try_start_1
    const-string v9, "Gmail"

    const-string v12, "Download id %d failed with status %d"

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v15

    aput-object v15, v13, v14

    const/4 v14, 0x1

    invoke-static/range {p3 .. p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-static {v9, v12, v13}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 970
    const/16 v36, 0x0

    move-object/from16 v25, p0

    move-wide/from16 v26, v10

    move-wide/from16 v28, v2

    move-wide/from16 v30, v4

    move-object/from16 v32, v6

    move-object/from16 v33, v7

    move/from16 v34, v8

    move/from16 v35, p3

    invoke-direct/range {v25 .. v36}, Lcom/google/android/gm/provider/AttachmentManager;->onAttachmentDownloadFinished(JJJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZILjava/lang/String;)V

    goto :goto_2

    .line 975
    .end local v19    # "fileName":Ljava/lang/String;
    .end local v23    # "mimeType":Ljava/lang/String;
    .end local v24    # "sender":Ljava/lang/String;
    :cond_3
    const/4 v9, 0x0

    move-object/from16 v0, p0

    move/from16 v1, p3

    invoke-direct {v0, v10, v11, v1, v9}, Lcom/google/android/gm/provider/AttachmentManager;->updateAttachmentEntry(JILjava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_0

    .line 980
    .end local v2    # "conversationId":J
    .end local v4    # "messageId":J
    .end local v6    # "partId":Ljava/lang/String;
    .end local v7    # "rendition":Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .end local v8    # "saveToSd":Z
    .end local v10    # "attachmentId":J
    .end local v38    # "requestDescription":Ljava/lang/String;
    :cond_4
    invoke-interface/range {v37 .. v37}, Landroid/database/Cursor;->close()V

    .line 984
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/google/android/gm/provider/AttachmentManager;->mRestrictedMailEngine:Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;

    invoke-interface {v9}, Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;->enqueueAttachmentDownloadTask()V

    .line 985
    return-void
.end method

.method public openAttachment(JJLcom/google/android/gm/provider/Gmail$Attachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZLjava/lang/String;)Landroid/os/ParcelFileDescriptor;
    .locals 14
    .param p1, "conversationId"    # J
    .param p3, "messageId"    # J
    .param p5, "attachment"    # Lcom/google/android/gm/provider/Gmail$Attachment;
    .param p6, "rendition"    # Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .param p7, "saveToSd"    # Z
    .param p8, "mode"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    .line 661
    move-object/from16 v0, p5

    iget-object v5, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    move-wide v1, p1

    move-wide/from16 v3, p3

    move-object/from16 v6, p6

    move/from16 v7, p7

    invoke-static/range {v1 .. v7}, Lcom/google/android/gm/provider/AttachmentManager;->requestDescription(JJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Ljava/lang/String;

    move-result-object v11

    .line 663
    .local v11, "description":Ljava/lang/String;
    const-string v1, "Gmail"

    const-string v2, "AttachmentManager.openAttachment: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v11, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 665
    const/4 v10, 0x0

    .line 668
    .local v10, "cursor":Landroid/database/Cursor;
    :try_start_0
    move-object/from16 v0, p5

    iget-object v4, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    sget-object v7, Lcom/google/android/gm/provider/AttachmentManager;->ATTACHMENT_NAME_STATUS_PROJECTION:[Ljava/lang/String;

    move-object v1, p0

    move-wide/from16 v2, p3

    move-object/from16 v5, p6

    move/from16 v6, p7

    invoke-direct/range {v1 .. v7}, Lcom/google/android/gm/provider/AttachmentManager;->newAttachmentCursor(JLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 671
    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 672
    const/4 v1, 0x1

    invoke-interface {v10, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v13

    .line 673
    .local v13, "status":I
    invoke-static {v13}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusSuccess(I)Z

    move-result v1

    if-nez v1, :cond_1

    .line 674
    new-instance v1, Ljava/io/FileNotFoundException;

    const-string v2, "Download not complete or not successful."

    invoke-direct {v1, v2}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 694
    .end local v13    # "status":I
    :catchall_0
    move-exception v1

    if-eqz v10, :cond_0

    .line 695
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    :cond_0
    throw v1

    .line 677
    .restart local v13    # "status":I
    :cond_1
    const/4 v1, 0x0

    :try_start_1
    invoke-interface {v10, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/google/android/gm/provider/AttachmentManager;->getPathFromUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 681
    .local v12, "fileName":Ljava/lang/String;
    invoke-static {}, Landroid/os/Binder;->clearCallingIdentity()J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-wide v8

    .line 683
    .local v8, "binderToken":J
    :try_start_2
    const-string v1, "Gmail"

    const-string v2, "Opening attachment %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v12, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 684
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v12}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    const/high16 v2, 0x10000000

    invoke-static {v1, v2}, Landroid/os/ParcelFileDescriptor;->open(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v1

    .line 687
    :try_start_3
    invoke-static {v8, v9}, Landroid/os/Binder;->restoreCallingIdentity(J)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 694
    if-eqz v10, :cond_2

    .line 695
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    :cond_2
    return-object v1

    .line 687
    :catchall_1
    move-exception v1

    :try_start_4
    invoke-static {v8, v9}, Landroid/os/Binder;->restoreCallingIdentity(J)V

    throw v1

    .line 690
    .end local v8    # "binderToken":J
    .end local v12    # "fileName":Ljava/lang/String;
    .end local v13    # "status":I
    :cond_3
    const-string v1, "Gmail"

    const-string v2, "Attachment is not requested %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v11, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 691
    new-instance v1, Ljava/io/FileNotFoundException;

    const-string v2, "Attachment not requested."

    invoke-direct {v1, v2}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method

.method purgeOldAttachments()V
    .locals 3

    .prologue
    .line 1028
    const-string v0, "Gmail"

    const-string v1, "Purging old attachments."

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1030
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->isDbLockedByCurrentThread()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1033
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Db should not be locked"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1036
    :cond_0
    invoke-direct {p0}, Lcom/google/android/gm/provider/AttachmentManager;->purgeInvalidAttachments()V

    .line 1037
    invoke-direct {p0}, Lcom/google/android/gm/provider/AttachmentManager;->purgeInvalidDownloadingAttachments()V

    .line 1038
    return-void
.end method

.method public queryAndStartDownloadingAttachment(JJLcom/google/android/gm/provider/Gmail$Attachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 33
    .param p1, "conversationId"    # J
    .param p3, "messageId"    # J
    .param p5, "attachment"    # Lcom/google/android/gm/provider/Gmail$Attachment;
    .param p6, "rendition"    # Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .param p7, "saveToSd"    # Z
    .param p8, "projection"    # [Ljava/lang/String;

    .prologue
    .line 485
    const-string v2, "Gmail"

    const/4 v3, 0x3

    invoke-static {v2, v3}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 486
    move-object/from16 v0, p5

    iget-object v6, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    move-wide/from16 v2, p1

    move-wide/from16 v4, p3

    move-object/from16 v7, p6

    move/from16 v8, p7

    invoke-static/range {v2 .. v8}, Lcom/google/android/gm/provider/AttachmentManager;->requestDescription(JJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Ljava/lang/String;

    move-result-object v29

    .line 488
    .local v29, "requestDescription":Ljava/lang/String;
    const-string v2, "Gmail"

    const-string v3, "queryAndStartDownloadingAttachment for %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v29, v5, v6

    invoke-static {v2, v3, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 492
    .end local v29    # "requestDescription":Ljava/lang/String;
    :cond_0
    const/4 v2, 0x5

    new-array v4, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "_id"

    aput-object v3, v4, v2

    const/4 v2, 0x1

    const-string v3, "downloadId"

    aput-object v3, v4, v2

    const/4 v2, 0x2

    const-string v3, "status"

    aput-object v3, v4, v2

    const/4 v2, 0x3

    const-string v3, "filename"

    aput-object v3, v4, v2

    const/4 v2, 0x4

    const-string v3, "saveToSd"

    aput-object v3, v4, v2

    .line 495
    .local v4, "privateProjection":[Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "attachments"

    const-string v5, "messages_messageId = ? AND messages_partId = ? AND desiredRendition = ? "

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x1

    move-object/from16 v0, p5

    iget-object v8, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    aput-object v8, v6, v7

    const/4 v7, 0x2

    invoke-virtual/range {p6 .. p6}, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual/range {v2 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v27

    .line 500
    .local v27, "privateCursor":Landroid/database/Cursor;
    const/4 v2, 0x2

    new-array v0, v2, [Ljava/lang/Long;

    move-object/from16 v23, v0

    const/4 v2, 0x0

    const-wide/16 v5, -0x1

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v23, v2

    const/4 v2, 0x1

    const-wide/16 v5, -0x1

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v23, v2

    .line 501
    .local v23, "attachmentIds":[Ljava/lang/Long;
    const/4 v2, 0x2

    new-array v0, v2, [J

    move-object/from16 v24, v0

    fill-array-data v24, :array_0

    .line 502
    .local v24, "downloadIds":[J
    const/4 v2, 0x2

    new-array v0, v2, [I

    move-object/from16 v30, v0

    fill-array-data v30, :array_1

    .line 503
    .local v30, "statuses":[I
    const/4 v2, 0x2

    new-array v0, v2, [Ljava/lang/String;

    move-object/from16 v25, v0

    const/4 v2, 0x0

    const/4 v3, 0x0

    aput-object v3, v25, v2

    const/4 v2, 0x1

    const/4 v3, 0x0

    aput-object v3, v25, v2

    .line 505
    .local v25, "fileUris":[Ljava/lang/String;
    :goto_0
    :try_start_0
    invoke-interface/range {v27 .. v27}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 506
    const/4 v2, 0x4

    move-object/from16 v0, v27

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v32

    .line 508
    .local v32, "version":I
    const/4 v2, 0x0

    move-object/from16 v0, v27

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v23, v32

    .line 509
    const/4 v2, 0x1

    move-object/from16 v0, v27

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    aput-wide v2, v24, v32

    .line 510
    const/4 v2, 0x2

    move-object/from16 v0, v27

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    aput v2, v30, v32

    .line 511
    const/4 v2, 0x3

    move-object/from16 v0, v27

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v25, v32
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 514
    .end local v32    # "version":I
    :catchall_0
    move-exception v2

    invoke-interface/range {v27 .. v27}, Landroid/database/Cursor;->close()V

    throw v2

    :cond_1
    invoke-interface/range {v27 .. v27}, Landroid/database/Cursor;->close()V

    .line 518
    const/16 v26, 0x0

    .local v26, "i":I
    :goto_1
    const/4 v2, 0x2

    move/from16 v0, v26

    if-ge v0, v2, :cond_4

    .line 519
    aget v2, v30, v26

    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusSuccess(I)Z

    move-result v2

    if-eqz v2, :cond_2

    aget-object v2, v25, v26

    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentManager;->isDownloadStillPresent(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 520
    :cond_2
    const/4 v2, 0x0

    aput-object v2, v25, v26

    .line 518
    :cond_3
    add-int/lit8 v26, v26, 0x1

    goto :goto_1

    .line 524
    :cond_4
    if-eqz p7, :cond_6

    const/16 v32, 0x1

    .line 527
    .restart local v32    # "version":I
    :goto_2
    const/16 v26, 0x0

    :goto_3
    move/from16 v0, v26

    move/from16 v1, v32

    if-gt v0, v1, :cond_8

    .line 528
    aget-object v2, v23, v26

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    const-wide/16 v5, -0x1

    cmp-long v2, v2, v5

    if-nez v2, :cond_5

    .line 529
    const-wide/16 v12, -0x1

    if-eqz v26, :cond_7

    const/4 v14, 0x1

    :goto_4
    const/4 v15, 0x0

    const/16 v16, 0x0

    move-object/from16 v5, p0

    move-wide/from16 v6, p1

    move-wide/from16 v8, p3

    move-object/from16 v10, p5

    move-object/from16 v11, p6

    invoke-virtual/range {v5 .. v16}, Lcom/google/android/gm/provider/AttachmentManager;->recordAttachmentInDb(JJLcom/google/android/gm/provider/Gmail$Attachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;JZZI)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v23, v26

    .line 527
    :cond_5
    add-int/lit8 v26, v26, 0x1

    goto :goto_3

    .line 524
    .end local v32    # "version":I
    :cond_6
    const/16 v32, 0x0

    goto :goto_2

    .line 529
    .restart local v32    # "version":I
    :cond_7
    const/4 v14, 0x0

    goto :goto_4

    .line 534
    :cond_8
    const/4 v2, 0x0

    aget v2, v30, v2

    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusValid(I)Z

    move-result v2

    if-nez v2, :cond_b

    const/4 v2, 0x1

    aget v2, v30, v2

    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusValid(I)Z

    move-result v2

    if-nez v2, :cond_b

    .line 536
    const-string v2, "Gmail"

    const-string v3, "AttachmentManager.queryAndStartDownloadingAttachment() starting new download"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v2, v3, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 539
    const/4 v2, 0x0

    aget-object v2, v23, v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    const/4 v2, 0x1

    aget-object v2, v23, v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentManager;->mContext:Landroid/content/Context;

    move-object/from16 v0, p5

    invoke-static {v2, v0}, Lcom/google/android/gm/provider/AttachmentManager;->canDownloadAttachment(Landroid/content/Context;Lcom/google/android/gm/provider/Gmail$Attachment;)Z

    move-result v2

    if-nez v2, :cond_a

    const/4 v10, 0x1

    :goto_5
    move-object/from16 v5, p0

    invoke-direct/range {v5 .. v10}, Lcom/google/android/gm/provider/AttachmentManager;->startAttachmentDownloadInDownloadManager(JJZ)V

    .line 570
    :cond_9
    :goto_6
    invoke-direct/range {p0 .. p2}, Lcom/google/android/gm/provider/AttachmentManager;->notifyChanged(J)V

    .line 571
    move-object/from16 v0, p5

    iget-object v8, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    move-object/from16 v5, p0

    move-wide/from16 v6, p3

    move-object/from16 v9, p6

    move/from16 v10, p7

    move-object/from16 v11, p8

    invoke-direct/range {v5 .. v11}, Lcom/google/android/gm/provider/AttachmentManager;->newAttachmentCursor(JLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v28

    .line 573
    .local v28, "publicCursor":Landroid/database/Cursor;
    return-object v28

    .line 539
    .end local v28    # "publicCursor":Landroid/database/Cursor;
    :cond_a
    const/4 v10, 0x0

    goto :goto_5

    .line 541
    :cond_b
    const/4 v2, 0x0

    aget-object v2, v25, v2

    if-nez v2, :cond_c

    const/4 v2, 0x1

    aget-object v2, v25, v2

    if-eqz v2, :cond_d

    .line 543
    :cond_c
    const-string v2, "Gmail"

    const-string v3, "AttachmentManager.queryAndStartDownloadingAttachment() file exists either on cache or sd card, will copy if needed"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v2, v3, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 546
    aget-object v2, v25, v32

    if-nez v2, :cond_9

    .line 547
    aget-object v2, v23, v32

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    move-object/from16 v0, p5

    iget-object v12, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    move-object/from16 v0, p5

    iget-object v15, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    const-wide/16 v16, -0x1

    rsub-int/lit8 v2, v32, 0x1

    aget-object v18, v25, v2

    move-object/from16 v0, p5

    iget-object v0, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    const/16 v21, 0x0

    const/16 v22, 0x0

    move-object/from16 v5, p0

    move-wide/from16 v8, p1

    move-wide/from16 v10, p3

    move-object/from16 v13, p6

    move/from16 v14, p7

    invoke-direct/range {v5 .. v22}, Lcom/google/android/gm/provider/AttachmentManager;->copyAttachment(JJJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_6

    .line 554
    :cond_d
    const-string v2, "Gmail"

    const-string v3, "AttachmentManager.queryAndStartDownloadingAttachment() refetch attachment"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v2, v3, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 557
    const/16 v26, 0x0

    :goto_7
    move/from16 v0, v26

    move/from16 v1, v32

    if-gt v0, v1, :cond_e

    .line 558
    new-instance v31, Landroid/content/ContentValues;

    invoke-direct/range {v31 .. v31}, Landroid/content/ContentValues;-><init>()V

    .line 559
    .local v31, "values":Landroid/content/ContentValues;
    const-string v2, "filename"

    move-object/from16 v0, p5

    iget-object v3, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    move-object/from16 v0, v31

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 561
    const-string v2, "automatic"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    move-object/from16 v0, v31

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 562
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "attachments"

    const-string v5, "_id = ?"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aget-object v8, v23, v26

    invoke-virtual {v8}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    move-object/from16 v0, v31

    invoke-virtual {v2, v3, v0, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 557
    add-int/lit8 v26, v26, 0x1

    goto :goto_7

    .line 566
    .end local v31    # "values":Landroid/content/ContentValues;
    :cond_e
    const/4 v2, 0x0

    aget-object v2, v23, v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    const/4 v2, 0x1

    aget-object v2, v23, v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentManager;->mContext:Landroid/content/Context;

    move-object/from16 v0, p5

    invoke-static {v2, v0}, Lcom/google/android/gm/provider/AttachmentManager;->canDownloadAttachment(Landroid/content/Context;Lcom/google/android/gm/provider/Gmail$Attachment;)Z

    move-result v2

    if-nez v2, :cond_f

    const/4 v10, 0x1

    :goto_8
    move-object/from16 v5, p0

    invoke-direct/range {v5 .. v10}, Lcom/google/android/gm/provider/AttachmentManager;->startAttachmentDownloadInDownloadManager(JJZ)V

    goto/16 :goto_6

    :cond_f
    const/4 v10, 0x0

    goto :goto_8

    .line 501
    :array_0
    .array-data 8
        -0x1
        -0x1
    .end array-data

    .line 502
    :array_1
    .array-data 4
        -0x1
        -0x1
    .end array-data
.end method

.method public queryForConversation(J[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 8

    .prologue
    const/4 v5, 0x0

    .line 1322
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "attachments"

    const-string v3, "messages_conversation = ? AND desiredRendition = ?"

    const/4 v2, 0x2

    new-array v4, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v2

    const/4 v2, 0x1

    sget-object v6, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->BEST:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    invoke-virtual {v6}, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v2

    move-object v2, p3

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method recordAttachmentInDb(JJLcom/google/android/gm/provider/Gmail$Attachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;JZZI)J
    .locals 5
    .param p1, "conversationId"    # J
    .param p3, "messageId"    # J
    .param p5, "attachment"    # Lcom/google/android/gm/provider/Gmail$Attachment;
    .param p6, "rendition"    # Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .param p7, "downloadId"    # J
    .param p9, "saveToSd"    # Z
    .param p10, "automatic"    # Z
    .param p11, "priority"    # I

    .prologue
    .line 461
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 462
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "messages_conversation"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 463
    const-string v1, "messages_messageId"

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 464
    const-string v1, "messages_partId"

    iget-object v2, p5, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 465
    const-string v1, "originExtras"

    iget-object v2, p5, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 466
    const-string v1, "desiredRendition"

    invoke-virtual {p6}, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 467
    const-string v1, "downloadedRendition"

    invoke-virtual {p6}, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 468
    const-string v1, "downloadId"

    invoke-static {p7, p8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 469
    const-string v2, "automatic"

    if-eqz p10, :cond_0

    const/4 v1, 0x1

    :goto_0
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 470
    const-string v1, "priority"

    invoke-static/range {p11 .. p11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 471
    const-string v2, "saveToSd"

    if-eqz p9, :cond_1

    const/4 v1, 0x1

    :goto_1
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 472
    const-string v1, "filename"

    iget-object v2, p5, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 473
    const-string v1, "status"

    const/16 v2, 0xbe

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 474
    const-string v1, "mimeType"

    iget-object v2, p5, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 478
    iget-object v1, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "attachments"

    const/4 v3, 0x0

    const/4 v4, 0x4

    invoke-virtual {v1, v2, v3, v0, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v1

    return-wide v1

    .line 469
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 471
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public resetAttachmentRequest(JJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)I
    .locals 11
    .param p1, "conversationId"    # J
    .param p3, "messageId"    # J
    .param p5, "partId"    # Ljava/lang/String;
    .param p6, "rendition"    # Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .param p7, "saveToSd"    # Z

    .prologue
    .line 817
    const-string v0, "Gmail"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 818
    invoke-static/range {p1 .. p7}, Lcom/google/android/gm/provider/AttachmentManager;->requestDescription(JJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Ljava/lang/String;

    move-result-object v10

    .line 820
    .local v10, "requestDescription":Ljava/lang/String;
    const-string v0, "Gmail"

    const-string v1, "resetAttachmentRequest: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v10, v2, v6

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 823
    .end local v10    # "requestDescription":Ljava/lang/String;
    :cond_0
    const/4 v0, 0x3

    new-array v6, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "_id"

    aput-object v1, v6, v0

    const/4 v0, 0x1

    const-string v1, "downloadId"

    aput-object v1, v6, v0

    const/4 v0, 0x2

    const-string v1, "filename"

    aput-object v1, v6, v0

    move-object v0, p0

    move-wide v1, p3

    move-object/from16 v3, p5

    move-object/from16 v4, p6

    move/from16 v5, p7

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gm/provider/AttachmentManager;->newAttachmentCursor(JLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 826
    .local v7, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 827
    const/4 v0, 0x0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    .line 828
    .local v3, "attachmentId":J
    const/4 v0, 0x1

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    .line 829
    .local v8, "downloadId":J
    const/4 v0, 0x2

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 832
    .local v5, "fileName":Ljava/lang/String;
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDownloadManager:Landroid/app/DownloadManager;

    if-eqz v0, :cond_1

    invoke-static {v8, v9}, Lcom/google/android/gm/provider/AttachmentManager;->isDownloadIdValid(J)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 833
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDownloadManager:Landroid/app/DownloadManager;

    const/4 v1, 0x1

    new-array v1, v1, [J

    const/4 v2, 0x0

    aput-wide v8, v1, v2

    invoke-virtual {v0, v1}, Landroid/app/DownloadManager;->remove([J)I

    :cond_1
    move-object v0, p0

    move-wide v1, p1

    .line 835
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/AttachmentManager;->resetAttachment(JJLjava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 836
    const/4 v0, 0x1

    .line 839
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 841
    .end local v3    # "attachmentId":J
    .end local v5    # "fileName":Ljava/lang/String;
    .end local v8    # "downloadId":J
    :goto_0
    return v0

    .line 839
    :cond_2
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 841
    const/4 v0, 0x0

    goto :goto_0

    .line 839
    :catchall_0
    move-exception v0

    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method public updateMessageId(JJ)V
    .locals 5
    .param p1, "prevMessageId"    # J
    .param p3, "newMessageId"    # J

    .prologue
    .line 765
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 766
    .local v1, "newAttachmentsValues":Landroid/content/ContentValues;
    const-string v2, "messages_messageId"

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 767
    const/4 v2, 0x1

    new-array v0, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v0, v2

    .line 768
    .local v0, "bindArgs":[Ljava/lang/String;
    iget-object v2, p0, Lcom/google/android/gm/provider/AttachmentManager;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "attachments"

    const-string v4, "messages_messageId = ?"

    invoke-virtual {v2, v3, v1, v4, v0}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 769
    return-void
.end method
