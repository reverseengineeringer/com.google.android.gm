.class public Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;
.super Ljava/lang/Object;
.source "UIAttachment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/uiprovider/UIAttachment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UriParser"
.end annotation


# instance fields
.field public final mAccount:Ljava/lang/String;

.field public final mContentTypeQueryParameters:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public final mConversationId:J

.field public final mLocalMessageId:J

.field public final mMessageId:J

.field public final mPartId:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;JJJLjava/lang/String;Ljava/util/List;)V
    .locals 0
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "conversationId"    # J
    .param p4, "messageId"    # J
    .param p6, "localMessageId"    # J
    .param p8, "partId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "JJJ",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 84
    .local p9, "contentTypeQueryParameters":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 85
    iput-object p1, p0, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mAccount:Ljava/lang/String;

    .line 86
    iput-wide p2, p0, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mConversationId:J

    .line 87
    iput-wide p4, p0, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mMessageId:J

    .line 88
    iput-wide p6, p0, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mLocalMessageId:J

    .line 89
    iput-object p8, p0, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mPartId:Ljava/lang/String;

    .line 90
    iput-object p9, p0, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mContentTypeQueryParameters:Ljava/util/List;

    .line 91
    return-void
.end method

.method public static parse(Landroid/net/Uri;)Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;
    .locals 12
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 61
    invoke-virtual {p0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v10

    .line 62
    .local v10, "partSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v0, 0x0

    invoke-interface {v10, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 63
    .local v1, "account":Ljava/lang/String;
    const-string v0, "contentType"

    invoke-virtual {p0, v0}, Landroid/net/Uri;->getQueryParameters(Ljava/lang/String;)Ljava/util/List;

    move-result-object v9

    .line 66
    .local v9, "contentTypeQueryParameters":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v0, 0x2

    invoke-interface {v10, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    .line 67
    .local v2, "conversationId":J
    const/4 v0, 0x3

    invoke-interface {v10, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v6

    .line 70
    .local v6, "localMessageId":J
    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v0

    const/4 v11, 0x5

    if-lt v0, v11, :cond_0

    .line 71
    const/4 v0, 0x4

    invoke-interface {v10, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 76
    .local v8, "partId":Ljava/lang/String;
    :goto_0
    const-string v0, "serverMessageId"

    invoke-virtual {p0, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 79
    .local v4, "messageId":J
    new-instance v0, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;

    invoke-direct/range {v0 .. v9}, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;-><init>(Ljava/lang/String;JJJLjava/lang/String;Ljava/util/List;)V

    return-object v0

    .line 73
    .end local v4    # "messageId":J
    .end local v8    # "partId":Ljava/lang/String;
    :cond_0
    const/4 v8, 0x0

    .restart local v8    # "partId":Ljava/lang/String;
    goto :goto_0
.end method
