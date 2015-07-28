.class public final Lcom/google/android/gm/contentprovider/GmailAccess;
.super Ljava/lang/Object;
.source "GmailAccess.java"


# static fields
.field public static final LABEL_PROJECTION:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 73
    const/16 v0, 0x8

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "labelUri"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "canonicalName"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "name"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "numConversations"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "numUnreadConversations"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "text_color"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "background_color"

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/gm/contentprovider/GmailAccess;->LABEL_PROJECTION:[Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getLabelsUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 182
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.google.android.gm/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/labels"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method
