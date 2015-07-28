.class Lcom/google/android/gm/provider/MailEngine$NormalHttpRequestRunner;
.super Ljava/lang/Object;
.source "MailEngine.java"

# interfaces
.implements Lcom/google/android/gm/provider/MailEngine$HttpRequestRunner;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/MailEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "NormalHttpRequestRunner"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6580
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 6581
    return-void
.end method


# virtual methods
.method public runHttpRequest(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    .locals 1
    .param p1, "client"    # Lorg/apache/http/client/HttpClient;
    .param p2, "request"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .param p3, "httpContext"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 6585
    invoke-interface {p1, p2, p3}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method
