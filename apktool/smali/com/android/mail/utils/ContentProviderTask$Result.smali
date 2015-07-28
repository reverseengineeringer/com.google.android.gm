.class public Lcom/android/mail/utils/ContentProviderTask$Result;
.super Ljava/lang/Object;
.source "ContentProviderTask.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/utils/ContentProviderTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Result"
.end annotation


# instance fields
.field exception:Ljava/lang/Exception;

.field results:[Landroid/content/ContentProviderResult;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 54
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/utils/ContentProviderTask$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/utils/ContentProviderTask$1;

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/android/mail/utils/ContentProviderTask$Result;-><init>()V

    return-void
.end method

.method static synthetic access$100(Lcom/android/mail/utils/ContentProviderTask$Result;[Landroid/content/ContentProviderResult;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/utils/ContentProviderTask$Result;
    .param p1, "x1"    # [Landroid/content/ContentProviderResult;

    .prologue
    .line 50
    invoke-direct {p0, p1}, Lcom/android/mail/utils/ContentProviderTask$Result;->setSuccess([Landroid/content/ContentProviderResult;)V

    return-void
.end method

.method static synthetic access$200(Lcom/android/mail/utils/ContentProviderTask$Result;Ljava/lang/Exception;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/utils/ContentProviderTask$Result;
    .param p1, "x1"    # Ljava/lang/Exception;

    .prologue
    .line 50
    invoke-direct {p0, p1}, Lcom/android/mail/utils/ContentProviderTask$Result;->setFailure(Ljava/lang/Exception;)V

    return-void
.end method

.method private setFailure(Ljava/lang/Exception;)V
    .locals 1
    .param p1, "failure"    # Ljava/lang/Exception;

    .prologue
    .line 62
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/utils/ContentProviderTask$Result;->results:[Landroid/content/ContentProviderResult;

    .line 63
    iput-object p1, p0, Lcom/android/mail/utils/ContentProviderTask$Result;->exception:Ljava/lang/Exception;

    .line 64
    return-void
.end method

.method private setSuccess([Landroid/content/ContentProviderResult;)V
    .locals 1
    .param p1, "success"    # [Landroid/content/ContentProviderResult;

    .prologue
    .line 57
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/utils/ContentProviderTask$Result;->exception:Ljava/lang/Exception;

    .line 58
    iput-object p1, p0, Lcom/android/mail/utils/ContentProviderTask$Result;->results:[Landroid/content/ContentProviderResult;

    .line 59
    return-void
.end method
