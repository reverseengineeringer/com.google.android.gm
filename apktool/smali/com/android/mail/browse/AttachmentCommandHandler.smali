.class Lcom/android/mail/browse/AttachmentCommandHandler;
.super Landroid/content/AsyncQueryHandler;
.source "AttachmentCommandHandler.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 26
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/content/AsyncQueryHandler;-><init>(Landroid/content/ContentResolver;)V

    .line 27
    return-void
.end method


# virtual methods
.method public sendCommand(Landroid/net/Uri;Landroid/content/ContentValues;)V
    .locals 7
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "params"    # Landroid/content/ContentValues;

    .prologue
    const/4 v2, 0x0

    .line 34
    const/4 v1, 0x0

    move-object v0, p0

    move-object v3, p1

    move-object v4, p2

    move-object v5, v2

    move-object v6, v2

    invoke-virtual/range {v0 .. v6}, Lcom/android/mail/browse/AttachmentCommandHandler;->startUpdate(ILjava/lang/Object;Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)V

    .line 35
    return-void
.end method
