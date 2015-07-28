.class Lcom/google/android/common/http/GoogleHttpClient$WrappedLayeredSocketFactory;
.super Lcom/google/android/common/http/GoogleHttpClient$WrappedSocketFactory;
.source "GoogleHttpClient.java"

# interfaces
.implements Lorg/apache/http/conn/scheme/LayeredSocketFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/common/http/GoogleHttpClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "WrappedLayeredSocketFactory"
.end annotation


# instance fields
.field private mDelegate:Lorg/apache/http/conn/scheme/LayeredSocketFactory;

.field final synthetic this$0:Lcom/google/android/common/http/GoogleHttpClient;


# direct methods
.method private constructor <init>(Lcom/google/android/common/http/GoogleHttpClient;Lorg/apache/http/conn/scheme/LayeredSocketFactory;)V
    .locals 1
    .param p2, "sf"    # Lorg/apache/http/conn/scheme/LayeredSocketFactory;

    .prologue
    .line 155
    iput-object p1, p0, Lcom/google/android/common/http/GoogleHttpClient$WrappedLayeredSocketFactory;->this$0:Lcom/google/android/common/http/GoogleHttpClient;

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/common/http/GoogleHttpClient$WrappedSocketFactory;-><init>(Lcom/google/android/common/http/GoogleHttpClient;Lorg/apache/http/conn/scheme/SocketFactory;Lcom/google/android/common/http/GoogleHttpClient$1;)V

    iput-object p2, p0, Lcom/google/android/common/http/GoogleHttpClient$WrappedLayeredSocketFactory;->mDelegate:Lorg/apache/http/conn/scheme/LayeredSocketFactory;

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/common/http/GoogleHttpClient;Lorg/apache/http/conn/scheme/LayeredSocketFactory;Lcom/google/android/common/http/GoogleHttpClient$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/google/android/common/http/GoogleHttpClient;
    .param p2, "x1"    # Lorg/apache/http/conn/scheme/LayeredSocketFactory;
    .param p3, "x2"    # Lcom/google/android/common/http/GoogleHttpClient$1;

    .prologue
    .line 152
    invoke-direct {p0, p1, p2}, Lcom/google/android/common/http/GoogleHttpClient$WrappedLayeredSocketFactory;-><init>(Lcom/google/android/common/http/GoogleHttpClient;Lorg/apache/http/conn/scheme/LayeredSocketFactory;)V

    return-void
.end method


# virtual methods
.method public final createSocket(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    .locals 1
    .param p1, "s"    # Ljava/net/Socket;
    .param p2, "host"    # Ljava/lang/String;
    .param p3, "port"    # I
    .param p4, "autoClose"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 159
    iget-object v0, p0, Lcom/google/android/common/http/GoogleHttpClient$WrappedLayeredSocketFactory;->mDelegate:Lorg/apache/http/conn/scheme/LayeredSocketFactory;

    invoke-interface {v0, p1, p2, p3, p4}, Lorg/apache/http/conn/scheme/LayeredSocketFactory;->createSocket(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;

    move-result-object v0

    return-object v0
.end method
