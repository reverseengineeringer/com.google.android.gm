.class abstract Lcom/google/android/gm/provider/MailSync$AbstractOperationSink;
.super Ljava/lang/Object;
.source "MailSync.java"

# interfaces
.implements Lcom/google/android/gm/provider/MailStore$OperationSink;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/MailSync;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "AbstractOperationSink"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/provider/MailSync;


# direct methods
.method private constructor <init>(Lcom/google/android/gm/provider/MailSync;)V
    .locals 0

    .prologue
    .line 3252
    iput-object p1, p0, Lcom/google/android/gm/provider/MailSync$AbstractOperationSink;->this$0:Lcom/google/android/gm/provider/MailSync;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gm/provider/MailSync;Lcom/google/android/gm/provider/MailSync$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/google/android/gm/provider/MailSync;
    .param p2, "x1"    # Lcom/google/android/gm/provider/MailSync$1;

    .prologue
    .line 3252
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailSync$AbstractOperationSink;-><init>(Lcom/google/android/gm/provider/MailSync;)V

    return-void
.end method


# virtual methods
.method public abstract getNumOperations()I
.end method
