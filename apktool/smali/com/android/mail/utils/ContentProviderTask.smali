.class public Lcom/android/mail/utils/ContentProviderTask;
.super Landroid/os/AsyncTask;
.source "ContentProviderTask.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/utils/ContentProviderTask$1;,
        Lcom/android/mail/utils/ContentProviderTask$UpdateTask;,
        Lcom/android/mail/utils/ContentProviderTask$Result;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Lcom/android/mail/utils/ContentProviderTask$Result;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mAuthority:Ljava/lang/String;

.field private mOps:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/content/ContentProviderOperation;",
            ">;"
        }
    .end annotation
.end field

.field private mResolver:Landroid/content/ContentResolver;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 48
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/utils/ContentProviderTask;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 113
    return-void
.end method


# virtual methods
.method protected varargs doInBackground([Ljava/lang/Void;)Lcom/android/mail/utils/ContentProviderTask$Result;
    .locals 5
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 69
    new-instance v1, Lcom/android/mail/utils/ContentProviderTask$Result;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Lcom/android/mail/utils/ContentProviderTask$Result;-><init>(Lcom/android/mail/utils/ContentProviderTask$1;)V

    .line 71
    .local v1, "result":Lcom/android/mail/utils/ContentProviderTask$Result;
    :try_start_0
    iget-object v2, p0, Lcom/android/mail/utils/ContentProviderTask;->mResolver:Landroid/content/ContentResolver;

    iget-object v3, p0, Lcom/android/mail/utils/ContentProviderTask;->mAuthority:Ljava/lang/String;

    iget-object v4, p0, Lcom/android/mail/utils/ContentProviderTask;->mOps:Ljava/util/ArrayList;

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentResolver;->applyBatch(Ljava/lang/String;Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;

    move-result-object v2

    # invokes: Lcom/android/mail/utils/ContentProviderTask$Result;->setSuccess([Landroid/content/ContentProviderResult;)V
    invoke-static {v1, v2}, Lcom/android/mail/utils/ContentProviderTask$Result;->access$100(Lcom/android/mail/utils/ContentProviderTask$Result;[Landroid/content/ContentProviderResult;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 76
    :goto_0
    return-object v1

    .line 72
    :catch_0
    move-exception v0

    .line 73
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/android/mail/utils/ContentProviderTask;->LOG_TAG:Ljava/lang/String;

    const-string v3, "exception executing ContentProviderOperationsTask"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v0, v3, v4}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 74
    # invokes: Lcom/android/mail/utils/ContentProviderTask$Result;->setFailure(Ljava/lang/Exception;)V
    invoke-static {v1, v0}, Lcom/android/mail/utils/ContentProviderTask$Result;->access$200(Lcom/android/mail/utils/ContentProviderTask$Result;Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 42
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/utils/ContentProviderTask;->doInBackground([Ljava/lang/Void;)Lcom/android/mail/utils/ContentProviderTask$Result;

    move-result-object v0

    return-object v0
.end method

.method public run(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 4
    .param p1, "resolver"    # Landroid/content/ContentResolver;
    .param p2, "authority"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/ContentResolver;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/content/ContentProviderOperation;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 81
    .local p3, "ops":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/content/ContentProviderOperation;>;"
    iput-object p1, p0, Lcom/android/mail/utils/ContentProviderTask;->mResolver:Landroid/content/ContentResolver;

    .line 82
    iput-object p2, p0, Lcom/android/mail/utils/ContentProviderTask;->mAuthority:Ljava/lang/String;

    .line 83
    iput-object p3, p0, Lcom/android/mail/utils/ContentProviderTask;->mOps:Ljava/util/ArrayList;

    .line 84
    sget-object v1, Lcom/android/mail/utils/ContentProviderTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/Void;

    const/4 v3, 0x0

    const/4 v0, 0x0

    check-cast v0, Ljava/lang/Void;

    aput-object v0, v2, v3

    invoke-virtual {p0, v1, v2}, Lcom/android/mail/utils/ContentProviderTask;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 85
    return-void
.end method
