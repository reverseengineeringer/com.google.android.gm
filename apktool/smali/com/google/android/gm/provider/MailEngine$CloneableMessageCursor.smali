.class Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;
.super Lcom/google/android/gm/provider/MailEngine$NetworkCursor;
.source "MailEngine.java"

# interfaces
.implements Ljava/lang/Cloneable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/MailEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CloneableMessageCursor"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/provider/MailEngine;


# direct methods
.method public constructor <init>(Lcom/google/android/gm/provider/MailEngine;Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Landroid/database/sqlite/SQLiteQuery;Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;)V
    .locals 0
    .param p2, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p3, "driver"    # Landroid/database/sqlite/SQLiteCursorDriver;
    .param p4, "editTable"    # Ljava/lang/String;
    .param p5, "query"    # Landroid/database/sqlite/SQLiteQuery;
    .param p6, "logic"    # Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

    .prologue
    .line 5524
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->this$0:Lcom/google/android/gm/provider/MailEngine;

    .line 5525
    invoke-direct/range {p0 .. p6}, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;-><init>(Lcom/google/android/gm/provider/MailEngine;Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Landroid/database/sqlite/SQLiteQuery;Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;)V

    .line 5526
    return-void
.end method


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 9

    .prologue
    .line 5531
    new-instance v1, Lcom/android/mail/utils/MatrixCursorWithExtra;

    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->getColumnNames()[Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->getCount()I

    move-result v6

    new-instance v7, Landroid/os/Bundle;

    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->getExtras()Landroid/os/Bundle;

    move-result-object v8

    invoke-direct {v7, v8}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    invoke-direct {v1, v5, v6, v7}, Lcom/android/mail/utils/MatrixCursorWithExtra;-><init>([Ljava/lang/String;ILandroid/os/Bundle;)V

    .line 5534
    .local v1, "cloned":Landroid/database/MatrixCursor;
    invoke-super {p0}, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->getColumnCount()I

    move-result v3

    .line 5535
    .local v3, "numColumns":I
    const-string v5, "body"

    invoke-virtual {p0, v5}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    .line 5536
    .local v0, "bodyIndex":I
    const/4 v5, -0x1

    invoke-virtual {p0, v5}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->moveToPosition(I)Z

    .line 5537
    :goto_0
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->moveToNext()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 5538
    new-array v4, v3, [Ljava/lang/Object;

    .line 5539
    .local v4, "row":[Ljava/lang/Object;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    if-ge v2, v3, :cond_1

    .line 5542
    if-ne v2, v0, :cond_0

    .line 5543
    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->getBlob(I)[B

    move-result-object v5

    aput-object v5, v4, v2

    .line 5539
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 5548
    :cond_0
    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->getType(I)I

    move-result v5

    packed-switch v5, :pswitch_data_0

    .line 5563
    const/4 v5, 0x0

    aput-object v5, v4, v2

    goto :goto_2

    .line 5550
    :pswitch_0
    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->getBlob(I)[B

    move-result-object v5

    aput-object v5, v4, v2

    goto :goto_2

    .line 5553
    :pswitch_1
    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->getDouble(I)D

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v5

    aput-object v5, v4, v2

    goto :goto_2

    .line 5556
    :pswitch_2
    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->getLong(I)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v4, v2

    goto :goto_2

    .line 5559
    :pswitch_3
    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v2

    goto :goto_2

    .line 5566
    :cond_1
    invoke-virtual {v1, v4}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_0

    .line 5569
    .end local v2    # "i":I
    .end local v4    # "row":[Ljava/lang/Object;
    :cond_2
    return-object v1

    .line 5548
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_3
        :pswitch_0
    .end packed-switch
.end method
